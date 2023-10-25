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
<title>Home Banking</title>
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
            <div class="navbar-nav d-flex justify-content-center align-items-center">
				<div class="btn-group mx-5">
				  <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" data-bs-display="static" aria-expanded="false">
				   Pepito
				  </button>
				  <ul class="dropdown-menu dropdown-menu-end dropdown-menu-lg-start">
				    <li><button class="dropdown-item" type="button">Prestamo</button></li>
				    <li><button class="dropdown-item" type="button">Cuentas</button></li>
				    <li><button class="dropdown-item" type="button">Transferencias</button></li>
				    <li><button class="dropdown-item" type="button">Cerrar Sesión</button></li>
				  </ul>
				</div>
			</div>
          </div>
        </div>
    </nav>
    
    <div class="container">
    	<h2>Tu cuenta principal</h2>
	    <div class="container">
		  <div class="row">
		    <div class="col-9 col-3">
		    	<div class="border border-success m-3 p-4">
		    		<span class="rounded bg-success p-2 h3 mx-3"><b>CA$</b></span> <b class="h3"> $ 540.678,89</b>
		    		<div style="margin-left:95px; padding:5px">Caja de ahorro en pesos <b>452787-56-7</b></div>
		    	</div>
				<table class="table text-center">
				  <thead>
				    <tr>

				      <th scope="col">Fecha</th>
				      <th scope="col">Descripción</th>
				      <th scope="col">Monto</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>

				      <td>20/04/2023</td>
				      <td>Trasnferencia</td>
				      <td>-$250.000</td>
				    </tr>
				    <tr>

				      <td>20/04/2023</td>
				      <td>Trasnferencia</td>
				      <td>-$250.000</td>
				    </tr>
				    <tr>

				      <td>20/04/2023</td>
				      <td>Trasnferencia</td>
				      <td>-$250.000</td>
				    </tr>
				    <tr>

				      <td>20/04/2023</td>
				      <td>Trasnferencia</td>
				      <td>-$250.000</td>
				    </tr>
				    <tr>

				      <td>20/04/2023</td>
				      <td>Trasnferencia</td>
				      <td>-$250.000</td>
				    </tr>
				    <tr>

				      <td>20/04/2023</td>
				      <td>Trasnferencia</td>
				      <td>$250000</td>
				    </tr>
				    <tr>

				      <td>20/04/2023</td>
				      <td>Trasnferencia</td>
				      <td>-$250.000</td>
				    </tr>
				    <tr>

				      <td>20/04/2023</td>
				      <td>Trasnferencia</td>
				      <td>-$250.000</td>
				    </tr>
				  </tbody>
				</table>
		    </div>
		    <div class="col-3 col-md-3"></div>
    	</div>
	  </div>
	</div>
</body>
</html>