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
        Jugador jugador = new Jugador("Lance");
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, new ArrayList<>() , null);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, new ArrayList<>(), null);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur, null);
        jugador.caeEn(buenosAiresNorte, null);
        Assert.assertTrue(buenosAiresSur.duenioDeAmbosHermanos());
    }

    @Test
    public void testUnJugadorPuedeEdificarUnaCasaAlTenerLosDosBarriosNecesariosBuenosAires(){
        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasas= new ArrayList<>();
        listaCasas.add(new Edificacion(5000, 3000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasas, null);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasas, null);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur,  null);
        jugador.caeEn(buenosAiresNorte,  null);
        Assert.assertTrue(buenosAiresSur.edificarCasa(jugador));
    }

    @Test
    public void testUnJugadorEdificaUnaCasaEnBuenosAiresSurBarrioDoblePierde5000(){
        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasas= new ArrayList<>();
        listaCasas.add(new Edificacion(5000, 3000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasas, null);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasas, null);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur,  null);
        jugador.caeEn(buenosAiresNorte,  null);
        buenosAiresSur.edificarCasa(jugador);
        Assert.assertEquals(jugador.capital(), 100000 - 20000 - 25000 - 5000);
    }

    @Test
    public void testUnJugadorCaeEnBuenosAiresSurUnBarrioDobleQuePerteneceAOtroJugadorQueEdificoUnaCasaPierde3000(){
        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        List<Edificacion> listaCasas= new ArrayList<>();
        listaCasas.add(new Edificacion(5000, 3000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasas, null);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasas, null);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador1.caeEn(buenosAiresSur, null);
        jugador1.caeEn(buenosAiresNorte, null);
        buenosAiresSur.edificarCasa(jugador1);
        buenosAiresNorte.edificarCasa(jugador1);
        jugador2.caeEn(buenosAiresSur, null);
        Assert.assertEquals(jugador2.capital(), 97000);
    }

    @Test
    public void testUnJugadorCaeEnBuenosAiresSurUnBarrioDobleQuePerteneceAOtroJugadorQueEdificoDosCasaAhiYUnaEnBuenosAiresNortePierde3500(){
        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        List<Edificacion> listaCasasS= new ArrayList<>();
        listaCasasS.add(new Edificacion(5000, 3000));
        listaCasasS.add(new Edificacion(5000, 3500));
        List<Edificacion> listaCasasN= new ArrayList<>();
        listaCasasN.add(new Edificacion(5500, 3500));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasasS, null);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasasN, null);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador1.caeEn(buenosAiresSur, null);
        jugador1.caeEn(buenosAiresNorte, null);
        buenosAiresSur.edificarCasa(jugador1);
        buenosAiresSur.edificarCasa(jugador1);
        buenosAiresNorte.edificarCasa(jugador1);
        jugador2.caeEn(buenosAiresSur, null);
        Assert.assertEquals(jugador2.capital(), 96500);
    }

    @Test
    public void testJugadorNoPuedeEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosDoblesBuenosAires(){
        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasasS= new ArrayList<>();
        listaCasasS.add(new Edificacion(5000, 3000));
        listaCasasS.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHotelesS = new ArrayList<>();
        listaHotelesS.add(new Edificacion(8000, 5000));
        List<Edificacion> listaCasasN= new ArrayList<>();
        listaCasasN.add(new Edificacion(5500, 3500));
        listaCasasN.add(new Edificacion(5500, 4000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasasN, null);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur, null);
        jugador.caeEn(buenosAiresNorte, null);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        Assert.assertFalse(buenosAiresSur.edificarHotel(jugador));
    }

    @Test
    public void testJugadorNoSeLeRestaCapitalAlTratarDeEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosDoblesBuenosAires(){
        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasasS= new ArrayList<>();
        listaCasasS.add(new Edificacion(5000, 3000));
        listaCasasS.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHotelesS = new ArrayList<>();
        listaHotelesS.add(new Edificacion(8000, 5000));
        List<Edificacion> listaCasasN= new ArrayList<>();
        listaCasasN.add(new Edificacion(5500, 3500));
        listaCasasN.add(new Edificacion(5500, 4000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasasN, null);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur, null);
        jugador.caeEn(buenosAiresNorte, null);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresSur.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 100000 - 20000 - 25000 - 5000);
    }

    @Test
    public void testJugadorContruyeUnHotelYDecrementaSuCapitalBuenosAiresSurPierde8000(){
        Jugador jugador = new Jugador("Nick");
        List<Edificacion> listaCasasS= new ArrayList<>();
        listaCasasS.add(new Edificacion(5000, 3000));
        listaCasasS.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHotelesS = new ArrayList<>();
        listaHotelesS.add(new Edificacion(8000, 5000));
        List<Edificacion> listaCasasN= new ArrayList<>();
        listaCasasN.add(new Edificacion(5500, 3500));
        listaCasasN.add(new Edificacion(5500, 4000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasasN, null);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur, null);
        jugador.caeEn(buenosAiresNorte, null);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        buenosAiresSur.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 100000 - 20000 - 25000 - 10000 - 11000 - 8000);
    }

    @Test
    public void testJugadorCaeEnCasilleroConHotelYSeDecrementaSuCapitalBuenosAires(){
        Jugador jugador = new Jugador("Nick");
        Jugador jugadorAct = new Jugador("Joe");
        List<Edificacion> listaCasasS= new ArrayList<>();
        listaCasasS.add(new Edificacion(5000, 3000));
        listaCasasS.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHotelesS = new ArrayList<>();
        listaHotelesS.add(new Edificacion(8000, 5000));
        List<Edificacion> listaCasasN= new ArrayList<>();
        listaCasasN.add(new Edificacion(5500, 3500));
        listaCasasN.add(new Edificacion(5500, 4000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasasN, null);
        buenosAiresSur.setHermano(buenosAiresNorte);
        buenosAiresNorte.setHermano(buenosAiresSur);
        jugador.caeEn(buenosAiresSur, null);
        jugador.caeEn(buenosAiresNorte, null);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        buenosAiresSur.edificarHotel(jugador);
        jugadorAct.caeEn(buenosAiresSur,null);
        Assert.assertEquals(jugadorAct.capital(),95000 );
    }

    @Test
    public void testUnJugadorPuedeEdificarUnaCasaAlTenerLosDosBarriosNecesariosCordoba(){
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS= new ArrayList<>();
        listaCasasS.add(new Edificacion(2000, 1500));
        List<Edificacion> listaCasasN= new ArrayList<>();
        listaCasasN.add(new Edificacion(2200, 1800));
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Aires Sur", 18000, 1000, listaCasasS, null);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, null);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador.caeEn(cordobaSur, null);
        jugador.caeEn(cordobaNorte, null);
        cordobaNorte.edificarCasa(jugador);
        Assert.assertEquals(jugador.capital(), 59800);
    }

    @Test
    public void testUnJugadorCaeEnCordobaSurUnBarrioQuePerteneceAOtroJugadorQueEdificoUnaCasaPierde1500(){
        Jugador jugador1 = new Jugador("Demi");
        Jugador jugador2 = new Jugador("Selena");
        List<Edificacion> listaCasasS= new ArrayList<>();
        listaCasasS.add(new Edificacion(2000, 1500));
        List<Edificacion> listaCasasN= new ArrayList<>();
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Aires Sur", 18000, 1000, listaCasasS, null);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, null);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador1.caeEn(cordobaSur, null);
        jugador1.caeEn(cordobaNorte, null);
        cordobaSur.edificarCasa(jugador1);
        jugador2.caeEn(cordobaSur, null);
        Assert.assertEquals(jugador2.capital(), 98500);
    }

    @Test
    public void testUnJugadorCaeEnCordobaSurUnBarrioQuePerteneceAOtroJugadorQueEdificoDosCasaEnEseMismoBarrioPierde2500(){
        Jugador jugador1 = new Jugador("Demi");
        Jugador jugador2 = new Jugador("Selena");
        List<Edificacion> listaCasasS= new ArrayList<>();
        listaCasasS.add(new Edificacion(2000, 1500));
        listaCasasS.add(new Edificacion(2000, 2500));
        List<Edificacion> listaCasasN= new ArrayList<>();
        listaCasasN.add(new Edificacion(2200, 1800));
        listaCasasN.add(new Edificacion(2200, 2900));
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Aires Sur", 18000, 1000, listaCasasS, null);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, null);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador1.caeEn(cordobaSur, null);
        jugador1.caeEn(cordobaNorte, null);
        cordobaSur.edificarCasa(jugador1);
        cordobaSur.edificarCasa(jugador1);
        jugador2.caeEn(cordobaSur, null);
        Assert.assertEquals(jugador2.capital(), 97500);
    }

    @Test
    public void testJugadorNoSeLeRestaCapitalAlEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosDoblesCordoba(){
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS= new ArrayList<>();
        listaCasasS.add(new Edificacion(2000, 1500));
        listaCasasS.add(new Edificacion(2000, 2500));
        List<Edificacion> listaCasasN= new ArrayList<>();
        listaCasasN.add(new Edificacion(2200, 1800));
        listaCasasN.add(new Edificacion(2200, 2900));
        List<Edificacion> listaHotelesN = new ArrayList<>();
        listaHotelesN.add(new Edificacion(3500, 3500));
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Aires Sur", 18000, 1000, listaCasasS, null);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, listaHotelesN);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador.caeEn(cordobaSur, null);
        jugador.caeEn(cordobaNorte, null);
        cordobaNorte.edificarCasa(jugador);
        cordobaNorte.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 59800);
    }

    @Test
    public void testJugadorContruyeUnHotelYDecrementaSuCapitalCordoba(){
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS= new ArrayList<>();
        listaCasasS.add(new Edificacion(2000, 1500));
        listaCasasS.add(new Edificacion(2000, 2500));
        List<Edificacion> listaCasasN= new ArrayList<>();
        listaCasasN.add(new Edificacion(2200, 1800));
        listaCasasN.add(new Edificacion(2200, 2900));
        List<Edificacion> listaHotelesN = new ArrayList<>();
        listaHotelesN.add(new Edificacion(3500, 3500));
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Aires Sur", 18000, 1000, listaCasasS, null);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, listaHotelesN);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador.caeEn(cordobaSur, null);
        jugador.caeEn(cordobaNorte, null);
        cordobaNorte.edificarCasa(jugador);
        cordobaNorte.edificarCasa(jugador);
        cordobaSur.edificarCasa(jugador);
        cordobaSur.edificarCasa(jugador);
        cordobaNorte.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 50100);
    }

    @Test
    public void testJugadorCaeEnCasilleroConHotelYSeDecrementaSuCapitalCordoba(){
        Jugador jugador = new Jugador("Kevin");
        Jugador jugadorAct = new Jugador("Kevin");
        List<Edificacion> listaCasasS= new ArrayList<>();
        listaCasasS.add(new Edificacion(2000, 1500));
        listaCasasS.add(new Edificacion(2000, 2500));
        List<Edificacion> listaCasasN= new ArrayList<>();
        listaCasasN.add(new Edificacion(2200, 1800));
        listaCasasN.add(new Edificacion(2200, 2900));
        List<Edificacion> listaHotelesN = new ArrayList<>();
        listaHotelesN.add(new Edificacion(3500, 3500));
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Aires Sur", 18000, 1000, listaCasasS, null);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, listaHotelesN);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador.caeEn(cordobaSur, null);
        jugador.caeEn(cordobaNorte, null);
        cordobaNorte.edificarCasa(jugador);
        cordobaNorte.edificarCasa(jugador);
        cordobaSur.edificarCasa(jugador);
        cordobaSur.edificarCasa(jugador);
        cordobaNorte.edificarHotel(jugador);
        jugadorAct.caeEn(cordobaNorte,null);
        Assert.assertEquals(jugadorAct.capital(), 96500);
    }

    @Test
    public void testUnJugadorPuedeEdificarUnaCasaAlTenerLosDosBarriosNecesariosSalta(){
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS = new ArrayList<>();
        listaCasasS.add(new Edificacion(4500, 3250));
        listaCasasS.add(new Edificacion(4500, 3850));
        List<Edificacion> listaCasasN = new ArrayList<>();
        listaCasasN.add(new Edificacion(4500, 3250));
        listaCasasN.add(new Edificacion(4500, 3850));
        BarrioDoble saltaSur = new BarrioDoble("Salta Sur", 23000, 2000, listaCasasS, null);
        BarrioDoble saltaNorte = new BarrioDoble("Salta Norte", 23000, 2000, listaCasasN, null);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador.caeEn(saltaSur, null);
        jugador.caeEn(saltaNorte, null);
        saltaNorte.edificarCasa(jugador);
        Assert.assertEquals(jugador.capital(), 49500);
    }

    @Test
    public void testUnJugadorCaeEnSaltaNorteUnBarrioQuePerteneceAOtroJugadorQueEdificoUnaCasaPierde3250(){
        Jugador jugador1 = new Jugador("Demi");
        Jugador jugador2 = new Jugador("Selena");
        List<Edificacion> listaCasasS = new ArrayList<>();
        listaCasasS.add(new Edificacion(4500, 3250));
        listaCasasS.add(new Edificacion(4500, 3850));
        List<Edificacion> listaCasasN = new ArrayList<>();
        listaCasasN.add(new Edificacion(4500, 3250));
        listaCasasN.add(new Edificacion(4500, 3850));
        BarrioDoble saltaSur = new BarrioDoble("Salta Sur", 23000, 2000, listaCasasS, null);
        BarrioDoble saltaNorte = new BarrioDoble("Salta Norte", 23000, 2000, listaCasasN, null);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador1.caeEn(saltaSur, null);
        jugador1.caeEn(saltaNorte, null);
        saltaNorte.edificarCasa(jugador1);
        jugador2.caeEn(saltaNorte, null);
        Assert.assertEquals(jugador2.capital(), 96750);
    }

    @Test
    public void testUnJugadorCaeEnSaltaNorteUnBarrioQuePerteneceAOtroJugadorQueEdificoDosCasasPierde3850(){
        Jugador jugador1 = new Jugador("Demi");
        Jugador jugador2 = new Jugador("Selena");
        List<Edificacion> listaCasasS = new ArrayList<>();
        listaCasasS.add(new Edificacion(4500, 3250));
        listaCasasS.add(new Edificacion(4500, 3850));
        List<Edificacion> listaCasasN = new ArrayList<>();
        listaCasasN.add(new Edificacion(4500, 3250));
        listaCasasN.add(new Edificacion(4500, 3850));
        BarrioDoble saltaSur = new BarrioDoble("Salta Sur", 23000, 2000, listaCasasS, null);
        BarrioDoble saltaNorte = new BarrioDoble("Salta Norte", 23000, 2000, listaCasasN, null);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador1.caeEn(saltaSur, null);
        jugador1.caeEn(saltaNorte, null);
        saltaNorte.edificarCasa(jugador1);
        saltaNorte.edificarCasa(jugador1);
        jugador2.caeEn(saltaNorte, null);
        Assert.assertEquals(jugador2.capital(), 96150);
    }

    @Test
    public void testJugadorNoPuedeEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosHermanosSalta(){
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS = new ArrayList<>();
        listaCasasS.add(new Edificacion(4500, 3250));
        listaCasasS.add(new Edificacion(4500, 3850));
        List<Edificacion> listaCasasN = new ArrayList<>();
        listaCasasN.add(new Edificacion(4500, 3250));
        listaCasasN.add(new Edificacion(4500, 3850));
        List<Edificacion> listaHotelesN = new ArrayList<>();
        listaHotelesN.add(new Edificacion(7500, 5500));
        BarrioDoble saltaSur = new BarrioDoble("Salta Sur", 23000, 2000, listaCasasS, null);
        BarrioDoble saltaNorte = new BarrioDoble("Salta Norte", 23000, 2000, listaCasasN, listaHotelesN);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador.caeEn(saltaSur, null);
        jugador.caeEn(saltaNorte, null);
        saltaNorte.edificarCasa(jugador);
        saltaNorte.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 49500);
    }

    @Test
    public void testJugadorContruyeUnHotelYDecrementaSuCapitalSalta(){
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS = new ArrayList<>();
        listaCasasS.add(new Edificacion(4500, 3250));
        listaCasasS.add(new Edificacion(4500, 3850));
        List<Edificacion> listaCasasN = new ArrayList<>();
        listaCasasN.add(new Edificacion(4500, 3250));
        listaCasasN.add(new Edificacion(4500, 3850));
        List<Edificacion> listaHotelesN = new ArrayList<>();
        listaHotelesN.add(new Edificacion(7500, 5500));
        BarrioDoble saltaSur = new BarrioDoble("Salta Sur", 23000, 2000, listaCasasS, null);
        BarrioDoble saltaNorte = new BarrioDoble("Salta Norte", 23000, 2000, listaCasasN, listaHotelesN);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador.caeEn(saltaSur, null);
        jugador.caeEn(saltaNorte, null);
        saltaNorte.edificarCasa(jugador);
        saltaNorte.edificarCasa(jugador);
        saltaSur.edificarCasa(jugador);
        saltaSur.edificarCasa(jugador);
        saltaNorte.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 100000 - 2*23000 - 4*4500 - 7500);
    }

    @Test
    public void testJugadorCaerEnUnHotelYDecrementaSuCapitalSalta(){
        Jugador jugador = new Jugador("Kevin");
        Jugador jugadorAct = new Jugador("nick");
        List<Edificacion> listaCasasS = new ArrayList<>();
        listaCasasS.add(new Edificacion(4500, 3250));
        listaCasasS.add(new Edificacion(4500, 3850));
        List<Edificacion> listaCasasN = new ArrayList<>();
        listaCasasN.add(new Edificacion(4500, 3250));
        listaCasasN.add(new Edificacion(4500, 3850));
        List<Edificacion> listaHotelesN = new ArrayList<>();
        listaHotelesN.add(new Edificacion(7500, 5500));
        BarrioDoble saltaSur = new BarrioDoble("Salta Sur", 23000, 2000, listaCasasS, null);
        BarrioDoble saltaNorte = new BarrioDoble("Salta Norte", 23000, 2000, listaCasasN, listaHotelesN);
        saltaSur.setHermano(saltaNorte);
        saltaNorte.setHermano(saltaSur);
        jugador.caeEn(saltaNorte, null);
        jugador.caeEn(saltaSur, null);
        saltaNorte.edificarCasa(jugador);
        saltaNorte.edificarCasa(jugador);
        saltaSur.edificarCasa(jugador);
        saltaSur.edificarCasa(jugador);
        saltaNorte.edificarHotel(jugador);
        jugadorAct.caeEn(saltaNorte,null);
        Assert.assertEquals(jugadorAct.capital(), 94500);
    }

    @Test
    public void testVentaDeTerrenoEdificadoEliminaLasPropiedades(){
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS= new ArrayList<>();
        listaCasasS.add(new Edificacion(2000, 1500));
        listaCasasS.add(new Edificacion(2000, 2500));
        List<Edificacion> listaHotelesS = new ArrayList<>();
        listaHotelesS.add(new Edificacion(3000, 3000));
        List<Edificacion> listaCasasN= new ArrayList<>();
        listaCasasN.add(new Edificacion(2200, 1800));
        listaCasasN.add(new Edificacion(2200, 2900));
        List<Edificacion> listaHotelesN = new ArrayList<>();
        listaHotelesN.add(new Edificacion(3500, 3500));
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Aires Sur", 18000, 1000, listaCasasS, listaHotelesS);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, listaHotelesN);
        cordobaSur.setHermano(cordobaNorte);
        cordobaNorte.setHermano(cordobaSur);
        jugador.caeEn(cordobaSur, null);
        jugador.caeEn(cordobaNorte, null);
        cordobaNorte.edificarCasa(jugador);
        jugador.venderAlBanco(cordobaNorte);
        Jugador jugador1 = new Jugador("Marcos");
        jugador1.caeEn(cordobaNorte,null);
        Jugador jugador2 = new Jugador("Loreto");
        jugador2.caeEn(cordobaNorte,null);
        Assert.assertEquals(100000 - 1300 ,jugador2.capital());

    }
}
