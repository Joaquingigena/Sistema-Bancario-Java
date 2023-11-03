package dao;

import entidades.Localidades;
import entidades.Personas;
import entidades.Prestamos;
import entidades.Provincias;
import entidades.Usuario;
import java.util.List;

public interface IAdminDao {

	public List<Usuario> listarUsuarios();
	public List<Prestamos> listarPrestamos();
	
	public boolean eliminarCliente(int id);
	
	public Usuario obtenerCliente(int id);
	
	public List<Personas> listarSolicitudes();
	
	public boolean altaUsuario(int ID, String user, String pass, int rol);
	
	public List <Localidades> listarLocalidades();
	
	public List<Provincias> listarProvincias();
	
	public boolean AgregarPersona(String DNI, int localidad, int provincia, String CUIL, String nombre, String apellido, String sexo, String nacionalidad, String fecha, String direccion, String mail, String tel, boolean solicitud);

	public int Codlocalidad(String nombre);
	
	public int CodProvincia(String nombre);
}
