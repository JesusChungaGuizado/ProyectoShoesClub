<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Pagina Administrador</title>
            <link
            rel="stylesheet"
            href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css"
          />
            <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
          <link rel="stylesheet" href="css/styleAdmin.css">
    </head>
    <body>
           <jsp:include page="navAdmin.jsp" />
           <div class="main-content">
                <div class="headerp">
                    <div class="menu-toggle">
                        <label for="sidebar-toggle">
                            <span class="las la-bars"></span>
                        </label>
                    </div>
                    <div class="header-icons">
                        <span class="las la-search"></span>
                        <span class="las la-bookmark"></span>
                        <span class="las la-sms"></span>
                    </div>
                </div>
               <main>
                    <button type="button" class="btn btn-primary mb-3" id="myBtn">Añadir producto</button>

                     <!-- The Modal de Regsitro -->
                     <div class="modal fade" id="myModal">
                         <div class="modal-dialog">
                             <div class="modal-content">

                                 <!-- Modal Header -->
                                 <div class="modal-header">
                                     <h4 class="modal-title">Registrar Producto</h4>
                                     <button type="button" class="close" data-dismiss="modal">×</button>
                                 </div>

                                 <!-- Modal body -->
                                 <div class="modal-body">
                                     <form id="formulario"   method="POST" enctype="multipart/form-data">

                                         <input type="hidden" id="cod" name="cod"  class="form-control mb-3" value="" >
                                         <input type="text" id="nombre" name="nombre" minlength="3" class="form-control mb-3" placeholder="Ingrese Nombre"  required="true"  >
                                         <input type="text" id="marca" name="marca" minlength="3" class="form-control mb-3" placeholder="Ingrese Marca"  required="true" >
                                         <input type="number" id="talla" name="talla" min="0"  class="form-control mb-3" placeholder="Enter Talla"  required="true" >
                                         <input type="number" id="stock" name="stock"  min="1"  class="form-control mb-3" placeholder="Enter stock"  required="true" >
                                         <input type="number" id="precio" name="precio"  step="0.01" class="form-control mb-3" placeholder="Enter Precio"  required="true" >
                                         <div class="form-group">
                                              <select class="form-control" name="genero" id="genero"  required="true" >
                                                  <option value="" >Género...</option>
                                                  <option value="M">Hombre</option>
                                                  <option value="F">Mujer</option>
                                                  <option value="N">Niño</option>
                                               </select>    
                                          </div> 
                                         <input type="number" id="descu" min="0" max="100" name="descu" class="form-control mb-3" placeholder="Enter descuento(%)"  required="true" >
                                         <div class="form-group">
                                             <select class="form-control custom-select" name="catego" id="catego"  required="true" >
                                                 <option value="" >Categoria...</option>
                                                 <option value="1">Zapatos</option>
                                                 <option value="2">Sandalias</option>
                                                 <option value="3">Zapatillas</option>
                                                 <option value="4">Botines</option>
                                             </select>
                                         </div> 
                                         <textarea class="form-control mb-3" id="descrip" name="descrip" minlength="10" maxlength="250" rows="3" placeholder="Descripcion"  required="true" ></textarea>
                                         <div class="custom-file mb-3">
                                             <input type="file" accept=".jpg,.png" id="img" name="img" class="custom-file-input"  >
                                             <label class="custom-file-label" for="customFile">Seleccione imagen...</label>
                                         </div>
                                         <button type="submit" class="btn btn-primary"  id="guardar" >Registrar</button>


                                     </form> 
                                 </div>
                             </div>
                         </div>
                     </div>
                <!-- The Modal -->
                <div class="modal fade" id="myModal2">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Modal 2</h4>
                                <button type="button" class="close" data-dismiss="modal">×</button>
                            </div>

                            <!-- Modal body -->
                            <div class="modal-body">
                                 <form id="formulario2"   method="POST" enctype="multipart/form-data">
                                    
                                    <input type="hidden" id="cod2" name="cod"  class="form-control mb-3" value="" >
                                    <input type="text" id="nombre2" name="nombre" minlength="3" class="form-control mb-3" placeholder="Ingrese Nombre"  required="true"  >
                                    <input type="text" id="marca2" name="marca" minlength="3" class="form-control mb-3" placeholder="Ingrese Marca"  required="true" >
                                    <input type="number" id="talla2" name="talla" min="0"  class="form-control mb-3" placeholder="Enter Talla"  required="true" >
                                    <input type="number" id="stock2" name="stock"  min="1"  class="form-control mb-3" placeholder="Enter stock"  required="true" >
                                    <input type="number" id="precio2" name="precio"  step="0.01" class="form-control mb-3" placeholder="Enter Precio"  required="true" >
                                    <div class="form-group">
                                         <select class="form-control" name="genero" id="genero2"  required="true" >
                                             <option value="" >Género...</option>
                                             <option value="M">Hombre</option>
                                             <option value="F">Mujer</option>
                                             <option value="N">Niño</option>
                                          </select>    
                                     </div> 
                                    <input type="number" id="descu2" min="0" max="100" name="descu" class="form-control mb-3" placeholder="Enter descuento(%)"  required="true" >
                                    <div class="form-group">
                                        <select class="form-control custom-select" name="catego" id="catego2"  required="true" >
                                            <option value="" >Categoria...</option>
                                            <option value="1">Zapatos</option>
                                            <option value="2">Sandalias</option>
                                            <option value="3">Zapatillas</option>
                                            <option value="4">Botines</option>
                                        </select>
                                    </div> 
                                    <textarea class="form-control mb-3" id="descrip2" name="descrip" minlength="10" maxlength="250" rows="3" placeholder="Descripcion"  required="true" ></textarea>
                                    <div class="custom-file mb-3">
                                        <input type="file" accept=".jpg,.png" id="img2" name="img2" class="custom-file-input"  >
                                        <label class="custom-file-label" for="customFile">Seleccione imagen...</label>
                                    </div>
                                    <div  class="custom-file mb-3">
                                        <img id="foto" src="" width="50px" height="50px" >
                                    </div>
                                            
                                    <button type="submit" class="btn btn-primary"   id="actualizar" >Actualizar</button>
                                    

                                </form> 

                            </div>
                        </div>
                    </div>
                </div>
            <div class="row">

                <div class="col-sm-12">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>id</th>
                                <th>Imagen</th>
                                <th>Nombre</th>
                                <th>Marca</th>
                                <th>Categoria</th>
                                <th>Precio(S/)</th>
                                <th>Desc(%)</th>
                                 <th>Precio(-%)</th>
                                <th>Stock</th>
                                <th>Sexo</th>
                                 <th>Talla</th>
                                 <th>U</th>
                                 <th>D</th>
                                 
                            </tr>
                        </thead>
                        <tbody id="tabla-producto">

                        <template id="template-producto">
                            <tr >
                                <td class="codigo" >1</td>
                                <td  ><img class="image" src="" width="70px" height="70px" style="border-radius: 100%"></td>
                                <td class="nombre">Perro</td>
                                <td class="marca">Nuevo Perro</td>
                                <td class="cat">S/ 200</td>
                                <td class="prec">6</td>
                                <td class="des">9</td>
                                <td class="precioDes">S/ 200</td>
                                <td class="stock">6</td>
                                <td class="sexo">9</td>
                                <td class="talla">9</td>
                                <td><button type="button" class="btn btn-primary update" ><i class="fas fa-edit"></i></button></td>
                                <td><button type="button" class="btn btn-danger delete"><i class="far fa-trash-alt"></i></button></td>
                            </tr>
                        </template>
                        </tbody>
                    </table>
                </div>
            </div>
               </main>
            </div>
    </body>
    <script src="js/efectoNavAdmin.js"></script>
     <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="js/Producto.js"></script>
    
                <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
             
                <script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</html>
