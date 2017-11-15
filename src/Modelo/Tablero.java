package Modelo;

import Modelo.Casilleros.*;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<Casillero> casilleros;

    public Tablero(){
        casilleros = new ArrayList<>();
        casilleros.add(new Salida());
        casilleros.add(new Quini6());
//        casilleros.add(new Barrio('Buenos Aires Sur', 20000,2000));
        casilleros.add(new Carcel());
        casilleros.add(new AvanceDinamico());
        casilleros.add(new Policia());
        casilleros.add(new RetrocesoDinamico());
        casilleros.add(new ImpuestoAlLujo());
    }

    public Casillero desplazarCasillero(Casillero actual, int num, Jugador jugador){
        int indexInicial = casilleros.indexOf(actual);
        int indexFinal = indexInicial + num;
        if(indexFinal > casilleros.size()){
            jugador.caeEn(salida(), 0, this);
            indexFinal-=casilleros.size();
        }
        return casilleros.get(indexFinal);
    }

    public Casillero salida(){
        return casilleros.get(0);
    }
}
