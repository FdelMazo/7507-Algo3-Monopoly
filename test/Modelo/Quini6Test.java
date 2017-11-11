package Modelo;

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
        jugador.asignarCasilla(quini6);
        quini6.sumarVisita(jugador);
        Assert.assertTrue(quini6.jugadorEstaRegistrado(jugador));
    }

    @Test
    public void testJugadorTiene1Visita(){
        Jugador jugador = new Jugador("Dio");
        Quini6 quini6 = new Quini6();
        jugador.asignarCasilla(quini6);
        quini6.sumarVisita(jugador);
        Assert.assertEquals(quini6.devolverCantidadDeVisitas(jugador), 1);
    }

    @Test
    public void testJugadorTiene2Visitas(){
        Jugador jugador = new Jugador("Dio");
        Quini6 quini6 = new Quini6();
        jugador.asignarCasilla(quini6);
        quini6.sumarVisita(jugador);
        quini6.sumarVisita(jugador);
        Assert.assertEquals(quini6.devolverCantidadDeVisitas(jugador), 2);
    }

    @Test
    public void testJugadorAlPasarPorPrimeraVezRecibe50000ASuCapital(){
        Jugador jugador = new Jugador("Dio");
        Quini6 quini6 = new Quini6();
        jugador.asignarCasilla(quini6);
        quini6.actuar(jugador,2);
        Assert.assertEquals(jugador.capital(), 150000);
    }

    @Test
    public void testJugadorAlPasarPorSegundaVezRecibe30000ASuCapital(){
        Jugador jugador = new Jugador("Dio");
        Quini6 quini6 = new Quini6();
        jugador.asignarCasilla(quini6);
        quini6.actuar(jugador,5);
        quini6.actuar(jugador,3);
        Assert.assertEquals(jugador.capital(), 180000);
    }

    @Test
    public void testJugadorAlPasarPorTerceraVezNoRecibeIngresoASuCapital(){
        Jugador jugador = new Jugador("Dio");
        Quini6 quini6 = new Quini6();
        jugador.asignarCasilla(quini6);
        int a =quini6.actuar(jugador,2);
        int b = quini6.actuar(jugador,5);
        int c =quini6.actuar(jugador,7);
        Assert.assertEquals(jugador.capital(), 180000);
    }
}
