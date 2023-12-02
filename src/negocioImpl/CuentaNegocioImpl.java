package negocioImpl;

import java.util.ArrayList;
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
	@Override
	public List<Cuenta> queryFiltro(String campo, String criterio, String filtro) {
		
		String query= "Select C.NumCuenta_Cta,C.IdUsuario_Cta, C.FechaCreacion_Cta, C.IdTipoCuenta_Cta, C.CBU_Cta, C.Saldo_Cta FROM cuenta AS C inner join usuario U on U.IdUsuario_U = C.IdUsuario_Cta inner join TipoCuentas tc on tc.IdTipo_TC = C.IdTipoCuenta_Cta where Estado_Cta=true and ";
		try {
			
		if("usuario".equals(campo)) {
			switch(criterio) {
			
			case "Contiene":
				
					query+= "C.IdUsuario_Cta LIKE '%" + filtro + "%'";
				break;
				
			case "Igual a":
				query+= "C.IdUsuario_Cta = " + filtro;
				break;
			
			}
			
		}
		else if("fecha".equals(campo)) {
			
			switch(criterio) {
			
			case "Mayor que":
				query+= "C.FechaCreacion_Cta > '"+  filtro+"'";
				
				break;
			case "Menor que":
				query+= "C.FechaCreacion_Cta < '" + filtro+"'";
				break;
			case "Igual a":
				
				query+= "C.FechaCreacion_Cta = '" + filtro+"'";
				break;
			}
			
		}
		else {
			switch(criterio) {
			
			case "Mayor que":
				query+= "C.Saldo_Cta > " + filtro;
				break;
			case "Menor que":
				
				query+= "C.Saldo_Cta < " + filtro;
				break;
			case "Igual a":
				query+= "C.Saldo_Cta = " + filtro;
				break;
			}
		
		}
		System.out.println(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return cuentaDaoImpl.filtroAvanzado(query);
	}
	@Override
	public List<Cuenta> listarCuentasPorUsuario(String nombre) {
		// TODO Auto-generated method stub
		return cuentaDaoImpl.listarCuentasPorUsuario(nombre);
	}
	
	@Override
	public ArrayList<Cuenta> obtenerTodos() {
		return cuentaDaoImpl.obtenerTodos();
	}

	@Override
	public ArrayList<Cuenta> cuentasXPropietario(String nombre) {
		return cuentaDaoImpl.cuentasXPropietario(nombre);
	}
	@Override
	public int obtenerNumCuenta(int cbu) {
		// TODO Auto-generated method stub
		return cuentaDaoImpl.obtenerNumCuenta(cbu);
	}
	@Override
	public boolean validarSaldo(int numCtaOrigen, float importe) {
		// TODO Auto-generated method stub
		return  cuentaDaoImpl.validarSaldo(numCtaOrigen, importe);
	}

}
