package Vista;


import Modelo.Jugador;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;


public class VistaJugador {

    Color color;
    Canvas canvas;
    int X;
    int Y;
    int R = 15;
    Posicion pos;
    Jugador jugador;

    public VistaJugador(Jugador jugador, Color color, Canvas canvas , int x , int y) {

        this.X = x;
        this.Y = y;
        this.color = color;
        this.canvas = canvas;
        this.pos = new Posicion(120,70);
        this.pos.setInicial(X,Y);
        this.jugador = jugador;
    }

    public void dibujar() {

        canvas.getGraphicsContext2D().setFill(color);
        canvas.getGraphicsContext2D().setStroke(Color.BLACK);
        canvas.getGraphicsContext2D().fillOval(X,Y,this.R,this.R);

    }

    public boolean esElJugador(String nombreJugador){
        return nombreJugador == jugador.getNombre();
    }

    public void mover(){

        X = pos.getNextY();
        Y = pos.getNextY();

        this.dibujar();

    }



}
