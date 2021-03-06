package Modelo.Casilleros;

import Modelo.Edificacion;
import Modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

import Modelo.Municipio;
import org.junit.Assert;
import org.junit.Test;

public class BarrioDobleTest {
    @Test
    public void testDosBarriosPertenecenAlMismoJugadorEsTrue() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        Jugador jugador = new Jugador("Lance");
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, new ArrayList<>(), null);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, new ArrayList<>(), null);
        jugador.caeEn(buenosAiresSur);
        buenosAiresSur.comprar(jugador);
        jugador.caeEn(buenosAiresNorte);
        buenosAiresNorte.comprar(jugador);
        Assert.assertTrue(buenosAiresSur.duenioDeAmbosHermanos());
    }


    @Test
    public void testUnJugadorPuedeEdificarUnaCasaAlTenerLosDosBarriosNecesariosBuenosAires() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();

        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasas = new ArrayList<>();
        listaCasas.add(new Edificacion(5000, 3000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasas, null);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasas, null);

        jugador.caeEn(buenosAiresSur);
        buenosAiresSur.comprar(jugador);
        jugador.caeEn(buenosAiresNorte);
        buenosAiresNorte.comprar(jugador);
        Assert.assertTrue(buenosAiresSur.edificarCasa(jugador));
    }

    @Test
    public void testUnJugadorEdificaUnaCasaEnBuenosAiresSurBarrioDoblePierde5000() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasas = new ArrayList<>();
        listaCasas.add(new Edificacion(5000, 3000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasas, null);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasas, null);
        jugador.caeEn(buenosAiresSur);
        buenosAiresSur.comprar(jugador);
        jugador.caeEn(buenosAiresNorte);
        buenosAiresNorte.comprar(jugador);
        buenosAiresSur.edificarCasa(jugador);
        Assert.assertEquals(jugador.capital(), 100000 - 20000 - 25000 - 5000);
    }

    @Test
    public void testUnJugadorCaeEnBuenosAiresSurUnBarrioDobleQuePerteneceAOtroJugadorQueEdificoUnaCasaPierde3000() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        List<Edificacion> listaCasas = new ArrayList<>();
        listaCasas.add(new Edificacion(5000, 3000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasas, null);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasas, null);

        jugador1.caeEn(buenosAiresSur);
        buenosAiresSur.comprar(jugador1);
        jugador1.caeEn(buenosAiresNorte);
        buenosAiresNorte.comprar(jugador1);
        buenosAiresSur.edificarCasa(jugador1);
        buenosAiresNorte.edificarCasa(jugador1);
        jugador2.caeEn(buenosAiresSur);
        Assert.assertEquals(jugador2.capital(), 97000);
    }

    @Test
    public void testUnJugadorCaeEnBuenosAiresSurUnBarrioDobleQuePerteneceAOtroJugadorQueEdificoDosCasaAhiYUnaEnBuenosAiresNortePierde3500() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");

        List<Edificacion> listaCasasS = new ArrayList<>();
        listaCasasS.add(new Edificacion(5000, 3000));
        listaCasasS.add(new Edificacion(5000, 3500));

        List<Edificacion> listaCasasN = new ArrayList<>();
        listaCasasN.add(new Edificacion(5500, 3500));

        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasasS, null);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasasN, null);

        jugador1.caeEn(buenosAiresSur);
        buenosAiresSur.comprar(jugador1);
        jugador1.caeEn(buenosAiresNorte);
        buenosAiresNorte.comprar(jugador1);
        buenosAiresSur.edificarCasa(jugador1);
        buenosAiresSur.edificarCasa(jugador1);
        buenosAiresNorte.edificarCasa(jugador1);
        jugador2.caeEn(buenosAiresSur);
        Assert.assertEquals(jugador2.capital(), 100000-3500);
    }





    @Test
    public void testJugadorNoPuedeEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosDoblesBuenosAires() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasasS = new ArrayList<>();
        listaCasasS.add(new Edificacion(5000, 3000));
        listaCasasS.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHotelesS = new ArrayList<>();
        listaHotelesS.add(new Edificacion(8000, 5000));
        List<Edificacion> listaCasasN = new ArrayList<>();
        listaCasasN.add(new Edificacion(5500, 3500));
        listaCasasN.add(new Edificacion(5500, 4000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasasN, null);

        jugador.caeEn(buenosAiresSur);
        buenosAiresSur.comprar(jugador);
        jugador.caeEn(buenosAiresNorte);
        buenosAiresNorte.comprar(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        Assert.assertFalse(buenosAiresSur.edificarHotel(jugador));
    }

    @Test
    public void testJugadorNoSeLeRestaCapitalAlTratarDeEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosDoblesBuenosAires() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasasS = new ArrayList<>();
        listaCasasS.add(new Edificacion(5000, 3000));
        listaCasasS.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHotelesS = new ArrayList<>();
        listaHotelesS.add(new Edificacion(8000, 5000));
        List<Edificacion> listaCasasN = new ArrayList<>();
        listaCasasN.add(new Edificacion(5500, 3500));
        listaCasasN.add(new Edificacion(5500, 4000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasasN, null);

        jugador.caeEn(buenosAiresSur);
        buenosAiresSur.comprar(jugador);
        jugador.caeEn(buenosAiresNorte);
        buenosAiresNorte.comprar(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresSur.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 100000 - 20000 - 25000 - 5000);
    }

    @Test
    public void testJugadorContruyeUnHotelYDecrementaSuCapitalBuenosAiresSurPierde8000(){
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
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

        jugador.caeEn(buenosAiresSur);
        buenosAiresSur.comprar(jugador);
        jugador.caeEn(buenosAiresNorte);
        buenosAiresNorte.comprar(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        buenosAiresSur.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 100000 - 20000 - 25000 - 10000 - 11000 - 8000);
    }

    @Test
    public void testJugadorCaeEnCasilleroConHotelYSeDecrementaSuCapitalBuenosAires() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        Jugador jugador = new Jugador("Nick");
        Jugador jugadorAct = new Jugador("Joe");
        List<Edificacion> listaCasasS = new ArrayList<>();
        listaCasasS.add(new Edificacion(5000, 3000));
        listaCasasS.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHotelesS = new ArrayList<>();
        listaHotelesS.add(new Edificacion(8000, 5000));
        List<Edificacion> listaCasasN = new ArrayList<>();
        listaCasasN.add(new Edificacion(5500, 3500));
        listaCasasN.add(new Edificacion(5500, 4000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasasN, null);
        jugador.caeEn(buenosAiresSur);
        buenosAiresSur.comprar(jugador);
        jugador.caeEn(buenosAiresNorte);
        buenosAiresNorte.comprar(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresSur.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        buenosAiresNorte.edificarCasa(jugador);
        buenosAiresSur.edificarHotel(jugador);
        jugadorAct.caeEn(buenosAiresSur);
        Assert.assertEquals(jugadorAct.capital(), 95000);
    }


    @Test
    public void testUnJugadorPuedeEdificarUnaCasaAlTenerLosDosBarriosNecesariosCordoba() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS = new ArrayList<>();
        listaCasasS.add(new Edificacion(2000, 1500));
        List<Edificacion> listaCasasN = new ArrayList<>();
        listaCasasN.add(new Edificacion(2200, 1800));
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Sur", 18000, 1000, listaCasasS, null);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, null);
        jugador.caeEn(cordobaSur);
        cordobaSur.comprar(jugador);
        jugador.caeEn(cordobaNorte);
        cordobaNorte.comprar(jugador);
        cordobaNorte.edificarCasa(jugador);
        Assert.assertEquals(jugador.capital(), 59800);
    }

    @Test
    public void testUnJugadorCaeEnCordobaSurUnBarrioQuePerteneceAOtroJugadorQueEdificoUnaCasaPierde1500() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        Jugador jugador1 = new Jugador("Demi");
        Jugador jugador2 = new Jugador("Selena");
        List<Edificacion> listaCasasS = new ArrayList<>();
        listaCasasS.add(new Edificacion(2000, 1500));
        List<Edificacion> listaCasasN = new ArrayList<>();
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Sur", 18000, 1000, listaCasasS, null);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, null);

        jugador1.caeEn(cordobaSur);
        cordobaSur.comprar(jugador1);
        jugador1.caeEn(cordobaNorte);
        cordobaNorte.comprar(jugador1);
        cordobaSur.edificarCasa(jugador1);
        jugador2.caeEn(cordobaSur);
        Assert.assertEquals(jugador2.capital(), 98500);
    }

    @Test
    public void testUnJugadorCaeEnCordobaSurUnBarrioQuePerteneceAOtroJugadorQueEdificoDosCasaEnEseMismoBarrioPierde2500() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        Jugador jugador1 = new Jugador("Demi");
        Jugador jugador2 = new Jugador("Selena");
        List<Edificacion> listaCasasS = new ArrayList<>();
        listaCasasS.add(new Edificacion(2000, 1500));
        listaCasasS.add(new Edificacion(2000, 2500));
        List<Edificacion> listaCasasN = new ArrayList<>();
        listaCasasN.add(new Edificacion(2200, 1800));
        listaCasasN.add(new Edificacion(2200, 2900));
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Sur", 18000, 1000, listaCasasS, null);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, null);

        jugador1.caeEn(cordobaSur);
        cordobaSur.comprar(jugador1);
        jugador1.caeEn(cordobaNorte);
        cordobaNorte.comprar(jugador1);
        cordobaSur.edificarCasa(jugador1);
        cordobaSur.edificarCasa(jugador1);
        jugador2.caeEn(cordobaSur);
        Assert.assertEquals(jugador2.capital(), 97500);
    }

    @Test
    public void testJugadorNoSeLeRestaCapitalAlEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosDoblesCordoba(){
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS= new ArrayList<>();
        listaCasasS.add(new Edificacion(2000, 1500));
        listaCasasS.add(new Edificacion(2000, 2500));
        List<Edificacion> listaCasasN= new ArrayList<>();
        listaCasasN.add(new Edificacion(2200, 1800));
        listaCasasN.add(new Edificacion(2200, 2900));
        List<Edificacion> listaHotelesN = new ArrayList<>();
        listaHotelesN.add(new Edificacion(3500, 3500));
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Sur", 18000, 1000, listaCasasS, null);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, listaHotelesN);

        jugador.caeEn(cordobaSur);
        cordobaSur.comprar(jugador);
        jugador.caeEn(cordobaNorte);
        cordobaNorte.comprar(jugador);
        cordobaNorte.edificarCasa(jugador);
        cordobaNorte.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 59800);
    }

   @Test
   public void testJugadorContruyeUnHotelYDecrementaSuCapitalCordoba() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS = new ArrayList<>();
        listaCasasS.add(new Edificacion(2000, 1500));
        listaCasasS.add(new Edificacion(2000, 2500));
        List<Edificacion> listaCasasN = new ArrayList<>();
        listaCasasN.add(new Edificacion(2200, 1800));
        listaCasasN.add(new Edificacion(2200, 2900));
        List<Edificacion> listaHotelesN = new ArrayList<>();
        listaHotelesN.add(new Edificacion(3500, 3500));
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Sur", 18000, 1000, listaCasasS, null);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, listaHotelesN);

        jugador.caeEn(cordobaSur);
        cordobaSur.comprar(jugador);
        jugador.caeEn(cordobaNorte);
        cordobaNorte.comprar(jugador);
        cordobaNorte.edificarCasa(jugador);
        cordobaNorte.edificarCasa(jugador);
        cordobaSur.edificarCasa(jugador);
        cordobaSur.edificarCasa(jugador);
        cordobaNorte.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 50100);
    }

   @Test
   public void testJugadorCaeEnCasilleroConHotelYSeDecrementaSuCapitalCordoba() {
       Municipio municipio = Municipio.getInstance();
       municipio.resetear();
       Jugador jugador = new Jugador("Kevin");
       Jugador jugadorAct = new Jugador("Kevin");
       List<Edificacion> listaCasasS = new ArrayList<>();
       listaCasasS.add(new Edificacion(2000, 1500));
       listaCasasS.add(new Edificacion(2000, 2500));
       List<Edificacion> listaCasasN = new ArrayList<>();
       listaCasasN.add(new Edificacion(2200, 1800));
       listaCasasN.add(new Edificacion(2200, 2900));
       List<Edificacion> listaHotelesN = new ArrayList<>();
       listaHotelesN.add(new Edificacion(3500, 3500));
       BarrioDoble cordobaSur = new BarrioDoble("Cordoba Sur", 18000, 1000, listaCasasS, null);
       BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, listaHotelesN);

       jugador.caeEn(cordobaSur);
       cordobaSur.comprar(jugador);
       jugador.caeEn(cordobaNorte);
       cordobaNorte.comprar(jugador);
       cordobaNorte.edificarCasa(jugador);
       cordobaNorte.edificarCasa(jugador);
       cordobaSur.edificarCasa(jugador);
       cordobaSur.edificarCasa(jugador);
       cordobaNorte.edificarHotel(jugador);
       jugadorAct.caeEn(cordobaNorte);
       Assert.assertEquals(jugadorAct.capital(), 96500);
    }

    @Test
    public void testUnJugadorPuedeEdificarUnaCasaAlTenerLosDosBarriosNecesariosSalta() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS = new ArrayList<>();
        listaCasasS.add(new Edificacion(4500, 3250));
        listaCasasS.add(new Edificacion(4500, 3850));
        List<Edificacion> listaCasasN = new ArrayList<>();
        listaCasasN.add(new Edificacion(4500, 3250));
        listaCasasN.add(new Edificacion(4500, 3850));
        BarrioDoble saltaSur = new BarrioDoble("Salta Sur", 23000, 2000, listaCasasS, null);
        BarrioDoble saltaNorte = new BarrioDoble("Salta Norte", 23000, 2000, listaCasasN, null);

        jugador.caeEn(saltaSur);
        saltaSur.comprar(jugador);
        jugador.caeEn(saltaNorte);
        saltaNorte.comprar(jugador);
        saltaNorte.edificarCasa(jugador);
        Assert.assertEquals(jugador.capital(), 49500);
    }


    @Test
    public void testUnJugadorCaeEnSaltaNorteUnBarrioQuePerteneceAOtroJugadorQueEdificoUnaCasaPierde3250() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
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

        jugador1.caeEn(saltaSur);
        saltaSur.comprar(jugador1);
        jugador1.caeEn(saltaNorte);
        saltaNorte.comprar(jugador1);
        saltaNorte.edificarCasa(jugador1);
        jugador2.caeEn(saltaNorte);
        Assert.assertEquals(jugador2.capital(), 96750);
    }
    @Test
    public void testUnJugadorCaeEnSaltaNorteUnBarrioQuePerteneceAOtroJugadorQueEdificoDosCasasPierde3850() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
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

        jugador1.caeEn(saltaSur);
        saltaSur.comprar(jugador1);
        jugador1.caeEn(saltaNorte);
        saltaNorte.comprar(jugador1);
        saltaNorte.edificarCasa(jugador1);
        saltaNorte.edificarCasa(jugador1);
        jugador2.caeEn(saltaNorte);
        Assert.assertEquals(jugador2.capital(), 96150);
    }
    @Test
    public void testJugadorNoPuedeEdificarHotelAlNoTenerTodasLasCasasEdificadasNecesariasDeAmbosBarriosHermanosSalta() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
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

        jugador.caeEn(saltaSur);
        saltaSur.comprar(jugador);
        jugador.caeEn(saltaNorte);
        saltaNorte.comprar(jugador);
        saltaNorte.edificarCasa(jugador);
        saltaNorte.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 49500);
    }

    @Test
    public void testJugadorContruyeUnHotelYDecrementaSuCapitalSalta() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
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
        jugador.caeEn(saltaSur);
        saltaSur.comprar(jugador);
        jugador.caeEn(saltaNorte);
        saltaNorte.comprar(jugador);
        saltaNorte.edificarCasa(jugador);
        saltaNorte.edificarCasa(jugador);
        saltaSur.edificarCasa(jugador);
        saltaSur.edificarCasa(jugador);
        saltaNorte.edificarHotel(jugador);
        Assert.assertEquals(jugador.capital(), 100000 - 2 * 23000 - 4 * 4500 - 7500);
    }



    @Test
    public void testJugadorCaerEnUnHotelYDecrementaSuCapitalSalta(){
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
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

        jugador.caeEn(saltaNorte);
        saltaNorte.comprar(jugador);
        jugador.caeEn(saltaSur);
        saltaSur.comprar(jugador);
        saltaNorte.edificarCasa(jugador);
        saltaNorte.edificarCasa(jugador);
        saltaSur.edificarCasa(jugador);
        saltaSur.edificarCasa(jugador);
        saltaNorte.edificarHotel(jugador);
        jugadorAct.caeEn(saltaNorte);
        Assert.assertEquals(jugadorAct.capital(), 94500);
    }

    @Test
    public void testVentaDeTerrenoEdificadoEliminaLasPropiedades(){
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        Jugador jugador = new Jugador("Kevin");
        List<Edificacion> listaCasasS= new ArrayList<>();
        listaCasasS.add(new Edificacion(2000, 1500));
        listaCasasS.add(new Edificacion(2000, 2500));
        List<Edificacion> listaCasasN= new ArrayList<>();
        listaCasasN.add(new Edificacion(2200, 1800));
        listaCasasN.add(new Edificacion(2200, 2900));
        BarrioDoble cordobaSur = new BarrioDoble("Cordoba Aires Sur", 18000, 1000, listaCasasS, null);
        BarrioDoble cordobaNorte = new BarrioDoble("Cordoba Norte", 20000, 1300, listaCasasN, null);

        jugador.caeEn(cordobaSur);
        cordobaSur.comprar(jugador);
        jugador.caeEn(cordobaNorte);
        cordobaNorte.comprar(jugador);
        cordobaNorte.edificarCasa(jugador);
        jugador.venderAlBanco(cordobaNorte);
        Jugador jugador1 = new Jugador("Marcos");
        jugador1.caeEn(cordobaNorte);
        cordobaNorte.comprar(jugador1);
        Jugador jugador2 = new Jugador("Loreto");
        jugador2.caeEn(cordobaNorte);

        Assert.assertEquals(100000 - 1300 ,jugador2.capital());

    }
}
