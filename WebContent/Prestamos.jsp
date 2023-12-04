<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Cuotas"%>
<%@page import="entidades.Cuenta"%>
<%@page import="entidades.Usuario"%>
<%@page import="java.util.List"%>
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

<title>Prestamos</title>
</head>
<%
String nombre = (String)request.getParameter("usuario");

ArrayList <Cuenta> listaCuentasOrigen = null;
if (request.getAttribute("cuentas")!=null) listaCuentasOrigen=(ArrayList <Cuenta>)request.getAttribute("cuentas");

ArrayList <Cuotas> listaCuotas = null;
if (request.getAttribute("cuotas")!=null) listaCuotas=(ArrayList <Cuotas>)request.getAttribute("cuotas");
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
			  
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio3" autocomplete="off" checked href="ServletMovimientos?Param=prestamos&usuario=<%=nombre%>">
			  <label class="btn btn-outline-danger" for="vbtn-radio3">Prestamos</label>
			  
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio4" autocomplete="off" href="ServletMovimientos?Param=pagos&usuario=<%=nombre%>">
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
			<div id="Encabezado">
				<h2>Prestamos</h2>
			</div>
			<div id="Primario">
				<form action="ServletPrestamo" method="post">
				
					<h4>Solicitud de prestamo</h4>
					<div id="MontoRequerido" style="display:flex; margin:0; margin-top: 20px; align-items:center;">
					  <h5>Monto requerido: $</h5>
					  <input type="text" class="form-control" id="monto" name ="monto" onchange="cambia_monto()" aria-describedby="basic-addon1" style="margin: 0; margin-left: 20px; width: 200px ">
					</div>	
				<div id=CantCuotas style="margin-top:50px; display:flex; align-items:center;">
					<h5>Cantidad de cuotas: </h5>
				    <select id="cuotas" name="ddlCuotas" class="form-select" required onchange="cambia_monto()">
					<%
					    if (listaCuotas != null) 
					    %>
					    	<option value="" selected>Seleccione cantidad de cuotas </option>
					    	<%
					            for (Cuotas c : listaCuotas) { %>
					                <option value=<%= c.getIdCuota_C() %>><%=c.getCantidadCuota_C() %></option>
					        <% }%>
					</select>
					
					
					 
				</div>	
				
				<div id=ImporteMes style="display:flex; margin-top: 20px; align-items:center"> 
					<h5>Importe Cuota: $</h5>
					<input type="number" class="form-control" id="montoApagar" name ="montoApagar" disabled aria-describedby="basic-addon1" style="margin: 0; margin-left: 20px; width: 200px">
				</div>
				
				<div id=ImporteTotal style="display:flex; margin-top: 20px; align-items:center"> 
					<h5>Total a pagar: $</h5>
					<input type="number" class="form-control" disabled id="Total" name ="Total" aria-describedby="basic-addon1" style="margin: 0; margin-left: 20px; width: 200px">
				</div>
							 
				<div>	 
					<div id="Cuenta Destino" style="display:flex; margin-top: 20px; align-items:center">
					  <h5>Cuenta destino: </h5>
		                    <select id="cuentas" name="ddlCuentaOrigen" class="form-select" required>
                        <% if (listaCuentasOrigen != null)
                            for (Cuenta cuenta : listaCuentasOrigen) { %>
                                <option value=<%=cuenta.getNumCuenta_Cta() %>><%=" CBU: "+ cuenta.getCBU_Cta() + " - " + " Saldo $"+ cuenta.getSaldo_Cta() %></option>
                        <% } %>
                    </select>
                    <% 
                    	if(request.getAttribute("idUser")!= null){
                    		int id = Integer.parseInt(request.getAttribute("idUser").toString());
                    %>
                    <input type="hidden" name="IDusuario" value="<%=id%>">
                    <%} %>
					</div>
					
					<input type="hidden" name="usuario" value="<%= nombre %>">
					<input type="hidden" id="plazo" name="plazo" value="">
					<input type="hidden" id="MontoTotal" name="MontoTotal" value="">

					<div id="btnSolicitar" style="margin-top:20px; display:flex; justify-content:end; width:100%">
						<input type="submit" value="Solicitar prestamos" name="btnSolicitarPrestamo" class="btn btn-primary" onclick="return confirm('¿Está seguro de pedir este prestamo?')"></input>
					</div>
				</div>
				
				</form>

				
			</div>
			<div>
				
				
			</div>
			
		</div>
	</div>
	
						<!-- FUNCION JAVASCRIPT -->
                        <script type="text/javascript">
                        
                        
                        function cambia_monto(){
                        	
                        	var montoSolicitado = document.getElementById('monto').value;
                        	var montoApagar = document.getElementById('montoApagar');
                        	var Total = document.getElementById('Total');
                        	var plazo = document.getElementById('plazo');
                        	var interes = 1;
                        	var seleccion = document.getElementById("cuotas");
                        	
                        	var cuotas = 1;
                        	var valueCuotas = Number(seleccion.options[seleccion.selectedIndex].value);
                        	
                        	switch(valueCuotas){
                        		case 1: interes = 1.15;
                        				cuotas = 3;
                        		break;
                        		
                        		case 2: interes = 1.25;
                        				cuotas = 6;
                        		break;
                        		
                        		case 3: interes = 1.50;
                        				cuotas = 12;
                        		break;
                        		
                        		case 4: interes = 1.90;
                        				cuotas = 18;
                        		break;
                        		
                        		case 5: interes = 2.15;
                        				cuotas = 24;
                        		break;
                        	}	
                        	
                        	if(seleccion.options[seleccion.selectedIndex].text.charAt(0)!="S"){
                        		var m = montoSolicitado*interes/cuotas;
                        		montoApagar.value = m.toFixed(2);
                        		var total = m*cuotas;
                        		Total.value = total.toFixed(2);
                        		document.getElementById('MontoTotal').value = document.getElementById('Total').value;
                        		plazo.value = cuotas;
                        	}
                        	else{
                        		montoApagar.value = "";
                        	}
                        	
                        }
                        
                        </script>
	
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>