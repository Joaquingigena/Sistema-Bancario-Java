<%@page import="entidades.Localidades"%>
<%@page import="entidades.Provincias"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Login</title>
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
	                <a class="nav-link active" aria-current="page" href="Inicio.jsp"> Inicio</a>
	              </li>
	              <li class="nav-item">
	                <a class="nav-link" href="Login.jsp">Iniciar Sesion</a>
	              </li> 
	        </ul>  
          </div>
        </div>
    </nav>

<!--========================================================== -->
                      <!-- CONTENEDOR DEL FORMULARIO -->
<!--========================================================== -->
	
  <div class="container  border-top border-primary " style="max-width: 500px" id="contenedor-formulario">
      <div class="text-center mb-4" id="titulo-formulario">
        <h2>Registrarse</h2>
      </div>
      
      <form action="ServletAdmin" method="get" name=registrar>
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
                        
                        <input  type="text" maxlength="11" minlength="10" class="form-control" id="cuil" name="cuil" required placeholder="CUIL">
                    </div>
                    <div class="form-group mb-3">
                        
                        <input type="date" class="form-control" id="fechaNac" name="fechaNac" required placeholder="Fecha de Nacimiento">
                    </div>
                </div>

                <!-- Segunda Columna -->
                <div class="col-md-6 align-items-center mt-3">
                    
                    <div class="form-group mb-3">
                        
                        <select class="form-control mb-3" required id="nacionalidad" name="nacionalidad" placeholder="Nacionalidad">
                        	<option value="" selected>Ejila su Nacionalidad</option>
                            <option value="Argentina">Argentina</option>
                            <option value="Peru">Perú</option>
                            <option value="Uruguay">Uruguay</option>
                            <option value="Brasil">Brasil</option>
                            <!-- Agrega más opciones según sea necesario -->
                        </select>
                    </div>
                    <div class="form-group mb-3">
                        
                        <select class="form-control mb-3" required id="sexo" name="sexo" placeholder="Sexo">
                        	<option value="" selected>Ejila su Sexo</option>
                            <option value="masculino">Masculino</option>
                            <option value="femenino">Femenino</option>
                            <option value="Otro">Otro</option>
                            <!-- Agrega más opciones según sea necesario -->
                        </select>
                    </div>     
                    
                    <div class="form-group mb-3">
                    	<%
                    			List <Provincias> ListaProv = null;
                    			int locali = 0;
			            		if(request.getAttribute("ListaProvincias") !=null)
			            		{
			            			ListaProv = (List<Provincias>)request.getAttribute("ListaProvincias");
			            		}
			            %>
			            
                        <select class="form-control mb-3" required id="provincias" name="provincia" placeholder="Provincia" onchange="cambia_localidad()">
                        	<option value="" selected>Seleccione Provincia</option>
                        	
                        	<%	
			            		if(ListaProv!=null)
			            		//for(int i=0; i < 5; i++){
			            		for(Provincias Prov : ListaProv){
            				%>
            				<option value="<%=Prov.getCodProvincia_Prov() %>"><%= Prov.getNombre_Prov() %></option>                          
                            <%} %>
                        </select>
                    </div>
                    
                    <div class="form-group mb-3">
                    	<%
                    		
			            		List <Localidades> ListaLoc = null;
			            		if(request.getAttribute("ListaLocalidades") !=null)
			            		{
			            			ListaLoc = (List<Localidades>)request.getAttribute("ListaLocalidades");
			            		}
			            %>
                        <select class="form-control mb-3" required id="localidad" name="localidad" placeholder="Localidad">
                        	<option value="" selected>Seleccione Localidad</option>	  				
                        </select>
                        
                        
                        
                        
                        
                        
                        
                        
                        <!-- <input type="text" class="form-control" id="localidad" name="localidad" required placeholder="Localidad"> -->
                    </div>
                    
                    <div class="form-group mb-3">
                        
                        <input type="DNI" maxlength="9" minlength="7" class="form-control" id="dni" name="dni" required placeholder="DNI">
                    </div>
                    <div class="form-group mb-3">
                        
                        <input type="tel" maxlength="15" class="form-control" id="telefono" name="telefono" required placeholder="Telefono">
                    </div>
                </div>
            </div>
			<div class="text-center mt-2">
				<input type="submit" value="Registrarse" name="btnRegistrarse" class="btn btn-primary" ></input>
			</div>
				
			<%
			if(request.getAttribute("Mensaje") !=null){
				String mens = "chacha";
				if(request.getAttribute("Mensaje").toString() == ""){
					
				if((boolean)request.getAttribute("EstadoAlta")==true){
				%>
					<script type="text/javascript">
								Swal.fire({
									  title: "Registro exitoso!",
									  text: "El banco se contactará con usted a la brevedad.",
									  icon: "success",
									  confirmButtonColor: "#43B814",
									  allowOutsideClick: false
								}).then((result) => {
	            					if(result.isConfirmed){
	            						location.href ='Inicio.jsp';
	            					}
	            				});
					</script>
					
            	<%}%>
            <%
	            if((boolean)request.getAttribute("EstadoAlta")==false){
	            	if((boolean)request.getAttribute("Existe")){
	            	%>
	            		<script type="text/javascript">
									Swal.fire({
										  title: "Ya existe un registro con el DNI ingresado",
										  text: "Por favor pongase en contacto con el banco.",
										  icon: "warning",
										  confirmButtonColor: "#43B814",
										  allowOutsideClick: false
		            				}).then((result) => {
	            					if(result.isConfirmed){
	            						location.href ='Inicio.jsp';
	            					}
	            				});
						</script>
	            	<%
	            	}else{
	            	%>	
	            		<script type="text/javascript">
							Swal.fire({
								  title: "No pudo registrarse",
								  text: "Por favor vuelva a intentarlo.",
								  icon: "error",
								  confirmButtonColor: "#DE3419",
								  allowOutsideClick: false,
	        				});		
						</script>
	            	<% }%>
	            <%}%>
	           <%} else{ %>	
            	<script type="text/javascript">
							Swal.fire({
								  title: "No pudo registrarse",
								  text: "El DNI no corresponde al CUIL ingresado.",
								  icon: "error",
								  confirmButtonColor: "#DE3419",
								  allowOutsideClick: false,
	        				});		
				</script>
            
            <%}%>
            <%} %>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
  
  </div>
