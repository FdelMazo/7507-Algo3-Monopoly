package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Modelo.Casilleros.Casillero;
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
        Jugador anteriorJugador = null;
        Jugador actual = controlador.getJugadorActual();
        if (anteriorJugador != actual) {
            Dados dados = new Dados();
            int resultado = dados.suma();
            Sistema.imprimir("Sacas : " + resultado);
            Sistema.imprimir("Caes en: " + controlador.getJugadorActual().actual().nombre());
            vistaTotal.actualizarJugador(controlador.getJugadorActual().getNombre(),resultado);
        }
        else{
            Sistema.imprimir("No puedes volver a tirar los dados");
        }
    }
}