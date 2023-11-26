package negocio;

import java.util.List;

import entidades.Movimientos;

public interface IMovimientoNegocio {


	public List<Movimientos> obtenerMovimientosPorUsuario(String nombre);
	
	public List<Movimientos> getMovimientosPorCuenta(int codMovimiento);
}
