package dao;

import java.util.List;

import entidades.Prestamos;

public interface IPrestamos {
	public List<Prestamos> listarPrestamos();
	public boolean agregarPrestamo(String monto, int cuotas, int cuenta);
	
	public List<Prestamos> filtroAvanzado(String query);
}
