
import java.util.LinkedList;

import javax.swing.JOptionPane;

public abstract class Cuenta {
		
		private int nroCuenta;
		private double saldo;
		private LinkedList<Credito> tarjetaCredito = new LinkedList<Credito>();
		private LinkedList<Debito> tarjetaDebito = new LinkedList<Debito>();
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
		


		public LinkedList<Credito> getTarjetaCredito() {
			return tarjetaCredito;
		}


		public void setTarjetaCredito(LinkedList<Credito> tarjetaCredito) {
			this.tarjetaCredito = tarjetaCredito;
		}


		public LinkedList<Debito> getTarjetaDebito() {
			return tarjetaDebito;
		}


		public void setTarjetaDebito(LinkedList<Debito> tarjetaDebito) {
			this.tarjetaDebito = tarjetaDebito;
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
			
		public void Transferir(Cuenta receptor) {};
		public void Retirar() {};
		public void Depositar() {};
		public void VerSaldo() {};
		public void VerHistorial() {
			
			String movs = "Movimientos\n\n";
			if(this.getMovimientos().size()==0){
				
				JOptionPane.showMessageDialog(null, "Aun no sea han registrado movimientos en la cuenta");
			}else {
				
				for(Movimiento mov :	this.getMovimientos()) {
					
					movs = movs + "Movimiento "+mov.getNumeroMovimiento() + "     " + mov.getFecha() + "  " + mov.getDetalle() + mov.getMonto() + "\n";  
					
				}
				JOptionPane.showMessageDialog(null, movs);
			}
			
		}
		public void Pagar_con_tarjeta_Credito() {};
		public void Pagar_con_tarjeta_Debito() {};
}
