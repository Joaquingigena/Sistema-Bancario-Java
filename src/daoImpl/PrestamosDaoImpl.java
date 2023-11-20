package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;


import conexion.conexion;
import dao.IPrestamos;
import entidades.Prestamos;

public class PrestamosDaoImpl implements IPrestamos{
	private conexion conexion;
	@Override
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
	public boolean agregarPrestamo(Prestamos prestamo) {
		conexion= new conexion();
		try {
			
			CallableStatement cst = conexion.Open().prepareCall("CALL SPAgregarPrestamo(?,?,?,?,?,?)");
			cst.setInt(1, prestamo.getNumPrestamo_P());
			cst.setInt(2, prestamo.getNumCuenta_P().getNumCuenta_Cta());
			cst.setFloat(3, prestamo.getImportePagar_P());
			cst.setFloat(4, prestamo.getImportePedido_P());
			cst.setString(5, prestamo.getPlazoPago_P());
			cst.setInt(6, prestamo.getIdCuota_P().getIdCuota_C());
			
			int fila = cst.executeUpdate();
			if(fila > 0) return true;
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

}
