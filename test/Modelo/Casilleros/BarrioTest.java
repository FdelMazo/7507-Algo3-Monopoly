package Modelo.Casilleros;

import Modelo.Casilleros.Barrio;
import Modelo.Jugador;
import Modelo.Tablero;
import Modelo.Edificacion;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class BarrioTest {

    @Test
    public void BarrioRecienCreadoNoTieneDuenio(){
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires SUr", 20000, 2000, listaCasas);
        Assert.assertEquals( null, buenosAiresSur.duenio() );
    }

    //ENTREGA 2: TEST 1 REQUERIDO
    @Test
    public void testSeActualizaElPropietarioAlSerCompradoUnTerreno() {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires SUr", 20000, 2000, listaCasas);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        Assert.assertEquals(jugador.nombre(), buenosAiresSur.duenio().nombre() );
    }

    @Test
    public void testJugadorConFondosInsuficientesNoPuedeComprarPropiedad(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires SUr", 20000, 2000, listaCasas);
        jugador.solicitar_dinero(90000);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        Assert.assertEquals(null, buenosAiresSur.duenio() );
    }

    @Test
    public void testjugadorEdificarCasaEnBarrioEsTrue(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires SUr", 20000, 2000, listaCasas);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        Assert.assertTrue(buenosAiresSur.edificarCasa(jugador));
    }

    @Test
    public void edificarCasaEnBarrioRestaElCapitalDelJugador(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires SUr", 20000, 2000, listaCasas);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        buenosAiresSur.edificarCasa(jugador);
        Assert.assertEquals(jugador.capital(), 75000);
    }

    @Test
    public void unJugadorQueCaeEnUnBarrioDeOtroJugadorDebePagarAlquiler(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires SUr", 20000, 2000, listaCasas);
        jugador1.caeEn(buenosAiresSur, 4, tablero);
        jugador2.caeEn(buenosAiresSur, 4, tablero);
        Assert.assertEquals(jugador2.capital(), 98000);
    }

    @Test
    public void unJugadorQueCaeEnUnBarrioDeOtroJugadorElDuenioDelBarrioRecibeElIngresoDelAlquiler(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires SUr", 20000, 2000, listaCasas);
        jugador1.caeEn(buenosAiresSur, 4, tablero);
        jugador2.caeEn(buenosAiresSur, 4, tablero);
        Assert.assertEquals(jugador1.capital(), 82000);
    }

    @Test
    public void JugadorVendeTerrenoYAhoraElCompradorTieneUnaPropiedadMas(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires SUr", 20000, 2000, listaCasas);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        Jugador jugador1 = new Jugador("Ezra");
        jugador.vender(jugador1,buenosAiresSur);
        Assert.assertEquals(1,jugador1.devolverCantPropiedades());
    }

    @Test
    public void JugadorVendeTerrenoYAhoraElVendedorTieneUnaPropiedadMenos(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires SUr", 20000, 2000, listaCasas);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        Jugador jugador1 = new Jugador("Ezra");
        jugador.vender(jugador1,buenosAiresSur);
        Assert.assertEquals(0,jugador.devolverCantPropiedades());
    }

    @Test
    public void JugadorVendeTerrenoConCasasPeroJugadorQueRecibeNoEncuentraNinguna(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires SUr", 20000, 2000, listaCasas);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        buenosAiresSur.edificarCasa(jugador);
        Jugador jugador1 = new Jugador("Ezra");
        jugador.vender(jugador1,buenosAiresSur);
        Jugador jugador2 = new Jugador("Kahlan");
        jugador2.caeEn(buenosAiresSur,4,tablero);
        Assert.assertEquals(100000-2000,jugador2.capital());
    }

    @Test
    public void JugadorCaeEnUnTerrenoVendidoYAhoraElAlquilerSeAcreditaAlNuevoDuenio(){
        int numDado = 4;
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pablo");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires SUr", 20000, 2000, listaCasas);
        jugador.caeEn(buenosAiresSur, 4, tablero);
        Jugador jugador1 = new Jugador("Ezra");
        jugador.vender(jugador1,buenosAiresSur);
        Jugador jugador2 = new Jugador("Matias");
        jugador2.caeEn(buenosAiresSur,numDado,tablero);
        Assert.assertEquals(100000-17000+2000, jugador1.capital());
    }

    //ENTREGA 2: TEST 9 REQUERID0
    @Test
    public void testJugadorCuentaConSantaFeYConstruyeUnaCasaPierde4000(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(4000, 3500));
        Barrio santaFe = new Barrio("Santa Fe", 15000, 1500, listaCasas);
        jugador.caeEn(santaFe, 4, tablero);
        santaFe.edificarCasa(jugador);
        Assert.assertEquals(100000 - 15000 - 4000, jugador.capital());
    }
}