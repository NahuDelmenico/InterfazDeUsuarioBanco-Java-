import java.time.LocalDate;
import java.util.Iterator;

import javax.swing.JOptionPane;

public abstract class Main {
	
	public static void main(String[] args) {
		
		Banco Frances = new Banco("Frances");
		
		CajaAhorro CuentaNahuel = new CajaAhorro(1,2000000.0,false); 
		
		Administrador Gerente = new Administrador("UserBank", "123456" , LocalDate.of(2000, 1, 1), Frances, 1);
		Cliente Nahuel = new Cliente("Nahuel Delmenico", "Nahuel123456",LocalDate.of(2024, 10, 20), Frances, CuentaNahuel);
		
		Usuario.getUsuarios().add(Nahuel);
		Usuario.getUsuarios().add(Gerente);
		
		if (Usuario.Login(JOptionPane.showInputDialog("Ingrese su nombre de usurio"), JOptionPane.showInputDialog("Ingrese la contraseña")) == true) {
			
			int a = JOptionPane.showOptionDialog(null, "Selecicones la accion a realizar", null, 0, 0, Opciones.values(), Opciones.values());
			
			switch(a) {
			
			case 0: 
				break;
			case 1: 
				break;
			case 2: 
				break;
			case 3: 
				break;
			case 4: 
				break;
			case 5: 
				break;
				
			
			
			
			}
			}
		
	
	}
		
	}

