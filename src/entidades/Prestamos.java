package entidades;

public class Prestamos {
	private int NumPrestamo_P;
	private int NumCliente_P;
	private Cuenta NumCuenta_P;
	private float ImportePagar_P;
	private float ImportePedido_P;
	private Cuotas IdCuota_P;
	private boolean Estado;
	private boolean Autorizado;
	
	public Prestamos()
	{
		NumCuenta_P = new Cuenta();
		IdCuota_P = new Cuotas();
	}
	public Prestamos(int numPrestamo, int numCliente, Cuenta numCuenta, float importePagar, float importePedido,
			Cuotas idCuota, boolean estado, boolean autorizado)
	{
		this.NumPrestamo_P=numPrestamo;
		this.NumCliente_P = numCliente; 
		this.NumCuenta_P=numCuenta;
		this.ImportePagar_P=importePagar;
		this.ImportePedido_P=importePedido;
		this.IdCuota_P=idCuota;
		this.Estado=estado;
		this.Autorizado=autorizado;
		
	}
	public int getNumPrestamo_P() {
		return NumPrestamo_P;
	}
	public void setNumPrestamo_P(int numPrestamo_P) {
		NumPrestamo_P = numPrestamo_P;
	}
	public int getNumCliente() {
		return NumCliente_P;
	}
	public void setNumCliente_P(int numCliente_P) {
		NumCliente_P = numCliente_P;
	}
	public Cuenta getNumCuenta_P() {
		return NumCuenta_P;
	}
	public void setNumCuenta_P(Cuenta numCuenta_P) {
		NumCuenta_P = numCuenta_P;
	}
	public float getImportePagar_P() {
		return ImportePagar_P;
	}
	public void setImportePagar_P(float importePagar_P) {
		ImportePagar_P = importePagar_P;
	}
	public float getImportePedido_P() {
		return ImportePedido_P;
	}
	public void setImportePedido_P(float importePedido_P) {
		ImportePedido_P = importePedido_P;
	}
	public Cuotas getIdCuota_P() {
		return IdCuota_P;
	}
	public void setIdCuota_P(Cuotas idCuota_P) {
		IdCuota_P = idCuota_P;
	}
	public boolean getEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
	public boolean getAutorizado() {
		return Autorizado;
	}
	public void setAutorizado(boolean autorizado) {
		Autorizado = autorizado;
	}
	@Override
	public String toString() {
		return "Prestamos [NumPrestamo_P=" + NumPrestamo_P + ",NumCliente_P="+NumCliente_P + ", NumCuenta_P=" + NumCuenta_P + ", ImportePagar_P="
				+ ImportePagar_P + ", ImportePedido_P=" + ImportePedido_P + "IdCuota_P=" + IdCuota_P + ", Estado=" + Estado + " , Autorizado=" + Autorizado + "]";
	}
	

}
