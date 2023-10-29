package entidades;

public class Cuotas {
	private int IdCuota_C;
	private String CantidadCuota_C;
	
	public Cuotas()
	{
		
	}
	public Cuotas(int idCuota, String CantidadCuota)
	{
		this.IdCuota_C=idCuota;
		this.CantidadCuota_C=CantidadCuota;
	}
	public int getIdCuota_C() {
		return IdCuota_C;
	}
	public void setIdCuota_C(int idCuota_C) {
		IdCuota_C = idCuota_C;
	}
	public String getCantidadCuota_C() {
		return CantidadCuota_C;
	}
	public void setCantidadCuota_C(String cantidadCuota_C) {
		CantidadCuota_C = cantidadCuota_C;
	}
	@Override
	public String toString() {
		return "Cuotas [IdCuota_C=" + IdCuota_C + ", CantidadCuota_C=" + CantidadCuota_C + "]";
	}
	

}
