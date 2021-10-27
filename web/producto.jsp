<%-- 
    Document   : catados
    Created on : 24-oct-2021, 19:09:06
    Author     : Jesus
--%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Calzados</title>
        <link rel="stylesheet" href="css/style.css" />
        <link
          href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css"
          rel="stylesheet"
        />
    </head>
    <body>
          <jsp:include page="menuPrincipal.jsp" />
          <main class="main-producto">
              <% List producto=(List)session.getAttribute("producto"); %>
      <div class="container container-products">
        <!-- SECCION CATEGORIAS -->
        <section class="container-category">
          <ul>
            <li class="cat-item">
              <div class="cat-item-header">
                <h4>Hombre</h4>
                <i class="bx bx-chevron-right bx-tada bx-rotate-90"></i>
              </div>
              <ul class="cat-item-chield">
                <li><a href="ProductoControl?acc=filter&sexo=M&cat=1">Zapatos</a></li>
                <li><a href="ProductoControl?acc=filter&sexo=M&cat=2">Sandalias</a></li>
                <li><a href="ProductoControl?acc=filter&sexo=M&cat=3">Zapatillas</a></li>
                <li><a href="ProductoControl?acc=filter&sexo=M&cat=4">Botines</a></li>
              </ul>
            </li>
            <li class="cat-item">
              <div class="cat-item-header">
                <h4>Mujer</h4>
                <i class="bx bx-chevron-right bx-tada bx-rotate-90"></i>
              </div>
              <ul class="cat-item-chield">
                <li><a href="ProductoControl?acc=filter&sexo=F&cat=1">Zapatos</a></li>
                <li><a href="ProductoControl?acc=filter&sexo=F&cat=2">Sandalias</a></li>
                <li><a href="ProductoControl?acc=filter&sexo=F&cat=3">Zapatillas</a></li>
                <li><a href="ProductoControl?acc=filter&sexo=F&cat=4">Botines</a></li>
              </ul>
            </li>
            <li class="cat-item">
              <div class="cat-item-header">
                <h4>Niños</h4>
                <i class="bx bx-chevron-right bx-tada bx-rotate-90"></i>
              </div>
              <ul class="cat-item-chield">
                <li><a href="ProductoControl?acc=filter&sexo=N&cat=1">Zapatos</a></li>
                <li><a href="ProductoControl?acc=filter&sexo=N&cat=2">Sandalias</a></li>
                <li><a href="ProductoControl?acc=filter&sexo=N&cat=3">Zapatillas</a></li>
                <li><a href="ProductoControl?acc=filter&sexo=N&cat=4">Botines</a></li>
              </ul>
            </li>
          </ul>
        </section>
        <!-- SECCION CARDS DE PRODUCTOS -->
        <section class="cards-product">
           <% if(producto.size()!=0){%>
            <% for (int i = 0; i < producto.size(); i++) {
                 Object[] lista=(Object[])producto.get(i);%>
                <% int oferta=(int)lista[8] ;%>
                   
                <div class="cards-product-item">
                    
                    <a href="ProductoControl?acc=view&id=<%=lista[0]%>">
                        <% if (oferta!=0) {%>
                               <span class="desc">-<%= lista[8] %>%</span>
                           <% }
                        %>  
                     
                      <img src="<%= lista[5] %>" />
                      <div class="product-item-detail">
                          <div>
                              <span><%= lista[2] %></span>
                               <h4><%= lista[1] %></h4>
                              </div>
                              <div>
                                   <% if (oferta!=0) {%>
                                        <p>S/<%= String.format(Locale.ROOT,"%.2f", (double)lista[4] )%></p>
                                    <% } %>  
                                    <h3>S/<%= String.format(Locale.ROOT,"%.2f", (double)lista[9] )%></h3>
                              </div>
                      </div>
                    </a>
                </div>
             <%   }
            }else{%> 
            <h4 style="text-align: center ;width: 400px;font-size: 2rem" >No se encontraron resultados </h4>
            <%  } %> 
        </section>
      </div>
               <!-- Footer -->
          <jsp:include page="footer.jsp" />
         
    </main>
    <script src="js/efectos.js"></script>
    </body>
</html>
