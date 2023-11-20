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
 
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Login</title>
</head>
<body>

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
                            <option value="Argentina">Argentina</option>
                            <option value="Peru">Perú</option>
                            <option value="Uruguay">Uruguay</option>
                            <option value="Brasil">Brasil</option>
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
                    	<%
                    			List <Provincias> ListaProv = null;
                    			int locali = 0;
			            		if(request.getAttribute("ListaProvincias") !=null)
			            		{
			            			ListaProv = (List<Provincias>)request.getAttribute("ListaProvincias");
			            		}
			            %>
			            
                        <select class="form-control mb-3" id="provincias" name="provincia" placeholder="Provincia" onchange="cambia_localidad()">
                        	<option value="predeterminada" selected>Seleccione Provincia</option>
                        	
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
                        <select class="form-control mb-3" id="localidad" name="localidad" placeholder="Localidad">
                        	<option value="predeterminada" selected>Seleccione Localidad</option>
                            
                            		
            				
                        </select>
                        
                        
                        
                        
                        
                        
                        
                        
                        <!-- <input type="text" class="form-control" id="localidad" name="localidad" required placeholder="Localidad"> -->
                    </div>
                    
                    <div class="form-group mb-3">
                        
                        <input type="DNI" class="form-control" id="dni" name="dni" required placeholder="DNI">
                    </div>
                    <div class="form-group mb-3">
                        
                        <input type="tel" class="form-control" id="telefono" name="telefono" required placeholder="Telefono">
                    </div>
                </div>
            </div>
			<div class="text-center mt-2">
				<input type="submit" value="Registrarse" name="btnRegistrarse" class="btn btn-primary" ></input>
			</div>
			
			<%
			if(request.getAttribute("EstadoAlta") !=null){
				if((boolean)request.getAttribute("EstadoAlta")==true){
				%>
            	<h3>Registrado exitosamente</h3>
            	<h3><%= locali %></h3>
            	<%}%>
            <%
	            if((boolean)request.getAttribute("EstadoAlta")==false){%>
	            	<h3>No puedo registrarse</h3>
	            	<h3><%= locali %></h3>
	            <%}%>	
            <%}%>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
  
  </div>
</section>


						<!-- FUNCION JAVASCRIPT -->{
                        <script type="text/javascript">
                        var localidades = [];
                        
                        <%	
		            		if(ListaLoc!=null)
		            		//for(int i=0; i < 5; i++){
		            		for(Localidades Loc : ListaLoc){
	    				%>
	    				localidades.push( ["<%=Loc.getCodProvincia_Loc() %>","<%=Loc.getCodLocalidad_Loc() %>","<%= Loc.getNombre_Loc() %>"] );                          
	                    <%} %>
                        
                        	function cambia_localidad(){
                        		
                        		var provincia = document.getElementById('provincias');
                        		var locSelect = document.getElementById('localidad');                    		
                        		
                        		if(provincia!=0){
                        			
                        			locSelect.innerHTML = '<option value="predeterminada" selected>Seleccione Localidad</option>';
                        			
                        			for (var i=0; i < localidades.length; i++) {
                            			if(provincia.value == localidades[i][0]){
	                        				var opt = document.createElement('option');
	                            		    opt.value = localidades[i][1];
	                            		    opt.innerHTML = localidades[i][2];
	                            		    locSelect.append(opt);
                            			}
                        			}
                        		}
                        	}
                        
                        </script>



</body>
</html>