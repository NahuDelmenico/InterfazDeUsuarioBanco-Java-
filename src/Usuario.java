import java.time.LocalDate;
import java.util.LinkedList;



public abstract class Usuario {
	
	
	private String nombre;
	private String contrasenia;
	private LocalDate alta;
	private static LinkedList<Cliente> Clientes = new LinkedList<Cliente>();;
	private static LinkedList<Administrador> Administradores = new LinkedList<Administrador>();;
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
	
	public static LinkedList<Cliente> getClientes() {
		return Clientes;
	}
	public static void setClientes(LinkedList<Cliente> clientes) {
		Clientes = clientes;
	}

	public static LinkedList<Administrador> getAdministradores() {
		return Administradores;
	}

	public static void setAdministradores(LinkedList<Administrador> administradores) {
		Administradores = administradores;
	}

	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	

	
	
	
}
