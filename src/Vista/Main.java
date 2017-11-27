package Vista;

import Controladores.Sistema;
import Modelo.Jugador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        new Sistema();
        primaryStage.setTitle("AlgoPoly");
        primaryStage.getIcons().add(new Image("/Recursos/Imagenes/monopoly_icon.png"));

        ContenedorEntrada contenedorEntrada = new ContenedorEntrada();
        Scene escenaBienvenidos = new Scene (contenedorEntrada);
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal();
        Scene escenaJuego = new Scene(contenedorPrincipal);

        contenedorEntrada.setBotonJugar(primaryStage,escenaJuego);
        primaryStage.setScene(escenaBienvenidos);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}