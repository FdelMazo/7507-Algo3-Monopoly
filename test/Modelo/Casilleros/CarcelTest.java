package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class CarcelTest {

    @Test
    public void testCarcelPrimeraNocheNoPermiteMovimiento(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("man");
        Carcel carcel = new Carcel();
        jugador.caeEn(carcel,tablero);
        Assert.assertFalse(jugador.mover());

    }

    @Test
    public void testCarcelPermiteSalidaDespuesDelPrimerTurno() {

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("man");
        Carcel carcel = new Carcel();
        jugador.caeEn(carcel,  tablero);
        jugador.mover();
        Assert.assertTrue(jugador.mover());
    }

    @Test
    public void testCarcelPermiteSalidaPasadas3Noches(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("man");
        Carcel carcel = new Carcel();
        jugador.caeEn(carcel,  tablero);
        jugador.mover();
        jugador.mover();
        jugador.mover();
        Assert.assertTrue(jugador.mover());
    }

}
