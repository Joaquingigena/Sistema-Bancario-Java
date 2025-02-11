<%@ page import= "entidades.Prestamos" %>

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
            $('#tablaPrestamos').DataTable({
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
<title>Prestamos</title>

</head>
<body>

<%
	String nombre = (String)request.getAttribute("nombre");
	List<Prestamos> listaPrestamos= new ArrayList<Prestamos>();

	if(request.getAttribute("cargarPrestamos")!=null){
		listaPrestamos = (ArrayList<Prestamos>)request.getAttribute("cargarPrestamos");
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
            <input type="text" class="form-control" name="filtroValor" id="filtroValor" onkeyup="filtroRapido()" placeholder="Buscar N� de prestamo">
        	<div class="col-sm-4">
			<input type="checkbox"  class="form-check-input" id="chkFiltro" onchange="activarFiltroAvanzado()" >
			<label class="form-check-label" for="chkFiltro">Filtro avanzado </label>
        </div>
        </div>
    </div>
	 <!-- </form>-->
	<script>
	function filtroRapido(){
		
		var filtro= document.getElementById("filtroValor").value.toLowerCase();;
		var tablaPrestamos= document.getElementById("tablaPrestamos")
		var filas= tablaPrestamos.getElementsByTagName("tr");
		
		for (var i = 1; i < filas.length; i++) {  
            var numPrestamo = filas[i].getAttribute("data-nombre").toLowerCase();
            if (numPrestamo.includes(filtro)) {
                filas[i].style.display = "";
            } else {
                filas[i].style.display = "none";
            }
        }
	}
	</script>
	
	<!-- Filtro Avanzado -->
	<div id="filtroAvanzado" style="display:none;"> 
	<form action="ServletPrestamo" method="post">
	<div class="container">
		<div class="row">
			<div class="col-3">
				<div class="mb-3">
				
				<label class="form-label"> Campo</label>
				<select id="ddlCampo" name="ddlCampo" class="form-control">
					<option value="cuenta" >N� Cuenta </option>
					<option value="importe" > Importe a pagar</option>
					<option value="plazo" > Plazo </option>
				</select>			
				</div>
			</div>
			<div class="col-3">
				<div class="mb-3">
				
				<label class="form-label"> Criterio</label>
				<select id="ddlCriterio" name="ddlCriterio" class="form-control"></select>			
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
				cuenta:["Contiene","Igual a"],
				importe: ["Mayor que","Menor que","Igual a"],
				plazo: ["Mayor que","Menor que","Igual a"]
		}
		
		var campoSelect = document.getElementById("ddlCampo");
        var criterioSelect = document.getElementById("ddlCriterio");
        
        campoSelect.addEventListener("change", function() {
        	
        	var lista= document.getElementById("tablaPrestamos");
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
    
    <div class="container-fluid">
        <div class="row">
            <div class="col-3 titulo">
               
                <h3 >Prestamos</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-8">
            
                <table class="table" id="tablaPrestamos">
                    <thead>
                      <tr>
                        <th scope="col">N� Prestamo</th>
                        <th scope="col">N� Cliente</th>
                        <th scope="col">N� Cuenta</th>
                        <th scope="col">Importe a pagar</th>
                        <th scope="col">Importe pedido</th>
                        <th scope="col">Cuotas a pagar</th>
                        <th scope="col">Estado</th>
                        
                      </tr>
                    </thead>
                    <tbody class="table-group-divider">
                    
                    
                      <%
                      if(listaPrestamos!=null){                   	  
                    	  for(Prestamos p : listaPrestamos){
                    		  %>
                    		 <form action="ServletPrestamo" method="post">
                    		 <tr data-nombre="<%= p.getNumPrestamo_P() %>">
		                        <td><%=p.getNumPrestamo_P() %></td>
		                        <td><%=p.getNumCliente() %></td>
		                        <td><%=p.getNumCuenta_P().getNumCuenta_Cta() %></td>
		                        <td><%=p.getImportePagar_P() %></td>
		                        <td><%=p.getImportePedido_P() %> </td>
		                        <td><%=p.getIdCuota_P().getCantidadCuota_C() %> </td>
		                        <td><% if(p.getEstado()== true && p.getAutorizado()== true){
		                        	%>
		                        	
		                        	<i class="bi bi-check-circle aceptado"></i>
		                        <% }
		                        else{
		                        	%>
		                        	<i class="bi bi-x-circle rechazado"></i>
		                        	<%
		                        }%> </td>
		                     
		                        
		                        
		                        
		                        
		                        <td style="width:300px;">
	                    		<%if(p.getEstado()==false){
	                    			int ID = p.getNumCliente(); 
	                    			int cuenta = p.getNumCuenta_P().getNumCuenta_Cta();
	                    			String numPre = p.getNumPrestamo_P()+"";
	                    			%>
	                    			
	                    			<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#Modal<%=numPre%>">Aceptar</button>
	                    			<!-- <input type="submit" name="btnAceptarSol" value="Aceptar"> -->
	                    			
	                    			<!-- DIV MODAL -->
							<div class="modal fade" id="Modal<%=numPre%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog modal-dialog-centered">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h1 class="modal-title fs-5" id="exampleModalLabel">Alta Usuario</h1>
							        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							      </div>
							      <div class="modal-body" Style="display:flex;">
							      	<div>
							      		
							      	</div>
							        <div style="margin-left: 10%;display:flex;flex-direction:column;">
							        	N� Pr�stamo
							        	<input type="text" name="Pres" value="<%=p.getNumPrestamo_P()%>" disabled>
							        	Cliente
							        	<input type="text" name="Cli" value="<%=ID%>" disabled>
							        	Cuenta
							        	<input type="text" name="Cue" value="<%=p.getNumCuenta_P().getNumCuenta_Cta()%>" disabled>
							        	Importe
							        	<input type="number" name="Imp" value="<%=p.getImportePedido_P()%>" disabled>
							        	
							        	<!-- SE UTILIZA PARA ENVIAR LOS DATOS AL SERVLET -->
							        	<input type="hidden" name="txtPrestamo" value="<%=p.getNumPrestamo_P()%>">
							        	<input type="hidden" name="txtCliente" value="<%=ID%>">
							        	<input type="hidden" name="txtCuenta1" value="<%=cuenta%>">
							        	<input type="hidden" name="txtImporte" value="<%=p.getImportePedido_P() %>">
							        </div>
							        
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
							        <button name="btnAceptarPrestamo" type="submit" class="btn btn-primary">Guardar</button>
							      </div>
							    </div>
							  </div>
							</div>
							<!-- ---------------------------------------------------------------------------------------------- -->
	                    			
	                    	
							
							
									<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#Rech<%=p.getNumPrestamo_P()%>">Rechazar</button>
	                    			<!-- <input type="submit" name="btnRechazarSol" value="Rechazar"> --> 
	                    			
	                    			<!-- DIV MODAL -->
							<div class="modal fade" id="Rech<%=p.getNumPrestamo_P()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog modal-dialog-centered">
							    <div class="modal-content">
							      <div style="background-color:red" class="modal-header">
							        <h1 class="modal-title fs-5" id="exampleModalLabel">ATENCI�N!</h1>
							        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							      </div>
							      <div class="modal-body" Style="display:flex;">
							      	<div style="width:90%;">
							      		
							      	</div>
							        <div style="margin-left: 0%;display:flex;flex-direction:column; text-align:center;justify-content:center;">
							        	N� Pr�stamo
							        	<input type="text" name="Pres" value="<%=p.getNumPrestamo_P()%>" disabled>
							        	Cliente
							        	<input type="text" name="Cli" value="<%=p.getNumCliente()%>" disabled>
							        	Cuenta
							        	<input type="text" name="Cue" value="<%=p.getNumCuenta_P().getNumCuenta_Cta()%>" disabled>
							        	Importe
							        	<input type="number" name="Imp" value="<%=p.getImportePedido_P()%>" disabled>
							        	
							        	<!-- SE UTILIZA PARA ENVIAR LOS DATOS AL SERVLET -->
							        	<input type="hidden" name="txtPrestamo" value="<%=p.getNumPrestamo_P()%>">
							        	<input type="hidden" name="txtCliente" value="<%=p.getNumCliente()%>">
							        	<input type="hidden" name="txtCuenta1" value="<%=p.getNumCuenta_P().getNumCuenta_Cta()%>">
							        	<input type="hidden" name="txtImporte" value="<%=p.getImportePedido_P() %>">
							    
							        	<h3>�Est� seguro que desea rechazar esta solicitud?</h3> 
							        	
							        </div>
							        
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">NO</button>
							        <button type="submit" name="btnRechazarPrestamo" style="background-color:red; border-color:red;" type="button" class="btn btn-primary">SI</button>
							      </div>
							    </div>
							  </div>
							</div>
							<!-- ---------------------------------------------------------------------------------------------- -->
	                    			
	                    		<%} %>
	                    		
							
	                    	</td>
		                        

									</div>                    
                     		 </tr>
            <%
			if(request.getAttribute("msgAprobado") !=null){
				%>
					<script type="text/javascript">
					var mensaje = "<%=request.getAttribute("msgAprobado")%>"; 
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
			if(request.getAttribute("msgRechazado") !=null){
				%>
					<script type="text/javascript">
					var mensaje = "<%=request.getAttribute("msgRechazado")%>"; 
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
                     		 </form>
						<%} %>
						<%} %>
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