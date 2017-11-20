package Modelo.Casilleros;

import Modelo.Edificacion;
import Modelo.Jugador;
import Modelo.Tablero;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BarrioDobleTest {

    @Test
    public void testDosBarriosPertenecenAlMismoJugadorEsTrue(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHoteles = new ArrayList();
        listaHoteles.add(new Edificacion(8000, 5000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasas, listaHoteles);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasas, listaHoteles);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        jugador.caeEn(buenosAiresNorte, 4, tablero);
        Assert.assertTrue(buenosAiresSur.tienenMismoPropietario(buenosAiresNorte));
    }

    @Test
    public void testUnJugadorPuedeEdificarUnaCasaAlTenerLosDosBarriosNecesariosBuenosAires(){
        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHoteles = new ArrayList();
        listaHoteles.add(new Edificacion(8000, 5000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasas, listaHoteles);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasas, listaHoteles);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        Assert.assertTrue(buenosAiresSur.edificarCasa(jugador));
    }

    //ENTREGA 2: TEST 2 REQUERIDO
    @Test
    public void testUnJugadorEdificaUnaCasaEnBuenosAiresSurBarrioDoblePierde5000(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHoteles = new ArrayList();
        listaHoteles.add(new Edificacion(8000, 5000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasas, listaHoteles);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasas, listaHoteles);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        buenosAiresSur.edificarCasa(jugador);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        jugador.caeEn(buenosAiresNorte, 4, tablero);
        Assert.assertEquals(jugador.capital(), 100000 - 20000 - 25000 - 5000);
    }

    //ENTREGA 2: TEST 3 REQUERIDO
    @Test
    public void testUnJugadorCaeEnBuenosAiresSurUnBarrioDobleQuePerteneceAOtroJugadorQueEdificoUnaCasaPierde3000(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHoteles = new ArrayList();
        listaHoteles.add(new Edificacion(8000, 5000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasas, listaHoteles);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasas, listaHoteles);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador1.caeEn(buenosAiresSur, 4, tablero);
        jugador1.caeEn(buenosAiresNorte, 4, tablero);
        buenosAiresSur.edificarCasa(jugador1);
        buenosAiresNorte.edificarCasa(jugador1);
        jugador2.caeEn(buenosAiresSur, 4, tablero);
        Assert.assertEquals(jugador2.capital(), 97000);
    }

    //ENTREGA 2: TEST 4 REQUERIDO
    @Test
    public void testUnJugadorCaeEnBuenosAiresSurUnBarrioDobleQuePerteneceAOtroJugadorQueEdificoDosCasaAhiYUnaEnBuenosAiresNortePierde3500(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        List<Edificacion> listaCasasS= new ArrayList();
        listaCasasS.add(new Edificacion(5000, 3000));
        listaCasasS.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(8000, 5000));
        List<Edificacion> listaCasasN= new ArrayList();
        listaCasasN.add(new Edificacion(5500, 3500));
        listaCasasN.add(new Edificacion(5500, 4000));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(9000, 6000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasasN, listaHotelesN);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador1.caeEn(buenosAiresSur, 4, tablero);
        jugador1.caeEn(buenosAiresNorte, 4, tablero);
        buenosAiresSur.edificarCasa(jugador1);
        buenosAiresSur.edificarCasa(jugador1);
        buenosAiresNorte.edificarCasa(jugador1);
        jugador2.caeEn(buenosAiresSur, 4, tablero);
        Assert.assertEquals(jugador2.capital(), 96500);
    }

    @Test
    public void testJugadorNoPuedeEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosDoblesBuenosAires(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasasS= new ArrayList();
        listaCasasS.add(new Edificacion(5000, 3000));
        listaCasasS.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(8000, 5000));
        List<Edificacion> listaCasasN= new ArrayList();
        listaCasasN.add(new Edificacion(5500, 3500));
        listaCasasN.add(new Edificacion(5500, 4000));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(9000, 6000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasasN, listaHotelesN);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        jugador.caeEn(buenosAiresNorte, 4, tablero);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        Assert.assertFalse(buenosAiresSur.edificarHotel(jugador));
    }

    //ENTREGA 2: TEST 5 REQUERIDO
    @Test
    public void testJugadorNoSeLeRestaCapitalAlTratarDeEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosDoblesBuenosAires(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasasS= new ArrayList();
        listaCasasS.add(new Edificacion(5000, 3000));
        listaCasasS.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(8000, 5000));
        List<Edificacion> listaCasasN= new ArrayList();
        listaCasasN.add(new Edificacion(5500, 3500));
        listaCasasN.add(new Edificacion(5500, 4000));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(9000, 6000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasasN, listaHotelesN);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        jugador.caeEn(buenosAiresNorte, 4, tablero);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresSur.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 100000 - 20000 - 25000 - 5000);
    }

    //ENTREGA 2: TEST 6 REQUERIDO
    @Test
    public void testJugadorContruyeUnHotelYDecrementaSuCapitalBuenosAiresSurPierde8000(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Nick");
        List<Edificacion> listaCasasS= new ArrayList();
        listaCasasS.add(new Edificacion(5000, 3000));
        listaCasasS.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(8000, 5000));
        List<Edificacion> listaCasasN= new ArrayList();
        listaCasasN.add(new Edificacion(5500, 3500));
        listaCasasN.add(new Edificacion(5500, 4000));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(9000, 6000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasasN, listaHotelesN);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        jugador.caeEn(buenosAiresNorte, 4, tablero);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        buenosAiresSur.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 100000 - 20000 - 25000 - 10000 - 11000 - 8000);
    }

    //ENTREGA 2: TEST 7 REQUERIDO
    @Test
    public void testJugadorCaeEnCasilleroConHotelYSeDecrementaSuCapitalBuenosAires(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Nick");
        Jugador jugadorAct = new Jugador("Joe");
        ArrayList<Integer> listaAlquileresSur = new ArrayList();
        List<Edificacion> listaCasasS= new ArrayList();
        listaCasasS.add(new Edificacion(5000, 3000));
        listaCasasS.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(8000, 5000));
        List<Edificacion> listaCasasN= new ArrayList();
        listaCasasN.add(new Edificacion(5500, 3500));
        listaCasasN.add(new Edificacion(5500, 4000));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(9000, 6000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasasN, listaHotelesN);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        jugador.caeEn(buenosAiresNorte, 4, tablero);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        buenosAiresSur.edificarHotel(jugador);
        jugadorAct.caeEn(buenosAiresSur,4,tablero);
        Assert.assertEquals(jugadorAct.capital(),95000 );
    }

    //ENTREGA 2: TEST 8 REQUERIDO (CORDOBA)
    @Test
    public void testUnJugadorPuedeEdificarUnaCasaAlTenerLosDosBarriosNecesariosCordoba(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS= new ArrayList();
        listaCasasS.add(new Edificacion(2000, 1500));
        listaCasasS.add(new Edificacion(2000, 2500));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(3000, 3000));
        List<Edificacion> listaCasasN= new ArrayList();
        listaCasasN.add(new Edificacion(2200, 1800));
        listaCasasN.add(new Edificacion(2200, 2900));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(3500, 3500));
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Aires Sur", 18000, 1000, listaCasasS, listaHotelesS);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, listaHotelesN);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador.caeEn(cordobaSur, 4, tablero);
        jugador.caeEn(cordobaNorte, 4, tablero);
        cordobaNorte.edificarCasa(jugador);
        Assert.assertEquals(jugador.capital(), 59800);
    }

    //ENTREGA 2: TEST 8 REQUERIDO (CORDOBA)
    @Test
    public void testUnJugadorCaeEnCordobaSurUnBarrioQuePerteneceAOtroJugadorQueEdificoUnaCasaPierde1500(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Demi");
        Jugador jugador2 = new Jugador("Selena");
        List<Edificacion> listaCasasS= new ArrayList();
        listaCasasS.add(new Edificacion(2000, 1500));
        listaCasasS.add(new Edificacion(2000, 2500));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(3000, 3000));
        List<Edificacion> listaCasasN= new ArrayList();
        listaCasasN.add(new Edificacion(2200, 1800));
        listaCasasN.add(new Edificacion(2200, 2900));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(3500, 3500));
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Aires Sur", 18000, 1000, listaCasasS, listaHotelesS);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, listaHotelesN);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador1.caeEn(cordobaSur, 4, tablero);
        jugador1.caeEn(cordobaNorte, 4, tablero);
        cordobaSur.edificarCasa(jugador1);
        jugador2.caeEn(cordobaSur, 4, tablero);
        Assert.assertEquals(jugador2.capital(), 98500);
    }

    //ENTREGA 2: TEST 8 REQUERIDO (CORDOBA)
    @Test
    public void testUnJugadorCaeEnCordobaSurUnBarrioQuePerteneceAOtroJugadorQueEdificoDosCasaEnEseMismoBarrioPierde2500(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Demi");
        Jugador jugador2 = new Jugador("Selena");
        List<Edificacion> listaCasasS= new ArrayList();
        listaCasasS.add(new Edificacion(2000, 1500));
        listaCasasS.add(new Edificacion(2000, 2500));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(3000, 3000));
        List<Edificacion> listaCasasN= new ArrayList();
        listaCasasN.add(new Edificacion(2200, 1800));
        listaCasasN.add(new Edificacion(2200, 2900));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(3500, 3500));
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Aires Sur", 18000, 1000, listaCasasS, listaHotelesS);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, listaHotelesN);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador1.caeEn(cordobaSur, 4, tablero);
        jugador1.caeEn(cordobaNorte, 4, tablero);
        cordobaSur.edificarCasa(jugador1);
        cordobaSur.edificarCasa(jugador1);
        jugador2.caeEn(cordobaSur, 4, tablero);
        Assert.assertEquals(jugador2.capital(), 97500);
    }

    //ENTREGA 2: TEST 8 REQUERIDO (CORDOBA)
    @Test
    public void testJugadorNoSeLeRestaCapitalAlEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosDoblesCordoba(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS= new ArrayList();
        listaCasasS.add(new Edificacion(2000, 1500));
        listaCasasS.add(new Edificacion(2000, 2500));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(3000, 3000));
        List<Edificacion> listaCasasN= new ArrayList();
        listaCasasN.add(new Edificacion(2200, 1800));
        listaCasasN.add(new Edificacion(2200, 2900));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(3500, 3500));
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Aires Sur", 18000, 1000, listaCasasS, listaHotelesS);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, listaHotelesN);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador.caeEn(cordobaSur, 4, tablero);
        jugador.caeEn(cordobaNorte, 4, tablero);
        cordobaNorte.edificarCasa(jugador);
        cordobaNorte.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 59800);
    }

    //ENTREGA 2: TEST 8 REQUERIDO (CORDOBA)
    @Test
    public void testJugadorContruyeUnHotelYDecrementaSuCapitalCordoba(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS= new ArrayList();
        listaCasasS.add(new Edificacion(2000, 1500));
        listaCasasS.add(new Edificacion(2000, 2500));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(3000, 3000));
        List<Edificacion> listaCasasN= new ArrayList();
        listaCasasN.add(new Edificacion(2200, 1800));
        listaCasasN.add(new Edificacion(2200, 2900));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(3500, 3500));
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Aires Sur", 18000, 1000, listaCasasS, listaHotelesS);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, listaHotelesN);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador.caeEn(cordobaSur, 4, tablero);
        jugador.caeEn(cordobaNorte, 4, tablero);
        cordobaNorte.edificarCasa(jugador);
        cordobaNorte.edificarCasa(jugador);
        cordobaSur.edificarCasa(jugador);
        cordobaSur.edificarCasa(jugador);
        cordobaNorte.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 50100);
    }

    //ENTREGA 2: TEST 8 REQUERIDO (CORDOBA)
    @Test
    public void testJugadorCaeEnCasilleroConHotelYSeDecrementaSuCapitalCordoba(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Kevin");
        Jugador jugadorAct = new Jugador("Kevin");
        List<Edificacion> listaCasasS= new ArrayList();
        listaCasasS.add(new Edificacion(2000, 1500));
        listaCasasS.add(new Edificacion(2000, 2500));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(3000, 3000));
        List<Edificacion> listaCasasN= new ArrayList();
        listaCasasN.add(new Edificacion(2200, 1800));
        listaCasasN.add(new Edificacion(2200, 2900));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(3500, 3500));
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Aires Sur", 18000, 1000, listaCasasS, listaHotelesS);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, listaHotelesN);
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
        Assert.assertEquals(jugadorAct.capital(), 96500);
    }

    //ENTREGA 2: TEST 8 REQUERIDO (SALTA)
    @Test
    public void testUnJugadorPuedeEdificarUnaCasaAlTenerLosDosBarriosNecesariosSalta(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS = new ArrayList();
        listaCasasS.add(new Edificacion(4500, 3250));
        listaCasasS.add(new Edificacion(4500, 3850));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(7500, 5500));
        List<Edificacion> listaCasasN = new ArrayList();
        listaCasasN.add(new Edificacion(4500, 3250));
        listaCasasN.add(new Edificacion(4500, 3850));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(7500, 5500));
        BarrioDoble saltaSur = new BarrioDoble("Salta Sur", 23000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble saltaNorte = new BarrioDoble("Salta Norte", 23000, 2000, listaCasasN, listaHotelesN);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador.caeEn(saltaSur, 4, tablero);
        jugador.caeEn(saltaNorte, 4, tablero);
        saltaNorte.edificarCasa(jugador);
        Assert.assertEquals(jugador.capital(), 49500);
    }

    //ENTREGA 2: TEST 8 REQUERIDO (SALTA)
    @Test
    public void testUnJugadorCaeEnSaltaNorteUnBarrioQuePerteneceAOtroJugadorQueEdificoUnaCasaPierde3250(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Demi");
        Jugador jugador2 = new Jugador("Selena");
        List<Edificacion> listaCasasS = new ArrayList();
        listaCasasS.add(new Edificacion(4500, 3250));
        listaCasasS.add(new Edificacion(4500, 3850));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(7500, 5500));
        List<Edificacion> listaCasasN = new ArrayList();
        listaCasasN.add(new Edificacion(4500, 3250));
        listaCasasN.add(new Edificacion(4500, 3850));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(7500, 5500));
        BarrioDoble saltaSur = new BarrioDoble("Salta Sur", 23000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble saltaNorte = new BarrioDoble("Salta Norte", 23000, 2000, listaCasasN, listaHotelesN);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador1.caeEn(saltaSur, 4, tablero);
        jugador1.caeEn(saltaNorte, 4, tablero);
        saltaNorte.edificarCasa(jugador1);
        jugador2.caeEn(saltaNorte, 4, tablero);
        Assert.assertEquals(jugador2.capital(), 96750);
    }

    //ENTREGA 2: TEST 8 REQUERIDO (SALTA)
    @Test
    public void testUnJugadorCaeEnSaltaNorteUnBarrioQuePerteneceAOtroJugadorQueEdificoDosCasasPierde3850(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Demi");
        Jugador jugador2 = new Jugador("Selena");
        List<Edificacion> listaCasasS = new ArrayList();
        listaCasasS.add(new Edificacion(4500, 3250));
        listaCasasS.add(new Edificacion(4500, 3850));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(7500, 5500));
        List<Edificacion> listaCasasN = new ArrayList();
        listaCasasN.add(new Edificacion(4500, 3250));
        listaCasasN.add(new Edificacion(4500, 3850));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(7500, 5500));
        BarrioDoble saltaSur = new BarrioDoble("Salta Sur", 23000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble saltaNorte = new BarrioDoble("Salta Norte", 23000, 2000, listaCasasN, listaHotelesN);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador1.caeEn(saltaSur, 4, tablero);
        jugador1.caeEn(saltaNorte, 4, tablero);
        saltaNorte.edificarCasa(jugador1);
        saltaNorte.edificarCasa(jugador1);
        jugador2.caeEn(saltaNorte, 4, tablero);
        Assert.assertEquals(jugador2.capital(), 96150);
    }

    //ENTREGA 2: TEST 8 REQUERIDO (SALTA)
    @Test
    public void testJugadorNoPuedeEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosHermanosSalta(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS = new ArrayList();
        listaCasasS.add(new Edificacion(4500, 3250));
        listaCasasS.add(new Edificacion(4500, 3850));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(7500, 5500));
        List<Edificacion> listaCasasN = new ArrayList();
        listaCasasN.add(new Edificacion(4500, 3250));
        listaCasasN.add(new Edificacion(4500, 3850));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(7500, 5500));
        BarrioDoble saltaSur = new BarrioDoble("Salta Sur", 23000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble saltaNorte = new BarrioDoble("Salta Norte", 23000, 2000, listaCasasN, listaHotelesN);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador.caeEn(saltaSur, 4, tablero);
        jugador.caeEn(saltaNorte, 4, tablero);
        saltaNorte.edificarCasa(jugador);
        saltaNorte.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 49500);
    }

    //ENTREGA 2: TEST 8 REQUERIDO (SALTA)
    @Test
    public void testJugadorContruyeUnHotelYDecrementaSuCapitalSalta(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS = new ArrayList();
        listaCasasS.add(new Edificacion(4500, 3250));
        listaCasasS.add(new Edificacion(4500, 3850));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(7500, 5500));
        List<Edificacion> listaCasasN = new ArrayList();
        listaCasasN.add(new Edificacion(4500, 3250));
        listaCasasN.add(new Edificacion(4500, 3850));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(7500, 5500));
        BarrioDoble saltaSur = new BarrioDoble("Salta Sur", 23000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble saltaNorte = new BarrioDoble("Salta Norte", 23000, 2000, listaCasasN, listaHotelesN);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador.caeEn(saltaSur, 4, tablero);
        jugador.caeEn(saltaNorte, 4, tablero);
        saltaNorte.edificarCasa(jugador);
        saltaNorte.edificarCasa(jugador);
        saltaSur.edificarCasa(jugador);
        saltaSur.edificarCasa(jugador);
        saltaNorte.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 100000 - 2*23000 - 4*4500 - 7500);
    }

    //ENTREGA 2: TEST 8 REQUERIDO (SALTA)
    @Test
    public void testJugadorCaerEnUnHotelYDecrementaSuCapitalSalta(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Kevin");
        Jugador jugadorAct = new Jugador("nick");
        List<Edificacion> listaCasasS = new ArrayList();
        listaCasasS.add(new Edificacion(4500, 3250));
        listaCasasS.add(new Edificacion(4500, 3850));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(7500, 5500));
        List<Edificacion> listaCasasN = new ArrayList();
        listaCasasN.add(new Edificacion(4500, 3250));
        listaCasasN.add(new Edificacion(4500, 3850));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(7500, 5500));
        BarrioDoble saltaSur = new BarrioDoble("Salta Sur", 23000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble saltaNorte = new BarrioDoble("Salta Norte", 23000, 2000, listaCasasN, listaHotelesN);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador.caeEn(saltaNorte, 4, tablero);
        jugador.caeEn(saltaSur, 4, tablero);
        saltaNorte.edificarCasa(jugador);
        saltaNorte.edificarCasa(jugador);
        saltaSur.edificarCasa(jugador);
        saltaSur.edificarCasa(jugador);
        saltaNorte.edificarHotel(jugador);
        jugadorAct.caeEn(saltaNorte,2,tablero);
        Assert.assertEquals(jugadorAct.capital(), 94500);
    }
}
