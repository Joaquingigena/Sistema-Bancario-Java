package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IAdminDao;
import entidades.Usuario;
import conexion.conexion;


public class AdminDaoImpl implements IAdminDao {
	
	private conexion conexion;

	@Override
	public List<Usuario> listarUsuarios() {
		
		List <Usuario> lista= new ArrayList<Usuario>();
		conexion= new conexion();
		String query= "select U.IdUsuario_U, U.Usuario_U,P.Nombre_P,P.Apellido_P,P.DNI_P,P.Correo_P from usuario as U inner join personas P on P.IdPersona_P = U.IdPersona_U";
		
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
