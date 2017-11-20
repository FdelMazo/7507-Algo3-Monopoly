package Modelo.Casilleros;

import Modelo.Edificacion;
import Modelo.Jugador;
import Modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MovimientoDinamicoTest {

    @Test
    public void numeroEntre2Y6EnAvanceDianmico() {
        int numDado = 3;
        AvanceDinamico avanceDinamico = new AvanceDinamico();
        Jugador jugador = new Jugador("Viky");
        Assert.assertEquals(numDado - 2, avanceDinamico.calcularDinamismo(jugador, numDado));
    }

    @Test
    public void numeroEntre7y10AvanceDinamico() {
        int numDado = 8;
        AvanceDinamico avanceDinamico = new AvanceDinamico();
        Jugador jugador = new Jugador("Viky");
        Assert.assertEquals(jugador.capital() % numDado, avanceDinamico.calcularDinamismo(jugador, numDado));
    }

    @Test
    public void numeroEntre11y12AvanceDinamico() {
        Tablero tablero = new Tablero();
        int numDado = 11;
        AvanceDinamico avanceDinamico = new AvanceDinamico();
        Jugador jugador = new Jugador("flor");
        ArrayList<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires SUr", 20000, 2000, listaCasas);
        jugador.caeEn(buenosAiresSur, numDado, tablero);
        Assert.assertEquals(numDado - jugador.cantPropiedades(),avanceDinamico.calcularDinamismo(jugador, numDado));
    }

    @Test
    public void numeroEntre2Y6EnRetrocesoDianmico() {
        Tablero tablero = new Tablero();
        int numDado = 2;
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
        Jugador jugador = new Jugador("flor");
        ArrayList<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires SUr", 20000, 2000, listaCasas);
        jugador.caeEn(buenosAiresSur, numDado, tablero);
        Assert.assertEquals(((numDado - jugador.cantPropiedades()) * -1), retrocesoDinamico.calcularDinamismo(jugador, numDado));
    }

    @Test
    public void numeroEntre7Y10EnRetrocesoDianmico() {
        int numDado = 9;
        int resultado;
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
        Jugador jugador = new Jugador("Viky");
        Assert.assertEquals(-1, retrocesoDinamico.calcularDinamismo(jugador, numDado));
    }

    @Test
    public void numeroEntre11Y12EnRetrocesoDianmico() {
        int numDado = 11;
        int resultado;
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
        Jugador jugador = new Jugador("Viky");
        Assert.assertEquals(-9, retrocesoDinamico.calcularDinamismo(jugador, numDado));
    }
}
