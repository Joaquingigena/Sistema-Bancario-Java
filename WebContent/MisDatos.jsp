<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">

 <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
 
 <!-- Icons de Bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Mis Datos</title>
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
            <div class="navbar-nav d-flex justify-content-center align-items-center">
				<div class="btn-group mx-5">
				  <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" data-bs-display="static" aria-expanded="false">
				   Pepito
				  </button>
				  <ul class="dropdown-menu dropdown-menu-end dropdown-menu-lg-start">
				    <li><button class="dropdown-item" type="button">Mis datos</button></li>
				    <li><button class="dropdown-item" type="button">Dinero</button></li>
				    <li><button class="dropdown-item" type="button">Transferencias</button></li>
				    <li><button class="dropdown-item" type="button">Prestamos</button></li>
				    <li><button class="dropdown-item" type="button">Movimientos</button></li>
				    <li><button class="dropdown-item" type="button">Pagos</button></li>
				    <li><button class="dropdown-item" type="button">Cerrar Sesión</button></li>
				  </ul>
				</div>
			</div>
          </div>
        </div>
    </nav>
    
    <div class="container">
    	<h2>Informacion Personal</h2>
<div id="DNICliente" style="margin-top:20px; display:flex; align-items:center">
					<h5>DNI </h5>
					<div style="width: 200px">
					<input readonly type="text" class="form-control" aria-label="DNI" aria-describedby="basic-addon1" style="margin-left: 40px;">
					</div>
				</div>
                <div id="CUILCliente" style="margin-top:20px; display:flex; align-items:center">
					<h5>CUIL </h5>
					<div style="width: 200px">
					<input readonly type="text" class="form-control" aria-label="CUIL" aria-describedby="basic-addon1" style="margin-left: 40px;">
					</div>
				</div>
                <div id="NombreCliente" style="margin-top:20px; display:flex; align-items:center">
					<h5>Nombre </h5>
					<div style="width: 200px">
					<input readonly type="text" class="form-control" aria-label="Nombre" aria-describedby="basic-addon1" style="margin-left: 40px;">
					</div>
				</div>
                <div id="ApellidoCliente" style="margin-top:20px; display:flex; align-items:center">
					<h5>Apellido </h5>
					<div style="width: 200px">
					<input readonly type="text" class="form-control" aria-label="Apellido" aria-describedby="basic-addon1" style="margin-left: 40px;">
					</div>
				</div>
                <div id="DireccionCliente" style="margin-top:20px; display:flex; align-items:center">
					<h5>Direccion </h5>
					<div style="width: 200px">
					<input readonly type="text" class="form-control" aria-label="Direccion" aria-describedby="basic-addon1" style="margin-left: 40px;">
					</div>
				</div>
                <div id="CorreoCliente" style="margin-top:20px; display:flex; align-items:center">
					<h5>Correo </h5>
					<div style="width: 200px">
					<input readonly type="text" class="form-control" aria-label="Correo" aria-describedby="basic-addon1" style="margin-left: 40px;">
					</div>
				</div>
                <div id="TelefonoCliente" style="margin-top:20px; display:flex; align-items:center">
					<h5>Numero de Telefono </h5>
					<div style="width: 200px">
					<input readonly type="text" class="form-control" aria-label="Telefono" aria-describedby="basic-addon1" style="margin-left: 40px;">
					</div>
				</div>
                <div id="UsuarioCliente" style="margin-top:20px; display:flex; align-items:center">
					<h5>Usuario </h5>
					<div style="width: 200px">
					<input readonly type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1" style="margin-left: 40px;">
					</div>
				</div>
					<div id="contraCliente" style="display:flex; margin:0; margin-top: 20px; align-items:center;">
					  <h5>Contraseña </h5>
					  <input type="text" class="form-control" aria-label="Contraseña" aria-describedby="basic-addon1" style="margin: 0; margin-left: 20px; width: 200px">
					  	<div id="btnVerContra" style="margin-top:20px; display:flex; justify-content:end; width:100%">
						<button type="button" class="btn btn-success">Ver Contraseña</button>
					</div>
					</div>
                
	  </div>
	</div>
</body>
</html>