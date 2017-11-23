package Controladores;

import Modelo.Jugador;
import Vista.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonSonido implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        Sistema.mutear();

    }
}


