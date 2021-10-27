<%-- 
    Document   : calzados
    Created on : 24-oct-2021, 19:09:06
    Author     : Jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Mi carrito</title>
        <link rel="stylesheet" href="css/style.css">
        <link
        href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css"
        rel="stylesheet"
      />
    </head>
    <body class="fondo-body">
          <jsp:include page="menuPrincipal.jsp" />
       <section class="carrito_header">
        <h1>Carrito de Compras</h1>
        <a href="producto.jsp" ><i class='bx bx-left-arrow-alt bx-tada bx-flip-vertical' ></i>Seguir Comprando</a>
    </section>
    <!-- Seccion listado productos carrito -->
      <main class="container-carrito">
            <section class=" container carrito_body">
                <section class="carrito-list">
                    <table>
                        <thead>
                            <tr>
                                <td></td>
                                <td>Precio</td>
                                <td>Cantidad</td>
                                <td>Importe</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="carrito-list-item">
                                <td>
                                    <div class="imagen">
                                        <img src="img/1UCC0020026_1.jpg" alt="">
                                        <span class="nombre">Zapato Casual Rat</span>
                                        <span class="codigo">SKU:1UCK0020020</span>
                                    </div>
                                </td>
                                <td>S/ 197.40</td>
                                <td >
                                    <div class="cantidad">
                                        <button class="boton">-</button>
                                        <p>1</p>
                                        <button class="boton">+</button>
                                    </div>
                                </td>
                                <td>S/ 197.40</td>
                                <td><a class="link-delete" href=""><i class='bx bxs-trash'></i> Eliminar</a></td>
                            </tr>
                            <tr class="carrito-list-item">
                                <td>
                                    <div class="imagen">
                                        <img src="img/1UCC0020026_1.jpg" alt="">
                                        <span class="nombre">Zapato Casual Rat</span>
                                        <span class="codigo">SKU:1UCK0020020</span>
                                    </div>
                                </td>
                                <td>S/ 197.40</td>
                                <td >
                                    <div class="cantidad">
                                        <button class="boton">-</button>
                                        <p>1</p>
                                        <button class="boton">+</button>
                                    </div>
                                </td>
                                <td>S/ 197.40</td>
                                <td><a class="link-delete" href=""><i class='bx bxs-trash'></i> Eliminar</a></td>
                            </tr>
                            <tr class="carrito-list-item">
                                <td>
                                    <div class="imagen">
                                        <img src="img/1UCC0020026_1.jpg" alt="">
                                        <span class="nombre">Zapato Casual Rat</span>
                                        <span class="codigo">SKU:1UCK0020020</span>
                                    </div>
                                </td>
                                <td>S/ 197.40</td>
                                <td >
                                    <div class="cantidad">
                                        <button class="boton">-</button>
                                        <p>1</p>
                                        <button class="boton">+</button>
                                    </div>
                                </td>
                                <td>S/ 197.40</td>
                                <td><a class="link-delete" href=""><i class='bx bxs-trash'></i> Eliminar</a></td>
                            </tr>
                            <tr class="carrito-list-item">
                                <td>
                                    <div class="imagen">
                                        <img src="img/1UCC0020026_1.jpg" alt="">
                                        <span class="nombre">Zapato Casual Rat</span>
                                        <span class="codigo">SKU:1UCK0020020</span>
                                    </div>
                                </td>
                                <td>S/ 197.40</td>
                                <td >
                                    <div class="cantidad">
                                        <button class="boton">-</button>
                                        <p>1</p>
                                        <button class="boton">+</button>
                                    </div>
                                </td>
                                <td>S/ 197.40</td>
                                <td><a class="link-delete" href=""><i class='bx bxs-trash'></i> Eliminar</a></td>
                            </tr>
                            
                        </tbody>
    
                    </table>
                </section>
                <section class="carrito-resumen">
                    <h2>Resumen de Compra</h2>
                        <div class="total">
                            <span>Subtotal</span>
                            <span>S/987.00</span>
                        </div>
                        <div class="total">
                            <span>Total</span>
                            <span>S/987.00</span>
                        </div>
                    <span class="btn-boton">Generar Compra</span>
                </section>
            </section>
            <!-- Footer -->
          <jsp:include page="footer.jsp" />
      </main>
      <script src="js/efectos.js"></script>
    </body>
</html>
