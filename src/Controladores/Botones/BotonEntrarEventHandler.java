package Controladores.Botones;

import Vista.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;

    public BotonEntrarEventHandler(Stage stage, Scene proximaEscena) {

        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
        Sistema.reproducir(getClass(), "background.mp3");
        Sistema.imprimir("https://www.youtube.com/user/8BitUniverseMusic");

    }

}
