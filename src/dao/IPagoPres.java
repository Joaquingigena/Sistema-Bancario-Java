package dao;

import java.util.List;

import entidades.PagoCuotasPrestamo; ;

public interface IPagoPres {

	public List<PagoCuotasPrestamo> listarCuotas(int numPrestamo);
	
}
