package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Controladores.Sistema;
import Modelo.Casilleros.Casillero;
import Modelo.Jugador;
import Modelo.Tablero;
import Vista.VistaJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorTirarDados implements EventHandler<ActionEvent> {
    static boolean presionado = false;

    @Override
    public void handle(ActionEvent event) {
        if (presionado) {
            Sistema.imprimir("Ya has lanzado... tramposo");
            ControladorDeTurno.getInstance().terminarTurno();
            return;
        }
        ControladorDeTurno controlador = ControladorDeTurno.getInstance();
        Jugador actual = controlador.getJugadorActual();
        Casillero viejo = actual.actual();
        if(!actual.mover()){
            Sistema.imprimir("Presooo");
            ControladorDeTurno.getInstance().terminarTurno();
            return;

        }
        if(!controlador.jugar()){
            Sistema.imprimir("Ya has lanzado... tramposo");
            ControladorDeTurno.getInstance().terminarTurno();
            return;
        }
        int dados = actual.sumaDados();
        Sistema.imprimir(actual.getNombre() + " saca " + dados);
        Sistema.imprimir(controlador.getJugadorActual().getNombre() + " cae en " + controlador.getJugadorActual().actual().nombre());
        VistaJugador vj = VistaJugador.getPorNombre(actual.getNombre());
        vj.moverDesdeHasta(viejo, actual.actual());
        if (actual.doble()) {
            Sistema.reproducir(this.getClass(), "woah3.mp3");
            Sistema.imprimir(actual.getNombre() + " sacó doble! \nLanza nuevamente");
            return;
        }
        presionado = true;
    }

    public static void reset(){
        presionado = false;
    }
}
