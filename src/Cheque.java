import java.time.LocalDate;

public class Cheque {
	private LocalDate fechaEmsion;
	private LocalDate fechaDeposito;
	private double monto;
	private int numero;
	
	public Cheque(LocalDate fechaEmsion, LocalDate fechaDeposito, double monto, int numero) {
		super();
		this.fechaEmsion = fechaEmsion;
		this.fechaDeposito = fechaDeposito;
		this.monto = monto;
		this.numero = numero;
	}

	public LocalDate getFechaEmsion() {
		return fechaEmsion;
	}

	public void setFechaEmsion(LocalDate fechaEmsion) {
		this.fechaEmsion = fechaEmsion;
	}

	public LocalDate getFechaDeposito() {
		return fechaDeposito;
	}

	public void setFechaDeposito(LocalDate fechaDeposito) {
		this.fechaDeposito = fechaDeposito;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
}
