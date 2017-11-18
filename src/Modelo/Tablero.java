package Modelo;

import Modelo.Casilleros.*;

import java.util.ArrayList;
import java.util.Collection;

public class Tablero {
    private ArrayList<Casillero> casilleros;

    public Tablero(){
        casilleros = new ArrayList<>();
        casilleros.add(new Salida());
        casilleros.add(new Quini6());
//        casilleros.add(new BarrioDoble("Buenos Aires Sur", 20000,2000));
        casilleros.add(new Servicio("Edesur",35000,500,1000,"Aysa"));
//        casilleros.add(new BarrioDoble("Buenos Aires Norte", 20000,2000));
        casilleros.add(new Carcel());
//        casilleros.add(new BarrioDoble("Cordoba Sur", 20000,2000));
        casilleros.add(new AvanceDinamico());
        casilleros.add(new Servicio("Subte",40000,600,1100,"Trenes"));
//        casilleros.add(new BarrioDoble("Cordoba Norte", 20000,2000));
        casilleros.add(new ImpuestoAlLujo());
//        casilleros.add(new Barrio("Santa Fe", 15000, 1500, 1));
        casilleros.add(new Servicio("Aysa",30000,300,5000,"Edesur"));
//        casilleros.add(new BarrioDoble("Salta Norte", 20000,2000));
//        casilleros.add(new BarrioDoble("Salta Sur", 20000,2000));
        casilleros.add(new Policia());
        casilleros.add(new Servicio("Trenes",38000,450,800,"Subte"));
//        casilleros.add(new Barrio("Neuquen", 15000, 1500, 1));
        casilleros.add(new RetrocesoDinamico());
//        casilleros.add(new Barrio("Tucumán", 15000, 1500, 1));
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
