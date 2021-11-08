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
import servicio.AdminServicio;
import servicio.AdminServicioImp;
import negocio.Empleado;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "AdminControl", urlPatterns = {"/AdminControl"})
public class AdminControl extends HttpServlet {
    private AdminServicio admSer;

    public AdminControl() {
        admSer=new AdminServicioImp();
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
            Object[]fil2 =admSer.validar(user, pass);
            response.setContentType("application/json;charset=UTF-8");
            if(fil2!=null){
                request.getSession().setAttribute("SesionAdmin", fil2);
                out.println(new Gson().toJson("Bienvenido"));
            }else{
                 out.println(new Gson().toJson("Usuario o Contraseña incorrecta"));
            }
        }
          if (acc.equalsIgnoreCase("LogOut")) {
            HttpSession se=request.getSession();
            se.removeAttribute("SesionAdmin");
            response.sendRedirect("loginAdmin.jsp");
        }
           if (acc.equalsIgnoreCase("RegistrarEmpleado")) {
            response.setContentType("application/json;charset=UTF-8");
            String nombre=request.getParameter("nombre");
            String email=request.getParameter("email");
            String celular=request.getParameter("cel");
            String direc=request.getParameter("dir");
            String user=request.getParameter("usu");
            String pass=request.getParameter("pass");
            String dni=request.getParameter("dni");
            int cargo=Integer.parseInt(request.getParameter("cargo"));
            Empleado emp=new Empleado(dni,cargo,nombre, email, celular, direc, user, pass);
            out.println(new Gson().toJson(admSer.registrarEmpleado(emp)));
        }
           if (acc.equalsIgnoreCase("ActualizarEmpleado")) {
            response.setContentType("application/json;charset=UTF-8");
            int cod=Integer.parseInt(request.getParameter("cod"));
            String nombre=request.getParameter("nombre");
            String email=request.getParameter("email");
            String celular=request.getParameter("cel");
            String direc=request.getParameter("dir");
            String user=request.getParameter("usu");
            String pass=request.getParameter("pass");
            String dni=request.getParameter("dni");
            int cargo=Integer.parseInt(request.getParameter("cargo"));
            Empleado emp=new Empleado(dni,cargo,nombre, email, celular, direc, user, pass);
            emp.setIdUsuario(cod);
            out.println(new Gson().toJson(admSer.actualizarEmpleado(emp)));
        }
            if (acc.equalsIgnoreCase("listarEmpleados")) {
            response.setContentType("application/json;charset=UTF-8");
            out.println(new Gson().toJson(admSer.listarEmpleados()));
        }
            if (acc.equalsIgnoreCase("BuscarEmpleado")) {
             int id=Integer.parseInt(request.getParameter("id"));
              response.setContentType("application/json;charset=UTF-8");
              out.println(new Gson().toJson(admSer.buscarEmpleado(id)));
        }
             if (acc.equalsIgnoreCase("DeleteEmpleado")) {
            int cod=Integer.parseInt(request.getParameter("id"));
            response.setContentType("application/json;charset=UTF-8");
            out.println(new Gson().toJson(admSer.eliminarEmpleado(cod)));
            
        }
             if (acc.equalsIgnoreCase("RegistrarCliente")) {
            response.setContentType("application/json;charset=UTF-8");
            String nombre=request.getParameter("nombre");
            String email=request.getParameter("email");
            String celular=request.getParameter("cel");
            String direc=request.getParameter("dir");
            String user=request.getParameter("usu");
            String pass=request.getParameter("pass");
            Cliente cli=new Cliente(nombre, email, celular, direc, user, pass);
            out.println(new Gson().toJson(admSer.registrarCliente(cli)));
        }
           if (acc.equalsIgnoreCase("ActualizarCliente")) {
            response.setContentType("application/json;charset=UTF-8");
            int cod=Integer.parseInt(request.getParameter("cod"));
            String nombre=request.getParameter("nombre");
            String email=request.getParameter("email");
            String celular=request.getParameter("cel");
            String direc=request.getParameter("dir");
            String user=request.getParameter("usu");
            String pass=request.getParameter("pass");
            Cliente cli=new Cliente(nombre, email, celular, direc, user, pass);
            cli.setIdUsuario(cod);
            out.println(new Gson().toJson(admSer.actualizarCliente(cli)));
        }
            if (acc.equalsIgnoreCase("listarClientes")) {
            response.setContentType("application/json;charset=UTF-8");
            out.println(new Gson().toJson(admSer.listarClientes()));
        }
            if (acc.equalsIgnoreCase("BuscarCliente")) {
             int id=Integer.parseInt(request.getParameter("id"));
              response.setContentType("application/json;charset=UTF-8");
              out.println(new Gson().toJson(admSer.buscarCliente(id)));
        }
             if (acc.equalsIgnoreCase("DeleteCliente")) {
            int cod=Integer.parseInt(request.getParameter("id"));
            response.setContentType("application/json;charset=UTF-8");
            out.println(new Gson().toJson(admSer.eliminarCliente(cod)));
            
        }
        if (acc.equalsIgnoreCase("listarPedidos")) {
            response.setContentType("application/json;charset=UTF-8");
            out.println(new Gson().toJson(admSer.listarPedidos()));
        }
        if (acc.equalsIgnoreCase("pagar")) {
            String codPed=request.getParameter("id");
            String msg=admSer.cobrarPedido(codPed);
            response.sendRedirect("crudPedidos.jsp");
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
