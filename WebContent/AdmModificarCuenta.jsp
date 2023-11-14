<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Usuario"%>
<%@page import="entidades.Cuenta"%>
<%@page import="entidades.TipoCuentas"%>
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
	String nombre = (String)request.getAttribute("usuario");
	Cuenta c= new Cuenta();
	
	if(request.getAttribute("modificarv2")!= null){
		 c= (Cuenta)request.getAttribute("modificarv2");
		 	System.out.println("CBU"+ c.getCBU_Cta());
		 	System.out.println("NUM Cuenta"+ c.getNumCuenta_Cta());
		 	System.out.println("id user"+ c.getIdUsuario_Cta().getIdUsuario_U());
		 	System.out.println("fecha"+ c.getFechaCreacion_Cta());
		 	System.out.println("tipo cuenta"+ c.getIdTipoCuenta_Cta().getIdTipo_TC());
		 	System.out.println("saldo"+ c.getSaldo_Cta());

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
	           	<ion-icon name="person-circle-outline"></ion-icon> <b><%= nombre %></b>
              
            </ul>
          
          </div>
        </div>
    </nav>
    <% if(c != null){
    %>
    <form action="ServletCuenta" method="get">
    <div class="container">
    	<h3>Modificar cuenta N° <%=c.getNumCuenta_Cta() %></h3>
    	  <div class="row">
           <div class="col-md-6">
             <label for="campo1" class="form-label">Numero de cuenta</label>
             <input type="text" class="form-control" value="<%=c.getNumCuenta_Cta() %>" name="txtnumCuenta">
           </div>
         </div>
         <div class="row">
           <div class="col-md-6">
             <label for="campo4" class="form-label">Tipo de Cuenta</label>
             <input type="text" class="form-control" value= "<%=c.getIdTipoCuenta_Cta().getIdTipo_TC()%>" name="txtTipo">
           </div>
           <div class="col-md-6">
             <label for="campo5" class="form-label">CBU</label>
             <input type="text" class="form-control" value= "<%=c.getCBU_Cta()%>" name="txtCBU">
           </div>
             <div class="col-md-6">
             <label for="campo6" class="form-label">Saldo</label>
             <input type="text" class="form-control" value= "<%=c.getSaldo_Cta()%>" name="txtSaldo">
           </div>
         </div>

         <div class="row">
        
         	<div class="col-3">
         		<input type="submit" name="btnAceptarModificacionCuenta" class="btn btn-primary" value="Aceptar">
         	</div>
         	<div class="col-3">
         		<a href="ServletCuenta?Param=ListaCuentas" class="btn btn-danger">Cancelar</a>
         	</div>
         </div>				
	</div>						          
    </form>
    	
    <% }     
    %>
    
    
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>