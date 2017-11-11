package Modelo;

import org.junit.Assert;
import org.junit.Test;

public class MovimientoDinamicoTest {

    @Test
    public void numeroEntre2Y6EnAvanceDianmico() {
        int numDado = 3;
        int resultado;
        AvanceDinamico avanceDinamico = new AvanceDinamico();
        Jugador jugador = new Jugador("Viky");
        resultado = avanceDinamico.actuar(jugador, numDado);
        Assert.assertEquals(numDado - 2, resultado);
    }

    @Test
    public void numeroEntre7y10AvanceDinamico() {

        int numDado = 8;
        int resultado;
        AvanceDinamico avanceDinamico = new AvanceDinamico();
        Jugador jugador = new Jugador("Viky");
        resultado = avanceDinamico.actuar(jugador, numDado);
        Assert.assertEquals(jugador.capital() % numDado, resultado);


    }

    @Test
    public void numeroEntre11y12AvanceDinamico() {

        int numDado = 11;
        int resultado;
        AvanceDinamico avanceDinamico = new AvanceDinamico();
        Jugador jugador = new Jugador("flor");
        Barrio buenosAiresSur = new Barrio(20000, 2000);
        jugador.asignarCasilla(buenosAiresSur);
        buenosAiresSur.actuar(jugador, numDado);
        resultado = avanceDinamico.actuar(jugador, numDado);
        Assert.assertEquals(numDado - jugador.devolverCantPropiedades(),resultado);
    }

    @Test
    public void numeroEntre2Y6EnRetrocesoDianmico() {
        int numDado = 2;
        int resultado;
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
        Jugador jugador = new Jugador("flor");
        Barrio buenosAiresSur = new Barrio(20000, 2000);
        jugador.asignarCasilla(buenosAiresSur);
        buenosAiresSur.actuar(jugador, numDado);
        resultado = retrocesoDinamico.actuar(jugador, numDado);

        Assert.assertEquals(((numDado - jugador.devolverCantPropiedades()) * -1), resultado);
    }

    @Test
    public void numeroEntre7Y10EnRetrocesoDianmico() {
        int numDado = 9;
        int resultado;
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
        Jugador jugador = new Jugador("Viky");
        resultado = retrocesoDinamico.actuar(jugador, numDado);
        Assert.assertEquals(-1, resultado);
    }

    @Test
    public void numeroEntre11Y12EnRetrocesoDianmico() {
        int numDado = 11;
        int resultado;
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
        Jugador jugador = new Jugador("Viky");
        resultado = retrocesoDinamico.actuar(jugador, numDado);
        Assert.assertEquals(-9, resultado);
    }
}
