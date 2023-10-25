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

<title>Movimientos</title>
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
			  
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio1" autocomplete="off" checked>
			  <label class="btn btn-outline-danger" for="vbtn-radio1">Movimientos</label>
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio2" autocomplete="off">
			  <label class="btn btn-outline-danger" for="vbtn-radio2">Transferencias</label>
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio3" autocomplete="off">
			  <label class="btn btn-outline-danger" for="vbtn-radio3">Prestamos</label>
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio4" autocomplete="off">
			  <label class="btn btn-outline-danger" for="vbtn-radio4">Pagos</label>
			</div>
		</div>
		<div id="Cuerpo">
			<div id="Encabezado">
				<h2>Movimientos</h2>
			</div>
			<div style="display:flex;">
				<h5 style="margin:25px">Cuenta: </h5>
				<select style="height: 40px; width:500px; margin: 15px" class="form-select" aria-label="Default select example">
				  <option selected>Seleccione una cuenta</option>
				  <option value="1">Cuenta 1</option>
				  <option value="2">Cuenta 2</option>
				  <option value="3">Cuenta 3</option>
				</select>
			</div>
			<div>
				
				<div id="Busqueda">
					<h5>Busqueda</h5>
					<h7>Desde: </h7>
					<input type="date">
					<h7>Hasta: </h7>
					<input type="date">
					<button type="button" class="btn btn-success">Buscar</button>
				</div>
				<table style="margin:25px;" class="table table-striped table-hover">
					<thead>
						<tr class="table-primary">
							<th>Fecha</th>
							<th>Detalle</th>
							<th>Importe</th>
							<th>Tipo movimiento</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>02/08/2023</th>
							<th>Transferencia de terceros</th>
							<th>$15000</th>
							<th>Deposito</th>
						</tr>
						<tr>
							<th>15/08/2023</th>
							<th>Compra super Chino</th>
							<th>$5000</th>
							<th>Extracción</th>
						</tr>
						<tr>
							<th>20/08/2023</th>
							<th>Mercado Libre</th>
							<th>$10000</th>
							<th>Extracción</th>
						</tr>
						<tr>
							<th>05/09/2023</th>
							<th>Transferencia de terceros</th>
							<th>$25000</th>
							<th>Deposito</th>
						</tr>
					</tbody>
				</table>
			</div>
			
		</div>
	</div>
</body>
</html>