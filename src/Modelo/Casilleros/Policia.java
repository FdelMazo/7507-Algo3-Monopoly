package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Policia implements Casillero {


    public void accionAlCaer(Jugador jugador, Tablero tablero) {
        Casillero carcel = tablero.desplazarCasillero(jugador, -10);
        jugador.caeEn(carcel, tablero);
    }

    public String nombre() {  return "Policia";}

    public Paint color() { return Color.LIGHTBLUE;  }
}
