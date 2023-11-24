package negocio;

import java.util.List;

import entidades.Movimientos;
import entidades.Prestamos;

public interface IInformesNegocio {
	public List<Movimientos> listarMovimientos();
	
	public List<Movimientos> queryFiltro(String campo,String criterio,String filtro);
}
