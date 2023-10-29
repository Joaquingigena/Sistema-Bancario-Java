package entidades;

public class Usuario {
	private int IdUsuario_U;
	private Personas IdPersona_U;
	private String Usuario_U;
	private String Contraseña_U;
	private Roles IdRoles_U;
	private Boolean Estado_U;
	
	public Usuario()
	{
		IdPersona_U = new Personas();
		IdRoles_U= new Roles();
	}
	public Usuario (int idUsuario, Personas idPersonas, String usuario, String contraseña, Roles idRoles, boolean estado)
	{
		this.IdUsuario_U=idUsuario;
		this.IdPersona_U=idPersonas;
		this.Usuario_U=usuario;
		this.Contraseña_U=contraseña;
		this.IdRoles_U=idRoles;
		this.Estado_U=estado;
		
	}
	public int getIdUsuario_U() {
		return IdUsuario_U;
	}
	public void setIdUsuario_U(int idUsuario_U) {
		IdUsuario_U = idUsuario_U;
	}
	public Personas getIdPersona_U() {
		return IdPersona_U;
	}
	public void setIdPersona_U(Personas idPersona_U) {
		IdPersona_U = idPersona_U;
	}
	public String getUsuario_U() {
		return Usuario_U;
	}
	public void setUsuario_U(String usuario_U) {
		Usuario_U = usuario_U;
	}
	public String getContraseña_U() {
		return Contraseña_U;
	}
	public void setContraseña_U(String contraseña_U) {
		Contraseña_U = contraseña_U;
	}
	public Roles getIdRoles_U() {
		return IdRoles_U;
	}
	public void setIdRoles_U(Roles idRoles_U) {
		IdRoles_U = idRoles_U;
	}
	public Boolean getEstado_U() {
		return Estado_U;
	}
	public void setEstado_U(Boolean estado_U) {
		Estado_U = estado_U;
	}
	@Override
	public String toString() {
		return "Usuario [IdUsuario_U=" + IdUsuario_U + ", IdPersona_U=" + IdPersona_U + ", Usuario_U=" + Usuario_U
				+ ", Contraseña_U=" + Contraseña_U + ", IdRoles_U=" + IdRoles_U + ", Estado_U=" + Estado_U + "]";
	}
	

}
