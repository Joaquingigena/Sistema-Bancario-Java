package negocioImpl;

import java.util.List;

import daoImpl.MovimientosDAOImpl;
import entidades.Movimientos;
import negocio.IMovimientoNegocio;

public class MovimientoNegocioImpl implements IMovimientoNegocio{

	private MovimientosDAOImpl mDaoImp = new MovimientosDAOImpl();
	@Override
	public List<Movimientos> obtenerMovimientosPorUsuario(String nombre) {
		
		return mDaoImp.obtenerMovimientosPorUsuario(nombre);
	}
	@Override
	public List<Movimientos> getMovimientosPorCuenta(int codMovimiento) {
		// TODO Auto-generated method stub
		return mDaoImp.getMovimientosPorCuenta(codMovimiento);
	}
	@Override
	public boolean insertMovimientoPorUsuario(int numCtaOrigen, int numCtaDestino, String Detalle, float importe,
			int tipoMov, boolean estado) {
		// TODO Auto-generated method stub
		return mDaoImp.insertMovimientoPorUsuario(numCtaOrigen, numCtaDestino , Detalle, importe, tipoMov, estado);
	}

}
