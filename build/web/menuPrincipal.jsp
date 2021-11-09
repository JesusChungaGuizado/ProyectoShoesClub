<%-- 
    Document   : menuPrincipal
    Created on : 24-oct-2021, 18:35:39
    Author     : Jesus
--%>
 
     
    
   <%@page import="vista.PedidoPresentador"%>


<div class=" container-nav">
        <nav>
              <h3>SHOES CLUB</h3>
              <div id="menu_back"></div>
                <ul id="menu">
                    <li class="list"><a class="links" href="index.jsp">Home</a></li>
                    <li class="list"><a class="links" href="ProductoControl?acc=ListaOfertas">Calzados</a></li>
                    <li class="list"><a class="links" href="contactos.jsp">Contactenos</a></li>
                    <% 
                        HttpSession ses=request.getSession();
                        if (ses.getAttribute("SesionCliente")!=null) {
                            Object[] fil = (Object[]) ses.getAttribute("SesionCliente");
                     %>
                    <li class="list  "><a class="links login" href="Menu.jsp"><i class='bx bx-user-circle bx-tada bx-flip-horizontal' ></i> <%=fil[5]%> </a>
                       
                    </li>
                    <%} else{%>
                 
                    <li class="list "><a class="links login" href="login.jsp"><i class='bx bx-user-circle bx-tada bx-flip-horizontal' ></i> Mi Cuenta</a></li>
                    
                    <%}%>
                    <li class="list car">
                      <a class="links" href="carrito.jsp">
                          <div><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" viewBox="0 0 25 25"><g id="Grupo_4953" data-name="Grupo 4953" transform="translate(-2 -2)"><path id="Trazado_6003" data-name="Trazado 6003" d="M8.579,17.213,5.974,6.789,4.816,3.316H2.658A.658.658,0,1,1,2.658,2H5.289a.658.658,0,0,1,.624.45l1.166,3.5H26.342a.657.657,0,0,1,.649.766l-1.316,7.895a.657.657,0,0,1-.541.541L9.895,17.689v1.416H25.026a.658.658,0,0,1,0,1.316H9.237a.658.658,0,0,1-.658-.658Zm16.987-9.95H7.447l2.28,9.12,14.728-2.454ZM11.211,24.368a2.632,2.632,0,1,1-2.632-2.632A2.631,2.631,0,0,1,11.211,24.368Zm15.789,0a2.632,2.632,0,1,1-2.632-2.632A2.631,2.631,0,0,1,27,24.368Z" transform="translate(0 0)" fill="#000"></path></g></svg>
                          </div>
                          <% 
                                HttpSession sess=request.getSession();
                                if (sess.getAttribute("pedPre")!=null) {
                                    PedidoPresentador pedPre = (PedidoPresentador) session.getAttribute("pedPre");
                                    %>
                                    <span><%= pedPre.getLis().size() %></span>
                           <% }%>
                          
                    </a>
                    </li>
                  </ul>
              <span id="menuIcon"  class='show bx bx-menu'></span>
        </nav>
        </div>

 <!-- Contenedor menu -->
    