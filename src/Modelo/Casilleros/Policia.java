package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Policia implements Casillero {


    public void accionAlCaer(Jugador jugador, int numDado, Tablero tablero) {
        Casillero carcel = tablero.desplazarCasillero(this, -10, jugador);
        jugador.caeEn(carcel, numDado, tablero);
    }

    public String nombre() {  return "Policia";}

    public Paint color() { return Color.LIGHTBLUE;  }
}
