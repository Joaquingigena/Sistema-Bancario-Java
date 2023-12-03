package negocio;

import java.util.List;

import entidades.Cuenta;
import entidades.Prestamos;

public interface IPrestamosNegocio {
	public List<Prestamos> listarPrestamos();
	
	public boolean agregarPrestamo(String monto, int cuotas, int cuenta);
	
	public List<Prestamos> queryFiltro(String campo,String criterio,String filtro);
	
	/*public boolean validarPrestamo(int numCuenta);

	boolean insertPrestamo(int numCtaOrigen, float importePrestamo, float importe, int cuotas, boolean estado);
	public boolean altaPrestamo(int numPrestamo);*/
}
