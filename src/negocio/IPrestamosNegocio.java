package negocio;

import java.util.List;

import entidades.Cuenta;
import entidades.Prestamos;

public interface IPrestamosNegocio {
	public List<Prestamos> listarPrestamos();
	
	public boolean agregarPrestamo(String monto, int cuotas, int cuenta);
	
	public List<Prestamos> queryFiltro(String campo,String criterio,String filtro);
	
	public boolean validarPrestamo(int numCuenta);

	public boolean insertPrestamo(int numCtaOrigen, int idUsuario, float importePrestamo, float importe, String plazo, int cuotas, boolean estado, boolean autorizado);

	public boolean rechazarPrestamo(int numPrestamo,int numCuenta, int idUsuario, float importe);
	
	public boolean aceptarPrestamo(int numPrestamo,int numCuenta, int idUsuario, float importe);
}
