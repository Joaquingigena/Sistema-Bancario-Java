package entidades;

import java.util.Date;

public class PagoCuotasPrestamo {
	private int CodPago_PCP;
	private Prestamos NumPrestamo_PCP;
	private Cuenta NumCuenta_PCP;
	private int NumCuota_PCP;
	private float MontoPagoMes_PCP;
	private Date FechaPago_PCP;
	private boolean Estado_PCP;
	
	public PagoCuotasPrestamo()
	{
		NumPrestamo_PCP = new Prestamos();
		NumCuenta_PCP = new Cuenta();
	}
	public PagoCuotasPrestamo (int codPago, Prestamos numPrestamo, Cuenta numCuenta, int numCuota,
			float montoPagoMes, Date fechaPago, boolean estado)
	{
		this.CodPago_PCP=codPago;
		this.NumPrestamo_PCP=numPrestamo;
		this.NumCuenta_PCP=numCuenta;
		this.NumCuota_PCP=numCuota;
		this.MontoPagoMes_PCP=montoPagoMes;
		this.FechaPago_PCP=fechaPago;
		this.Estado_PCP=estado;
	}
	public int getCodPago_PCP() {
		return CodPago_PCP;
	}
	public void setCodPago_PCP(int codPago_PCP) {
		CodPago_PCP = codPago_PCP;
	}
	public Prestamos getNumPrestamo_PCP() {
		return NumPrestamo_PCP;
	}
	public void setNumPrestamo_PCP(Prestamos numPrestamo_PCP) {
		NumPrestamo_PCP = numPrestamo_PCP;
	}
	public Cuenta getNumCuenta_PCP() {
		return NumCuenta_PCP;
	}
	public void setNumCuenta_PCP(Cuenta numCuenta_PCP) {
		NumCuenta_PCP = numCuenta_PCP;
	}
	public int getNumCuota_PCP() {
		return NumCuota_PCP;
	}
	public void setNumCuota_PCP(int numCuota_PCP) {
		NumCuota_PCP = numCuota_PCP;
	}
	public float getMontoPagoMes_PCP() {
		return MontoPagoMes_PCP;
	}
	public void setMontoPagoMes_PCP(float montoPagoMes_PCP) {
		MontoPagoMes_PCP = montoPagoMes_PCP;
	}
	public Date getFechaPago_PCP() {
		return FechaPago_PCP;
	}
	public void setFechaPago_PCP(Date fechaPago_PCP) {
		FechaPago_PCP = fechaPago_PCP;
	}
	public boolean isEstado_PCP() {
		return Estado_PCP;
	}
	public void setEstado_PCP(boolean estado_PCP) {
		Estado_PCP = estado_PCP;
	}
	@Override
	public String toString() {
		return "PagoCuotasPrestamo [CodPago_PCP=" + CodPago_PCP + ", NumPrestamo_PCP=" + NumPrestamo_PCP
				+ ", NumCuenta_PCP=" + NumCuenta_PCP + ", NumCuota_PCP=" + NumCuota_PCP + ", MontoPagoMes_PCP="
				+ MontoPagoMes_PCP + ", FechaPago_PCP=" + FechaPago_PCP + ", Estado_PCP=" + Estado_PCP + "]";
	}
	
	

}
