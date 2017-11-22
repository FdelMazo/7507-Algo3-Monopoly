package Vista;

import Modelo.Jugador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("AlgoPoly");

        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Jugador jugador1 = new Jugador("Jorge");
        Jugador jugador2 = new Jugador("batman");
        Jugador jugador3 = new Jugador("Kahlan");

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(listaJugadores,primaryStage);
        Scene escenaJuego = new Scene(contenedorPrincipal,1200,700);

        ContenedorEntrada contenedorEntrada = new ContenedorEntrada(primaryStage,escenaJuego);
        Scene escenaBienvenidos = new Scene (contenedorEntrada,500,500);

        primaryStage.setScene(escenaBienvenidos);
        primaryStage.setResizable(false);

        primaryStage.show();
    }
}