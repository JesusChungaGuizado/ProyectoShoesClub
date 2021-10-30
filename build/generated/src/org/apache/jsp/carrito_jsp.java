package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Locale;
import vista.PedidoPresentador;

public final class carrito_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 String total="0";  
 String subTotal="0";  
 String descTotal="0";  
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <title>Mi carrito</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("        <link\r\n");
      out.write("        href=\"https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css\"\r\n");
      out.write("        rel=\"stylesheet\"\r\n");
      out.write("      />\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"fondo-body\">\r\n");
      out.write("        ");
 PedidoPresentador pedPre = (PedidoPresentador) session.getAttribute("pedPre"); 
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("          ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menuPrincipal.jsp", out, false);
      out.write("\r\n");
      out.write("       <section class=\"carrito_header\">\r\n");
      out.write("        <h1>Carrito de Compras</h1>\r\n");
      out.write("        <a href=\"ProductoControl?acc=ListaOfertas\" ><i class='bx bx-left-arrow-alt bx-tada bx-flip-vertical' ></i>Seguir Comprando</a>\r\n");
      out.write("    </section>\r\n");
      out.write("    \r\n");
      out.write("      <main class=\"container-carrito\">\r\n");
      out.write("            <section class=\" container carrito_body\">\r\n");
      out.write("                 <!-------SECCIÓN DEL LISTADO DEL CARRITO-------->\r\n");
      out.write("                <section class=\"carrito-list\">\r\n");
      out.write("                ");
if (pedPre.getLis().size() != 0) {
      out.write("\r\n");
      out.write("                    <table>\r\n");
      out.write("                        <thead>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td></td>\r\n");
      out.write("                                <td>Precio</td>\r\n");
      out.write("                                <td>Cantidad</td>\r\n");
      out.write("                                <td>Importe</td>\r\n");
      out.write("                                <td></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                             ");
for (int i = 0; i < pedPre.getLis().size(); i++) {
                                Object[] car = (Object[]) pedPre.getLis().get(i);
                                subTotal=car[6].toString();
                                descTotal=car[7].toString();
                                total=car[8].toString();
                            
      out.write("  \r\n");
      out.write("                            <tr class=\"carrito-list-item\">\r\n");
      out.write("                                <td>\r\n");
      out.write("                                    <div class=\"imagen\">\r\n");
      out.write("                                        <img src=\"");
      out.print( car[1] );
      out.write("\" alt=\"\">\r\n");
      out.write("                                        <span class=\"nombre\">");
      out.print( car[0] );
      out.write("</span>\r\n");
      out.write("                                        <span class=\"codigo\">SKU:1UCK0020020</span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </td>\r\n");
      out.write("                                <td>\r\n");
      out.write("                                    ");
 if ((int)car[10]!=0) {
      out.write("\r\n");
      out.write("                                          <div style=\"text-decoration: line-through;font-size: 0.8rem;color: #757577\">S/ ");
      out.print(car[3]);
      out.write("</div>  \r\n");
      out.write("                                      ");
  }
                                    
      out.write("\r\n");
      out.write("                                    \r\n");
      out.write("                                    <div>S/ ");
      out.print( car[2]);
      out.write("</div>\r\n");
      out.write("                                </td>\r\n");
      out.write("                                <td >\r\n");
      out.write("                                        <form class=\"cantidad\" action=\"PedidoControl\" method=\"POST\">\r\n");
      out.write("                                            <input type=\"hidden\" name=\"id\" value=\"");
      out.print( car[9] );
      out.write("\" />\r\n");
      out.write("                                            <button name=\"acc\" value=\"Restar\"  type=\"submit\" class=\"boton\">-</button>\r\n");
      out.write("                                            <p>");
      out.print( car[4] );
      out.write("</p>\r\n");
      out.write("                                            <button name=\"acc\" value=\"Agregar\" type=\"submit\"  class=\"boton\">+</button>\r\n");
      out.write("                                        </form>\r\n");
      out.write("                                </td>\r\n");
      out.write("                                <td>S/");
      out.print( car[5] );
      out.write(" </td>\r\n");
      out.write("                                <td><a class=\"link-delete\" href=\"PedidoControl?cod=");
      out.print( car[9] );
      out.write("&acc=Quitar\"><i class='bx bxs-trash'></i> Eliminar</a></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                             ");
   }
                } else { 
                                total="0.00" ;
                                subTotal="0.00";
                                descTotal="0.00";
               
      out.write("\r\n");
      out.write("                <h2><i class='bx bx-cart' ></i> Carrito Vacio....</h2>\r\n");
      out.write("                ");
 } 
      out.write("     \r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </section>\r\n");
      out.write("                <!-------SECCIÓN DEL RESUMEN DE COMPRA--------->\r\n");
      out.write("                <section class=\"carrito-resumen\">\r\n");
      out.write("                    <h2>Resumen de Compra</h2>\r\n");
      out.write("                    <div class=\"total\">\r\n");
      out.write("                        <span>Subtotal</span>\r\n");
      out.write("                        <span>S/");
      out.print( subTotal );
      out.write("</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"total\" >\r\n");
      out.write("                        <span>Descuento</span>\r\n");
      out.write("                        <span style=\"color: rgb(226, 39, 39);\">S/-");
      out.print( descTotal);
      out.write("</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"total\" style=\"border-top:2px solid #f2f2f2;padding-top: 1rem \">\r\n");
      out.write("                        <span>Total</span>\r\n");
      out.write("                        <span>S/");
      out.print( total );
      out.write("</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    ");
if (pedPre.getLis().size() != 0) {
      out.write("\r\n");
      out.write("                       <a href=\"PedidoControl?acc=Comprar\" class=\"btn-boton \">Generar Compra</a>\r\n");
      out.write("                    ");
}else{
      out.write("\r\n");
      out.write("                        <a href=\"\" class=\"btn-boton desabiltar\">Generar Compra</a>\r\n");
      out.write("                        <a href=\"PedidoControl?acc=reporte\" class=\"btn-boton desabiltar\">Reporte</a>\r\n");
      out.write("                    ");
}
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                </section>\r\n");
      out.write("            </section>\r\n");
      out.write("            <!-- Footer -->\r\n");
      out.write("          ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("      </main>\r\n");
      out.write("      <script src=\"js/efectos.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
