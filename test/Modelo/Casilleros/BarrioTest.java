package Modelo.Casilleros;

import Modelo.Casilleros.Barrio;
import Modelo.Jugador;
import Modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class BarrioTest {


    @Test
    public void BarrioRecienCreadoNoTieneDuenio(){
        Barrio buenosAiresSur = new Barrio("Buenos Aires Sur", 20000,2000);
        Assert.assertEquals( null, buenosAiresSur.duenio() );
    }

    @Test
    public void testSeActualizaElPropietarioAlSerCompradoUnTerreno() {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        Barrio buenosAiresSur = new Barrio("Buenos Aires Sur", 20000,2000);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        Assert.assertEquals(jugador.nombre(), buenosAiresSur.duenio().nombre() );

    }

    @Test
    public void testJugadorConFondosInsuficientesNoPuedeComprarPropiedad(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        Barrio buenosAiresSur = new Barrio("Buenos Aires Sur", 20000,2000);
        jugador.solicitar_dinero(90000);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        Assert.assertEquals(null, buenosAiresSur.duenio() );
    }

}