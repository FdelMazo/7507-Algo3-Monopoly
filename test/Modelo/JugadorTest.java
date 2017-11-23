package Modelo;

import Modelo.Casilleros.Barrio;
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
    public void jugadorCaeEnBarrioSinPropietarioYAlComprarloSuCapitalSeRedujo(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Lance");
        ArrayList<Edificacion> listaCasas= new ArrayList<>();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires SUr", 20000, 2000, listaCasas);
        jugador.caeEn(buenosAiresSur, tablero);
        Assert.assertEquals(jugador.capital(), 80000);
    }
}
