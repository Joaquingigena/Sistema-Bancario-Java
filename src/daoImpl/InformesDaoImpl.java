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
		String query= "select M.numMovimiento_M, M.numCuenta_M, M.fechaMovimiento_M, M.detalle_M, M.importe_M, M.idTipoMovimiento_M, M.estado_M from Movimientos as M inner join Cuenta C on C.numCuenta_Cta = M.numCuenta_M inner join TipoMovimientos TM on TM.idTipoMovimiento_TM = M.idTipoMovimiento_M";
		
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
