package daoImpl;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexion.conexion;
import dao.IMovimientos;
import entidades.Movimientos;


public class MovimientosDAOImpl implements IMovimientos{

	private conexion conexion; 
	
	@Override
	public List<Movimientos> obtenerMovimientosPorUsuario(String Nombre) {
		
		List<Movimientos> Movs = new ArrayList<Movimientos>();
		conexion= new conexion();
		String query= "SELECT m.*, tm.Descripcion_TM as Descripcion FROM movimientos m JOIN cuenta c ON m.NumCuentaDestino_Mo = c.NumCuenta_Cta or m.NumCuenta_M = c.NumCuenta_Cta  JOIN usuario u on c.IdUsuario_Cta = u.IdUsuario_U  JOIN tipoMovimientos TM on m.IdTipoMovimiento_M = TM.IdTipoMovimiento_TM  WHERE u.Usuario_U = '" + Nombre + "'";

		try {
			conexion.Open();
			ResultSet rs= conexion.query(query);
			
			while(rs.next()) {
				Movimientos movimiento = new Movimientos();
				movimiento.setNumMovimiento_M(rs.getInt(1));
				movimiento.setFechaMovimiento_M(rs.getTimestamp(4));
				movimiento.setDetalle_M(rs.getString(5));
				movimiento.setImporte_M(rs.getFloat(7));
				movimiento.setEstado_M(rs.getBoolean(8));
				movimiento.getIdTipoMovimiento_M().setIdTipoMovimiento_TM(rs.getInt("IdTipoMovimiento_M"));;
				movimiento.getIdTipoMovimiento_M().setDescripcion_TM(rs.getString("Descripcion"));
               
			
                Movs.add(movimiento);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		
		return Movs;
	}
	@Override
	public List<Movimientos> getMovimientosPorCuenta(int codMovimiento) {
		List<Movimientos> Movs = new ArrayList<Movimientos>();
		conexion= new conexion();

		String query= "SELECT m.*, tp.Descripcion_TM as Descripcion FROM movimientos m join tipomovimientos tp on tp.IdTipoMovimiento_TM = m.IdTipoMovimiento_M  WHERE m.NumCuentaDestino_Mo = '" + codMovimiento + "' or m.NumCuenta_M = '" + codMovimiento + "'";

		try {
			conexion.Open();
			ResultSet rs= conexion.query(query);
			
			while(rs.next()) {
				Movimientos movimiento = new Movimientos();
				movimiento.setNumMovimiento_M(rs.getInt(1));
				movimiento.setFechaMovimiento_M(rs.getTimestamp(4));
				movimiento.setDetalle_M(rs.getString(5));
				movimiento.setImporte_M(rs.getFloat(7));
				movimiento.setEstado_M(rs.getBoolean(8));           
				movimiento.getIdTipoMovimiento_M().setIdTipoMovimiento_TM(rs.getInt("IdTipoMovimiento_M"));;
				movimiento.getIdTipoMovimiento_M().setDescripcion_TM(rs.getString("Descripcion"));
                Movs.add(movimiento);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		
		return Movs;
	}
	@Override
	public boolean insertMovimientoPorUsuario(int numCtaOrigen, int numCtaDestino , String Detalle, float importe, int tipoMov, boolean estado) {
		Connection connection = null;
		conexion= new conexion();
		boolean isCreate = false;
		
		try {
			connection = conexion.Open();
			String query = "INSERT INTO bd_tpint_grupo_6_lab4.movimientos (NumCuenta_M, IdTipoMovimiento_M, Detalle_M, NumCuentaDestino_Mo, Importe_M, Estado_M) VALUES (?, ?, ?, ?, ?, ?)";

			// Crear una declaración preparada con la consulta SQL
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			// Establecer los valores para las columnas utilizando métodos setXXX 
			preparedStatement.setInt(1, numCtaOrigen); 
			preparedStatement.setInt(2, tipoMov); 
			preparedStatement.setString(3, Detalle);
			preparedStatement.setInt(4, numCtaDestino);
			preparedStatement.setFloat(5, importe);
			preparedStatement.setBoolean(6, estado);
			
			// Ejecutar la declaración de inserción
			preparedStatement.executeUpdate();
			isCreate = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		
		return isCreate;
	}

}