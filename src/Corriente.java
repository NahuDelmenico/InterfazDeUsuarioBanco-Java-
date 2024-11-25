

public class Corriente extends Cuenta{
	
	private double limiteCheque;
	private double saldoNegativo;
	private String Cheques_emitidos;
	
	public Corriente(int nroCuenta, double saldo,double limiteCheque, double saldoNegativo, String cheques_emitidos) {
		super(nroCuenta, saldo);
		this.limiteCheque = limiteCheque;
		this.saldoNegativo = saldoNegativo;
		Cheques_emitidos = cheques_emitidos;
	}

	public double getLimiteCheque() {
		return limiteCheque;
	}

	public void setLimiteCheque(double limiteCheque) {
		this.limiteCheque = limiteCheque;
	}

	public double getSaldoNegativo() {
		return saldoNegativo;
	}

	public void setSaldoNegativo(double saldoNegativo) {
		this.saldoNegativo = saldoNegativo;
	}

	public String getCheques_emitidos() {
		return Cheques_emitidos;
	}

	public void setCheques_emitidos(String cheques_emitidos) {
		Cheques_emitidos = cheques_emitidos;
	}

	
	
	
}
