package Modelo;

import Modelo.Casilleros.Casillero;
import org.junit.Assert;
import org.junit.Test;

public class TurnoTest {

    @Test
    public void testTurnoDesplazaJugador(){
        Tablero tablero = Tablero.getInstancia();
        Jugador jugador = new Jugador("Jugador 1");
        jugador.asignarCasillero(tablero.salida());
        Casillero viejo = jugador.actual();
        new Turno(tablero, jugador);
        Casillero nuevo = jugador.actual();
        Assert.assertFalse(viejo == nuevo );
    }

}
