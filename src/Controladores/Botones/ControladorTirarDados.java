package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Controladores.Sistema;
import Modelo.Casilleros.Casillero;
import Modelo.Jugador;
import Modelo.Tablero;
import Vista.Boton;
import Vista.VistaJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorTirarDados implements EventHandler<ActionEvent> {
    static boolean presionado = false;
    static Boton boton;

    public ControladorTirarDados (Boton unBoton){
        this.boton = unBoton;
    }

    @Override
    public void handle(ActionEvent event) {
        if (presionado) {
            ControladorDeTurno.getInstance().terminarTurno();
            return;
        }
        ControladorDeTurno controlador = ControladorDeTurno.getInstance();
        Jugador actual = controlador.getJugadorActual();
        Casillero viejo = actual.actual();

        Sistema.imprimir("\tSaca " + actual.lanzarDados());
        if(!actual.mover()){
            boton.setText("Finalizar Turno");
            Sistema.imprimir("\tPresooo");
            ControladorDeTurno.getInstance().terminarTurno();
            return;
        }
        if(!controlador.jugar()){
            ControladorDeTurno.getInstance().terminarTurno();
            return;
        }

        int dados = actual.sumaDados();
        Sistema.imprimir("\tCae en " + controlador.getJugadorActual().actual().nombre());
        VistaJugador vj = VistaJugador.getPorNombre(actual.getNombre());
        vj.moverDesdeHasta(viejo, actual.actual());
        if (actual.doble()) {
            Sistema.reproducir(this.getClass(), "woah3.mp3");
            Sistema.imprimir("\tSacó doble! \n\tLanza nuevamente");
            return;
        }
        presionado = true;
        boton.setText("Finalizar Turno");
    }

    public static void reset(){
        boton.setText("Tirar Dados");
        presionado = false;
    }
}
