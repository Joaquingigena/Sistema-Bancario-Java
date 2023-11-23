package dao;

public interface IUsuario {
	public int Login(String usuario, String pass);
	
	public int ObtenerIdUsuario(String nombre);
}
