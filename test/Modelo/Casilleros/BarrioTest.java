package Modelo.Casilleros;

import Modelo.Casilleros.Barrio;
import Modelo.Jugador;
import Modelo.Tablero;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class BarrioTest {


    @Test
    public void BarrioRecienCreadoNoTieneDuenio(){
        ArrayList<Integer> listaAlquileres= new ArrayList();
        listaAlquileres.add(2000);
        Barrio buenosAiresSur = new Barrio("Buenos Aires Sur", 20000, listaAlquileres, 5000, 8000);
        Assert.assertEquals( null, buenosAiresSur.duenio() );
    }

    @Test
    public void testSeActualizaElPropietarioAlSerCompradoUnTerreno() {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        ArrayList<Integer> listaAlquileres= new ArrayList();
        listaAlquileres.add(2000);
        Barrio buenosAiresSur = new Barrio("Buenos Aires Sur", 20000, listaAlquileres, 5000, 8000);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        Assert.assertEquals(jugador.nombre(), buenosAiresSur.duenio().nombre() );
    }

    @Test
    public void testJugadorConFondosInsuficientesNoPuedeComprarPropiedad(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        ArrayList<Integer> listaAlquileres= new ArrayList();
        listaAlquileres.add(2000);
        Barrio buenosAiresSur = new Barrio("Buenos Aires Sur", 20000, listaAlquileres, 5000, 8000);
        jugador.solicitar_dinero(90000);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        Assert.assertEquals(null, buenosAiresSur.duenio() );
    }

    @Test
    public void jugadorEdificarCasaEnBarrioEsTrue(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Lance");
        ArrayList<Integer> listaAlquileres= new ArrayList();
        listaAlquileres.add(2000);
        Barrio buenosAiresSur = new Barrio("Buenos Aires Sur", 20000, listaAlquileres, 5000, 8000);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        Assert.assertTrue(buenosAiresSur.edificarCasa(jugador));
    }

    @Test
    public void edificarCasaEnBarrioRestaElCapitalDelJugador(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Lance");
        ArrayList<Integer> listaAlquileres= new ArrayList();
        listaAlquileres.add(2000);
        Barrio buenosAiresSur = new Barrio("Buenos Aires Sur", 20000, listaAlquileres, 5000, 8000);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        buenosAiresSur.edificarCasa(jugador);
        Assert.assertEquals(jugador.capital(), 75000);
    }

    @Test
    public void unJugadorQueCaeEnUnBarrioDeOtroJugadorDebeComprarAlquiler(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        ArrayList<Integer> listaAlquileres= new ArrayList();
        listaAlquileres.add(2000);
        listaAlquileres.add(3000);
        Barrio buenosAiresSur = new Barrio("Buenos Aires Sur", 20000, listaAlquileres, 5000, 8000);
        jugador1.caeEn(buenosAiresSur, 4, tablero);
        buenosAiresSur.edificarCasa(jugador1);
        jugador2.caeEn(buenosAiresSur, 4, tablero);
        Assert.assertEquals(jugador2.capital(), 97000);
    }

    @Test
    public void edificarUnHotelEnUnBarrioSinCasasNecesariasEsFalse(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Lance");
        ArrayList<Integer> listaAlquileres= new ArrayList();
        listaAlquileres.add(2000);
        listaAlquileres.add(3000);
        Barrio buenosAiresSur = new Barrio("Buenos Aires Sur", 20000, listaAlquileres, 5000, 8000);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        Assert.assertFalse(buenosAiresSur.edificarHotel(jugador));
    }
}