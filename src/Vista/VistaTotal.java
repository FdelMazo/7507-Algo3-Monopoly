package Vista;


public class VistaTotal {

    VistaJugador jugador1;
    VistaJugador jugador2;
    VistaJugador jugador3;
    VistaTablero tablero;

    public VistaTotal(VistaJugador jugador1, VistaJugador jugador2, VistaJugador jugador3, VistaTablero tablero){

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugador3 = jugador3;
        this.tablero = tablero;

    }

    public void actualizar(){

        tablero.dibujar();
        jugador1.mover();
        jugador2.dibujar();
        jugador3.dibujar();

    }

}
