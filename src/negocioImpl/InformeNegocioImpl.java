package negocioImpl;

import java.util.List;

import daoImpl.InformesDaoImpl;
import entidades.Movimientos;
import negocio.IInformesNegocio;

public class InformeNegocioImpl implements IInformesNegocio{
	private InformesDaoImpl informedao= new InformesDaoImpl();
	
	@Override
	public List<Movimientos> listarMovimientos() {
		
		return informedao.listarMovimientos();
	}

	@Override
	public List<Movimientos> queryFiltro(String campo, String criterio, String filtro) {
		

		String query= "select M.NumMovimiento_M, M.NumCuenta_M, M.FechaMovimiento_M, M.Detalle_M, M.Importe_M, M.IdTipoMovimiento_M, M.Estado_M from Movimientos as M inner join Cuenta C on C.NumCuenta_Cta = M.NumCuenta_M inner join TipoMovimientos TM on TM.IdTipoMovimiento_TM = M.IdTipoMovimiento_M and";
		try {
			
		if("movimiento".equals(campo)) {
			switch(criterio) {
			
			case "Contiene":
				
					query+= "M.numMovimiento_M LIKE '%" + filtro + "%'";
				break;
				
			case "Igual a":
				query+= "M.numMovimiento_M = " + filtro;
				break;
			
			}
			
		}
		else if("fecha".equals(campo)) {
			
			switch(criterio) {
			
			case "Mayor que":
				query+= "M.fechaMovimiento_M> '"+  filtro+"'";
				
				break;
			case "Menor que":
				query+= "M.fechaMovimiento_M < '" + filtro+"'";
				break;
			case "Igual a":
				
				query+= "M.fechaMovimiento_M = '" + filtro+"'";
				break;
			}
			
		}
		else {
			switch(criterio) {
			
			case "Mayor que":
				query+= "M.importe_M> " + filtro;
				break;
			case "Menor que":
				
				query+= "M.importe_M < " + filtro;
				break;
			case "Igual a":
				query+= "M.importe_M = " + filtro;
				break;
			}
		
		}
		System.out.println(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return informedao.filtroAvanzado(query);
	}
	
	public int filtroPorMovimientosRealizado(String fechaIni, String fechaFin) 
	{
		return informedao.filtroPorMovimientosRealizado(fechaIni, fechaFin);
	}
	
	public float filtroPorMontoPrestamos(String fechaIni, String fechaFin) 
	{
		return informedao.filtroPorMontoPrestamos(fechaIni, fechaFin);
	}
	
	public float filtroPorMontoCuotas(String fechaIni, String fechaFin) 
	{
		return informedao.filtroPorMontoCuotas(fechaIni, fechaFin);
	}
	
	/* filtros para mostrar cuando se abre el jsp de adminformes */
	
	public float filtroPorMontoPrestamosSF() 
	{
		return informedao.filtroPorMontoPrestamosSF();
	}
	
	public float filtroPorMontoCuotasSF() 
	{
		return informedao.filtroPorMontoCuotasSF();
	}
	
	public int filtroPorMovimientosRealizadoSF() 
	{
		return informedao.filtroPorMovimientosRealizadoSF();
	}
	public int filtroCantUsuariosSF() 
	{
		return informedao.filtroCantUsuariosSF();
	}
	public int filtroCantPrestamosSF()
	{
		return informedao.filtroCantPrestamosSF();
	}

}
