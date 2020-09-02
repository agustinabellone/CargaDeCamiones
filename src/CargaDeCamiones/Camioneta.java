package CargaDeCamiones;

public class Camioneta extends Vehiculo {

	private Integer modelo ;
	
	public Camioneta (String patente,String nombreTitular, String apellidoTitular,  Integer pesoMaximo, Integer modelo) {
		super(patente, nombreTitular, apellidoTitular, pesoMaximo);
		this.modelo= modelo;
	}


	/*Las camionetas soportan cargas hasta su pesoMaximo*/
	


	public Integer getModelo() {
		return modelo;
	}

	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}

	@Override
	public Boolean agregarCarga(Carga carga) throws SobrepesoException {
		if (this.getPesoMaximo()< carga.getPeso()) {
			throw new SobrepesoException();
		}  if ((this.obtenerPesoCargado() + carga.getPeso()) > this.getPesoMaximo()) {
			throw new SobrepesoException();
		}
		return this.getCargas().add(carga);
		
	}
	
	

}
