package Modelo;

import Modelo.Casilleros.Casillero;

public class Turno {

    public Turno(Tablero tablero, Jugador jugador){
        Dados dados = new Dados();
        Casillero nuevo = tablero.desplazarCasillero(jugador.actual(), dados.suma(), jugador);
        jugador.caeEn(nuevo, dados.suma(), tablero);
        if (dados.doble()) new Turno(tablero, jugador);
        }
    }

