package Modelo;

import Modelo.Casilleros.Casillero;
import Modelo.Casilleros.Servicio;
import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

    @Test
    public void testAvanzar3PasosEnTableroCaeEnEdesur() {
        Jugador jugador = new Jugador("Jugador 1");
        Tablero tablero = new Tablero();
        Casillero salida = tablero.salida();
        Servicio deberiaSerEdesur = (Servicio) tablero.desplazarCasillero(salida, 3, jugador);
        Assert.assertEquals("Edesur", deberiaSerEdesur.nombre());
    }

    @Test
    public void testAvanzar8yRetroceder5PasosEnTableroCaeEnEdesur() {
        Jugador jugador = new Jugador("Jugador 1");
        Tablero tablero = new Tablero();
        Casillero salida = tablero.salida();
        Servicio deberiaSerSubte = (Servicio) tablero.desplazarCasillero(salida, 8, jugador);
        Assert.assertEquals("Subte", deberiaSerSubte.nombre());
        Servicio deberiaSerEdesur = (Servicio) tablero.desplazarCasillero(deberiaSerSubte, -5, jugador);
        Assert.assertEquals("Edesur", deberiaSerEdesur.nombre());
    }

    @Test
    public void testPegarVueltaEnteraPasaPorSalidaYSumaCapital() {
        Jugador jugador = new Jugador("Jugador 1");
        Tablero tablero = new Tablero();
        Casillero salida = tablero.salida();
        Servicio deberiaSerAysa = (Servicio) tablero.desplazarCasillero(salida, 12, jugador);
        Assert.assertEquals("Aysa", deberiaSerAysa.nombre());
        Servicio deberiaSerEdesur = (Servicio) tablero.desplazarCasillero(deberiaSerAysa, 11, jugador);
        Assert.assertEquals("Edesur", deberiaSerEdesur.nombre());
        Assert.assertEquals(100000+2000, jugador.capital());
    }

}
