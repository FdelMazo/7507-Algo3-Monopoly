package Vista;


import Modelo.Jugador;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class VistaJugador {

    Circle circulo;
    Color color;

    public VistaJugador(Jugador jugador, Color color) {

        circulo = new Circle(12);
        circulo.setStroke(Color.BLACK);
        circulo.setFill(color);
        this.color = color;

    }

    public Circle getPieza() {
        return circulo;
    }

}
