import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public abstract class Cuenta {
		
		private int nroCuenta;
		private double saldo;
		private LinkedList<Tarjeta> tarjeta = new LinkedList<Tarjeta>();
		private LinkedList<Movimiento> movimientos = new LinkedList<Movimiento>();
		

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
		
		public boolean Verificacion(String monto) {
			
			 
			if(monto.isEmpty() || monto == "") {
				JOptionPane.showMessageDialog(null, "El monto no puede estar vacio");
				return false; 
				
			} 
		
			for(int i= 0; i<monto.length();i++) {
					
					if(Character.isAlphabetic(monto.charAt(i))) {
						JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
						return false; 
					}
				}
			double m = Double.parseDouble(monto);
			
			if (m < 0) {
				JOptionPane.showMessageDialog(null, "ingrese un monto positivo");
				return false; 
				
			}
				return true;
			}
			
		public void Transferir() {};
		public void Retirar() {};
		public void Depositar() {};
		public void VerSaldo() {};
		
		
}
