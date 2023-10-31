<%@page import="entidades.Usuario"%>
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

<title>Clientes</title>
</head>
<body>

<%
	String nombre = (String)request.getAttribute("nombre");
	List<Usuario> listaClientes= new ArrayList<Usuario>();

	if(request.getAttribute("cargar")!=null){
		listaClientes= (ArrayList<Usuario>)request.getAttribute("cargar");
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
                <a class="nav-link active" aria-current="page" href="AdmClientes.jsp"> Clientes</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="AdmCuentas.jsp">Cuentas</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="AdmPrestamos.jsp">Prestamos</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="ServletInformes?Param=listarInformes">Informes</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="Login.jsp">Cerrar sesion</a>
              </li>
	           	<ion-icon name="person-circle-outline"></ion-icon> <b><%= nombre %></b>
              
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
                <option value="nombre">N° Cliente</option>
                <option value="id">DNI</option>
            </select>
        </div>
        <div class="col-auto">
            <button class="btn btn-primary" id="btnFiltrar">Filtrar</button>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-3 titulo">
               
                <h3 >Listado de clientes</h3>
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
                        
                        <th scope="col">N° cliente</th>
                        <th scope="col">Usuario</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Dni</th>
                        <th scope="col">Correo</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        
                      </tr>
                    </thead>
                    <tbody class="table-group-divider">
                      
                      <%
                      if(listaClientes!=null){                   	  
                    	  for(Usuario u : listaClientes){
                    		  %>
                    		 <tr>
		                        <td><%= u.getIdUsuario_U() %></td>
		                        <td><%=u.getUsuario_U() %></td>
		                        <td><%=u.getIdPersona_U().getNombre_P() %></td>
		                        <td><%=u.getIdPersona_U().getApellido_P() %> </td>
		                        <td><%=u.getIdPersona_U().getDNI_P()%> </td> 
		                        <td><%=u.getIdPersona_U().getCorreo_P() %></td>
		                        <td><button class="btn btn-primary">Modificar</button></td>
		                       <td> <a href="ServletAdmin?eliminarCliente=<%=u.getIdUsuario_U()%>" class="btn btn-danger" >Eliminar </a> </td>
			                        
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

<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>