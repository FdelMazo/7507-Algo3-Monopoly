package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public abstract class Dinamismo implements Casillero {

    public void accionAlCaer(Jugador jugador){
        int aMover = calcularDinamismo(jugador, jugador.sumaDados());
        Casillero nuevoCasillero = Tablero.getInstancia().desplazarCasillero(jugador.actual(), aMover);
        jugador.caeEn(nuevoCasillero);
    }

    public int calcularDinamismo(Jugador jugador, int numDado) {
        if (2 <= numDado && numDado <= 6) {
            return primeraOpcion(numDado, jugador);
        } else if (7 <= numDado && numDado <= 10) {
            return segundaOpcion(numDado, jugador);
        } else {
            return terceraOpcion(numDado, jugador);
        }
    }

    public int restaDos(int numDado){
        return numDado-2;
    }
    public int porcentajeCapital(int numDado, Jugador jugador){
        return (jugador.capital() % numDado);
    }
    public int restaCantidadPropiedades(int numDado, Jugador jugador){ return (numDado - jugador.cantPropiedades()); }
    public abstract int primeraOpcion(int num, Jugador jugador);
    public abstract int segundaOpcion (int num,Jugador jugador);
    public abstract int terceraOpcion (int num, Jugador jugador);

    public Paint color() { return Color.YELLOW;  }

}
