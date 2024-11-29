
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Corriente extends Cuenta{
	
	
	private double saldoNegativo;
	private double limiteNegativo;
	
	
	
	public Corriente(int nroCuenta, double saldo, double saldoNegativo,double limiteNegativo) {
		super(nroCuenta, saldo);
		
		this.saldoNegativo = saldoNegativo;
		this.limiteNegativo=limiteNegativo;
	}

	

	public double getSaldoNegativo() {
		return saldoNegativo;
	}

	public void setSaldoNegativo(double saldoNegativo) {
		this.saldoNegativo = saldoNegativo;
	}
	
	
	public double getLimiteNegativo() {
		return limiteNegativo;
	}


	public void setLimiteNegativo(double limiteNegativo) {
		this.limiteNegativo = limiteNegativo;
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
	public void Transferir(Cuenta receptor) {
		String monto = JOptionPane.showInputDialog("Ingrese el monto a transferir");
		
		
		while(Verificacion(monto) == false) {
			monto = JOptionPane.showInputDialog("Ingrese el monto a transferir");
		}
		
		double m = Double.parseDouble(monto);
		
		if(m <= this.limiteNegativo+this.getSaldo()) {
			
			JOptionPane.showMessageDialog(null, "Transferencia exitosa",null,JOptionPane.DEFAULT_OPTION, new ImageIcon(Corriente.class.getResource("transferir.png")));
			
			
				this.setSaldo(this.getSaldo()-(m)); 
				Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Transferencia     -$",m );
				this.getMovimientos().add(nuevo);
				
			
			receptor.setSaldo(receptor.getSaldo()+m);
			Movimiento recep = new Movimiento(1,LocalDateTime.now(), "Transferencia     +$",m );
			receptor.getMovimientos().add(recep);
			
		
		}else {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente y/o limite de cuenta alcanzado, operacion cancelada",null,JOptionPane.DEFAULT_OPTION, new ImageIcon(Corriente.class.getResource("error.png")));
		}
		
	}

	@Override
	public void Retirar() {
		String monto = JOptionPane.showInputDialog("Ingrese el monto a retirar");
		
		
		while(Verificacion(monto) == false) {
			monto = JOptionPane.showInputDialog("Ingrese el monto a retirar");
		}
		
		double m = Double.parseDouble(monto);
		
		if(m <= this.limiteNegativo+this.getSaldo()) {
			
			JOptionPane.showMessageDialog(null, "Retiro exitoso",null,JOptionPane.DEFAULT_OPTION, new ImageIcon(Corriente.class.getResource("retirar.png")));
			
			this.setSaldo(this.getSaldo()-m); 
			
			Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Retiro  -$",m );
			
			this.getMovimientos().add(nuevo);
			
		
		}else {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente y/o limite de cuenta alcanzado, operacion cancelada",null,JOptionPane.DEFAULT_OPTION, new ImageIcon(Corriente.class.getResource("error.png")));
		}
	}

	@Override
	public void Depositar() {
		String monto = JOptionPane.showInputDialog("Ingrese el monto a depositar");
		
		while(Verificacion(monto) == false) {
			monto = JOptionPane.showInputDialog("Ingrese el monto a depositar");
		}
		
		double m = Double.parseDouble(monto);
		
		
			JOptionPane.showMessageDialog(null, "Deposito exitoso",null,JOptionPane.DEFAULT_OPTION, new ImageIcon(Corriente.class.getResource("deposito.png")));
			
			this.setSaldo(getSaldo()+m);
			
			Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Deposito   +$",m );
			this.getMovimientos().add(nuevo);
			
	}

	@Override
	public void VerSaldo() {
		JOptionPane.showMessageDialog(null, "El saldo actual es de $" + this.getSaldo()+"\nLimite de deuda de la cuenta: $" +this.limiteNegativo,null,JOptionPane.DEFAULT_OPTION, new ImageIcon(Corriente.class.getResource("saldo.png")));
	}

	@Override
	public void VerHistorial() {
		// TODO Auto-generated method stub
		super.VerHistorial();
	}
		
	@Override
 	public void Pagar_con_tarjeta_Credito() {
		
		if (this.getTarjetaCredito().size()==0) {
			JOptionPane.showMessageDialog(null, "Ustede no tiene tarjetas de credito disponibles",null,JOptionPane.DEFAULT_OPTION, new ImageIcon(Corriente.class.getResource("error.png")));
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
			
			int a = JOptionPane.showOptionDialog(null, "Seleccione la tarjeta", null, 0,JOptionPane.DEFAULT_OPTION, new ImageIcon(Corriente.class.getResource("tarjeta.png")), tarjetas, tarjetas[0]);
			
			
			if (m <= this.getTarjetaCredito().get(a).getLimiteDeuda() ) {
				int c = JOptionPane.showOptionDialog(null, "Seleccione la cuotas sin interes", null, 0,JOptionPane.DEFAULT_OPTION, new ImageIcon(Corriente.class.getResource("tarjeta.png")), cuotas, cuotas[0]);
				
				this.getTarjetaCredito().get(a).setLimiteDeuda(this.getTarjetaCredito().get(a).getLimiteDeuda()-m);
				this.getTarjetaCredito().get(a).setTotalAPagar(this.getTarjetaCredito().get(a).getTotalAPagar()+m);
				
				Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Tarjeta de Credito Cuotas:" +cuotas[c]+"    $",m );
				this.getMovimientos().add(nuevo);
				
				JOptionPane.showMessageDialog(null, "Operacion Exitosa \nTotal a pagar: $"+m+"\nCuotas: "+cuotas[c]+" x $"+ m/Integer.parseInt(cuotas[c]),null,JOptionPane.DEFAULT_OPTION, new ImageIcon(Corriente.class.getResource("tarjeta.png")));
			}else {
				JOptionPane.showMessageDialog(null, "Limite de deuda alcanzado.\nLimite de tarjeta:" + this.getTarjetaCredito().get(a).getLimiteDeuda()+"\nOperacion cancelada",null,JOptionPane.DEFAULT_OPTION, new ImageIcon(Corriente.class.getResource("error.png")));
			}
		}
			
		}
	

	@Override
	public void Pagar_con_tarjeta_Debito() {
		
		if (this.getTarjetaDebito().size()==0) {
			JOptionPane.showMessageDialog(null, "Ustede no tiene tarjetas de debito disponibles",null,JOptionPane.DEFAULT_OPTION, new ImageIcon(Corriente.class.getResource("error.png")));
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
			
			int a = JOptionPane.showOptionDialog(null, "Seleccione la tarjeta", null, 0,JOptionPane.DEFAULT_OPTION, new ImageIcon(Corriente.class.getResource("tarjeta.png")), tarjetas, tarjetas[0]);
		
			if(m <= this.getTarjetaDebito().get(a).getLimiteCompra() && m <= this.limiteNegativo+this.getSaldo()  ) {
				
				this.setSaldo(this.getSaldo()-m);
				
				
				Movimiento nuevo = new Movimiento(1,LocalDateTime.now(), "Tarjeta de Debito    -$",m );
				this.getMovimientos().add(nuevo);
				
				JOptionPane.showMessageDialog(null, "Operacion Exitosa",null,JOptionPane.DEFAULT_OPTION, new ImageIcon(Corriente.class.getResource("tarjeta.png")));
			}else {
				JOptionPane.showMessageDialog(null, "Limite de pago alcanzado y/o saldo insuficiente.\nLimite de tarjeta:" + this.getTarjetaDebito().get(a).getLimiteCompra()+"\nOperacion cancelada",null,JOptionPane.DEFAULT_OPTION, new ImageIcon(Corriente.class.getResource("error.png")));
			}
			
		}
		
	
	
}

}