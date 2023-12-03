package negocioImpl;


import java.util.List;

import Excepciones.CuilDNIException;
import daoImpl.AdminDaoImpl;
import entidades.Localidades;
import entidades.Personas;
import entidades.Prestamos;
import entidades.Provincias;
import entidades.Usuario;
import negocio.IAdminNegocio;

public class AdminNegocioImpl implements IAdminNegocio {

	private AdminDaoImpl adminDao= new AdminDaoImpl();
	
	@Override
	public List<Usuario> listarUsuarios() {
		
		return adminDao.listarUsuarios();
	}

	@Override
	public boolean eliminarCliente(int id) {
		
		
		return adminDao.eliminarCliente(id);
	}

	@Override
	public Usuario obtenerUsuario(int id) {
		
		return adminDao.obtenerCliente(id);
	}
	@Override
	public Usuario obtenerUsuariov2(String nombre) {
		
		return adminDao.obtenerClientev2(nombre);
	}
	
	public List<Personas> listarSolicitudes(){
		return adminDao.listarSolicitudes();
	}

	@Override
	public boolean aceptarSolicitud(int ID, int estado) {
		return adminDao.cambiarEstadoSolicitud(ID, estado);
	}

	@Override
	public boolean altaUsuario(int ID, String user, String pass, int rol) {
		return adminDao.altaUsuario(ID, user, pass, rol);
	}

	@Override
	public List<Localidades> ListarLocalidades() {
		return adminDao.listarLocalidades();
	}

	@Override
	public List<Provincias> ListarProvincias() {
		return adminDao.listarProvincias();
	}

	@Override
	public boolean AgregarPersona(String DNI, int localidad, int provincia, String CUIL, String nombre, String apellido, String sexo, String nacionalidad, String fecha, String direccion, String mail, String tel, boolean solicitud) {
		return adminDao.AgregarPersona(DNI, localidad, provincia, CUIL, nombre, apellido, sexo, nacionalidad, fecha, direccion, mail, tel, solicitud);
	}

	@Override
	public int CodLocalidad(String nombre) {
		return adminDao.Codlocalidad(nombre);
	}

	public int CodProvincia(String nombre) {
		return adminDao.CodProvincia(nombre);
	}

	@Override
	public boolean modificarCliente(Usuario user) {
		
		return adminDao.modificarCliente(user);
	}

	@Override
	public List<Usuario> filtrarListaUsuarios(String filtro) {
		// TODO Auto-generated method stub
		return adminDao.filtrarListaUsuarios(filtro);
	}
	
	public boolean existePersona(String DNI) {
		return adminDao.existePersona(DNI);
	}
	
	public boolean CompararCuilDNI(String Cuil, String DNI) throws CuilDNIException {
		if(adminDao.CompararCuilDNI(Cuil, DNI)==false) {
			throw new CuilDNIException();
		}
		return true;
	}
}
