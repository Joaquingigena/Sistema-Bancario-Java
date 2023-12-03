package negocioImpl;

import java.util.List;


import daoImpl.PrestamosDaoImpl;
import entidades.Prestamos;
import entidades.Cuotas;
import negocio.IPrestamosNegocio;

public class PrestamosNegocioImpl implements IPrestamosNegocio{
	
	private PrestamosDaoImpl preDao = new PrestamosDaoImpl();
	
	public List<Prestamos> listarPrestamos(){
		return preDao.listarPrestamos();
	}

	@Override
	public List<Prestamos> queryFiltro(String campo, String criterio, String filtro) {
		
		String query= "SELECT P.NumPrestamo_P,P.NumCuenta_P, P.ImportePagar_P, P.ImportePedido_P, P.PlazoPago, C.NumCuenta_Cta FROM prestamos as P INNER JOIN cuenta C on P.NumCuenta_P = C.NumCuenta_Cta and ";
		try {
			
		if("cuenta".equals(campo)) {
			switch(criterio) {
			
			case "Contiene":
				
					query+= "P.NumCuenta_P LIKE '%" + filtro + "%'";
				break;
				
			case "Igual a":
				query+= "P.NumCuenta_P = " + filtro;
				break;
			
			}
			
		}
		else if("importe".equals(campo)) {
			
			switch(criterio) {
			
			case "Mayor que":
				query+= "P.ImportePagar_P > "+  filtro;
				
				break;
			case "Menor que":
				query+= "P.ImportePagar_P < " + filtro;
				break;
			case "Igual a":
				
				query+= "P.ImportePagar_P = " + filtro;
				break;
			}
			
		}
		else {
			switch(criterio) {
			
			case "Mayor que":
				query+= "P.PlazoPago > " + filtro;
				break;
			case "Menor que":
				
				query+= "P.PlazoPago < " + filtro;
				break;
			case "Igual a":
				query+= "P.PlazoPago = " + filtro;
				break;
			}
		
		}
		System.out.println(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return preDao.filtroAvanzado(query);
	}

	@Override
	public boolean agregarPrestamo(String monto, int cuotas, int cuenta) {
		preDao.agregarPrestamo( monto, cuotas, cuenta);
		return false;
	}
	
	public List<Cuotas> listarCuotas(){
		return preDao.listarCuotas();
	}
	public boolean validarPrestamo(int numCuenta)
	{
		return preDao.validarPrestamo(numCuenta);
	}
	/*
	@Override
	public boolean insertPrestamo(int numCtaOrigen, float importePrestamo, float importe, int cuotas, boolean estado) {
		// TODO Auto-generated method stub
		return preDao.insertPrestamo(numCtaOrigen, importePrestamo, importe, cuotas, estado);
	}
	
	public boolean altaPrestamo(int numPrestamo) {
		// TODO Auto-generated method stub
		return preDao.altaPrestamo(numPrestamo);
	}
	public boolean deletePrestamo(int numPrestamo) {
		// TODO Auto-generated method stub
		return preDao.deletePrestamo(numPrestamo);
	}*/
}
