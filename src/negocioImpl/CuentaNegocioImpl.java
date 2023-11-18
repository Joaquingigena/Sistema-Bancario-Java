package negocioImpl;

import java.util.List;


import daoImpl.CuentaDaoImpl;
import entidades.Cuenta;
import entidades.TipoCuentas;
import entidades.Usuario;
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
	@Override
	public boolean modificarCuenta(Cuenta cta) {
		
		return cuentaDaoImpl.modificate(cta);
	}
	@Override
	public Cuenta obtenerCuenta(int id) {
		
		return cuentaDaoImpl.obtenerCuenta(id);
	}
	
	@Override
	public List<TipoCuentas> ListarTipoCuentas() {
		return cuentaDaoImpl.listarTipoCuentas();
	}
	@Override
	public List<Cuenta> filtrarListaCuentas(String filtro) {
		// TODO Auto-generated method stub
		return cuentaDaoImpl.filtrarListaCuentas(filtro);
	}

}
