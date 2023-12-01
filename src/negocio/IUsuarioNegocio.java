package negocio;

import java.util.List;

import Excepciones.UsuarioEnBlancoException;
import entidades.Personas;

public interface IUsuarioNegocio {
	
	public int LoginUser(String usuario, String pass) throws UsuarioEnBlancoException;
	
	public List<Personas> getUsuarioPorCBU(String cbu);
}
