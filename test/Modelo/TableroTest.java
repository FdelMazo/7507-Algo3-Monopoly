package Modelo;

import Modelo.Casilleros.Casillero;
import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

    @Test
    public void testAvanzar3PasosEnTablero() {
        Jugador jugador = new Jugador("Maria");
        Tablero tablero = new Tablero();
        Casillero salida = tablero.salida();
        tablero.desplazarCasillero(salida, 3, jugador);
        jugador.actual();
    }

}
