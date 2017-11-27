package Modelo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class JugadorTest {

    @Test
    public void capitalInicialEs100000(){
        Jugador jugador = new Jugador("Marcos");
        Assert.assertEquals(100000,jugador.capital());
    }

    @Test
    public void solicitarDineroRestaAlCapitalDelJugador(){
        Jugador jugador = new Jugador("María");
        jugador.solicitarDinero(500);
        Assert.assertEquals(100000-500,jugador.capital());
    }

    @Test
    public void cobrarDineroAumentaElCapitalDelJugador(){

        Jugador jugador = new Jugador("María");
        jugador.cobrar(2000);
        Assert.assertEquals(100000+2000,jugador.capital());
    }
}
