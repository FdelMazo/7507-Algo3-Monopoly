package Controladores.Botones;

import Modelo.Jugador;
import Vista.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMudo implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        Sistema.mutear();

    }
}


