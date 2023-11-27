package negocioImpl;

import com.sun.xml.internal.fastinfoset.algorithm.UUIDEncodingAlgorithm;

import Excepciones.UsuarioEnBlancoException;
import daoImpl.UsuarioDaoImp;
import negocio.IUsuarioNegocio;

public class UsuarioNegocioImpl implements IUsuarioNegocio{
	
	private UsuarioDaoImp uDaoImp = new UsuarioDaoImp();

	@Override
	public int LoginUser(String usuario, String pass) throws UsuarioEnBlancoException {
		
		if(usuario.trim() == "") {
			throw new UsuarioEnBlancoException();
		}
		return uDaoImp.Login(usuario, pass);
	}
	
	
}
