<%@page import="entidades.Movimientos"%>
<%@page import="entidades.Usuario"%>
<%@page import="entidades.Cuenta"%>
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

<title>Movimientos</title>
</head>
<body>
<%
	String nombre = (String)request.getAttribute("nombre");

List<Movimientos> listaMovimientos= new ArrayList<Movimientos>();

if(request.getAttribute("Movimientos")!=null){
	listaMovimientos= (ArrayList<Movimientos>)request.getAttribute("Movimientos");
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
                <a class="nav-link active" aria-current="page" href="Inicio.jsp"> Usuario</a>
              </li>
              <ion-icon name="person-circle-outline"></ion-icon> <b><%= nombre %></b>   
              <li class="nav-item">
                <a class="nav-link" href="Login.jsp">Cerrar Sesion</a>
              </li>
            </ul>
          </div>
        </div>
    </nav>
	<div id="General">
		<div id="Navegacion">
			<label style="text-align:center; margin: 10%;">Nombre Usuario</label>
			<div class="btn-group-vertical" role="group" aria-label="Vertical radio toggle button group">
			  
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio1" autocomplete="off" checked href="Movimientos.jsp">
			  <label class="btn btn-outline-danger" for="vbtn-radio1">Movimientos</label>
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio2" autocomplete="off" href="Transferencias.jsp">
			  <label class="btn btn-outline-danger" for="vbtn-radio2">Transferencias</label>
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio3" autocomplete="off" href="Prestamos.jsp">
			  <label class="btn btn-outline-danger" for="vbtn-radio3">Prestamos</label>
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio4" autocomplete="off" href="PagosPrestamos.jsp">
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
					<h2>Movimientos</h2>
				</div>
				<div style="display:flex;">
					<h5 style="margin:25px">Cuenta: </h5>
					<form action="ServletMovimientos" method="GET">
				    <div style="display:flex;">
				        <h5 style="margin:25px">Cuenta: </h5>
				        <select name="numCuenta" style="height: 40px; width:500px; margin: 15px" class="form-select" aria-label="Default select example">
				            <option selected>Seleccione una cuenta</option>
				            <option value="1">Cuenta 1</option>
				            <option value="2">Cuenta 2</option>
				            <option value="3">Cuenta 3</option>
				        </select>
				        <input type="hidden" name="idUsuario" value="<%= nombre %>">
				        <button type="submit" class="btn btn-success">Buscar</button>
				    </div>
				</form>
				</div>
				<div class="border border-success m-3 p-4" style="width: 620px">
	    <span class="rounded bg-success p-2 h3 mx-3"><b>CA$</b></span> <b class="h3"> $ 540.678,89</b>
	    <div style="margin-left:95px; padding:5px">Caja de ahorro en pesos <b>452787-56-7</b></div>
	</div>
	<div>
	    <div id="Busqueda">
	        <h5>Busqueda</h5>
	        <h7>Desde: </h7>
	        <input type="date">
	        <h7>Hasta: </h7>
	        <input type="date">
	        <button type="button" class="btn btn-success">Buscar</button>
	    </div>
	    <table style="margin:25px;" class="table table-striped table-hover">
	        <thead>
	            <tr class="table-primary">
	                <th>Numero de Movimiento</th>
	                <th>Fecha</th>
	                <th>Detalle</th>
	                <th>Importe</th>
	                <th>Tipo movimiento</th>
	            </tr>
	        </thead>
                    <tbody class="table-group-divider">
                      <%
                      if(listaMovimientos!=null){                   	  
                    	  for(Movimientos m : listaMovimientos){
                    		  %>
                    		 <tr>
                    		    <td><%= m.getNumMovimiento_M() %></td>
		                        <td><%= m.getFechaMovimiento_M() %></td>
		                        <td><%= m.getDetalle_M() %></td>
		                        <td><%= m.getImporte_M() %></td>
		                        <td><%= m.getIdTipoMovimiento_M().getDescripcion_TM() %> </td>
			                        
                     		 </tr>
                    		  <%
                    	  }
                    	  
                      }
                      
                      
                      %>
                    </tbody>
	    </table>
	</div>

	
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>