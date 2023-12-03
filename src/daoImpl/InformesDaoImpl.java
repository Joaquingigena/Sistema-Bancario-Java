package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IInformes;
import entidades.Movimientos;
import conexion.conexion;


public class InformesDaoImpl implements IInformes{
	private conexion conexion;
	
	public List<Movimientos> listarMovimientos() {
		
		List <Movimientos> lista= new ArrayList<Movimientos>();
		conexion= new conexion();
		String query= "SELECT\r\n" + 
				"    M.NumMovimiento_M,\r\n" + 
				"    M.NumCuenta_M,\r\n" + 
				"    C.IdUsuario_Cta,\r\n" + 
				"    U.Usuario_U,\r\n" + 
				"    P.Nombre_P,\r\n" + 
				"    P.Apellido_P,\r\n" + 
				"    M.FechaMovimiento_M,\r\n" + 
				"    M.Detalle_M,\r\n" + 
				"    M.Importe_M,\r\n" + 
				"    M.IdTipoMovimiento_M,\r\n" + 
				"    M.Estado_M\r\n" + 
				"FROM\r\n" + 
				"    Movimientos AS M\r\n" + 
				"INNER JOIN\r\n" + 
				"    Cuenta AS C ON C.NumCuenta_Cta = M.NumCuenta_M\r\n" + 
				"INNER JOIN\r\n" + 
				"    usuario AS U ON U.IdUsuario_U = C.IdUsuario_Cta\r\n" + 
				"INNER JOIN\r\n" + 
				"    personas AS P ON U.IdPersona_U = P.IdPersona_P\r\n" + 
				"INNER JOIN\r\n" + 
				"    TipoMovimientos AS TM ON TM.IdTipoMovimiento_TM = M.IdTipoMovimiento_M;";
		try {
			conexion.Open();
			ResultSet rs= conexion.query(query);
			
			while(rs.next()) {
				Movimientos movimiento= new Movimientos();
				
				movimiento.setNumMovimiento_M(rs.getInt(1));
				movimiento.getNumCuenta_M().setNumCuenta_Cta(rs.getInt(2));
				movimiento.getNumCuenta_M().getIdUsuario_Cta().getIdPersona_U().setNombre_P(rs.getString(5));
				movimiento.getNumCuenta_M().getIdUsuario_Cta().getIdPersona_U().setApellido_P(rs.getString(6));
				movimiento.setFechaMovimiento_M(rs.getDate(7));
				movimiento.setDetalle_M(rs.getString(8));
				movimiento.setImporte_M(rs.getFloat(9));
				movimiento.getIdTipoMovimiento_M().setIdTipoMovimiento_TM(rs.getInt(10));
				movimiento.setEstado_M(rs.getString(11));
				
						
				lista.add(movimiento);
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
	public List<Movimientos> filtroAvanzado(String query) {
		List <Movimientos> lista= new ArrayList<Movimientos>();
		conexion= new conexion();
		
		try {
			conexion.Open();
			ResultSet rs= conexion.query(query);
			
			while(rs.next()) {
				Movimientos movimiento= new Movimientos();
				
				movimiento.setNumMovimiento_M(rs.getInt(1));
				movimiento.getNumCuenta_M().setNumCuenta_Cta(rs.getInt(2));
				movimiento.setFechaMovimiento_M(rs.getDate(3));
				movimiento.setDetalle_M(rs.getString(4));
				movimiento.setImporte_M(rs.getFloat(5));
				movimiento.getIdTipoMovimiento_M().setIdTipoMovimiento_TM(rs.getInt(6));
				movimiento.setEstado_M(rs.getString(7));
				
						
				lista.add(movimiento);
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
