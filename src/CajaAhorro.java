import java.time.LocalDateTime;

import javax.swing.JOptionPane;

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

	@Override
	public void Transferir() {
		String monto = JOptionPane.showInputDialog("Ingrese el monto a transferir");
		
		
		while(Verificacion(monto) == false) {
			monto = JOptionPane.showInputDialog("Ingrese el monto a transferir");
		}
		
		double m = Double.parseDouble(monto);
		
		if(m <= this.getSaldo()) {
			
			JOptionPane.showMessageDialog(null, "Transferencia exitosa");
			
			this.setSaldo(this.getSaldo()-m); 
			
			Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Transferencia",m );
			this.getMovimientos().add(nuevo);
			
		
		}else {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente, operacion cancelada");
		}
	}

	@Override
	public void Retirar() {
		String monto = JOptionPane.showInputDialog("Ingrese el monto a retirar");
		
		
		while(Verificacion(monto) == false) {
			monto = JOptionPane.showInputDialog("Ingrese el monto a transferir");
		}
		
		double m = Double.parseDouble(monto);
		
		if(m <= this.getSaldo()) {
			
			JOptionPane.showMessageDialog(null, "Retiro exitoso");
			
			this.setSaldo(this.getSaldo()-m); 
			
			Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Retiro",m );
			
			this.getMovimientos().add(nuevo);
			
		
		}else {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente, operacion cancelada");
		}
	}

	@Override
	public void Depositar() {
		String monto = JOptionPane.showInputDialog("Ingrese el monto a depositar");
		
		while(Verificacion(monto) == false) {
			monto = JOptionPane.showInputDialog("Ingrese el monto a transferir");
		}
		
		double m = Double.parseDouble(monto);
		
		
			JOptionPane.showMessageDialog(null, "Deposito exitoso");
			
			this.setSaldo(getSaldo()+m);
			
			Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Deposito",m );
			this.getMovimientos().add(nuevo);
			
	}

	@Override
	public void VerSaldo() {
		JOptionPane.showMessageDialog(null, "El saldo actual es de $" + this.getSaldo());
	}
	
	
	
}
