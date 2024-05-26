/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.electrika.tech.test;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Lena
 */
public class App {

    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        String downloadPath = System.getProperty("user.home") + "/Downloads/";
        String fileName = "N10_Lena.pdf";
        String fullPath = downloadPath + fileName;

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(fullPath));

            document.open();

            PdfPTable Encabezado = new PdfPTable(2);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            int[] ColumnaEncabezado = new int[]{1, 1};
            Encabezado.setWidths(ColumnaEncabezado);

            PdfPCell imageAndTitleCell = new PdfPCell();
            imageAndTitleCell.setBorder(Rectangle.NO_BORDER);
            Image img = Image.getInstance("src/com/electrika/tech/img/logo.png");
            img.scaleToFit(100, 100);
            imageAndTitleCell.addElement(img);

            Encabezado.addCell(imageAndTitleCell);

            // segunda columna: fecha y número de factura
            Date date = new Date();
            PdfPCell dateAndInvoiceCell = new PdfPCell();
            dateAndInvoiceCell.setBorder(Rectangle.NO_BORDER);

            // Fecha y número de factura
            String fecha = new SimpleDateFormat("dd/MM/yyyy").format(date);
            Paragraph dateAndInvoice = new Paragraph(String.format("Fecha %s\nFactura\nNº1", fecha));
            dateAndInvoice.setAlignment(Element.ALIGN_RIGHT);
            dateAndInvoiceCell.addElement(dateAndInvoice);

            Encabezado.addCell(dateAndInvoiceCell);

            // Agregar el encabezado al documento
            document.add(Encabezado);

//            Datos del cliente
            Font negrita = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Paragraph cli = new Paragraph();
            cli.add(Chunk.NEWLINE);
            cli.add("Datos del Cliente" + "\n\n");
            document.add(cli);
            PdfPTable tablaDatos = new PdfPTable(2);
            tablaDatos.setWidthPercentage(100);
            tablaDatos.getDefaultCell().setBorder(0);
            int[] ColumnaDa = new int[]{1, 1};
            tablaDatos.setWidths(ColumnaDa);
            PdfPCell cd1 = new PdfPCell(new Phrase(String.format("Cliente: %s", "")));
            PdfPCell cd2 = new PdfPCell(new Phrase(String.format("DNI: %s", "")));
            PdfPCell cd3 = new PdfPCell(new Phrase(String.format("Telefono: %s", "")));
            PdfPCell cd4 = new PdfPCell(new Phrase(String.format("Correo: %s", "")));
            cd1.setBorder(0);
            cd2.setBorder(0);
            cd3.setBorder(0);
            cd4.setBorder(0);
            tablaDatos.addCell(cd1);
            tablaDatos.addCell(cd2);
            tablaDatos.addCell(cd3);
            tablaDatos.addCell(cd4);
            Paragraph salto = new Paragraph();
            salto.add(Chunk.NEWLINE);
            document.add(tablaDatos);
            document.add(salto);
            
//            Tabla de datos;
            PdfPTable tablacli = new PdfPTable(4);
            tablacli.setWidthPercentage(100);
            tablacli.getDefaultCell().setBorder(Rectangle.BOX);
            int[] ColumnaCli = new int[]{2, 4, 2, 2};
            tablacli.setWidths(ColumnaCli);
            PdfPCell cl1 = new PdfPCell(new Phrase("Cantidad", negrita));
            PdfPCell cl2 = new PdfPCell(new Phrase("Producto", negrita));
            PdfPCell cl3 = new PdfPCell(new Phrase("Precio", negrita));
            PdfPCell cl4 = new PdfPCell(new Phrase("Total", negrita));
            cl1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cl2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cl3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cl4.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablacli.addCell(cl1);
            tablacli.addCell(cl2);
            tablacli.addCell(cl3);
            tablacli.addCell(cl4);
            tablacli.addCell("");
            tablacli.addCell("");
            tablacli.addCell("");
            tablacli.addCell("");
            tablacli.addCell("");
            tablacli.addCell("");
            tablacli.addCell("");
            tablacli.addCell("");
            tablacli.addCell("");
            tablacli.addCell("");
            tablacli.addCell("");
            tablacli.addCell("");

            document.add(tablacli);

//            for (int i = 0; i < tablaAdicionales.getRowCount(); i++) {
//                String servicioA=tablaAdicionales.getValueAt(i, 0).toString();
//                String precioA=tablaAdicionales.getValueAt(i, 1).toString();
//                tablaserv.addCell(servicioA);
//                tablaserv.addCell(precioA);
//            }
            // Establecer el padding (espacio alrededor del texto)
            Paragraph infoP = new Paragraph(String.format("Total a pagar S/. %s", ""));
            infoP.setAlignment(Element.ALIGN_RIGHT);
            document.add(infoP);

            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Firma\n\n");
            firma.add("-----------------------------------------");
            firma.setAlignment(Element.ALIGN_CENTER);
            document.add(firma);

            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("Gracias por su compra!!");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            document.add(mensaje);

//            contactyo titulo
            Paragraph contacto = new Paragraph("Contacto", negrita);
            document.add(contacto);
//            String ruc="736492736";
//            informacion contacto
            PdfPTable footerTable = new PdfPTable(2);
            footerTable.setWidthPercentage(100);
            footerTable.setWidths(new int[]{2, 5}); // Ancho de columnas

            // Columna 1
            PdfPCell cell1 = new PdfPCell();
            cell1.setBorder(Rectangle.NO_BORDER);
            Phrase emailPhrase = new Phrase();
//            emailPhrase.add(emailIcon);
            emailPhrase.add(new Phrase("Email: hola.gmail.com"));
            cell1.addElement(emailPhrase);
            // Icono de ubicación y texto
//            Chunk locationIcon = new Chunk(Icon.get(com.itextpdf.text.Font.FontFamily.ZAPFDINGBATS, "l"), 0, 0);
            Phrase locationPhrase = new Phrase();
//            locationPhrase.add(locationIcon);
            locationPhrase.add(new Phrase("Direccion: call.34"));
            cell1.addElement(locationPhrase);

            // Columna 2
            PdfPCell cell2 = new PdfPCell();
            cell2.setBorder(Rectangle.NO_BORDER);
            // Icono de página web y texto
//            Chunk webIcon = new Chunk(Icon.get(com.itextpdf.text.Font.FontFamily.ZAPFDINGBATS, "W"), 0, 0);
            Phrase rucPhrase = new Phrase();
//            webPhrase.add(webIcon);
            rucPhrase.add(new Phrase("Ruc: 2522356787"));
            cell2.addElement(rucPhrase);
            // Icono de teléfono y texto
//            Chunk phoneIcon = new Chunk(Icon.get(com.itextpdf.text.Font.FontFamily.ZAPFDINGBATS, "+"), 0, 0);
            Phrase phonePhrase = new Phrase();
//            phonePhrase.add(phoneIcon);
            phonePhrase.add(new Phrase("Telefono: +51 9232392832"));
            cell2.addElement(phonePhrase);

            footerTable.addCell(cell1);
            footerTable.addCell(cell2);

            // Agregar pie de página al documento
            document.add(footerTable);

            document.close();
            // Abrir el archivo automáticamente
            File pdfFile = new File(fullPath);
            Desktop.getDesktop().open(pdfFile);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
