package Vista;

import javafx.animation.TranslateTransition;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class PiezaJugador {

    Circle circulo;

    public PiezaJugador(Color color) {
        circulo = new Circle(12);
        circulo.setStroke(Color.BLACK);
        circulo.setFill(color);
    }

    public Circle getForma() {
        return circulo;
    }
}
