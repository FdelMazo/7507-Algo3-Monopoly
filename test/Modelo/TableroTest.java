package Modelo;

import Modelo.Casilleros.Casillero;
import Modelo.Casilleros.Servicio;
import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

    @Test
    public void testAvanzar3PasosEnTableroCaeEnEdesur() {
        Jugador jugador = new Jugador("Jugador 1");
        Tablero tablero = Tablero.getInstancia();
        jugador.asignarCasillero(tablero.salida());
        Servicio deberiaSerEdesur = (Servicio) tablero.desplazarCasillero(jugador, 3);
        Assert.assertEquals("Edesur", deberiaSerEdesur.nombre());
    }

    @Test
    public void testAvanzar8yRetroceder5PasosEnTableroCaeEnEdesur() {
        Jugador jugador = new Jugador("Jugador 1");
        Tablero tablero = Tablero.getInstancia();
        jugador.asignarCasillero(tablero.salida());
        Servicio deberiaSerSubte = (Servicio) tablero.desplazarCasillero(jugador, 8);
        jugador.caeEn(deberiaSerSubte, tablero);
        Assert.assertEquals("Subte", deberiaSerSubte.nombre());
        Servicio deberiaSerEdesur = (Servicio) tablero.desplazarCasillero(jugador, -5);
        Assert.assertEquals("Edesur", deberiaSerEdesur.nombre());
    }

    @Test
    public void testPegarVueltaEnteraPasaPorSalidaYSumaCapital() {
        Jugador jugador = new Jugador("Jugador 1");
        Tablero tablero = Tablero.getInstancia();
        jugador.asignarCasillero(tablero.salida());
        tablero.desplazarCasillero(jugador, 21);
        Assert.assertEquals(100000+2000, jugador.capital());
    }

}
