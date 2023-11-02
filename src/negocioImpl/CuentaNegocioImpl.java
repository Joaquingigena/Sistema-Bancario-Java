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

}
