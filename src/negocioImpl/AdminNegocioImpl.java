package negocioImpl;


import java.util.List;

import daoImpl.AdminDaoImpl;
import entidades.Usuario;
import negocio.IAdminNegocio;

public class AdminNegocioImpl implements IAdminNegocio {

	private AdminDaoImpl adminDao= new AdminDaoImpl();
	
	@Override
	public List<Usuario> listarUsuarios() {
		
		return adminDao.listarUsuarios();
	}

}
