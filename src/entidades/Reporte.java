package entidades;

public class Reporte {

	private float ingresos;
	private float egresos;
	private int cantUsuarios;
	private int cantPrestamos;
	private int cantMovimientos;
	
	public Reporte() {
		
	}
	
	public Reporte(float ingresos, float egresos, int cantUsuarios, int cantPrestamos, int cantMovimientos) {
		super();
		this.ingresos = ingresos;
		this.egresos = egresos;
		this.cantUsuarios = cantUsuarios;
		this.cantPrestamos = cantPrestamos;
		this.cantMovimientos = cantMovimientos;
	}


	public float getIngresos() {
		return ingresos;
	}


	public void setIngresos(float ingresos) {
		this.ingresos = ingresos;
	}


	public float getEgresos() {
		return egresos;
	}


	public void setEgresos(float egresos) {
		this.egresos = egresos;
	}


	public int getCantUsuarios() {
		return cantUsuarios;
	}


	public void setCantUsuarios(int cantUsuarios) {
		this.cantUsuarios = cantUsuarios;
	}


	public int getCantPrestamos() {
		return cantPrestamos;
	}


	public void setCantPrestamos(int cantPrestamos) {
		this.cantPrestamos = cantPrestamos;
	}


	public int getCantMovimientos() {
		return cantMovimientos;
	}


	public void setCantMovimientos(int cantMovimientos) {
		this.cantMovimientos = cantMovimientos;
	}


	@Override
	public String toString() {
		return "Reporte [ingresos=" + ingresos + ", egresos=" + egresos + ", cantUsuarios=" + cantUsuarios
				+ ", cantPrestamos=" + cantPrestamos + ", cantMovimientos=" + cantMovimientos + "]";
	}
	
	
	
	
}
