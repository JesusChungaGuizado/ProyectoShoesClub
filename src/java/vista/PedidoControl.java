/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.PedidoBoleta;
import servicio.PedidoServicio;
import servicio.PedidoServicioImp;
import servicio.ProductoServicio;
import servicio.ProductoServicioImp;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "PedidoControl", urlPatterns = {"/PedidoControl"})
public class PedidoControl extends HttpServlet {
    private PedidoServicio pedSer;
    private PedidoPresentador pedPre;
    private ProductoServicio proSer;
    List lista=new ArrayList();

    

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
        
        proSer=new ProductoServicioImp();
        String acc=request.getParameter("acc");
        
        if (acc.equalsIgnoreCase("Nuevo")) {
             pedPre=new PedidoPresentador();
             pedSer=new PedidoServicioImp();
             pedSer.NuevoPedido();
             request.getSession().setAttribute("pedPre", pedPre);
             pedPre.setLis(pedSer.quitarArticulo(""));
             response.sendRedirect("index.jsp");
        }
      
        
//        if(acc.equalsIgnoreCase("lis")){
//            request.getSession().setAttribute("listado", proSer.listar());
//            response.sendRedirect("listado.jsp");
//        }
//        if(acc.equalsIgnoreCase("Detalle")){
//            int cod=Integer.parseInt(request.getParameter("id"));
//            request.getSession().setAttribute("detalle", proSer.buscar(cod));
//            response.sendRedirect("DetalleProducto.jsp");
//        }
//        
        
        if (acc.equalsIgnoreCase("Agregar")) {
           String id=request.getParameter("id");
            //String cant=request.getParameter("can");
            pedPre.setLis(pedSer.agregarArticulos(Integer.parseInt(id), 1));
            response.sendRedirect("carrito.jsp");
             
        }
         if (acc.equalsIgnoreCase("Restar")) {
            String id=request.getParameter("id");
            pedPre.setLis(pedSer.restarArticulos(Integer.parseInt(id), 1));
            response.sendRedirect("carrito.jsp");  
        }
        if (acc.equalsIgnoreCase("Quitar")) {
            String cod=request.getParameter("cod");
            pedPre.setLis(pedSer.quitarArticulo(cod));
            response.sendRedirect("carrito.jsp");
        }
//        if (acc.equalsIgnoreCase("Buscar")) {
//            String cod=request.getParameter("cod");
//            Object[]fil=pedSer.buscarCliente(cod);
//            if(fil!=null){
//                pedPre.setFil2(fil);
//                pedPre.setMsg("");
//            }else{
//                pedPre.setMsg("No existe este cliente en la BD");
//            }
//             response.sendRedirect("PedidoGui.jsp");
//        }
        if (acc.equalsIgnoreCase("Comprar")) {
            PrintWriter out = response.getWriter();
            HttpSession se=request.getSession();
            Object[]fil=(Object[])se.getAttribute("SesionCliente");
            if (fil!=null) {
                response.setContentType("application/json;charset=UTF-8");
                int idCliente=(int)fil[0];
                String msg=pedSer.grabarPedido(idCliente);
                pedPre=new PedidoPresentador();
                pedSer=new PedidoServicioImp();
                pedSer.NuevoPedido();
                request.getSession().setAttribute("pedPre", pedPre);
                pedPre.setLis(pedSer.quitarArticulo(""));
                out.println(new Gson().toJson("Compra exitosa"));
                //response.sendRedirect(("carrito.jsp"));
            }else{
                out.println(new Gson().toJson("Inicie Sesion"));
               //response.sendRedirect("login.jsp");
            }

        }
        if(acc.equalsIgnoreCase("verPedidos")){
            int cod=Integer.parseInt(request.getParameter("id"));
            pedPre.setLis2(pedSer.VerMisPedidos(cod));
            response.sendRedirect("MisPedidos.jsp");
        }
        if (acc.equalsIgnoreCase("reporte")) {
            response.setContentType("application/PDF");
            response.setHeader("Content-Disposition", "attachment; filename=\"pedidoBoleta.PDF\";");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            String codPedido=request.getParameter("id");
            try {
                OutputStream out =response.getOutputStream();
                pedSer.GenerarBoletaPedido(out, codPedido);
                //response.sendRedirect("carrito.jsp");
            } catch (Exception e) {
            }
              
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
