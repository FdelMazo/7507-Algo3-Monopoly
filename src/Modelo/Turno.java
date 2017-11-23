package Modelo;

import Modelo.Casilleros.Casillero;

public class Turno {

    public Turno(Tablero tablero, Jugador jugador){
        Casillero nuevo = tablero.desplazarCasillero(jugador, jugador.lanzarDados());
        jugador.caeEn(nuevo);
        if (jugador.doble()) new Turno(tablero, jugador);
        }
    }

