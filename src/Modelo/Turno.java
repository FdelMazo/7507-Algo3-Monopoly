package Modelo;

import Modelo.Casilleros.Casillero;

public class Turno {

    public Casillero inicial;
    public Casillero intermedio;

    public Turno(Tablero tablero, Jugador jugador){
        if (!jugador.mover()) return;
        inicial = jugador.actual();
        Casillero nuevo = tablero.desplazarCasillero(jugador.actual(), jugador.sumaDados());
        jugador.caeEn(nuevo);
        }


    public boolean dobleDesplazamiento(Tablero tablero, Jugador jugador) {
        Casillero nuevo = tablero.desplazarCasillero(inicial, jugador.sumaDados());
        if (jugador.actual() != nuevo){
            intermedio = nuevo;
            return true;
        }
        return false;
    }

    public Casillero getIntermedio() {
        return  intermedio;
    }
}

