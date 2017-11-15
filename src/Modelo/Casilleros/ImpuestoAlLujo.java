package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;

public class ImpuestoAlLujo implements Casillero {
    public void accionAlPartir(Jugador jugador) {

    }

    public void accionAlCaer(Jugador jugador, int numDado, Tablero tablero) {
        double impuesto = jugador.capital() * 0.1 ;
        jugador.solicitar_dinero(impuesto); /*falta especificar cuando el jugador no tiene dinero suficiente*/

    }

    public boolean permiteSalida(Jugador jugador) {
        return false;
    }
}
