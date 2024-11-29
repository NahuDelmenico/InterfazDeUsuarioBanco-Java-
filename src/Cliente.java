import java.time.LocalDate;


public class Cliente extends Usuario {
	
	
	private Cuenta cuenta;

	public Cliente(String nombre, String contrasenia, LocalDate alta, Banco banco, Cuenta cuenta) {
		super(nombre, contrasenia, alta, banco);
		this.cuenta = cuenta;
	}
	
	public Cuenta getCuenta() {
		return cuenta;
	}
	
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	

	
	

	public static Cliente findCliente(String nombre, String contraseña){
		  for (Cliente cliente : Usuario.getClientes() ){
		    if (cliente.getNombre().equals(nombre) && cliente.getContrasenia().equals(contraseña)){
		      return cliente;
		    }
		  }
		  return null;
		}
	

}	



