package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Controladores.Sistema;
import Modelo.Casilleros.BarrioDoble;
import Modelo.Casilleros.Casillero;
import Modelo.Casilleros.Propiedades;
import Modelo.Jugador;
import Modelo.Municipio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorEdificarHotel implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        ControladorDeTurno controlador = ControladorDeTurno.getInstance();
        Municipio municipio = Municipio.getInstance();
        Jugador jugador = controlador.getJugadorActual();
        Casillero actualCasillero = jugador.actual();
        Jugador jugadorAnterior = null;

        if (municipio.esUnaPropiedad(actualCasillero.nombre()) && jugador != jugadorAnterior){
            boolean puedeEdificar = ((Propiedades)actualCasillero).puedeEdificarHotel(jugador);
            if (puedeEdificar){
                ((BarrioDoble)actualCasillero).edificarHotel(jugador);
                Sistema.imprimir("Se ha edificado un Hotal");
            }
            else{
                Sistema.imprimir("No se ha podido edificar un Hotel");
            }
            jugadorAnterior = jugador;
        }
        else {
            Sistema.error();
        }
    }

}
