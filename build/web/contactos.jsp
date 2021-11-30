<%-- 
    Document   : contactos
    Created on : 08-nov-2021, 20:41:25
    Author     : Jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Contactenos</title>
        <link rel="stylesheet" href="css/style.css">
         <link rel="stylesheet" href="css/contactos.css">
        <link href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css" rel="stylesheet"/>
    </head>
    <body>
         <!--  Menu de Navegacion--->
        <jsp:include page="menuPrincipal.jsp" />
        <main class="content-contactos ">
              <header class="hero">
                <div class="textos-hero" data-aos="fade-left">
                    <h1>Contáctenos</h1>
                </div>
                <div class="svg-hero" style="height: 80px; overflow: hidden;" >
                   <svg viewBox="0 0 500 150" preserveAspectRatio="none" style="height: 100%; width: 100%;"><path d="M0.00,49.98 C149.99,150.00 349.20,-49.98 500.00,49.98 L500.00,150.00 L0.00,150.00 Z" style="stroke: none; fill: #fff;"></path></svg>
                </div>

            </header>
             <!-- Formulario COntactenos -->
            <section class="container form-contactos">
                <div class="info-contacto">
               
                    <h4><i class='bx bxs-map-pin'></i> - Av. los Sauces 154 Ate</h4>
                    <h4><a href="mailto:info@shoesclub.com"><i class='bx bx-envelope' ></i> - info@shoesclub.com</a></h4>
                    <h4><i class='bx bx-time'></i> - Atención: 10:00 am a 7:00 pm de lunes a sábado </h4>
                    
                    <h4><a href="https://api.whatsapp.com/send?phone=946258360"><i class='bx bx-phone'></i> - 946258360</a></h4>
                 </div>
                     
                         <form id="form-consulta" class="sign-up-form login-box">
                            <div class="conteiner-grid">
                               
                                <div class="user-box">
                                    <input type="text" minlength="3"  name="nombre"  required="true">
                                  <label>Nombre</label>
                                </div>
                                <div class="user-box">
                                  <input type="email" name="email"  required="true">
                                  <label>Correo</label>
                                </div>
                                <div class="user-box">
                                  <input  type="tel" pattern="[0-9]{9}" name="celular" required="true">
                                  <label>Celular</label>
                                </div>
                                <div class="user-box">
                                    <input type="text" minlength="3" name="asunto"  required="true">
                                  <label>Asunto</label>
                                </div>
                                <div class="user-box">
                                    <textarea  name="consulta" minlength="10" maxlength="250" required="true" ></textarea>
                                 
                                  <label>Consulta</label>
                                </div>
                            </div>
                            <input type="submit"  class="btn" value="Enviar" />
                        </form>
                     
            </section>
            <!-- Footer -->
          <jsp:include page="footer.jsp" />
        </main>
    </body>
   
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://kit.fontawesome.com/64d58efce2.js"crossorigin="anonymous"></script>
     <script src="js/efectos.js"></script>
    <script src="js/consulta.js"></script>
    
</html>
