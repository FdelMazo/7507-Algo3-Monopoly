//package Modelo.Casilleros;
//
//import Modelo.Edificacion;
//import Modelo.Jugador;
//import Modelo.Municipio;
//import Modelo.Tablero;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PropiedadesVariasTest {
//
//    @Test
//    public void JugadorVendeSuUnicaPropiedadTrenParaPagarSolicitado() {
//
//        Municipio municipio = Municipio.getInstance();
//        municipio.resetear();
//        int numDado = 4;
//        Tablero tablero = new Tablero();
//        Jugador jugador = new Jugador("Pablo");
//        Servicio servicio = new Servicio("Tren",38000);
//        jugador.caeEn(servicio,numDado,tablero);
//        jugador.solicitarDinero(70000);
//        Assert.assertEquals(24300,jugador.capital());
//    }

//    @Test
//    public void JugadorIntercambiaPropiedadConOtroJugadorYAhoraElNuevoDueniooCobraElAlquiler(){
//
//        Municipio municipio = Municipio.getInstance();
//        municipio.resetear();
//        Tablero tablero = new Tablero();
//        Jugador jugador1 = new Jugador("Carlos");
//        Jugador jugador2 = new Jugador("Mario");
//        Servicio servicio1 = new Servicio("Tren",38000);
//        Servicio servicio2 = new Servicio("Subte",40000);
//        jugador1.caeEn(servicio1,3,tablero);
//        jugador2.caeEn(servicio2,3,tablero);
//        jugador1.intercambiarPropiedades(jugador2,servicio2);
//        Jugador jugador3 = new Jugador("Mario");
//        jugador3.caeEn(servicio1,2,tablero);
//        Assert.assertEquals(60900,jugador2.capital());
//    }

//    @Test
//    public void JugadorIntercambiaPropiedadEdificaConOtroJugadorYAhoraElNuevoDueniooCobraElAlquilersinEdifican(){
//
//
//        Municipio municipio = Municipio.getInstance();
//        municipio.resetear();
//        Tablero tablero = new Tablero();
//
//        Jugador jugador1 = new Jugador("Carlos");
//        Jugador jugador2 = new Jugador("Mario");
//
//        List<Edificacion> listaCasas= new ArrayList();
//        listaCasas.add(new Edificacion(4000, 3500));
//
//        Barrio santaFe = new Barrio("Santa Fe", 15000, 1500, listaCasas);
//        jugador1.caeEn(santaFe, 0, null);
//        santaFe.edificarCasa(jugador1);
//
//        Servicio servicio1 = new Servicio("Tren",38000);
//        jugador2.caeEn(servicio1 ,0,tablero);
//
//        jugador1.intercambiarPropiedades(jugador2,servicio1);
//
//        Jugador jugador3 = new Jugador("Mario");
//        jugador3.caeEn(santaFe,2,tablero);
//
//        Assert.assertEquals(100000-1500,jugador3.capital());
//    }

//}
