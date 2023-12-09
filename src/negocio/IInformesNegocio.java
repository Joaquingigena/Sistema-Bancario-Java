package negocio;

import java.util.List;

import entidades.Movimientos;
import entidades.Prestamos;

public interface IInformesNegocio {
	public List<Movimientos> listarMovimientos();
	
	public List<Movimientos> queryFiltro(String campo,String criterio,String filtro);
	
	public int filtroPorMovimientosRealizado(String fechaIni, String fechaFin);
	public float filtroPorMontoPrestamos(String fechaIni, String fechaFin);
	public float filtroPorMontoCuotas(String fechaIni, String fechaFin);
	
	/* filtros para mostrar cuando se abre el jsp de adminformes */
	
	public float filtroPorMontoPrestamosSF();
	public float filtroPorMontoCuotasSF();
	public int filtroPorMovimientosRealizadoSF();
	public int filtroCantUsuariosSF();
	public int filtroCantPrestamosSF();
}
