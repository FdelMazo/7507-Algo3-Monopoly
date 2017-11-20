package Vista;

import Modelo.Tablero;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.awt.*;

public class VistaTablero {

    Tablero tablero;
    Canvas canvas;
    Pane pane;

    VistaTablero(Tablero tablero, Canvas canvas , Pane pane){

        this.tablero = tablero;
        this.canvas = canvas;
        this.pane = pane;
    }

    public void dibujar(){

        canvas.getGraphicsContext2D().setFill(Color.LIGHTYELLOW);
        canvas.getGraphicsContext2D().fillRect(0, 0, 700, 500);
        Circle circle1 = new Circle(50);
        circle1.setStroke(Color.GREEN);
        circle1.setFill(Color.GREEN.deriveColor(1, 1, 1, 0.7));
        circle1.relocate(0, 0);
        pane.getChildren().addAll(canvas,circle1);

    }
}
