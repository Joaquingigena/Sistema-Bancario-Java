package dao;

import entidades.Prestamos;
import entidades.Usuario;
import java.util.List;

public interface IAdminDao {

	public List<Usuario> listarUsuarios();
	public List<Prestamos> listarPrestamos();
}
