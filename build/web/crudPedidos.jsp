<%-- 
    Document   : crudPedidos
    Created on : 05-nov-2021, 12:04:20
    Author     : Jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                            <h1>Pedidos</h1>
                        </div>
                        <div class="header-actions">
                            <button id="export">
                                <span  class="far fa-file-pdf" ></span>
                                Export PDF
                            </button>
                        </div>
                    </div>
                   <div class="botones-crud">
                       <input class="form-control mb-3" id="myInput" type="text" placeholder="Search..">
                   </div>
                   
            
            <div class="row">

                <div class="col-sm-12 title-report">
                    <table class="table table-hover table-light">
                        <thead >
                            <tr >
                                <th>idPedidos</th>
                                <th>Fecha</th>
                                <th>Total(S/)</th>
                                <th>Usuario</th>
                                <th>Celular</th>
                                <th>Estado</th>
                                
                                <th class="operation">Ver Detalle</th>
                                <th class="operation">Estado</th>
                                
                                 
                            </tr>
                        </thead>
                        <tbody id="lista-pedidos" >

                           
                          
                        </tbody>
                    </table>
                </div>
            </div>
               </main>
            </div>
    </body>
       
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
         <script src="js/efectoNavAdmin.js"></script>
        <script src="js/Admin.js"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</html>
