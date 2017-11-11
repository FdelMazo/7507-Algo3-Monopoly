package Modelo;

public class AvanceDinamico extends Dinamismo{

    public int primeraOpcion(int numDado, Jugador jugador){
        return restaDos(numDado);
    }
    public int segundaOpcion(int numDado,Jugador jugador){
        return porcentajeCapital(numDado,jugador);
    }
    public int terceraOpcion(int numDado , Jugador jugador){
        return restaCantidadPropiedades(numDado, jugador);
    }
}
