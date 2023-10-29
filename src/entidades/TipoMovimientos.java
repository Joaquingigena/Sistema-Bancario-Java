package entidades;

public class TipoMovimientos {
	private int idTipoMovimiento_TM;
	private String Descripcion_TM;
	
	public TipoMovimientos()
	{
		
	}
	public TipoMovimientos(int idTipoMovimiento, String Descripcion)
	{
		this.idTipoMovimiento_TM=idTipoMovimiento;
		this.Descripcion_TM=Descripcion;
	}
	public int getIdTipoMovimiento_TM() {
		return idTipoMovimiento_TM;
	}
	public void setIdTipoMovimiento_TM(int idTipoMovimiento_TM) {
		this.idTipoMovimiento_TM = idTipoMovimiento_TM;
	}
	public String getDescripcion_TM() {
		return Descripcion_TM;
	}
	public void setDescripcion_TM(String descripcion_TM) {
		Descripcion_TM = descripcion_TM;
	}
	@Override
	public String toString() {
		return "TipoMovimientos [idTipoMovimiento_TM=" + idTipoMovimiento_TM + ", Descripcion_TM=" + Descripcion_TM
				+ "]";
	}
	

}
