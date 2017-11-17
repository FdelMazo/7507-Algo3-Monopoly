package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class ServicioTest {

    @Test
    public void testJugadorCaeEnTrenesAdueñadoPorOtroJugadorQueNoTieneSubte(){

        int numDado = 4;
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        Servicio servicio = new Servicio("Trenes",38000,450,800,"Subte");
        jugador.caeEn(servicio,4,tablero);
        Jugador jugador1 = new Jugador("Martin");
        jugador1.caeEn(servicio,numDado,tablero);
        Assert.assertEquals(100000 - (450*numDado),jugador1.capital());

    }

    @Test
    public void testJugadorCaeEnEdesurAdueñadoPorOtroJugadorQueNoTieneAysa(){

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
    public void testJugadorCaeEnEdesurPeroEsDueñoPorLoQueNoSeLeCobra(){

        int numDado = 4;
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        Servicio servicio = new Servicio("Edesur",35000,500,1000,"Aysa");
        jugador.caeEn(servicio,4,tablero);
        jugador.caeEn(servicio,numDado,tablero);
        Assert.assertEquals(100000 - 35000,jugador.capital());

    }

    @Test
    public void testJugadorCaeEnEdesurPeroElDueñoTambienPoseeAysa(){

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
    public void testJugadorCaeEnTrenesPeroElDueñoTambienPoseeSubte(){

        int numDado = 4;
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        Servicio servicio1 = new Servicio("Trenes",38000,450,800,"Subte");
        Servicio servicio2 = new Servicio("Subte",40000,600,1100,"Trenes");
        jugador.caeEn(servicio2,4,tablero);
        jugador.caeEn(servicio1,4,tablero);
        Jugador jugador1 = new Jugador("Martin");
        jugador1.caeEn(servicio1,numDado,tablero);
        Assert.assertEquals(100000-numDado*800,jugador1.capital());

    }

    //@Test
    //public void testJugadoresIntercambiaPropiedadesYLasPropiedadesTieneNuevosDuenios(){

      //  Tablero tablero = new Tablero();
       // Jugador jugador = new Jugador("Pablo");
        //Jugador jugador1 = new Jugador("Martin");
        //Servicio servicio1 = new Servicio("Edesur",35000,500,1000,"Aysa");
        //Servicio servicio2 = new Servicio("Subte",40000,600,1100,"Trenes");
        //jugador.caeEn(servicio1,4,tablero);
        //jugador1.caeEn(servicio2,4,tablero);
        //jugador.intercambiarPropiedades(jugador1);

        //Assert.assertEquals(jugador1,servicio1.devolverDuenio());
    //}

    @Test
    public void testJugadorVendePropiedadYSeeIncrementaSuCapitalUn85DelValorDeLaPropiedad() {

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Oca");
        Servicio servicio1 = new Servicio("Edesur", 10000, 500, 1000, "Aysa");
        jugador.caeEn(servicio1, 4, tablero);
        jugador.venderAlBanco();
        Assert.assertEquals(100000 - 10000 + 8500, jugador.capital());
    }


}
