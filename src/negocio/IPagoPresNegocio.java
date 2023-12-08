package negocio;

import java.util.List;

import entidades.PagoCuotasPrestamo;

public interface IPagoPresNegocio {

	public List<PagoCuotasPrestamo> listarCuotas(int numPrestamo);

	PagoCuotasPrestamo getPagoPorCuenta(int numCuenta);
	public boolean pagoCuota(int codPago, int numPrestamo, int numCuenta, int numCuota, float monto);

	
}
