package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class ServicioTest {

    @Test
    public void testJugadorCaeEnTrenAdueniadoPorOtroJugadorQueNoTieneSubte(){

        int numDado = 4;
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        Servicio servicio = new Servicio("Tren",38000,450,800,"Subte");
        jugador.caeEn(servicio,4,tablero);
        Jugador jugador1 = new Jugador("Martin");
        jugador1.caeEn(servicio,numDado,tablero);
        Assert.assertEquals(100000 - (450*numDado),jugador1.capital());

    }

    @Test
    public void testJugadorCaeEnEdesurAdueniadoPorOtroJugadorQueNoTieneAysa(){

        int numDado = 4;
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        Servicio servicio = new Servicio("Edesur",35000,500,1000,"Aysa");
        jugador.caeEn(servicio,4,tablero);
        Jugador jugador1 = new Jugador("Martin");
        jugador1.caeEn(servicio,numDado,tablero);
        Assert.assertEquals(100000 - (500*numDado),jugador1.capital());
    }

    @Test
    public void testJugadorCaeEnEdesurPeroEsDuenioPorLoQueNoSeLeCobra(){

        int numDado = 4;
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        Servicio servicio = new Servicio("Edesur",35000,500,1000,"Aysa");
        jugador.caeEn(servicio,4,tablero);
        jugador.caeEn(servicio,numDado,tablero);
        Assert.assertEquals(100000 - 35000,jugador.capital());

    }

    @Test
    public void testJugadorCaeEnEdesurPeroElDuenioTambienPoseeAysa(){

        int numDado = 4;
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        Servicio servicio1 = new Servicio("Edesur",35000,500,1000,"Aysa");
        Servicio servicio2 = new Servicio("Aysa",30000,300,5000,"Edesur");
        jugador.caeEn(servicio2,4,tablero);
        jugador.caeEn(servicio1,4,tablero);
        Jugador jugador1 = new Jugador("Martin");
        jugador1.caeEn(servicio1,numDado,tablero);
        Assert.assertEquals(100000-numDado*1000,jugador1.capital());

    }

    @Test
    public void testJugadorCaeEnTrenPeroElDuenioTambienPoseeSubte(){

        int numDado = 4;
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        Servicio servicio1 = new Servicio("Tren",38000,450,800,"Subte");
        Servicio servicio2 = new Servicio("Subte",40000,600,1100,"Tren");
        jugador.caeEn(servicio2,4,tablero);
        jugador.caeEn(servicio1,4,tablero);
        Jugador jugador1 = new Jugador("Martin");
        jugador1.caeEn(servicio1,numDado,tablero);
        Assert.assertEquals(100000-numDado*800,jugador1.capital());

    }

    @Test
    public void testJugadoresIntercambiaPropiedadesYLasPropiedadesTieneNuevosDuenios(){

        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Pablo");
        Jugador jugador2 = new Jugador("Martin");
        Servicio servicio1 = new Servicio("Edesur",35000,500,1000,"Aysa");
        Servicio servicio2 = new Servicio("Subte",40000,600,1100,"Tren");
        jugador1.caeEn(servicio1,4,tablero);
        jugador2.caeEn(servicio2,4,tablero);
        jugador1.intercambiarPropiedades(jugador2);
        Assert.assertTrue(jugador2.posee("Edesur"));
        Assert.assertTrue(jugador1.posee("Subte"));
    }

    @Test
    public void testJugadorVendePropiedadYSeeIncrementaSuCapitalUn85DelValorDeLaPropiedad() {

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Oca");
        Servicio servicio1 = new Servicio("Edesur", 10000, 500, 1000, "Aysa");
        jugador.caeEn(servicio1, 4, tablero);
        jugador.venderAlBanco(servicio1);
        Assert.assertEquals(100000 - 10000 + 8500, jugador.capital());
    }


}
