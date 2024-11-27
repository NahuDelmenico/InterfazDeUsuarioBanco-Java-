import java.time.LocalDate;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public abstract class Main {
	
	public static void main(String[] args) {
		 
		Banco Frances = new Banco("Frances");
		
		CajaAhorro CuentaNahuel = new CajaAhorro(1,200.0,false); 
		
		Administrador Gerente = new Administrador("UserBank", "123456" , LocalDate.of(2000, 1, 1), Frances, 1);
		Cliente Nahuel = new Cliente("N", "1",LocalDate.of(2024, 10, 20), Frances, CuentaNahuel);
		
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
				
				boolean sesion = true;
				while(sesion == true ) {
		
					if (Usuario.Login(JOptionPane.showInputDialog("Ingrese El Usuario"), JOptionPane.showInputDialog("Ingrese la contrasena"))==false ) {
						
							JOptionPane.showMessageDialog(null, "Contraseña y/o nombre de usuario incorrectos");
							
							 if (1	==  JOptionPane.showOptionDialog(null, "¿Desea continuar?", null, i, i, null, null, null)) {
								 sesion = false;
								 break;
							 }
						
						
					}else {
						
							JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso");	
							
							int a = JOptionPane.showOptionDialog(null, "Selecciones la accion a realizar",//Mensaje que aparece en la ventana
								"", //Titulo 
								0, //
								JOptionPane.DEFAULT_OPTION, // Elijo la opción de imagen que muestra
								new ImageIcon(Main.class.getResource("logo.jpg")), //aca va el image icon
								Opciones.values(),
								Opciones.values()[0]
										
								);
							
						
							switch(a) {
							
							case 0: 
								
								Nahuel.Transferir();
								break;
							case 1: 
								Nahuel.Depositar();
								break;
							case 2: 
								Nahuel.Retirar();
								break;
							case 3: 
								Nahuel.VerSaldo();
								break;
							case 4: 
								Nahuel.VerHistorial();
								break;
							case 5: 

								sesion = true;
								break;
							
							case 6: 
								
								sesion = false;
								JOptionPane.showMessageDialog(null, "Sesion cerrada");
								break;
			
								}
					}
				}
			
			}
		
		}
	}
		
}

