package negocioImpl;

import java.util.List;


import daoImpl.CuentaDaoImpl;
import entidades.Cuenta;
import negocio.ICuentaNegocio;

public class CuentaNegocioImpl implements ICuentaNegocio {
	private CuentaDaoImpl cuentaDaoImpl = new CuentaDaoImpl();

	@Override
	public List<Cuenta> ListarCuentas() {
		return cuentaDaoImpl.listarCuentas();
	}
	@Override
	public boolean eliminarCuenta(int id) {
		
		
		return cuentaDaoImpl.eliminarCuenta(id);
	}

	@Override
	public boolean altaCuenta(int idUsuario, int idTipoCta, int cbu, float saldo, String detalle, int tipoMovimiento) {
		// TODO Auto-generated method stub
		return cuentaDaoImpl.altaCuenta(idUsuario, idTipoCta, cbu, saldo, detalle, tipoMovimiento);
	}

	@Override
	public int validarTotalCuentas(int idUsuario) {
		// TODO Auto-generated method stub
		return cuentaDaoImpl.validarTotalCuentas(idUsuario);
	}

	@Override
	public void logMovimientos(int cbu, String descripcion, float importe, int tipoMovimiento) {
		// TODO Auto-generated method stub
		cuentaDaoImpl.logMovimientos(cbu, descripcion, importe, tipoMovimiento);
	}

}
