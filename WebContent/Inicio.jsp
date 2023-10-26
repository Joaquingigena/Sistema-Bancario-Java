<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">

 <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
 
 <!-- Icons de Bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
    <title>Banco Grupo 6 - Inicio</title>
</head>
<body>
<!-- Barra de navegacion -->
     <nav class="navbar navbar-expand-md navbar-light">
        <div class="container-fluid">
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar-toggler" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbar-toggler">
            <a class="navbar-brand" href="#">
              <img src="css/imagenes/logoBanco.png" class="logo img-fluid " alt="logo" />
            </a>
            <ul class="navbar-nav d-flex justify-content-center align-items-center">
	              <li class="nav-item">
	                <a class="nav-link active" aria-current="page" href="Inicio.jsp"> Inicio</a>
	              </li>
	              <li class="nav-item">
	                <a class="nav-link" href="Login.jsp">Iniciar Sesion</a>
	              </li> 
	        </ul>  
          </div>
        </div>
    </nav>
    
    <div id="carousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active" data-bs-interval="3000">
            <img src="css/imagenes/img1.jpg" class="d-block w-100" alt="">
          </div>
          
 
          <div class="carousel-item" data-bs-interval="3000">
            <img src="css/imagenes/img2.jpg" class="d-block w-100" alt="...">
          </div>
 

          <div class="carousel-item" data-bs-interval="3000">
            <img src="css/imagenes/img3.jpg" class="d-block w-100" alt="...">
          </div>
 
 
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carousel"  data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carousel"  data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>   
   <!--========================================================== -->
                        <!-- INTRODUCCION DE SERVICIOS-->
    <!--========================================================== -->


    <section class="d-flex flex-column justify-content-center align-items-center pt-5  text-center w-50 m-auto" id="intro">
    <h1 class="p-3 fs-2 border-top border-3">"Tu Socio de Confianza para Todas Tus Necesidades Financieras" <span class="text-primary">Finanzas<span/></h1>
     <p class="p-3  fs-4">
         <span class="text-primary">Banco Grupo 6.</span> ¡Somos su socio financiero de confianza, comprometidos a ofrecerle una amplia gama de servicios bancarios para satisfacer todas sus necesidades financieras. En Banco Grupo6, entendemos la importancia de la seguridad, la accesibilidad y la satisfacción del cliente.        
     </p>   
    </section>

   <!--========================================================== -->
                        <!-- TIPOS DE SERVICIOS-->
    <!--========================================================== -->


<section class="w-100">
    <div class="row w-75 mx-auto" id="servicios-fila-1">       
        <div class="col-lg-6 col-md-12 col-sm-12 d-flex justify-content-start my-5 icono-wrap">
            <img src="css/imagenes/img6.png" alt="..."   width="180" height="160">

            <div>
                <h3 class="fs-5 mt-4 px-4 pb-1">Cuentas Bancarias</h3>
                <p class="px-4">Ofrecemos una variedad de cuentas bancarias diseñadas para adaptarse a sus necesidades personales o empresariales.</p>
            </div>

        </div>

        <div class="col-lg-6 col-md-12 col-sm-12 d-flex justify-content-start  my-5 icono-wrap">
            <img src="css/imagenes/img7.png" alt="..." width="180" height="160">

            <div>
                <h3 class="fs-5 mt-4 px-4 pb-1 icono-wrap">Prestamos y Creditos</h3>
                <p class="px-4">Obtenga acceso a préstamos personales, hipotecas y financiamiento para sus proyectos.</p>
            </div>
        </div>   
    </div>
    
    <div class="row w-75 mx-auto mb-5" id="servicios-fila-2">       
        <div class="col-lg-6 col-md-12 col-sm-12 d-flex justify-content-start  my-5 icono-wrap">
            <img src="css/imagenes/img8.png" alt="..." width="180" height="160">

            <div>
                <h3 class="fs-5 mt-4 px-4 pb-1">Inversiones</h3>
                <p class="px-4">Planifique su futuro financiero con nuestras opciones de inversión y asesoramiento experto.

                </p>
            </div>
        </div>

        <div class="col-lg-6 col-md-12 col-sm-12 d-flex justify-content-start my-5 icono-wrap">
            <img src="css/imagenes/img9.png" alt="..." width="180" height="160" >

            <div>
                <h3 class="fs-5 mt-4 px-4 pb-1">Servicios Empresariales</h3>
                <p class="px-4">Apoyamos a empresas de todos los tamaños con soluciones financieras personalizadas.</p>
            </div>
        </div>   
    </div>
</section>

<!--========================================================== -->
                        <!--FOOTER-->
<!--========================================================== -->


<footer class="w-100  d-flex  align-items-center justify-content-center flex-wrap">
  <p class="fs-5 px-3  pt-3">&copy; Banco Grupo 6 Todos Los Derechos Reservados 2021</p>
  <div id="iconos" >
      <a href="#"><i class="bi bi-facebook"></i></a>
      <a href="#"><i class="bi bi-twitter"></i></a>
      <a href="#"><i class="bi bi-instagram"></i></a>  
  </div>
</footer>

</body>
</html>