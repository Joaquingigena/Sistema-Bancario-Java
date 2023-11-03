package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.AdminDaoImpl;
import entidades.Localidades;
import entidades.Personas;
import entidades.Provincias;
import negocioImpl.AdminNegocioImpl;

@WebServlet("/ServletAdmin")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminNegocioImpl adminNeg= new AdminNegocioImpl();
       
 
    public ServletAdmin() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("Param")!=null) {
			
			String opcion= request.getParameter("Param").toString();
			
			switch(opcion) {
			
			case "listarClientes":
				
				request.setAttribute("cargar" ,adminNeg.listarUsuarios());
					
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AdmClientes.jsp");
				dispatcher.forward(request, response);
				
				break;
			case "listarPrestamos":
				
				request.setAttribute("cargarPrestamos" ,adminNeg.listarPrestamos());
				
				RequestDispatcher dispa = request.getRequestDispatcher("/AdmPrestamos.jsp");
				dispa.forward(request, response);
				break;
			
			case "Registrarse":
				
				AdminNegocioImpl AdminNeg = new AdminNegocioImpl();
				
				// Obtengo la lista de Localidades desde la capa Negocio.
				List <Localidades> ListaLoc = null;
				ListaLoc = AdminNeg.ListarLocalidades();
				
				// Obtengo la lista de Localidades desde la capa Negocio.
				List <Provincias> ListaProv = null;
				ListaProv = AdminNeg.ListarProvincias();
				
				// Seteo la lista al request para enviarla a la pagina de regreso.
				if(ListaLoc!=null) {
					request.setAttribute("ListaLocalidades", ListaLoc);
				}
				
				// Seteo la lista al request para enviarla a la pagina de regreso.
				if(ListaProv!=null) {
					request.setAttribute("ListaProvincias", ListaProv);
				}
				
				
				RequestDispatcher rd = request.getRequestDispatcher("/Registrarse.jsp");
				rd.forward(request, response);
				break;
				
			default:
				break;
			}
			
		}
		
		if(request.getParameter("eliminarCliente")!=null) {
			
			int id=Integer.parseInt( request.getParameter("eliminarCliente"));
			
			if(adminNeg.eliminarCliente(id))
				System.out.println("Cliente eliminado correctamente");
			
			request.setAttribute("cargar" ,adminNeg.listarUsuarios());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdmClientes.jsp");
			dispatcher.forward(request, response);
		}
		
	if(request.getParameter("modificarCliente")!=null) {
			
			int id=Integer.parseInt( request.getParameter("modificarCliente"));
			
			adminNeg.obtenerUsuario(id);
			
			request.setAttribute("cargar" ,adminNeg.listarUsuarios());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdmClientes.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("btnSolicitudes")!=null) {
			AdminNegocioImpl AdminNeg = new AdminNegocioImpl();
			
			// Obtengo la lista de personas desde la capa Negocio.
			List <Personas> ListaPer = null;
			ListaPer = AdminNeg.listarSolicitudes();
			
			// Seteo la lista al request para enviarla a la pagina de regreso.
			if(ListaPer!=null) {
				request.setAttribute("ListaPersonas", ListaPer);
			}
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/Solicitudes.jsp");
			rd.forward(request, response);
			
		}
		
		
		if(request.getParameter("btnAceptarSol")!=null) {
			int estado=1;
			int ID = Integer.parseInt(request.getParameter("idPersona").toString());
			String user = request.getParameter("txtUsuario").toString();
			String pass = request.getParameter("txtPass").toString();
			int rol = 2;
			List <Personas> ListaPer = null;
			
			// Cambia estado Solicitud
			adminNeg.aceptarSolicitud(ID, estado);
			
			//Alta Usuario
			adminNeg.altaUsuario(ID, user, pass, rol);
			
			// Obtengo la lista de personas desde la capa Negocio.
			ListaPer = adminNeg.listarSolicitudes();
						
			// Seteo la lista al request para enviarla a la pagina de regreso.
			if(ListaPer!=null) {
				request.setAttribute("ListaPersonas", ListaPer);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/Solicitudes.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnRechazarSol")!=null) {
			int estado=-1;
			int ID = Integer.parseInt(request.getParameter("idPersona").toString());
			List <Personas> ListaPer = null;
			
			adminNeg.aceptarSolicitud(ID, estado);
			
			// Obtengo la lista de personas desde la capa Negocio.
			ListaPer = adminNeg.listarSolicitudes();
						
			// Seteo la lista al request para enviarla a la pagina de regreso.
			if(ListaPer!=null) {
				request.setAttribute("ListaPersonas", ListaPer);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/Solicitudes.jsp");
			rd.forward(request, response);
		}
		
		
		if(request.getParameter("btnRegistrarse")!=null) {
			int estado=1;
			
			String dni = request.getParameter("dni").toString();
			int localidad = 1;//adminNeg.CodLocalidad(request.getParameter("localidad").toString());
			int provincia = 1;//adminNeg.CodProvincia(request.getParameter("provincia").toString());
			String cuil = request.getParameter("cuil").toString();
			String nombre = request.getParameter("nombre").toString();
			String apellido = request.getParameter("apellido").toString();
			String sexo = request.getParameter("sexo").toString();
			String nacionalidad = request.getParameter("nacionalidad").toString();
			String fecha = request.getParameter("fechaNac").toString();
			String direccion = request.getParameter("direccion").toString();
			String mail = request.getParameter("email").toString();
			String tel = request.getParameter("telefono").toString();
			boolean solicitud = false;
			int rol = 2;
			
			//Alta Usuario
			boolean alta = adminNeg.AgregarPersona(dni, localidad, provincia, cuil, nombre, apellido, sexo, nacionalidad, fecha, direccion, mail, tel, solicitud);
						
			// Seteo la lista al request para enviarla a la pagina de regreso.
			request.setAttribute("EstadoAlta", alta);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/Registrarse.jsp");
			rd.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
