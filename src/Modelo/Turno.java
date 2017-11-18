package Modelo;

public class Turno {

    public Turno(Tablero tablero, Jugador jugador){
        tablero = tablero;
        Dados dados = new Dados();
        tablero.desplazarCasillero(jugador.actual(), dados.suma(), jugador);
        }
    }

