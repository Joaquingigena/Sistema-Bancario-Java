package entidades;

import java.util.Date;

public class Cuenta {
	private int NumCuenta_Cta;
	private Usuario IdUsuario_Cta;
	private Date FechaCreacion_Cta;
	private int CBU_Cta;
	private float Saldo_Cta;
	
	public Cuenta()
	{
		IdUsuario_Cta=new Usuario();
	}
	public Cuenta (int numCuenta, Usuario idUsuario, Date FechaCreacion, int CBU, float Saldo)
	{
		this.NumCuenta_Cta=numCuenta;
		this.IdUsuario_Cta=idUsuario;
		this.FechaCreacion_Cta=FechaCreacion;
		this.CBU_Cta=CBU;
		this.Saldo_Cta=Saldo;
	}
	public int getNumCuenta_Cta() {
		return NumCuenta_Cta;
	}
	public void setNumCuenta_Cta(int numCuenta_Cta) {
		NumCuenta_Cta = numCuenta_Cta;
	}
	public Usuario getIdUsuario_Cta() {
		return IdUsuario_Cta;
	}
	public void setIdUsuario_Cta(Usuario idUsuario_Cta) {
		IdUsuario_Cta = idUsuario_Cta;
	}
	public Date getFechaCreacion_Cta() {
		return FechaCreacion_Cta;
	}
	public void setFechaCreacion_Cta(Date fechaCreacion_Cta) {
		FechaCreacion_Cta = fechaCreacion_Cta;
	}
	public int getCBU_Cta() {
		return CBU_Cta;
	}
	public void setCBU_Cta(int cBU_Cta) {
		CBU_Cta = cBU_Cta;
	}
	public float getSaldo_Cta() {
		return Saldo_Cta;
	}
	public void setSaldo_Cta(float saldo_Cta) {
		Saldo_Cta = saldo_Cta;
	}
	@Override
	public String toString() {
		return "Cuenta [NumCuenta_Cta=" + NumCuenta_Cta + ", IdUsuario_Cta=" + IdUsuario_Cta + ", FechaCreacion_Cta="
				+ FechaCreacion_Cta + ", CBU_Cta=" + CBU_Cta + ", Saldo_Cta=" + Saldo_Cta + "]";
	}
	

}
