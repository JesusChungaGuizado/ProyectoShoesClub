$(document).ready(function () {
    ListarPedidos();
    cambiarColorEstado();
    filtro();
});
function filtro(){
    $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#lista-pedidos tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
  });
}
function ListarPedidos(){
         $.ajax({
        type: 'GET',
        url: 'AdminControl?acc=listarPedidos',
        async: true,
        cache: false,
        success: function (resp) {
            var tabla_products = document.getElementById("lista-pedidos");
            var text="";
            $.each(resp, function (indice, lista) {
                          text+='  <tr class="table-light">';
                             text+='    <td>'+lista[0]+'</td>';
                             text+='    <td>'+lista[1]+'</td>';
                              text+='   <td>'+lista[2]+'</td>';
                              text+='   <td>'+lista[3]+'</td>';
                              text+='   <td>'+lista[4]+'</td>';
                              text+='   <td><span class="badge badge-pill ">'+lista[5]+'</span></td>';
                               text+='  <td><a href="PedidoControl?acc=reporte&id='+lista[0]+'" role="button" class="btn btn-light " ><i class="fas fa-list"></i></a></td>';
                                text+=' <td><div class="btn-group">';
   
                                text+=' <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown">';
                                text+='   <i class="far fa-edit"></i><span class="caret"></span>';
                                text+=' </button>';
                                text+=' <div class="dropdown-menu">';
                                text+='   <a class="dropdown-item" href="AdminControl?acc=pagar&id='+lista[0]+'">Pago</a>';
//                                 text+='  <a class="dropdown-item" href="#">Cancelar</a>';
                               text+='  </div>';
                                text+=' </div></td>  ';
//                text+='  <td><button type="button" class="btn btn-danger delete"><i class="far fa-trash-alt"></i></button></td>';
                           text+='  </tr>'
                          
              
             
                console.log(lista)
                
               
            });
            tabla_products.innerHTML=text;
         cambiarColorEstado()
        }
    }); 
}
  
  function cambiarColorEstado(){
      var estado=document.querySelectorAll(".badge") ;
      $.each(estado, function (indice, e) {
          if (e.innerHTML=="Por pagar") {
             e.classList.add("badge-warning");
        }else{
            e.classList.add("badge-success");
        }
                       
                
               
            });
     
      
  }

