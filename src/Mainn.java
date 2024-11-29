
import java.time.LocalDate;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Mainn {
	public static void main(String[] args) {
		
		Banco Frances = new Banco("Frances");
		
		Credito TarjetaCreditoNahuel = new Credito(44445555, true,1000000, 0);
		Debito TarjetaDebitoNahuel = new Debito(00004114,false,2000000,4000000);
		
		CajaAhorro CajaAhorroNahuel = new CajaAhorro(1,200000,false); 
		CajaAhorro CajaAhorroBruno = new CajaAhorro(1,100000, false);
		
		Corriente corrienteNahuel=new Corriente(4545, 200000, 0,1000000);
		
		Administrador Gerente = new Administrador("UserBank", "123456" , LocalDate.of(2000, 1, 1), Frances, 1);
		Cliente Nahuel = new Cliente("Nahuel", "1",LocalDate.of(2024, 10, 20), Frances, CajaAhorroNahuel);
		Cliente Bruno = new Cliente ("Bruno", "2", LocalDate.of(2022, 10, 20), Frances,CajaAhorroBruno);
		
		Usuario.getClientes().add(Bruno);
		Usuario.getClientes().add(Nahuel);
		Usuario.getAdministradores().add(Gerente);
		
		CajaAhorroNahuel.getTarjetaDebito().add(TarjetaDebitoNahuel);
		CajaAhorroNahuel.getTarjetaCredito().add(TarjetaCreditoNahuel);
		
		boolean conectado = true;
		
		JOptionPane.showMessageDialog(null,  "Bienvenido al BBVA Argentina",null,JOptionPane.DEFAULT_OPTION,new ImageIcon(Mainn.class.getResource("inicio.jpg")));
		
	
		
		while(conectado == true) {
		
		
		String [] opc = {"Iniciar Sesion","Salir"};
		
		int a = JOptionPane.showOptionDialog(null, "Seleccione", null, 0, 0, null, opc, opc[0]);
		
			if (a == 1) {
				
				JOptionPane.showMessageDialog(null, "Gracias por su visita");
				conectado = false;
			
			}else {
				Cliente clienteLogeado = null;
				Administrador adminLogeado =null;
				
				boolean sesion = true;
				while(sesion == true) {
					
					String nombre = JOptionPane.showInputDialog("Ingrese el usuario");
					String contra = JOptionPane.showInputDialog("ingrese la contraseña");
				
				 
					clienteLogeado = Cliente.findCliente( nombre, contra);
					adminLogeado = Administrador.findAdministrador(nombre, contra);
					
					if	(clienteLogeado!=null) {
						
						JOptionPane.showMessageDialog(null, "Sesion iniciada");
						boolean bucle = true;
						
						while(bucle) {
							int b = JOptionPane.showOptionDialog(null, "Bienvenido "+clienteLogeado.getNombre()+" .Selecciones la accion a realizar",//Mensaje que aparece en la ventana
									"", //Titulo 
									0, //
									JOptionPane.DEFAULT_OPTION, // Elijo la opción de imagen que muestra
									new ImageIcon(Mainn.class.getResource("logo.jpg")), //aca va el image icon
									Opciones.values(),
									Opciones.values()[0]
											
									);
							
							switch(b){
	
							case 0:
							
								//trasnferir
								clienteLogeado.getCuenta().Transferir(Bruno.getCuenta());
								break;
							
							case 1:
								
								clienteLogeado.getCuenta().Depositar();
								break;
								
							case 2:
								clienteLogeado.getCuenta().Retirar();
								break;
								
							case 3:
								clienteLogeado.getCuenta().VerSaldo();
								break;
								
							case 4:
								clienteLogeado.getCuenta().VerHistorial();
							break;
								
							case 5:
								
								
								clienteLogeado.getCuenta().Pagar_con_tarjeta_Credito();
								
								break;
							case 6:
								clienteLogeado.getCuenta().Pagar_con_tarjeta_Debito();
								break;
				
							case 7:
							bucle = false;
							sesion=false;
							JOptionPane.showMessageDialog(null, "Sesion cerrada");
							
							break;
							}
					}
					
					}else if(adminLogeado!=null){
						
						JOptionPane.showMessageDialog(null, "Sesion iniciada");
						boolean bucle = true;
						
						while(bucle) {
						
						int b = JOptionPane.showOptionDialog(null, "Bienvenido "+adminLogeado.getNombre()+" .Selecciones la accion a realizar",//Mensaje que aparece en la ventana
								"", //Titulo 
								0, //
								JOptionPane.DEFAULT_OPTION, // Elijo la opción de imagen que muestra
								new ImageIcon(Mainn.class.getResource("logo.jpg")), //aca va el image icon
								OpcionesAdministrador.values(),
								OpcionesAdministrador.values()[0]
										
								);
					
						switch(b){
						
						case 0:
						
							Gerente.crearCliente();
							
							break;
						case 1: 
							Gerente.listaClientes();
							break;
							
						case 2:
							String[]tiposTarjetas = {"Credito","Debito"};
							int t =JOptionPane.showOptionDialog(null, "Seleccione el tipo de tarjeta a crear", null, 0, JOptionPane.DEFAULT_OPTION, new ImageIcon(Administrador.class.getResource("tarjeta.png")), tiposTarjetas, tiposTarjetas[0]);
							if(t==0) {
								Gerente.crearTarjetaCredito();
							}else {
								Gerente.crearTarjetaDebito();
							}
							break;
						case 3:
							
							bucle = false;
							sesion=false;
							JOptionPane.showMessageDialog(null, "Sesion cerrada");
							break;
					
					
								}
					
						}
					}else {
						int s = JOptionPane.showOptionDialog(null, "Usuario y/o contrasena no encontrados, ¿Desea Continuar?", null, 0, 0, null, null, null);
						if (s==1) {
							sesion=false;
						}
					}
				} 
				
				}
			}
		}
	}
	

