package negocio;

import java.util.List;

import entidades.PagoCuotasPrestamo;

public interface IPagoPresNegocio {

	public List<PagoCuotasPrestamo> listarCuotas(int numPrestamo);

	
}
