package Vista;

import Modelo.Casilleros.Casillero;
import Modelo.Jugador;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class VisorCasillero {
    public VisorCasillero(Casillero casillero, Pane pane) {
        int x = 310;
        int y = 240;
        TextFlow flow = new TextFlow();
        Label titulo = new Label(casillero.nombre());
        titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        flow.getChildren().addAll(titulo);
        flow.relocate(x, y);
        pane.getChildren().add(flow);
    }

}
