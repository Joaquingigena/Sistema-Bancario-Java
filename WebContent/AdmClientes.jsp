<%@page import="entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
	
	.dataTables_wrapper .dataTables_paginate .paginate_button {
    margin: 0 5px; /* Ajusta el valor de margen según sea necesario */
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script type="text/javascript">
        $(document).ready(function () {
            $('#tablaClientes').DataTable({
                language: {
                    paginate: {
                        first: "Primero",
                        previous: "Anterior",
                        next: "Siguiente",
                        last: "Ultimo"
                    },
                },
                lengthMenu: [ [5, 25, -1], [10, 25, "All"] ],
                "bLengthChange" : false,
                "bFilter": false,
                "bInfo": false
            });
        });
    </script>
<title>Clientes</title>
</head>
<body>

<%
	String nombre = (String)request.getAttribute("usuario");
	List<Usuario> listaClientes= new ArrayList<Usuario>();

	if(request.getAttribute("cargar")!=null){
		listaClientes= (ArrayList<Usuario>)request.getAttribute("cargar");
	}
	
	Usuario user= new Usuario();
	
	if(request.getAttribute("modificar")!= null){
		 user= (Usuario)request.getAttribute("modificar");
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
               	<a class="nav-link active" href="ServletAdmin?btnSolicitudes=Ver solicitudes de cuenta&usuario=<%= nombre %>"> Lista de solicitudes</a>
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
            <input type="text" class="form-control"  id="filtroValor" onkeyup="filtroRapido()" placeholder="Buscar usuario">
        </div>
        <script>
        	function filtroRapido(){
        		
        		var filtro= document.getElementById("filtroValor").value.toLowerCase();;
        		var tablaClientes= document.getElementById("tablaClientes")
        		var filas= tablaClientes.getElementsByTagName("tr");
        		
        		for (var i = 1; i < filas.length; i++) {  
                    var nombreUsuario = filas[i].getAttribute("data-nombre").toLowerCase();
                    if (nombreUsuario.includes(filtro)) {
                        filas[i].style.display = "";
                    } else {
                        filas[i].style.display = "none";
                    }
                }
        	}
        </script>
        <!--
        <div class="col-auto">
            <select class="form-control" id="filtroCampo">
                <option value="nombre">N° Cliente</option>
                <option value="id">DNI</option>
            </select>
        </div>
        -->
        <div class="col-auto">
            <input type="submit" name="btnBuscar" value="Buscar" class="btn btn-primary" >
        </div>
    </div>
    
	
	
    <div class="container-fluid">
        <div class="row d-flex justify-content-center my-3">
            <div class="col-3 titulo">
               
                <h3 >Listado de clientes</h3>
            </div>
          	<!--<form action="ServletAdmin" method="get">
          		<div>
                	<input type="text" name="usuario" value="<%=nombre%>" style="display: none;">
					<input type="submit" name="btnSolicitudes" value="Ver solicitudes de cuenta" class="btn btn-secondary btn"> 
           		</div>
          	</form>-->
           
        </div>

        <div class="row d-flex justify-content-center">
            <div class="col-8">
                <table class="table" id="tablaClientes">
                    <thead>
                      <tr >
                        
                        <th scope="col">N° cliente</th>
                        <th scope="col">Usuario</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Dni</th>
                        <th scope="col">Correo</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        
                      </tr>
                    </thead>
                    <tbody class="table-group-divider">
                      
                      <%
	                      Random random = new Random();
	                      
	                      // Generar un número aleatorio de 8 dígitos
	                      int min1 = 100000000; 
	                      int max1 = 999999999; 
	                      int numero1 = random.nextInt(max1 - min1 + 1) + min1;

                      if(listaClientes!=null){                   	  
                    	  for(Usuario u : listaClientes){
                    		  %>
                    		 <tr data-nombre="<%=u.getUsuario_U() %>">
		                        <td><%= u.getIdUsuario_U() %></td>
		                        <td><%=u.getUsuario_U() %></td>
		                        <td><%=u.getIdPersona_U().getNombre_P() %></td>
		                        <td><%=u.getIdPersona_U().getApellido_P() %> </td>
		                        <td><%=u.getIdPersona_U().getDNI_P()%> </td> 
		                        <td><%=u.getIdPersona_U().getCorreo_P() %></td>
			                    <td style="width:400px;">
	                    			<button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#Modal<%=u.getIdUsuario_U()%>">Abrir cuenta</button>
	                    			
	                    			<!-- DIV MODAL ALTA CUENTA -->
									<div class="modal fade" id="Modal<%= u.getIdUsuario_U()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	                    			<form action="ServletCuenta" method="post">
	                    				<input type="hidden" name="idUsuario" value="<%=u.getIdUsuario_U() %>">
									  <div class="modal-dialog modal-dialog-centered">
									    <div class="modal-content">
									      <div class="modal-header">
									        <h1 class="modal-title fs-5" id="exampleModalLabel">Alta Cuenta</h1>
									        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
									      </div>
									      <div class="modal-body" Style="display:flex;">
									      	<div>
										        <div><b>ID: </b><%= u.getIdUsuario_U()%></div>
										        <div><b>DNI:</b> <%= u.getIdPersona_U().getDNI_P()%></div>
									      		<div><b>Nombre:</b> <%= u.getIdPersona_U().getNombre_P()%></div>
										        <div><b>Apellido: </b><%= u.getIdPersona_U().getApellido_P()%></div>
										        <div><b>Mail: </b><%= u.getIdPersona_U().getCorreo_P() %></div>
									      	</div>
									        <div style="margin-left: 10%;display:flex;flex-direction:column;">
									        	<b>Tipo de Cuenta</b>
									        	<div class="form-check">
												  <input class="form-check-input" type="radio" name="radioBtn" id="1" value="1" checked>
												  <label class="form-check-label" for="flexRadioDefault1">
												    Caja de Ahorro $
												  </label>
												</div>
												<div class="form-check">
												  <input class="form-check-input" type="radio" name="radioBtn" id="2" value="2">
												  <label class="form-check-label" for="flexRadioDefault2">
												    Cuenta Corriente
												  </label>
												</div>
									        	<b>Nro. CBU</b>
									        	<input type="text" readonly name="nroCbu" value="<%=numero1%>">
									        	<b>Monto inicial</b>
									        	<input type="number" name="montoInicial" value="10000">
									        	<b>Detalle</b>
									        	<input type="text" name="detalle" value="Apertura de cuenta">
									        </div>
									        
									      </div>
									      <div class="modal-footer">
									        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
									        <input name="btnAltaCuenta" type="submit" value="Guardar" class="btn btn-primary" />
									      </div>
									    </div>
									  </div>
							        </form>
										<!-- FIN DIV MODAL ALTA CUENTA -->
									</div>
			                    	</td>
				                        <td> 
				                        <a href="ServletAdmin?modificarCliente=<%=u.getIdUsuario_U()%>&usuario=<%= nombre %>" class="btn btn-primary" >Modificar </a>
						                   
				                         </td>
				                        <td> <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modalEliminar<%=u.getIdUsuario_U()%>"> Eliminar</button>
				                        
				                        
				                        <!-- Modal -->
										<div class="modal fade" id="modalEliminar<%=u.getIdUsuario_U()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
										  <div class="modal-dialog">
										    <div class="modal-content">
										      <div class="modal-header">
										        <h1 class="modal-title fs-5" id="exampleModalLabel">Eliminar cliente</h1>
										        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
										      </div>
										      <div class="modal-body">
										        Estas seguro que desea eliminar al cliente <%=u.getUsuario_U()  %>
										      </div>
										      <div class="modal-footer">
										        <a href="ServletAdmin?eliminarCliente=<%=u.getIdUsuario_U()%>" class="btn btn-danger" >Eliminar </a>
										        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
										      </div>
										    </div>
										  </div>
</div>
 </td>
		                     		 </tr>
		                    		<%
                    	  				}
                    	  			} 
		                    		%>

                    </tbody>
                  </table>
                          <div class="card-footer">
          <nav aria-label="Page navigation example">
            <ul class=".dataTables_wrapper .dataTables_paginate .paginate_button">
               
            </ul>
        </nav>
      </div>
            </div>
            
        </div>
    </div>

<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>