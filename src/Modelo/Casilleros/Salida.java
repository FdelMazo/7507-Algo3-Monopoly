package Modelo.Casilleros;

import Modelo.Jugador;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Salida implements Casillero {

    public void accionAlCaer(Jugador jugador) {
    }

    public String nombre() {  return "Salida";}

    public Paint color() { return Color.LIGHTYELLOW;  }


}
