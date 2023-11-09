package daoImpl;

import java.sql.ResultSet;

import conexion.conexion;
import dao.IUsuario;
import entidades.Roles;
import entidades.Usuario;

public class UsuarioDaoImp implements IUsuario{
	
	private conexion cn;
	private final int ROL = 1;  
	
	
	public Usuario ValidarDatos(String usuario, String pass) {
		cn = new conexion();
		cn.Open();
		
		String query = "SELECT * FROM bd_tpint_grupo_6_lab4.usuario where Usuario_U = " + "'"+usuario+"'" + " and " + " Contrase�a = " + "'"+pass+"'";
		Usuario u = new Usuario();	
		try {
			
			ResultSet rs = cn.query(query);
			
			while (rs.next()) {
				
				Roles r = new Roles(); 
				
				u.setIdUsuario_U(rs.getInt("IdUsuario_U"));
				u.setUsuario_U(rs.getString("Usuario_U"));
				u.setPassword_U(rs.getString("Contraseña"));
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
			if(u.getIdRoles_U().getIdRol() == ROL) {
				return 1;// user admin
			}	
			return 0; // user no admin
		}
		return -1;// user no existe o datos inválidos
	}

}
