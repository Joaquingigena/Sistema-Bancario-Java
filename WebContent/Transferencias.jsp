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
              <li class="nav-item">
                <a class="nav-link" href="Login.jsp">Cerrar Sesion</a>
              </li>   
          </div>
        </div>
    </nav>
	<div id="General">
		<div id="Navegacion">
			<label style="text-align:center; margin: 10%;">Nombre Usuario</label>
			<div class="btn-group-vertical" role="group" aria-label="Vertical radio toggle button group">
			  
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio1" autocomplete="off" href="Movimientos.jsp">
			  <label class="btn btn-outline-danger" for="vbtn-radio1">Movimientos</label>
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio2" autocomplete="off" checked href="Transferencias.jsp">
			  <label class="btn btn-outline-danger" for="vbtn-radio2">Transferencias</label>
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio3" autocomplete="off" href="Prestamos.jsp">
			  <label class="btn btn-outline-danger" for="vbtn-radio3">Prestamos</label>
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio4" autocomplete="off" href="PagosPrestamos.jsp">
			  <label class="btn btn-outline-danger" for="vbtn-radio4">Pagos</label>
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio5" autocomplete="off" href="MisDatos.jsp">
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
			<div id="Primario">
				<form action="">
					<h5>Origen</h5>
					<div id="Cuenta Origen" style="display:flex; margin-top: 20px; align-items:center">
					  <h5>Cuenta: </h5>
					  <select style="height: 40px; width:100%; margin-left: 15px" class="form-select" aria-label="Default select example">
					  <option selected>Seleccione una cuenta</option>
					  <option value="1">Cuenta 1</option>
					  <option value="2">Cuenta 2</option>
					  <option value="3">Cuenta 3</option>
				  	  </select>
					</div>
				
				<div id=CkeckBox style="margin-top:50px; display:flex; flex-direction:column;">
					<h5>Destino</h5>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
					  <label class="form-check-label" for="inlineRadio1">Cuenta propia</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
					  <label class="form-check-label" for="inlineRadio2">Otra Cuenta</label>
					</div>
					<div id="Cuenta Destino" style="display:flex; margin-top: 20px; align-items:center">
					  <h5>Cuenta: </h5>
					  <select style="height: 40px; width:100%; margin-left: 15px" class="form-select" aria-label="Default select example">
						  <option selected>Seleccione una cuenta</option>
						  <option value="1">Cuenta 1</option>
						  <option value="2">Cuenta 2</option>
						  <option value="3">Cuenta 3</option>
					  </select>
					</div>
					<div id="CBU" style="margin-top:20px; display:flex; align-items:center">
						<h5>CBU: </h5>
						<div class="input-group mb-3" style="width:100%;">
						  <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1" style="margin-left: 40px">
						</div>
					</div>
					<div id="Monto" style="margin-top:20px; display:flex; align-items:center">
						<h5>Monto: $</h5>
						<div class="input-group mb-3" style="width:35%;">
						  <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1" style="margin-left: 2px">
						</div>
					</div>
					<div id="btnTransfereir" style="margin-top:20px; display:flex; justify-content:end; width:100%">
						<button type="button" class="btn btn-success">Transferir</button>
					</div>
				</div>
				
				</form>

				
			</div>
			<div>
				
				
			</div>
			
		</div>
	</div>
</body>
</html>