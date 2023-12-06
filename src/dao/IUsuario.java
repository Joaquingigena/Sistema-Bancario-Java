package dao;

import java.util.List;

import entidades.Personas;

public interface IUsuario {
	public int Login(String usuario, String pass);
	
	public int ObtenerIdUsuario(String nombre);
	
	public int ObtenerIdUsuario(int idUsuario);
	
	public Personas getUsuarioPorCBU(String cbu);
	
	public boolean resucitarUsuario(int idUsuario, String user, String pass);
	
	public int obtenerIdPersonaDeUsuario(int idPersona);
}
