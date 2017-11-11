package Modelo;

import java.util.HashMap;

public class Quini6 implements Casillero {
    private HashMap<Jugador, Integer> jugadoresregistrados;
    public Quini6(){
        jugadoresregistrados = new HashMap<>();
    }

    public boolean jugadorEstaRegistrado(Jugador jugador) {
        return jugadoresregistrados.containsKey(jugador);
    }

    public void sumarVisita(Jugador jugador){
        if (jugadorEstaRegistrado(jugador)){
            jugadoresregistrados.put(jugador, jugadoresregistrados.get(jugador) + 1);
        }
        else{
            jugadoresregistrados.put(jugador, 1);
        }
    }

    public int devolverCantidadDeVisitas(Jugador jugador) {
        return jugadoresregistrados.get(jugador);
    }

    public int devolverPrecioCorrespondiente(Jugador jugador){
        if (devolverCantidadDeVisitas(jugador) == 1){
            return 50000;
        }
        else if (devolverCantidadDeVisitas(jugador) == 2){
            return 30000;
        }
        return 0;
    }

    public int actuar ( Jugador jugador,int numDado){
        this.sumarVisita(jugador);
        jugador.cobrar_ingreso(this.devolverPrecioCorrespondiente(jugador));
        return numDado;
    }


}
