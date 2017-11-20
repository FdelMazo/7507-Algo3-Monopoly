package Vista;

import Modelo.Casilleros.Casillero;
import Modelo.Tablero;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;
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

    public void dibujar() {

        canvas.getGraphicsContext2D().setFill(Color.LIGHTYELLOW);
        canvas.getGraphicsContext2D().fillRect(0, 0, 720, 420);
        pane.getChildren().add(canvas);

        int x = 600; int x_rel = 0;
        int y = 350; int y_rel = 0;

        for (Casillero casillero : tablero.casilleros()) {

            Rectangle rectangle = new Rectangle(120, 70);
                Text text = new Text(casillero.nombre());
                text.relocate(x+10, y+25);

            rectangle.setStroke(Color.BLACK);
            rectangle.setFill(Color.RED);
            rectangle.relocate(x, y);

            pane.getChildren().addAll(rectangle,text);
            if (x_rel==0 & y_rel>0){y_rel-=1; y+=70;}
            if (y_rel==5){x_rel-=1; x+=120;}
            if (x_rel==5){y_rel+=1; y-=70;}
            if (y_rel==0){x_rel+=1; x-=120;}
        }
    }

}
