package negocio;

import java.util.List;

import entidades.Cuenta;
import entidades.TipoCuentas;

public interface ICuentaNegocio {
	public List<Cuenta> ListarCuentas();
	
	public boolean altaCuenta(int idUsuario, int idTipoCta, int cbu, float saldo, String detalle, int tipoMovimiento);
	
	public int validarTotalCuentas(int idUsuario);
	
	public void logMovimientos(int cbu, String descripcion, float importe, int tipoMovimiento);

	boolean eliminarCuenta(int id);

	boolean modificarCuenta(Cuenta cta);

	Cuenta obtenerCuenta(int id);

	List<TipoCuentas> ListarTipoCuentas();
	
	public List<Cuenta> filtrarListaCuentas(String filtro);

}
