import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Corriente extends Cuenta{
	
	private double limiteCheque;
	private double saldoNegativo;
	private LinkedList<Cheque>chequesEmitidos = new LinkedList<Cheque>();
	
	
	public Corriente(int nroCuenta, double saldo,double limiteCheque, double saldoNegativo) {
		super(nroCuenta, saldo);
		this.limiteCheque = limiteCheque;
		this.saldoNegativo = saldoNegativo;
		
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

	
	
	public void emitirCheque() {
		
		String diferido = JOptionPane.showInputDialog("Ingrese los dias diferido");
		while(Verificacion(diferido)== false) {
			diferido = JOptionPane.showInputDialog("Ingrese los dias diferido");
			
		}
		
		int d = Integer.parseInt(diferido);
		
		String monto = JOptionPane.showInputDialog("Ingrese el monto");
		while(Verificacion(monto)== false) {
			monto = JOptionPane.showInputDialog("Ingrese el monto");
			
		} 
		double m = Double.parseDouble(monto);
		
		if(m > this.getLimiteCheque()) {
			JOptionPane.showMessageDialog(null, "El limite de emision para cheques es de" + this.limiteCheque);
			
		}else {
		
		Cheque cheque = new Cheque(LocalDate.now(), LocalDate.now().plusDays(d), m, 1);
		this.chequesEmitidos.add(cheque);
		JOptionPane.showMessageDialog(null, "Cheque emitido");
		
		Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Cheque " + cheque.getNumero(),m );
		this.getMovimientos().add(nuevo);
		
		}
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
			JOptionPane.showMessageDialog(null, "Ingrese un monto positivo");
			return false; 
			
		}
		
			return true;
		}


	
	
	@Override
	public void Transferir() {
		// TODO Auto-generated method stub
		super.Transferir();
	}

	@Override
	public void Retirar() {
		// TODO Auto-generated method stub
		super.Retirar();
	}

	@Override
	public void Depositar() {
		// TODO Auto-generated method stub
		super.Depositar();
	}

	@Override
	public void VerSaldo() {
		// TODO Auto-generated method stub
		super.VerSaldo();
	}
			
	
}
