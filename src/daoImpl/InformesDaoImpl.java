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
				"    M.Estado_M,\r\n" + 
				"    M.NumCuentaDestino_Mo \r\n" + 
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
				movimiento.getNumCuenta_M().getIdUsuario_Cta().setIdUsuario_U(rs.getInt(3));
				movimiento.getNumCuenta_M().getIdUsuario_Cta().setUsuario_U(rs.getString(4));
				movimiento.getNumCuenta_M().getIdUsuario_Cta().getIdPersona_U().setNombre_P(rs.getString(5));
				movimiento.getNumCuenta_M().getIdUsuario_Cta().getIdPersona_U().setApellido_P(rs.getString(6));
				movimiento.setFechaMovimiento_M(rs.getTimestamp(7));
				movimiento.setDetalle_M(rs.getString(8));
				movimiento.setImporte_M(rs.getFloat(9));
				movimiento.getIdTipoMovimiento_M().setIdTipoMovimiento_TM(rs.getInt(10));
				movimiento.setEstado_M(rs.getBoolean(11));
				movimiento.getNumCuentaDestino_Mo().setNumCuenta_Cta(rs.getInt(12));;
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
				movimiento.setFechaMovimiento_M(rs.getTimestamp(3));
				movimiento.setDetalle_M(rs.getString(4));
				movimiento.setImporte_M(rs.getFloat(5));
				movimiento.getIdTipoMovimiento_M().setIdTipoMovimiento_TM(rs.getInt(6));
				movimiento.setEstado_M(rs.getBoolean(7));
				
						
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
	
	public int filtroPorMovimientosRealizado(String fechaIni, String fechaFin)
	{
		conexion= new conexion();
		String query = "select count(NumMovimiento_M) as MovimientosRealizados from Movimientos where FechaMovimiento_M >= ' " + fechaIni + "' and FechaMovimiento_M <= ' " + fechaFin + "' and Estado_M = 1";
		int cont = 0;
		try
		{
			conexion.Open();
			ResultSet rs = conexion.query(query);
			while(rs.next())
			{
				cont = rs.getInt("MovimientosRealizados");
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
		return cont;
	}
	
	public float filtroPorMontoPrestamos(String fechaIni, String fechaFin) 
	{
		conexion=new conexion();
		String query = "select sum(Importe_M) as MontoTotalPrestamosOtorgados from Movimientos where IdTipoMovimiento_M = '2' and Estado_M = 1 and FechaMovimiento_M >=' " +fechaIni + "' and FechaMovimiento_M <= '" + fechaFin + "'";
		float montoPrestamo = 0;
		try
		{
			conexion.Open();
			ResultSet rs = conexion.query(query);
			while(rs.next())
			{
				montoPrestamo = rs.getFloat("MontoTotalPrestamosOtorgados");
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
		return montoPrestamo;
	}
	
	public float filtroPorMontoCuotas(String fechaIni, String fechaFin) 
	{
		conexion=new conexion();
		String query = "select sum(Importe_M) as MontoTotalCuotasPagadas from Movimientos where IdTipoMovimiento_M = '3' and Estado_M = 1 and FechaMovimiento_M >=' " +fechaIni + "' and FechaMovimiento_M <= '" + fechaFin + "'";
		float montoCuotas = 0;
		try
		{
			conexion.Open();
			ResultSet rs = conexion.query(query);
			while(rs.next())
			{
				montoCuotas = rs.getFloat("MontoTotalCuotasPagadas");
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
		return montoCuotas;
	}
	 /* filtros para mostrar cuando se abre el jsp de adminformes */
	
	public float filtroPorMontoCuotasSF() 
	{
		conexion=new conexion();
		String query = "select sum(Importe_M) as MontoTotalCuotasPagadas from Movimientos where IdTipoMovimiento_M = '3' and Estado_M = 1";
		float montoCuotas = 0;
		try
		{
			conexion.Open();
			ResultSet rs = conexion.query(query);
			while(rs.next())
			{
				montoCuotas = rs.getFloat("MontoTotalCuotasPagadas");
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
		return montoCuotas;
	}
	
	public float filtroPorMontoPrestamosSF() 
	{
		conexion=new conexion();
		String query = "select sum(Importe_M) as MontoTotalPrestamosOtorgados from Movimientos where IdTipoMovimiento_M = '2' and Estado_M = 1";
		float montoPrestamo = 0;
		try
		{
			conexion.Open();
			ResultSet rs = conexion.query(query);
			while(rs.next())
			{
				montoPrestamo = rs.getFloat("MontoTotalPrestamosOtorgados");
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
		return montoPrestamo;
	}
	
	public int filtroPorMovimientosRealizadoSF()
	{
		conexion= new conexion();
		String query = "select count(NumMovimiento_M) as MovimientosRealizados from Movimientos where Estado_M = 1";
		int cont = 0;
		try
		{
			conexion.Open();
			ResultSet rs = conexion.query(query);
			while(rs.next())
			{
				cont = rs.getInt("MovimientosRealizados");
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
		return cont;
	}
	
	public int filtroCantUsuariosSF()
	{
		conexion= new conexion();
		String query = "select count(IdUsuario_U) as UsuariosRegistrados from Usuario where Estado_U = 1";
		int contU = 0;
		try
		{
			conexion.Open();
			ResultSet rs = conexion.query(query);
			while(rs.next())
			{
				contU = rs.getInt("UsuariosRegistrados");
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
		return contU;
	}
	
	public int filtroCantPrestamosSF()
	{
		conexion= new conexion();
		String query = "select count(NumPrestamo_P) as NumPrestamosOtorgados from Prestamos where  (Autorizado = 1 or Autorizado = 2) AND (Estado = 1 OR Estado = 2)";
		int contP = 0;
		try
		{
			conexion.Open();
			ResultSet rs = conexion.query(query);
			while(rs.next())
			{
				contP = rs.getInt("NumPrestamosOtorgados");
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
		return contP;
	}
	
}
