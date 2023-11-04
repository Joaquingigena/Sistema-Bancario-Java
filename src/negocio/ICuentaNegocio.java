package negocio;

import java.util.List;

import entidades.Cuenta;

public interface ICuentaNegocio {
	public List<Cuenta> ListarCuentas();
<<<<<<< HEAD
	
	public boolean altaCuenta(int idUsuario, int idTipoCta, int cbu, float saldo, String detalle, int tipoMovimiento);
	
	public int validarTotalCuentas(int idUsuario);
	
	public void logMovimientos(int cbu, String descripcion, float importe, int tipoMovimiento);
=======

	boolean eliminarCuenta(int id);
>>>>>>> f63fe2a4c960f7da03ea64f015a981aaf0cb238e
}