</section>


						<!-- FUNCION JAVASCRIPT -->
                        <script type="text/javascript">
                        var localidades = [];
                        
                        <%	
		            		if(ListaLoc!=null)
		            		// Recorro localidades
		            		for(Localidades Loc : ListaLoc){
		    			%>
		    				// Agrego al vector localidades de JS cada localidad de la tabla. 
		    				localidades.push( ["<%=Loc.getCodProvincia_Loc() %>","<%=Loc.getCodLocalidad_Loc() %>","<%= Loc.getNombre_Loc() %>"] );                          
		                <%} %>
                        
                        	function cambia_localidad(){
                        		
                        		// Obtengo el elemento seleccionado en el SELECT "provincias".
                        		var provincia = document.getElementById('provincias');
                        		// Obtengo el elemento seleccionado en el SELECT "localidades".
                        		var locSelect = document.getElementById('localidad');                    		
                        		
                        		
                        		if(provincia!=0){
                        			locSelect.innerHTML = '<option value="" selected>Seleccione Localidad</option>';
                        			
                        			for (var i=0; i < localidades.length; i++) {
                            			if(provincia.value == localidades[i][0]){
	                        				// Creo una variable "OPTION"
                            				var opt = document.createElement('option');
	                        				// Seteo en el VALUE de la variable OPTION la posición 1 del arrey LOCALIDADES (Código localidad)
	                            		    opt.value = localidades[i][1];
	                            		 	// Seteo en el INNER de la variable OPTION la posición 2 del arrey LOCALIDADES (Nombre localidad)
	                        				opt.innerHTML = localidades[i][2];
	                            		 	// Agrego al select de localidades la opción creada. 
	                            		    locSelect.append(opt);
                            			}
                        			}
                        		}
                        	}
                        </script>

						

</body>
</html>