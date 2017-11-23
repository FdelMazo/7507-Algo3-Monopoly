package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ImpuestoAlLujo implements Casillero {

    public void accionAlCaer(Jugador jugador, Tablero tablero) {
        double impuesto = jugador.capital() * 0.1 ;
        jugador.solicitarDinero(impuesto); /*falta especificar cuando el jugador no tiene dinero suficiente*/

    }

    public String nombre() {  return "Impuesto Al Lujo";}

    public Paint color() { return Color.LIME;  }

}
