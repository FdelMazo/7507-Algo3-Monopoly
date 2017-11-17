package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import Modelo.Preso;

import java.util.HashMap;

public class Carcel implements Casillero {
    private HashMap<Jugador, Integer> nochesPresos;

    public Carcel(){
        nochesPresos = new HashMap<>();
    }

    private boolean pagarFianza(Jugador jugador) {
        return jugador.solicitar_dinero(45000);
    }

    public void accionAlCaer(Jugador jugador, int numDado, Tablero tablero) {
        jugador.actualizarEstado(new Preso());
    }

    public boolean permiteSalida(Jugador jugador) {
        if (nochesPresos.get(jugador) == 1){return false;}
        else if (nochesPresos.get(jugador) > 3 || this.pagarFianza(jugador)) {
            nochesPresos.remove(jugador);
            return true;
        }
        return false;
    }



}
