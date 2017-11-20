package Modelo.Casilleros;


import Modelo.Jugador;

public interface Propiedades {

    int resetear();
    String nombre();
    void cambiarPropietario(Jugador jugador);
}
