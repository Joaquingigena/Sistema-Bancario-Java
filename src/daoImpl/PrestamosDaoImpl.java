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
		String query = "SELECT P.NumPrestamo_P,P.NumCuenta_P, P.ImportePagar_P, P.ImportePedido_P, Cu.CantidadCuota_C, P.Estado FROM prestamos as P INNER JOIN cuenta C on P.NumCuenta_P = C.NumCuenta_Cta INNER JOIN Cuotas Cu on IdCuota_P = IdCuota_C";
		
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
				prestamos.setEstado(rs.getBoolean(6));
						
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
		
		try {
			conexion.Open();
			ResultSet rs= conexion.query(query);
			
			while(rs.next()) {
				Prestamos prestamos= new Prestamos();
				
				prestamos.setNumPrestamo_P(rs.getInt(1));
				prestamos.getNumCuenta_P().setNumCuenta_Cta(rs.getInt(2));
				prestamos.setImportePagar_P(rs.getFloat(3));
				prestamos.setImportePedido_P(rs.getFloat(4));
				prestamos.getIdCuota_P().setIdCuota_C(rs.getInt(5));
				prestamos.setEstado(rs.getBoolean(6));
						
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
		String consulta = "Select COUNT(NumCuenta_P) as NumeroC from Prestamos where NumCuenta_P = '"+ numCuenta + "' and Estado = 1";
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
			if(num<=1)
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
	
	public boolean insertPrestamo(int numCtaOrigen, int idUsuario, float importePrestamo, float importe, String plazo, int cuotas, boolean estado)
	{
		conexion = new conexion();
		boolean isPrestado=true;
		try
		{
			CallableStatement cst = conexion.Open().prepareCall("CALL SPAgregarPrestamo(?,?,?,?,?,?)");
			cst.setInt(1,numCtaOrigen);
			cst.setFloat(2, importePrestamo);
			cst.setFloat(3,importe);
			cst.setString(4, plazo);
			cst.setInt(5, cuotas);
			cst.setBoolean(6, estado);
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
	
	@Override
	public boolean altaPrestamo(int numPrestamo) {
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
	public boolean deletePrestamo(int numPrestamo) {
		ResultSet rs;
		conexion = new conexion();
		String consulta = "DELETE from Prestamos where NumPrestamo_P= '" + numPrestamo + "'";
		boolean iscreate= false;
		try
		{
			conexion.Open();
			iscreate=conexion.executeDelete(consulta);
			
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
	
	
	/*
	 Y LA NUEVA TABLA DE PRESTAMOS, SOLO SE ELIMINA EL PLAZOPAGOS:
	 
	 create table Prestamos
(
NumPrestamo_P int not null auto_increment,
NumCuenta_P int not null,
ImportePagar_P float (10,2) not null default 0,
ImportePedido_P float (10,2) not null default 0,
IdCuota_P int not null,
Estado boolean not null default 1, -- ???
constraint PK_PRESTAMOS primary key (NumPrestamo_P, NumCuenta_P),
constraint FK_PRESTAMOS_CUENTA foreign key (NumCuenta_P)
references Cuenta (NumCuenta_Cta),
constraint FK_PRESTAMOS_CUOTAS foreign key (IdCuota_P)
references Cuotas (IdCuota_C)
);


	PROCEDIMIENTO ALMACENADO PARA AGREGAR UN PRESTAMO A LA DB:
	CREATE DEFINER=`root`@`localhost` PROCEDURE `SPAgregarPrestamo`(
     IN NumCuenta INT,
     IN ImpPagar DECIMAL(10,2),
     IN impPedido DECIMAL(10,2),
     IN IdCuota INT,
     IN estado boolean
)
BEGIN
    INSERT INTO Prestamos (NumCuenta_P, ImportePagar_P, ImportePedido_P, IdCuota_P, Estado) 
    VALUES (NumCuenta, ImpPagar, impPedido, IdCuota, estado);
END //

DELIMITER ;
	 */

}
