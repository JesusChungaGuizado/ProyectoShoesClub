$(document).ready(function () {
cargarOfertas();
 $("#carrito").click(function (){
                    $("#paginas").load("carrito.jsp");
                });
                 $("#footer").click(function (){
                    $("#paginas").load("footer.jsp");
                });

});

function cargarOfertas(){
     $.ajax({
        type: 'GET',
        url: 'ProductoControl?acc=Ofertas',
        async: true,
        cache: false,
        success: function (resp) {
            var tabla_products = document.querySelector("#carrusel-Ofertas");
            var template = document.querySelector("#template-ofertas").content;
            var fragment = document.createDocumentFragment();
            console.log(template);
//            let oferta=document.getElementById('carruesel-ofertas')
//                  var text="";
            $.each(resp, function (indice, lista) {
                
          
                
//                
//                 text+='<div   class="carousel__elemento">'
//                text+= '           <div class="cards-product-item">'
//                     text+= '          <a href="details_Product.html">'
//                       text+= '          <span class="desc">-'+ lista[8]+ '%</span>'
//                        text+= '         <img class="img-oferta" src="img/1UCK0020019_1.jpg" />'
//                          text+= '       <div class="product-item-detail">'
//                           text+= '        <span class="marca" >CALIMOD</span>'
//                           text+= '        <h4 class="nombre">Zapatilla Urbana Negro 1UEM001</h4>'
//                            text+= '       <h3 class="pre-normal">S/279.80</h3>'
//                            text+= '     </div>'
//                           text+= '    </a>'
//                          text+= '   </div>'
//                       
//                    text+= '   </div> '
                console.log(lista)
                
                template.querySelectorAll('span')[0].textContent = lista[8];
                template.querySelector('img').setAttribute('src', lista[5]);
                template.querySelectorAll('span')[1].textContent = lista[2];
                template.querySelector('h4').textContent = lista[1];
                template.querySelector('h3').textContent = lista[4];
             

                var clone = template.cloneNode(true);
                fragment.appendChild(clone);
            });
            //oferta.innerHTML=text;
            tabla_products.appendChild(fragment);
            //eliminar();
            //buscar();
            // actualizar();
        }
    });
}