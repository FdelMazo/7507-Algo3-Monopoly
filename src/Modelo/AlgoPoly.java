package Modelo;

import java.util.ArrayList;
import java.util.Random;

public class AlgoPoly {
    public ArrayList<Jugador> jugadores;
    public Jugador actual;
    public Tablero tablero;

    public AlgoPoly(){
        tablero = new Tablero();
        jugadores.add(new Jugador("Jugador 1"));
        jugadores.add(new Jugador("Jugador 2"));
        jugadores.add(new Jugador("Jugador 3"));
        for (Jugador jugador: jugadores ) {
            jugador.asignarCasillero(tablero.salida());
        }
        actual = elegirPrimerJugador();
    }

    private Jugador elegirPrimerJugador() {
        return jugadores.get(new Random().nextInt(jugadores.size()));
    }

    public void jugar(){
        while(!(ganador())){
            Turno turno = new Turno(tablero, actual);
            if(actual.perdio()) retirarJugador(actual);
            actual = siguienteJugador(actual);
        }
    }

    private Jugador siguienteJugador(Jugador actual) {
        if (jugadores.indexOf(actual) == jugadores.size()-1){
            return jugadores.get(0);
        }
        return jugadores.get(jugadores.indexOf(actual)+1);
    }

    private void retirarJugador(Jugador actual) {
        jugadores.remove(actual);
    }

    private boolean ganador() {
        return jugadores.size() == 1;
    }

}
