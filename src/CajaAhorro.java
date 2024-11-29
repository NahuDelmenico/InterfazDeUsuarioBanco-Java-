import java.time.LocalDateTime;

import javax.swing.ImageIcon;
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
	public void Transferir(Cuenta receptor) {
		String monto = JOptionPane.showInputDialog("Ingrese el monto a transferir");
		
		
		while(Verificacion(monto) == false) {
			monto = JOptionPane.showInputDialog("Ingrese el monto a transferir");
		}
		
		double m = Double.parseDouble(monto);
		
		if(m <= this.getSaldo()) {
			
			JOptionPane.showMessageDialog(null, "Transferencia exitosa", null,JOptionPane.DEFAULT_OPTION, new ImageIcon(CajaAhorro.class.getResource("transferir.png")));
			
			if(this.dolares == true) {
			this.setSaldo(this.getSaldo()-(m+(m*2/100))); 
			Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Transferencia     -$",(m+(m*2/100)) );
			this.getMovimientos().add(nuevo);
			}else {
				this.setSaldo(this.getSaldo()-(m)); 
				Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Transferencia     -$",m );
				this.getMovimientos().add(nuevo);
				
			}
			receptor.setSaldo(receptor.getSaldo()+m);
			Movimiento recep = new Movimiento(1,LocalDateTime.now(), "Transferencia     +$",m );
			receptor.getMovimientos().add(recep);
			
		
		}else {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente, operacion cancelada", null,JOptionPane.DEFAULT_OPTION, new ImageIcon(CajaAhorro.class.getResource("error.png")));
		}
	}

	@Override
	public void Retirar() {
		String monto = JOptionPane.showInputDialog("Ingrese el monto a retirar");
		
		
		while(Verificacion(monto) == false) {
			monto = JOptionPane.showInputDialog("Ingrese el monto a retirar");
		}
		
		double m = Double.parseDouble(monto);
		
		if(m <= this.getSaldo()) {
			
			JOptionPane.showMessageDialog(null, "Retiro exitoso", null,JOptionPane.DEFAULT_OPTION, new ImageIcon(CajaAhorro.class.getResource("retirar.png")));
			
			this.setSaldo(this.getSaldo()-m); 
			
			Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Retiro  -$",m );
			
			this.getMovimientos().add(nuevo);
			
		
		}else {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente, operacion cancelada", null,JOptionPane.DEFAULT_OPTION, new ImageIcon(CajaAhorro.class.getResource("error.png")));
		}
	}

	@Override
	public void Depositar() {
		String monto = JOptionPane.showInputDialog("Ingrese el monto a depositar");
		
		while(Verificacion(monto) == false) {
			monto = JOptionPane.showInputDialog("Ingrese el monto a depositar");
		}
		
		double m = Double.parseDouble(monto);
		
		
			JOptionPane.showMessageDialog(null, "Deposito exitoso", null,JOptionPane.DEFAULT_OPTION, new ImageIcon(CajaAhorro.class.getResource("deposito.png")));
			
			this.setSaldo(getSaldo()+m);
			
			Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Deposito   +$",m );
			this.getMovimientos().add(nuevo);
			
	}

	@Override
	public void VerSaldo() {
		JOptionPane.showMessageDialog(null, "El saldo actual es de $" + this.getSaldo(), null,JOptionPane.DEFAULT_OPTION, new ImageIcon(CajaAhorro.class.getResource("saldo.png")));
	}

	@Override
	public void VerHistorial() {
		// TODO Auto-generated method stub
		super.VerHistorial();
	}

	@Override
	public void Pagar_con_tarjeta_Credito() {
		
		if (this.getTarjetaCredito().size()==0) {
			JOptionPane.showMessageDialog(null, "Ustede no tiene tarjetas de credito disponibles", null,JOptionPane.DEFAULT_OPTION, new ImageIcon(CajaAhorro.class.getResource("error.png")));
		}else {
			String[] cuotas = {"1","3","6","9"};

			String monto = JOptionPane.showInputDialog("Ingrese el monto a pagar");
			
			while(Verificacion(monto) == false) {
				monto = JOptionPane.showInputDialog("Ingrese el monto a pagar");
			}
			
			double m = Double.parseDouble(monto);
			
			int v = 0;
			String [] tarjetas = new String[this.getTarjetaCredito().size()] ;
			for(Credito c : this.getTarjetaCredito()) {
				tarjetas[v] = String.valueOf(c.getNumeroTarjeta());
				v++;
			}
			v =0;
			
			int a = JOptionPane.showOptionDialog(null, "Seleccione la tarjeta", null, 0, 0, null, tarjetas, tarjetas[0]);
			
			
			if (m <= this.getTarjetaCredito().get(a).getLimiteDeuda() ) {
				int c = JOptionPane.showOptionDialog(null, "Seleccione la cuotas sin interes", null, 0, 0, null, cuotas, cuotas[0]);
				
				this.getTarjetaCredito().get(a).setLimiteDeuda(this.getTarjetaCredito().get(a).getLimiteDeuda()-m);
				this.getTarjetaCredito().get(a).setTotalAPagar(this.getTarjetaCredito().get(a).getTotalAPagar()+m);
				
				Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Tarjeta de Credito Cuotas:" +cuotas[c]+"    $",m );
				this.getMovimientos().add(nuevo);
				
				JOptionPane.showMessageDialog(null, "Operacion Exitosa \nTotal a pagar: $"+m+"\nCuotas: "+cuotas[c]+" x $"+ m/Integer.parseInt(cuotas[c]));
			}else {
				JOptionPane.showMessageDialog(null, "Limite de deuda alcanzado.\nLimite de tarjeta:" + this.getTarjetaCredito().get(a).getLimiteDeuda()+"\nOperacion cancelada");
			}
			
			
		}
	}

	@Override
	public void Pagar_con_tarjeta_Debito() {
		
		if (this.getTarjetaDebito().size()==0) {
			JOptionPane.showMessageDialog(null, "Ustede no tiene tarjetas de debito disponibles",null,JOptionPane.DEFAULT_OPTION, new ImageIcon(CajaAhorro.class.getResource("error.png")));
		}else {
			
			String monto = JOptionPane.showInputDialog("Ingrese el monto a pagar");
			
			while(Verificacion(monto) == false) {
				monto = JOptionPane.showInputDialog("Ingrese el monto a pagar");
			}
			
			double m = Double.parseDouble(monto);
			
			int v = 0;
			String [] tarjetas = new String[this.getTarjetaDebito().size()] ;
			for(Debito c : this.getTarjetaDebito()) {
				tarjetas[v] = String.valueOf(c.getNumeroTarjeta());
				v++;
			}
			v =0;
			
			int a = JOptionPane.showOptionDialog(null, "Seleccione la tarjeta", null, 0,JOptionPane.DEFAULT_OPTION, new ImageIcon(CajaAhorro.class.getResource("tarjeta.png")), tarjetas, tarjetas[0]);
		
			if(m <= this.getTarjetaDebito().get(a).getLimiteCompra() && m <=this.getSaldo()) {
				
				this.setSaldo(this.getSaldo()-m);
				
				Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Tarjeta de Debito    -$",m );
				this.getMovimientos().add(nuevo);
				
				JOptionPane.showMessageDialog(null, "Operacion Exitosa", null,JOptionPane.DEFAULT_OPTION, new ImageIcon(CajaAhorro.class.getResource("tarjeta.png")));
			}else {
				JOptionPane.showMessageDialog(null, "Limite de pago alcanzado y/o saldo insuficiente.\nLimite de tarjeta:" + this.getTarjetaDebito().get(a).getLimiteCompra()+"\nOperacion cancelada", null,JOptionPane.DEFAULT_OPTION, new ImageIcon(CajaAhorro.class.getResource("error.png")));
			}
			
		}
		
	}

	
	

	
	


}
	
	
	
	
	

