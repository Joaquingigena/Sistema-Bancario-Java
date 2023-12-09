package dao;

import java.util.List;

import entidades.Movimientos;
import entidades.Prestamos;

public interface IInformes {
	public List<Movimientos> listarMovimientos();
	
	public List<Movimientos> filtroAvanzado(String query);
	
	public int filtroPorMovimientosRealizado(String fechaIni, String fechaFin);
	public float filtroPorMontoPrestamos(String fechaIni, String fechaFin) ;
	public float filtroPorMontoCuotas(String fechaIni, String fechaFin) ;
	
	 /* filtros para mostrar cuando se abre el jsp de adminformes */
	public float filtroPorMontoCuotasSF();
	public float filtroPorMontoPrestamosSF();
	public int filtroPorMovimientosRealizadoSF();
	public int filtroCantUsuariosSF();
	public int filtroCantPrestamosSF();

}
