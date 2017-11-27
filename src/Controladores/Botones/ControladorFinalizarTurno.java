package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Modelo.Jugador;
import Controladores.Sistema;
import Vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorFinalizarTurno implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        ControladorDeTurno.getInstance().terminarTurno();
    }

}

