package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Municipio;
import Modelo.Tablero;
import Modelo.Edificacion;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class BarrioTest {

    @Test
    public void testSeActualizaElPropietarioAlSerCompradoUnTerreno() {

        Jugador jugador = new Jugador("Pablo");
        List<Edificacion> listaCasas = new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires Sur", 20000, 2000, listaCasas);
        jugador.caeEn(buenosAiresSur);
        buenosAiresSur.comprar(jugador);
        Assert.assertTrue(jugador.posee("Buenos Aires Sur"));
    }


    @Test
    public void testJugadorConFondosInsuficientesNoPuedeComprarPropiedad(){

        Jugador jugador = new Jugador("Pabloo");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires Sur", 20000, 2000, listaCasas);
        jugador.solicitarDinero(90000);
        jugador.caeEn(buenosAiresSur);
        buenosAiresSur.comprar(jugador);
        Assert.assertFalse(jugador.posee("Buenos Aires Sur"));
    }

    @Test
    public void testjugadorEdificarCasaEnBarrioEsTrue(){

        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires Sur", 20000, 2000, listaCasas);
        jugador.caeEn(buenosAiresSur);
        buenosAiresSur.comprar(jugador);
        Assert.assertTrue(buenosAiresSur.edificarCasa(jugador));
    }

    @Test
    public void edificarCasaEnBarrioRestaElCapitalDelJugador(){

        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires Sur", 20000, 2000, listaCasas);
        jugador.caeEn(buenosAiresSur);
        buenosAiresSur.comprar(jugador);
        buenosAiresSur.edificarCasa(jugador);
        Assert.assertEquals(jugador.capital(), 75000);
    }

    @Test
    public void unJugadorQueCaeEnUnBarrioDeOtroJugadorDebePagarAlquiler(){

        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires Sur", 20000, 2000, listaCasas);
        jugador1.caeEn(buenosAiresSur);
        buenosAiresSur.comprar(jugador1);
        jugador2.caeEn(buenosAiresSur);
        Assert.assertEquals(jugador2.capital(), 98000);
    }

    @Test
    public void unJugadorQueCaeEnUnBarrioDeOtroJugadorElDuenioDelBarrioRecibeElIngresoDelAlquiler(){

        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(5000, 3000));
        listaCasas.add(new Edificacion(5000, 3500));
        Barrio buenosAiresSur = new Barrio("Buenos Aires SUr", 20000, 2000, listaCasas);
        jugador1.caeEn(buenosAiresSur);
        buenosAiresSur.comprar(jugador1);
        jugador2.caeEn(buenosAiresSur);
        Assert.assertEquals(jugador1.capital(), 82000);
    }


    //ENTREGA 2: TEST 9 REQUERID0
    @Test
    public void testJugadorCuentaConSantaFeYConstruyeUnaCasaPierde4000(){

        Jugador jugador = new Jugador("Lance");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(4000, 3500));
        Barrio santaFe = new Barrio("Santa Fe", 15000, 1500, listaCasas);
        jugador.caeEn(santaFe);
        santaFe.comprar(jugador);
        santaFe.edificarCasa(jugador);
        Assert.assertEquals(100000 - 15000 - 4000, jugador.capital());
    }

    //ENTREGA 2: TEST 10 REQUERIDO (Buenos Aires Sur)
    @Test
    public void testBarrioBuenosAiresSurJugadorDebePagarAlquilerPierde3000(){

        Municipio municipio = Municipio.getInstance();
        municipio.resetear();

        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        List<Edificacion> listaCasasS= new ArrayList();
        listaCasasS.add(new Edificacion(5000, 3000));
        listaCasasS.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(8000, 5000));
        List<Edificacion> listaCasasN= new ArrayList();
        listaCasasN.add(new Edificacion(5500, 3500));
        listaCasasN.add(new Edificacion(5500, 4000));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(9000, 6000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasasN, listaHotelesN);
        jugador1.caeEn(buenosAiresSur);
        buenosAiresSur.comprar(jugador1);
        jugador1.caeEn(buenosAiresNorte);
        buenosAiresNorte.comprar(jugador1);
        buenosAiresSur.edificarCasa(jugador1);
        jugador2.caeEn(buenosAiresSur);
        Assert.assertEquals(jugador2.capital(), 100000 - 3000);
    }

