package negocio;

import java.util.List;

import Excepciones.UsuarioEnBlancoException;
import entidades.Personas;
import entidades.Usuario;

public interface IUsuarioNegocio {
	
	public int LoginUser(String usuario, String pass) throws UsuarioEnBlancoException;
	
	public Personas getUsuarioPorCBU(String cbu);
	
	public Usuario datosUsuario(String usuario, String pass);
	
	public int idUsuario (String nombre);
}
