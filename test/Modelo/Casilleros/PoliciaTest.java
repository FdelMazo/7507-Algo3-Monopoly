package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class PoliciaTest {

    @Test
    public void testPoliciaLlevaAJugadorACarcelYNoSePuedeMover(){
        Tablero tablero = Tablero.getInstancia();
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Casillero salida = tablero.salida();
        jugador1.asignarCasillero(salida);
        jugador2.asignarCasillero(salida);
        Policia policia = (Policia) tablero.desplazarCasillero(jugador1, 15);
        Carcel carcel = (Carcel) tablero.desplazarCasillero(jugador2, 5);
        jugador1.caeEn(policia);
        Assert.assertFalse(jugador1.actual() == policia);
        Assert.assertTrue(jugador1.actual() == carcel);
        Assert.assertFalse(jugador1.mover());
    }


}
