<%@page import="entidades.Cuenta"%>
<%@page import="entidades.Prestamos"%>

<%@page import="entidades.PagoCuotasPrestamo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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

<title>PagosPrestamos</title>
</head>
<%
	String nombre = (String)request.getParameter("usuario");

	ArrayList <Cuenta> listaCuentas = null;
	if (request.getAttribute("cuentas")!=null) listaCuentas=(ArrayList <Cuenta>)request.getAttribute("cuentas");
	
	ArrayList <PagoCuotasPrestamo> listaCuotas = null;
	if (request.getAttribute("pagocuotasprestamo")!=null) listaCuotas=(ArrayList <PagoCuotasPrestamo>)request.getAttribute("pagocuotasprestamo");

	List<Prestamos> listaPrestamos= new ArrayList<Prestamos>();
	if(request.getAttribute("prestamos")!=null){
		listaPrestamos = (ArrayList<Prestamos>)request.getAttribute("prestamos");
	}
%>
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
            <ul class="navbar-nav d-flex justify-content-center align-items-center">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="Inicio.jsp"> Usuario</a>
              </li>
              <ion-icon name="person-circle-outline"></ion-icon> <b><%= nombre %></b>
              <li class="nav-item">
                <a class="nav-link" href="Login.jsp">Cerrar Sesion</a>
              </li>   
          </div>
        </div>
    </nav>
	<div id="General">
		<div id="Navegacion">
			<label style="text-align:center; margin: 10%;"><b><%= nombre %></b></label>
			<div class="btn-group-vertical" role="group" aria-label="Vertical radio toggle button group">
			  
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio1" autocomplete="off" href="ServletMovimientos?Param=listarMovimientos&usuario=<%=nombre%>">
			  <label class="btn btn-outline-danger" for="vbtn-radio1">Movimientos</label>
			  
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio2" autocomplete="off" href="ServletMovimientos?Param=transferencias&usuario=<%=nombre%>">
			  <label class="btn btn-outline-danger" for="vbtn-radio2">Transferencias</label>
			  
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio3" autocomplete="off" href="ServletPrestamo?Param=prestamos&usuario=<%=nombre%>">
			  <label class="btn btn-outline-danger" for="vbtn-radio3">Prestamos</label>
			  
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio4" autocomplete="off" checked href="ServletMovimientos?Param=pagos&usuario=<%=nombre%>">
			  <label class="btn btn-outline-danger" for="vbtn-radio4">Pagos</label>
			  
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio5" autocomplete="off" href="ServletAdmin?Param=misDatos&Nombre=<%=nombre%>">
			  <label class="btn btn-outline-danger" for="vbtn-radio5">Mis Datos</label>
			</div>
		</div>
		<script>
		  // Obtén todos los botones de radio
		  const radioButtons = document.querySelectorAll('.btn-check');
		
		  // Manejador de eventos para redirigir cuando se selecciona un botón de radio
		  radioButtons.forEach(function (radioButton) {
		    radioButton.addEventListener('change', function () {
		      if (radioButton.checked) {
		        const href = radioButton.getAttribute('href');
		        if (href) {
		          // Redirige a la página JSP correspondiente
		          window.location.href = href;
		        }
		      }
		    });
		  });
		</script>
		<div id="Cuerpo">
			
			
			
					
				
			<form action="ServletMovimientos" method="post">
			<div class="container text-center">
				
				<h2>Prestamos</h2>
				<div class="row filaPrestamo">
				    <div class="col">
				    <label class="form-control">Prestamo N°</label>
				      <select class="form-select">
				      	<%
				      	if(listaPrestamos!=null){
				      		for(Prestamos P : listaPrestamos){
				      			%>
				      			<option><%=P.getNumPrestamo_P() %> </option>
				      			<%
				      		}
				      	}
				      	%>
				      </select>
				
				    </div>
				    <div class="col">
				    	<label class="form-control">Fecha de inicio </label>
				    </div>
				    <div class="col">
				    	<label class="form-control">Monto solicitado:  <%= listaPrestamos.get(0).getImportePedido_P() %> $</label>
				    </div>
				    <div class="col">
				    	<label class="form-control">Monto total a pagar: <%=listaPrestamos.get(0).getImportePagar_P() %>$</label>
				    </div>
				</div>
			
			<div class="row filaPrestamo">
					<div class="col">
				      <label class="form-control">Cuota N°</label>
				      <select id="cuotas" name="ddlCuotas" class="form-select" required>
                        <% if (listaCuotas != null)
                            for (PagoCuotasPrestamo c : listaCuotas) { %>
                                <option value=<%=c.getNumPrestamo_PCP() %>><%=c.getNumCuota_PCP() + " - " + " Monto: " + c.getMontoPagoMes_PCP()  %></option>
                        <% } %>
                    </select>
                    <% 
                    %>
				    </div>
				    <div class="col">
				      <label class="form-control">N° de cuenta</label>
				      <select id="cuentas" name="ddlCuenta" class="form-select" required>
                        <% if (listaCuentas != null)
                            for (Cuenta cuenta : listaCuentas) { %>
                                <option value=<%=cuenta.getNumCuenta_Cta() %>><%=" CBU: "+ cuenta.getCBU_Cta() + " - " + " Saldo $"+ cuenta.getSaldo_Cta() %></option>
                        <% } %>
                    </select>
                    <% 
                    %>
				    </div>
			</div>
			
			<div class="row ">
				<div class="col text-center">
					<input type="submit" name="btnPagar" value="Pagar" class="btn btn-secondary btn-mm">
				</div>
			</div>
			
			</form>
			
			
			</div>
			</div>
			</div>
			
				
	
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>