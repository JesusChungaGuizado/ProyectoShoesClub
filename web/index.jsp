
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/glider-js/1.7.3/glider.min.css">
        <title>Shoes Club</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/styleIndex.css">
        <link href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css" rel="stylesheet"/>
    </head>
    <body>
         <%
             HttpSession se=request.getSession();
            if (se.getAttribute("pedPre")==null) {
                    response.sendRedirect("PedidoControl?acc=Nuevo");
                }
        %>
        <!--  Menu de Navegacion--->
        <jsp:include page="menuPrincipal.jsp" />
        <main class="main_index">
        <!-- Carrusel de Banner Principal -->
        <div class="carousel-banner">
            <div class="carousel__contenedor">
                
                <button aria-label="Anterior" class="carousel__anterior_banner">
                    <i class="fas fa-chevron-left"></i>
                </button>
                <div class="carousel__lista_banner">
                    <div class="carousel__elemento">
                        <img class="banner-img" src="img/CYBER WEEK CALIMOD - ZAPATOS PARA HOMBRE MUJER Y NINOS - DESCUENTOS - WEB.jpg" alt="">
                       
                    </div>
                    <div class="carousel__elemento">
                        <img class="banner-img" src="img/CYBER WEEK ZAPATOS PARA NINAS Y NINOS - DESCUENTOS - WEB.jpg" alt="">
                      
                    </div>
                    <div class="carousel__elemento">
                        <img class="banner-img" src="img/Zapatillas Mickey Mouse para mujer - especial Disney en Calimod Store - Web_Desktop.jpg" alt="">
                    
                    </div>
                   
                </div>
                <button aria-label="Siguiente" class="carousel__siguiente_banner">
                    <i class="fas fa-chevron-right"></i>
                </button>
            </div>
            <div role="tablist" class="carousel__indicadores_banner"></div>
    
        </div>
        <!-- Carrusel de Ofertas Zapatillas -->
        <div id="ofertas" class="carousel container">
            <h1 class="recomendaciones">OFERTAS ESPECIALES</h1>
            <div class="carousel__contenedor">
                
                <button aria-label="Anterior" class="carousel__anterior">
                    <i class="fas fa-chevron-left"></i>
                </button>
                <div id="carrusel-Ofertas" class="carousel__lista ">
                   <template id="template-ofertas">
                       <div class="carousel__elemento" style="width: 360px">
                            <div class="cards-product-item">
                              <a href="details_Product.html">
                                <span class="desc">-25%</span>
                                <img class="img-oferta" src="img/1UCK0020019_1.jpg" />
                                <div class="product-item-detail">
                                  <span class="marca" >CALIMOD</span>
                                  <h4 class="nombre">Zapatilla Urbana Negro 1UEM001</h4>
                                  <h3 class="pre-normal">S/279.80</h3>
                                </div>
                              </a>
                            </div>
                        </div>
                            
                        </template>
                    
                </div>
                <button aria-label="Siguiente" class="carousel__siguiente">
                    <i class="fas fa-chevron-right"></i>
                </button>
            </div>
            <div role="tablist" class="carousel__indicadores"></div>
    
        </div>
        <!-- Footer -->
          <jsp:include page="footer.jsp" />
    </main>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
     <script src="js/Producto.js"></script>
    <script src="js/efectos.js"></script>
    <script src="js/carrusel.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/glider-js/1.7.3/glider.min.js"></script>
    </body>
</html>
