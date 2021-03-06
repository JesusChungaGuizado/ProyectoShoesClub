<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Pagina Administrativa</title>
            <link
            rel="stylesheet"
            href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css"
          />
            <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
          <link rel="stylesheet" href="css/styleAdmin.css">
    </head>
    <body>
         <% if (session.getAttribute("SesionAdmin")==null) {
                response.sendRedirect("loginAdmin.jsp");
            }%>
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
                    <div class="page-header mb-3">
                        <div>
                            <h1>Clientes</h1>
                        </div>
                        <div class="header-actions">
                            <button id="export">
                                <span  class="far fa-file-pdf" ></span>
                                Export PDF
                            </button>
                        </div>
                    </div>
                   <div class="botones-crud">
                       <button type="button" class="btn btn-primary mb-3" id="myBtn"><img src="img/plus.svg">A??adir Cliente</button>
                       <input class="form-control mb-3" id="myInput" type="text" placeholder="Search..">
                   </div>
                     <!-- The Modal de Regsitro -->
                     <div class="modal fade" id="myModal">
                         <div class="modal-dialog">
                             <div class="modal-content">

                                 <!-- Modal Header -->
                                 <div class="modal-header">
                                     <h4 class="modal-title">Registrar Clientes</h4>
                                     <button type="button" class="close" data-dismiss="modal">??</button>
                                 </div>

                                 <!-- Modal body -->
                                 <div class="modal-body">
                                     <form id="formulario-registro-cliente" class="container-inputs2"   method="POST" >
                                         
                                             <input type="hidden" id="cod" name="cod"  class="form-control mb-3" value="" >
                                             <div class="input-item" >
                                                 <label class="label-input" for="nombre">Nombre</label>
                                                <input type="text" id="nombre" name="nombre" minlength="3" class="form-control mb-3"  required="true"  >
                                             </div>
                                             <div class="input-item">
                                                <label  class="label-input" for="email">Email</label>
                                                <input type="email" id="email" name="email"  class="form-control mb-3"  required="true" >
                                             </div>
                                       
                                        
                                             <div class="input-item">
                                                <label  class="label-input" for="cel">Celular</label>
                                                <input type="tel" id="cel" name="cel"  pattern="[0-9]{9}" class="form-control mb-3"   required="true" >
                                             </div>
                                              <div class="input-item">
                                                <label  class="label-input" for="usu">Usuario</label>
                                                <input type="text" id="usu" name="usu" minlength="3"  class="form-control mb-3"   required="true" >
                                              </div>
                                         <div class="input-item">
                                                <label  class="label-input" for="pass">Contrase??a</label>
                                                <input type="password" id="pass" name="pass" minlength="6"  class="form-control mb-3"   required="true" >
                                              </div>
                                         
                                              <div class="input-item">
                                                <label  class="label-input" for="dir">Direcci??n</label>
                                                <input type="text" id="dir" name="dir" minlength="3"  class="form-control mb-3"   required="true" >
                                              </div>
                                            
                                          
                                             
                                         <button type="submit" class="btn btn-primary"  id="guardarCliente" >Registrar</button>


                                     </form> 
                                 </div>
                             </div>
                         </div>
                     </div>
                <!-- The Modal  de Actualizar-->
                <div class="modal fade" id="myModal2">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Actualizar Cliente</h4>
                                <button type="button" class="close" data-dismiss="modal">??</button>
                            </div>

                            <!-- Modal body -->
                            <div class="modal-body">
                              
                                <form id="formulario-update-cliente" class="container-inputs2"   method="POST" >
                                         
                                             <input type="hidden" id="cod2" name="cod"  class="form-control mb-3" value="" >
                                             <div class="input-item" >
                                                 <label class="label-input" for="nombre">Nombre</label>
                                                <input type="text" id="nombre2" name="nombre" minlength="3" class="form-control mb-3"  required="true"  >
                                             </div>
                                             <div class="input-item">
                                                <label  class="label-input" for="email">Email</label>
                                                <input type="email" id="email2" name="email"  class="form-control mb-3"  required="true" >
                                             </div>
                                       
                                        
                                             <div class="input-item">
                                                <label  class="label-input" for="cel">Celular</label>
                                                <input type="tel" id="cel2" name="cel" pattern="[0-9]{9}"  class="form-control mb-3"   required="true" >
                                             </div>
                                            <div class="input-item">
                                                <label  class="label-input" for="usu">Usuario</label>
                                                <input type="text" id="usu2" name="usu" minlength="3"  class="form-control mb-3"   required="true" >
                                              </div>
                                         <div class="input-item">
                                                <label  class="label-input" for="pass">Contrase??a</label>
                                                <input type="password" id="pass2" name="pass" minlength="6"   class="form-control mb-3"   required="true" >
                                              </div>
                                              <div class="input-item">
                                                <label  class="label-input" for="dir">Direcci??n</label>
                                                <input type="text" id="dir2" name="dir" minlength="3"  class="form-control mb-3"   required="true" >
                                              </div>
                                             
                                         
                                           
                                             
                                         <button type="submit" class="btn btn-primary"  id="actualizarCliente" >Actualizar</button>


                                     </form> 

                            </div>
                        </div>
                    </div>
                </div>
            <div class="row">

                <div class="col-sm-12 title-report">
                    <table class="table table-hover table-light">
                        <thead >
                            <tr>
                                <th>idCliente</th>
                                <th>Nombre</th>
                                <th>Email</th>
                                <th>Celular</th>
                                <th>Direcci??n</th>
                                <th>Usuario</th>
                                <th>Password</th>
                                <th colspan="2" class="operation">Operaci??n</th>
                            </tr>
                        </thead>
                        <tbody id="tabla-cliente" >

                        <template id="template-cliente">
                            <tr >
                                <td class="codigo"></td>
                                <td class="nombre"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
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
    <script src="js/Admin.js"></script>
    
                <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
             
                <script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</html>
