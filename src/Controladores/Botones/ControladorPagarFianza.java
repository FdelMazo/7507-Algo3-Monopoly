package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Controladores.Sistema;
import Modelo.Casilleros.Casillero;
import Modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorPagarFianza implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        ControladorDeTurno controlador = ControladorDeTurno.getInstance();

        Jugador jugador = controlador.getJugadorActual();
        Casillero actual = jugador.actual();

        if ( jugador.estaPreso()){
            if(jugador.pagarFianza()) {
                Sistema.imprimir(jugador.getNombre() + " , eres libre");
            }
            else{
                Sistema.imprimir(jugador.getNombre() + "  no podés pagar la fianza");
            }
        }
        else {
            Sistema.imprimir(jugador.getNombre() + " No estás preso");
        }
    }

}
