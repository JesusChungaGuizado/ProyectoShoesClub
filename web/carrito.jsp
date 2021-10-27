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
        <a href="producto.jsp" ><i class='bx bx-left-arrow-alt bx-tada bx-flip-vertical' ></i>Seguir Comprando</a>
    </section>
    <!-- Seccion listado productos carrito -->
      <main class="container-carrito">
            <section class=" container carrito_body">
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
                                <td>S/ <%= car[2]%></td>
                                <td >
                                    <div >
                                        <form class="cantidad" action="PedidoControl" method="POST">
                                            <input type="hidden" name="id" value="<%= car[9] %>" />
                                            <button name="acc" value="Restar"  type="submit" class="boton">-</button>
                                            <p><%= car[4] %></p>
                                            <button name="acc" value="Agregar" type="submit"  class="boton">+</button>
                                        </form>
                                    </div>
                                </td>
                                <td>S/<%= String.format(Locale.ROOT,"%.2f", (double)car[5] )%> </td>
                                
                                <td><a class="link-delete" href="PedidoControl?cod=<%= car[9] %>&acc=Quitar"><i class='bx bxs-trash'></i> Eliminar</a></td>
                            </tr>
                             <%       }
                              } else { total="0" ;%>
                    <h6>Carrito Vacio....</h6>
                    
                    <% }
                    %>  

 
                            
                            
                        </tbody>
    
                    </table>
                </section>
                <section class="carrito-resumen">
                    <h2>Resumen de Compra</h2>
                        <div class="total">
                            <span>Subtotal</span>
                            <span>S/<%= subTotal %></span><br>
                            <span>Descuento</span><br>
                            <span>S/<%= descTotal%></span>
                        </div>
                        <div class="total">
                            <span>Total</span>
                            <span>S/<%= total %></span>
                        </div>
                    <span class="btn-boton">Generar Compra</span>
                </section>
            </section>
            <!-- Footer -->
          <jsp:include page="footer.jsp" />
      </main>
      <script src="js/efectos.js"></script>
    </body>
</html>
