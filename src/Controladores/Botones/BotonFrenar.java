package Controladores.Botones;

import Vista.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonFrenar implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        Sistema.frenarSonidos();
    }
}


