package Modelo.Casilleros;

import Modelo.Casilleros.Barrio;
import Modelo.Casilleros.BarrioConHermano;
import Modelo.Jugador;
import Modelo.Tablero;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class BarrioConHermanoTest {

    @Test
    public void testDosBarriosPertenecenAlMismoJugadorEsTrue(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Lance");
        ArrayList<Integer> listaAlquileres= new ArrayList();
        listaAlquileres.add(2000);
        BarrioConHermano buenosAiresSur = new BarrioConHermano("Buenos Aires Sur", 20000, listaAlquileres, 5000, 8000);
        BarrioConHermano buenosAiresNorte = new BarrioConHermano("Buenos Aires Norte", 25000, listaAlquileres, 5500, 9000);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        jugador.caeEn(buenosAiresNorte, 4, tablero);
        buenosAiresSur.edificarCasa(jugador);
    }

    @Test
    public void testUnJugadorPuedeEdificarUnaCasaAlTenerLosDosBarriosNecesarios(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Lance");
        ArrayList<Integer> listaAlquileres= new ArrayList();
        listaAlquileres.add(2000);
        BarrioConHermano buenosAiresSur = new BarrioConHermano("Buenos Aires Sur", 20000, listaAlquileres, 5000, 8000);
        BarrioConHermano buenosAiresNorte = new BarrioConHermano("Buenos Aires Norte", 25000, listaAlquileres, 5500, 9000);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        jugador.caeEn(buenosAiresNorte, 4, tablero);
        buenosAiresSur.edificarCasa(jugador);
        Assert.assertEquals(jugador.capital(), 50000);
    }

    @Test
    public void testUnJugadorCaeEnUnBarrioQuePerteneceAOtroJugadorQueEdificoUnaCasaEnUnBarrioQueRequiereOtroBarrioParaEdificar(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        ArrayList<Integer> listaAlquileres= new ArrayList();
        listaAlquileres.add(2000);
        listaAlquileres.add(3000);
        BarrioConHermano buenosAiresSur = new BarrioConHermano("Buenos Aires Sur", 20000, listaAlquileres, 5000, 8000);
        BarrioConHermano buenosAiresNorte = new BarrioConHermano("Buenos Aires Norte", 25000, listaAlquileres, 5500, 9000);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador1.caeEn(buenosAiresSur, 4, tablero);
        jugador1.caeEn(buenosAiresNorte, 4, tablero);
        buenosAiresSur.edificarCasa(jugador1);
        jugador2.caeEn(buenosAiresSur, 4, tablero);
        Assert.assertEquals(jugador2.capital(), 97000);
    }

    @Test
    public void testUnJugadorCaeEnUnBarrioQuePerteneceAOtroJugadorQueEdificoDosCasaEnEseMismoBarrioQueRequiereOtroBarrioParaEdificar(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        ArrayList<Integer> listaAlquileres= new ArrayList();
        listaAlquileres.add(2000);
        listaAlquileres.add(3000);
        listaAlquileres.add(3500);
        BarrioConHermano buenosAiresSur = new BarrioConHermano("Buenos Aires Sur", 20000, listaAlquileres, 5000, 8000);
        BarrioConHermano buenosAiresNorte = new BarrioConHermano("Buenos Aires Norte", 25000, listaAlquileres, 5500, 9000);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador1.caeEn(buenosAiresSur, 4, tablero);
        jugador1.caeEn(buenosAiresNorte, 4, tablero);
        buenosAiresSur.edificarCasa(jugador1);
        buenosAiresSur.edificarCasa(jugador1);
        jugador2.caeEn(buenosAiresSur, 4, tablero);
        Assert.assertEquals(jugador2.capital(), 96500);
    }

    @Test
    public void testUnJugadorCaeEnUnBarrioQuePerteneceAOtroJugadorQueEdificoDosCasaEnOtroBarrioQueRequiereEsteMismoBarrioParaEdificar(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        ArrayList<Integer> listaAlquileres= new ArrayList();
        listaAlquileres.add(2500);
        listaAlquileres.add(3500);
        listaAlquileres.add(4000);
        BarrioConHermano buenosAiresSur = new BarrioConHermano("Buenos Aires Sur", 20000, listaAlquileres, 5000, 8000);
        BarrioConHermano buenosAiresNorte = new BarrioConHermano("Buenos Aires Norte", 25000, listaAlquileres, 5500, 9000);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador1.caeEn(buenosAiresSur, 4, tablero);
        jugador1.caeEn(buenosAiresNorte, 4, tablero);
        buenosAiresSur.edificarCasa(jugador1);
        buenosAiresSur.edificarCasa(jugador1);
        buenosAiresNorte.edificarCasa(jugador1);
        jugador2.caeEn(buenosAiresNorte, 4, tablero);
        Assert.assertEquals(jugador2.capital(), 96500);
    }

    @Test
    public void testJugadorNoPuedeEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosHermanos(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Lance");
        ArrayList<Integer> listaAlquileres= new ArrayList();
        listaAlquileres.add(2000);
        BarrioConHermano buenosAiresSur = new BarrioConHermano("Buenos Aires Sur", 20000, listaAlquileres, 5000, 8000);
        BarrioConHermano buenosAiresNorte = new BarrioConHermano("Buenos Aires Norte", 25000, listaAlquileres, 5500, 9000);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        jugador.caeEn(buenosAiresNorte, 4, tablero);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        Assert.assertFalse(buenosAiresSur.edificarHotel(jugador));
    }

    @Test
    public void testJugadorNoSeLeRestaCapitalAlTratarDeEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosHermanos(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Lance");
        ArrayList<Integer> listaAlquileres= new ArrayList();
        listaAlquileres.add(2000);
        BarrioConHermano buenosAiresSur = new BarrioConHermano("Buenos Aires Sur", 20000, listaAlquileres, 5000, 8000);
        BarrioConHermano buenosAiresNorte = new BarrioConHermano("Buenos Aires Norte", 25000, listaAlquileres, 5500, 9000);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        jugador.caeEn(buenosAiresNorte, 4, tablero);
        buenosAiresSur.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 55000);
    }
}
