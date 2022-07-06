
public class Main {
	
	public static void main(String[] args) {

		// Uso de clase Cliente
		
		Cliente usuario = new Cliente();
		
		usuario.setNombre("Nicolás");
		
		usuario.setEdad(32);
		
		usuario.setTelefono(44545833);
		
		usuario.setCredito(1500);
		
		System.out.println("Hola. Me llamo " + usuario.getNombre() + ".");
		
		System.out.println("Tengo " + usuario.getEdad() + " años.");
		
		System.out.println("Mi número de teléfono es " + usuario.getTelefono() + ".");
		
		System.out.println("Mi crédito de cliente es $" + usuario.getCredito());
		
		// Uso de clase Trabajador
		
		Trabajador empleado = new Trabajador();
		
		empleado.setNombre("Enzo");
		
		empleado.setEdad(32);
		
		empleado.setTelefono(44458533);
		
		empleado.setSalario(5500);
		
		System.out.println("Hola. Me llamo " + empleado.getNombre() + ".");
		
		System.out.println("Tengo " + empleado.getEdad() + " años.");
		
		System.out.println("Mi número de teléfono es " + empleado.getTelefono() + ".");
		
		System.out.println("Mi salario es $" + empleado.getSalario());
	}
}

class Persona {
	
	private int _edad;
	
	private String _nombre;
	
	private int _telefono;
	
	public void setEdad(int edad) {
		
		this._edad = edad;
	}
	
	public int getEdad() {
		
		return this._edad;
	}
	
	public void setNombre(String nombre) {
		
		this._nombre = nombre;
	}
	
	public String getNombre() {
		
		return this._nombre;
	}
	
	public void setTelefono(int telefono) {
		
		this._telefono = telefono;
	}
	
	public int getTelefono() {
		
		return this._telefono;
	}
}

class Cliente extends Persona {
	
	private double _credito;
	
	public void setCredito(double credito) {
		
		this._credito = credito;
	}
	
	public double getCredito() {
		
		return this._credito;
	}
}

class Trabajador extends Persona {
	
	private double _salario;
	
	public void setSalario(double salario) {
		
		this._salario = salario;
	}
	
	public double getSalario() {
		
		return this._salario;
	}
}
