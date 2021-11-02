/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Producto;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import servicio.*;
/**
 *
 * @author Jesus
 */
@WebServlet(name = "ProductoControl", urlPatterns = {"/ProductoControl"})
public class ProductoControl extends HttpServlet {
    private ProductoServicio proSer;
    public ProductoControl(){
    proSer=new ProductoServicioImp();
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
        String acc=request.getParameter("acc");
          Producto p=new Producto();
        
        if (acc.equalsIgnoreCase("Guardar")) {
                ArrayList<String> lista =new ArrayList<>();
                try {
                    FileItemFactory file = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(file);
                    List items = fileUpload.parseRequest(request);
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);
                        if (!fileItem.isFormField()) {
                            //"E:\\EjerciciosUML_JEE\\ListadoAjax\\web\\img\\" 
                            File f = new File("c:\\xampp\\htdocs\\img\\"+ fileItem.getName());
                            fileItem.write(f);
                            //     img/ 
                            p.setImagen("http://localhost/img/"+fileItem.getName());
                        } else {
                            lista.add(fileItem.getString());
                        }
                    }
                    p.setNombre(lista.get(1));
                    p.setMarca(lista.get(2));
                    p.setTalla(Integer.parseInt(lista.get(3)));
                    p.setStock(Integer.parseInt(lista.get(4)));
                    p.setPrecioNormal(Double.parseDouble(lista.get(5)));
                    p.setSexo(lista.get(6));
                    p.setDescuento(Integer.parseInt(lista.get(7)));
                    p.setCategoria(Integer.parseInt(lista.get(8)));
                    p.setDescripcion(lista.get(9));
                    
                  response.setContentType("application/json;charset=UTF-8");
                  out.println(new Gson().toJson(proSer.RegistrarProducto(p)));
                
                } catch (Exception e) {
                }
        }
         if (acc.equalsIgnoreCase("Listar")) {
              response.setContentType("application/json;charset=UTF-8");
              out.println(new Gson().toJson(proSer.listarProductos()));
        }
         if (acc.equalsIgnoreCase("Buscar")) {
             int id=Integer.parseInt(request.getParameter("id"));
              response.setContentType("application/json;charset=UTF-8");
              out.println(new Gson().toJson(proSer.buscarProducto(id)));
        }
         if (acc.equalsIgnoreCase("Delete")) {
            int cod=Integer.parseInt(request.getParameter("id"));
            response.setContentType("application/json;charset=UTF-8");
            out.println(new Gson().toJson(proSer.eliminarProducto(cod)));
            
        }
         if (acc.equalsIgnoreCase("Actualizar")) {
             ArrayList<String> lista =new ArrayList<>();
                try {
                    FileItemFactory file = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(file);
                    List items = fileUpload.parseRequest(request);
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);
                        if (!fileItem.isFormField()) {
                            //"E:\\EjerciciosUML_JEE\\ListadoAjax\\web\\img\\" 
                            File f = new File("c:\\xampp\\htdocs\\img\\"+ fileItem.getName());
                            fileItem.write(f);
                            //     img/ 
                            p.setImagen("http://localhost/img/"+fileItem.getName());
                        } else {
                            lista.add(fileItem.getString());
                        }
                    }
                    if(lista.size()==11){
                        p.setImagen(lista.get(10));
                    }
                    p.setIdProducto(Integer.parseInt(lista.get(0)));
                    p.setNombre(lista.get(1));
                    p.setMarca(lista.get(2));
                    p.setTalla(Integer.parseInt(lista.get(3)));
                    p.setStock(Integer.parseInt(lista.get(4)));
                    p.setPrecioNormal(Double.parseDouble(lista.get(5)));
                    p.setSexo(lista.get(6));
                    p.setDescuento(Integer.parseInt(lista.get(7)));
                    p.setCategoria(Integer.parseInt(lista.get(8)));
                    p.setDescripcion(lista.get(9));
                    
                  response.setContentType("application/json;charset=UTF-8");
                  out.println(new Gson().toJson(proSer.actualizarProducto(p)));
                
                } catch (Exception e) {
                }
        }
        if (acc.equalsIgnoreCase("Ofertas")) {
             response.setContentType("application/json;charset=UTF-8");
             out.println(new Gson().toJson(proSer.listarOfertas()));
        }
         if (acc.equalsIgnoreCase("ListaOfertas")) {
             List lista=proSer.listarOfertas();
             request.getSession().setAttribute("producto",lista);
             response.sendRedirect("producto.jsp");
        }
          if (acc.equalsIgnoreCase("view")) {
              int id=Integer.parseInt(request.getParameter("id"));
             Producto pro=proSer.buscarProducto(id);
             request.getSession().setAttribute("detalle",pro);
             response.sendRedirect("DetalleProducto.jsp");
        }
          if (acc.equalsIgnoreCase("filter")) {
             String sexo=request.getParameter("sexo");
             int categoria=Integer.parseInt(request.getParameter("cat"));
             proSer.FiltrarProductos(categoria, sexo);
             request.getSession().setAttribute("producto",proSer.FiltrarProductos(categoria, sexo));
             response.sendRedirect("producto.jsp");
        }
        
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
