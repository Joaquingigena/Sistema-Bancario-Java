package dao;

import java.util.List;

import entidades.Cuotas;
import entidades.Prestamos;

public interface IPrestamos {
	public List<Prestamos> listarPrestamos();
	public boolean agregarPrestamo(String monto, int cuotas, int cuenta);
	
	public List<Prestamos> filtroAvanzado(String query);
	List<Cuotas> listarCuotas();
	
	public boolean validarPrestamo(int numCuenta);
	boolean altaPrestamo(int numPrestamo);
	public boolean deletePrestamo(int numPrestamo);
}
