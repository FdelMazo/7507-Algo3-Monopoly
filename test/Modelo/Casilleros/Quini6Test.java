package Modelo.Casilleros;

import Modelo.Casilleros.Quini6;
import Modelo.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class Quini6Test {

    @Test
    public void testJugadorNoEstaRegistrado(){
        Jugador jugador = new Jugador("Dio");
        Quini6 quini6 = new Quini6();
        Assert.assertFalse(quini6.jugadorEstaRegistrado(jugador));
    }

    @Test
    public void testJugadorEstaRegistradoAlPasarPorElQuini6(){
        Jugador jugador = new Jugador("Dio");
        Quini6 quini6 = new Quini6();
        jugador.caeEn(quini6, 0);
        Assert.assertTrue(quini6.jugadorEstaRegistrado(jugador));
    }

    @Test
    public void testJugadorTiene1Visita(){
        Jugador jugador = new Jugador("Dio");
        Quini6 quini6 = new Quini6();
        jugador.caeEn(quini6, 0);
        Assert.assertEquals(quini6.devolverCantidadDeVisitas(jugador), 1);
    }

    @Test
    public void testJugadorTiene2Visitas(){
        Jugador jugador = new Jugador("Dio");
        Quini6 quini6 = new Quini6();
        jugador.caeEn(quini6, 0);
        jugador.caeEn(quini6, 0);
        Assert.assertEquals(quini6.devolverCantidadDeVisitas(jugador), 2);
    }

    @Test
    public void testJugadorAlPasarPorPrimeraVezRecibe50000ASuCapital(){
        Jugador jugador = new Jugador("Dio");
        Quini6 quini6 = new Quini6();
        jugador.caeEn(quini6, 0);
        Assert.assertEquals(jugador.capital(), 150000);
    }

    @Test
    public void testJugadorAlPasarPorSegundaVezRecibe30000ASuCapital(){
        Jugador jugador = new Jugador("Dio");
        Quini6 quini6 = new Quini6();
        jugador.caeEn(quini6, 0);
        jugador.caeEn(quini6, 0);
        Assert.assertEquals(jugador.capital(), 180000);
    }

    @Test
    public void testJugadorAlPasarPorTerceraVezNoRecibeIngresoASuCapital(){
        Jugador jugador = new Jugador("Dio");
        Quini6 quini6 = new Quini6();
        jugador.caeEn(quini6, 0);
        jugador.caeEn(quini6, 0);
        jugador.caeEn(quini6, 0);
        jugador.caeEn(quini6, 0);
        Assert.assertEquals(jugador.capital(), 180000);
    }
}
