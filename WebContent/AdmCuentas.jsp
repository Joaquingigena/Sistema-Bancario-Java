<%@page import="entidades.Cuenta"%>
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

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
		.dataTables_wrapper .dataTables_paginate .paginate_button {
    margin: 0 5px; /* Ajusta el valor de margen seg�n sea necesario */
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script type="text/javascript">
        $(document).ready(function () {
            $('#tablaCuentas').DataTable({
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

<title>Cuentas</title>

</head>
<body>

<%
	String nombre = (String)request.getAttribute("usuario");

	List<Cuenta> listaCuentas= new ArrayList<Cuenta>();

	if(request.getAttribute("ListaCuentas")!=null){
		listaCuentas= (ArrayList<Cuenta>)request.getAttribute("ListaCuentas");
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
    <!-- Busqueda -->
     <!-- <form action="ServletCuenta" method="post">-->
    <div class="d-flex justify-content-center">
        <div class="col-sm-4">
            <input type="text" class="form-control" name="filtroValor" id="filtroValor" onkeyup="filtroRapido()" placeholder="Buscar N� cuenta">
        </div>
        <div class="col-sm-4">
			<input type="checkbox"  class="form-check-input" id="chkFiltro" onchange="activarFiltroAvanzado()" >
			<label class="form-check-label" for="chkFiltro">Filtro avanzado </label>
        </div>
    </div>
	 <!-- </form>-->
	<script>
	function filtroRapido(){
		
		var filtro= document.getElementById("filtroValor").value.toLowerCase();;
		var tablaCuentas= document.getElementById("tablaCuentas")
		var filas= tablaCuentas.getElementsByTagName("tr");
		
		for (var i = 1; i < filas.length; i++) {  
            var numCuenta = filas[i].getAttribute("data-nombre").toLowerCase();
            if (numCuenta.includes(filtro)) {
                filas[i].style.display = "";
            } else {
                filas[i].style.display = "none";
            }
        }
	}
	
	</script>
	
	<!-- Filtro -->
	<div id="filtroAvanzado" style="display:none;"> 
	<form action="ServletCuenta" method="post">
	<div class="container">
		<div class="row">
			<div class="col-3">
				<div class="mb-3">
				
				<label class="form-label"> Campo</label>
				<select id="ddlCampo" name="ddlCampo" class="form-control">
					<option value="usuario" >N� Usuario </option>
					<option value="fecha" > Fecha</option>
					<option value="saldo" > Saldo </option>
				</select>			
				</div>
			</div>
			<div class="col-3">
				<div class="mb-3">
				
				<label class="form-label"> Criterio</label>
				<select id="ddlCriterio" name="ddlCriterio" class="form-control">
						<option value="Contiene" >Contiene</option>
						<option value="Igual a" > Igual a</option>
						
			    </select>			
				</div>
			</div>
			<div class="col-3">
				<div class="mb-3">
				<label class="form-label"> Filtro</label>
				<input type="text" name="filtro" class="form-control"> 
				</div>
			</div>
			<div class="col-3">
				<div class="mb-3">
				<br>
				<input type="submit" name="btnFiltrar" value="Filtrar" class="btn btn-primary"> 
				</div>
				<div class="col-auto">
				<br>
                <input type="submit" name="btnQuitarFiltro" value="QuitarFiltro" class="btn btn-primary" >
                </div>
			</div>
		</div>
	</div>
	</form>
	</div>
	<script>
		var criteriosXcampos= {
				usuario:["Contiene","Igual a"],
				fecha: ["Mayor que","Menor que","Igual a"],
				saldo: ["Mayor que","Menor que","Igual a"]
		}
		
		var campoSelect = document.getElementById("ddlCampo");
        var criterioSelect = document.getElementById("ddlCriterio");
        
        campoSelect.addEventListener("change", function() {
        	
        	var lista= document.getElementById("listaCuenta");
        	console.log(lista);
        	
        	var criterios = criteriosXcampos[campoSelect.value];
        	
        	criterioSelect.innerHTML="";
        	
        	 if (criterios) {
                 criterios.forEach(function(criterio) {
                     var opcion = document.createElement("option");
                     opcion.value = criterio;
                     opcion.textContent = criterio;
                     criterioSelect.appendChild(opcion);
                 });
             }
        });
        
        
	</script>	
	
	<!-- Listado -->
    <div class="container-fluid">
        <div class="row d-flex justify-content-center my-3">
            <div class="col-3 titulo">
               
                <h3 >Cuentas</h3>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-8">
                <table class="table" id="tablaCuentas">
                    <thead>
                      <tr>
                        <th scope="col">N� cuenta</th>
                        <th scope="col">N� Usuario</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Fecha de creacion</th>
                        <th scope="col">CBU</th>
                        <th scope="col">Saldo</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        
                      </tr>
                    </thead>
                    <tbody class="table-group-divider">
                      <%
                      if(listaCuentas!=null){                   	  
                    	  for(Cuenta c : listaCuentas){
                    		  %>
                    		 <tr data-nombre="<%= c.getNumCuenta_Cta() %>">
		                        <td><%= c.getNumCuenta_Cta() %></td>
		                        <td><%= c.getIdUsuario_Cta().getIdUsuario_U() %></td>
		                        <td><%= c.getIdUsuario_Cta().getIdPersona_U().getNombre_P() %></td>
		                        <td><%= c.getIdUsuario_Cta().getIdPersona_U().getApellido_P() %></td>
		                        <td><%= c.getFechaCreacion_Cta() %></td>
		                        <td><%= c.getCBU_Cta() %> </td>
		                        <td><%= c.getSaldo_Cta() %> </td> 
		                        
		                        <td> <a href="ServletCuenta?modificarCuenta=<%=c.getNumCuenta_Cta()%>&usuario=<%=nombre%>" class="btn btn-primary" >Modificar </a> </td>
		                      
			                    <td> <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modalEliminar<%=c.getNumCuenta_Cta()%>"> Eliminar</button> </td>
				                        
				                        
				                        <!-- Modal -->
										<div class="modal fade" id="modalEliminar<%=c.getNumCuenta_Cta()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
										  <div class="modal-dialog">
										    <div class="modal-content">
										      <div class="modal-header">
										        <h1 class="modal-title fs-5" id="exampleModalLabel">Eliminar cuenta</h1>
										        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
										      </div>
										      <div class="modal-body">
										        Estas seguro que desea eliminar la cuenta N�  <%=c.getNumCuenta_Cta()%>
										      </div>
										      <div class="modal-footer">
										        <a href="ServletCuenta?eliminarCuenta=<%=c.getNumCuenta_Cta()%>" class="btn btn-danger" >Eliminar </a>
										        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
										      </div>
										    </div>
										  </div>
										  <form action="ServletCuenta" method="get">
										                  <%
			if(request.getAttribute("msgModificado") !=null){
				%>
					<script type="text/javascript">
					var mensaje = "<%=request.getAttribute("msgModificado")%>"; 
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
            
            <%
			if(request.getAttribute("msgError") !=null){
				%>
					<script type="text/javascript">
						var mensaje = "<%=request.getAttribute("msgError")%>"; 
							Swal.fire({
								  title: "Error",
								  text: mensaje,
								  icon: "error",
								  confirmButtonColor: "#DE3419",
								  allowOutsideClick: false,
	        				});		
					</script>
            <%}%>
            
            										                  <%
			if(request.getAttribute("msgEliminado") !=null){
				%>
					<script type="text/javascript">
					var mensaje = "<%=request.getAttribute("msgEliminado")%>"; 
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
            
            <%
			if(request.getAttribute("msgErrorEliminar") !=null){
				%>
					<script type="text/javascript">
						var mensaje = "<%=request.getAttribute("msgErrorEliminar")%>"; 
							Swal.fire({
								  title: "Error",
								  text: mensaje,
								  icon: "error",
								  confirmButtonColor: "#DE3419",
								  allowOutsideClick: false,
	        				});		
					</script>
            <%}%>
										  </form>
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
	
	<script>
	
	function activarFiltroAvanzado(){
		
		var check= document.getElementById("chkFiltro");
		var div = document.getElementById("filtroAvanzado");
		
		console.log("Entro");
			if(check.checked){
				div.style.display='block';
			}
			else{
				div.style.display='none';
			}
		}
	</script>

<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>