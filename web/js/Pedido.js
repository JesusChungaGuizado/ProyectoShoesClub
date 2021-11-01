
    
$(document).ready(function () {
   
    ConfirmarPedido()
});
  
function ConfirmarPedido(){
    let btnCompra=document.getElementById("compra")
    btnCompra.addEventListener("click",()=>{
         $.ajax({
            url: "PedidoControl?acc=Comprar",
            type: 'POST',
            success: function (resultado) {
                if (resultado=="Compra exitosa"){
                     Swal.fire(
                        '¡Compra realizada!',
                        'Hacercate a uno de nuestros estableciminetos para recoger tu pedido',
                        'success'
                      ).then((result) => {
                        if (result.isConfirmed) {
                            parent.location.href = "PedidoControl?acc=Nuevo";
                        }
                        });
                }else{
                    
                    Swal.fire({
                          icon: 'info',
                          text: 'Inicie sesión para continuar comprando'
                        
                    }).then((result) => {
                        if (result.isConfirmed) {
                            parent.location.href = "login.jsp";
                        }
                        });
                     
                }
            }
        });
        
        
        
    })
       
   
}