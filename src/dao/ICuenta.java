package dao;

import java.util.List;

import entidades.Cuenta;

public interface ICuenta {

	public List<Cuenta> listarCuentas();

	boolean eliminarCuenta(int id);
	
	public boolean altaCuenta(int idUsuario, int idTipoCta, int cbu, float saldo, String detalle, int tipoMovimiento);
	
	public int validarTotalCuentas(int idUsuario);
	
	public void logMovimientos(int cbu, String descripcion, float importe, int tipoMovimiento);
}
