package negocio;

import java.util.List;

import entidades.Personas;
import entidades.Prestamos;
import entidades.Usuario;

public interface IAdminNegocio {

	public List<Usuario> listarUsuarios();
	public List<Prestamos> listarPrestamos();
	
	public boolean eliminarCliente(int id);
	
	public Usuario obtenerUsuario(int id);
	
	public List <Personas> listarSolicitudes();
	
	public boolean aceptarSolicitud(int ID, int estado);
	
	public boolean altaUsuario(int ID, String user, String pass, int rol);
}
