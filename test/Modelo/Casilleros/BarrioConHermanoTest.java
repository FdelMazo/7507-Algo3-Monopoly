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
    public void testUnJugadorPuedeEdificarUnaCasaAlTenerLosDosBarriosNecesariosBuenosAires(){
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
    public void testUnJugadorCaeEnUnBarrioQuePerteneceAOtroJugadorQueEdificoUnaCasaEnUnBarrioQueRequiereOtroBarrioParaEdificarBuenosAires(){
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
    public void testUnJugadorCaeEnUnBarrioQuePerteneceAOtroJugadorQueEdificoDosCasaEnEseMismoBarrioQueRequiereOtroBarrioParaEdificarBuenosAires(){
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
    public void testUnJugadorCaeEnUnBarrioQuePerteneceAOtroJugadorQueEdificoDosCasaEnOtroBarrioQueRequiereEsteMismoBarrioParaEdificarBuenosAires(){
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
    public void testJugadorNoPuedeEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosHermanosBuenosAires(){
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
    public void testJugadorNoSeLeRestaCapitalAlTratarDeEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosHermanosBuenosAires(){
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

    @Test
    public void testJugadorContruyeUnHotelYDecrementaSuCapitalBuenosAires(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Nick");
        ArrayList<Integer> listaAlquileres= new ArrayList();
        listaAlquileres.add(2000);
        BarrioConHermano buenosAiresSur = new BarrioConHermano("Buenos Aires Sur", 20000, listaAlquileres, 5000, 8000);
        BarrioConHermano buenosAiresNorte = new BarrioConHermano("Buenos Aires Norte", 25000, listaAlquileres, 5500, 9000);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        jugador.caeEn(buenosAiresNorte, 4, tablero);
        buenosAiresNorte.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresSur.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 26000);

    }
    @Test
    public void testJugadorCaeEnCasilleroConHotelYSeDecrementaSuCapitalBuenosAires(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Nick");
        Jugador jugadorAct = new Jugador("Joe");
        ArrayList<Integer> listaAlquileresSur = new ArrayList();
        ArrayList<Integer> listaAlquileresNorte = new ArrayList();
        listaAlquileresSur.add(2000);
        listaAlquileresSur.add(3000);
        listaAlquileresSur.add(3500);
        listaAlquileresSur.add(5000);
        listaAlquileresNorte.add(2500);
        listaAlquileresNorte.add(3500);
        listaAlquileresNorte.add(4000);
        BarrioConHermano buenosAiresSur = new BarrioConHermano("Buenos Aires Sur", 20000, listaAlquileresSur, 5000, 8000);
        BarrioConHermano buenosAiresNorte = new BarrioConHermano("Buenos Aires Norte", 25000, listaAlquileresNorte, 5500, 9000);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        jugador.caeEn(buenosAiresNorte, 4, tablero);
        buenosAiresNorte.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresSur.edificarHotel(jugador);
        jugadorAct.caeEn(buenosAiresSur,2,tablero);
        Assert.assertEquals(jugadorAct.capital(),95000 );

    }
    @Test
    public void testUnJugadorPuedeEdificarUnaCasaAlTenerLosDosBarriosNecesariosCordoba(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Kevin");
        ArrayList<Integer> listaAlquileresSur = new ArrayList();
        ArrayList<Integer> listaAlquileresNorte = new ArrayList();
        listaAlquileresSur.add(1000);
        listaAlquileresNorte.add(1300);
        BarrioConHermano cordobaSur = new BarrioConHermano("Cordoba Sur", 18000, listaAlquileresSur, 2000, 3000);
        BarrioConHermano cordobaNorte = new BarrioConHermano("Cordoba Norte", 20000, listaAlquileresNorte, 2200, 3500);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador.caeEn(cordobaSur, 4, tablero);
        jugador.caeEn(cordobaNorte, 4, tablero);
        cordobaNorte.edificarCasa(jugador);
        Assert.assertEquals(jugador.capital(), 59800);
    }

    @Test
    public void testUnJugadorCaeEnUnBarrioQuePerteneceAOtroJugadorQueEdificoUnaCasaEnUnBarrioQueRequiereOtroBarrioParaEdificarCordoba(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Demi");
        Jugador jugador2 = new Jugador("Selena");
        ArrayList<Integer> listaAlquileresSur = new ArrayList();
        ArrayList<Integer> listaAlquileresNorte = new ArrayList();
        listaAlquileresSur.add(1000);
        listaAlquileresSur.add(1500);
        listaAlquileresNorte.add(1300);
        BarrioConHermano cordobaSur = new BarrioConHermano("Cordoba Sur", 18000, listaAlquileresSur, 2000, 3000);
        BarrioConHermano cordobaNorte = new BarrioConHermano("Cordoba Norte", 20000, listaAlquileresNorte, 2200, 3500);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador1.caeEn(cordobaSur, 4, tablero);
        jugador1.caeEn(cordobaNorte, 4, tablero);
        cordobaSur.edificarCasa(jugador1);
        jugador2.caeEn(cordobaSur, 4, tablero);
        Assert.assertEquals(jugador2.capital(), 98500);
    }
    @Test
    public void testUnJugadorCaeEnUnBarrioQuePerteneceAOtroJugadorQueEdificoDosCasaEnEseMismoBarrioQueRequiereOtroBarrioParaEdificarCordoba(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Demi");
        Jugador jugador2 = new Jugador("Selena");
        ArrayList<Integer> listaAlquileresSur = new ArrayList();
        ArrayList<Integer> listaAlquileresNorte = new ArrayList();
        listaAlquileresSur.add(1000);
        listaAlquileresSur.add(1500);
        listaAlquileresSur.add(2500);
        listaAlquileresNorte.add(1300);
        BarrioConHermano cordobaSur = new BarrioConHermano("Cordoba Sur", 18000, listaAlquileresSur, 2000, 3000);
        BarrioConHermano cordobaNorte = new BarrioConHermano("Cordoba Norte", 20000, listaAlquileresNorte, 2200, 3500);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador1.caeEn(cordobaSur, 4, tablero);
        jugador1.caeEn(cordobaNorte, 4, tablero);
        cordobaSur.edificarCasa(jugador1);
        cordobaSur.edificarCasa(jugador1);
        jugador2.caeEn(cordobaSur, 4, tablero);
        Assert.assertEquals(jugador2.capital(), 97500);
    }
    @Test
    public void testJugadorNoSeLeRestaCapitalAlEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosHermanosCordoba(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Kevin");
        ArrayList<Integer> listaAlquileresSur = new ArrayList();
        ArrayList<Integer> listaAlquileresNorte = new ArrayList();
        listaAlquileresSur.add(1000);
        listaAlquileresNorte.add(1300);
        BarrioConHermano cordobaSur = new BarrioConHermano("Cordoba Sur", 18000, listaAlquileresSur, 2000, 3000);
        BarrioConHermano cordobaNorte = new BarrioConHermano("Cordoba Norte", 20000, listaAlquileresNorte, 2200, 3500);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador.caeEn(cordobaSur, 4, tablero);
        jugador.caeEn(cordobaNorte, 4, tablero);
        cordobaNorte.edificarCasa(jugador);
        cordobaNorte.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 59800);;
    }

    @Test
    public void testJugadorContruyeUnHotelYDecrementaSuCapitalCordoba(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Kevin");
        ArrayList<Integer> listaAlquileresSur = new ArrayList();
        ArrayList<Integer> listaAlquileresNorte = new ArrayList();
        listaAlquileresSur.add(1000);
        listaAlquileresSur.add(1500);
        listaAlquileresSur.add(2500);
        listaAlquileresSur.add(3000);
        listaAlquileresNorte.add(1300);
        listaAlquileresNorte.add(1800);
        listaAlquileresNorte.add(2900);
        listaAlquileresNorte.add(3500);
        BarrioConHermano cordobaSur = new BarrioConHermano("Cordoba Sur", 18000, listaAlquileresSur, 2000, 3000);
        BarrioConHermano cordobaNorte = new BarrioConHermano("Cordoba Norte", 20000, listaAlquileresNorte, 2200, 3500);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador.caeEn(cordobaSur, 4, tablero);
        jugador.caeEn(cordobaNorte, 4, tablero);
        cordobaNorte.edificarCasa(jugador);
        cordobaNorte.edificarCasa(jugador);
        cordobaSur.edificarCasa(jugador);
        cordobaSur.edificarCasa(jugador);
        cordobaNorte.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 50100);;
    }
    @Test
    public void testJugadorCaeEnCasilleroConHotelYSeDecrementaSuCapitalCordoba(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Kevin");
        Jugador jugadorAct = new Jugador("Kevin");
        ArrayList<Integer> listaAlquileresSur = new ArrayList();
        ArrayList<Integer> listaAlquileresNorte = new ArrayList();
        listaAlquileresSur.add(1000);
        listaAlquileresSur.add(1500);
        listaAlquileresSur.add(2500);
        listaAlquileresSur.add(3000);
        listaAlquileresNorte.add(1300);
        listaAlquileresNorte.add(1800);
        listaAlquileresNorte.add(2900);
        listaAlquileresNorte.add(3500);
        BarrioConHermano cordobaSur = new BarrioConHermano("Cordoba Sur", 18000, listaAlquileresSur, 2000, 3000);
        BarrioConHermano cordobaNorte = new BarrioConHermano("Cordoba Norte", 20000, listaAlquileresNorte, 2200, 3500);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador.caeEn(cordobaSur, 4, tablero);
        jugador.caeEn(cordobaNorte, 4, tablero);
        cordobaNorte.edificarCasa(jugador);
        cordobaNorte.edificarCasa(jugador);
        cordobaSur.edificarCasa(jugador);
        cordobaSur.edificarCasa(jugador);
        cordobaNorte.edificarHotel(jugador);
        jugadorAct.caeEn(cordobaNorte,2,tablero);
        Assert.assertEquals(jugadorAct.capital(), 96500);;
    }

    @Test
    public void testUnJugadorPuedeEdificarUnaCasaAlTenerLosDosBarriosNecesariosSalta(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Kevin");
        ArrayList<Integer> listaAlquileresSur = new ArrayList();
        ArrayList<Integer> listaAlquileresNorte = new ArrayList();
        listaAlquileresSur.add(2000);
        listaAlquileresNorte.add(2000);
        BarrioConHermano saltaSur = new BarrioConHermano("Salta Sur", 23000, listaAlquileresSur, 4500, 7500);
        BarrioConHermano saltaNorte = new BarrioConHermano("Salta Norte", 23000, listaAlquileresNorte, 4500, 7500);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador.caeEn(saltaSur, 4, tablero);
        jugador.caeEn(saltaNorte, 4, tablero);
        saltaNorte.edificarCasa(jugador);
        Assert.assertEquals(jugador.capital(), 49500);
    }
    @Test
    public void testUnJugadorCaeEnUnBarrioQuePerteneceAOtroJugadorQueEdificoUnaCasaEnUnBarrioQueRequiereOtroBarrioParaEdificarSalta(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Demi");
        Jugador jugador2 = new Jugador("Selena");
        ArrayList<Integer> listaAlquileresSur = new ArrayList();
        ArrayList<Integer> listaAlquileresNorte = new ArrayList();
        listaAlquileresSur.add(2000);
        listaAlquileresNorte.add(2000);
        listaAlquileresNorte.add(3250);
        BarrioConHermano saltaSur = new BarrioConHermano("Salta Sur", 23000, listaAlquileresSur, 4500, 7500);
        BarrioConHermano saltaNorte = new BarrioConHermano("Salta Norte", 23000, listaAlquileresNorte, 4500, 7500);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador1.caeEn(saltaSur, 4, tablero);
        jugador1.caeEn(saltaNorte, 4, tablero);
        saltaNorte.edificarCasa(jugador1);
        jugador2.caeEn(saltaNorte, 4, tablero);
        Assert.assertEquals(jugador2.capital(), 96750);
    }
    @Test
    public void testUnJugadorCaeEnUnBarrioQuePerteneceAOtroJugadorQueEdificoDosCasasEnUnBarrioQueRequiereOtroBarrioParaEdificarSalta(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Demi");
        Jugador jugador2 = new Jugador("Selena");
        ArrayList<Integer> listaAlquileresSur = new ArrayList();
        ArrayList<Integer> listaAlquileresNorte = new ArrayList();
        listaAlquileresSur.add(2000);
        listaAlquileresNorte.add(2000);
        listaAlquileresNorte.add(3250);
        listaAlquileresNorte.add(3850);
        BarrioConHermano saltaSur = new BarrioConHermano("Salta Sur", 23000, listaAlquileresSur, 4500, 7500);
        BarrioConHermano saltaNorte = new BarrioConHermano("Salta Norte", 23000, listaAlquileresNorte, 4500, 7500);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador1.caeEn(saltaSur, 4, tablero);
        jugador1.caeEn(saltaNorte, 4, tablero);
        saltaNorte.edificarCasa(jugador1);
        saltaNorte.edificarCasa(jugador1);
        jugador2.caeEn(saltaNorte, 4, tablero);
        Assert.assertEquals(jugador2.capital(), 96150);
    }
    @Test
    public void testJugadorNoPuedeEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosHermanosSalta(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Kevin");
        ArrayList<Integer> listaAlquileresSur = new ArrayList();
        ArrayList<Integer> listaAlquileresNorte = new ArrayList();
        listaAlquileresSur.add(2000);
        listaAlquileresNorte.add(2000);
        BarrioConHermano saltaSur = new BarrioConHermano("Salta Sur", 23000, listaAlquileresSur, 4500, 7500);
        BarrioConHermano saltaNorte = new BarrioConHermano("Salta Norte", 23000, listaAlquileresNorte, 4500, 7500);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador.caeEn(saltaSur, 4, tablero);
        jugador.caeEn(saltaNorte, 4, tablero);
        saltaNorte.edificarCasa(jugador);
        saltaNorte.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 49500);
    }
    @Test
    public void testJugadorContruyeUnHotelYDecrementaSuCapitalSalta(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Kevin");
        ArrayList<Integer> listaAlquileresSur = new ArrayList();
        ArrayList<Integer> listaAlquileresNorte = new ArrayList();
        listaAlquileresSur.add(2000);
        listaAlquileresSur.add(3250);
        listaAlquileresSur.add(3850);
        listaAlquileresSur.add(5500);
        listaAlquileresNorte.add(2000);
        listaAlquileresNorte.add(3250);
        listaAlquileresNorte.add(3850);
        listaAlquileresNorte.add(5500);
        BarrioConHermano saltaSur = new BarrioConHermano("Salta Sur", 23000, listaAlquileresSur, 4500, 7500);
        BarrioConHermano saltaNorte = new BarrioConHermano("Salta Norte", 23000, listaAlquileresNorte, 4500, 7500);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador.caeEn(saltaSur, 4, tablero);
        jugador.caeEn(saltaNorte, 4, tablero);
        saltaNorte.edificarCasa(jugador);
        saltaNorte.edificarCasa(jugador);
        saltaSur.edificarCasa(jugador);
        saltaSur.edificarCasa(jugador);
        saltaNorte.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 28500);
    }

    @Test
    public void testJugadorCaerEnUnHotelYDecrementaSuCapitalSalta(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Kevin");
        Jugador jugadorAct = new Jugador("nick");
        ArrayList<Integer> listaAlquileresSur = new ArrayList();
        ArrayList<Integer> listaAlquileresNorte = new ArrayList();
        listaAlquileresSur.add(2000);
        listaAlquileresSur.add(3250);
        listaAlquileresSur.add(3850);
        listaAlquileresSur.add(5500);
        listaAlquileresNorte.add(2000);
        listaAlquileresNorte.add(3250);
        listaAlquileresNorte.add(3850);
        listaAlquileresNorte.add(5500);
        BarrioConHermano saltaSur = new BarrioConHermano("Salta Sur", 23000, listaAlquileresSur, 4500, 7500);
        BarrioConHermano saltaNorte = new BarrioConHermano("Salta Norte", 23000, listaAlquileresNorte, 4500, 7500);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador.caeEn(saltaSur, 4, tablero);
        jugador.caeEn(saltaNorte, 4, tablero);
        saltaNorte.edificarCasa(jugador);
        saltaNorte.edificarCasa(jugador);
        saltaSur.edificarCasa(jugador);
        saltaSur.edificarCasa(jugador);
        saltaNorte.edificarHotel(jugador);
        jugadorAct.caeEn(saltaNorte,2,tablero);
        Assert.assertEquals(jugadorAct.capital(), 94500);
    }
}
