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

<title>Informes</title>
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
                <a class="nav-link" href="AdmInformes.jsp">Informes</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Cerrar sesion</a>
              </li>
            </ul>
          
          </div>
        </div>
    </nav>
    
    <div class="d-flex justify-content-center">
        <div class="col-sm-4">
            <input type="text" class="form-control" id="filtroValor" placeholder="Filtrar por">
        </div>
        <div class="col-auto">
            <select class="form-control" id="filtroCampo">
                <option value="nombre">N° Informe</option>
                <option value="id">N° Cliente</option>
                <option value="id">N° Cuenta</option>
            </select>
        </div>
        <div class="col-auto">
            <button class="btn btn-primary" id="btnFiltrar">Filtrar</button>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-3 titulo">
               
                <h3 >Listado de Informes</h3>
            </div>
           <div>
                <input type="submit" name="btnSolicitudes" value="Ver solicitudes de cuenta" class="btn btn-secondary btn">
           </div>
        </div>

        <div class="row">
            <div class="col-8">
                <table class="table">
                    <thead>
                      <tr>
                        <th scope="col">N° Informe</th>
                        <th scope="col">N° Cliente</th>
                        <th scope="col">N° Cuenta</th>
                        <th scope="col">Descripcion</th>
                        <th scope="col">Comentarios</th>
                        <th scope="col">Estado</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        
                      </tr>
                    </thead>
                    <tbody class="table-group-divider">
                      <tr>
                        <th scope="row">1</th>
                        <td>12312312</td>
                        <td>12313</td>
                        <td>Sin descripcion</td>
                        <td>Sin comentarios</td>
                        <td>Activo</td>
                        <td><button class="btn btn-primary">Modificar</button></td>
                        <td><button class="btn btn-danger">Eliminar</button></td>
                        
                      </tr>
                      <tr>
                        <th scope="row">2</th>
                        <td>12312312</td>
                        <td>12313</td>
                        <td>Sin descripcion</td>
                        <td>Sin comentarios</td>
                        <td>Activo</td>
                        <td><button class="btn btn-primary">Modificar</button></td>
                        <td><button class="btn btn-danger">Eliminar</button></td>
                      </tr>
                      <tr>
                        <th scope="row">3</th>
                        <td>12312312</td>
                        <td>12313</td>
                        <td>Sin descripcion</td>
                        <td>Sin comentarios</td>
                        <td>Activo</td>
                        <td><button class="btn btn-primary">Modificar</button></td>
                        <td><button class="btn btn-danger">Eliminar</button></td>
                      </tr>
                    </tbody>
                  </table>
            </div>
        </div>
    </div>


</body>
</html>