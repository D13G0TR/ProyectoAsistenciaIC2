package Modelos;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GeneradorPDF {

    public static void generarReporteAtrasos(Connection connection) {
        generarPDF(connection, "Reporte de Ingresos Atrasados", 
                   "SELECT tr.RUT, tr.NOMBRES, tr.APELLIDOS, tn.INGRESO, tn.SALIDA " +
                   "FROM TRABAJADORES tr " +
                   "JOIN TURNOS tn ON tr.ID = tn.ID " +
                   "WHERE tn.INGRESO > '09:30:00'");
    }

    public static void generarReporteAnticipos(Connection connection) {
        generarPDF(connection, "Reporte de Salidas Anticipadas", 
                   "SELECT tr.RUT, tr.NOMBRES, tr.APELLIDOS, tn.INGRESO, tn.SALIDA " +
                   "FROM TRABAJADORES tr " +
                   "JOIN TURNOS tn ON tr.ID = tn.ID " +
                   "WHERE tn.SALIDA < '17:30:00'");
    }

    private static void generarPDF(Connection connection, String titulo, String query) {
        Document document = new Document(PageSize.A4);
        String filePath = titulo.replaceAll(" ", "_") + ".pdf";
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Título del documento
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, Font.BOLD);
            Paragraph title = new Paragraph(titulo, titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" ")); // Agregar un espacio

            // Crear tabla con encabezados
            PdfPTable table = new PdfPTable(5); // Ajusta el número de columnas a 5
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            // Encabezados de tabla
            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            String[] headers = {"RUT", "Nombres", "Apellidos", "Hora de Ingreso", "Hora de Salida"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header, headFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            // Obtener datos de la base de datos
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            // Añadir datos a la tabla
            while (resultSet.next()) {
                table.addCell(resultSet.getString("RUT"));
                table.addCell(resultSet.getString("NOMBRES"));
                table.addCell(resultSet.getString("APELLIDOS"));
                table.addCell(resultSet.getString("INGRESO"));
                table.addCell(resultSet.getString("SALIDA"));
            }

            document.add(table);
            document.close();

            // Abrir el PDF automáticamente
            if (Desktop.isDesktopSupported()) {
                File pdfFile = new File(filePath);
                if (pdfFile.exists()) {
                    Desktop.getDesktop().open(pdfFile);
                }
            }

        } catch (DocumentException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
