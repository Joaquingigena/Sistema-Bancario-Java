package entidades;

public class Provincias {
	private int CodProvincia_Prov;
	private String Nombre_Prov;
	
	public Provincias()
	{
		
	}
	public Provincias (int codProvincia, String Nombre)
	{
		this.CodProvincia_Prov=codProvincia;
		this.Nombre_Prov=Nombre;
	}
	public int getCodProvincia_Prov() {
		return CodProvincia_Prov;
	}
	public void setCodProvincia_Prov(int codProvincia_Prov) {
		CodProvincia_Prov = codProvincia_Prov;
	}
	public String getNombre_Prov() {
		return Nombre_Prov;
	}
	public void setNombre_Prov(String nombre_Prov) {
		Nombre_Prov = nombre_Prov;
	}
	@Override
	public String toString() {
		return Nombre_Prov;
	}
	

}
