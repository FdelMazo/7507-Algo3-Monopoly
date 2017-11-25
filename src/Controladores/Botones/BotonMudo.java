package Controladores.Botones;

import Controladores.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMudo implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        Sistema.frenarSonidos();
        Sistema.mutear();
    }
}


