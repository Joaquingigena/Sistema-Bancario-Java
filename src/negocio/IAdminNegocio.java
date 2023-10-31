package negocio;

import java.util.List;

import entidades.Prestamos;
import entidades.Usuario;

public interface IAdminNegocio {

	public List<Usuario> listarUsuarios();
	public List<Prestamos> listarPrestamos();
}
