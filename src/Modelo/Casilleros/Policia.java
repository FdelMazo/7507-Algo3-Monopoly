package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Policia implements Casillero {


    public void accionAlCaer(Jugador jugador) {
        Casillero carcel = Tablero.getInstancia().desplazarCasillero(jugador.actual(), -10);
        jugador.caeEn(carcel);
    }

    public String nombre() {  return "Policia";}

    public Paint color() { return Color.LIGHTBLUE;  }
}
