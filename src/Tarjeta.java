
public class Tarjeta {
	
	private int numeroTarjeta;
	private boolean credito;

	public Tarjeta(int numeroTarjeta,boolean credito) {
		super();
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public boolean isCredito() {
		return credito;
	}

	public void setCredito(boolean credito) {
		this.credito = credito;
	}
	
	
	
}	
