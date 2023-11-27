package Excepciones;

public class UsuarioEnBlancoException extends Exception {
	
	public UsuarioEnBlancoException() {
		
	}

	@Override
	public String getMessage() {
		return "El usuario no puede estar en blanco";
	}
	
	
}
