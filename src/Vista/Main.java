package Vista;

import Modelo.Jugador;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    PiezaJugador piezaJugador = new PiezaJugador(660,340,20,20);

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
        for(int i=0 ; i<1 ;i++) {
            piezaJugador.move(800, 500, 60, 130, 1);
        }
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc) {
        //hilera de arriba
        gc.setFill(Color.PALEGOLDENROD);
        gc.fillRect(10, 10, 130, 60);
        gc.setFill(Color.PALEVIOLETRED);
        gc.fillRect(140, 10, 130, 60);
        gc.setFill(Color.PALEGOLDENROD);
        gc.fillRect(270, 10, 130, 60);
        gc.setFill(Color.PALEVIOLETRED);
        gc.fillRect(400, 10, 130, 60);
        gc.setFill(Color.PALEGOLDENROD);
        gc.fillRect(530, 10, 130, 60);
        gc.setFill(Color.PALEVIOLETRED);
        gc.fillRect(660, 10, 130, 60);
        //hilera de abajo
        gc.setFill(Color.PALEVIOLETRED);
        gc.fillRect(10, 310, 130, 60);
        gc.setFill(Color.PALEGOLDENROD);
        gc.fillRect(140, 310, 130, 60);
        gc.setFill(Color.PALEVIOLETRED);
        gc.fillRect(270, 310, 130, 60);
        gc.setFill(Color.PALEGOLDENROD);
        gc.fillRect(400, 310, 130, 60);
        gc.setFill(Color.PALEVIOLETRED);
        gc.fillRect(530, 310, 130, 60);
        gc.setFill(Color.PALEGOLDENROD);
        gc.fillRect(660, 310, 130, 60);
        //hileras izquierda
        gc.setFill(Color.PALEVIOLETRED);
        gc.fillRect(10, 70, 130, 60);
        gc.setFill(Color.PALEGOLDENROD);
        gc.fillRect(10, 130, 130, 60);
        gc.setFill(Color.PALEVIOLETRED);
        gc.fillRect(10, 190, 130, 60);
        gc.setFill(Color.PALEGOLDENROD);
        gc.fillRect(10, 250, 130, 60);
        //hileras derecha
        gc.setFill(Color.PALEGOLDENROD);
        gc.fillRect(660, 70, 130, 60);
        gc.setFill(Color.PALEVIOLETRED);
        gc.fillRect(660, 130, 130, 60);
        gc.setFill(Color.PALEGOLDENROD);
        gc.fillRect(660, 190, 130, 60);
        gc.setFill(Color.PALEVIOLETRED);
        gc.fillRect(660, 250, 130, 60);
        //jugadores
        piezaJugador.show(gc);

    }
}