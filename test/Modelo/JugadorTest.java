package Modelo;

import Modelo.Casilleros.Barrio;
import Modelo.Jugador;
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
        jugador.solicitar_dinero(500);
        Assert.assertEquals(100000-500,jugador.capital());
    }

    @Test
    public void jugadorCaeEnBarrioSinPropietarioYAlComprarloSuCapitalSeRedujo(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Lance");
        ArrayList<Integer> listaAlquileres= new ArrayList();
        listaAlquileres.add(2000);
        Barrio buenosAiresSur = new Barrio("Buenos Aires Sur", 20000, listaAlquileres, 5000, 8000);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        Assert.assertEquals(jugador.capital(), 80000);
    }
}
