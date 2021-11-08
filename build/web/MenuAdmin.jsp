<%-- 
    Document   : MenuAdmin
    Created on : 01-nov-2021, 18:15:19
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
            <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
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
                   <div>
                    <h1>Analitics Dasbooard</h1>
                    <small>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Alias maiores 
                         iusto soluta quos doloremque quas.</small>
                </div>
                     <div class="cards">
                     <div class="card-single">
                    <div class="card-flex">
                        <div class="card-info">
                            <div class="card-head">
                                <span>Monto Total Ventas</span>
                                <small>Del Mes</small>
                            </div>
                            <h2>S/300.21</h2>
                            
                        </div>
                        
                        <div class="card-chart success">
                            <span class="fas fa-money-bill-alt"></span>
                        </div>
                    </div>
                </div>    
               
                <div class="card-single">
                    <div class="card-flex">
                        <div class="card-info">
                            <div class="card-head">
                                <span>Clientes</span>
                                <small>Registrados</small>
                            </div>
                            <h2>100</h2>
                          
                        </div>
                        <div class="card-chart danger">
                            <span class="far fa-user"></span>
                        </div>
                    </div>
                </div>
                <div class="card-single">
                    <div class="card-flex">
                        <div class="card-info">
                            <div class="card-head">
                                <span>Pedidos</span>
                                <small>Recientes</small>
                            </div>
                            <h2>20</h2>
                         
                        </div>
                        <div class="card-chart yellow">
                            <span class="fas fa-shopping-cart"></span>
                        </div>
                    </div>
                </div>
 <div class="card-single">
                    <div class="card-flex">
                        <div class="card-info">
                            <div class="card-head">
                                <span>Poductos</span>
                                <small>Total en inventario</small>
                            </div>
                            <h2>32</h2>
                            
                        </div>
                        <div class="card-chart yellow">
                            <span class="fas fa-box-open"></span>
                        </div>
                    </div>
     
                </div>
                          <div class="card-single">
                    <div class="card-flex">
                        <div class="card-info">
                            <div class="card-head">
                                <span>Ventas</span>
                                <small>Del Mes</small>
                            </div>
                            <h2>20</h2>
                            
                        </div>
                        <div class="card-chart success">
                            <span class="fas fa-chart-line"></span>
                        </div>
                    </div>
                </div>
                          
                        
                       
            </div>
               </main>
            </div>
           
    </body>
    <script src="js/efectoNavAdmin.js"></script>
</html>
