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

     boolean esValido = false;
    if (request.getAttribute("datosOk")!=null) esValido = (boolean)request.getAttribute("datosOk");
    
	ArrayList <Cuenta> listaCuentas = null;
	if (request.getAttribute("cuentas")!=null) listaCuentas=(ArrayList <Cuenta>)request.getAttribute("cuentas");
	
	PagoCuotasPrestamo pago = (PagoCuotasPrestamo) request.getAttribute("listPago");
	/*PagoCuotasPrestamo pago = null;
	if (request.getAttribute("listPago")!=null) pago=(PagoCuotasPrestamo)request.getAttribute("listPago");*/
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
			
			
			
					
				
			<form action="ServletPagoPrestamos" method="<%=esValido ? "post" : "get"%>">
			<div class="container text-center">
				
				    <div class="col">
				      <label class="form-control">N° de cuenta</label>
				      <input type="hidden" name="usuario" value="<%=nombre %>"/>
                     
				      <select id="cuentas" name="ddlCuenta" class="form-select" required>

                        <% if (listaCuentas != null)
                            for (Cuenta cuenta : listaCuentas) { %>
                                <option value=<%=cuenta.getNumCuenta_Cta() %>><%=" CBU: "+ cuenta.getCBU_Cta() + " - " + " Saldo $"+ cuenta.getSaldo_Cta() %></option>
                        <% } %>
                    </select>
                      <div class="container text-center">
					  <div class="row">
                    	<%
					    		if(pago != null){%>
					    		
					    		
					    		<div class="col form-floating mb-3">
							     	<input readonly type="text" class="form-control" value="<%= pago.getCodPago_PCP()%>" name="CodPago"/>
		                        	<label for="CodPago">Codigo de Pago</label>
							    </div>	
							    
							    <div class="col form-floating mb-3">
							      	<input readonly type="text" class="form-control" value="<%= pago.getNumPrestamo_PCP().getNumPrestamo_P()%>" name="NumPrestamo"/>
		                        	<label for="NumPrestamo">N° de Prestamo</label>
							    </div>
							    
							    <div class="col form-floating mb-3">
							      	<input readonly type="text" class="form-control" value="<%= pago.getNumCuenta_PCP().getNumCuenta_Cta()%>" name="NumCuenta"/>
		                        	<label for="NumCuenta">N° de Cuenta</label>
							    </div>
							    
							    <div class="col form-floating mb-3">
							     	<input readonly type="text" class="form-control" value="<%= pago.getNumCuota_PCP()%>" name="NumCuota"/>
		                        	<label for="NumCuota">N° de Cuota</label>
							    </div>
							    
							    <div class="col form-floating mb-3">
							     	<input readonly type="text" class="form-control" value="<%= pago.getMontoPagoMes_PCP()%>" name="MontoPago"/>
		                        	<label for="MontoPago">Monto a Pagar</label>
							    </div>
					    	<%	}%>
					   </div>
					 </div>
				    </div>
			</div>
			
                <div class="col-md-12">
                	<%if(!esValido){%>
                		<input type="submit" class="btn btn-outline-success form-control btn-lg" name="validarDatos" value="Verificar datos"/>
                    <%	}
                	else{%>	
                    	<input type="submit" class="btn btn-outline-success form-control btn-lg" name="btnPagar" value="Pagar" min=0.01 onclick="return confirm('¿Está seguro de realizar este pago?')" />
                	<%	}%>
                </div>
			
			</form>
			
			
			</div>
			</div>
			</div>
			
				
	
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>