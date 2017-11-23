package Modelo.Casilleros;

import Modelo.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class Quini6Test {

    @Test
    public void testJugadorAlPasarPorPrimeraVezRecibe50000ASuCapital(){

        Jugador jugador = new Jugador("Dio");
        Quini6 quini6 = new Quini6();
        jugador.caeEn(quini6);
        Assert.assertEquals(jugador.capital(), 150000);
    }

    @Test
    public void testJugadorAlPasarPorSegundaVezRecibe30000ASuCapital(){

        Jugador jugador = new Jugador("Dio");
        Quini6 quini6 = new Quini6();
        jugador.caeEn(quini6);
        jugador.caeEn(quini6);
        Assert.assertEquals(jugador.capital(), 180000);
    }

    @Test
    public void testJugadorAlPasarPorTerceraVezNoRecibeIngresoASuCapital(){

        Jugador jugador = new Jugador("Dio");
        Quini6 quini6 = new Quini6();
        jugador.caeEn(quini6);
        jugador.caeEn(quini6);
        jugador.caeEn(quini6);
        jugador.caeEn(quini6);
        Assert.assertEquals(jugador.capital(), 180000);
    }
}
