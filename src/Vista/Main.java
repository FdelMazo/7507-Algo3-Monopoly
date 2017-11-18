package Vista;

import Modelo.Jugador;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    PiezaJugador piezaJugador = new PiezaJugador(660,340,20,20);
    CasilleroVista salida = new CasilleroVista(660, 310, 130, 60, "salida", Color.PALEGOLDENROD);
    CasilleroVista quini6 = new CasilleroVista(530, 310, 130, 60,"quini6",Color.PALEVIOLETRED);
    CasilleroVista bsAsZonaSur = new CasilleroVista(400, 310, 130, 60,"bsAsZonaSur",Color.PALEGOLDENROD);
    CasilleroVista edesur = new CasilleroVista(270, 310, 130, 60,"edesur",Color.PALEVIOLETRED);
    CasilleroVista bsAsZonaNorte = new CasilleroVista(140, 310, 130,60,"bsAsZonaNorte",Color.PALEGOLDENROD);
    CasilleroVista carcel = new CasilleroVista(10, 310, 130, 60,"carcel",Color.PALEVIOLETRED);
    CasilleroVista cordobaSur = new CasilleroVista(10, 250, 130, 60,"cordobaSur",Color.PALEGOLDENROD);
    CasilleroVista avanceDinamico = new CasilleroVista(10, 190, 130,60,"avanceDinamico",Color.PALEVIOLETRED);
    CasilleroVista subte = new CasilleroVista(10, 130, 130, 60,"subte",Color.PALEGOLDENROD);
    CasilleroVista cordobaNorte = new CasilleroVista(10, 70, 130, 60,"cordobaNorte",Color.PALEVIOLETRED);
    CasilleroVista impuestoDeLujo = new CasilleroVista(10, 10, 130, 60,"impuestoDeLujo",Color.PALEGOLDENROD);
    CasilleroVista santaFe = new CasilleroVista(140, 10, 130, 60,"santaFe",Color.PALEVIOLETRED);
    CasilleroVista aysa = new CasilleroVista(270, 10, 130, 60,"aysa",Color.PALEGOLDENROD);
    CasilleroVista saltaNorte = new CasilleroVista(400, 10, 130, 60,"saltaNorte",Color.PALEVIOLETRED);
    CasilleroVista saltaSur = new CasilleroVista(530, 10, 130, 60,"saltaSur",Color.PALEGOLDENROD);
    CasilleroVista policia = new CasilleroVista(660, 10, 130, 60,"policia",Color.PALEVIOLETRED);
    CasilleroVista tren = new CasilleroVista(660, 70, 130, 60,"tren",Color.PALEGOLDENROD);
    CasilleroVista neuquen = new CasilleroVista(660, 130, 130, 60,"neuquen",Color.PALEVIOLETRED);
    CasilleroVista retrocesoDinamico = new CasilleroVista(660, 190, 130, 60,"retrocesoDinamico",Color.PALEGOLDENROD);
    CasilleroVista tucuman = new CasilleroVista(660, 250, 130, 60,"tucuman",Color.PALEVIOLETRED);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("AlgoPoly");
        Group root = new Group();
        Canvas canvas = new Canvas(800, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));

        new AnimationTimer(){
            public  void handle(long currentNanoTime)
            {
                piezaJugador.move(800, 500, 60, 130, 1);
            }
        }.start();


        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc) {
        //Casilleros
        salida.show(gc);
        quini6.show(gc);
        bsAsZonaSur.show(gc);
        edesur.show(gc);
        bsAsZonaNorte.show(gc);
        carcel.show(gc);
        cordobaSur.show(gc);
        avanceDinamico.show(gc);
        subte.show(gc);
        cordobaNorte.show(gc);
        impuestoDeLujo.show(gc);
        santaFe.show(gc);
        aysa.show(gc);
        saltaNorte.show(gc);
        saltaSur.show(gc);
        policia.show(gc);
        tren.show(gc);
        neuquen.show(gc);
        retrocesoDinamico.show(gc);
        tucuman.show(gc);
        //jugadores
        piezaJugador.show(gc);
    }
}