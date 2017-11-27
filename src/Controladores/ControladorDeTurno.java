package Controladores;

import Modelo.Casilleros.Casillero;
import Modelo.Jugador;
import Modelo.Tablero;
import Modelo.Turno;
import Vista.ContenedorPrincipal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class ControladorDeTurno {

    private static ControladorDeTurno controlador;
    private Jugador actual;
    private Tablero tablero = Tablero.getInstancia();
    ArrayList<Jugador> jugadores;

    private ControladorDeTurno(ArrayList<Jugador> unosJugadores){
        jugadores = unosJugadores;
        actual = elegirPrimerJugador();
        Sistema.imprimir("Es el turno de " + actual.getNombre());
    }

    public static ControladorDeTurno getInstance(){
        if (controlador == null){
            controlador = new ControladorDeTurno(ContenedorPrincipal.getJugadores());
        }
        return controlador;
    }

    private Jugador elegirPrimerJugador() {
        return jugadores.get(new Random().nextInt(jugadores.size()));
    }

    public Jugador getJugadorActual(){
        return actual;
    }

    public boolean jugar(){
        if (!ganador()){
            Casillero viejo = actual.actual();
            Turno turno = new Turno(tablero, actual);
            if(viejo == actual.actual()) return false;
            if (actual.perdio()){
                Sistema.imprimir(actual.getNombre() + " perdió :(");
                Sistema.reproducir(this.getClass(), "memuero.mp3");
                retirarJugador(actual);
                return false;
            }
            ContenedorPrincipal.actualizar();
        }
        return true;
    }

    public void cambiarTurno(){

        actual = siguienteJugador(actual);
        Sistema.imprimir("\nEs el turno de " + actual.getNombre());
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