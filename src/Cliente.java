import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Cliente extends Usuario {
	
	
	private Cuenta cuenta;

	public Cliente(String nombre, String contrasenia, LocalDate alta, Banco banco, Cuenta cuenta) {
		super(nombre, contrasenia, alta, banco);
		this.cuenta = cuenta;
	}
	
	public Cuenta getCuenta() {
		return cuenta;
	}
	
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	
	
	
	public void Transferir() {
		
		String monto = JOptionPane.showInputDialog("Ingrese el monto a transferir");
		
		
		while(Verificacion(monto) == false) {
			monto = JOptionPane.showInputDialog("Ingrese el monto a transferir");
		}
		
		double m = Double.parseDouble(monto);
		
		if(m <= this.getCuenta().getSaldo()) {
			
			JOptionPane.showMessageDialog(null, "Transferencia exitosa");
			
			this.getCuenta().setSaldo(this.getCuenta().getSaldo()-m); 
			
			Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Transferencia",m );
			this.getCuenta().getMovimientos().add(nuevo);
			
		
		}else {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente, operacion cancelada");
		}
		}

	public void Depositar() {
		String monto = JOptionPane.showInputDialog("Ingrese el monto a depositar");
		
		while(Verificacion(monto) == false) {
			monto = JOptionPane.showInputDialog("Ingrese el monto a transferir");
		}
		
		double m = Double.parseDouble(monto);
		
		
			JOptionPane.showMessageDialog(null, "Deposito exitoso");
			
			this.getCuenta().setSaldo(getCuenta().getSaldo()+m);
			
			Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Deposito",m );
			this.getCuenta().getMovimientos().add(nuevo);
			
			
		
	}

	public void Retirar() {
		
		String monto = JOptionPane.showInputDialog("Ingrese el monto a retirar");
		
		
		while(Verificacion(monto) == false) {
			monto = JOptionPane.showInputDialog("Ingrese el monto a transferir");
		}
		
		double m = Double.parseDouble(monto);
		
		if(m <= this.getCuenta().getSaldo()) {
			
			JOptionPane.showMessageDialog(null, "Retiro exitoso");
			
			this.getCuenta().setSaldo(this.getCuenta().getSaldo()-m); 
			
			Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Retiro",m );
			
			this.getCuenta().getMovimientos().add(nuevo);
			
		
		}else {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente, operacion cancelada");
		}
		}

	public void VerSaldo() {
		JOptionPane.showMessageDialog(null, "El saldo actual es de $" + this.getCuenta().getSaldo());
	}
	
	@Override 
	public void VerHistorial() {
	
		String movs = "Movimientos\n\n";
		if(this.getCuenta().getMovimientos().size()==0){
			
			JOptionPane.showMessageDialog(null, "Aun no sea han registrado movimientos en la cuenta");
		}else {
			
			for(Movimiento mov :	this.getCuenta().getMovimientos()) {
				
				movs = movs + "Movimiento "+mov.getNumeroMovimiento() + "     " + mov.getFecha() + "  " + mov.getDetalle() + "                                        $" + mov.getMonto() + "\n";  
				
			}
			JOptionPane.showMessageDialog(null, movs);
		}
		
	}

	public void PagarTarjeta(Tarjeta tarjeta) {
		
	}



}	



