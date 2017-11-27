package Modelo;

import Modelo.Casilleros.Casillero;
import Modelo.Casilleros.Servicio;
import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Repeatable;

public class TableroTest {

    @Test
    public void testAvanzar3PasosEnTableroCaeEnEdesur() {
        Jugador jugador = new Jugador("Jugaddor 1");
        Tablero tablero = Tablero.getInstancia();
        jugador.asignarCasillero(tablero.salida());
        Servicio deberiaSerEdesur = (Servicio) tablero.desplazarCasillero(jugador.actual(), 3);
        Assert.assertEquals("Edesur", deberiaSerEdesur.nombre());
    }

    @Test
    public void testAvanzar8yRetroceder5PasosEnTableroCaeEnEdesur() {
        Jugador jugador = new Jugador("Jugador 1");
        Tablero tablero = Tablero.getInstancia();
        jugador.asignarCasillero(tablero.salida());
        Servicio deberiaSerSubte = (Servicio) tablero.desplazarCasillero(jugador.actual(), 8);
        jugador.caeEn(deberiaSerSubte);
        Assert.assertEquals("Subte", deberiaSerSubte.nombre());
        Servicio deberiaSerEdesur = (Servicio) tablero.desplazarCasillero(jugador.actual(), -5);
        Assert.assertEquals("Edesur", deberiaSerEdesur.nombre());
    }

    @Test
    public void testAvanzarSegunDadosLanzados() {
        Jugador jugador = new Jugador("Jugadorr 1");
        Tablero tablero = Tablero.getInstancia();
        jugador.asignarCasillero(tablero.salida());
        jugador.lanzarDados();
        Casillero nuevoCasillero = tablero.desplazarCasillero(jugador.actual(), jugador.sumaDados());
        Assert.assertEquals(jugador.sumaDados(), Tablero.getInstancia().casilleros().indexOf(nuevoCasillero));
    }
}
