package CargaDeCamiones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Agencia{

	private Set <Vehiculo> vehiculos;

	public Agencia() {
		vehiculos = new HashSet <Vehiculo>();
	}

	// Agrega Un vehiculo a la flota
	public Boolean agregarVehiculo(Vehiculo vehiculo) {
		return vehiculos.add(vehiculo);
	}

	// * Busca Un vehiculo por patente y si no lo encuentra devuelve
	// VehiculoNotFoundException
	public Vehiculo buscarVehiculo(String patente) throws VehiculoNotFoundException {
		for (Vehiculo vehiculo : vehiculos) {
			if (vehiculo.getPatente().equals(patente)) {
				return vehiculo;
			}
		} throw new VehiculoNotFoundException();
	
	}

	public void descargarCargasVehiculo(String patente) throws VehiculoNotFoundException {
		Vehiculo vehiculo = this.buscarVehiculo(patente);
		vehiculo.setCargas(new ArrayList<Carga>());
	}

	// Transfiere todas las carga de un vehiculo
	public Boolean moverCargaDeUnVehiculoAOtro(String patenteOrigen, String patenteDestino)
			throws VehiculoNotFoundException, SobrepesoException {
			
		Vehiculo v1 = this.buscarVehiculo(patenteOrigen);
		Vehiculo v2 = this.buscarVehiculo(patenteDestino);
		
		if(v1!=null && v2!=null) {
			if (v1.obtenerPesoCargado()<v2.getPesoMaximo()) {
				v2.setCargas(v1.getCargas());
				this.descargarCargasVehiculo(patenteOrigen);
			} else {
				throw new SobrepesoException();
			}
		} else {
			throw new VehiculoNotFoundException();
		}
		return false;	
}


	public Set<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Set<Vehiculo> vehiculos) {
		this.vehiculos=vehiculos;
	}
}
