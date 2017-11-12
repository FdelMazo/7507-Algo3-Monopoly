package Modelo.Casilleros;

import Modelo.Jugador;

import java.util.HashMap;

public class Quini6 implements Casillero {
    private HashMap<Jugador, Integer> jugadoresregistrados;
    public Quini6(){
        jugadoresregistrados = new HashMap<>();
    }

    private void sumarVisita(Jugador jugador){
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

    public void accionAlPartir(Jugador jugador) {}
    public boolean permiteSalida(Jugador jugador){
        return true;
    }

    private int devolverPrecioCorrespondiente(Jugador jugador){
        if (jugadoresregistrados.get(jugador) == 1){
            return 50000;
        }
        else if (jugadoresregistrados.get(jugador) == 2){
            return 30000;
        }
        return 0;
    }

    public void accionAlCaer( Jugador jugador, int numDado){
        this.sumarVisita(jugador);
        jugador.cobrar_ingreso(this.devolverPrecioCorrespondiente(jugador));
    }


    public boolean jugadorEstaRegistrado(Jugador jugador) {
        return jugadoresregistrados.containsKey(jugador);
    }
}
