package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Municipio;
import Modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class ServicioTest {

    @Test
    public void testJugadorCaeEnTrenAdueniadoPorOtroJugadorQueNoTieneSubte() {

        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        int numDado = 4;
        Tablero tablero = Tablero.getInstancia();
        Jugador jugador = new Jugador("Pablo");
        Servicio servicio = new Servicio("Tren", 38000);
        jugador.caeEn(servicio);
        servicio.comprar(jugador);
        Jugador jugador1 = new Jugador("Martin");
        jugador1.caeEn(servicio);
        Assert.assertEquals(450 * numDado, servicio.calcularCobro(numDado));

    }

    @Test
    public void testJugadorCaeEnEdesurAdueniadoPorOtroJugadorQueNoTieneAysa() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        int numDado = 4;
        Tablero tablero = Tablero.getInstancia();
        Jugador jugador = new Jugador("Pablo");
        Servicio servicio = new Servicio("Edesur", 35000);
        jugador.caeEn(servicio);
        servicio.comprar(jugador);

        Assert.assertEquals(500 * numDado, servicio.calcularCobro(numDado));
    }

    @Test
    public void testJugadorCaeEnEdesurPeroEsDuenioPorLoQueNoSeLeCobra() {
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        int numDado = 4;
        Tablero tablero = Tablero.getInstancia();
        Jugador jugador = new Jugador("Pablo");
        Servicio servicio = new Servicio("Edesur", 35000);
        jugador.caeEn(servicio);
        servicio.comprar(jugador);
        jugador.caeEn(servicio);
        Assert.assertEquals(100000 - 35000, jugador.capital());

    }

    @Test
    public void testJugadorCaeEnEdesurPeroElDuenioTambienPoseeAysa() {

        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        int numDado = 4;
        Tablero tablero = Tablero.getInstancia();
        Jugador jugador = new Jugador("Pablo");
        Servicio servicio1 = new Servicio("Edesur", 35000);
        Servicio servicio2 = new Servicio("Aysa", 30000);
        jugador.caeEn(servicio2);
        servicio2.comprar(jugador);
        jugador.caeEn(servicio1);
        servicio1.comprar(jugador);
        Jugador jugador1 = new Jugador("Martin");
        jugador1.caeEn(servicio1);
        Assert.assertEquals(numDado * 1000, servicio1.calcularCobro(numDado));
    }

    @Test
    public void testJugadorCaeEnTrenPeroElDuenioTambienPoseeSubte() {

        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        int numDado = 4;
        Tablero tablero = Tablero.getInstancia();
        Jugador jugador = new Jugador("Pablo");
        Servicio servicio1 = new Servicio("Tren", 38000);
        Servicio servicio2 = new Servicio("Subte", 40000);
        jugador.caeEn(servicio2);
        servicio2.comprar(jugador);
        jugador.caeEn(servicio1);
        servicio1.comprar(jugador);
        Jugador jugador1 = new Jugador("Martin");
        jugador1.caeEn(servicio1);
        Assert.assertEquals(numDado * 800, servicio1.calcularCobro(numDado));

    }

    @Test
    public void testJugadoresIntercambiaPropiedadesYLasPropiedadesTieneNuevosDuenios() {

        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        Jugador jugador1 = new Jugador("Pablo");
        Jugador jugador2 = new Jugador("Martin");
        Servicio servicio1 = new Servicio("Edesur", 35000);
        Servicio servicio2 = new Servicio("Subte", 40000);
        jugador1.caeEn(servicio1);
        servicio1.comprar(jugador1);
        jugador2.caeEn(servicio2);
        servicio2.comprar(jugador2);
        jugador1.intercambiarPropiedades(servicio1, jugador2, servicio2);
        Assert.assertTrue(jugador2.posee("Edesur"));
        Assert.assertTrue(jugador1.posee("Subte"));
    }

    @Test
    public void testJugadorVendePropiedadYSeeIncrementaSuCapitalUn85DelValorDeLaPropiedad() {

        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        Jugador jugador = new Jugador("Oca");
        Servicio servicio1 = new Servicio("Edesur", 10000);
        jugador.caeEn(servicio1);
        servicio1.comprar(jugador);
        jugador.venderAlBanco(servicio1);
        Assert.assertEquals(100000 - 10000 + 8500, jugador.capital());
    }
}

