package Vista.eventos;

import Modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonVender implements EventHandler<ActionEvent>{

    Jugador jugador;

    public BotonVender(Jugador jugador){
        this.jugador = jugador;
    }

    @Override
    public void handle(ActionEvent event) {
        //this.jugador.vender();
    }
}
