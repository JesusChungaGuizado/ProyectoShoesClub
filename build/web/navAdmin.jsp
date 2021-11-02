<%-- 
    Document   : navAdmin
    Created on : 01-nov-2021, 17:44:16
    Author     : Jesus
--%>

<input type="checkbox" name="" id="sidebar-toggle">
    <div class="sidebar">
        <div class="sidebar-brand">
            <div class="brand-flex">
                <img src="img/persona.jpg" width="30px" alt="">
                <div class="brand-icons">
                    <span class="las la-bell" ></span>
                    <span class="las la-user-circle" ></span>
                </div>
            </div>
        </div>
        <div class="sidebar-main">
            <div class="sidebar-user">
                <img src="img/persona.jpg" alt="">
                <div>
                    <h3>Adam Johnson</h3>
                    <span>adamjohson@hotmail.com</span>
                </div>
            </div>
            <nav class="nav">
                <ul class="list">
                    
                    <li class="list__item menu-head">
                       <div class="list__button ">
                           
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" style="fill: #8da2fb"><path d="M4 11h6a1 1 0 0 0 1-1V4a1 1 0 0 0-1-1H4a1 1 0 0 0-1 1v6a1 1 0 0 0 1 1zm10 0h6a1 1 0 0 0 1-1V4a1 1 0 0 0-1-1h-6a1 1 0 0 0-1 1v6a1 1 0 0 0 1 1zM4 21h6a1 1 0 0 0 1-1v-6a1 1 0 0 0-1-1H4a1 1 0 0 0-1 1v6a1 1 0 0 0 1 1zm10 0h6a1 1 0 0 0 1-1v-6a1 1 0 0 0-1-1h-6a1 1 0 0 0-1 1v6a1 1 0 0 0 1 1z"></path></svg>
                            <a href="#" class="nav__link">Inicio</a>
                        </div>
                    </li>
        
                    <li class="list__item list__item--click ">
                        <div class="list__button list__button--click menu-head">
                            <img src="img/docs.svg" class="list__img">
                            <a href="#" class="nav__link">Servicios</a>
                            <img src="img/arrow.svg" class="list__arrow">
                        </div>
        
                        <ul class="list__show ">
                            <li class="list__inside">
                                <a href="#" class="nav__link nav__link--inside">Estoy dentro</a>
                            </li>
        
                            <li class="list__inside">
                                <a href="#" class="nav__link nav__link--inside">Estoy dentro</a>
                            </li>
                        </ul>
        
                    </li>
        
        
                    <li class="list__item menu-head">
                        <div class="list__button">
                            <img src="img/stats.svg" class="list__img">
                            <a href="#" class="nav__link">Estadisticas</a>
                        </div>
                    </li>
        
                    <li class="list__item list__item--click">
                        <div class="list__button list__button--click menu-head">
                            <img src="img/bell.svg" class="list__img">
                            <a href="#" class="nav__link">Notificaciones</a>
                            <img src="img/arrow.svg" class="list__arrow">
                        </div>
        
                        <ul class="list__show">
                            <li class="list__inside">
                                <a href="#" class="nav__link nav__link--inside">Estoy dentro</a>
                            </li>
        
                            <li class="list__inside">
                                <a href="#" class="nav__link nav__link--inside">Estoy dentro</a>
                            </li>
        
                            <li class="list__inside">
                                <a href="#" class="nav__link nav__link--inside">Estoy dentro</a>
                            </li>
                        </ul>
        
                    </li>
                    <li class="list__item list__item--click">
                        <div class="list__button list__button--click menu-head">
                            <img src="img/bell.svg" class="list__img">
                            <a href="#" class="nav__link">Notificaciones</a>
                            <img src="img/arrow.svg" class="list__arrow">
                        </div>
        
                        <ul class="list__show">
                            <li class="list__inside">
                                <a href="#" class="nav__link nav__link--inside">Estoy dentro</a>
                            </li>
        
                            <li class="list__inside">
                                <a href="#" class="nav__link nav__link--inside">Estoy dentro</a>
                            </li>
        
                            <li class="list__inside">
                                <a href="#" class="nav__link nav__link--inside">Estoy dentro</a>
                            </li>
                        </ul>
        
                    </li>
        
                    <li class="list__item">
                        <div class="list__button menu-head">
                            <img src="img/message.svg" class="list__img">
                            <a href="#" class="nav__link">Contacto</a>
                        </div>
                    </li>
                    
                </ul>
            </nav>
         
            
        </div>
    </div>
    
    
    <label for="sidebar-toggle" class="body-label"></label>