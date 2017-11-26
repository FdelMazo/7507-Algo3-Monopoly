package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Controladores.Sistema;
import Modelo.Casilleros.Casillero;
import Modelo.Casilleros.Propiedades;
import Modelo.Jugador;
import Modelo.Municipio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorComprar implements EventHandler<ActionEvent>{

    public ControladorComprar(){
    }

    @Override
    public void handle(ActionEvent event) {

        ControladorDeTurno controlador = ControladorDeTurno.getInstance();
        Municipio municipio = Municipio.getInstance();
        Jugador jugador = controlador.getJugadorActual();
        Casillero actual = jugador.actual();
        //Sistema.imprimir("Nombre: " + actual.nombre());
        if (municipio.esUnaPropiedad(actual.nombre())){
            //Sistema.imprimir("Hasta aca funco");
            if (!municipio.tienePropietario((Propiedades) actual)) {
                //Sistema.imprimir("Plata antes de comprar: " + jugador.capital());
                ((Propiedades) actual).comprar(jugador);
                //Sistema.imprimir("Has comprado la propiedad " + actual.nombre());
                //Sistema.imprimir("Plata despues de comprar: " + jugador.capital());
            }
        }
        else {
            Sistema.imprimir("No puedes realizar esa accion");
        }

    }



}