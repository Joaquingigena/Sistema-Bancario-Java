package dao;

import java.util.List;

import entidades.Movimientos;
import entidades.Prestamos;

public interface IInformes {
	public List<Movimientos> listarMovimientos();
	
	public List<Movimientos> filtroAvanzado(String query);

}
