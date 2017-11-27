package Modelo;

import java.util.Random;

public class Dados {
    private int dado1;
    private int dado2;

    public Dados(){
        dado1 = new Random().nextInt(5) +1;
        dado2 = new Random().nextInt(5) +1;
    }

    public int suma(){
        return dado1+dado2;
    }

    public boolean doble() {return dado1==dado2; }

    public void dadosDobles(){
        dado1 = 1;
        dado2 = 1;
    }
}
