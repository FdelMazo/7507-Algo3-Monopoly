package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;

import java.util.HashMap;

public class Quini6 implements Casillero {
    private HashMap<Jugador, Integer> jugadoresregistrados;

    public Quini6(){
        jugadoresregistrados = new HashMap<>();
    }

    private void sumarVisita(Jugador jugador){
        if (jugadoresregistrados.containsKey(jugador)){
            jugadoresregistrados.put(jugador, jugadoresregistrados.get(jugador) + 1);
        }
        else{
            jugadoresregistrados.put(jugador, 1);
        }
    }

    private int calcularPrecio(Jugador jugador){
        if (jugadoresregistrados.get(jugador) == 1){
            return 50000;
        }
        else if (jugadoresregistrados.get(jugador) == 2){
            return 30000;
        }
        return 0;
    }

    public void accionAlCaer( Jugador jugador, int numDado, Tablero tablero){
        this.sumarVisita(jugador);
        jugador.cobrar(this.calcularPrecio(jugador));
    }
    public String nombre() {  return "Quini 6";}


}
