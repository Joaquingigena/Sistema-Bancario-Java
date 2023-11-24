<%@page import="entidades.Movimientos"%>
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

<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>

<title>Informes</title>
</head>
<body>
<%
	String nombre = (String)request.getAttribute("nombre");
	List<Movimientos> listaMovimientos= new ArrayList<Movimientos>();

	if(request.getAttribute("listaInformes")!=null){
		listaMovimientos= (ArrayList<Movimientos>)request.getAttribute("listaInformes");
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
                <a class="nav-link" href="#">Cerrar sesion</a>
              </li>
              <ion-icon name="person-circle-outline"></ion-icon> <b><%= nombre %></b>
            </ul>
          
          </div>
        </div>
    </nav>
    
     <!-- Busqueda -->
     <!-- <form action="ServletCuenta" method="post">-->
    <div class="d-flex justify-content-center">
        <div class="col-sm-4">
            <input type="text" class="form-control" name="filtroValor" id="filtroValor" onkeyup="filtroRapido()" placeholder="Buscar N° de movimiento">
        </div>
        <div class="col-auto">
            <input type="submit" name="btnBuscar" value="Buscar" class="btn btn-primary" >
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
		var tablaMovimientos= document.getElementById("tablaMovimientos")
		var filas= tablaMovimientos.getElementsByTagName("tr");
		
		for (var i = 1; i < filas.length; i++) {  
            var numMovimiento = filas[i].getAttribute("data-nombre").toLowerCase();
            if (numMovimiento.includes(filtro)) {
                filas[i].style.display = "";
            } else {
                filas[i].style.display = "none";
            }
        }
	}
	</script>
	
	<!-- Filtro -->
	<div id="filtroAvanzado"  style="display:none;"> 
	<form action="ServletInformes" method="post">
	<div class="container">
		<div class="row">
			<div class="col-3">
				<div class="mb-3">
				
				<label class="form-label"> Campo</label>
				<select id="ddlCampo" name="ddlCampo" class="form-control">
					<option value="movimiento" >N° Movimiento </option>
					<option value="fecha" > Fecha</option>
					<option value="importe" > importe </option>
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
				movimiento:["Contiene","Igual a"],
				fecha: ["Mayor que","Menor que","Igual a"],
				importe: ["Mayor que","Menor que","Igual a"]
		}
		
		var campoSelect = document.getElementById("ddlCampo");
        var criterioSelect = document.getElementById("ddlCriterio");
        
        campoSelect.addEventListener("change", function() {
        	
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
               
                <h3 >Listado de Informes</h3>
            </div>
        </div>

        <div class="row">
            <div class="col-8">
                    <table class="table" id="tablaMovimientos">
                    <thead>
                      <tr>
                        
                        <th scope="col">N° Movimiento</th>
                        <th scope="col">N° Cliente</th>
                        <th scope="col">Fecha Movimiento</th>
                        <th scope="col">Detalle</th>
                        <th scope="col">Importe</th>
                        <th scope="col">Tipo de Movimiento</th>
                        <th scope="col">Estado</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        
                      </tr>
                    </thead>
                    <tbody class="table-group-divider">
                      
                      <%
                      if(listaMovimientos!=null){                   	  
                    	  for(Movimientos m : listaMovimientos){
                    		  %>
                    		 <tr data-nombre="<%=m.getNumMovimiento_M() %>">
		                        <td><%=m.getNumMovimiento_M() %></td>
		                        <td><%=m.getNumCuenta_M().getNumCuenta_Cta()%></td>
		                        <td><%=m.getFechaMovimiento_M() %></td>
		                        <td><%=m.getDetalle_M() %> </td>
		                        <td><%=m.getImporte_M() %> </td>
		                        <td><%=m.getIdTipoMovimiento_M().getIdTipoMovimiento_TM()%> </td> 
		                        <td><%=m.getEstado_M()%></td>

			                        
                     		 </tr>
                    		  <%
                    	  }
                    	  
                      }
                      
                      
                      %>
                         
                     
                    </tbody>
                  </table>
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