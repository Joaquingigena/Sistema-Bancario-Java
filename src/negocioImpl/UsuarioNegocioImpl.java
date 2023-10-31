package negocioImpl;

import daoImpl.UsuarioDaoImp;
import negocio.IUsuarioNegocio;

public class UsuarioNegocioImpl implements IUsuarioNegocio{
	
	private UsuarioDaoImp uDaoImp = new UsuarioDaoImp();

	@Override
	public int LoginUser(String usuario, String pass) {
		return uDaoImp.Login(usuario, pass);
	}
	
	
}
