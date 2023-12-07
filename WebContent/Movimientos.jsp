<%@page import="entidades.Movimientos"%>
<%@page import="entidades.Usuario"%>
<%@page import="entidades.Cuenta"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">

 <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
 
 <!-- Icons de Bootstrap -->
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
            $('#tablaMov').DataTable({
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
<title>Movimientos</title>
</head>
<body>
<%
	String nombre = (String)request.getParameter("usuario");
	int numCuenta = 0;
	if(request.getAttribute("numCuenta")!=null){
		numCuenta = Integer.parseInt( request.getParameter("numCuenta"));
	}
	float saldo = 0;
	
	List<Movimientos> listaMovimientos= new ArrayList<Movimientos>();
	
	List<Cuenta> listCuentas = new ArrayList<Cuenta>();
	
	Cuenta listCuentaFilter = new Cuenta();

	if(request.getAttribute("Movimientos")!=null){
		listaMovimientos= (ArrayList<Movimientos>)request.getAttribute("Movimientos");
	}
	
	if(request.getAttribute("cuentas")!=null){
		listCuentas = (ArrayList<Cuenta>)request.getAttribute("cuentas");
	}
	
	if(request.getAttribute("cuentaFilter")!=null){
		listCuentaFilter = (Cuenta)request.getAttribute("cuentaFilter");
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
                <a class="nav-link active" aria-current="page" href="Inicio.jsp"> Usuario</a>
              </li>
              <ion-icon name="person-circle-outline"></ion-icon> <b><%= nombre %></b>   
              <li class="nav-item">
                <a class="nav-link" href="Login.jsp">Cerrar Sesion</a>
              </li>
            </ul>
          </div>
        </div>
    </nav>
	<div id="General">
		
		<div id="Navegacion">
			<label style="text-align:center; margin: 10%;"><%=nombre%></label>
			<div class="btn-group-vertical" role="group" aria-label="Vertical radio toggle button group">
			  
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio1" autocomplete="off" checked href="ServletMovimientos?Param=listarMovimientos&usuario=<%=nombre%>">
			  <label class="btn btn-outline-danger" for="vbtn-radio1" >Movimientos</label>
			  
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio2" autocomplete="off" href="ServletMovimientos?Param=transferencias&usuario=<%=nombre%>">
			  <label class="btn btn-outline-danger" for="vbtn-radio2" >Transferencias</label>
			  
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio3" autocomplete="off" href="ServletPrestamo?Param=prestamos&usuario=<%=nombre%>">
			  <label class="btn btn-outline-danger" for="vbtn-radio3" >Prestamos</label>
			  
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio4" autocomplete="off" href="ServletPagoPrestamos?Param=pagos&usuario=<%=nombre%>">
			  <label class="btn btn-outline-danger" for="vbtn-radio4" >Pagos</label>
			  
			  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio5" autocomplete="off" href="ServletAdmin?Param=misDatos&Nombre=<%=nombre%>">
			  <label class="btn btn-outline-danger" for="vbtn-radio5" >Mis Datos</label>
			</div>
		</div>

		<script>
			  // Obtén todos los botones de radio
			  const radioButtons = document.querySelectorAll('.btn-check');
			
			  // Manejador de eventos para redirigir cuando se selecciona un botón de radio
			  radioButtons.forEach(function (radioButton) {
			    radioButton.addEventListener('change', function () {
			      if (radioButton.checked) {
			        const href = radioButton.getAttribute('href');
			        if (href) {
			          // Redirige a la página JSP correspondiente
			          window.location.href = href;
			        }
			      }
			    });
			  });
		</script>
	<div id="Cuerpo">
		<div >
			<div class="text-center">
				<div class="d-flex justify-content-center">
					<form action="ServletMovimientos" method="get">
				    <div style="display:flex;">
				        <h5 style="margin:25px">Cuenta: </h5>
				        <input type="hidden" name="usuario" value="<%=nombre %>"/>
				        <select name="numCuenta" style="height: 40px; width:400px; margin: 15px" class="form-select" aria-label="Default select example">
								
				            <%
				            	if(numCuenta==0){%>
				            		<option value="0">Seleccione una cuenta</option>
				            	<%}%>
				            <%
				            	if(listCuentas != null){
									int ban = 0;
									int auxNumCuenta = 0;
				            		for(Cuenta c : listCuentas){
				            			if(listCuentaFilter.getNumCuenta_Cta() != 0 && ban == 0){
				            		%>
				            			<option value="<%=numCuenta%>"><%= listCuentaFilter.getCBU_Cta() %></option>
				            			<option value="0">Seleccione una cuenta</option>
				            		<%
				            				ban = 1;
				            			}
				            			if(numCuenta != c.getNumCuenta_Cta()){
				            		%>	
				            			<option value="<%=c.getNumCuenta_Cta()%>"><%= c.getCBU_Cta() %></option>
										<%}	%>
				            	<%	}
				            		for(Cuenta c : listCuentas){
				            			saldo = c.getSaldo_Cta();
				            			break;
				            		}
				            	}
				            %>
				            
				        </select>
				        
				        <button type="submit" class="btn btn-success btn-sm" name="buscarCuenta" value="filtrar">Buscar</button>
				    </div>
				</form>
				</div>
			</div>
			<div class="d-flex justify-content-center">
				<div class="border border-success m-3 p-4" style="width: 620px">
						 <%
				            	if(listCuentas != null && listCuentaFilter.getNumCuenta_Cta() == 0){%>
				            		<span class="rounded bg-success p-2 h3 mx-3"><b>CASH</b></span> <b class="h3">$ <%= saldo %></b>
				            	<%}
				         %>
				            
				            
						<%
				            	if(listCuentaFilter.getNumCuenta_Cta() != 0){
				            		
				            			saldo = listCuentaFilter.getSaldo_Cta();
				            		%>
				            			<span class="rounded bg-success p-2 h3 mx-3"><b>CASH</b></span> <b class="h3">$ <%= saldo %></b>
				            	<%	
				            	}
				            %>
				</div>
			</div>
		</div>
			<div>
		    <div class="container text-center d-flex justify-content-center aligne-content-center">
			  <div class="row">
			    <div class="col-md">
			      <h6>Desde: </h6>
			        <input type="date" id="fechaInicio">
			    </div>
			    <div class="col-md">
			      <h6>Hasta: </h6>
			        <input type="date" id="fechaFin">
			    </div>
			    <div class="col-md py-4">
			      <button class="btn btn-success btn-sm" onclick="filtroFechas()">Buscar</button>
			    </div>
			  </div>
			</div>
			
			    <div id="Encabezado" class="text-center">
					<h2>Movimientos</h2>
				</div>
			    <table style="margin:25px;" class="table table-striped table-hover text-center" id="tablaMov">
			        <thead>
			            <tr class="table-primary">
			                <th>Numero de Movimiento</th>
			                <th>Fecha</th>
			                <th>Detalle</th>
			                <th>Importe</th>
			                <th>Tipo movimiento</th>
			            </tr>
			        </thead>
		                    <tbody class="table-group-divider">
		                      <%
		                      if(listaMovimientos!=null){          
		                    	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Define el formato de fecha que deseas
		                    	  for(Movimientos m : listaMovimientos){
		                    		  %>
		                    		 <tr>
		                    		    <td><%= m.getNumMovimiento_M() %></td>
				                        <td><%= dateFormat.format(m.getFechaMovimiento_M()) %></td>
				                        <td><%= m.getDetalle_M() %></td>
				                        <td><%= m.getIdTipoMovimiento_M().getIdTipoMovimiento_TM() == 1 || m.getIdTipoMovimiento_M().getIdTipoMovimiento_TM() == 2 ? m.getImporte_M() : "-"+m.getImporte_M() %></td>
				                        <td><%= m.getIdTipoMovimiento_M().getDescripcion_TM() %> </td>
					                        
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
			console.log("Script cargado")
			function filtroFechas(){
					
				
				var fechaInicio= document.getElementById("fechaInicio");
				var fechaFin= document.getElementById("fechaFin");
				var tablaMovimientos= document.getElementById("tablaMov");
				
				
				var inicio= new Date(fechaInicio.value);
				var fin= new Date(fechaFin.value);
				
				for(i=1 ; i< tablaMovimientos.rows.length ; i++ ){
					
					var fechaCelda = new Date(tablaMovimientos.rows[i].cells[1].innerText);
					
					if(!(fechaCelda >= inicio && fechaCelda <= fin)){
						tablaMovimientos.rows[i].style.display="none";
					}
				}
					
					
					
				}
					
	</script>
  
  
  
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>