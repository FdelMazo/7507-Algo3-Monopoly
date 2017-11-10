package Modelo;

import org.junit.Assert;
import org.junit.Test;

public class BarrioTest {


    @Test
    public void BarrioRecienCreadoNoTieneDuenio(){

        Barrio buenosAiresSur = new Barrio(20000,2000);
        Assert.assertEquals( null, buenosAiresSur.duenio() );

    }

    @Test
    public void testSeActualizaElPropietarioAlSerCompradoUnTerreno() {

        Jugador jugador = new Jugador("Pablo");
        Barrio buenosAiresSur = new Barrio(20000,2000);
        jugador.asignarCasilla(buenosAiresSur);
        buenosAiresSur.actuar(jugador);

        Assert.assertEquals(jugador.nombre(), buenosAiresSur.duenio().nombre() );

    }

    @Test
    public void testJugadorConFondosInsuficientesNoPuedeComprarPropiedad(){

        Jugador jugador = new Jugador("Pablo");
        Barrio buenosAiresSur = new Barrio(200000,2000);
        jugador.asignarCasilla(buenosAiresSur);
        buenosAiresSur.actuar(jugador);

        Assert.assertEquals(null, buenosAiresSur.duenio() );
    }

}