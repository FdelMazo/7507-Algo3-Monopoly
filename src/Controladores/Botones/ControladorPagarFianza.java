package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Controladores.Sistema;
import Modelo.Casilleros.Casillero;
import Modelo.Jugador;
import Vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorPagarFianza implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        ControladorDeTurno controlador = ControladorDeTurno.getInstance();

        Jugador jugador = controlador.getJugadorActual();

        if ( jugador.estaPreso()){
            if(jugador.pagarFianza()) {
                Sistema.imprimir("\tLibreee");
            }
            else{
                Sistema.imprimir("\tNo se puede pagar la fianza");
            }
        }
        else {
            Sistema.imprimir("\tQue no estas preso!");
        }
        ContenedorPrincipal.actualizar();
    }

}
