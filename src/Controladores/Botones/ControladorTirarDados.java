package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Controladores.Sistema;
import Modelo.Jugador;
import Vista.VistaJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorTirarDados implements EventHandler<ActionEvent> {
    static boolean presionado = false;

    @Override
    public void handle(ActionEvent event) {
        if (presionado) {
            Sistema.imprimir("Ya has lanzado... tramposo");
            return;
        }
        ControladorDeTurno controlador = ControladorDeTurno.getInstance();
        Jugador actual = controlador.getJugadorActual();
        if(!controlador.jugar()){
            controlador.cambiarTurno();
            return;
        }
        int dados = actual.sumaDados();
        Sistema.imprimir(actual.getNombre() + " saca " + dados);
        Sistema.imprimir(controlador.getJugadorActual().getNombre() + " cae en " + controlador.getJugadorActual().actual().nombre());
        VistaJugador vj = VistaJugador.getPorNombre(actual.getNombre());
        vj.mover(dados);
        if (actual.doble()) {
            Sistema.imprimir(actual.getNombre() + " sacó doble! \nLanza nuevamente");
            return;
        }
        presionado = true;
    }

    public static void reset(){
        presionado = false;
    }
}
