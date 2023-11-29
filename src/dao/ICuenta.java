package dao;

import java.util.ArrayList;
import java.util.List;

import entidades.Cuenta;
import entidades.TipoCuentas;

public interface ICuenta {

	public List<Cuenta> listarCuentas();

	boolean eliminarCuenta(int id);
	
	public boolean altaCuenta(int idUsuario, int idTipoCta, int cbu, float saldo, String detalle, int tipoMovimiento);
	
	public int validarTotalCuentas(int idUsuario);
	
	public void logMovimientos(int cbu, String descripcion, float importe, int tipoMovimiento);

	boolean modificarCuenta(Cuenta Cta);

	Cuenta obtenerCuenta(int id);

	boolean modificate(Cuenta cuenta);

	public List<TipoCuentas> listarTipoCuentas();
	
	public List<Cuenta> filtrarListaCuentas(String filtro);
	
	public List<Cuenta> filtroAvanzado(String query);
	
	public List<Cuenta> listarCuentasPorUsuario(String nombre);

	ArrayList<Cuenta> obtenerTodos();

	ArrayList<Cuenta> cuentasXPropietario(String nombre);
}
