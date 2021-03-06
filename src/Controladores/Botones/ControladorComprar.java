package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Controladores.Sistema;
import Modelo.Casilleros.Casillero;
import Modelo.Casilleros.Propiedades;
import Modelo.Jugador;
import Modelo.Municipio;
import Vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorComprar implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        ControladorDeTurno controlador = ControladorDeTurno.getInstance();
        Municipio municipio = Municipio.getInstance();
        Jugador jugador = controlador.getJugadorActual();
        Casillero actual = jugador.actual();
        if (municipio.esUnaPropiedad(actual.nombre())){
            if (!municipio.tienePropietario((Propiedades) actual)) {
                ((Propiedades) actual).comprar(jugador);
                Sistema.imprimir("\tHa comprado " + actual.nombre());
            }
            else if (municipio.devolverPropietario((Propiedades)actual) == jugador){
                Sistema.imprimir("\tYa es dueño..");
            }
            else{
                Sistema.imprimir("\tEsta propiedad es de " + jugador.getNombre());
            }
        }
        else {
            Sistema.error();
        }
        ContenedorPrincipal.actualizar();
    }

}