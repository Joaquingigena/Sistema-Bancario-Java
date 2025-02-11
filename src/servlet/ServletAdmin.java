package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Excepciones.CuilDNIException;
import daoImpl.AdminDaoImpl;
import daoImpl.UsuarioDaoImp;
import entidades.Localidades;
import entidades.Personas;
import entidades.Provincias;
import entidades.Usuario;
import negocioImpl.AdminNegocioImpl;

@WebServlet("/ServletAdmin")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminNegocioImpl adminNeg= new AdminNegocioImpl();
       
 
    public ServletAdmin() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		request.setAttribute("usuario" ,usuario);
		RequestDispatcher dispatcher;

		if(request.getParameter("Param")!=null) {
			
			String opcion= request.getParameter("Param").toString();
			switch(opcion) {
			
			case "listarClientes":
				
				request.setAttribute("cargar" ,adminNeg.listarUsuarios());
					
				dispatcher = request.getRequestDispatcher("/AdmClientes.jsp");
				dispatcher.forward(request, response);
				
				break;
			case "Registrarse":
				
				AdminNegocioImpl AdminNeg = new AdminNegocioImpl();
				
				// Obtengo la lista de Localidades desde la capa Negocio.
				List <Localidades> ListaLoc = null;
				ListaLoc = AdminNeg.ListarLocalidades();
				
				// Obtengo la lista de Provincias desde la capa Negocio.
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
			case "misDatos":
				String nombre=(String)request.getParameter("Nombre");
				
				Usuario user= adminNeg.obtenerUsuariov2(nombre);
				
				
				request.setAttribute("datos", user);
				
				
				dispatcher = request.getRequestDispatcher("/MisDatos.jsp");
				dispatcher.forward(request, response);
				break;

			default:
				break;
			}
			
		}
		
		if(request.getParameter("eliminarCliente")!=null) {
			
			int id=Integer.parseInt( request.getParameter("eliminarCliente"));
			System.out.println("id para eliminar: "+ id);
			String msgEliminado= "";
			
		if(adminNeg.eliminarCliente(id))
		{
			
			msgEliminado = "Cliente eliminado correctamente";
			request.setAttribute("msgEliminado", msgEliminado);
		}
		else
		{
			msgEliminado = "Error al Eliminar";
			request.setAttribute("msgErrorEliminar", msgEliminado);
		}
				System.out.println("Cliente eliminado correctamente con Id: "+ id);
			
			request.setAttribute("cargar" ,adminNeg.listarUsuarios());
			
			dispatcher = request.getRequestDispatcher("/AdmClientes.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("modificarCliente")!=null) {
			
			int id=Integer.parseInt( request.getParameter("modificarCliente"));
			
			Usuario user= adminNeg.obtenerUsuario(id);
			System.out.println("Aca esta el cliente"+ user.toString());
			
			
			request.setAttribute("modificar", user);
			
			// Obtengo la lista de Localidades desde la capa Negocio.
			List <Localidades> ListaLoc = null;
			ListaLoc = adminNeg.ListarLocalidades();
			
			// Obtengo la lista de Localidades desde la capa Negocio.
			List <Provincias> ListaProv = null;
			ListaProv = adminNeg.ListarProvincias();
			
			// Seteo la lista al request para enviarla a la pagina de regreso.
			if(ListaLoc!=null) {
				request.setAttribute("ListaLocalidades", ListaLoc);
			}
			
			// Seteo la lista al request para enviarla a la pagina de regreso.
			if(ListaProv!=null) {
				request.setAttribute("ListaProvincias", ListaProv);
			}
			
			dispatcher = request.getRequestDispatcher("/AdmModificarCliente.jsp");
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
			boolean altaSoli = false;
			int ID = Integer.parseInt(request.getParameter("idPersona").toString());
			String user = request.getParameter("txtUsuario").toString();
			String pass = request.getParameter("txtPass").toString();
			int rol = 2;
			String msgSol = "";
			List <Personas> ListaPer = null;
			
			// Cambia estado Solicitud
			adminNeg.aceptarSolicitud(ID, estado);
			
			//Alta Usuario
			altaSoli = adminNeg.altaUsuario(ID, user, pass, rol);
			
			// Obtengo la lista de personas desde la capa Negocio.
			ListaPer = adminNeg.listarSolicitudes();
						
			// Seteo la lista al request para enviarla a la pagina de regreso.
			if(ListaPer!=null) {
				request.setAttribute("ListaPersonas", ListaPer);
				msgSol= "Usuario dado de alta Exitosamente";
				request.setAttribute("msgSol", msgSol);
			}
			
			request.setAttribute("EstadoAltasoli", altaSoli);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Solicitudes.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnRechazarSol")!=null) {
			int estado=-1;
			int ID = Integer.parseInt(request.getParameter("idPersona").toString());
			List <Personas> ListaPer = null;
			String msgRec = "";
			
			adminNeg.aceptarSolicitud(ID, estado);
			
			// Obtengo la lista de personas desde la capa Negocio.
			ListaPer = adminNeg.listarSolicitudes();
						
			// Seteo la lista al request para enviarla a la pagina de regreso.
			if(ListaPer!=null) {
				request.setAttribute("ListaPersonas", ListaPer);
				msgRec= "Usuario Rechazado Exitosamente";
				request.setAttribute("msgRec", msgRec);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/Solicitudes.jsp");
			rd.forward(request, response);
		}
		
		
		if(request.getParameter("btnRegistrarse")!=null) {
			int estado=1;
			AdminNegocioImpl AdminNeg = new AdminNegocioImpl();
			String mensaje = "";
			boolean alta = false;
			
			String dni = request.getParameter("dni").toString();
			int localidad = Integer.parseInt(request.getParameter("localidad").trim());
			int provincia = Integer.parseInt(request.getParameter("provincia").trim());
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
			
			try{
				adminNeg.CompararCuilDNI(cuil, dni);
				System.out.println("DNI y CUIL OK!");
				//Alta Usuario
				alta = adminNeg.AgregarPersona(dni, localidad, provincia, cuil, nombre, apellido, sexo, nacionalidad, fecha, direccion, mail, tel, solicitud);	
			}
			catch(CuilDNIException e) {
				mensaje = e.getMessage();
				System.out.println(e.getMessage());
			}
			
			
			boolean existe = false;
			
			if(alta==false) {
				existe = adminNeg.existePersona(dni);
			}
			
			// Seteo la lista al request para enviarla a la pagina de regreso.
			request.setAttribute("EstadoAlta", alta);
			
			request.setAttribute("Existe", existe);
			
			request.setAttribute("Mensaje", mensaje);
			
			// Obtengo la lista de Localidades desde la capa Negocio.
			List <Localidades> ListaLoc = null;
			ListaLoc = AdminNeg.ListarLocalidades();
			
			// Obtengo la lista de Provincias desde la capa Negocio.
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
		}
		
		if(request.getParameter("btnAceptarModificacion")!=null) {
			
			Usuario nuevo= new Usuario();
			Personas persona= new Personas();
			Localidades L= new Localidades();
			Provincias P= new Provincias();
			
			persona.setIdPersona_P(Integer.parseInt(request.getParameter("txtIdPersona")));
			persona.setNombre_P(request.getParameter("txtNombre"));
			persona.setApellido_P(request.getParameter("txtApellido"));
			persona.setDireccion_P(request.getParameter("txtDireccion"));
			persona.setCorreo_P(request.getParameter("txtCorreo"));
			persona.setTelefono_P(request.getParameter("txtTelefono"));
			//persona.setFechaNac_P((request.getParameter("txtFecha").toString()));
			
			String msgMod = "";
		
			L.setCodLocalidad_Loc(Integer.parseInt(request.getParameter("ddlLocalidades")));
			
			P.setCodProvincia_Prov(Integer.parseInt(request.getParameter("ddlProvincias")));
			
			persona.setCodLocalidad_P(L);
			persona.setCodProvincia_P(P);
			
			System.out.println(request.getParameter("ddlLocalidades"));
			
			System.out.println("Provincia " + P.getCodProvincia_Prov() + "Localidad " + L.getCodLocalidad_Loc() );
			
			nuevo.setIdUsuario_U(Integer.parseInt(request.getParameter("txtIdCliente")));
			nuevo.setIdPersona_U(persona);
			nuevo.setUsuario_U(request.getParameter("txtNombreUsuario"));
			nuevo.setPassword_U(request.getParameter("txtContrasena"));
			
			
			System.out.println("----------------------------------------------------");
			System.out.println(nuevo.toString());
			
			if(adminNeg.modificarCliente(nuevo)) {
				msgMod = "Modificado con Exito";
				System.out.println(msgMod);
				request.setAttribute("msgModificado", msgMod);
				
			}
			else
			{
				msgMod = "Error al Modificar";
				System.out.println(msgMod);
				request.setAttribute("msgError", msgMod);
				
			}
			request.setAttribute("cargar" ,adminNeg.listarUsuarios());
			
			dispatcher = request.getRequestDispatcher("/AdmClientes.jsp");
			dispatcher.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnBuscar")!=null) {
			
			RequestDispatcher dispatcher;
			String filtro= request.getParameter("filtroValor").toString();
			
			if(filtro!=null ) {
				request.setAttribute("cargar" ,adminNeg.filtrarListaUsuarios(filtro));
				
				dispatcher = request.getRequestDispatcher("/AdmClientes.jsp");
				dispatcher.forward(request, response);
				
			}else {
				request.setAttribute("cargar" ,adminNeg.listarUsuarios());
				
				dispatcher = request.getRequestDispatcher("/AdmClientes.jsp");
				dispatcher.forward(request, response);
			}
			
			
		}
	}

}
