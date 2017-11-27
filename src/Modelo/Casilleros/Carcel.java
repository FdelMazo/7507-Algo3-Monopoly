package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Preso;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Carcel implements Casillero {

    public void accionAlCaer(Jugador jugador) {
        jugador.actualizarEstado(new Preso(jugador));
    }

    public String nombre() {  return "Carcel";}

    public Paint color() { return Color.LIGHTBLUE;  }
}
