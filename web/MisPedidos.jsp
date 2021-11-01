<%-- 
    Document   : Menu
    Created on : 25-oct-2021, 12:16:52
    Author     : Jesus
--%>

<%@page import="vista.PedidoPresentador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shoes Club</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/style_Login.css" />
        <link rel="stylesheet" href="css/styleMenu.css" />
        <link href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css" rel="stylesheet"/>
    </head>
    <body>
        <% if (session.getAttribute("SesionCliente")==null) {
                response.sendRedirect("index.jsp");
            }else{%>
            <% Object[]fil=(Object[])session.getAttribute("SesionCliente"); %>
            <% PedidoPresentador pedPre = (PedidoPresentador) session.getAttribute("pedPre"); %>
            <jsp:include page="menuPrincipal.jsp" />
            <main>
                <section class="container ">
                    <!----------NAVEGACION DE USUARIO----------------->
                    <div class="nav-usuario">
                        <div class="nav-usuario__nameUser">
                            <img src="img/user.png" >
                            <h3><%= fil[5] %></h3>
                        </div>
                        <div  class="nav-usuario__operacion">
                            <a href="Menu.jsp" class="link"><i class='bx bx-user-pin' ></i> Mi Perfil</a><br>
                            <a href="PedidoControl?acc=verPedidos&id=<%= fil[0] %>" class="link"><i class='bx bx-list-ul'></i> Mis Pedidos</a>
                        </div>
                    </div>
                    <!----------TABLA DE PEDIDOS DE USUARIOS----------------->   
                    <div class="fomulario">
                         <section class="carrito-list">
                             <% if (pedPre.getLis2().size()!=0  ) {%>
                            <table>
                                <thead>
                                    <tr>
                                        <td>ID Pedido</td>
                                        <td>Fecha Pedido</td>
                                        <td>Total</td>
                                        <td>Ver Detalles</td>
                                        <td>Cancelar</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% for (int i = 0; i < pedPre.getLis2().size(); i++) {
                                        Object[] ob=(Object[])pedPre.getLis2().get(i);%>
                                        <tr class="carrito-list-item">
                                            <td> <%= ob[0] %></td>
                                            <td> <%= ob[1] %></td>
                                            <td> S/<%= ob[2] %></td>
                                            <td> <a class="link-delete" href="PedidoControl?acc=reporte&id=<%= ob[0] %>"><i class='bx bx-download'></i>Detalle</a></td>
                                            <td><a class="link-delete" href="#"><i class='bx bxs-trash'></i>Eliminar</a></td>
                                        </tr>
                                    <% } %>    
                                </tbody>
                            </table>
                                    <% }else{%>
                                        <h3>Aun no tiene ningun Pedido</h3>
                                    <% } %>
                        </section>
                    </div>
                </section>
                  <jsp:include page="footer.jsp" />
            </main>  
        <% } %>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="js/efectos.js"></script>
    </body>
</html>
