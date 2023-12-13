<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="entidades.Usuario"%>
<%@page import="entidades.Personas"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>

<title>Solicitudes</title>
</head>
<body>

<%
	String nombre = (String)request.getAttribute("usuario");
	List<Usuario> listaClientes= new ArrayList<Usuario>();

	if(request.getAttribute("cargar")!=null){
		listaClientes= (ArrayList<Usuario>)request.getAttribute("cargar");
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
               	<a class="nav-link active" href="ServletAdmin?btnSolicitudes=Ver solicitudes de cuenta"> Lista de solicitudes</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="ServletAdmin?Param=listarClientes&usuario=<%= nombre %>"> Clientes</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="ServletCuenta?Param=listarCuentas&usuario=<%= nombre %>">Cuentas</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="ServletPrestamo?Param=listarPrestamos&usuario=<%= nombre %>">Prestamos</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="ServletInformes?Param=listarInformes&usuario=<%= nombre %>">Informes</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="Login.jsp">Cerrar sesion</a>
              </li>
	          
            </ul>
          
          </div>
        </div>
    </nav>
    
    <div class="d-flex justify-content-center">
        <div class="col-sm-4">
            <input type="text" class="form-control" id="filtroValor" placeholder="Search...">
    </div>
		<script>
	    document.getElementById('filtroValor').addEventListener('input', function() {
	        let filtro = this.value.toUpperCase();
	        let filas = document.querySelectorAll('table tr[data-nombre]');
	
	        filas.forEach(function(fila) {
	            let contenido = fila.innerText.toUpperCase();
	            fila.style.display = contenido.includes(filtro) ? '' : 'none';
	        });
	    });
	</script>
	
    </div>

    <div class="container-fluid">
        <div class="row d-flex justify-content-center">
            <div class="col-3 titulo">
               
                <h3 >Lista de solicitudes</h3>
            </div>
	        <div class="container mb-3">
				<span class="badge rounded-pill text-bg-warning"><span class="rounded-5"></span></span> A espera
				<span class="badge rounded-pill text-bg-success"><span class="rounded-5"></span></span> Aprobado
				<span class="badge rounded-pill text-bg-danger"><span class="rounded-5"></span></span> Rechazado
	        </div>
        </div>

        <div class="row">
            <div class="Cuerpo">
            	<%
            		List <Personas> ListaPer = null;
            		String dni = "";
            		if(request.getAttribute("ListaPersonas") !=null)
            		{
            			ListaPer = (List<Personas>)request.getAttribute("ListaPersonas");
            		}
            	
            	%>
            <form action="ServletAdmin" method="get">
                <table class="table table-striped" id="tablaLista">
                      <tr class="table-primary">
                        
                        <th scope="col">ID</th>
                        <th scope="col">DNI</th>
                        <th scope="col">Localidad</th>
                        <th scope="col">Provincia</th>
                        <th scope="col">CUIL</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Sexo</th>
                        <th scope="col">Nacionalidad</th>
                        <th scope="col">Fecha de Nacimiento</th>
                        <th scope="col" >Dirección</th>
                        <th scope="col">Mail</th>
                        <th scope="col">Teléfono</th>
                        <th scope="col">Estado Solicitud</th>
                        <th scope="col"></th>
                      </tr>

  						
 					<%
 						if(ListaPer!=null)
 						//for(int i=0;i<5;i++)
 						for(Personas Per : ListaPer)
 	                    {
 							
                    %>
                    
                    	<tr data-nombre="<%=Per.getDNI_P() %>" > 
	                    	<td> <%=Per.getIdPersona_P() %> </td> <td><%=Per.getDNI_P() %></td> <td><%=Per.getCodLocalidad_P().getNombre_Loc() %></td> <td><%=Per.getCodProvincia_P().getNombre_Prov() %></td> <td><%=Per.getCUIL_P() %> </td> <td><%=Per.getNombre_P() %></td> <td><%=Per.getApellido_P() %></td> <td><%=Per.getSexo_P()%></td> <td><%=Per.getNacionalidad_P() %></td> <td><%=Per.getFechaNac_P() %></td> <td><%=Per.getDireccion_P() %></td> <td><%=Per.getCorreo_P()%></td> <td><%=Per.getTelefono_P() %></td> 
	                    	<%
		                    	String ruta = "";
		                    	switch(Per.getSolicitud_P())
		                    	{
		                    	case 0:
		                    		ruta = "css/imagenes/amarillo.png";
		                    		break;
		                    			
		                    	case 1:
		                    		ruta = "css/imagenes/verde.png";
		                    		break;
		                    	case -1:
		                    		ruta = "css/imagenes/rojo.png";
		                    		break;
		                    	}
	                    	%>
	                    	<td>
	                    		<img alt="Icono" src="<%=ruta %>">
	                    	</td>
	                    	
	                    	<td style="width:300px;">
	                    		<%if(Per.getSolicitud_P()==0){ String DNI = Per.getDNI_P();%>
	                    			<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#Modal<%=DNI%>">Aceptar</button>
	                    			<!-- <input type="submit" name="btnAceptarSol" value="Aceptar"> -->
	                    			
	                    			<!-- DIV MODAL -->
							<div class="modal fade" id="Modal<%=DNI%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog modal-dialog-centered">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h1 class="modal-title fs-5" id="exampleModalLabel">Alta Usuario</h1>
							        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							      </div>
							      <div class="modal-body" Style="display:flex;">
							      	<div>
							      		<input type="hidden" name="idPersona" value="<%=Per.getIdPersona_P() %>"/>
							      		<div>Nombre: <%=Per.getNombre_P() %></div>
								        <div>Apellido: <%=Per.getApellido_P() %></div>
								        <div>DNI: <%=Per.getDNI_P() %></div>
								        <div>Dirección: <%=Per.getDireccion_P() %></div>
								        <div>Localidad: <%=Per.getCodLocalidad_P() %></div>
								        <div>Provincia: <%=Per.getCodProvincia_P() %></div>
								        <div>Mail: <%=Per.getCorreo_P() %></div>
								        <div>Sexo: <%=Per.getSexo_P() %></div>
								        <div>Nacionalidad: <%=Per.getNacionalidad_P() %></div>
								        <div>Teléfono: <%=Per.getTelefono_P() %></div>
							      	</div>
							        <div style="margin-left: 10%;display:flex;flex-direction:column;">
							        	Usuario
							        	<input type="text" name="txtUsuario">
							        	Contraseña
							        	<input type="password" name="txtPass">
							        	Repetir Contraseña
							        	<input type="password" name="txtRepetirPass">
							        </div>
							        
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
							        <button name="btnAceptarSol" type="submit" class="btn btn-primary">Guardar</button>
							      </div>
							    </div>
							  </div>
							</div>
							<!-- ---------------------------------------------------------------------------------------------- -->
	                    			
	                    	
							
							
									<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#Rech<%=DNI%>">Rechazar</button>
	                    			<!-- <input type="submit" name="btnRechazarSol" value="Rechazar"> --> 
	                    			
	                    			<!-- DIV MODAL -->
							<div class="modal fade" id="Rech<%=DNI%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog modal-dialog-centered">
							    <div class="modal-content">
							      <div style="background-color:red" class="modal-header">
							        <h1 class="modal-title fs-5" id="exampleModalLabel">ATENCIÓN!</h1>
							        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							      </div>
							      <div class="modal-body" Style="display:flex;">
							      	<div style="width:90%;">
							      		<input type="hidden" name="idPersona" value="<%=Per.getIdPersona_P() %>"/>
							      		<div>Nombre: <%=Per.getNombre_P() %> </div> 
								        <div>Apellido: <%=Per.getApellido_P() %></div>
								        <div>DNI: <%=Per.getDNI_P() %></div>
								        <div>Dirección: <%=Per.getDireccion_P() %></div>
								        <div>Localidad: <%=Per.getCodLocalidad_P() %></div>
								        <div>Provincia: <%=Per.getCodProvincia_P() %></div>
								        <div>Mail: <%=Per.getCorreo_P() %></div>
								        <div>Sexo: <%=Per.getSexo_P() %></div>
								        <div>Nacionalidad: <%=Per.getNacionalidad_P() %></div>
								        <div>Teléfono: <%=Per.getTelefono_P() %></div>
							      	</div>
							        <div style="margin-left: 0%;display:flex;flex-direction:column; text-align:center;justify-content:center;">
							        	<h3>¿Está seguro que desea rechazar esta solicitud?</h3> 
							        	
							        </div>
							        
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">NO</button>
							        <button type="submit" name="btnRechazarSol" style="background-color:red; border-color:red;" type="button" class="btn btn-primary">SI</button>
							      </div>
							    </div>
							  </div>
							</div>
							<!-- ---------------------------------------------------------------------------------------------- -->
	                    			
	                    		<%} %>
	                    		
							
	                    	</td>
							
                    	</tr>
                    

                    <%	
                    	}
                    %>
   
            	
                  </table>
                  </form>
                <%
			if(request.getAttribute("msgSol") !=null){
				%>
					<script type="text/javascript">
					var mensaje = "<%=request.getAttribute("msgSol")%>"; 
								Swal.fire({
									  title: "Registro exitoso!",
									  text: mensaje,
									  icon: "success",
									  confirmButtonColor: "#43B814",
									  allowOutsideClick: false
								}).then((result) => {
	            				});
					</script>
            <%}%>
            
                         <%
			if(request.getAttribute("msgRec") !=null){
				%>
					<script type="text/javascript">
					var mensaje = "<%=request.getAttribute("msgRec")%>"; 
								Swal.fire({
									  title: "Accion exitosa!",
									  text: mensaje,
									  icon: "success",
									  confirmButtonColor: "#43B814",
									  allowOutsideClick: false
								}).then((result) => {
	            				});
					</script>
            <%}%>
            
                   
            </div>
        </div>
    </div>

<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</body>
</html>