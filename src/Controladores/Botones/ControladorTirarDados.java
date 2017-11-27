package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Modelo.Dados;
import Controladores.Sistema;
import Modelo.Jugador;
import Vista.VistaTotal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorTirarDados implements EventHandler<ActionEvent> {

    private VistaTotal vistaTotal;

    public ControladorTirarDados(VistaTotal vistaTotal){

        this.vistaTotal = vistaTotal;
    }

    @Override
    public void handle(ActionEvent event) {

        ControladorDeTurno controlador = ControladorDeTurno.getInstance();
        controlador.jugar();
        Jugador actual = controlador.getJugadorActual();

        Dados dados = new Dados();
        int resultado = dados.suma();
        Sistema.imprimir("Sacas : " + resultado);

        vistaTotal.actualizarJugador(actual.getNombre());

        controlador.cambiarTurno();

        }
}

