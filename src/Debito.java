
public class Debito extends Tarjeta{
	private double limiteRetiro;
	private double limiteCompra;
	
	
	

	public Debito(int numeroTarjeta, boolean credito, double limiteRetiro, double limiteCompra) {
		super(numeroTarjeta, credito);
		this.limiteRetiro = limiteRetiro;
		this.limiteCompra = limiteCompra;
	}


	public double getLimiteRetiro() {
		return limiteRetiro;
	}


	public void setLimiteRetiro(double limiteRetiro) {
		this.limiteRetiro = limiteRetiro;
	}


	public double getLimiteCompra() {
		return limiteCompra;
	}


	public void setLimiteCompra(double limiteCompra) {
		this.limiteCompra = limiteCompra;
	}
	
	
	
	
}
