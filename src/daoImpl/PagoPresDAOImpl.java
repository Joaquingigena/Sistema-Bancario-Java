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
	            PagoCuotasPrestamo p = new PagoCuotasPrestamo();
	            
	            p.getNumPrestamo_PCP().setNumPrestamo_P(rs.getInt("NumPrestamo_PCP"));
	            p.setCodPago_PCP(rs.getInt("CodPago_PCP"));
	            p.getNumCuenta_PCP().setNumCuenta_Cta(rs.getInt("NumCuenta_PCP"));
	            p.setNumCuota_PCP(rs.getInt("NumCuota_PCP"));
	            p.setMontoPagoMes_PCP(rs.getFloat("MontoPagoMes_PCP"));
	            p.setFechaPago_PCP(rs.getDate("FechaPago_PCP"));
	            p.setEstado_PCP(rs.getBoolean("Estado_PCP"));
	                    
	            lista.add(p);
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        conexion.close();
	    }
	    return lista;
	}
	
	@Override
	public PagoCuotasPrestamo getPagoPorCuenta(int numCuenta)
	{
		conexion = new conexion();
		String query = "Select CodPago_PCP, NumPrestamo_PCP, NumCuenta_PCP, NumCuota_PCP, MontoPagoMes_PCP, FechaPago_PCP, Estado_PCP " 
		+ "FROM pagocuotasPrestamo where Estado_PCP = 1 and NumCuenta_PCP = '" + numCuenta +"' order by CodPago_PCP ASC LIMIT 1";
		
		PagoCuotasPrestamo pago = new PagoCuotasPrestamo();
		try {
			conexion.Open();
			ResultSet rs = conexion.query(query);
			while(rs.next())
			{
				
				
				pago.setCodPago_PCP(rs.getInt("CodPago_PCP"));
				pago.getNumPrestamo_PCP().setNumPrestamo_P(rs.getInt("NumPrestamo_PCP"));
				pago.getNumCuenta_PCP().setNumCuenta_Cta(rs.getInt("NumCuenta_PCP"));
	            pago.setNumCuota_PCP(rs.getInt("NumCuota_PCP"));
	            pago.setMontoPagoMes_PCP(rs.getFloat("MontoPagoMes_PCP"));
	            pago.setFechaPago_PCP(rs.getDate("FechaPago_PCP"));
	            pago.setEstado_PCP(rs.getBoolean("Estado_PCP"));
				
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			conexion.close();
		}
		return pago;
	}
	

}
