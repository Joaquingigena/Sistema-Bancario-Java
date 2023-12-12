package dao;

import java.sql.Date;
import java.util.List;

import entidades.Movimientos;

public interface IMovimientos {

	public List<Movimientos> obtenerMovimientosPorUsuario(String Nombre);
	
	public List<Movimientos> getMovimientosPorCuenta(int codMovimiento);
	
	public boolean insertMovimientoPorUsuario(int numCtaOrigen, int numCtaDestino ,String Detalle, float importe, int tipoMov, boolean estado);
	
	public List<Movimientos> filtroFechaPorCuenta (String fechaIni, String fechaFin, int numCuenta);
	
	public List<Movimientos> filtroFechaPorUsuario(String fechaIni, String fechaFin, String Nombre);
}
