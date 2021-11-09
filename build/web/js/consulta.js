    
$(document).ready(function () {
   RegistrarConsulta();

});
  
function RegistrarConsulta(){
    $("#form-consulta").submit(function(e){
        e.preventDefault();
        $.ajax({
            url: "ClienteControl?acc=consultar",
            type: 'POST',
            data: $("#form-consulta").serialize(), // Al atributo data se le asigna el objeto FormData.
            success: function (resultado) {
                if (resultado=="Consulta Registrada"){
                    $("#form-consulta").trigger('reset');
                     Swal.fire(
                        'Enviado!',
                        'En breve nos comunicaremos contigo',
                        'success'
                      ).then((result) => {
                        if (result.isConfirmed) {
                            parent.location.href = "contactos.jsp";
                        }
                        });
                }
                console.log(resultado);
            }
        });
    });
}
