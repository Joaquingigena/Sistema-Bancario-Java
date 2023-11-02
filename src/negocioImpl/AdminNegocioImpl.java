package negocioImpl;


import java.util.List;

import daoImpl.AdminDaoImpl;
import entidades.Personas;
import entidades.Prestamos;
import entidades.Usuario;
import negocio.IAdminNegocio;

public class AdminNegocioImpl implements IAdminNegocio {

	private AdminDaoImpl adminDao= new AdminDaoImpl();
	
	@Override
	public List<Usuario> listarUsuarios() {
		
		return adminDao.listarUsuarios();
	}
	
	@Override
	public List<Prestamos> listarPrestamos(){
		return adminDao.listarPrestamos();
	}

	@Override
	public boolean eliminarCliente(int id) {
		
		
		return adminDao.eliminarCliente(id);
	}

	@Override
	public Usuario obtenerUsuario(int id) {
		
		return adminDao.obtenerCliente(id);
	}
	
	public List<Personas> listarSolicitudes(){
		return adminDao.listarSolicitudes();
	}

}
