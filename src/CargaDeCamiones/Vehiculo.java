package CargaDeCamiones;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehiculo {
	private String patente;
	private String apellidoTitular;
	private String nombreTitular;
	private List<Carga> cargas;
	private Integer pesoMaximo;
	
	
	
	public Vehiculo(String patente,String nombreTitular, String apellidoTitular, Integer pesoMaximo) {
		this.patente=patente;
		this.nombreTitular=nombreTitular;
		this.apellidoTitular=apellidoTitular;
		this.pesoMaximo=pesoMaximo;
		cargas = new ArrayList<>();
	}
	

	
	//obtiene el peso cargado del vehiculo
	public Integer obtenerPesoCargado() {
		Integer cargaTotal = 0;
			for (Carga cargas : cargas){
				  cargaTotal += cargas.getPeso();
				}
			return cargaTotal;
			}
	
	public abstract Boolean agregarCarga(Carga carga) throws SobrepesoException;
			
	
	public String getApellidoTitular() {
		return apellidoTitular;
	}

	public void setApellidoTitular(String apellidoTitular) {
		this.apellidoTitular = apellidoTitular;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}
	
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	public Integer getPesoMaximo() {
		return pesoMaximo;
	}
	public void setPesoMaximo(Integer pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public List<Carga> getCargas() {
		return cargas;
	}

	public void setCargas(List<Carga> cargas) {
		this.cargas = cargas;
	}



	@Override
	public String toString() {
		return "Vehiculo [patente=" + patente + ", apellidoTitular=" + apellidoTitular + ", nombreTitular="
				+ nombreTitular + ", cargas=" + cargas + ", pesoMaximo=" + pesoMaximo + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patente == null) ? 0 : patente.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vehiculo))
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (patente == null) {
			if (other.patente != null)
				return false;
		} else if (!patente.equals(other.patente))
			return false;
		return true;
	}

}
