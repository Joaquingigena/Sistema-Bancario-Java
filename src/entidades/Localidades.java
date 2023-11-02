package entidades;

public class Localidades {
	private int CodLocalidad_Loc;
	private int CodProvincia_Loc;
	private String Nombre_Loc;
	
	public Localidades()
	{
		
	}
	public Localidades(int codLocalidad, int codProvincia, String Nombre)
	{
		this.CodLocalidad_Loc=codLocalidad;
		this.CodProvincia_Loc=codProvincia;
		this.Nombre_Loc=Nombre;
	}
	public int getCodLocalidad_Loc() {
		return CodLocalidad_Loc;
	}
	public void setCodLocalidad_Loc(int codLocalidad_Loc) {
		CodLocalidad_Loc = codLocalidad_Loc;
	}
	public int getCodProvincia_Loc() {
		return CodProvincia_Loc;
	}
	public void setCodProvincia_Loc(int codProvincia_Loc) {
		CodProvincia_Loc = codProvincia_Loc;
	}
	public String getNombre_Loc() {
		return Nombre_Loc;
	}
	public void setNombre_Loc(String nombre_Loc) {
		Nombre_Loc = nombre_Loc;
	}
	@Override
	public String toString() {
		return Nombre_Loc;
	}
	

}
