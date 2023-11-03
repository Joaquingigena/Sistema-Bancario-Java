package dao;

import entidades.Personas;
import entidades.Prestamos;
import entidades.Usuario;
import java.util.List;

public interface IAdminDao {

	public List<Usuario> listarUsuarios();
	public List<Prestamos> listarPrestamos();
	
	public boolean eliminarCliente(int id);
	
	public Usuario obtenerCliente(int id);
	
	public List<Personas> listarSolicitudes();
	
	public boolean altaUsuario(int ID, String user, String pass);
}
