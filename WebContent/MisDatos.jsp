<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
              <i class="bi bi-bank banco"></i>
            </a>
            <ul class="navbar-nav d-flex justify-content-center align-items-center">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="Inicio.jsp"> Usuario</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="Login.jsp">Cerrar Sesion</a>
              </li>   
          </div>
        </div>
    </nav>
	<div id="General">
		<div id="Navegacion">
			<label style="text-align:center; margin: 10%;">Nombre Usuario</label>
			<div class="btn-group-vertical" role="group" aria-label="Vertical radio toggle button group">
			  
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio1" autocomplete="off" href="Movimientos.jsp">
			  <label class="btn btn-outline-danger" for="vbtn-radio1">Movimientos</label>
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio2" autocomplete="off">
			  <label class="btn btn-outline-danger" for="vbtn-radio2">Transferencias</label>
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio3" autocomplete="off">
			  <label class="btn btn-outline-danger" for="vbtn-radio3">Prestamos</label>
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio4" autocomplete="off">
			  <label class="btn btn-outline-danger" for="vbtn-radio4">Pagos</label>
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio4" autocomplete="off" checked>
			  <label class="btn btn-outline-danger" for="vbtn-radio5">Mis Datos</label>
			</div>
		</div>
		<div id="Cuerpo">
			<div id="Encabezado">
				<h2>Mis datos</h2>
			</div>

    <div class="container">
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
					  <h5>Contraseņa </h5>
					  <input type="text" class="form-control" aria-label="Contraseņa" aria-describedby="basic-addon1" style="margin: 0; margin-left: 20px; width: 200px">
					  	<div id="btnVerContra" style="margin-top:20px; display:flex; justify-content:end; width:100%">
						<button type="button" class="btn btn-success">Ver Contraseņa</button>
					</div>
					</div>
                
	  </div>


			<div>
				
				
			</div>
			
		</div>
	</div>
</body>
</html>