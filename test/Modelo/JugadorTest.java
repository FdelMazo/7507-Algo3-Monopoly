package Modelo;

import org.junit.Assert;
import org.junit.Test;

public class JugadorTest {

    @Test
    public void capitalInicialEs100000(){
        Jugador jugador = new Jugador("Marcos");
        Assert.assertEquals(100000,jugador.capital());
    }

    @Test
    public void solicitarDineroRestaAlCapitalDelJugador() {
        Jugador jugador = new Jugador("María");
        jugador.solicitar_dinero(500);
        Assert.assertEquals(100000-500,jugador.capital());
    }

}
