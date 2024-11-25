import java.util.LinkedList;

public abstract class Cuenta {
		
		private int nroCuenta;
		private double saldo;
		private LinkedList<Tarjeta> tarjeta;
		private LinkedList<Movimiento> movimientos;
		

		public Cuenta(int nroCuenta, double saldo) {
			super();
			this.nroCuenta = nroCuenta;
			this.saldo = saldo;
			
		}


		public int getNroCuenta() {
			return nroCuenta;
		}


		public void setNroCuenta(int nroCuenta) {
			this.nroCuenta = nroCuenta;
		}


		public double getSaldo() {
			return saldo;
		}


		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}
		

		public LinkedList<Tarjeta> getTarjeta() {
			return tarjeta;
		}


		public void setTarjeta(LinkedList<Tarjeta> tarjeta) {
			this.tarjeta = tarjeta;
		}


		public LinkedList<Movimiento> getMovimientos() {
			return movimientos;
		}


		public void setMovimientos(LinkedList<Movimiento> movimientos) {
			this.movimientos = movimientos;
		}
		
		
}
