$(document).ready(function () {
    ValidarSesion();
    VerDatos();
    ListarPedidos();
    ListarConsultas();
    cargaListadoEmpleados();
    registrarEmpleado();
    updateEmpleado();
    cargaListadoClientes();
    registrarCliente();
    updateCliente();
    cambiarColorEstado();
    filtro("lista-pedidos");
     filtro("tabla-empleado");
     filtro("tabla-cliente");
      filtro("lista-consulta");
    abrirModal();
    var btn_exportar=document.getElementById("export");
    btn_exportar.addEventListener("click",()=>print());
});
function filtro(tabla){
    $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#"+tabla+" tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
  });
}
function abrirModal(){
    $("#myBtn").click(function () {
        $('#formulario').trigger('reset');
        $("#myModal").modal();
    });
}
function ValidarSesion(){
    var btnLogin=document.getElementById("btn-login");
    $("#login").submit(function(e){
        e.preventDefault();
        $.ajax({
            url: "AdminControl?acc=LogIn",
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
                            parent.location.href = "MenuAdmin.jsp";
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
function VerDatos(){
         $.ajax({
        type: 'GET',
        url: 'AdminControl?acc=verDatos',
        async: true,
        cache: false,
        success: function (resp) {
            var tabla_datos = document.querySelectorAll(".datosMenu");
           
            $.each(resp, function (indice, lista) {
                if (indice==0) {
                   
                    tabla_datos[indice].innerHTML="S/"+lista[0].toLocaleString('en-IN', { minimumFractionDigits: 2}); 
                }else{
                     tabla_datos[indice].innerHTML=lista[0];   
                }         
              console.log(lista);
            });
            
         
        }
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
                               text+='  <td class="operation"><a href="PedidoControl?acc=reporte&id='+lista[0]+'" role="button" class="btn btn-light " ><i class="fas fa-list"></i></a></td>';
                                text+=' <td class="operation"><div class="btn-group">';
   
                                text+=' <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown">';
                                text+='   <i class="far fa-edit"></i><span class="caret"></span>';
                                text+=' </button>';
                                text+=' <div class="dropdown-menu">';
                                text+='   <a class="dropdown-item" href="AdminControl?acc=pagar&id='+lista[0]+'">Pago</a>';
//                                 text+='  <a class="dropdown-item" href="#">Cancelar</a>';
                               text+='  </div>';
                                text+=' </div></td>  ';
                           text+='  </tr>';
            });
            tabla_products.innerHTML=text;
         cambiarColorEstado()
        }
    }); 
}
function ListarConsultas(){
         $.ajax({
        type: 'GET',
        url: 'AdminControl?acc=listarConsultas',
        async: true,
        cache: false,
        success: function (resp) {
            var tabla_products = document.getElementById("lista-consulta");
            var text="";
            $.each(resp, function (indice, lista) {
                          text+='  <tr class="table-light">';
                             text+='    <td class="codigo">'+lista[0]+'</td>';
                             text+='    <td class="nombre">'+lista[1]+'</td>';
                              text+='   <td>'+lista[2]+'</td>';
                              text+='   <td>'+lista[3]+'</td>';
                              text+='   <td>'+lista[4]+'</td>';
                              text+='   <td>'+lista[5]+'</td>';
                               text+='  <td class="operation"><button type="button" class="btn btn-danger delete"><i class="far fa-trash-alt"></i></button></td>';
                           text+='  </tr>';
            });
            tabla_products.innerHTML=text;
            eliminarConsulta();
        }
    }); 
}
function eliminarConsulta() {
    var botones = document.querySelectorAll(".delete");
    $.each(botones, function (indice, lista) {
        lista.addEventListener("click", (e) => {
            var id = document.querySelectorAll(".codigo")[indice];
            var nombre = document.querySelectorAll(".nombre")[indice];
            var dato = "id=" + id.innerHTML;
            //console.log(id.innerHTML);
            Swal.fire({
                title: 'Are you sure?',
                text: "Se eliminará la consulta de " + nombre.innerHTML + "!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        url: "AdminControl?acc=EliminarConsulta",
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
                                    parent.location.href = "crudConsultas.jsp";
                                }
                            });
                        }
                    });

                }
            });

        });
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
function cargaListadoEmpleados() {
    $.ajax({
        type: 'GET',
        url: 'AdminControl?acc=listarEmpleados',
        async: true,
        cache: false,
        success: function (resp) {
            var tabla_empleados = document.querySelector("#tabla-empleado");
            var template = document.querySelector("#template-empleado").content;
            var fragment = document.createDocumentFragment();
            console.log(template);
            $.each(resp, function (indice, lista) {
                //console.log(lista)
                template.querySelectorAll('td')[0].textContent = lista[0];
                template.querySelectorAll('td')[1].textContent = lista[1];
                template.querySelectorAll('td')[2].textContent = lista[2];
                template.querySelectorAll('td')[3].textContent = lista[3];
                template.querySelectorAll('td')[4].textContent = lista[4];
                template.querySelectorAll('td')[5].textContent = lista[5];
                template.querySelectorAll('td')[6].textContent = lista[6];
                template.querySelectorAll('td')[7].textContent = lista[7];
                template.querySelectorAll('td')[8].textContent = lista[8];
                var clone = template.cloneNode(true);
                fragment.appendChild(clone);
            });
            tabla_empleados.appendChild(fragment);
            eliminarEmpleado();
            buscarEmpleado();
           
        }
    });
}
function registrarEmpleado(){
     var btnRegistro=document.getElementById("guardar");
    $("#formulario-registro").submit(function(e){
        e.preventDefault();
        $.ajax({
            url: "AdminControl?acc=RegistrarEmpleado",
            type: 'POST',
            data: $("#formulario-registro").serialize(), // Al atributo data se le asigna el objeto FormData.
            success: function (resultado) {
                if (resultado=="Registro Exitoso"){
                    $("#registro").trigger('reset');
                     Swal.fire(
                        'Successful!',
                         resultado,
                        'success'
                      ).then((result) => {
                        if (result.isConfirmed) {
                            parent.location.href = "crudEmpleado.jsp";
                        }
                        });
                }
                console.log(resultado);
            }
        });
    });
}
function buscarEmpleado() {
    var botones = document.querySelectorAll(".update");
    $.each(botones, function (indice, lista) {
        lista.addEventListener("click", (e) => {
            var id = document.querySelectorAll(".codigo")[indice];
            var dato = "id=" + id.innerHTML;
            $.ajax({
                url: "AdminControl?acc=BuscarEmpleado",
                type: 'POST',
                data: dato,
                success: function (resultado) {
                    console.log(resultado);
                    $("#myModal2").modal();
                    document.getElementById("cod2").value = resultado.idUsuario;
                    document.getElementById("nombre2").value = resultado.nombre;
                    document.getElementById("email2").value = resultado.email;
                    document.getElementById("cel2").value = resultado.celular;
                    document.getElementById("dni2").value = resultado.dni;
                    document.getElementById("dir2").value = resultado.direccion;
                    document.getElementById("usu2").value = resultado.usuario;
                    document.getElementById("pass2").value = resultado.password;
                    document.getElementById("cargo2").value = resultado.cargo;
                
                    
                }
            });
        });
    });
}
function updateEmpleado(){
     var btnRegistro=document.getElementById("actualizar");
    $("#formulario-update").submit(function(e){
        e.preventDefault();
        $.ajax({
            url: "AdminControl?acc=ActualizarEmpleado",
            type: 'POST',
            data: $("#formulario-update").serialize(), // Al atributo data se le asigna el objeto FormData.
            success: function (resultado) {
                  Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: resultado,
                    showConfirmButton: true
                }).then((result) => {
                        if (result.isConfirmed) {
                            parent.location.href = "crudEmpleado.jsp";
                        }
                        });
                console.log(resultado);
            }
        });
    });
}
function eliminarEmpleado() {
    var botones = document.querySelectorAll(".delete");
    $.each(botones, function (indice, lista) {
        lista.addEventListener("click", (e) => {
            var id = document.querySelectorAll(".codigo")[indice];
            var nombre = document.querySelectorAll(".nombre")[indice];
            var dato = "id=" + id.innerHTML;
            //console.log(id.innerHTML);
            Swal.fire({
                title: 'Are you sure?',
                text: "Se eliminará al empleado " + nombre.innerHTML + "!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        url: "AdminControl?acc=DeleteEmpleado",
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
                                    parent.location.href = "crudEmpleado.jsp";
                                }
                            });
                        }
                    });

                }
            });

        });
    });
}
function cargaListadoClientes() {
    $.ajax({
        type: 'GET',
        url: 'AdminControl?acc=listarClientes',
        async: true,
        cache: false,
        success: function (resp) {
            var tabla_cliente = document.querySelector("#tabla-cliente");
            var template = document.querySelector("#template-cliente").content;
            var fragment = document.createDocumentFragment();
            console.log(template);
            $.each(resp, function (indice, lista) {
                //console.log(lista)
                template.querySelectorAll('td')[0].textContent = lista[0];
                template.querySelectorAll('td')[1].textContent = lista[1];
                template.querySelectorAll('td')[2].textContent = lista[2];
                template.querySelectorAll('td')[3].textContent = lista[3];
                template.querySelectorAll('td')[4].textContent = lista[4];
                template.querySelectorAll('td')[5].textContent = lista[5];
                template.querySelectorAll('td')[6].textContent = lista[6];
                var clone = template.cloneNode(true);
                fragment.appendChild(clone);
            });
            tabla_cliente.appendChild(fragment);
            eliminarCliente();
            buscarCliente();
           
        }
    });
}
function registrarCliente(){
     var btnRegistro=document.getElementById("guardarCliente");
    $("#formulario-registro-cliente").submit(function(e){
        e.preventDefault();
        $.ajax({
            url: "AdminControl?acc=RegistrarCliente",
            type: 'POST',
            data: $("#formulario-registro-cliente").serialize(), // Al atributo data se le asigna el objeto FormData.
            success: function (resultado) {
                if (resultado=="Registro Exitoso"){
                    $("#formulario-registro-cliente").trigger('reset');
                     Swal.fire(
                        'Successful!',
                         resultado,
                        'success'
                      ).then((result) => {
                        if (result.isConfirmed) {
                            parent.location.href = "crudClientes.jsp";
                        }
                        });
                }
                console.log(resultado);
            }
        });
    });
}
function buscarCliente() {
    var botones = document.querySelectorAll(".update");
    $.each(botones, function (indice, lista) {
        lista.addEventListener("click", (e) => {
            var id = document.querySelectorAll(".codigo")[indice];
            var dato = "id=" + id.innerHTML;
            $.ajax({
                url: "AdminControl?acc=BuscarCliente",
                type: 'POST',
                data: dato,
                success: function (resultado) {
                    console.log(resultado);
                    $("#myModal2").modal();
                    document.getElementById("cod2").value = resultado.idUsuario;
                    document.getElementById("nombre2").value = resultado.nombre;
                    document.getElementById("email2").value = resultado.email;
                    document.getElementById("cel2").value = resultado.celular;
                    document.getElementById("dir2").value = resultado.direccion;
                    document.getElementById("usu2").value = resultado.usuario;
                    document.getElementById("pass2").value = resultado.password;
                    
                
                    
                }
            });
        });
    });
}
function updateCliente(){
     var btnRegistro=document.getElementById("actualizarCliente");
    $("#formulario-update-cliente").submit(function(e){
        e.preventDefault();
        $.ajax({
            url: "AdminControl?acc=ActualizarCliente",
            type: 'POST',
            data: $("#formulario-update-cliente").serialize(), // Al atributo data se le asigna el objeto FormData.
            success: function (resultado) {
                  Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: resultado,
                    showConfirmButton: true
                }).then((result) => {
                        if (result.isConfirmed) {
                            parent.location.href = "crudClientes.jsp";
                        }
                        });
                console.log(resultado);
            }
        });
    });
}
function eliminarCliente() {
    var botones = document.querySelectorAll(".delete");
    $.each(botones, function (indice, lista) {
        lista.addEventListener("click", (e) => {
            var id = document.querySelectorAll(".codigo")[indice];
            var nombre = document.querySelectorAll(".nombre")[indice];
            var dato = "id=" + id.innerHTML;
            //console.log(id.innerHTML);
            Swal.fire({
                title: 'Are you sure?',
                text: "Se eliminará al cliente " + nombre.innerHTML + "!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        url: "AdminControl?acc=DeleteCliente",
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
                                    parent.location.href = "crudClientes.jsp";
                                }
                            });
                        }
                    });

                }
            });

        });
    });
}