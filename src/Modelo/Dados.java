package Modelo;

import java.util.Random;

public class Dados {
    Integer dado1;
    Integer dado2;

    public Dados(){
        dado1 = new Random().nextInt(5) +1;
        dado2 = new Random().nextInt(5) +1;
    }

    public int suma(){
        return dado1+dado2;
    }

    public boolean doble() {return dado1==dado2; }
}
