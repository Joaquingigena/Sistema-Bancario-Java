package entidades;

import java.util.Date;

public class Movimientos {
	private int NumMovimiento_M;
	private Cuenta NumCuenta_M;
	private Date FechaMovimiento_M;
	private String Detalle_M;
	private float Importe_M;
	private TipoMovimientos IdTipoMovimiento_M;
	private String Estado_M;
	
	public Movimientos()
	{
		NumCuenta_M = new Cuenta();
		IdTipoMovimiento_M = new TipoMovimientos();
	}
	public Movimientos (int numMovimiento, Cuenta numCuenta, Date fechaMovimiento, String detalle,
			float importe, TipoMovimientos idTipoMovimiento, String estado)
	{
		this.NumMovimiento_M=numMovimiento;
		this.NumCuenta_M=numCuenta;
		this.FechaMovimiento_M=fechaMovimiento;
		this.Detalle_M=detalle;
		this.Importe_M=importe;
		this.IdTipoMovimiento_M=idTipoMovimiento;
		this.Estado_M=estado;
	}
	public int getNumMovimiento_M() {
		return NumMovimiento_M;
	}
	public void setNumMovimiento_M(int numMovimiento_M) {
		NumMovimiento_M = numMovimiento_M;
	}
	public Cuenta getNumCuenta_M() {
		return NumCuenta_M;
	}
	public void setNumCuenta_M(Cuenta numCuenta_M) {
		NumCuenta_M = numCuenta_M;
	}
	public Date getFechaMovimiento_M() {
		return FechaMovimiento_M;
	}
	public void setFechaMovimiento_M(Date fechaMovimiento_M) {
		FechaMovimiento_M = fechaMovimiento_M;
	}
	public String getDetalle_M() {
		return Detalle_M;
	}
	public void setDetalle_M(String detalle_M) {
		Detalle_M = detalle_M;
	}
	public float getImporte_M() {
		return Importe_M;
	}
	public void setImporte_M(float importe_M) {
		Importe_M = importe_M;
	}
	public TipoMovimientos getIdTipoMovimiento_M() {
		return IdTipoMovimiento_M;
	}
	public void setIdTipoMovimiento_M(TipoMovimientos idTipoMovimiento_M) {
		IdTipoMovimiento_M = idTipoMovimiento_M;
	}
	public String getEstado_M() {
		return Estado_M;
	}
	public void setEstado_M(String estado_M) {
		Estado_M = estado_M;
	}
	@Override
	public String toString() {
		return "Movimientos [NumMovimiento_M=" + NumMovimiento_M + ", NumCuenta_M=" + NumCuenta_M
				+ ", FechaMovimiento_M=" + FechaMovimiento_M + ", Detalle_M=" + Detalle_M + ", Importe_M=" + Importe_M
				+ ", IdTipoMovimiento_M=" + IdTipoMovimiento_M + ", Estado_M=" + Estado_M + "]";
	}
	

}
