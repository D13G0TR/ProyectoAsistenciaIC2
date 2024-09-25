package cl.ipst.sca.frames;

import cl.ipst.sca.controllers.MarcadorController;
import cl.ipst.sca.model.Marcacion;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que representa la interfaz de usuario para reportes de atrasos. Esta
 * clase extiende de JInternalFrame y contiene los componentes y métodos
 * necesarios para mostrar un reporte de trabajadores que han llegado tarde.
 *
 * @author rober
 */
public class frmReporteAtrasos extends javax.swing.JInternalFrame {

    MarcadorController marcadorController = new MarcadorController();
    Marcacion mAux = new Marcacion();

    /**
     * Constructor de la clase frmReporteAtrasos. Inicializa los componentes de
     * la interfaz.
     */
    public frmReporteAtrasos() {
        initComponents();
    }

    /**
     * Carga los datos de atrasos en la tabla de reportes. Este método obtiene
     * la lista de marcaciones de los trabajadores desde el controlador y la
     * muestra en un modelo de tabla. Los atrasos se calculan comparando la hora
     * de ingreso establecida (09:30) con la hora de entrada de cada trabajador.
     *
     * El método realiza las siguientes acciones: 1. Define la hora de ingreso
     * (09:30). 2. Crea un modelo de tabla no editable para mostrar los datos.
     * 3. Obtiene una lista de marcaciones de atrasos mediante el método
     * generarReportesAtrasos(). 4. Itera sobre la lista de marcaciones, calcula
     * el tiempo de atraso y llena el modelo de tabla con la información
     * correspondiente (RUN, nombres, apellidos, fecha, hora de ingreso, tiempo
     * de atraso). 5. Establece el modelo en el componente de tabla
     * (jtListaAtrasos).
     */
    private void cargarDatos() {
        LocalTime horaIngreso = LocalTime.of(9, 30);
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        modelo.addColumn("RUN");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora Ingreso");
        modelo.addColumn("Tiempo de Atraso");

        List<Marcacion> listaBase = marcadorController.generarReportesAtrasos();
        Object[] datos = new Object[6];

        for (int i = 0; i < listaBase.size(); i++) {

            mAux = listaBase.get(i);

            datos[0] = mAux.getTrabMarca().getRutTra() + "-" + mAux.getTrabMarca().getDvTra();
            datos[1] = mAux.getTrabMarca().getNombresTra();
            datos[2] = mAux.getTrabMarca().getApellidosTra();

            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            datos[3] = formatoFecha.format(mAux.getFecha());

            datos[4] = mAux.getHora();

            Duration atraso = Duration.between(horaIngreso, mAux.getHora());

            // Obtener horas y minutos de atraso
            long horasAt = atraso.toHours();
            long minAt = atraso.toMinutesPart();
            long segAt = atraso.toSecondsPart();

            datos[5] = horasAt + ":" + minAt + ":" + segAt;

            modelo.addRow(datos);

            jtListaAtrasos.setModel(modelo);
        }
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
        lblTituloRegistrar.setText("Reporte de Atrasos");

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
                "RUN", "Nombres", "Apellidos", "Fecha", "Hora Ingreso", "Tiempo de Atraso"
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
     * Método que se ejecuta al hacer clic en el botón "Listar". Este método
     * invoca el método cargarDatos() para cargar y mostrar en la tabla los
     * registros de atrasos de los trabajadores.
     *
     * @param evt El evento de acción que desencadena la ejecución de este
     * método.
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
