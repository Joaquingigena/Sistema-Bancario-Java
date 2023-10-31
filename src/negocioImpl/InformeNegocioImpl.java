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

}
