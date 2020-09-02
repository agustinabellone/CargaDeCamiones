package CargaDeCamiones;

public class VehiculoNotFoundException extends Exception {
	public VehiculoNotFoundException() {
		super ("No se encontró el vehiculo.");
	}
}
