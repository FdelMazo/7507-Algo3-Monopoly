package Controladores.Botones;

import Controladores.EntradaUsuario;
import Controladores.Sistema;
import Vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorEntrar implements EventHandler<ActionEvent> {

    ArrayList<EntradaUsuario> entradaJugadores;
    Stage stage;
    Scene proximaEscena;

    public ControladorEntrar(Stage stage, Scene proximaEscena, ArrayList<EntradaUsuario> entradaJugadores) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.entradaJugadores = entradaJugadores;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
        Sistema.musicaFondo(getClass());
        for (EntradaUsuario entradaJugador: entradaJugadores) {
            Sistema.dicColores.put(entradaJugador.getNombre(),entradaJugador.getColor());
        }
        ContenedorPrincipal.setJugadores();
    }
}
