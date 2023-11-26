<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Cuotas"%>
<%@page import="entidades.Cuenta"%>
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

	List<Cuenta> listCuentas = new ArrayList<Cuenta>();	
	if(request.getAttribute("cuentas")!=null){
		listCuentas = (ArrayList<Cuenta>)request.getAttribute("cuentas");
	}
	int numCuenta = 0;
	if(request.getAttribute("numCuenta")!=null){
		numCuenta = Integer.parseInt( request.getParameter("numCuenta"));
	}
	float saldo = 0;
	
	Cuenta listCuentaFilter = new Cuenta();
	if(request.getAttribute("cuentaFilter")!=null){
		listCuentaFilter = (Cuenta)request.getAttribute("cuentaFilter");
	}
	
	List<Cuotas> ListCuota = new ArrayList<Cuotas>();
	Cuotas listCuotaFilter = new Cuotas();
	if(request.getAttribute("coutaFilter")!= null){
		listCuotaFilter = (Cuotas)request.getAttribute("cuotaFilter");
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
				<form action="">
				
					<h4>Solicitud de prestamo</h4>
					<div id="MontoRequerido" style="display:flex; margin:0; margin-top: 20px; align-items:center;">
					  <h5>Monto requerido: $</h5>
					  <input type="text" class="form-control" id="monto" name ="monto" aria-label="Username" aria-describedby="basic-addon1" style="margin: 0; margin-left: 20px; width: 200px">
					</div>
				
				<div id=CantCuotas style="margin-top:50px; display:flex; align-items:center;">
					<h5>Cantidad de cuotas: </h5>
					<select style="height: 40px; width: 70px; margin-left: 20px" class="form-select" aria-label="Default select example">
					<%
					    if (ListCuota != null) {
					%>
					    <select id="cuota">
					        <option value="0">Seleccione una cuota</option>
					        <%
					            for (Cuotas c : ListCuota) {
					            	System.out.println("Cantidad de cuota: " + c.getCantidadCuota_C());
					        %>
					                <option value="<%= c.getIdCuota_C() %>"><%= c.getCantidadCuota_C() %></option>
					        <%
					            }
					        %>
					    </select>
					<%
					    }
					%>
					 
				</div>
				<div id="ValorCuota" style="margin-top:20px; display:flex; align-items:center">
					<h5>Valor de cuota: $ </h5>
					<div style="width: 200px">
					<input readonly type="text" class="form-control" id="valorCuota" aria-label="Username" aria-describedby="basic-addon1" style="margin-left: 40px;">
					</div>
				</div>	 
					 
					 
				<div>	 
					<div id="Cuenta Destino" style="display:flex; margin-top: 20px; align-items:center">
					  <h5>Cuenta destino: </h5>
					  <select style="height: 40px; width: 500px; margin-left: 15px" class="form-select" id="destino" aria-label="Default select example">
						  <%
				            	if(numCuenta==0){%>
				            		<option value="0">Seleccione una cuenta</option>
				            	<%}%>
				            <%
				            	if(listCuentas != null){
									int ban = 0;
									int auxNumCuenta = 0;
				            		for(Cuenta c : listCuentas){
				            			if(listCuentaFilter.getNumCuenta_Cta() != 0 && ban == 0){
				            		%>
				            			<option value="<%=numCuenta%>"><%= listCuentaFilter.getCBU_Cta() %></option>
				            			<option value="0">Seleccione una cuenta</option>
				            		<%
				            				ban = 1;
				            			}
				            			if(numCuenta != c.getNumCuenta_Cta()){
				            		%>	
				            			<option value="<%=c.getNumCuenta_Cta()%>"><%= c.getCBU_Cta() %></option>
										<%}	%>
				            	<%	}
				            		for(Cuenta c : listCuentas){
				            			saldo = c.getSaldo_Cta();
				            			break;
				            		}
				            	}
				            %>
					  </select>
					</div>


					<div id="btnSolicitar" style="margin-top:20px; display:flex; justify-content:end; width:100%">
						<input type="submit" value="Solicitar prestamos" name="btnSolicitarPrestamo" class="btn btn-primary" ></input>
					</div>
				</div>
				
				</form>

				
			</div>
			<div>
				
				
			</div>
			
		</div>
	</div>
	
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>