package entidades;

public class TipoCuentas {
	private int idTipo_TC;
	private String Descripcion_TC;
	
	public TipoCuentas()
	{
		
	}
	public TipoCuentas(int idTipo, String Descripcion)
	{
		this.idTipo_TC=idTipo;
		this.Descripcion_TC=Descripcion;
	}
	public int getIdTipo_TC() {
		return idTipo_TC;
	}
	public void setIdTipo_TC(int idTipo_TC) {
		this.idTipo_TC = idTipo_TC;
	}
	public String getDescripcion_TC() {
		return Descripcion_TC;
	}
	public void setDescripcion_TC(String descripcion_TC) {
		Descripcion_TC = descripcion_TC;
	}
	@Override
	public String toString() {
		return "TipoCuentas [idTipo_TC=" + idTipo_TC + ", Descripcion_TC=" + Descripcion_TC + "]";
	}
	

}
