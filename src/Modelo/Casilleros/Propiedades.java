package Modelo.Casilleros;


import Modelo.Jugador;

public interface Propiedades {

    int resetear();
    String nombre();
    int valorMercado();
    void cambiarPropietario(Jugador jugador);
}
