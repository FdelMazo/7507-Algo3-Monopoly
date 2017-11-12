package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;

public abstract class Dinamismo implements Casillero {

    public void accionAlCaer(Jugador jugador, int numDado, Tablero tablero){
        int aMover = calcularDinamismo(jugador, numDado);
        Casillero nuevoCasillero = tablero.desplazarCasillero(this, aMover, jugador);
        jugador.caeEn(nuevoCasillero, numDado, tablero);
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
    public void accionAlPartir(Jugador jugador) {}
    public boolean permiteSalida(Jugador jugador){
        return true;
    }

    public int restaDos(int numDado){
        return numDado-2;
    }
    public int porcentajeCapital(int numDado, Jugador jugador){
        return (jugador.capital() % numDado);
    }
    public int restaCantidadPropiedades(int numDado, Jugador jugador){ return (numDado - jugador.devolverCantPropiedades()); }
    public abstract int primeraOpcion(int num, Jugador jugador);
    public abstract int segundaOpcion (int num,Jugador jugador);
    public abstract int terceraOpcion (int num, Jugador jugador);

}
