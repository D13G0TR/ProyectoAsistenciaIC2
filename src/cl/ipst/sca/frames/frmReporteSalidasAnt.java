package cl.ipst.sca.frames;

import cl.ipst.sca.controllers.MarcadorController;
import cl.ipst.sca.model.Marcacion;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rober
 */
public class frmReporteSalidasAnt extends javax.swing.JInternalFrame {

    MarcadorController marcadorController = new MarcadorController();
    Marcacion mAux = new Marcacion();

    public frmReporteSalidasAnt() {
        initComponents();
    }

    /**
     * Carga los datos de salidas anticipadas de trabajadores y los muestra en
     * la tabla.
     *
     * Este método obtiene una lista de marcaciones de salidas anticipadas a
     * través del controlador de marcaciones y llena el modelo de la tabla con
     * la información relevante. Se calcula el tiempo anticipado respecto a una
     * hora de salida establecida (17:30).
     */
    private void cargarDatos() {
        LocalTime horaSalida = LocalTime.of(17, 30); // Hora de salida estándar
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false; // La tabla no es editable
            }
        };

        // Definición de las columnas de la tabla
        modelo.addColumn("RUN");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora Salida");
        modelo.addColumn("Tiempo Anticipado");

        // Obtiene la lista de marcaciones de salidas anticipadas
        List<Marcacion> listaBase = marcadorController.generarReporteSalidasAnticipadas();
        Object[] datos = new Object[6];

        // Itera sobre la lista de marcaciones
        for (int i = 0; i < listaBase.size(); i++) {
            mAux = listaBase.get(i);

            // Llena el array de datos con la información de la marcación
            datos[0] = mAux.getTrabMarca().getRutTra() + "-" + mAux.getTrabMarca().getDvTra();
            datos[1] = mAux.getTrabMarca().getNombresTra();
            datos[2] = mAux.getTrabMarca().getApellidosTra();

            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            datos[3] = formatoFecha.format(mAux.getFecha());

            datos[4] = mAux.getHora();

            // Calcula el tiempo anticipado respecto a la hora de salida estándar
            Duration anticipado = Duration.between(mAux.getHora(), horaSalida);

            // Obtener horas, minutos y segundos de anticipación
            long horasAnt = anticipado.toHours();
            long minAnt = anticipado.toMinutesPart();
            long segAnt = anticipado.toSecondsPart();

            datos[5] = horasAnt + ":" + minAnt + ":" + segAnt;

            // Agrega la fila de datos al modelo de la tabla
            modelo.addRow(datos);
        }

        // Establece el modelo a la tabla para mostrar los datos
        jtListaAtrasos.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        lblTituloRegistrar = new javax.swing.JLabel();
        btnListar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListaAtrasos = new javax.swing.JTable();
        btnExportar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        lblTituloRegistrar.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTituloRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloRegistrar.setText("Reporte de Salidas Anticipadas");

        btnListar.setText("Cargar Datos");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        jtListaAtrasos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "RUN", "Nombres", "Apellidos", "Fecha", "Hora Salida", "Tiempo Anticipado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListaAtrasos.setShowGrid(true);
        jScrollPane2.setViewportView(jtListaAtrasos);

        btnExportar.setText("Exportar a PDF");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloRegistrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnListar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExportar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTituloRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListar)
                    .addComponent(btnExportar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Maneja el evento de acción del botón "Listar".
     *
     * Este método se ejecuta cuando el usuario hace clic en el botón para
     * listar los datos de salidas anticipadas de los trabajadores. Llama al
     * método {@link #cargarDatos()} para cargar y mostrar la información en la
     * tabla.
     *
     * @param evt El evento de acción que contiene la información del evento
     */
    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        cargarDatos();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnListar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtListaAtrasos;
    private javax.swing.JLabel lblTituloRegistrar;
    // End of variables declaration//GEN-END:variables
}
