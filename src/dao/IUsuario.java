package dao;

import java.util.List;

import entidades.Personas;

public interface IUsuario {
	public int Login(String usuario, String pass);
	
	public int ObtenerIdUsuario(String nombre);
	
	public Personas getUsuarioPorCBU(String cbu);
}
