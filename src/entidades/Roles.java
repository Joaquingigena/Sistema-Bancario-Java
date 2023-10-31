package entidades;

public class Roles {
	public int getIdRoles_R() {
		return IdRoles_R;
	}
	
	public Roles()
	{
		
	}
	public Roles (int id, String rol)
	{
		this.IdRoles_R=id;
		this.Rol_R=rol;
	}
	
	public void setIdRoles_R(int idRoles_R) {
		IdRoles_R = idRoles_R;
	}
	
	public int getIdRol() {
		return IdRoles_R;
	}
	
	public String getRol_R() {
		return Rol_R;
	}
	public void setRol_R(String rol_R) {
		Rol_R = rol_R;
	}
	private int IdRoles_R;
	private String Rol_R;
	
	@Override
	public String toString() {
		return "Roles [IdRoles_R=" + IdRoles_R + ", Rol_R=" + Rol_R + "]";
	}
	

}
