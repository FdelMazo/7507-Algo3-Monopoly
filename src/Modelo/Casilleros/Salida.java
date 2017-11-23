package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Salida implements Casillero {

    public void accionAlCaer(Jugador jugador, Tablero tablero) {
        jugador.cobrar(2000);
    }

    public String nombre() {  return "Salida";}

    public Paint color() { return Color.GREEN;  }


}
