package Modelo;

import Modelo.Casilleros.Casillero;
import org.junit.Assert;
import org.junit.Test;

public class DadosTest {

    @Test
    public void testSumaEntre0y12(){
        Dados dados = new Dados();
        Assert.assertTrue( 0 < dados.suma() && dados.suma() < 13 );
    }

    @Test
    public void testUnJugadorSacaElMismoValorEnLosDosDados(){
        int cont = 0;
        Tablero tablero = Tablero.getInstancia();
        Jugador jugador = new Jugador("Joe");
        Casillero nuevo = tablero.desplazarCasillero(jugador.actual(), jugador.lanzarDadosdobles());
        jugador.caeEn(nuevo);
        if (jugador.doble()){
            cont = cont + 1;
            Casillero nuevo2 = tablero.desplazarCasillero(jugador.actual(), jugador.lanzarDadosdobles());
            jugador.caeEn(nuevo);
        }
        Assert.assertEquals(1,cont);
    }
    @Test
    public void testUnJugadorSacaElMismoValorDosVecesEnLosDosDados(){
        int cont = 0;
        Tablero tablero = Tablero.getInstancia();
        Jugador jugador = new Jugador("Joe");
        Casillero nuevo = tablero.desplazarCasillero(jugador.actual(), jugador.lanzarDadosdobles());
        jugador.caeEn(nuevo);
        if (jugador.doble()) {
            cont = cont + 1;
            Casillero nuevo2 = tablero.desplazarCasillero(jugador.actual(), jugador.lanzarDadosdobles());
            jugador.caeEn(nuevo);
        }
        if (jugador.doble()){
                cont = cont + 1;
                Casillero nuevo2 = tablero.desplazarCasillero(jugador.actual(), jugador.lanzarDadosdobles());
                jugador.caeEn(nuevo);
        }
        Assert.assertEquals(2,cont);
    }

}
