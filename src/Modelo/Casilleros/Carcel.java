package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import Modelo.Preso;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Carcel implements Casillero {

    public void accionAlCaer(Jugador jugador, int numDado, Tablero tablero) {
        jugador.actualizarEstado(new Preso());
    }


    public String nombre() {  return "Carcel";}

    public Paint color() { return Color.LIGHTBLUE;  }
}