//    //ENTREGA 2: TEST 10 REQUERIDO (Buenos Aires Norte)
    @Test
    public void testBarrioBuenosAiresNorteJugadorDebePagarAlquilerPierde3500(){
        Tablero tablero = Tablero.getInstancia();
        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        List<Edificacion> listaCasasS= new ArrayList();
        listaCasasS.add(new Edificacion(5000, 3000));
        listaCasasS.add(new Edificacion(5000, 3500));
        List<Edificacion> listaHotelesS = new ArrayList();
        listaHotelesS.add(new Edificacion(8000, 5000));
        List<Edificacion> listaCasasN= new ArrayList();
        listaCasasN.add(new Edificacion(5500, 3500));
        listaCasasN.add(new Edificacion(5500, 4000));
        List<Edificacion> listaHotelesN = new ArrayList();
        listaHotelesN.add(new Edificacion(9000, 6000));
        BarrioDoble buenosAiresSur = new BarrioDoble("Buenos Aires Sur", 20000, 2000, listaCasasS, listaHotelesS);
        BarrioDoble buenosAiresNorte = new BarrioDoble("Buenos Aires Norte", 25000, 2500, listaCasasN, listaHotelesN);
        jugador1.caeEn(buenosAiresSur);
        buenosAiresSur.comprar(jugador1);
        jugador1.caeEn(buenosAiresNorte);
        buenosAiresNorte.comprar(jugador1);
        buenosAiresNorte.edificarCasa(jugador1);
        jugador2.caeEn(buenosAiresNorte);
        Assert.assertEquals(jugador2.capital(), 100000 - 3500);
     }

    //ENTREGA 2: TEST 10 REQUERIDO (Neuquen)
    @Test
    public void testNeuquenJugadorDebePagarAlquilerEnBarrioEdificadoPierde3800(){

        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(4800, 3800));
        Barrio neuquen = new Barrio("Neuquen", 17000, 1800, listaCasas);
        jugador1.caeEn(neuquen);
        neuquen.comprar(jugador1);
        neuquen.edificarCasa(jugador1);
        jugador2.caeEn(neuquen);
        Assert.assertEquals(100000 - 3800, jugador2.capital());
    }

    //ENTREGA 2: TEST 10 REQUERIDO (Tucuman)
    @Test
    public void testTucumanJugadorDebePagarAlquilerEnBarrioEdificadoPierde3800(){
        Municipio municipio = Municipio.getInstance();
        municipio.resetear();
        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(4800, 3800));
        Barrio tucuman = new Barrio("Tucuman", 17000, 1800, listaCasas);
        jugador1.caeEn(tucuman);
        tucuman.comprar(jugador1);
        tucuman.edificarCasa(jugador1);
        jugador2.caeEn(tucuman);
        Assert.assertEquals(100000 - 3800, jugador2.capital());
    }

    @Test
    public void testJugadorVendePropiedadEdificadaYAhoraEstasNoExistenMas(){

        Jugador jugador1 = new Jugador("Lance");
        Jugador jugador2 = new Jugador("Hunk");
        List<Edificacion> listaCasas= new ArrayList();
        listaCasas.add(new Edificacion(4800, 3800));
        Barrio tucuman = new Barrio("Tucuman", 17000, 1800, listaCasas);
        jugador1.caeEn(tucuman);
        tucuman.comprar(jugador1);
        tucuman.edificarCasa(jugador1);
        jugador1.venderAlBanco(tucuman);
        jugador2.caeEn(tucuman);
        tucuman.comprar(jugador2);
        Jugador jugador3 = new Jugador("Batman");
        jugador3.caeEn(tucuman);
        Assert.assertEquals(jugador3.capital(), 100000 - 1800);

    }
}