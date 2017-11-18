package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class PoliciaTest {

    @Test
    public void testPoliciaLlevaAJugadorACarcelYNoSePuedeMover(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Casillero salida = tablero.salida();
        Policia policia = (Policia) tablero.desplazarCasillero(salida, 15, jugador1);
        Carcel carcel = (Carcel) tablero.desplazarCasillero(salida, 5, jugador2);
        jugador1.caeEn(policia, 0, tablero);
        Assert.assertFalse(jugador1.actual() == policia);
        Assert.assertTrue(jugador1.actual() == carcel);
        Assert.assertFalse(jugador1.mover());
    }


}
