package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexion.conexion;
import dao.IUsuario;
import entidades.Personas;
import entidades.Roles;
import entidades.Usuario;

public class UsuarioDaoImp implements IUsuario{
	
	private conexion cn;
	private final int ROL = 1;  
	
	
	public Usuario ValidarDatos(String usuario, String pass) {
		cn = new conexion();
		cn.Open();
		
		String query = "SELECT * FROM bd_tpint_grupo_6_lab4.usuario where Usuario_U = " + "'"+usuario+"'" + " and " + " Pass_U = " + "'"+pass+"'";
		Usuario u = new Usuario();	
		try {
			
			ResultSet rs = cn.query(query);
			
			while (rs.next()) {
				
				Roles r = new Roles(); 
				
				u.setIdUsuario_U(rs.getInt("IdUsuario_U"));
				u.setUsuario_U(rs.getString("Usuario_U"));
				u.setPassword_U(rs.getString("Pass_U"));
				r.setIdRoles_R(rs.getInt("IdRoles_U"));
				u.setIdRoles_U(r);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			cn.close();
		}
		
		return u;
		
	}
	
	@Override
	public int Login(String usuario, String pass) {
		Usuario u = ValidarDatos(usuario, pass);
		System.out.println("datos: "+ u);
		if(u.getIdUsuario_U() != 0) {
			if(u.getIdRoles_U().getIdRol() == 1) {
				return 1;// user admin
			}	
			return 0; // user no admin
		}
		return -1;// user no existe o datos inválidos
	}

	@Override
	public int ObtenerIdUsuario(String nombre) {
		cn = new conexion();
		cn.Open();
		
		String query = "SELECT IdUsuario_U FROM bd_tpint_grupo_6_lab4.usuario where Usuario_U = " + "'"+nombre+"'";
		
		try {
			
			ResultSet rs = cn.query(query);
			
			while (rs.next()) {
				int idUsuario = rs.getInt("IdUsuario_U");
				System.out.println("id usuario: "+ idUsuario);
	            return idUsuario;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			cn.close();
		}
		return 0; // retorna 0 si no existe usuario
	}

	@Override
	public Personas getUsuarioPorCBU(String cbu) {
		cn = new conexion();
		cn.Open();
		
		String query = "SELECT p.* FROM bd_tpint_grupo_6_lab4.personas p" +
					   " join bd_tpint_grupo_6_lab4.usuario u on u.IdPersona_U = p.IdPersona_P" +
				       " join bd_tpint_grupo_6_lab4.cuenta c on c.IdUsuario_Cta = u.IdUsuario_U" + 
					   " WHERE c.CBU_Cta =" +"'"+cbu+"'";
		
		Personas persona = new Personas();
		try {
			
			ResultSet rs = cn.query(query);
			
			while (rs.next()) {
				
				persona.setIdPersona_P(rs.getInt(1));
				persona.setDNI_P(rs.getString(2));
				persona.setCUIL_P(rs.getString(5));
				persona.setNombre_P(rs.getString(6));
				persona.setApellido_P(rs.getString(7));

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			cn.close();
		}
		return persona; 
	}
	
	

}
