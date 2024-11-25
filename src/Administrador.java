import java.time.LocalDate;

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

	
	 
	
	
	
}
