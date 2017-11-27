package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Modelo.Casilleros.Casillero;
import Modelo.Casilleros.Propiedades;
import Modelo.Jugador;
import Controladores.Sistema;
import Modelo.Municipio;
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
                Sistema.imprimir("Has vendido la propiedad " + actual.nombre());
            }
            else{
                Sistema.imprimir("Ya la has vendido");
            }
        }
        else {
            Sistema.error();
        }
    }
}


