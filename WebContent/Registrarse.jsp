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

<!--========================================================== -->
                      <!-- CONTENEDOR DEL FORMULARIO -->
<!--========================================================== -->

  <div class="container  border-top border-primary " style="max-width: 500px" id="contenedor-formulario">
      <div class="text-center mb-4" id="titulo-formulario">
        <h2>Registrarse</h2>
      </div>
      
      <form   method="POST" data-netlify="true" action="#">     
            <div class= "mb-3">           
              <input type="email" class="form-control" id="email" name="email" placeholder="nombre@ejemplo.com">
            </div>
 
          
            <div class="mb-3">            
              <input type="input" class="form-control" id="name" name="name" placeholder="John">
            </div>
      
            <div class="mb-3">            
              <input type="input" class="form-control" id="name" name="surname" placeholder="Doe">
            </div>
            <div class="mb-3">            
              <input type="number" class="form-control" id="name" name="CUIL" placeholder="20-42882584-8">
            </div>
             <div class="mb-3">            
              <input type="date" class="form-control" id="name" name="FechaNac" placeholder="01-01-2023">
            </div>
             <div class="mb-3">            
              <input type="input" class="form-control" id="name" name="Direccion" placeholder="Calle falsa 123">
            </div>
            <div class="mb-3">
              <input type="tel" class="form-control" name="phone" id="phone" placeholder="Teléfono">
            </div>

          <div class="mb-3">
            <button type="submit" class=" btn btn-primary w-100 fs-5">Registrarse</button>
          </div>
      </form>
  
  </div>
</section>
</body>
</html>