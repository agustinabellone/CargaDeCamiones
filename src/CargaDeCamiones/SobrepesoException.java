package CargaDeCamiones;

public class SobrepesoException extends Exception {
	public SobrepesoException() {
		super("La carga tiene sobrepeso.");
	}
}

