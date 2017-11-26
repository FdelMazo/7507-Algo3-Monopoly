package Vista.Figura;

import Modelo.Figura.Figura;
import javafx.animation.TranslateTransition;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class FiguraVista {

    private final Figura figura;
    GraphicsContext gc;

    public FiguraVista(Figura figura, GraphicsContext gc) {
        this.gc = gc;
        this.figura = figura;
    }

    public void draw() {
        this.drawShapes(gc);
    }

    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillOval(figura.getPosicionFigura().getX(), figura.getPosicionFigura().getX(), 20, 20);
    }

    public void mover() {
        figura.move();
        gc.fillOval(figura.getPosicionFigura().getX(), figura.getPosicionFigura().getX(), 20, 20);
    }

}
