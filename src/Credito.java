
public class Credito extends Tarjeta {
	private double limiteDeuda;
	private double totalAPagar;
	
	
	public Credito(int numeroTarjeta, boolean credito, double limiteDeuda, double totalAPagar) {
		super(numeroTarjeta, credito);
		this.limiteDeuda = limiteDeuda;
		this.totalAPagar = totalAPagar;
	}
	
	public double getLimiteDeuda() {
		return limiteDeuda;
	}
	public void setLimiteDeuda(double limiteDeuda) {
		this.limiteDeuda = limiteDeuda;
	}
	public double getTotalAPagar() {
		return totalAPagar;
	}
	public void setTotalAPagar(double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}
	
	
	
}
