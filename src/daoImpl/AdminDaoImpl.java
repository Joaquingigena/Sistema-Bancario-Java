package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
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
			e.printStackTrace();
		}
		finally {
			guardado=false;
			conexion.close();
		}
		return guardado;
	}


	@Override
	public Usuario obtenerCliente(int id) {
		
		conexion= new conexion();
		Usuario user= new Usuario();
		Personas persona= new Personas();
		
		String query= "select U.IdUsuario_U as idUsuario,U.IdPersona_U as idPersona,U.Usuario_U as nombreUsuario,U.ContraseÃ±a as Contraseña,U.IdRoles_U as Rol,U.Estado_U as Estado, P.DNI_P as DNI, L.Nombre_Loc as Localidad,Pr.Nombre_Prov as Provincia,P.CUIL_P as Cuil, P.Nombre_P as Nombre,P.Apellido_P as Apellido,P.Sexo_P as Sexo, P.Nacionalidad_P as Nacionalidad,P.FechaNac_P as Fecha,P.Direccion_P as Direccion, P.Correo_P as Correo, P.Telefono_P as Telefono from usuario as U inner join personas P on P.IdPersona_P=U.IdPersona_U inner join localidades L on L.CodLocalidad_Loc=P.CodLocalidad_P inner join provincias Pr on Pr.CodProvincia_Prov=P.CodProvincia_P where U.IdUsuario_U="+id;
		
		try {
			conexion.Open();
			
			ResultSet rs= conexion.query(query);
			
			rs.next();
			persona.setIdPersona_P(rs.getInt("idPersona"));
			persona.setNombre_P(rs.getString("Nombre"));
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
			user.setPassword_U(rs.getString("Contraseña"));
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
				//Localidades Loc = new Localidades();
				//Provincias Prov = new Provincias();
				
				//Loc.setCodLocalidad_Loc(1);
				//Prov.setCodProvincia_Prov(1);
				
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
			//conexion.close();
			//return Lista;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//conexion.close();
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
			e.printStackTrace();
		}
		finally {
			guardado=false;
			conexion.close();
		}
		return guardado;
	}
}
