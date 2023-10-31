<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
 
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Login</title>
</head>
<body>
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
	                <a class="nav-link active" aria-current="page" href="Inicio.jsp"> Inicio</a>
	              </li>
	              <li class="nav-item">
	                <a class="nav-link" href="Login.jsp"></a>
	              </li> 
	        </ul>  
          </div>
        </div>
    </nav>
<div class="container text-center">
    <div class="row">
        <section class="col-md-6 mx-auto ingreso">
            <div class="logo text-center">
                <h1>Banco Grupo 4</h1>
            </div>
            <h3>Inicia sesión</h3>
            <form method="post" action="ServletUsuario">
                <div class="text-center">
                    <label for="exampleInputEmail1" class="form-label">Usuario</label>
                    <input type="text" class="form-control" name="usuario">
                </div>
                <div class="text-center">
                    <label for="exampleInputPassword1" class="form-label">Contraseña</label>
                    <input type="password" class="form-control" name="password">
                </div>
				<div class="mt-3">
                	<input type="submit" class="btn btn-success" value="Ingresar" name="btnIngresar">
                </div>
            </form>

            <p class="text-body-dark">
                ¿No tienes cuenta? <a href="Registrarse.jsp" class="text-reset">Regístrate</a>.
            </p>
        </section>
    </div>
</div>

</body>
</html>