package Modelo.Casilleros;

import Modelo.Casilleros.Barrio;
import Modelo.Casilleros.Carcel;
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
        jugador.caeEn(carcel,6,tablero);
        Assert.assertFalse(jugador.mover());

    }

    @Test
    public void testCarcelPermiteSalidaDespuesDelPrimerTurno() {

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("man");
        Carcel carcel = new Carcel();
        jugador.caeEn(carcel, 6, tablero);
        jugador.mover();
        Assert.assertTrue(jugador.mover());
    }

}
