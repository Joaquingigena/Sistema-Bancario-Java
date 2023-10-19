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
<title>LOgin</title>
</head>
<body>

<div class="container text-center ">
        <div class="row ">
            <section class="col-6 ingreso ">
                <div class="logo text-center">
                    <h1>Banco Grupo 4</h1>
                </div>
                <h3>Inicia sesion</h3>
                <form>
                    <div class="col-4">
                      <label for="exampleInputEmail1" class="form-label">Usuario</label>
                      <input type="text" class="form-control" id="exampleInputEmail1" >
                      
                    </div>
                    <div class="col-4">
                      <label for="exampleInputPassword1" class="form-label">Contraseña</label>
                      <input type="password" class="form-control" id="exampleInputPassword1">
                    </div>
                    
                    <input type="submit" class= "btn btn-secondary" value="Ingresar">
                  </form>

                  <p class="text-body-dark">
                    No tienes cuenta?<a href="#" class="text-reset">Registrate</a>.
                  </p>

            </section>


    </div>
    </div>

</body>
</html>