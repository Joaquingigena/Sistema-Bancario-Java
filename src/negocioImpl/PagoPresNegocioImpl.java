package negocioImpl;

import java.util.List;

import daoImpl.PagoPresDAOImpl;
import entidades.PagoCuotasPrestamo;
import negocio.IPagoPresNegocio;

public class PagoPresNegocioImpl implements IPagoPresNegocio{
	private PagoPresDAOImpl pagDao = new PagoPresDAOImpl();

	@Override
	public List<PagoCuotasPrestamo> listarCuotas(int numPrestamo) {
		 pagDao.listarCuotas(numPrestamo);
		return null;
	}
	
	@Override
	public PagoCuotasPrestamo getPagoPorCuenta(int numCuenta) {
		return pagDao.getPagoPorCuenta(numCuenta);
		
	}
	
	@Override
	public boolean pagoCuota(int codPago, int numPrestamo, int numCuenta, int numCuota, float monto) {
		return pagDao.pagoCuota(codPago,numPrestamo,numCuenta,numCuota,monto);
	}
 
	
}
