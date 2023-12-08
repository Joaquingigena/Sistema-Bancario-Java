<%@page import="entidades.Movimientos"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat" %>
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
                <a class="nav-link" href="Login.jsp">Cerrar sesion</a>
              </li>
              <ion-icon name="person-circle-outline"></ion-icon> <b><%= nombre %></b>
            </ul>
          
          </div>
        </div>
    </nav>
    
    
	
	
	<div class="container mt-4">
    <h2 class="mb-4">Informe Bancario</h2>
    
     <h4>Filtrar por Fechas</h4>

    <form action="" method="post">
        <div class="row">
            <div class="col-md-4">
                <label for="fechaInicio">Fecha de inicio:</label>
                <input type="date" class="form-control" id="fechaInicio" name="fechaInicio" required>
            </div>

            <div class="col-md-4">
                <label for="fechaFin">Fecha de fin:</label>
                <input type="date" class="form-control" id="fechaFin" name="fechaFin" required>
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Filtrar</button>
    </form>
    
	<form method="get" action="ServletInformes">
    <div class="row mt-4">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Monto Total de Ingresos</h5>
                    <p class="card-text" id="montoIngresos">0.00</p>
                </div>
            </div>
        </div>

        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Monto Total de Egresos</h5>
                    <p class="card-text" id="montoEgresos">0.00</p>
                </div>
            </div>
        </div>
    </div>

    <div class="row mt-4">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Cantidad de Usuarios Registrados</h5>
                    <p class="card-text" id="usuariosRegistrados">0</p>
                </div>
            </div>
        </div>

        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Cantidad de Préstamos Otorgados</h5>
                    <p class="card-text" id="prestamosOtorgados">0</p>
                </div>
            </div>
        </div>
    </div>

    <div class="row mt-4 mb-5">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Cantidad de Movimientos Realizados</h5>
                    <p class="card-text" id="movimientosRealizados">0</p>
                </div>
            </div>
        </div>
    </div>
	</div>
	</form>
	
	
	
	
	
	
	
	
	
	
	<!-- 
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
                        <th scope="col">N° Cuenta Origen</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Fecha Movimiento</th>
                        <th scope="col">Detalle</th>
                        <th scope="col">Importe</th>
                        <th scope="col">Tipo de Movimiento</th>
                        <th scope="col">N° Cuenta Destino</th>
                        <th scope="col">Estado</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        
                      </tr>
                    </thead>
                    <tbody class="table-group-divider">
                      
                      <%
                      if(listaMovimientos!=null){  
                    	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Define el formato de fecha que deseas
                    	  for(Movimientos m : listaMovimientos){
                    		  %>
                    		 <tr data-nombre="<%=m.getNumMovimiento_M() %>">
		                        <td><%=m.getNumMovimiento_M() %></td>
		                        <td><%=m.getNumCuenta_M().getNumCuenta_Cta()%></td>
		                        <td><%=m.getNumCuenta_M().getIdUsuario_Cta().getIdPersona_U().getNombre_P() %></td>
		                        <td><%=m.getNumCuenta_M().getIdUsuario_Cta().getIdPersona_U().getApellido_P() %></td>
		                        <td><%=dateFormat.format(m.getFechaMovimiento_M()) %></td>
		                        <td><%=m.getDetalle_M() %> </td>
		                        <td><%=m.getImporte_M() %> </td>
		                        <td><%=m.getIdTipoMovimiento_M().getIdTipoMovimiento_TM()%> </td> 
		                        <td><%=m.getNumCuentaDestino_Mo().getNumCuenta_Cta()%> </td> 
		                        <td><%=m.getEstado_M()%></td>

			                        
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
     -->
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