package entidades;

public class Usuario {
	private int IdUsuario_U;
	private Personas IdPersona_U;
	private String Usuario_U;
	private String Contrase�a_U;
	private Roles IdRoles_U;
	private Boolean Estado_U;
	
	public Usuario()
	{
		IdPersona_U = new Personas();
		IdRoles_U= new Roles();
	}
	public Usuario (int idUsuario, Personas idPersonas, String usuario, String contrase�a, Roles idRoles, boolean estado)
	{
		this.IdUsuario_U=idUsuario;
		this.IdPersona_U=idPersonas;
		this.Usuario_U=usuario;
		this.Contrase�a_U=contrase�a;
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
	public String getContrase�a_U() {
		return Contrase�a_U;
	}
	public void setContrase�a_U(String contrase�a_U) {
		Contrase�a_U = contrase�a_U;
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
				+ ", Contrase�a_U=" + Contrase�a_U + ", IdRoles_U=" + IdRoles_U + ", Estado_U=" + Estado_U + "]";
	}
	

}
