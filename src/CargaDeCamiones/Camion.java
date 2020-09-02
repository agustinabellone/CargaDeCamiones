package CargaDeCamiones;

public class Camion extends Vehiculo {
	private Boolean tieneAcoplado;

	
	public Camion(String patente, String nombreTitular, String apellidoTitular, Integer pesoMaximo,
			Boolean tieneAcoplado) {
		super(patente, nombreTitular, apellidoTitular, pesoMaximo);
		this.tieneAcoplado=tieneAcoplado;
	}

	/* Los camiones con acoplados soportan el doble de su pesoMaximo y si no tienen acoplados soportan
	 * hasta el pesoMaximo
	 */
	public Boolean getTieneAcoplado() {
		return tieneAcoplado;
	}


	public void setTieneAcoplado(Boolean tieneAcoplado) {
		this.tieneAcoplado = tieneAcoplado;
	}

	@Override
	public Boolean agregarCarga(Carga carga) throws SobrepesoException {
		if(this.getTieneAcoplado()==true) {
			if (this.getPesoMaximo()*2< carga.getPeso()) {
				throw new SobrepesoException();
			}  if ((this.obtenerPesoCargado() + carga.getPeso()) > this.getPesoMaximo()*2) {
				throw new SobrepesoException();
			}
		} else {
			if (this.getPesoMaximo()< carga.getPeso()) {
				throw new SobrepesoException();
			}  if ((this.obtenerPesoCargado() + carga.getPeso()) > this.getPesoMaximo()) {
				throw new SobrepesoException();
			}
		}
		
		return this.getCargas().add(carga);
	}
}

