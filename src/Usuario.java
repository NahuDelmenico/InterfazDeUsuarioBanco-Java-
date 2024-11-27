import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public abstract class Usuario {
	
	
	private String nombre;
	private String contrasenia;
	private LocalDate alta;
	private static LinkedList<Usuario> Usuarios = new LinkedList<Usuario>();;
	private Banco banco;
	public String getNombre() {
		return nombre;
	}
	

	public Usuario(String nombre, String contrasenia, LocalDate alta, Banco banco) {
		super();
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.alta = alta;
		this.banco = banco;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public LocalDate getAlta() {
		return alta;
	}
	public void setAlta(LocalDate alta) {
		this.alta = alta;
	}
	public static LinkedList<Usuario> getUsuarios() {
		return Usuarios;
	}
	public static void setUsuarios(LinkedList<Usuario> usuarios) {
		Usuarios = usuarios;
	}
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	public static boolean Login(String user, String contra){
		
		boolean flag = false;
		
		for(Usuario u : Usuarios) {
			
			if(user.equals(u.getNombre()) && contra.equals(u.getContrasenia())) {
				flag = true;
				break;
			}
			
		}
			
		return flag;
	}
	
	public void VerHistorial() {
		
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
			JOptionPane.showMessageDialog(null, "ingrese un monto positivo");
			return false; 
			
		}
			return true;
		}
		
	
}
