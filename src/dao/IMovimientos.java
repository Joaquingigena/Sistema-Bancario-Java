package dao;

import java.sql.Date;
import java.util.List;

import entidades.Movimientos;

public interface IMovimientos {

	public List<Movimientos> obtenerMovimientosPorUsuario(String Nombre);
	
	public List<Movimientos> getMovimientosPorCuenta(int codMovimiento);
	
	public boolean insertMovimientoPorUsuario(int numCtaOrigen, int numCtaDestino ,String Detalle, float importe, int tipoMov, boolean estado);
}
