package Vista;

import Controladores.ControladorDeTurno;
import Modelo.Casilleros.Casillero;
import Modelo.Casilleros.Propiedades;
import Modelo.Jugador;
import Modelo.Municipio;
import Modelo.Tablero;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

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

        int x = 600;
        int y = 350;
        Posicion manejadorDePosiciones = new Posicion(120,70);
        manejadorDePosiciones.setInicial(x,y);

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
