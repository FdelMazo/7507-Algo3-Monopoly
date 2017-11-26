package Vista;


import Modelo.Jugador;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class VistaJugador {
    Circle circulo;
    public VistaJugador(Jugador jugador, Color color) {
       PiezaJugador pieza = new PiezaJugador(color);
       circulo = pieza.getForma();

    }

    public Circle getPieza() {
        return circulo;
    }

}
