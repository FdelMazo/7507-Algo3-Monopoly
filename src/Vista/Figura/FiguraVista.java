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
    Circle figuraVista;
    TranslateTransition tt;

    public FiguraVista(Figura figura) {
        this.gc = gc;
        this.figura = figura;
        this.figuraVista = new Circle(20, Color.RED);
        this.draw();
        this.tt = new TranslateTransition(Duration.millis(2000), this.figuraVista);
    }

    public void draw() {
        this.drawShapes();
    }

    private void drawShapes() {
        figuraVista.setCenterX(figura.getPosicionFigura().getX());
        figuraVista.setCenterY(figura.getPosicionFigura().getY());
    }

    public void mover() {
        figura.move();
        tt.setToX(figura.getPosicionFigura().getX());
        tt.setToY(figura.getPosicionFigura().getY());
        tt.play();
    }

}
