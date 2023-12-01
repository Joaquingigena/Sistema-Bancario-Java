<%@page import="entidades.Usuario"%>
<%@page import="entidades.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.List"%>
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

<title>Transferencias</title>
 
</head>
<body>
<%
	String nombre = (String)request.getParameter("usuario");

ArrayList <Cuenta> listaCuentasOrigen = null;
if (request.getAttribute("cuentas")!=null) listaCuentasOrigen=(ArrayList <Cuenta>)request.getAttribute("cuentas");

ArrayList <Cuenta> listaCuentasDestino = null;
if (request.getAttribute("listaCuentasDestino")!=null) listaCuentasDestino=(ArrayList <Cuenta>)request.getAttribute("listaCuentasDestino");

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
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio2" autocomplete="off" checked href="ServletMovimientos?Param=transferencias&usuario=<%=nombre%>">
			  <label class="btn btn-outline-danger" for="vbtn-radio2">Transferencias</label>
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio3" autocomplete="off" href="ServletMovimientos?Param=prestamos&usuario=<%=nombre%>">
			  <label class="btn btn-outline-danger" for="vbtn-radio3">Prestamos</label>
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio4" autocomplete="off" href="ServletMovimientos?Param=pagos&usuario=<%=nombre%>">
			  <label class="btn btn-outline-danger" for="vbtn-radio4">Pagos</label>
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio5" autocomplete="off" href="ServletAdmin?Param=misDatos&Nombre=<%= nombre %>">
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
            <h2>Transferencias</h2>
        </div>
	<div class="d-flex justify-content-center">
        <div id="Primario">
            <form action="ServletTransferencia" method="post">
                <!-- Cuenta origen -->
                <div class="col-md-12">
                <label for="ddlCuentaOrigen">Cuenta origen</label>
                	<input type="hidden" name="usuario" value="<%=nombre %>"/>
                    <select name="ddlCuentaOrigen" class="form-select" required>
                        <% if (listaCuentasOrigen != null)
                            for (Cuenta cuenta : listaCuentasOrigen) { %>
                                <option value=<%=cuenta.getNumCuenta_Cta() %>><%=" CBU: "+ cuenta.getCBU_Cta() + " - " + " Saldo $"+ cuenta.getSaldo_Cta() %></option>
                        <% } %>
                    </select>
                    
                </div>
                <br>
                <!-- Cuenta destino -->
                <div class="col-md-12">
                	<label for="CBUDestino">Cuenta destino</label>
                    <input type="text" class="form-control" name="CBUDestino" placeholder="CBU destino" required />                    
                </div>
                <div class="container text-center">
					  <div class="row">
					    <div class="col form-floating mb-3">
					      	<input type="text" class="form-control" name="nombreDestino" placeholder="-" required />
                        	<label for="nombreDestino">Nombre</label>
					    </div>
					    <div class="col form-floating mb-3">
					     	<input type="text" class="form-control" name="apellidoDestino" placeholder="-" required />
                        	<label for="apellidoDestino">Apellido</label>
					    </div>
					  </div>
					</div>
                <br>
                <!-- Detalle -->
                <div class="col-md-12">
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" name="txtDetalle" placeholder="-" required />
                        <label for="txtDetalle">Detalle</label>
                    </div>
                </div>
                <!-- Importe -->
                <div class="col-md-12">
                    <div class="form-floating mb-3">
                        <input type="number" step=0.01 class="form-control" name="txtImporte" placeholder="-" required />
                        <label for="txtImporte">Importe</label>
                    </div>
                </div>
                <br>
                <!-- Botón de transferir -->
                <div class="col-md-12">
                    <input type="submit" class="btn btn-outline-success form-control btn-lg" name="btnTransferir" value="Transferir" min=0.01 onclick="return confirm('¿Está seguro de realizar esta transferencia?')" />
                </div>
            </form>
        </div>
	</div>
    </div>
	<%
int mensaje=-3;
if (request.getAttribute("mensaje")!=null) mensaje=(int)request.getAttribute("mensaje");   

                		
Boolean importeNegativo = false;
if (request.getAttribute("importeNegativo")!=null) {
	importeNegativo= (boolean)request.getAttribute("importeNegativo");
}
%>  



    <div style="display: flex; justify-content: center;">
    
  		<%
	    if (importeNegativo == true){
	    %>
	   <div ID="MsgErrorDiv" class="col-md-4 alert alert-danger" runat="server" visible="false">
	         <strong>Error</strong> El importe no debe ser negativo!
	         <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
	   </div>
       <%}%>    
        <%
        if (mensaje == -2){
        %>
        <div ID="MsgErrorDiv" class="col-md-4 alert alert-danger" runat="server" visible="false">
            <strong>Error</strong> La cuenta de origen no puede ser la misma que la de destino.
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
        <%
        }
        else if (mensaje == -1){
        %>
        <div ID="MsgErrorDiv" class="col-md-4 alert alert-danger" runat="server" visible="false">
            <strong>Error</strong> La cuenta no tiene saldo disponible para la transferencia.
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
        <%
        }
        else if (mensaje == 0){
        %>
        <div ID="MsgErrorDiv" class="col-md-4 alert alert-danger" runat="server" visible="false">
            <strong>Error</strong> Hubo un error al realizar la transferencia.
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
        <%
        }
        else if (mensaje == 1){
        %>
        
        <div ID="MsgCorrectoDiv" class="col-md-4 alert alert-success" runat="server" visible="false">
            <strong>Correcto</strong> Transferencia realizada correctamente!
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
        <%
        }
        %>
   </div>
	
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>