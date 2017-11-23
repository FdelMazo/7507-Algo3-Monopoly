package Controladores;

import Modelo.Jugador;
import Modelo.Tablero;
import Modelo.Turno;
import Vista.Sistema;

import java.util.ArrayList;
import java.util.Random;


public class ControladorDeTurno {

    private static ControladorDeTurno controlador;
    private ArrayList<Jugador> jugadores;
    private Jugador actual;
    private Tablero tablero;

    private ControladorDeTurno(){
        tablero = Tablero.getInstancia();
        jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Jugador 1"));
        jugadores.add(new Jugador("Jugador 2"));
        jugadores.add(new Jugador("Jugador 3"));
        for (Jugador jugador: jugadores ) {
            jugador.asignarCasillero(tablero.salida());
        }
        actual = elegirPrimerJugador();
    }

    public static ControladorDeTurno getInstance(){
        if (controlador == null){
            controlador = new ControladorDeTurno();
        }
        return controlador;
    }

    private Jugador elegirPrimerJugador() {
        return jugadores.get(new Random().nextInt(jugadores.size()));
    }

    public void jugar(){
        if (!ganador()){
            Turno turno = new Turno(tablero, actual);
            Sistema.imprimir("Es el turno del jugador " + actual.getNombre());
            Sistema.imprimir("Cae en " + actual.actual().nombre()); //para ver si se mueve
            if (actual.perdio()) retirarJugador(actual);
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