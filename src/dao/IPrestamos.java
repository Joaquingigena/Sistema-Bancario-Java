package dao;

import java.util.List;

import entidades.Cuotas;
import entidades.Prestamos;

public interface IPrestamos {
	public List<Prestamos> listarPrestamos();
	public boolean agregarPrestamo(String monto, int cuotas, int cuenta);
	
	public List<Prestamos> filtroAvanzado(String query);
	List<Cuotas> listarCuotas();
	
	public boolean insertPrestamo(int numCtaOrigen, int idUsuario, float importePrestamo, float importe, String plazo, int cuotas, boolean estado, boolean autorizado);
	
	public boolean validarPrestamo(int numCuenta);
	
	public boolean rechazarPrestamo(int numPrestamo,int numCuenta, int idUsuario, float importe);
	public boolean aceptarPrestamo(int numPrestamo,int numCuenta, int idUsuario, float importe);
}
