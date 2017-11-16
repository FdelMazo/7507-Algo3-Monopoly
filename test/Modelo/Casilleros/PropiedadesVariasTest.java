package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class PropiedadesVariasTest {

    @Test
    public void JugadorVendeSuUnicaPropiedadTRenesParaPagarSolicitado() {

        int numDado = 4;
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        Servicio servicio = new Servicio("Trenes",38000,450,800,"Subte");
        jugador.caeEn(servicio,numDado,tablero);
        jugador.solicitar_dinero(70000);
        Assert.assertEquals(24300,jugador.capital());
    }

}
