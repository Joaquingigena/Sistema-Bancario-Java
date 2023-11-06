<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Usuario"%>
<%@page import="entidades.Provincias"%>
<%@page import="entidades.Localidades"%>
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

<title>Modificar cliente</title>
</head>
<body>

<%
	Usuario user= new Usuario();
	
	if(request.getAttribute("modificar")!= null){
		 user= (Usuario)request.getAttribute("modificar");
	}
	
	List<Provincias> listaProvincias= new ArrayList<Provincias>();
	List<Localidades> listaLocalidades= new ArrayList<Localidades>();
	
	if(request.getAttribute("ListaProvincias")!=null){
		listaProvincias=(ArrayList<Provincias>)request.getAttribute("ListaProvincias");
	}
	
	if(request.getAttribute("ListaLocalidades")!=null){
		listaLocalidades=(ArrayList<Localidades>)request.getAttribute("ListaLocalidades");
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
                <a class="nav-link" href="ServletAdmin?Param=listarPrestamos">Prestamos</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="ServletInformes?Param=listarInformes">Informes</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="Login.jsp">Cerrar sesion</a>
              </li>
	           	<ion-icon name="person-circle-outline"></ion-icon> <b>NOmbreUsuario/b>
              
            </ul>
          
          </div>
        </div>
    </nav>
    
    <form action="ServletAdmin" method="get">
    <div class="container">
    	<h3>Modificar cliente N° <%=user.getIdUsuario_U() %></h3>
    	<input type="hidden" name="txtIdPersona" value="<%=user.getIdPersona_U().getIdPersona_P()%>">
    	<input type="hidden" name="txtIdCliente" value="<%=user.getIdUsuario_U()%>">
    	  <div class="row">
           <div class="col-md-6">
             <label for="campo3" class="form-label">Nombre de usuario</label>
             <input type="text" class="form-control" value="<%=user.getUsuario_U() %>" name="txtNombreUsuario">
           </div>
           <div class="col-md-6">
             <label for="campo4" class="form-label">Contraseña</label>
             <input type="text" class="form-control" value="<%=user.getPassword_U() %>" name="txtContrasena">
           </div>
         </div>
         <div class="row">
           <div class="col-md-6">
             <label for="campo1" class="form-label">Nombre</label>
             <input type="text" class="form-control" value= "<%=user.getIdPersona_U().getNombre_P()%>" name="txtNombre">
           </div>
           <div class="col-md-6">
             <label for="campo2" class="form-label">Apellido</label>
             <input type="text" class="form-control" value= "<%=user.getIdPersona_U().getApellido_P()%>" name="txtApellido">
           </div>
         </div>
         <div class="row">
           <div class="col-md-6">
             <label for="campo3" class="form-label">Localidad</label>
             <select name="ddlLocalidades" class="form-select">
             	<%for(Localidades L: listaLocalidades){ %>
             	<option value="<%=L.getCodLocalidad_Loc()%>"><%=L.getNombre_Loc() %> </option>
             	<%} %>
             </select>
           </div>
           <div class="col-md-6">
             <label for="campo4" class="form-label">Provincia</label>
             <select name="ddlProvincias" class="form-select">
             	<%for(Provincias P: listaProvincias){ %>
             	<option value="<%=P.getCodProvincia_Prov()%>"><%=P.getNombre_Prov()%> </option>
             	<%} %>
             </select>
           </div>
         </div>
          <div class="row">
           <div class="col-md-6">
             <label for="campo3" class="form-label">Direccion</label>
             <input type="text" class="form-control" value="<%=user.getIdPersona_U().getDireccion_P()%>" name="txtDireccion">
           </div>
           <div class="col-md-6">
             <label for="campo4" class="form-label">Telefono</label>
             <input type="text" class="form-control" value="<%=user.getIdPersona_U().getTelefono_P()%>" name="txtTelefono">
           </div>
         </div>
          <div class="row">
           <div class="col-md-6">
             <label for="campo3" class="form-label">Correo</label>
             <input type="text" class="form-control" value="<%=user.getIdPersona_U().getCorreo_P()%>" name="txtCorreo">
           </div>
           <div class="col-md-6">
             <label for="campo4" class="form-label">Fecha de nacimiento</label>
             <input type="text" class="form-control" value="<%=user.getIdPersona_U().getFechaNac_P()%>" name="txtFecha">
           </div>
         </div>
         <div class="row">
        
         	<div class="col-3">
         		<input type="submit" name="btnAceptarModificacion" class="btn btn-primary" value="Aceptar">
         	</div>
         	<div class="col-3">
         		<a href="ServletAdmin?Param=listarClientes" class="btn btn-danger">Cancelar</a>
         	</div>
         </div>				
	</div>						          
    </form>
    

</body>
</html>