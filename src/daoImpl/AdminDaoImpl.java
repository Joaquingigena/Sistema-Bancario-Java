package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IAdminDao;
import entidades.Prestamos;
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
}
