package CargaDeCamiones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;




public class TestFletes {

	@Test
	public void testQueAgregoUnaCargaCamioneta() throws SobrepesoException {
		Vehiculo camioneta = new Camioneta("ABC123", "Carlos", "Perez", 250 , 1);
		Carga carga = new Carga ("Madera", 200);
		camioneta.agregarCarga(carga);
		assertEquals(200, camioneta.obtenerPesoCargado(), 0.0);
	}
	
	@Test(expected = SobrepesoException.class)
	public void testQueNoAgregoUnaCargaCamionPorSobrepeso() throws SobrepesoException {
		Vehiculo camioneta = new Camioneta("ABC123", "Carlos", "Perez", 250 , 1);
		Carga carga = new Carga ("Madera", 400);
		camioneta.agregarCarga(carga);
	}
	
	@Test
	public void testQueTransfieraUnaCargaDeUnVehiculoAOtro() throws SobrepesoException, VehiculoNotFoundException {
		Vehiculo camion = new Camion("JDK123", "Ricardo", "Aguero", 250, true);
		Vehiculo camioneta = new Camioneta("ABC123", "Carlos", "Perez", 250 , 1);
		Carga carga = new Carga ("Madera", 80);
		Agencia agencia = new Agencia ();
		agencia.agregarVehiculo(camioneta);
		agencia.agregarVehiculo(camion);
		camion.agregarCarga(carga);
		
		assertEquals(camion,agencia.buscarVehiculo("JDK123"));
		assertEquals(camioneta,agencia.buscarVehiculo("ABC123"));
		
		agencia.moverCargaDeUnVehiculoAOtro("JDK123", "ABC123");
		
		assertEquals(0, camion.obtenerPesoCargado(), 0.0);
		assertEquals(80, camioneta.obtenerPesoCargado(), 0.0);
	}
	
	@Test(expected=SobrepesoException.class)
	public void testQueNoPermitaTransfieraUnaCargaAUnVehiculoDestinoPorNoSoportarElPesoDeLasCargas()
			throws SobrepesoException, VehiculoNotFoundException {
		Vehiculo camion = new Camion("JDK123", "Ricardo", "Aguero", 250, true);
		Vehiculo camioneta = new Camioneta("ABC123", "Carlos", "Perez", 50 , 1);
		Carga carga = new Carga ("Madera", 200);
		Agencia agencia = new Agencia ();
		agencia.agregarVehiculo(camioneta);
		agencia.agregarVehiculo(camion);
		camion.agregarCarga(carga);
		agencia.moverCargaDeUnVehiculoAOtro("JDK123", "ABC123");
		

	}

}
