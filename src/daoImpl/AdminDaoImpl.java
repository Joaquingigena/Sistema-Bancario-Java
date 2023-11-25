package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.mysql.cj.xdevapi.Statement;

//import com.mysql.cj.jdbc.CallableStatement;
//import com.sun.corba.se.pept.transport.Connection;

import dao.IAdminDao;
import entidades.Localidades;
import entidades.Personas;
import entidades.Prestamos;
import entidades.Provincias;
import entidades.Usuario;
import conexion.conexion;


public class AdminDaoImpl implements IAdminDao {
	
	private conexion conexion;

	@Override
	public List<Usuario> listarUsuarios() {
		
		List <Usuario> lista= new ArrayList<Usuario>();
		conexion= new conexion();
		String query= "select U.IdUsuario_U, U.Usuario_U,P.Nombre_P,P.Apellido_P,P.DNI_P,P.Correo_P from Usuario as U inner join Personas P on P.IdPersona_P = U.IdPersona_U where U.Estado_U= true";
		
		try {
			conexion.Open();
			ResultSet rs= conexion.query(query);
			
			while(rs.next()) {
				Usuario usuario= new Usuario();
				
				usuario.setIdUsuario_U(rs.getInt(1));
				usuario.setUsuario_U(rs.getString(2));
				usuario.getIdPersona_U().setNombre_P(rs.getString(3));
				usuario.getIdPersona_U().setApellido_P(rs.getString(4));
				usuario.getIdPersona_U().setDNI_P(rs.getString(5));
				usuario.getIdPersona_U().setCorreo_P(rs.getString(6));
						
				lista.add(usuario);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		
		return lista;
	}
	

	public List<Prestamos> listarPrestamos() {
		List<Prestamos> lista = new ArrayList<Prestamos>();
		conexion = new conexion();
		String query = "SELECT P.NumPrestamo_P,P.NumCuenta_P, P.ImportePagar_P, P.ImportePedido_P, P.PlazoPago, C.NumCuenta_Cta FROM prestamos as P INNER JOIN cuenta C on P.NumCuenta_P = C.NumCuenta_Cta";
		
		try {
			conexion.Open();
			ResultSet rs= conexion.query(query);
			
			while(rs.next()) {
				Prestamos prestamos= new Prestamos();
				
				prestamos.setNumPrestamo_P(rs.getInt(1));
				prestamos.getNumCuenta_P().setNumCuenta_Cta(rs.getInt(2));
				prestamos.setImportePagar_P(rs.getFloat(3));
				prestamos.setImportePedido_P(rs.getFloat(4));
				prestamos.setPlazoPago_P(rs.getString(5));
						
				lista.add(prestamos);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		
		return lista;

	}


	@Override
	public boolean eliminarCliente(int id) {
		
		conexion= new conexion();
		boolean guardado=true;
		
		String query= "update usuario set Estado_u=false where IdUsuario_U="+id;
		try {
			conexion.Open();
			guardado=conexion.execute(query);	
			
		} catch (Exception e) {
			guardado=false;
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		return guardado;
	}


	@Override
	public Usuario obtenerCliente(int id) {
		
		conexion= new conexion();
		Usuario user= new Usuario();
		Personas persona= new Personas();
		
		String query= "select U.IdUsuario_U as idUsuario,U.Pass_U as Pass,U.IdPersona_U as idPersona,U.Usuario_U as nombreUsuario,U.IdRoles_U as Rol,U.Estado_U as Estado, P.DNI_P as DNI, L.Nombre_Loc as Localidad,Pr.Nombre_Prov as Provincia,P.CUIL_P as Cuil, P.Nombre_P as Nombre,P.Apellido_P as Apellido,P.Sexo_P as Sexo, P.Nacionalidad_P as Nacionalidad,P.FechaNac_P as Fecha,P.Direccion_P as Direccion, P.Correo_P as Correo, P.Telefono_P as Telefono from usuario as U inner join personas P on P.IdPersona_P=U.IdPersona_U inner join localidades L on L.CodLocalidad_Loc=P.CodLocalidad_P inner join provincias Pr on Pr.CodProvincia_Prov=P.CodProvincia_P where U.IdUsuario_U="+id;
		
		//U.Contraseña as Contrase�a, Hay que agregarlo
		try {
			conexion.Open();
			
			ResultSet rs= conexion.query(query);
			
			rs.next();
			persona.setIdPersona_P(rs.getInt("idPersona"));
			persona.setNombre_P(rs.getString("Nombre"));
			persona.setApellido_P(rs.getString("Apellido"));
			persona.setDNI_P(rs.getString("DNI"));
			persona.setSexo_P(rs.getString("Sexo"));
			persona.setCUIL_P(rs.getString("Cuil"));
			persona.setDireccion_P(rs.getString("Direccion"));
			persona.setCorreo_P(rs.getString("Correo"));
			persona.setTelefono_P(rs.getString("Telefono"));
			persona.setFechaNac_P(rs.getDate("Fecha"));
			
			Localidades localidad= new Localidades();
			localidad.setNombre_Loc(rs.getString("Localidad"));
			persona.setCodLocalidad_P(localidad);
			
			Provincias provincia= new Provincias();
			provincia.setNombre_Prov(rs.getString("Provincia"));
			persona.setCodProvincia_P(provincia);
			
			user.setIdUsuario_U(rs.getInt("idUsuario"));
			user.setUsuario_U(rs.getString("nombreUsuario"));
			user.setPassword_U(rs.getString("Pass"));
			user.setIdPersona_U(persona);
			
			System.out.println(user.toString());
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		
		return user;
	}
	@Override
	public Usuario obtenerClientev2(String nombre) {
		System.out.println("usuario: "+ nombre);
		
		conexion= new conexion();
		Usuario user= new Usuario();
		Personas persona= new Personas();
		
		String query= "select U.Pass as Pass,U.Usuario_U as nombreUsuario, P.DNI_P as DNI,P.CUIL_P as Cuil, P.Nombre_P as Nombre,P.Apellido_P as Apellido, P.Direccion_P as Direccion, P.Correo_P as Correo, P.Telefono_P as Telefono from usuario as U inner join personas P on P.IdPersona_P=U.IdPersona_U where U.Usuario_U="+"'"+nombre+"'";
		
		//U.Contraseña as Contraseña, Hay que agregarlo
		try {
			conexion.Open();
			
			ResultSet rs= conexion.query(query);
			
			rs.next();
			persona.setNombre_P(rs.getString("Nombre"));
			persona.setApellido_P(rs.getString("Apellido"));
			persona.setDNI_P(rs.getString("DNI"));
			persona.setCUIL_P(rs.getString("Cuil"));
			persona.setDireccion_P(rs.getString("Direccion"));
			persona.setCorreo_P(rs.getString("Correo"));
			persona.setTelefono_P(rs.getString("Telefono"));
		
			user.setUsuario_U(rs.getString("nombreUsuario"));
			user.setPassword_U(rs.getString("Pass"));
			user.setIdPersona_U(persona);
			
			System.out.println(user.toString());
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		
		return user;
	}


	@Override
	public List<Personas> listarSolicitudes() {
		
		List <Personas> Lista = new ArrayList<Personas>();
		conexion= new conexion();
		String query= "SELECT IdPersona_P, DNI_P, Nombre_Loc, Nombre_Prov, CUIL_P, Nombre_P, Apellido_P, Sexo_P, Nacionalidad_P, FechaNac_P, Direccion_P, Correo_P, Telefono_P, Solicitud_P FROM Personas INNER JOIN Localidades ON CodLocalidad_P = CodLocalidad_Loc INNER JOIN Provincias ON CodProvincia_P = CodProvincia_Prov";
		try {
			conexion.Open();
			ResultSet rs = conexion.query(query);
			
			while(rs.next()) {
				Personas persona = new Personas();

				persona.setIdPersona_P(rs.getInt("idPersona_P"));
				persona.setNombre_P(rs.getString("Nombre_P"));
				persona.setApellido_P(rs.getString("Apellido_P"));
				persona.setDNI_P(rs.getString("DNI_P"));
				persona.setSexo_P(rs.getString("Sexo_P"));
				persona.setNacionalidad_P(rs.getString("Nacionalidad_P"));
				persona.setCUIL_P(rs.getString("CUIL_p"));
				persona.setDireccion_P(rs.getString("Direccion_P"));
				persona.setCorreo_P(rs.getString("Correo_P"));
				persona.setTelefono_P(rs.getString("Telefono_P"));
				persona.setFechaNac_P(rs.getDate("FechaNac_P"));
				persona.setSolicitud_P(rs.getInt("Solicitud_P"));
				
				Localidades localidad= new Localidades();
				localidad.setNombre_Loc(rs.getString("Nombre_Loc"));
				persona.setCodLocalidad_P(localidad);
				
				Provincias provincia= new Provincias();
				provincia.setNombre_Prov(rs.getString("Nombre_Prov"));
				persona.setCodProvincia_P(provincia);
				
				Lista.add(persona);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		return Lista;
			
	}
	
	public String DNIusuario() 
	{
		String DNI="";
		
		conexion = new conexion();
		String query = "SELECT DNI_P FROM Personas";
		
		try {
			conexion.Open();
			ResultSet rs= conexion.query(query);
			
			rs.next();
			DNI = rs.getString("DNI_P");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		
		return DNI;
	}
	
	public boolean cambiarEstadoSolicitud(int ID, int estado) {
		
		conexion= new conexion();
		boolean guardado=true;
		
		String query= "update personas set Solicitud_P="+estado+" where IdPersona_P="+ID;
		try {
			conexion.Open();
			guardado=conexion.execute(query);	
			
		} catch (Exception e) {
			guardado=false;
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		return guardado;
	}


	@Override
	public boolean altaUsuario(int ID, String user, String pass, int rol) {
		conexion= new conexion();
		boolean guardado=true;
		
		try {
			CallableStatement cst =  conexion.Open().prepareCall("CALL SP_AgregarUsuario(?,?,?,?)");
			cst.setInt(1, ID);
			cst.setString(2, user);
			cst.setString(3, pass);
			cst.setInt(4, rol);
			cst.execute();
			
		} catch (Exception e) {
			guardado=false;
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		return guardado;
	}


	@Override
	public List<Localidades> listarLocalidades() {
		List <Localidades> Lista = new ArrayList<Localidades>();
		conexion= new conexion();
		String query= "select CodLocalidad_Loc,CodProvincia_Loc,Nombre_Loc FROM localidades ";
		try {
			conexion.Open();
			ResultSet rs = conexion.query(query);
			
			while(rs.next()) {
				Localidades Localidad = new Localidades();
				
				Localidad.setCodLocalidad_Loc(rs.getInt("CodLocalidad_Loc"));
				Localidad.setCodProvincia_Loc(rs.getInt("CodProvincia_Loc"));
				Localidad.setNombre_Loc(rs.getString("Nombre_Loc"));
				
				Lista.add(Localidad);
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		return Lista;

	}


	@Override
	public List<Provincias> listarProvincias() {
		
		List <Provincias> Lista = new ArrayList<Provincias>();
		conexion= new conexion();
		String query= "SELECT CodProvincia_Prov, Nombre_Prov FROM provincias";
		try {
			conexion.Open();
			ResultSet rs = conexion.query(query);
			
			while(rs.next()) {
				Provincias Provincia = new Provincias();
				
				Provincia.setCodProvincia_Prov(rs.getInt("CodProvincia_Prov"));
				Provincia.setNombre_Prov(rs.getString("Nombre_Prov"));
				
				Lista.add(Provincia);
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		return Lista;

	}


	@Override
	public boolean AgregarPersona(String DNI, int localidad, int provincia, String CUIL, String nombre, String apellido,
			String sexo, String nacionalidad, String fecha, String direccion, String mail, String tel,
			boolean solicitud) {
		
		conexion= new conexion();
		boolean guardado=true;
		
		try {
			CallableStatement cst =  conexion.Open().prepareCall("CALL SP_AgregarPersona(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			cst.setString(1, DNI);
			cst.setInt(2, localidad);
			cst.setInt(3, provincia);
			cst.setString(4, CUIL);
			cst.setString(5, nombre);
			cst.setString(6, apellido);
			cst.setString(7, sexo);
			cst.setString(8, nacionalidad);
			cst.setString(9, fecha);
			cst.setString(10, direccion);
			cst.setString(11, mail);
			cst.setString(12, tel);
			cst.setBoolean(13, solicitud);
			cst.execute();
			
		} catch (Exception e) {
			guardado=false;
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		return guardado;
		
	}


	@Override
	public int Codlocalidad(String nombre) {
		int codigo = 0;
		conexion= new conexion();
		String query= "SELECT CodLocalidad_Loc FROM localidades WHERE Nombre_Loc="+nombre;
		
		try {
			conexion.Open();
			ResultSet rs = conexion.query(query);
			
			rs.next();
			codigo = rs.getInt("CodLocalidad_Loc");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		return codigo;
	}


	@Override
	public int CodProvincia(String nombre) {
		int codigo = 0;
		conexion= new conexion();
		String query= "SELECT CodProvincia_Prov FROM provincias WHERE Nombre_Prov="+nombre;
		
		try {
			conexion.Open();
			ResultSet rs = conexion.query(query);
			
			rs.next();
			codigo = rs.getInt("CodProvincia_Prov");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		return codigo;
	}


	@Override
	public boolean modificarCliente(Usuario user) {
		
		boolean exito=false;
		conexion= new conexion();
		
		String queryPersona= "update personas set CodLocalidad_P="+user.getIdPersona_U().getCodLocalidad_P().getCodLocalidad_Loc()+", CodProvincia_P="+user.getIdPersona_U().getCodProvincia_P().getCodProvincia_Prov()+",Nombre_P='"+user.getIdPersona_U().getNombre_P()+"',Apellido_P='"+user.getIdPersona_U().getApellido_P()+"',Direccion_P='"+user.getIdPersona_U().getDireccion_P()+"',Correo_P='"+user.getIdPersona_U().getCorreo_P()+"',Telefono_P='"+user.getIdPersona_U().getTelefono_P()+"' where IdPersona_P="+user.getIdPersona_U().getIdPersona_P()+"";
		String cambiarContraseña= "update usuario set Contraseña='"+user.getPassword_U()+"' where IdUsuario_U="+ user.getIdUsuario_U();
		
		try {
			conexion.Open();
			
			if(conexion.execute(queryPersona) && conexion.execute(cambiarContraseña)) {
				
				exito=true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conexion.close();
		}
		
		return exito;
	}


	@Override
	public List<Usuario> filtrarListaUsuarios(String filtro) {
		
		List <Usuario> lista= new ArrayList<Usuario>();
		conexion= new conexion();
		String query= "select U.IdUsuario_U, U.Usuario_U,P.Nombre_P,P.Apellido_P,P.DNI_P,P.Correo_P from Usuario as U inner join Personas P on P.IdPersona_P = U.IdPersona_U where U.Estado_U= true and Usuario_U LIKE '%"+ filtro+"%'";
		
		try {
			conexion.Open();
			ResultSet rs= conexion.query(query);
			
			while(rs.next()) {
				Usuario usuario= new Usuario();
				
				usuario.setIdUsuario_U(rs.getInt(1));
				usuario.setUsuario_U(rs.getString(2));
				usuario.getIdPersona_U().setNombre_P(rs.getString(3));
				usuario.getIdPersona_U().setApellido_P(rs.getString(4));
				usuario.getIdPersona_U().setDNI_P(rs.getString(5));
				usuario.getIdPersona_U().setCorreo_P(rs.getString(6));
						
				lista.add(usuario);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		
		return lista;
	}
}
