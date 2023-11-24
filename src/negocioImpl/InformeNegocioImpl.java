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
		

		String query= "select M.numMovimiento_M, M.numCuenta_M, M.fechaMovimiento_M, M.detalle_M, M.importe_M, M.idTipoMovimiento_M, M.estado_M from Movimientos as M inner join Cuenta C on C.numCuenta_Cta = M.numCuenta_M inner join TipoMovimientos TM on TM.idTipoMovimiento_TM = M.idTipoMovimiento_M and ";
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

}
