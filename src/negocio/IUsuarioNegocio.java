package negocio;

import Excepciones.UsuarioEnBlancoException;

public interface IUsuarioNegocio {
	
	public int LoginUser(String usuario, String pass) throws UsuarioEnBlancoException;
	
}
