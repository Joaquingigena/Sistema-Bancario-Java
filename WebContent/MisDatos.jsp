<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Usuario"%>
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

<title>Mis Datos</title>
</head>
<body>
<%
	String nombre = (String)request.getParameter("Nombre");;

    Usuario user= new Usuario();

    if(request.getAttribute("datos")!= null){
	 user= (Usuario)request.getAttribute("datos");
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
				<h2>Mis datos</h2>
			</div>
<form action="ServletAdmin" method="get">
    <div class="container">
<div id="DNICliente" style="margin-top:20px; display:flex; align-items:center">
					<h5>DNI </h5>
					<div style="width: 200px">
					<input readonly type="text" class="form-control" value= "<%=user.getIdPersona_U().getDNI_P()%>" aria-label="DNI" aria-describedby="basic-addon1" style="margin-left: 40px;">
					</div>
				</div>
                <div id="CUILCliente" style="margin-top:20px; display:flex; align-items:center">
					<h5>CUIL </h5>
					<div style="width: 200px">
					<input readonly type="text" class="form-control" value= "<%=user.getIdPersona_U().getCUIL_P()%>" aria-label="CUIL" aria-describedby="basic-addon1" style="margin-left: 40px;">
					</div>
				</div>
                <div id="NombreCliente" style="margin-top:20px; display:flex; align-items:center">
					<h5>Nombre </h5>
					<div style="width: 200px">
					<input readonly type="text" class="form-control" value= "<%=user.getIdPersona_U().getNombre_P()%>" aria-label="Nombre" aria-describedby="basic-addon1" style="margin-left: 40px;">
					</div>
				</div>
                <div id="ApellidoCliente" style="margin-top:20px; display:flex; align-items:center">
					<h5>Apellido </h5>
					<div style="width: 200px">
					<input readonly type="text" class="form-control" value= "<%=user.getIdPersona_U().getApellido_P()%>" aria-label="Apellido" aria-describedby="basic-addon1" style="margin-left: 40px;">
					</div>
				</div>
                <div id="DireccionCliente" style="margin-top:20px; display:flex; align-items:center">
					<h5>Direccion </h5>
					<div style="width: 200px">
					<input readonly type="text" class="form-control" value="<%=user.getIdPersona_U().getDireccion_P()%>" aria-label="Direccion" aria-describedby="basic-addon1" style="margin-left: 40px;">
					</div>
				</div>
                <div id="CorreoCliente" style="margin-top:20px; display:flex; align-items:center">
					<h5>Correo </h5>
					<div style="width: 200px">
					<input readonly type="text" class="form-control" value="<%=user.getIdPersona_U().getCorreo_P()%>" aria-label="Correo" aria-describedby="basic-addon1" style="margin-left: 40px;">
					</div>
				</div>
                <div id="TelefonoCliente" style="margin-top:20px; display:flex; align-items:center">
					<h5>Numero de Telefono </h5>
					<div style="width: 200px">
					<input readonly type="text" class="form-control" value="<%=user.getIdPersona_U().getTelefono_P()%>" aria-label="Telefono" aria-describedby="basic-addon1" style="margin-left: 40px;">
					</div>
				</div>
                <div id="UsuarioCliente" style="margin-top:20px; display:flex; align-items:center">
					<h5>Usuario </h5>
					<div style="width: 200px">
					<input readonly type="text" class="form-control" value="<%=user.getUsuario_U() %>" aria-label="Username" aria-describedby="basic-addon1" style="margin-left: 40px;">
					</div>
				</div>
					<div id="contraCliente" style="display:flex; margin:0; margin-top: 20px; align-items:center;">
					  <h5>Contraseña </h5>
					  <input type="text" class="form-control"  value="<%=user.getPassword_U() %>" aria-label="Contraseña" aria-describedby="basic-addon1" style="margin: 0; margin-left: 20px; width: 200px">
					        	<div class="col-3">
         		<input type="submit" name="btnAceptarModificacion" class="btn btn-primary" value="Aceptar">
         	</div>
					</div>
					</div>
					</form>
                
	  </div>


			<div>
				
				
			</div>
			
		</div>
	
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>