<%@ page import= "entidades.Prestamos" %>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

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

<%
	List<Prestamos> listaPrestamos= new ArrayList<Prestamos>();

	if(request.getAttribute("cargar")!=null){
		listaPrestamos = (ArrayList<Prestamos>)request.getAttribute("cargar");
	}
%>

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
                <a class="nav-link active" href="ServletAdmin?Param=listarClientes"> Clientes</a>
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
                <option value="nombre">N° Prestamo</option>
                <option value="id">N° Usuario</option>
            </select>
        </div>
        <div class="col-auto">
            <button class="btn btn-primary" id="btnFiltrar">Filtrar</button>
        </div>
    </div>
    
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
                        <th scope="col">N° Prestamo</th>
                        <th scope="col">N° Cuenta</th>
                        <th scope="col">Importe a pagar</th>
                        <th scope="col">Importe pedido</th>
                        <th scope="col">Cuotas a pagar</th>
                        
                      </tr>
                    </thead>
                    <tbody class="table-group-divider">
                    
                      <%
                      if(listaPrestamos!=null){                   	  
                    	  for(Prestamos p : listaPrestamos){
                    		  %>
                    		 <tr>
		                        <td><%= p.getNumPrestamo_P() %></td>
		                        <td><%=p.getNumCuenta_P().getNumCuenta_Cta() %></td>
		                        <td><%=p.getImportePagar_P() %></td>
		                        <td><%=p.getImportePedido_P() %> </td>
		                        <td><%=p.getPlazoPago_P() %> </td> 

		                        <td><button class="btn btn-primary">Modificar</button></td>
		                        <td><button class="btn btn-danger">Eliminar</button></td>                        
                     		 </tr>
                    		  <%
                    	  }
                    	  
                      }
                      
                      
                      %>
                    </tbody>
                  </table>
            </div>
        </div>
    </div>
    
</body>
</html>