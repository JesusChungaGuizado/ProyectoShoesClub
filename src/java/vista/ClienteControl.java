/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.Cliente;
import servicio.*;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "ClienteControl", urlPatterns = {"/ClienteControl"})
public class ClienteControl extends HttpServlet {
    private ClienteServicio cliSer;

    public ClienteControl() {
        cliSer = new ClienteServicioImp();
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
        if (acc.equalsIgnoreCase("LogIn")) {
            String user=request.getParameter("user");
            String pass=request.getParameter("pass");
            Object[]fil =cliSer.validar(user, pass);
            response.setContentType("application/json;charset=UTF-8");
            if(fil!=null){
                request.getSession().setAttribute("SesionCliente", fil);
                out.println(new Gson().toJson("Bienvenido"));
            }else{
                 out.println(new Gson().toJson("Usuario o Contraseña incorrecta"));
            }
        }
        if (acc.equalsIgnoreCase("Registrar")) {
            response.setContentType("application/json;charset=UTF-8");
            String nombre=request.getParameter("nombre");
            String email=request.getParameter("email");
            String celular=request.getParameter("celular");
            String direc=request.getParameter("direccion");
            String user=request.getParameter("usuario");
            String pass=request.getParameter("pass");
            String busqueda =cliSer.BuscarCliente(user);//Validamos si existe el usuario
            if (busqueda!=null) {
                out.println(new Gson().toJson("Esta cuenta de usuario ya existe"));
            }else{
                Cliente cli=new Cliente(nombre, email, celular, direc, user, pass);
                out.println(new Gson().toJson(cliSer.RegistrarCliente(cli)));
            }
           
        }
        if (acc.equalsIgnoreCase("LogOut")) {
            HttpSession se=request.getSession();
            se.removeAttribute("SesionCliente");
            response.sendRedirect("index.jsp");
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
