package negocioImpl;

import java.util.List;


import daoImpl.PrestamosDaoImpl;
import entidades.Prestamos;
import negocio.IPrestamosNegocio;

public class PrestamosNegocioImpl implements IPrestamosNegocio{
	
	private PrestamosDaoImpl preDao = new PrestamosDaoImpl();
	
	public List<Prestamos> listarPrestamos(){
		return preDao.listarPrestamos();
	}
}
