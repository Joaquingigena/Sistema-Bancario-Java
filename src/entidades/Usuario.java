package entidades;

public class Usuario {
	private int IdUsuario_U;
	private Personas IdPersona_U;
	private String Usuario_U;
	private String Password_U;
	private Roles IdRoles_U;
	private Boolean Estado_U;
	
	public Usuario()
	{
		IdPersona_U = new Personas();
		IdRoles_U= new Roles();
	}
	public Usuario (int idUsuario, Personas idPersonas, String usuario, String Password, Roles idRoles, boolean estado)
	{
		this.IdUsuario_U=idUsuario;
		this.IdPersona_U=idPersonas;
		this.Usuario_U=usuario;
		this.Password_U=Password;
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
	public String getPassword_U() {
		return Password_U;
	}
	public void setPassword_U(String password_U) {
		Password_U = password_U;
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
				+ ", Password_U=" + Password_U + ", IdRoles_U=" + IdRoles_U + ", Estado_U=" + Estado_U + "]";
	}
	

}
