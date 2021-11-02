$(document).ready(function () {
cargarOfertas();
 $("#myBtn").click(function () {
        $('#formulario').trigger('reset');
        $("#myModal").modal();
    });
 cargaListado();
  //  cargaCategoria();
    registrar();
   actualizar();
   mostrarImagenInput();
});
$(".custom-file-input").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
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

function registrar() {
    $("#formulario").submit(function (e) {
        e.preventDefault(); // Evitamos que salte el enlace.
        //Recogemos los datos del formulario
        var paqueteDeDatos = new FormData();
        paqueteDeDatos.append('cod', $('#cod').prop('value'));
        paqueteDeDatos.append('nombre', $('#nombre').prop('value'));
        paqueteDeDatos.append('marca', $('#marca').prop('value'));
        paqueteDeDatos.append('talla', $('#talla').prop('value'));
        paqueteDeDatos.append('stock', $('#stock').prop('value'));
        paqueteDeDatos.append('precio', $('#precio').prop('value'));
        paqueteDeDatos.append('genero', $('#genero').prop('value'));
        paqueteDeDatos.append('descu', $('#descu').prop('value'));
        paqueteDeDatos.append('catego', $('#catego').prop('value'));
        paqueteDeDatos.append('descrip', $('#descrip').prop('value'));
        paqueteDeDatos.append('img', $('#img')[0].files[0]);
        //console.log(paqueteDeDatos);
        /* Se envia el paquete de datos por ajax. */
        $.ajax({
            url: "ProductoControl?acc=Guardar",
            type: 'POST', // Siempre que se envíen ficheros, por POST, no por GET.
            contentType: false,
            data: paqueteDeDatos, // Al atributo data se le asigna el objeto FormData.
            processData: false,
            cache: false,
            success: function (resultado) { //si se resive algun una respuesta
                $('#formulario').trigger('reset');

                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: 'Producto Registrado',
                    showConfirmButton: true
                }).then((result) => {
                        if (result.isConfirmed) {
                            parent.location.href = "crudProducto.jsp";
                        }
                        });//mandamos enunciado mediate swearAlert y retornamos  Producto Registrado
            },
            error: function () { // Si hay algún error.
                alert("Algo ha fallado.");
            }
        });
    });

}
function cargaListado() {
    $.ajax({
        type: 'GET',
        url: 'ProductoControl?acc=Listar',
        async: true,
        cache: false,
        success: function (resp) {
            var tabla_products = document.querySelector("#tabla-producto");
            var template = document.querySelector("#template-producto").content;
            var fragment = document.createDocumentFragment();
            console.log(template);
            $.each(resp, function (indice, lista) {
                //console.log(lista)
                template.querySelectorAll('td')[0].textContent = lista[0];
                template.querySelector('img').setAttribute('src', lista[1]);
                template.querySelectorAll('td')[2].textContent = lista[2];
                template.querySelectorAll('td')[3].textContent = lista[3];
                template.querySelectorAll('td')[4].textContent = lista[4];
                template.querySelectorAll('td')[5].textContent = lista[5];
                template.querySelectorAll('td')[6].textContent = lista[6];
                template.querySelectorAll('td')[7].textContent = lista[7];
                template.querySelectorAll('td')[8].textContent = lista[8];
                template.querySelectorAll('td')[9].textContent = lista[9];
                template.querySelectorAll('td')[10].textContent = lista[10];
               
                var clone = template.cloneNode(true);
                fragment.appendChild(clone);
            });
            tabla_products.appendChild(fragment);
            eliminar();
            buscar();
           
        }
    });
}
function buscar() {
    var botones = document.querySelectorAll(".update");
    $.each(botones, function (indice, lista) {
        lista.addEventListener("click", (e) => {
            var id = document.querySelectorAll(".codigo")[indice];
            var dato = "id=" + id.innerHTML;
            $.ajax({
                url: "ProductoControl?acc=Buscar",
                type: 'POST',
                data: dato,
                success: function (resultado) {
                    console.log(resultado);
                    $("#myModal2").modal();
                    document.getElementById("cod2").value = resultado.idProducto;
                    document.getElementById("nombre2").value = resultado.nombre;
                    document.getElementById("marca2").value = resultado.marca;
                    document.getElementById("talla2").value = resultado.talla;
                    document.getElementById("stock2").value = resultado.stock;
                    document.getElementById("precio2").value = resultado.precioNormal;
                    document.getElementById("genero2").value = resultado.sexo;
                    document.getElementById("descu2").value = resultado.descuento;
                    document.getElementById("catego2").value = resultado.categoria;
                    document.getElementById("descrip2").value = resultado.descripcion;
                    document.getElementById("img2").value='';//Limpiando input de la imagen
                    document.getElementById("foto").src = resultado.imagen;
                    
                }
            });
        });
    });
}
function eliminar() {
    var botones = document.querySelectorAll(".delete");
    $.each(botones, function (indice, lista) {
        lista.addEventListener("click", (e) => {
            var id = document.querySelectorAll(".codigo")[indice];
            var nombre = document.querySelectorAll(".nombre")[indice];
            var dato = "id=" + id.innerHTML;
            //console.log(id.innerHTML);
            Swal.fire({
                title: 'Are you sure?',
                text: "Se eliminara el producto " + nombre.innerHTML + "!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        url: "ProductoControl?acc=Delete",
                        type: 'POST', // Siempre que se envíen ficheros, por POST, no por GET.
                        data: dato, // Al atributo data se le asigna el objeto FormData.
                        success: function (resultado) { //si se resive algun una respuesta
                            // $('#formulario').trigger('reset');
                            Swal.fire(
                                    'Deleted!',
                                    'Your file has been deleted.',
                                    'success'
                                    ).then((result) => {
                                if (result.isConfirmed) {
                                    parent.location.href = "crudProducto.jsp";
                                }
                            });
                        }
                    });

                }
            });

        });
    });
}
function mostrarImagenInput() {
     
    document.getElementById("img2").onchange = function (e) {
        // Creamos el objeto de la clase FileReader
        let reader = new FileReader();
        // Leemos el archivo subido y se lo pasamos a nuestro fileReader
        reader.readAsDataURL(e.target.files[0]);
        // Le decimos que cuando este listo ejecute el código interno
        reader.onload = function () {
            document.getElementById("foto").src = reader.result;
        };
    };
}
function actualizar() {
   $("#formulario2").submit(function (e) {
        e.preventDefault(); // Evitamos que salte el enlace.
        //Recogemos los datos del formulario
        var paqueteDeDatos = new FormData();
        paqueteDeDatos.append('cod', $('#cod2').prop('value'));
        paqueteDeDatos.append('nombre', $('#nombre2').prop('value'));
        paqueteDeDatos.append('marca', $('#marca2').prop('value'));
        paqueteDeDatos.append('talla', $('#talla2').prop('value'));
        paqueteDeDatos.append('stock', $('#stock2').prop('value'));
        paqueteDeDatos.append('precio', $('#precio2').prop('value'));
        paqueteDeDatos.append('genero', $('#genero2').prop('value'));
        paqueteDeDatos.append('descu', $('#descu2').prop('value'));
        paqueteDeDatos.append('catego', $('#catego2').prop('value'));
        paqueteDeDatos.append('descrip', $('#descrip2').prop('value'));
     



        if (document.getElementById("img2").files.length == 0) {
            console.log("Esta vacio");
            paqueteDeDatos.append('foto', $('#foto').prop('src'));
        } else {
            console.log("Esta lleno");
            paqueteDeDatos.append('img2', $('#img2')[0].files[0]);
        }




        //console.log("actualizar");
        //console.log(paqueteDeDatos);
        $.ajax({
            url: "ProductoControl?acc=Actualizar",
            type: 'POST',
            contentType: false,
            data: paqueteDeDatos, // Al atributo data se le asigna el objeto FormData.
            processData: false,
            cache: false,

            success: function (resultado) {
                
                console.log(resultado);
                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: resultado,
                    showConfirmButton: true
                }).then((result) => {
                        if (result.isConfirmed) {
                            parent.location.href = "crudProducto.jsp";
                        }
                        });
            }
        });
    });

}