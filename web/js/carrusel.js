//Carrusel Principal Banner
window.addEventListener("load",function(){
    new Glider(document.querySelector(".carousel__lista_banner"),{
        slidesToShow: 1,
        slidesToScroll: 1,
        draggable: true,
        dots: '.carousel__indicadores_banner',
        arrows: {
            prev: '.carousel__anterior_banner',
            next: '.carousel__siguiente_banner'
        }
        
    });
});
//Carrusel de Productos de ofertas
window.addEventListener("load",function(){
    new Glider(document.querySelector(".carousel__lista"),{
        slidesToShow: 1,
        slidesToScroll: 1,
        draggable: true,
        dots: '.carousel__indicadores',
        arrows: {
            prev: '.carousel__anterior',
            next: '.carousel__siguiente'
        },
        responsive: [
            {
                // screens greater than >= 600px
                breakpoint: 600,
                settings: {
                  // Set to `auto` and provide item width to adjust to viewport
                  slidesToShow: 2,
                  slidesToScroll: 2,
                }
              },{
              // screens greater than >= 775px
              breakpoint: 800,
              settings: {
                // Set to `auto` and provide item width to adjust to viewport
                slidesToShow: 3,
                slidesToScroll: 2,
              }
            },{
              // screens greater than >= 1024px
              breakpoint: 1024,
              settings: {
                slidesToShow: 4,
                slidesToScroll: 4,
                itemWidth: 150,
                duration: 0.25
              }
            }
          ]
    });
});