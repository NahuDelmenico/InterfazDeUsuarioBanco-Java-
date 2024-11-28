import java.time.LocalDate;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public abstract class Main {
	
	public static void main(String[] args) {
		 
		Banco Frances = new Banco("Frances");
		
		CajaAhorro CajaAhorroNahuel = new CajaAhorro(1,200.0,false); 
		Corriente CuentaCorrienteNahuel = new Corriente(4564,200000,1000000,-1000000);
		
		Administrador Gerente = new Administrador("UserBank", "123456" , LocalDate.of(2000, 1, 1), Frances, 1);
		Cliente Nahuel = new Cliente("N", "1",LocalDate.of(2024, 10, 20), Frances, CajaAhorroNahuel);
		
		Usuario.getUsuarios().add(Nahuel);
		Usuario.getUsuarios().add(Gerente);
		
		
		boolean conectado = true;
		
		JOptionPane.showMessageDialog(null, "Bienvenido a BBVA Argentina ");
		while(conectado == true) {
			
			String [] opc = {"Iniciar Sesion","salir"};
			
			int i  = JOptionPane.showOptionDialog(null, "Seleccione", null, 0, 0, null, opc, opc[0]);
			if (i == 1) {
				
				
				JOptionPane.showMessageDialog(null, "Gracias por su visita");
				conectado = false;
				
			}else {
				
				
				boolean sesion = Usuario.Login(JOptionPane.showInputDialog("Ingrese El Usuario"), JOptionPane.showInputDialog("Ingrese la contrasena"));
				
				while(sesion == false) {
				
					JOptionPane.showMessageDialog(null, "Contraseña y/o nombre de usuario incorrectos");
					
					 if (1	==  JOptionPane.showOptionDialog(null, "¿Desea continuar?", null, i, i, null, null, null)) {
						 sesion = true ;
						 
					 }else {
						 sesion = Usuario.Login(JOptionPane.showInputDialog("Ingrese El Usuario"), JOptionPane.showInputDialog("Ingrese la contrasena"));
					 }
				}	
						
					JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso");
					boolean cerrarSesion = true;
					while(cerrarSesion == true) {	
							int a = JOptionPane.showOptionDialog(null, "Selecciones la accion a realizar",//Mensaje que aparece en la ventana
								"", //Titulo 
								0, //
								JOptionPane.DEFAULT_OPTION, // Elijo la opción de imagen que muestra
								new ImageIcon(Main.class.getResource("logo.jpg")), //aca va el image icon
								Opciones.values(),
								Opciones.values()[0]
										
								);
							
							String[] cuentas = {"Caja de Ahorro","Cuenta Corriente"}; 
							switch(a) {
							 
							case 0:
								//TRANSFERENCIA
								int c= JOptionPane.showOptionDialog(null, "Seleccione la cuenta", null, 0, 0, null, cuentas, cuentas[0]);
								
								if(c==0) {
									CajaAhorroNahuel.Transferir();
								}else {
									
								}
								
								break;
							case 1: 
								//DEPOSITO
								 c= JOptionPane.showOptionDialog(null, "Seleccione la cuenta", null, 0, 0, null, cuentas, cuentas[0]);
								
								if(c==0) {
									CajaAhorroNahuel.Depositar();
								}else {
									
								}
								
								break;
							case 2: 
								//RETIRAR
								 c= JOptionPane.showOptionDialog(null, "Seleccione la cuenta", null, 0, 0, null, cuentas, cuentas[0]);
								
								if(c==0) {
									CajaAhorroNahuel.Retirar();
								}else {
									
								}
								
								break;
							case 3: 
								//VER SALDO
								c= JOptionPane.showOptionDialog(null, "Seleccione la cuenta", null, 0, 0, null, cuentas, cuentas[0]);
								
								if(c==0) {
									CajaAhorroNahuel.VerSaldo();
								}else {
									
								}
								
								break;
							case 4: 
								//VER HISTORIAL
								c= JOptionPane.showOptionDialog(null, "Seleccione la cuenta", null, 0, 0, null, cuentas, cuentas[0]);
								
								if(c==0) {
									
									
								}else {
									
								}
								
								break;
							case 5: 
								//TARJETA
								break;
							case 6:
								//CHEQUE
								CuentaCorrienteNahuel.emitirCheque();
								break;
							case 7: 
								//SALIR
								cerrarSesion = false;
								sesion= false;
								JOptionPane.showMessageDialog(null, "Sesion cerrada");
								break;
			
								}
						}
					}
				}
			}
	}



