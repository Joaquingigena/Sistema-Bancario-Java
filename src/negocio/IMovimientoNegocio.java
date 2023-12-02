package negocio;

import java.util.List;

import entidades.Movimientos;

public interface IMovimientoNegocio {


	public List<Movimientos> obtenerMovimientosPorUsuario(String nombre);
	
	public List<Movimientos> getMovimientosPorCuenta(int codMovimiento);
	
	public boolean insertMovimientoPorUsuario(int numCtaOrigen, int numCtaDestino , String Detalle, float importe, int tipoMov, boolean estado);
}
