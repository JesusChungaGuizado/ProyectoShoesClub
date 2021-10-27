/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Producto;

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
