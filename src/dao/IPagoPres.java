package dao;

import java.util.List;

import entidades.PagoCuotasPrestamo; 

public interface IPagoPres {

	public List<PagoCuotasPrestamo> listarCuotas(int numPrestamo);

	public PagoCuotasPrestamo getPagoPorCuenta(int numCuenta);
	
	public boolean pagoCuota(int codPago, int numPrestamo, int numCuenta, int numCuota, float monto);
	
}
