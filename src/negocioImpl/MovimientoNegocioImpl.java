package negocioImpl;

import java.util.List;

import daoImpl.MovimientosDAOImpl;
import entidades.Movimientos;
import negocio.IMovimientoNegocio;

public class MovimientoNegocioImpl implements IMovimientoNegocio{

	private MovimientosDAOImpl mDaoImp = new MovimientosDAOImpl();
	@Override
	public List<Movimientos> obtenerMovimientosPorUsuario(int idUsuario, int numCuenta) {
		
		return mDaoImp.obtenerMovimientosPorUsuario(idUsuario, numCuenta);
	}

}
