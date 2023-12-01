package dao;

import java.sql.Date;
import java.util.List;

import entidades.Movimientos;

public interface IMovimientos {

	public List<Movimientos> obtenerMovimientosPorUsuario(String Nombre);
	
	public List<Movimientos> getMovimientosPorCuenta(int codMovimiento);
	
	public boolean updateMovimientoPorUsuario(int numCta, Date fechaMov, String Detalle, float importe, int tipoMov, String estado);
}
