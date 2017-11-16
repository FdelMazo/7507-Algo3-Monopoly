package Modelo.Casilleros;


import Modelo.Jugador;

public interface Propiedades {

    int resetear();
    String nombre();
    int valorMercado();
    boolean vender(Jugador jugador);
    void cambiarPropietario(Jugador jugador);
}
