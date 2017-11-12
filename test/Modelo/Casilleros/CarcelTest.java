package Modelo.Casilleros;

import Modelo.Casilleros.Barrio;
import Modelo.Casilleros.Carcel;
import Modelo.Jugador;
import Modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class CarcelTest {

    @Test
    public void testCarcelNoPermiteMovimiento(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Dio");
        Carcel carcel = new Carcel();
        jugador.caeEn(carcel, 0, tablero);
        Assert.assertFalse(carcel.permiteSalida(jugador));
    }

    @Test
    public void testCarcelPermiteSalidaDespuesDelPrimerTurno(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Dio");
        Carcel carcel = new Carcel();
        jugador.caeEn(carcel, 0, tablero);
        jugador.empezarTurno();
        Assert.assertTrue(carcel.permiteSalida(jugador));
    }

    @Test
    public void testCarcelNoPermiteSalidaSiNoPago(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Dio");
        Carcel carcel = new Carcel();
        jugador.solicitar_dinero(60000);
        jugador.caeEn(carcel, 0, tablero);
        jugador.empezarTurno();
        Assert.assertFalse(carcel.permiteSalida(jugador));
    }

    @Test
    public void testCarcelLiberaAlJugadorLuegoDeDosTurnosDeHaberCaido(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("batman");
        Carcel carcel = new Carcel();
        jugador.caeEn(carcel,0,tablero);
        jugador.empezarTurno();
        jugador.empezarTurno();
        jugador.empezarTurno();
        Assert.assertTrue((carcel.permiteSalida(jugador)));
    }

    @Test
    public void testCarcelAceptaAMasDeUnJugador(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("batman");
        Jugador jugador2 = new Jugador("superman");
        Carcel carcel = new Carcel();
        jugador1.caeEn(carcel,0, tablero);
        jugador2.caeEn(carcel,0, tablero);
        jugador1.empezarTurno();
        jugador2.empezarTurno();
        Assert.assertTrue(carcel.permiteSalida(jugador1)== carcel.permiteSalida(jugador2));
    }



}
