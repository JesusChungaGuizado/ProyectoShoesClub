<%-- 
    Document   : login
    Created on : 24-oct-2021, 19:42:52
    Author     : Jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    
    <link href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css"
    rel="stylesheet" />
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" integrity="sha512-c42qTSw/wPZ3/5LBzD+Bw5f7bSF2oxou6wEb+I/lqeaKV5FDIfMvvRp772y4jcJLKuGUOpbJMdg/BTl50fJYAw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.1.9/sweetalert2.min.css" integrity="sha512-cyIcYOviYhF0bHIhzXWJQ/7xnaBuIIOecYoPZBgJHQKFPo+TOBA+BY1EnTpmM8yKDU4ZdI3UGccNGCEUdfbBqw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
   
    <link rel="stylesheet" href="css/style_Login.css" />
    <link rel="stylesheet" href="css/style.css">
    <title>Log In</title>
    </head>
    <body>
        <!--  Menu de Navegacion--->
        <jsp:include page="menuPrincipal.jsp" />
          <!--  Formularios de Login y Registto de Usuario--->
         <div class="container-login">
      <div class="forms-container">
        <div class="signin-signup">
            <form id="login"  class="sign-in-form login-box ">
            <h2 class="title">Sign in</h2>
           
            <div class="user-box">
                <input type="text" name="user" required="true">
              <label>Username</label>
            </div>
            <div class="user-box">
                <input type="password" name="pass" required="true">
              <label>Password</label>
            </div>
           
            <input type="submit" id="btn-login" value="Log in" class="btn solid" />
            <p class="social-text">Or Sign in with social platforms</p>
            <div class="social-media">
              <a href="#" class="social-icon">
                <i class="fab fa-facebook-f"></i>
              </a>
              <a href="#" class="social-icon">
                <i class="fab fa-twitter"></i>
              </a>
              <a href="#" class="social-icon">
                <i class="fab fa-google"></i>
              </a>
              <a href="#" class="social-icon">
                <i class="fab fa-linkedin-in"></i>
              </a>
            </div>
          </form>
            <form id="registro" class="sign-up-form login-box">
            <h2 class="title">Sign up</h2>
            <div class="conteiner-grid">
              <div class="user-box">
                <input type="text" name="nombre" required="true">
                <label>Nombre y Apellido</label>
              </div>
              <div class="user-box">
                <input type="email" name="email" required="true">
                <label>Correo</label>
              </div>
              <div class="user-box">
                <input type="text" name="celular"  required="true">
                <label>Celular</label>
              </div>
              <div class="user-box">
                <input type="text" name="direccion" required="true">
                <label>Dirección</label>
              </div>
              <div class="user-box">
                <input type="text" name="usuario" required="true">
                <label>Usuario</label>
              </div>
              <div class="user-box">
                <input type="password" name="pass" required="true">
                <label>Password</label>
              </div>
            </div>
            <input type="submit" id="btn-registro" class="btn" value="Sign up" />
          </form>
        </div>
      </div>

      <div class="panels-container">
        <div class="panel left-panel">
          <div class="content">
            <h3>No tengo una cuenta ?</h3>
           
            <button class="btn transparent" id="sign-up-btn" >
              Registrame
            </button>
          </div>
          <img src="img/undraw_Login_re_4vu2.svg" class="image" alt="" />
        </div>
        <div class="panel right-panel">
          <div class="content">
            <h3>Ya tengo una cuenta</h3>
            <!-- <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum
              laboriosam ad deleniti.
            </p> -->
            <button class="btn transparent" id="sign-in-btn">
              Log in
            </button>
          </div>
          <img src="img/undraw_Successful_purchase_re_mpig.svg" class="image" alt="" />
        </div>
      </div>
      
    </div>
           <!-- Footer -->
          <jsp:include page="footer.jsp" />
          <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
         <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
          <script src="https://kit.fontawesome.com/64d58efce2.js"crossorigin="anonymous"></script>
          <script src="js/app.js" ></script>
          <script src="js/Cliente.js"></script>
    <script src="js/efectos.js"></script>
    </body>
</html>
