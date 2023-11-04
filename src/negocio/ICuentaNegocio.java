package negocio;

import java.util.List;

import entidades.Cuenta;

public interface ICuentaNegocio {
	public List<Cuenta> ListarCuentas();

	boolean eliminarCuenta(int id);
}
