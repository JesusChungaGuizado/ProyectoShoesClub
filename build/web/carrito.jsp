<%-- 
    Document   : calzados
    Created on : 24-oct-2021, 19:09:06
    Author     : Jesus
--%>

<%@page import="java.util.Locale"%>
<%@page import="vista.PedidoPresentador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Mi carrito</title>
        <link rel="stylesheet" href="css/style.css">
        <link
        href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css"
        rel="stylesheet"
      />
    </head>
    <body class="fondo-body">
        <% PedidoPresentador pedPre = (PedidoPresentador) session.getAttribute("pedPre"); %>
        <%! String total="0";  %>
        <%! String subTotal="0";  %>
        <%! String descTotal="0";  %>
          <jsp:include page="menuPrincipal.jsp" />
       <section class="carrito_header">
        <h1>Carrito de Compras</h1>
        <a href="ProductoControl?acc=ListaOfertas" ><i class='bx bx-left-arrow-alt bx-tada bx-flip-vertical' ></i>Seguir Comprando</a>
    </section>
    
      <main class="container-carrito">
            <section class=" container carrito_body">
                 <!-------SECCIÓN DEL LISTADO DEL CARRITO-------->
                <section class="carrito-list">
                <%if (pedPre.getLis().size() != 0) {%>
                    <table>
                        <thead>
                            <tr>
                                <td></td>
                                <td>Precio</td>
                                <td>Cantidad</td>
                                <td>Importe</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                             <%for (int i = 0; i < pedPre.getLis().size(); i++) {
                                Object[] car = (Object[]) pedPre.getLis().get(i);
                                subTotal=car[6].toString();
                                descTotal=car[7].toString();
                                total=car[8].toString();
                            %>  
                            <tr class="carrito-list-item">
                                <td>
                                    <div class="imagen">
                                        <img src="<%= car[1] %>" alt="">
                                        <span class="nombre"><%= car[0] %></span>
                                        <span class="codigo">SKU:1UCK0020020</span>
                                    </div>
                                </td>
                                <td>
                                    <% if ((int)car[10]!=0) {%>
                                          <div style="text-decoration: line-through;font-size: 0.8rem;color: #757577">S/ <%=car[3]%></div>  
                                      <%  }
                                    %>
                                    
                                    <div>S/ <%= car[2]%></div>
                                </td>
                                <td >
                                        <form class="cantidad" action="PedidoControl" method="POST">
                                            <input type="hidden" name="id" value="<%= car[9] %>" />
                                            <button name="acc" value="Restar"  type="submit" class="boton">-</button>
                                            <p><%= car[4] %></p>
                                            <button name="acc" value="Agregar" type="submit"  class="boton">+</button>
                                        </form>
                                </td>
                                <td>S/<%= car[5] %> </td>
                                <td><a class="link-delete" href="PedidoControl?cod=<%= car[9] %>&acc=Quitar"><i class='bx bxs-trash'></i> Eliminar</a></td>
                            </tr>
                             <%   }
                } else { 
                                total="0.00" ;
                                subTotal="0.00";
                                descTotal="0.00";
               %>
                <h2><i class='bx bx-cart' ></i> Carrito Vacio....</h2>
                <% } %>     
                        </tbody>
                    </table>
                </section>
                <!-------SECCIÓN DEL RESUMEN DE COMPRA--------->
                <section class="carrito-resumen">
                    <h2>Resumen de Compra</h2>
                    <div class="total">
                        <span>Subtotal</span>
                        <span>S/<%= subTotal %></span>
                    </div>
                    <div class="total" >
                        <span>Descuento</span>
                        <span style="color: rgb(226, 39, 39);">S/-<%= descTotal%></span>
                    </div>
                    <div class="total" style="border-top:2px solid #f2f2f2;padding-top: 1rem ">
                        <span>Total</span>
                        <span>S/<%= total %></span>
                    </div>
                    <%if (pedPre.getLis().size() != 0) {%>
                       <a href="PedidoControl?acc=Comprar" class="btn-boton ">Generar Compra</a>
                    <%}else{%>
                        <a href="" class="btn-boton desabiltar">Generar Compra</a>
                        <a href="PedidoControl?acc=reporte" class="btn-boton ">Reporte</a>
                    <%}%>
                    
                </section>
            </section>
            <!-- Footer -->
          <jsp:include page="footer.jsp" />
      </main>
      <script src="js/efectos.js"></script>
    </body>
</html>
