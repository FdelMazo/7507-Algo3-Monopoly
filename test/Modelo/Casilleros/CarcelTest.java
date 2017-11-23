package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class CarcelTest {

    @Test
    public void testCarcelPrimeraNocheNoPermiteMovimiento(){

        Tablero tablero = Tablero.getInstancia();
        Jugador jugador = new Jugador("man");
        Carcel carcel = new Carcel();
        jugador.caeEn(carcel);
        Assert.assertFalse(jugador.mover());

    }

    @Test
    public void testCarcelPermiteSalidaDespuesDelPrimerTurno() {

        Tablero tablero = Tablero.getInstancia();
        Jugador jugador = new Jugador("man");
        Carcel carcel = new Carcel();
        jugador.caeEn(carcel);
        jugador.mover();
        Assert.assertTrue(jugador.mover());
    }

    @Test
    public void testCarcelPermiteSalidaPasadas3Noches(){

        Tablero tablero = Tablero.getInstancia();
        Jugador jugador = new Jugador("man");
        Carcel carcel = new Carcel();
        jugador.caeEn(carcel);
        jugador.mover();
        jugador.mover();
        jugador.mover();
        Assert.assertTrue(jugador.mover());
    }

}
