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
		
		String query= "SELECT P.NumPrestamo_P,P.NumCuenta_P, P.ImportePagar_P, P.ImportePedido_P, P.PlazoPago, C.IdUsuario_Cta,P.Estado FROM prestamos as P INNER JOIN cuenta C on P.NumCuenta_P= C.NumCuenta_Cta where ";
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
	
	@Override
	public boolean insertPrestamo(int numCtaOrigen, int idUsuario, float importePrestamo, float importe, String plazo, int cuotas, boolean estado, boolean autorizado) {
		// TODO Auto-generated method stub
		return preDao.insertPrestamo(numCtaOrigen, idUsuario, importePrestamo, importe, plazo, cuotas, estado, autorizado);
	}
	
	public boolean rechazarPrestamo(int numPrestamo,int numCuenta, int idUsuario, float importe) {
		return preDao.rechazarPrestamo(numPrestamo,numCuenta, idUsuario, importe);
	}
	
	public boolean aceptarPrestamo(int numPrestamo,int numCuenta, int idUsuario, float importe) {
		return preDao.aceptarPrestamo(numPrestamo,numCuenta, idUsuario, importe);
	}

	@Override
	public List<Prestamos> listarPrestamos(int idUsuario) {
	
		return preDao.listarPrestamos(idUsuario);
	}
	
	
}
