package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Connection;


import dao.IPagoPres;
import entidades.PagoCuotasPrestamo;
import conexion.conexion;


public class PagoPresDAOImpl implements IPagoPres{
	private conexion conexion;
	@Override
	public List<PagoCuotasPrestamo> listarCuotas(int numPrestamo) {
		List<PagoCuotasPrestamo> lista = new ArrayList<PagoCuotasPrestamo>();
	    conexion = new conexion();
	    String query = "SELECT NumPrestamo_PCP, CodPago_PCP, NumCuenta_PCP, NumCuota_PCP, MontoPagoMes_PCP, FechaPago_PCP, Estado_PCP "
	                 + "FROM pagocuotasprestamo WHERE NumPrestamo_PCP = " + numPrestamo;
	    
	    try {
	    	conexion.Open();
	        ResultSet rs = conexion.query(query);
	        
	        while(rs.next()) {
	            PagoCuotasPrestamo pagoCuotasPrestamo = new PagoCuotasPrestamo();
	            
	            pagoCuotasPrestamo.getNumPrestamo_PCP().setNumPrestamo_P(rs.getInt("NumPrestamo_PCP"));
	            pagoCuotasPrestamo.setCodPago_PCP(rs.getInt("CodPago_PCP"));
	            pagoCuotasPrestamo.getNumCuenta_PCP().setNumCuenta_Cta(rs.getInt("NumCuenta_PCP"));
	            pagoCuotasPrestamo.setNumCuota_PCP(rs.getInt("NumCuota_PCP"));
	            pagoCuotasPrestamo.setMontoPagoMes_PCP(rs.getFloat("MontoPagoMes_PCP"));
	            pagoCuotasPrestamo.setFechaPago_PCP(rs.getDate("FechaPago_PCP"));
	            pagoCuotasPrestamo.setEstado_PCP(rs.getBoolean("Estado_PCP"));
	                    
	            lista.add(pagoCuotasPrestamo);
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        conexion.close();
	    }
	    return lista;
	}

}
