package Vista;

import Modelo.Casilleros.Casillero;
import Modelo.Tablero;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class VistaTablero {

    Tablero tablero;
    Pane pane;
    Canvas canvas;

    VistaTablero(Tablero tablero, Pane pane, Canvas canvas){

        this.tablero = tablero;
        this.pane = pane;
        this.canvas = canvas;
    }

    public void dibujar() {


        int x = 600; int x_rel = 0;
        int y = 350; int y_rel = 0;
        Posicion manejadorDePosiciones = new Posicion(120,70);
        manejadorDePosiciones.setInicial(600,350);

        for (Casillero casillero : tablero.casilleros()) {

            canvas.getGraphicsContext2D().setFill(casillero.color());
            canvas.getGraphicsContext2D().setStroke(Color.BLACK);
            canvas.getGraphicsContext2D().fillRect(manejadorDePosiciones.getNextX(),manejadorDePosiciones.getNextY(),120,70);

            manejadorDePosiciones.actualizar();
        }
    }
}
