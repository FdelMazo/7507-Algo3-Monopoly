package Modelo.Casilleros;

import Modelo.Jugador;
import javafx.scene.paint.Paint;

public interface Casillero {

    void accionAlCaer(Jugador jugador);

    String nombre();

    Paint color();
}
