package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Connection;

import conexion.conexion;
import dao.IPrestamos;
import entidades.Prestamos;
import entidades.Cuotas;

public class PrestamosDaoImpl implements IPrestamos{
	private conexion conexion;
	@Override
	public List<Prestamos> listarPrestamos() {
		List<Prestamos> lista = new ArrayList<Prestamos>();
		conexion = new conexion();
		String query = "SELECT P.NumPrestamo_P, IDusuario_P ,P.NumCuenta_P, P.ImportePagar_P, P.ImportePedido_P, Cu.CantidadCuota_C, P.Estado, P.Autorizado FROM prestamos as P INNER JOIN cuenta C on P.NumCuenta_P = C.NumCuenta_Cta INNER JOIN Cuotas Cu on IdCuota_P = IdCuota_C order by P.numPrestamo_P ASC";
		
		try {
			conexion.Open();
			ResultSet rs= conexion.query(query);
			
			while(rs.next()) {
				Prestamos prestamos= new Prestamos();
				
				prestamos.setNumPrestamo_P(rs.getInt(1));
				prestamos.setNumCliente_P(rs.getInt(2));
				prestamos.getNumCuenta_P().setNumCuenta_Cta(rs.getInt(3));
				prestamos.setImportePagar_P(rs.getFloat(4));
				prestamos.setImportePedido_P(rs.getFloat(5));
				prestamos.getIdCuota_P().setCantidadCuota_C(rs.getString(6));
				prestamos.setEstado(rs.getBoolean(7));
				prestamos.setAutorizado(rs.getBoolean(8));
						
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
	public List<Prestamos> listarPrestamos(int idUsuario) {
		List<Prestamos> lista = new ArrayList<Prestamos>();
		conexion = new conexion();
		String query = "SELECT P.NumPrestamo_P, IDusuario_P ,P.NumCuenta_P, P.ImportePagar_P, P.ImportePedido_P, Cu.CantidadCuota_C, P.Estado, P.Autorizado FROM prestamos as P INNER JOIN cuenta C on P.NumCuenta_P = C.NumCuenta_Cta INNER JOIN Cuotas Cu on IdCuota_P = IdCuota_C where IDusuario_P= " + idUsuario;
		
		try {
			conexion.Open();
			ResultSet rs= conexion.query(query);
			
			while(rs.next()) {
				Prestamos prestamos= new Prestamos();
				
				prestamos.setNumPrestamo_P(rs.getInt(1));
				prestamos.setNumCliente_P(rs.getInt(2));
				prestamos.getNumCuenta_P().setNumCuenta_Cta(rs.getInt(3));
				prestamos.setImportePagar_P(rs.getFloat(4));
				prestamos.setImportePedido_P(rs.getFloat(5));
				prestamos.getIdCuota_P().setCantidadCuota_C(rs.getString(6));
				prestamos.setEstado(rs.getBoolean(7));
				prestamos.setAutorizado(rs.getBoolean(8));
						
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
	public boolean agregarPrestamo(String monto, int cuotas, int cuenta) {
		conexion= new conexion();
		try {
			
			CallableStatement cst = conexion.Open().prepareCall("CALL SPAgregarPrestamo(?,?,?,?)");
			
			cst.setInt(1, cuenta);
			cst.setString(2, monto);
			cst.setString(3, monto);
			cst.setInt(4, cuotas);
			
			int fila = cst.executeUpdate();
			if(fila > 0) return true;
	
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	@Override
	public List<Prestamos> filtroAvanzado(String query) {
		
		List<Prestamos> lista = new ArrayList<Prestamos>();
		conexion = new conexion();
		
		System.out.println("query en el dao " + query);
		
		try {
			conexion.Open();
			ResultSet rs= conexion.query(query);
			
			while(rs.next()) {
				Prestamos prestamos= new Prestamos();
				
				prestamos.setNumPrestamo_P(rs.getInt(1));
				prestamos.getNumCuenta_P().setNumCuenta_Cta(rs.getInt(2));
				prestamos.setImportePagar_P(rs.getFloat(3));
				prestamos.setImportePedido_P(rs.getFloat(4));
				prestamos.getIdCuota_P().setCantidadCuota_C(rs.getString(5));
				prestamos.setNumCliente_P(rs.getInt(6));
				prestamos.setEstado(rs.getBoolean(7));
						
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
	public List<Cuotas> listarCuotas() {
		List<Cuotas> lista = new ArrayList<Cuotas>();
		conexion = new conexion();
		String query = "SELECT * from Cuotas";
		
		try {
			conexion.Open();
			ResultSet rs= conexion.query(query);
			
			while(rs.next()) {
				Cuotas c = new Cuotas();
				
				c.setIdCuota_C(rs.getInt(1));
				c.setCantidadCuota_C(rs.getString(2));
						
				lista.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		
		return lista;
	}
	
	public boolean validarPrestamo(int numCuenta)
	{
		ResultSet rs;
		conexion = new conexion();
		String consulta = "Select COUNT(NumCuenta_P) as NumeroC from Prestamos where NumCuenta_P = '"+ numCuenta + "' and (Estado = 1 or Estado = 0) and Autorizado = 1";
		boolean esValido= true;
		int num=0;
		try
		{
			conexion.Open();
			rs=conexion.query(consulta);
			while(rs.next())
			{
				num=rs.getInt("NumeroC");
			}
			System.out.println("numero de prestamos en la misma cuenta: "+ num);
			if(num<1)
			{
				esValido=true;
			}
			else
			{
				esValido=false;
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
		return esValido;
	}
	
	public boolean insertPrestamo(int numCtaOrigen, int idUsuario, float importePrestamo, float importe, String plazo, int cuotas, boolean estado, boolean autorizado)
	{
		conexion = new conexion();
		boolean isPrestado=true;
		try
		{
			CallableStatement cst = conexion.Open().prepareCall("CALL SPAgregarPrestamo(?,?,?,?,?,?,?,?)");
			cst.setInt(1,numCtaOrigen);
			cst.setInt(2,idUsuario);
			cst.setFloat(3, importePrestamo);
			cst.setFloat(4,importe);
			cst.setString(5, plazo);
			cst.setInt(6, cuotas);
			cst.setBoolean(7, estado);
			cst.setBoolean(8, autorizado);
			cst.execute();
		}
		catch (Exception e)
		{
			isPrestado=false;
			e.printStackTrace();
		}
		finally
		{
			conexion.close();
		}
		return isPrestado;
	}

	public boolean aceptarPrestamo(int numPrestamo, int numCuenta, int idUsuario, float importe) {
		
		ResultSet rs;
		conexion= new conexion();
		String consulta = "UPDATE Prestamos set Estado = 1 where NumPrestamo_P= '" + numPrestamo + "'";
		boolean iscreate= false;
		try
		{
			conexion.Open();
			iscreate=conexion.execute(consulta);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			conexion.close();
		}
		return iscreate;

	}
	
	public boolean rechazarPrestamo(int numPrestamo,int numCuenta, int idUsuario, float importe) {
		
		ResultSet rs;
		conexion= new conexion();
		String consulta = "UPDATE Prestamos set Autorizado = 0 where NumPrestamo_P= '" + numPrestamo + "'";
		boolean iscreate= false;
		try
		{
			conexion.Open();
			iscreate=conexion.execute(consulta);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			conexion.close();
		}
		return iscreate;

	}
	
	


}
