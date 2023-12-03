package Excepciones;

public class CuilDNIException extends Exception {
	
	public CuilDNIException() {
		
	}
	
	@Override
	public String getMessage() {
		return "El DNI no corresponde al cuil ingresado";
	}
}
