import java.time.LocalDate;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class Administrador extends Usuario {
	private int numero;

	public Administrador(String nombre, String contrasenia, LocalDate alta, Banco banco, int numero) {
		super(nombre, contrasenia, alta, banco);
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	
	public boolean Verificacion(String monto) {
		
		 
		if(monto.isEmpty() || monto == "") {
			JOptionPane.showMessageDialog(null, "El monto no puede estar vacio");
			return false; 
			
		}else {
			return true;
		}
		
	}

	public static Administrador findAdministrador(String nombre, String contraseña){
		  for (Administrador administrador : Usuario.getAdministradores() ){
		    if (administrador.getNombre().equals(nombre) && administrador.getContrasenia().equals(contraseña)){
		      return administrador;
		    }
		  }
		  return null;
		}
	 
	public void crearCliente(){
		String[]cuentas= {"Cuenta corriente","Caja de Ahorro"};
		int c= JOptionPane.showOptionDialog(null, "Seleccione el tipo de cuenta", null, 0, JOptionPane.DEFAULT_OPTION, // Elijo la opción de imagen que muestra
				new ImageIcon(Administrador.class.getResource("agregar.png")), cuentas, cuentas[0]);
		if(c==0) {
			String nombre = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
			while(Verificacion(nombre) == false) {
				nombre = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
			}
			String contra = JOptionPane.showInputDialog("Ingrese la contrasena");
			while(Verificacion(contra) == false) {
				contra = JOptionPane.showInputDialog("Ingrese la contrasena");
			}
			Cliente nuevoCliente= new Cliente( nombre,contra, LocalDate.now(), this.getBanco(), crearCuentaCoriente());
			
			Usuario.getClientes().add(nuevoCliente);
		}else {
			String nombre = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
			while(Verificacion(nombre) == false) {
				nombre = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
			}
			String contra = JOptionPane.showInputDialog("Ingrese la contrasena");
			while(Verificacion(contra) == false) {
				contra = JOptionPane.showInputDialog("Ingrese la contrasena");
			}
			Cliente nuevoCliente= new Cliente( nombre,contra, LocalDate.now(), this.getBanco(), crearCajaAhorro());
			
			Usuario.getClientes().add(nuevoCliente);
		}
		
		JOptionPane.showMessageDialog(null, "Cliente creado con exito");
		
	}
	
	public Corriente crearCuentaCoriente(){
		
			
			String numero = JOptionPane.showInputDialog("Ingrese el numero de cuenta");
			while(Verificacion(numero) == false) {
				numero = JOptionPane.showInputDialog("Ingrese el numero de cuenta");
			}
			int num = Integer.parseInt(numero);
			
			
			
			Corriente cuentaCorriente = new Corriente(num,0, 0,100000);
			return cuentaCorriente;
		
	}
	
	public CajaAhorro crearCajaAhorro(){
		
		
		String numero = JOptionPane.showInputDialog("Ingrese el numero de cuenta");
		while(Verificacion(numero) == false) {
			numero = JOptionPane.showInputDialog("Ingrese el numero de cuenta");
		}
		int num = Integer.parseInt(numero);
		
		boolean dolares;
		if (JOptionPane.showOptionDialog(null, "¿Caja de ahorro en dolares?", null, 0, 0, null, null, null)==0) {
			dolares = true;
		}else {
			dolares = false;
		}
		
		CajaAhorro cajaAhorro = new CajaAhorro(num,0,dolares);
		return cajaAhorro;
	
}
	
	public void listaClientes() {
		int a = 0;
		String[]lista = new String[Usuario.getClientes().size()];
		for(Cliente u : Usuario.getClientes()) {
			
			lista[a]= (a+1)+"- Usuario: "+u.getNombre()+"   Contrasenia: "+u.getContrasenia()+"           Saldo en cuenta $"+u.getCuenta().getSaldo()+"\n"; 
			a++;
		}
		a=0;
		JOptionPane.showMessageDialog(null, lista, null, JOptionPane.DEFAULT_OPTION, new ImageIcon(Administrador.class.getResource("lista.png")));
	}
	
	public void crearTarjetaDebito(){
		int num = 0;
		String[]clientes = new String[ Usuario.getClientes().size()];
		for(Cliente u : Usuario.getClientes()) {
			
			clientes[num] = u.getNombre()+"\n";
			num++;
		}
		num=0;
		
		int c = JOptionPane.showOptionDialog(null, "Seleccione el Cliente", null, 0, 0, null, clientes, clientes[0]);
		
		String numero = JOptionPane.showInputDialog("Ingrese el numero de la tarjeta");
		while(Verificacion(numero) == false) {
			numero = JOptionPane.showInputDialog("Ingrese el numero de tarjeta");
		}
		 num = Integer.parseInt(numero); 
		
		Debito nueva = new Debito(num,false, 1000000, 2000000);
		
		Usuario.getClientes().get(c).getCuenta().getTarjetaDebito().add(nueva);
		JOptionPane.showMessageDialog(null, "Tarjeta de Debito creada con exito");
		
	}
	
	public void crearTarjetaCredito(){
		int num = 0;
		String[]clientes = new String[ Usuario.getClientes().size()];
		for(Cliente u : Usuario.getClientes()) {
			
			clientes[num] = u.getNombre()+"\n";
			num++;
		}
		num=0;
		
		int c = JOptionPane.showOptionDialog(null, "Seleccione el Cliente", null, 0, 0, null, clientes, clientes[0]);
		
		String numero = JOptionPane.showInputDialog("Ingrese el numero de la tarjeta");
		while(Verificacion(numero) == false) {
			numero = JOptionPane.showInputDialog("Ingrese el numero de tarjeta");
		}
		 num = Integer.parseInt(numero); 
		
		Credito nueva = new Credito(num,true, 1000000,0);
		
		Usuario.getClientes().get(c).getCuenta().getTarjetaCredito().add(nueva);
		JOptionPane.showMessageDialog(null, "Tarjeta de Credito creada con exito");
	}
	
	
	
}
