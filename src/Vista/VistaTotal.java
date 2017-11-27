package Vista;


import java.util.ArrayList;

public class VistaTotal {

    ArrayList<VistaJugador> vistaJugadores;
    VistaTablero tablero;

    public VistaTotal(ArrayList<VistaJugador> jugadores, VistaTablero tablero){


        this.vistaJugadores = jugadores;
        this.tablero = tablero;

    }

    public void actualizarJugador(String nombreJugador, int pasos){

        tablero.dibujar();
        int jugadoresEnJuego = vistaJugadores.size();
        for (int i = 0; i<jugadoresEnJuego ; i++){
            if (vistaJugadores.get(i).esElJugador(nombreJugador)){
                for (int x = 0; x<pasos ; x++) {
                    vistaJugadores.get(i).mover();
                }
            }
            else{
                vistaJugadores.get(i).dibujar();
            }
        }

    }

    public void agregarEdificacion(){

    }
}
