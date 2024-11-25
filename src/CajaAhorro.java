

public class CajaAhorro extends Cuenta {
	
	private boolean dolares;

	public CajaAhorro(int nroCuenta, double saldo,boolean dolares) {
		super(nroCuenta, saldo);
		this.dolares = dolares;
	}

	public boolean isDolares() {
		return dolares;
	}

	public void setDolares(boolean dolares) {
		this.dolares = dolares;
	}
	
	
}
