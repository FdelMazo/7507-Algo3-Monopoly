package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Modelo.Jugador;
import Controladores.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorFinalizarTurno implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        ControladorDeTurno controlador = ControladorDeTurno.getInstance();
        controlador.cambiarTurno();
    }

}

