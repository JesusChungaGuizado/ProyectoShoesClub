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
                            <a href="PedidoControl?acc=verPedidos&id=<%= fil[0] %>" class="link"><i class='bx bx-list-ul'></i> Mis Pedidos</a><br>
                            <a href="ClienteControl?acc=LogOut" class="link"><i class='bx bx-log-out'></i> Log Out</a>
                        </div>
                    </div>
                    <!----------FORMULARIO DE DATOS USUARIO----------------->
                    <div class="fomulario">
                        <form id="form-update" class="sign-up-form login-box">
                            <h2 class="title">Mis Datos</h2>
                            <div class="conteiner-grid">
                                <input type="hidden" name="id" value="<%= fil[0] %>" required="true">
                                <div class="user-box">
                                    <input type="text" name="nombre" value="<%= fil[1] %>" required="true">
                                  <label>Nombre y Apellido</label>
                                </div>
                                <div class="user-box">
                                  <input type="email" name="email" value="<%= fil[2] %>" required="true">
                                  <label>Correo</label>
                                </div>
                                <div class="user-box">
                                  <input type="text" name="celular" value="<%= fil[3] %>"  required="true">
                                  <label>Celular</label>
                                </div>
                                <div class="user-box">
                                  <input type="text" name="direccion" value="<%= fil[4] %>" required="true">
                                  <label>Dirección</label>
                                </div>
                                <div class="user-box">
                                  <input type="text" name="usuario" value="<%= fil[5] %>" required="true">
                                  <label>Usuario</label>
                                </div>
                                <div class="user-box">
                                  <input type="password" name="pass" value="<%= fil[6] %>" required="true">
                                  <label>Password</label>
                                </div>
                            </div>
                            <input type="submit" id="btn-update" class="btn" value="Actualizar" />
                        </form>

                        </div>  
                    </section>
                    <jsp:include page="footer.jsp" />
                </main>
            <% } %>
       
            <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
            <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
            <script src="https://kit.fontawesome.com/64d58efce2.js"crossorigin="anonymous"></script>
            <script src="js/Cliente.js"></script>
            <script src="js/efectos.js"></script>
    </body>
</html>
