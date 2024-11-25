import java.time.LocalDateTime;

public class Movimiento {
	
	private int numeroMovimiento;
	private LocalDateTime fecha;
	private String detalle;
	
	public Movimiento(int numeroMovimiento, LocalDateTime fecha, String detalle) {
		super();
		this.numeroMovimiento = numeroMovimiento;
		this.fecha = fecha;
		this.detalle = detalle;
	}

	public int getNumeroMovimiento() {
		return numeroMovimiento;
	}

	public void setNumeroMovimiento(int numeroMovimiento) {
		this.numeroMovimiento = numeroMovimiento;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	
	

}
