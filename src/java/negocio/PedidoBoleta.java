/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import com.itextpdf.text.BadElementException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
/**
 *
 * @author Jesus
 */
public class PedidoBoleta {
    private String encabezado;
    private List listaPedido;
    private String[] thead;
    private String codPedido;
    private String fecha;
    private double total;
    public PedidoBoleta(String encabezado, List listaPed, String[] thead) {
        this.encabezado = encabezado;
        this.listaPedido = listaPed;
        this.thead = thead;
    }

    public PedidoBoleta() {
   
        
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String[] getThead() {
        return thead;
    }

    public void setThead(String[] thead) {
        this.thead = thead;
    }

    public List getListaPed() {
        return listaPedido;
    }

    public void setListaPed(List listaPed) {
        this.listaPedido = listaPed;
    }

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void estiloCelda(PdfPCell celda){
            celda.setPaddingTop(8);
            celda.setPaddingBottom(8);
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(1);
    }
    public void AgregarEncabezadoTabla(PdfPTable tabla){
        for (int i = 0; i < getThead().length; i++) {
            PdfPCell celda1 = new PdfPCell(new Paragraph(getThead()[i].toString(), FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.WHITE)));
            celda1.setBackgroundColor(BaseColor.BLACK);
            celda1.setBorderColor(BaseColor.WHITE);
            estiloCelda(celda1);
            tabla.addCell(celda1);
        }
    }
    public void Listado(PdfPTable tabla){
            for (int i = 0; i < getListaPed().size(); i++) {
                Object[] ob = new Object[getThead().length];
                ob= (Object[]) getListaPed().get(i);
                for (Object ob1 : ob) {
                    PdfPCell cel=new PdfPCell(new Paragraph(ob1.toString()));
                    estiloCelda(cel);
                    tabla.addCell(cel);
                }         
            }
    }
    public String fechaLocal(){
      SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-y hh:mm:ss a ");
      return sdf.format(new Date());
    }
    public void generaBoleta(OutputStream out) throws BadElementException, DocumentException, IOException {
            //Generando estructuta PDF
            //Definimos el tipo de letra
            Font fuente = new Font(Font.getFamily("ROBOTO"), 20, Font.BOLD);
            //Creamos objeto tipo Imagen
            //Image imagen = Image.getInstance("E:\\EjerciciosUML_JEE\\ProyectoCalzado\\web\\img\\facebook.png");
            //imagen.scaleToFit(100, 40);
            //imagen.setAlignment(Image.LEFT);
            //Creamos un parrafo
            Paragraph logo=new Paragraph("SHOES CLUB\n\n",fuente);
            Paragraph linea = new Paragraph(getEncabezado()+ "\n" + "\n", fuente);
            linea.setAlignment(Element.ALIGN_CENTER);
            Paragraph fecha = new Paragraph(fechaLocal() + "\n" + "\n");
            //Creamos una tabla
            PdfPTable tabla = new PdfPTable(getThead().length);
            tabla.setWidthPercentage(100);
            
            //Creamos el documento
            Document documento = new Document(PageSize.A4);
            //Generamos archivo pdf
            PdfWriter writer=PdfWriter.getInstance(documento, out);
            AgregarEncabezadoTabla(tabla);         
//            //Ensamblar el documento
            documento.open();
            documento.add(logo);
            documento.add(linea);
            documento.add(fecha);
            documento.add(new Paragraph("Fecha de Pedido:"+getFecha()));
            documento.add(new Paragraph("Codigo de Pedido:"+getCodPedido()+"\n\n"));
//            //Impriemiendo contenido
             Listado(tabla);
//            //Agregamos tabla en el documento
            PdfPCell celdaFinal = new PdfPCell(new Paragraph("Total a Pagar (S/)"));
            celdaFinal.setColspan(4);
            estiloCelda(celdaFinal);
            tabla.addCell(celdaFinal);
            PdfPCell total=new PdfPCell(new Paragraph(""+getTotal()));
            estiloCelda(total);
            tabla.addCell(total);
            documento.add(tabla);
            documento.add(new Paragraph("\n\nGRACIAS POR SU PREFERENCIA...!"));
            //documento.add(new Paragraph("Total a Pagar: "+getTotal()));
            documento.close();
        
    }
}
