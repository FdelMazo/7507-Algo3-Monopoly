package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import javafx.scene.paint.Paint;

public interface Casillero {

    void accionAlCaer(Jugador jugador, Tablero tablero);

    String nombre();

    Paint color();
}
