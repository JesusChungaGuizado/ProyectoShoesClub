<%-- 
    Document   : loginAdmin
    Created on : 05-nov-2021, 11:34:41
    Author     : Jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login Administrativo</title>
        <link rel="stylesheet" href="css/styleLoginAdmin.css">
    </head>
    <body>
        
        <main class=" container form-container login-box">
            <form id="login"  class="sign-in-container ">
               <div class="imagen">
                 <img src="img/user.jpg"  alt="">
              </div>
              <div>
            
                  <h5>Bienvenido a Invent Shod</h5>
                   <h2>Iniciar Sesión</h2>
                
              </div>
              <div class="user-box">
                <input type="text" name="user" required="true">
                <label>Username</label>
              </div>
              <div class="user-box">
                <input type="password" name="pass" required="true">
                <label>Password</label>
              </div>
              <input type="submit" id="btn-login" value="Sign In" class="btn solid" />
           
            </form>
        </main>
   
    </body>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
         <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
          <script src="https://kit.fontawesome.com/64d58efce2.js"crossorigin="anonymous"></script>
          
          <script src="js/Admin.js"></script>
</html>
