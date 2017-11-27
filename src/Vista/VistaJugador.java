package Vista;


import Modelo.Jugador;
import Modelo.Tablero;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Circle;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class VistaJugador {

    Posicion posicion;
    Color color;
    Pane canvas;
    int X;
    int Y;
    Jugador jugador;
    Circle circulo;
    static HashMap<String, VistaJugador > diccionarioNombres = new HashMap<>();

    public VistaJugador(Jugador jugador, Color color, Pane canvas , int x , int y) {
        this.X = x;
        this.Y = y;
        this.color = color;
        this.canvas = canvas;
        this.posicion = new Posicion(120,70);
        posicion.setInicial(x,y);
        circulo = new Circle(12);
        circulo.setStroke(Color.BLACK);
        circulo.setFill(color);
        canvas.getChildren().add(circulo);
        diccionarioNombres.put(jugador.getNombre(), this);
    }

    public void dibujar() {
        circulo.relocate(X,Y);
    }

    public void mover(int pasos){
        for (int i = 0; i<pasos; i++) {
            posicion.actualizar();
            X = posicion.getNextX();
            Y = posicion.getNextY();
            this.dibujar();
        }
    }

    public static VistaJugador getPorNombre(String unNombre){
        return diccionarioNombres.get(unNombre);
    }



}
