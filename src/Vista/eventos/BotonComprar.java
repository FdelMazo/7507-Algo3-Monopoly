package Vista.eventos;

import Modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonComprar implements EventHandler<ActionEvent>{

    Jugador jugador;

    public BotonComprar(Jugador jugador){
        this.jugador = jugador;
    }

    @Override
    public void handle(ActionEvent event) {
        //this.jugador.comprar();
    }
}