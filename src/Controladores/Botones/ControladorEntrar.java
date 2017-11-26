package Controladores.Botones;

import Controladores.EntradaUsuario;
import Controladores.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

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
        Sistema.musicaFondo(getClass());
    }
}
