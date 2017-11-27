//package Modelo;
//
//import Controladores.ControladorDeTurno;
//import org.junit.Assert;
//import org.junit.Test;
//
//public class FinDelJuegoTest {
//
//    @Test
//    public void testGanaJugador1CuandoLosDemásJugadoresseQuedanSinDinero(){
//
//        ControladorDeTurno controlador = ControladorDeTurno.getInstance();
//        Jugador jugador = controlador.getJugadorActual();
//        jugador.solicitarDinero(100000);
//        controlador.cambiarTurno();
//        Jugador jugador1 = controlador.getJugadorActual();
//        jugador1.solicitarDinero(100000);
//        Assert.assertTrue(controlador.ganador());
//
//    }
//
//
//
//}
