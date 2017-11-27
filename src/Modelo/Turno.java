package Modelo;

import Modelo.Casilleros.Casillero;

public class Turno {

    public Turno(Tablero tablero, Jugador jugador){
        if (!jugador.mover()) return;
        Casillero nuevo = tablero.desplazarCasillero(jugador, jugador.lanzarDados());
        jugador.caeEn(nuevo);
        }
    }

