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

<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>

<title>Solicitudes</title>
</head>
<body>

<%
	String nombre = (String)request.getAttribute("nombre");
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
                <a class="nav-link active" href="ServletAdmin?Param=listarClientes"> Clientes</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="AdmCuentas.jsp">Cuentas</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="ServletAdmin?Param=listarPrestamos">Prestamos</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="ServletInformes?Param=listarInformes">Informes</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="Login.jsp">Cerrar sesion</a>
              </li>
	           	<ion-icon name="person-circle-outline"></ion-icon> <b><%= nombre %></b>
              
            </ul>
          
          </div>
        </div>
    </nav>
    
    <div class="d-flex justify-content-center">
        <div class="col-sm-4">
            <input type="text" class="form-control" id="filtroValor" placeholder="Filtrar por">
        </div>
        <div class="col-auto">
            <select class="form-control" id="filtroCampo">
                <option value="nombre">N° Cliente</option>
                <option value="id">DNI</option>
            </select>
        </div>
        <div class="col-auto">
            <button class="btn btn-primary" id="btnFiltrar">Filtrar</button>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-3 titulo">
               
                <h3 >Lista de solicitudes</h3>
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
            
                <table class="table table-striped">
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
                    <form action="ServletAdmin" method="get">
                    	<tr> 
	                    	<td> <%=Per.getIdPersona_P() %> <input type="hidden" name="idPersona" value="<%=Per.getIdPersona_P() %>"> </td> <td><%=Per.getDNI_P() %></td> <td><%=Per.getCodLocalidad_P() %></td> <td><%=Per.getCodProvincia_P() %></td> <td><%=Per.getCUIL_P() %> </td> <td><%=Per.getNombre_P() %></td> <td><%=Per.getApellido_P() %></td> <td><%=Per.getSexo_P()%></td> <td><%=Per.getNacionalidad_P() %></td> <td><%=Per.getFechaNac_P() %></td> <td><%=Per.getDireccion_P() %></td> <td><%=Per.getCorreo_P()%></td> <td><%=Per.getTelefono_P() %></td> 
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
	                    	
	                    	<td style="width:200px;">
	                    		<%if(Per.getSolicitud_P()==0){ %>
	                    			<input type="submit" name="btnAceptarSol" value="Aceptar">
	                    			<input type="submit" name="btnRechazarSol" value="Rechazar">
	                    		<%} %>
	                    	</td>

                    	</tr>
                    </form>
                    <%	
                    	}
                    %>
                     
                  </table>
            </div>
        </div>
    </div>

<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>