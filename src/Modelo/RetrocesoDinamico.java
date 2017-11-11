package Modelo;

public class RetrocesoDinamico extends Dinamismo {
    public int primeraOpcion(int numDado, Jugador jugador) {
        return (restaCantidadPropiedades(numDado,jugador)*-1);
    }

    public int segundaOpcion(int numDado, Jugador jugador) {
        return (porcentajeCapital(numDado,jugador)*-1);
    }

    public int terceraOpcion(int numDado, Jugador jugador) {
        return (restaDos(numDado)*-1);
    }
}