package daoImpl;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexion.conexion;
import dao.IMovimientos;
import entidades.Movimientos;


public class MovimientosDAOImpl implements IMovimientos{

	private conexion conexion; 
	@Override
	public List<Movimientos> obtenerMovimientosPorUsuario(int idUsuario, int numCuenta) {
		
		List<Movimientos> Movs = new ArrayList<Movimientos>();
		conexion= new conexion();
		String query= "SELECT m.*, c.*"+
				"FROM movimientos m"+
				"JOIN cuenta c ON m.NumCuenta_M = c.NumCuenta_Cta"+
				"WHERE c.IdUsuario_Cta = " + idUsuario +
				"AND c.NumCuenta_Cta = "+ numCuenta;

		try {
			conexion.Open();
			ResultSet rs= conexion.query(query);
			
			while(rs.next()) {
				Movimientos movimiento = new Movimientos();
				movimiento.setNumMovimiento_M(rs.getInt(1));
				movimiento.setFechaMovimiento_M(rs.getDate(3));
				movimiento.setDetalle_M(rs.getString(4));
				movimiento.setImporte_M(rs.getFloat(5));
				movimiento.setEstado_M(rs.getString(7));
                //movimiento.getNumCuenta_M().setIdUsuario_Cta(rs.getInt(9));
               
			
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

}