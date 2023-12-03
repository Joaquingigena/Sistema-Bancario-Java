package negocio;

import java.util.List;

import Excepciones.CuilDNIException;
import entidades.Localidades;
import entidades.Personas;
import entidades.Prestamos;
import entidades.Provincias;
import entidades.Usuario;

public interface IAdminNegocio {

	public List<Usuario> listarUsuarios();
	
	public boolean eliminarCliente(int id);
	
	public Usuario obtenerUsuario(int id);
	
	public List <Personas> listarSolicitudes();
	
	public boolean aceptarSolicitud(int ID, int estado);
	
	public boolean altaUsuario(int ID, String user, String pass, int rol);
	
	public List<Localidades> ListarLocalidades();
	
	public List<Provincias> ListarProvincias();
	
	public boolean AgregarPersona(String DNI, int localidad, int provincia, String CUIL, String nombre, String apellido, String sexo, String nacionalidad, String fecha, String direccion, String mail, String tel, boolean solicitud);

	public int CodLocalidad(String nombre);
	
	public boolean modificarCliente(Usuario user);
	Usuario obtenerUsuariov2(String nombre);
	
	public List<Usuario> filtrarListaUsuarios(String filtro);
	
	public boolean existePersona(String DNI);
	
	public boolean CompararCuilDNI(String Cuil, String DNI) throws CuilDNIException;
}
