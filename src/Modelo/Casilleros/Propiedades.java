package Modelo.Casilleros;


import Modelo.Jugador;

public interface Propiedades {

    void cederAlBanco(Jugador jugador);
    String nombre();
    void cambiarPropietario(Jugador jugador);
    int getValorMercado();
    int getCosto();
}