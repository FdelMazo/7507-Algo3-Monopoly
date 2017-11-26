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
        if (municipio.esUnaPropiedad(actual.nombre())){
            if (!municipio.tienePropietario((Propiedades) actual)) {
                //jugador.comprar(((Propiedades) actual).getCosto(), (Propiedades) actual);
                //(Propcaiedades)actual.vender();
                Sistema.imprimir("Has comprado la propiedad " + actual.nombre());
            }
        }
        Sistema.imprimir("No me explotes el codigo, gil");

    }



}