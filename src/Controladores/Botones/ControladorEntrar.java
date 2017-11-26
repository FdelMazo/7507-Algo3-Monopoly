package Controladores.Botones;

import Controladores.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorEntrar implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;

    public ControladorEntrar(Stage stage, Scene proximaEscena) {

        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
        Sistema.reproducir(getClass(), "background.mp3");
    }

}
