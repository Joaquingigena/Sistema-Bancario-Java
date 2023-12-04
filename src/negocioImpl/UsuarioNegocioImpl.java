package negocioImpl;

import java.util.List;

import com.sun.xml.internal.fastinfoset.algorithm.UUIDEncodingAlgorithm;

import Excepciones.UsuarioEnBlancoException;
import daoImpl.UsuarioDaoImp;
import entidades.Personas;
import entidades.Usuario;
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

	@Override
	public Personas getUsuarioPorCBU(String cbu) {
		
		return uDaoImp.getUsuarioPorCBU(cbu);
	}

	@Override
	public Usuario datosUsuario(String usuario, String pass) {
		Usuario user = new Usuario();
		
		user = uDaoImp.ValidarDatos(usuario, pass);
		
		return user;
	}
	
	
	
}
