package Modelo.Casilleros;


import Modelo.Jugador;

public interface Propiedades {

    String nombre();
    void cambiarPropietario(Jugador jugador);
    boolean comprar(Jugador jugador);
    void cederAlBanco(Jugador jugador);
    boolean edificarCasa(Jugador jugador);
    boolean puedeEdificarHotel(Jugador jugador);
    int getCosto();

}