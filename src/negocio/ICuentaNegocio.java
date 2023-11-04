package negocio;

import java.util.List;

import entidades.Cuenta;

public interface ICuentaNegocio {
	public List<Cuenta> ListarCuentas();
	
	public boolean altaCuenta(int idUsuario, int idTipoCta, int cbu, float saldo, String detalle, int tipoMovimiento);
	
	public int validarTotalCuentas(int idUsuario);
	
	public void logMovimientos(int cbu, String descripcion, float importe, int tipoMovimiento);
}
