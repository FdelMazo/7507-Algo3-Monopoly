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


        int x = 600; int x_rel = 0;
        int y = 350; int y_rel = 0;
        Posicion manejadorDePosiciones = new Posicion(120,70);
        manejadorDePosiciones.setInicial(600,350);
        int w = 120;
        int h = 70;
        for (Casillero casillero : tablero.casilleros()) {

            Municipio municipio = Municipio.getInstance();

            int posx= manejadorDePosiciones.getNextX();
            int posy =manejadorDePosiciones.getNextY();

            canvas.getGraphicsContext2D().setStroke(Color.BLACK);
            canvas.getGraphicsContext2D().setFill(casillero.color());
            canvas.getGraphicsContext2D().fillRect(posx,posy,w,h);
            canvas.getGraphicsContext2D().setFill(Color.BLACK);
            canvas.getGraphicsContext2D().setTextBaseline(VPos.CENTER);
            canvas.getGraphicsContext2D().setTextAlign(TextAlignment.CENTER);
            canvas.getGraphicsContext2D().fillText(casillero.nombre(),posx+(w/2),posy+(h/2));

            if(municipio.puedeConstruir(casillero)){
                int cantidadEdificaciones = municipio.edificacionesExistentes((Propiedades)(casillero));
                for (int i = 0 ; i<cantidadEdificaciones ; i++){
                    canvas.getGraphicsContext2D().setStroke(Color.BLACK);
                    canvas.getGraphicsContext2D().setFill(Color.BLUE); // cambiar al color del dueño dps
                    canvas.getGraphicsContext2D().fillRect(posx,posy,10,10);
                    posx +=15;
                    posy +=15;
                }
            }

            manejadorDePosiciones.actualizar();
        }
    }

}
