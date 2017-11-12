package Modelo.Casilleros;

import Modelo.Casilleros.Barrio;
import Modelo.Casilleros.Carcel;
import Modelo.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class CarcelTest {

    @Test
    public void testCarcelNoPermiteMovimiento(){
        Jugador jugador = new Jugador("Dio");
        Carcel carcel = new Carcel();
        jugador.caeEn(carcel, 0);
        Assert.assertFalse(carcel.permiteSalida(jugador));
    }

    @Test
    public void testCarcelPermiteSalidaDespuesDelPrimerTurno(){
        Jugador jugador = new Jugador("Dio");
        Carcel carcel = new Carcel();
        jugador.caeEn(carcel, 0);
        jugador.empezarTurno();
        Assert.assertTrue(carcel.permiteSalida(jugador));
    }

    @Test
    public void testCarcelNoPermiteSalidaSiNoPago(){
        Jugador jugador = new Jugador("Dio");
        Carcel carcel = new Carcel();
        jugador.pedir_dinero(60000);
        jugador.caeEn(carcel, 0);
        jugador.empezarTurno();
        Assert.assertFalse(carcel.permiteSalida(jugador));
    }

}
