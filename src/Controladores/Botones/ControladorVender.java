package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Modelo.Casilleros.Casillero;
import Modelo.Casilleros.Propiedades;
import Modelo.Jugador;
import Controladores.Sistema;
import Modelo.Municipio;
import Vista.ContenedorPrincipal;
import Vista.VistaJugador;
import Vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorVender implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {

        ControladorDeTurno controlador = ControladorDeTurno.getInstance();
        Municipio municipio = Municipio.getInstance();

        Jugador jugador = controlador.getJugadorActual();
        Casillero actual = jugador.actual();
        if (municipio.esUnaPropiedad(actual.nombre())){
            if (municipio.tienePropietario((Propiedades) actual) && municipio.devolverPropietario((Propiedades) actual) == jugador) {
                jugador.venderAlBanco((Propiedades) actual);
                Sistema.imprimir("\tHa vendido " + actual.nombre() );
            }
            else{
                Sistema.imprimir("\tYa fue vendida");
            }
        }
        else {
            Sistema.error();
        }
        ContenedorPrincipal.actualizar();
    }
}


