package Vista;

import Modelo.Jugador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("AlgoPoly");

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(primaryStage);
        Scene escenaJuego = new Scene(contenedorPrincipal);

        ContenedorEntrada contenedorEntrada = new ContenedorEntrada(primaryStage,escenaJuego);
        Scene escenaBienvenidos = new Scene (contenedorEntrada);

        contenedorPrincipal.setJugadores(contenedorEntrada.getJugadores());

        primaryStage.setScene(escenaBienvenidos);
        primaryStage.setResizable(false);

        primaryStage.show();
    }
}