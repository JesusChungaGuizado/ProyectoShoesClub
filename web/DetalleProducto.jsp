<%-- 
    Document   : calzados
    Created on : 24-oct-2021, 19:09:06
    Author     : Jesus
--%>

<%@page import="java.util.Locale"%>
<%@page import="negocio.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>DetailsProduct</title>
        <link rel="stylesheet" href="css/style.css">
        <link
        href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css"
        rel="stylesheet" />
    </head>
    <body>
        <% Producto pro=(Producto)session.getAttribute("detalle"); %>
          <jsp:include page="menuPrincipal.jsp" />
         <main class="main-producto" >
        <section class="container details-product">
            <figure class="image">
              <img  src="<%=pro.getImagen() %>" alt="">
            </figure>
            <div class="details">
                <h2><%=pro.getMarca()%></h2>
               <div>
                <p><%=pro.getNombre()%></p>
                <span>STOCK: <%=pro.getStock()%></span>
               </div>
               
                <div>
                    <% if (pro.getOferta()!=0) {%>
                               <span class="desc">S/ <%= String.format(Locale.ROOT,"%.2f", pro.getPrecioNormal())%></span>
                    <% }%>  
                   
                    <div class="precio">
                        <h3 >S/ <%= String.format(Locale.ROOT,"%.2f",pro.getPrecioOferta() )%> </h3>
                        <% if (pro.getOferta()!=0) {%>
                               <span>-<%=pro.getDescuento() %>%</span>
                        <% }%> 
                    </div>
                </div>
                 <div class="descripcion">
                    <h5>Descripción</h5>
                    <p ><%=pro.getDescripcion()%></p>
                </div>
                <h4>Talla</h4>
                <section class="tallas">
                    <div class="item"><%=pro.getTalla() %></div>
                    
                </section>
                <a class="btn-boton" href="PedidoControl?acc=Agregar&id=<%= pro.getIdProducto() %>"><i class='bx bxs-cart-add' ></i> AGREGAR A CARRITO</a>
            </div>
        </section>
        <section class=" info">
            
               <div class="info-item">
                <div>
                    <svg id="Grupo_3293" data-name="Grupo 3293" xmlns="http://www.w3.org/2000/svg" width="65.835" height="37.057" viewBox="0 0 65.835 37.057"><path id="Trazado_4497" data-name="Trazado 4497" d="M20.214,26.878a3.131,3.131,0,0,0-3.02,3.2v3H15.172a.533.533,0,0,0-.072,0,.787.787,0,0,0-.727.837.779.779,0,0,0,.8.765H30.487a.8.8,0,0,0,.021-1.6H18.715v-3a1.542,1.542,0,0,1,1.5-1.6H44.9a1.542,1.542,0,0,1,1.5,1.6v1.452a.619.619,0,0,0,0,.075V56.072a1.493,1.493,0,0,1-1.5,1.552H37.407a5.685,5.685,0,0,0-4.423-5.157c-.153-.032-.317-.083-.476-.1h-.047a5.129,5.129,0,0,0-.524-.025,5.638,5.638,0,0,0-5.469,5.283H20.214a1.493,1.493,0,0,1-1.5-1.553V48.059h4.138a.8.8,0,0,0,.021-1.6H7.516a.8.8,0,0,0-.021,1.6h9.7v8.012a3.092,3.092,0,0,0,3.02,3.155H26.54a5.449,5.449,0,0,0,10.8,0H54.5a5.449,5.449,0,0,0,10.8,0h4.257a3.1,3.1,0,0,0,3.02-3.155V44.379a2.745,2.745,0,0,0-2.568-2.854L59.832,31.034a.74.74,0,0,0-.547-.225H47.918v-.727a3.131,3.131,0,0,0-3.02-3.2H20.214Zm27.7,5.533H59l8.751,9.038-19.832.025V32.41ZM11.272,39.772a.788.788,0,0,0-.727.838.779.779,0,0,0,.8.765H26.658a.8.8,0,0,0,.021-1.6H11.272Zm58.214,3.28a.733.733,0,0,0,.119,0,1.551,1.551,0,0,1,1.07.376,1.185,1.185,0,0,1,.38.951V56.072a1.488,1.488,0,0,1-1.5,1.553H65.372a5.686,5.686,0,0,0-4.423-5.158c-.153-.031-.317-.082-.476-.1h-.047c-.174-.017-.345-.025-.524-.025a5.638,5.638,0,0,0-5.469,5.283h-6.92A3.153,3.153,0,0,0,47.8,56.9c.018-.057.033-.117.047-.175,0-.015,0-.034,0-.05a2.672,2.672,0,0,0,.072-.6V43.077l21.569-.025ZM31.937,53.968a4.175,4.175,0,1,1-3.948,4.157c0-.145.011-.285.024-.426a4.181,4.181,0,0,1,1.712-3.029,3.92,3.92,0,0,1,1.023-.526,3.738,3.738,0,0,1,.4-.1,3.671,3.671,0,0,1,.785-.075Zm27.965,0a4.028,4.028,0,0,1,3.947,4.157c0,.085.005.167,0,.25,0,.034,0,.067,0,.1a3.952,3.952,0,0,1-7.895.1.135.135,0,0,0,0-.025c0-.017,0-.034,0-.05a.685.685,0,0,0,0-.125,2.241,2.241,0,0,1,0-.251,4.212,4.212,0,0,1,1.737-3.455,3.775,3.775,0,0,1,1.022-.526,3.67,3.67,0,0,1,1.189-.175Z" transform="translate(-6.744 -26.877)" fill="#757577"></path></svg>
                </div>
                <span class="info-text">Envío a Lima y a provincias.</span>
               </div>
                <div class="info-item">
                    <div>
                        <svg id="Grupo_3292" data-name="Grupo 3292" xmlns="http://www.w3.org/2000/svg" width="40.521" height="47.65" viewBox="0 0 40.521 47.65"><path id="Trazado_4464" data-name="Trazado 4464" d="M4.619,52.156a3.332,3.332,0,0,0,2.674,1.456H40.721c1.959,0,3.546-1.9,3.547-4.24a5.181,5.181,0,0,0-.034-.585L40.486,16.462A3.843,3.843,0,0,0,36.973,12.8H11.043a3.842,3.842,0,0,0-3.513,3.659L3.781,48.787A4.824,4.824,0,0,0,4.619,52.156Zm1.143-3.04L9.511,16.792a1.675,1.675,0,0,1,1.532-1.6h25.93A1.674,1.674,0,0,1,38.5,16.791l3.748,32.325A1.82,1.82,0,0,1,40.932,51.2a1.248,1.248,0,0,1-.211.018H7.293a1.718,1.718,0,0,1-1.546-1.848,2.176,2.176,0,0,1,.015-.255Z" transform="translate(-3.747 -5.961)" fill="#757577"></path><path id="Trazado_4465" data-name="Trazado 4465" d="M24.7,6.576A.58.58,0,0,0,25.285,6h0V5.714a4.629,4.629,0,1,0-9.258,0V6a.581.581,0,1,0,1.161,0V5.714a3.468,3.468,0,0,1,6.936,0V6a.58.58,0,0,0,.58.581Z" transform="translate(-0.396 -1.085)" fill="#757577"></path></svg>
                    </div>
                    <span class="info-text">Comprar es fácil.</span>
                </div>
              <div class="info-item">
                <div>
                    <svg id="Grupo_1804" data-name="Grupo 1804" xmlns="http://www.w3.org/2000/svg" width="45.47" height="39.523" viewBox="0 0 45.47 39.523"><path id="Trazado_96" data-name="Trazado 96" d="M151.439,192.837h-3.524v-16.8a5.948,5.948,0,0,0,3.391-2.6,6.074,6.074,0,0,0,.341-5.752l-4.488-9.671-.792-1.706A2.263,2.263,0,0,0,144.321,155h-7.182a.782.782,0,0,0-.3,0H122.113a.782.782,0,0,0-.3,0h-7.179a2.293,2.293,0,0,0-2.046,1.307l-5.274,11.378a6.075,6.075,0,0,0,.342,5.75,5.967,5.967,0,0,0,2.529,2.268,5.9,5.9,0,0,0,.862.334v16.8h-3.513a.781.781,0,0,0,0,1.562h43.3v.1a.838.838,0,0,0,.065-.1h.544a.781.781,0,1,0,0-1.562Zm-21.171-34.829v-1.449h6.12l.374,1.449,3.1,12.033a4.8,4.8,0,0,1-9.594.107Zm-20.592,15.47a4.562,4.562,0,0,1-.688-.866,4.515,4.515,0,0,1-.256-4.274l5.274-11.378a.7.7,0,0,1,.628-.4h6.318l-.372,1.449-3.005,11.7a.772.772,0,0,0-.043.246,4.819,4.819,0,0,1-4.8,4.753c-.056,0-.111,0-.167,0A4.288,4.288,0,0,1,109.676,173.478Zm13.89,19.359H112.61V176.27l.12,0a6.384,6.384,0,0,0,5.585-3.307,6.383,6.383,0,0,0,5.25,3.3Zm.335-18.128a4.819,4.819,0,0,1-4.8-4.659l3.093-12.043.372-1.449H128.7v13.451c0,.018,0,.036,0,.054A4.781,4.781,0,0,1,123.9,174.709Zm22.452,18.128H125.128V176.154a6.328,6.328,0,0,0,3.2-1.679,6.4,6.4,0,0,0,1.148-1.505,6.371,6.371,0,0,0,11.166-.005,6.38,6.38,0,0,0,5.585,3.308l.119,0Zm.046-18.131c-.055,0-.11,0-.165,0a4.819,4.819,0,0,1-4.8-4.753v-.012c0-.016,0-.031,0-.046s0-.024,0-.036,0-.024-.006-.037-.006-.029-.009-.044l0-.013-3.031-11.762L138,156.558h6.319a.7.7,0,0,1,.628.4l.487,1.048,4.793,10.329a4.515,4.515,0,0,1-.255,4.276A4.311,4.311,0,0,1,146.4,174.706Z" transform="translate(-106.75 -154.981)" fill="#4f4f51"></path><path id="Trazado_97" data-name="Trazado 97" d="M131.989,211.511a.781.781,0,0,0,.781-.781V206.3a.781.781,0,1,0-1.562,0v4.433A.781.781,0,0,0,131.989,211.511Z" transform="translate(-118.529 -179.319)" fill="#4f4f51"></path></svg>
                </div>
                <span class="info-text">Entregas garantizadas.</span>
              </div>
            
        </section>
              <!-- Footer -->
          <jsp:include page="footer.jsp" />
         </main>
    <script src="js/efectos.js"></script>
    </body>
</html>
