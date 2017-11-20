package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class PropiedadesVariasTest {

    @Test
    public void JugadorVendeSuUnicaPropiedadTrenParaPagarSolicitado() {

        int numDado = 4;
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        Servicio servicio = new Servicio("Tren",38000,450,800,"Subte");
        jugador.caeEn(servicio,numDado,tablero);
        jugador.solicitarDinero(70000);
        Assert.assertEquals(24300,jugador.capital());
    }

    @Test
    public void JugadorIntercambiaPropiedadConOtroJugadorYAhoraElNuevoDueniooCobraElAlquiler(){

        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Carlos");
        Jugador jugador2 = new Jugador("Mario");
        Servicio servicio1 = new Servicio("Tren",38000,450,800,"Subte");
        Servicio servicio2 = new Servicio("Subte",40000,600,1100,"Tren");
        jugador1.caeEn(servicio1,3,tablero);
        jugador2.caeEn(servicio2,3,tablero);
        jugador1.intercambiarPropiedades(jugador2);
        Jugador jugador3 = new Jugador("Mario");
        jugador3.caeEn(servicio1,2,tablero);
        Assert.assertEquals(60900,jugador2.capital());
    }

}
