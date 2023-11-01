package negocio;

import java.util.List;

import entidades.Prestamos;
import entidades.Usuario;

public interface IAdminNegocio {

	public List<Usuario> listarUsuarios();
	public List<Prestamos> listarPrestamos();
	
	public boolean eliminarCliente(int id);
	
	public Usuario obtenerUsuario(int id);
}
