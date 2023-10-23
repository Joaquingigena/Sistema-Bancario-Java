<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>

<title>Prestamos</title>

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
                <a class="nav-link active" aria-current="page" href="AdmClientes.jsp"> Clientes</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="AdmCuentas.jsp">Cuentas</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="AdmPrestamos.jsp">Prestamos</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Informes</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Cerrar sesion</a>
              </li>
            </ul>
          
          </div>
        </div>
    </nav>
    
    <div class="container-fluid">
        <div class="row">
            <div class="col-3 titulo">
               
                <h3 >Prestamos</h3>
            </div>
           <div>
                <input type="submit" name="btnPrestamos" value="Autorizar prestamos" class="btn btn-secondary btn">
           </div>
        </div>

        <div class="row">
            <div class="col-8">
                <table class="table">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">N� Prestamo</th>
                        <th scope="col">N� Usuario</th>
                        <th scope="col">Importe a pagar</th>
                        <th scope="col">Cuotas</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        
                      </tr>
                    </thead>
                    <tbody class="table-group-divider">
                      <tr>
                        <th scope="row">1</th>
                        <td>12312312</td>
                        <td>12313</td>
                        <td>10.000</td>
                        <td>3</td>
                        <td><button class="btn btn-outline-primary">Modificar</button></td>
                        <td><button class="btn btn-outline-danger">Eliminar</button></td>
                        
                      </tr>
                      <tr>
                        <th scope="row">2</th>
                        <td>12312312</td>
                        <td>12313</td>
                        <td>20000</td>
                        <td>5</td>
                        <td><button class="btn btn-outline-primary">Modificar</button></td>
                        <td><button class="btn btn-outline-danger">Eliminar</button></td>
                      </tr>
                      <tr>
                        <th scope="row">3</th>
                        <td>12312312</td>
                        <td>12313</td>
                        <td>10000000</td>
                        <td>12</td>
                        <td><button class="btn btn-outline-primary">Modificar</button></td>
                        <td><button class="btn btn-outline-danger">Eliminar</button></td>
                      </tr>
                    </tbody>
                  </table>
            </div>
        </div>
    </div>
    
</body>
</html>