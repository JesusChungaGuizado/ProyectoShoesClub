    
$(document).ready(function () {
   
ValidarSesion();
RegistrarCliente();
UpdateCliente();
});
  

function ValidarSesion(){
    var btnLogin=document.getElementById("btn-login");
    $("#login").submit(function(e){
        e.preventDefault();
        $.ajax({
            url: "ClienteControl?acc=LogIn",
            type: 'POST',
            data: $("#login").serialize(), // Al atributo data se le asigna el objeto FormData.
            success: function (resultado) {
                if (resultado=="Bienvenido"){
                    $("#login").trigger('reset');;
                     Swal.fire(
                        'Bienvenido!',
                        'Sesión Iniciada!',
                        'success'
                      ).then((result) => {
                        if (result.isConfirmed) {
                            parent.location.href = "index.jsp";
                        }
                        });
                }else{
                    Swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: resultado+"!",
                        //footer: '<a onclick=container.classList.add("sign-up-mode") href="#">No tengo una cuenta?</a>'
                      })
                }
              
            }
        });
    });
}
function RegistrarCliente(){
     var btnRegistro=document.getElementById("btn-registro");
    $("#registro").submit(function(e){
        e.preventDefault();
        $.ajax({
            url: "ClienteControl?acc=Registrar",
            type: 'POST',
            data: $("#registro").serialize(), // Al atributo data se le asigna el objeto FormData.
            success: function (resultado) {
                if (resultado=="Registro Exitoso"){
                    $("#registro").trigger('reset');;
                     Swal.fire(
                        'Successful!',
                         resultado,
                        'success'
                      ).then((result) => {
                        if (result.isConfirmed) {
                            parent.location.href = "login.jsp";
                        }
                        });
                }else{
                    Swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: resultado+"!",
                        
                      })
                }
                console.log(resultado);
            }
        });
    });
}
function UpdateCliente(){
     var btnUpdate=document.getElementById("btn-update");
    $("#form-update").submit(function(e){
        e.preventDefault();
        $.ajax({
            url: "ClienteControl?acc=Update",
            type: 'POST',
            data: $("#form-update").serialize(), 
            success: function (resultado) {
                if (resultado=="Datos Actualizados"){
                    $("#form-update").trigger('reset');;
                     Swal.fire(
                        'Successful!',
                         resultado,
                        'success'
                      ).then((result) => {
                        if (result.isConfirmed) {
                            parent.location.href = "Menu.jsp";
                        }
                        });
                }
                console.log(resultado);
            }
        });
    });
}