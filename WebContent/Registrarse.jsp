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
      
      <form>
            <div class="row bg-secondary border-dark rounded ">
                <!-- Primera Columna -->
                <div class="col-md-6 align-items-center mt-3">
                    <div class="form-group mb-3 ">
                        
                        <input type="text" class="form-control " id="nombre" name="nombre" required placeholder="Nombre">
                    </div>
                    <div class="form-group mb-3">
                        
                        <input type="text" class="form-control" id="apellido" name="apellido" required placeholder="Apellido">
                    </div>
                    <div class="form-group mb-3">
                        
                        <input type="email" class="form-control" id="email" name="email" required placeholder="example@email.com">
                    </div>
                    <div class="form-group mb-3">
                        
                        <input type="text" class="form-control" id="direccion" name="direccion" required placeholder="Direccion">
                    </div>
                    <div class="form-group mb-3">
                        
                        <input type="text" class="form-control" id="cuil" name="cuil" required placeholder="CUIL">
                    </div>
                    <div class="form-group mb-3">
                        
                        <input type="date" class="form-control" id="fechaNac" name="fechaNac" required placeholder="Fecha de Nacimiento">
                    </div>
                </div>

                <!-- Segunda Columna -->
                <div class="col-md-6 align-items-center mt-3">
                    
                    <div class="form-group mb-3">
                        
                        <select class="form-control mb-3" id="nacionalidad" name="nacionalidad" placeholder="Nacionalidad">
                        	<option value="predeterminada" selected>Ejila su Nacionalidad</option>
                            <option value="opcion1">Argentina</option>
                            <option value="opcion2">Perú</option>
                            <option value="opcion2">Uruguay</option>
                            <option value="opcion2">Brasil</option>
                            <!-- Agrega más opciones según sea necesario -->
                        </select>
                    </div>
                    <div class="form-group mb-3">
                        
                        <select class="form-control mb-3" id="sexo" name="sexo" placeholder="Sexo">
                        	<option value="predeterminada" selected>Ejila su Sexo</option>
                            <option value="masculino">Masculino</option>
                            <option value="femenino">Femenino</option>
                            <option value="Otro">Otro</option>
                            <!-- Agrega más opciones según sea necesario -->
                        </select>
                    </div>
                    <div class="form-group mb-3">
                        
                        <input type="text" class="form-control" id="localidad" name="localidad" required placeholder="Localidad">
                    </div>
                    <div class="form-group mb-3">
                        
                        <input type="text" class="form-control" id="provincia" name="provincia" required placeholder="Provincia">
                    </div>
                    <div class="form-group mb-3">
                        
                        <input type="tel" class="form-control" id="telefono" name="telefono" required placeholder="Telefono">
                    </div>
                </div>
            </div>
			<div class="text-center mt-2">
				<input type="submit" value="Registrarse" name="btnRegistrarse" class="btn btn-primary" ></input>
			</div>
            
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
  
  </div>
</section>
</body>
</html>