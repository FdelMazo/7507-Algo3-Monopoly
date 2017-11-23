package Modelo;

import Modelo.Casilleros.*;
import Vista.Consola;

import java.util.ArrayList;
import java.util.Arrays;






public class Tablero {
    //Singleton!
    private ArrayList<Casillero> casilleros;

    private Tablero(){
        casilleros = new ArrayList<>();
        agregarCasilleros0a6();
        agregarCasilleros7a11();
        agregarCasilleros12a16();
        agregarCasilleros17a20();
        Consola.println("Tablero creado");
    }

    private static class tableroInstancia {
        private static final Tablero INSTANCE = new Tablero();
    }

    public static Tablero getInstancia() {
        return tableroInstancia.INSTANCE;
    }

    public Casillero desplazarCasillero(Jugador jugador, int numDados){
        Casillero actual = jugador.actual();
        if (!jugador.mover()) return actual;
        int indexInicial = casilleros.indexOf(actual);
        int indexFinal = indexInicial + numDados;
        if(indexFinal > casilleros.size()){
            jugador.caeEn(salida(), this);
            indexFinal-=casilleros.size();
        }
        return casilleros.get(indexFinal);
    }

    public Casillero salida(){
        return casilleros.get(0);
    }
    private void agregarCasilleros17a20() {
        casilleros.add(new Servicio("Tren", 38000));
        casilleros.add(new Barrio("Neuquen", 17000, 1800, Arrays.asList(new Edificacion(4800, 3800))));
        casilleros.add(new RetrocesoDinamico());
        casilleros.add(new Barrio("Tucuman", 25000, 2500, Arrays.asList(new Edificacion(7000, 4500))));
    }

    private void agregarCasilleros12a16() {
        casilleros.add(new Barrio("Santa Fe", 15000, 1500, Arrays.asList(new Edificacion(4000, 3500))));
        casilleros.add(new Servicio("Aysa", 30000));
        casilleros.add(new BarrioDoble("Salta Norte",
                23000, 2000,
                Arrays.asList(new Edificacion(4500, 3250),new Edificacion(4500, 3850)),
                Arrays.asList(new Edificacion(7500, 5500))));
        casilleros.add(new BarrioDoble("Salta Sur",
                23000, 2000,
                Arrays.asList(new Edificacion(4500, 3250),new Edificacion(4500, 3850)),
                Arrays.asList(new Edificacion(7500, 5500))));
        casilleros.add(new Policia());

    }

    private void agregarCasilleros7a11() {
        casilleros.add(new BarrioDoble("Cordoba Sur",
                18000, 1000,
                Arrays.asList(new Edificacion(2000, 1500),new Edificacion(2000, 2500)),
                Arrays.asList(new Edificacion(3000, 3000))));
        casilleros.add(new AvanceDinamico());
        casilleros.add(new Servicio("Subte",
                40000));
        casilleros.add(new BarrioDoble("Cordoba Norte",
                20000, 1300,
                Arrays.asList(new Edificacion(2200, 1800),new Edificacion(2200, 2900)),
                Arrays.asList(new Edificacion(3500, 3500))));
        casilleros.add(new ImpuestoAlLujo());
    }

    private void agregarCasilleros0a6() {
        casilleros.add(new Salida());
        casilleros.add(new Quini6());
        casilleros.add(new BarrioDoble("Buenos Aires Sur",
                20000, 2000,
                Arrays.asList(new Edificacion(3000, 5000),new Edificacion(3000, 3500)),
                Arrays.asList(new Edificacion(8000, 5000))));
        casilleros.add(new Servicio("Edesur",
                35000));
        casilleros.add(new BarrioDoble("Buenos Aires Norte",
                25000, 2500,
                Arrays.asList(new Edificacion(5500, 3500),new Edificacion(5500, 4000)),
                Arrays.asList(new Edificacion(9000, 6000))));
        casilleros.add(new Carcel());
    }

    public ArrayList<Casillero> casilleros() { return casilleros;  }
}
