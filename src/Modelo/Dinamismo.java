package Modelo;

public abstract class Dinamismo implements Casillero {

    public int actuar(Jugador jugador,  int numDado){
        if (2 <= numDado && numDado <= 6){
           numDado = primeraOpcion(numDado, jugador);
        }
        else if  (7 <= numDado && numDado <= 10){
            numDado = segundaOpcion(numDado,jugador);
        }
        else {
            numDado= terceraOpcion(numDado, jugador);
        }
        return numDado;
    }
    public int restaDos(int numDado){
        return numDado-2;
    }
    public int porcentajeCapital(int numDado, Jugador jugador){
        return (jugador.capital() % numDado);
    }
    public int restaCantidadPropiedades(int numDado, Jugador jugador){
        return (numDado - jugador.devolverCantPropiedades());
    }

    public abstract int primeraOpcion(int num, Jugador jugador);
    public  abstract int segundaOpcion (int num,Jugador jugador);
    public abstract int terceraOpcion (int num, Jugador jugador);



}
