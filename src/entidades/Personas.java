package entidades;

import java.util.Date;

public class Personas {
	private int IdPersona_P;
	private String DNI_P;
	private Localidades CodLocalidad_P;
	private Provincias CodProvincia_P;
	private String CUIL_P;
	private String Nombre_P;
	private String Apellido_P;
	private String Sexo_P;
	private String Nacionalidad_P;
	private Date FechaNac_P;
	private String Direccion_P;
	private String Correo_P;
	private String Telefono_P;
	private int Solicitud_P;
	
	public Personas()
	{
		CodLocalidad_P = new Localidades();
		CodProvincia_P = new Provincias();
	}
	public Personas (int idPersona, String DNI, Localidades CodLocalidad, Provincias CodProvincia, String CUIL, 
			String nombre, String apellido, String sexo, String nacionalidad, Date FechaNac, String direccion,
			String Correo, String Telefono, int Solicitud)
	{
		this.IdPersona_P=idPersona;
		this.DNI_P=DNI;
		this.CodLocalidad_P=CodLocalidad;
		this.CodProvincia_P=CodProvincia;
		this.CUIL_P=CUIL;
		this.Nombre_P=nombre;
		this.Apellido_P=apellido;
		this.Sexo_P=sexo;
		this.Nacionalidad_P=nacionalidad;
		this.FechaNac_P=FechaNac;
		this.Direccion_P=direccion;
		this.Correo_P=Correo;
		this.Telefono_P=Telefono;
		this.Solicitud_P = Solicitud;
		
	}
	public int getIdPersona_P() {
		return IdPersona_P;
	}
	public void setIdPersona_P(int idPersona_P) {
		IdPersona_P = idPersona_P;
	}
	public String getDNI_P() {
		return DNI_P;
	}
	public void setDNI_P(String dNI_P) {
		DNI_P = dNI_P;
	}
	public Localidades getCodLocalidad_P() {
		return CodLocalidad_P;
	}
	public void setCodLocalidad_P(Localidades codLocalidad_P) {
		CodLocalidad_P = codLocalidad_P;
	}
	public Provincias getCodProvincia_P() {
		return CodProvincia_P;
	}
	public void setCodProvincia_P(Provincias codProvincia_P) {
		CodProvincia_P = codProvincia_P;
	}
	public String getCUIL_P() {
		return CUIL_P;
	}
	public void setCUIL_P(String cUIL_P) {
		CUIL_P = cUIL_P;
	}
	public String getNombre_P() {
		return Nombre_P;
	}
	public void setNombre_P(String nombre_P) {
		Nombre_P = nombre_P;
	}
	public String getApellido_P() {
		return Apellido_P;
	}
	public void setApellido_P(String apellido_P) {
		Apellido_P = apellido_P;
	}
	public String getSexo_P() {
		return Sexo_P;
	}
	public void setSexo_P(String sexo_P) {
		Sexo_P = sexo_P;
	}
	public String getNacionalidad_P() {
		return Nacionalidad_P;
	}
	public void setNacionalidad_P(String nacionalidad_P) {
		Nacionalidad_P = nacionalidad_P;
	}
	public Date getFechaNac_P() {
		return FechaNac_P;
	}
	public void setFechaNac_P(Date fechaNac_P) {
		FechaNac_P = fechaNac_P;
	}
	public String getDireccion_P() {
		return Direccion_P;
	}
	public void setDireccion_P(String direccion_P) {
		Direccion_P = direccion_P;
	}
	public String getCorreo_P() {
		return Correo_P;
	}
	public void setCorreo_P(String correo_P) {
		Correo_P = correo_P;
	}
	public String getTelefono_P() {
		return Telefono_P;
	}
	public void setTelefono_P(String telefono_P) {
		Telefono_P = telefono_P;
	}
	
	public int getSolicitud_P() {
		return Solicitud_P;
	}
	public void setSolicitud_P(int solicitud_P) {
		Solicitud_P = solicitud_P;
	}
	@Override
	public String toString() {
		return "Personas [IdPersona_P=" + IdPersona_P + ", DNI_P=" + DNI_P + ", CodLocalidad_P=" + CodLocalidad_P
				+ ", CodProvincia_P=" + CodProvincia_P + ", CUIL_P=" + CUIL_P + ", Nombre_P=" + Nombre_P
				+ ", Apellido_P=" + Apellido_P + ", Sexo_P=" + Sexo_P + ", Nacionalidad_P=" + Nacionalidad_P
				+ ", FechaNac_P=" + FechaNac_P + ", Direccion_P=" + Direccion_P + ", Correo_P=" + Correo_P
				+ ", Telefono_P=" + Telefono_P + ", Solicitud=" + Solicitud_P + "]";
	}
	
	
	
	

}
