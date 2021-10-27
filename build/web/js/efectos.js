let iconoMenu=document.getElementById("menuIcon");
let menu=document.getElementById("menu");
let fondoMenu=document.getElementById("menu_back");
iconoMenu.addEventListener("click",(e)=>{
 
    menu.classList.toggle("mostrarMenu");
    fondoMenu.classList.toggle("menu-fondo");
 
})
// ---------------DESPLAZAMIENTO DE MENU DE NAVEGACION----------
// buscamos la posicion del scroll
let ubicacionPrincipal=window.pageYOffset;
// console.log(ubicacionPrincipal)
window.addEventListener("scroll",function(){
    //remover menu lateral
    menu.classList.remove("mostrarMenu");
    fondoMenu.classList.remove("menu-fondo");
    let desplazamientoActual=window.pageYOffset;
    // console.log(ubicacionPrincipal)
    if (ubicacionPrincipal>=desplazamientoActual) {
        document.querySelector(".container-nav").style.top="0px";
    } else {
        document.querySelector(".container-nav").style.top="-110px";
    }
    ubicacionPrincipal=desplazamientoActual;
})

// si el tamaño de pantalla es mayor a 650px removemos la clase
window.addEventListener('resize',function(){
    if(this.screen.width>650){
        menu.classList.remove("mostrarMenu");
        fondoMenu.classList.remove("menu-fondo");
    }
})


