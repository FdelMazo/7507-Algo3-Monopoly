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
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

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

        Rectangle rectangle1 = new Rectangle(110,70);
        rectangle1.setStroke(Color.BLACK);
        rectangle1.setFill(Color.RED);
        rectangle1.relocate(0,0);

        Rectangle rectangle2 = new Rectangle(110,70);
        rectangle2.setStroke(Color.BLACK);
        rectangle2.setFill(Color.BLUEVIOLET);
        rectangle2.relocate(110,0);

        Rectangle rectangle3 = new Rectangle(110,70);
        rectangle3.setStroke(Color.BLACK);
        rectangle3.setFill(Color.RED);
        rectangle3.relocate(220,0);

        pane.getChildren().addAll(canvas,rectangle1,rectangle2,rectangle3);
    }
}
