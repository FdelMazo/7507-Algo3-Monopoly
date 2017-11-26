package Vista;

import Modelo.Casilleros.Casillero;
import Modelo.Tablero;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class VistaTablero {

    Tablero tablero;
    Canvas fondo = new Canvas(800,500);
    Pane pane;

    VistaTablero(Tablero tablero, Pane pane){
        this.tablero = tablero;
        this.pane = pane;
    }

    public void dibujar() {
        fondo.getGraphicsContext2D().setFill(Color.LIGHTYELLOW);
        fondo.getGraphicsContext2D().fillRect(0, 0, 720, 420);

        int x = 600; int x_rel = 0;
        int y = 350; int y_rel = 0;
        Posicion manejadorDePosiciones = new Posicion(120,70);
        manejadorDePosiciones.setInicial(600,350);

        for (Casillero casillero : tablero.casilleros()) {

            Rectangle rectangle = new Rectangle(120, 70);
            Text text = new Text(casillero.nombre());
            text.relocate(manejadorDePosiciones.getNextX()+10, manejadorDePosiciones.getNextY()+25);

            rectangle.setStroke(Color.BLACK);
            rectangle.setFill(casillero.color());
            rectangle.relocate(manejadorDePosiciones.getNextX(), manejadorDePosiciones.getNextY());

            pane.getChildren().addAll(rectangle,text);
            manejadorDePosiciones.actualizar();
        }
    }
}
