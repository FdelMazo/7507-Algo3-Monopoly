package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Controladores.Sistema;
import Modelo.Casilleros.Casillero;
import Modelo.Casilleros.Propiedades;
import Modelo.Dados;
import Modelo.Jugador;
import Modelo.Municipio;
import Vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorEdificar implements EventHandler<ActionEvent>{

    public ControladorEdificar(){
    }

    @Override
    public void handle(ActionEvent event) {

        ControladorDeTurno controlador = ControladorDeTurno.getInstance();
        Municipio municipio = Municipio.getInstance();
        Jugador jugador = controlador.getJugadorActual();
        Casillero actualCasillero = jugador.actual();
        Jugador jugadorAnterior = null;
        if (municipio.esUnaPropiedad(actualCasillero.nombre()) && jugador != jugadorAnterior){
            boolean pudoEdificar = ((Propiedades)actualCasillero).edificarCasa(jugador);
            if (pudoEdificar){
                Sistema.imprimir("\tSe ha podido edificar");
            }
            else{
                Sistema.imprimir("\tNo se ha puede edificar");
            }
            jugadorAnterior = jugador;
        }
        else {
            Sistema.error();
        }
        ContenedorPrincipal.actualizar();
    }



}