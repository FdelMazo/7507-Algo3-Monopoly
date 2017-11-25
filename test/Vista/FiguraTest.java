package Vista;

import Modelo.Figura.*;
import org.junit.Assert;
import org.junit.Test;

public class FiguraTest {

    @Test
    public void testLaSeEncuentraEnElOrigen(){
        Contenedor contenedor = new Contenedor(500, 500);
        Sensor sensor = new Sensor(contenedor);
        PosicionFigura posicion = new PosicionFigura(0, 0);
        Figura figura = new Figura(sensor, posicion);
        figura.setDireccion(Direccion.north());
        PosicionFigura posicionEsperada = new PosicionFigura(0, 0);
        PosicionFigura posicionObtenida = figura.getPosicionFigura();
        Assert.assertEquals(posicionEsperada, posicionObtenida);
    }


    @Test
    public void testLaFiguraAvanzaUnaVezAlNorteYSuPosicionYSeIncrementa(){
        Contenedor contenedor = new Contenedor(500, 500);
        Sensor sensor = new Sensor(contenedor);
        PosicionFigura posicion = new PosicionFigura(0, 0);
        Figura figura = new Figura(sensor, posicion);
        figura.setDireccion(Direccion.north());
        figura.move();
        PosicionFigura posicionEsperada = new PosicionFigura(0, 70);
        PosicionFigura posicionObtenida = figura.getPosicionFigura();
        Assert.assertEquals(posicionEsperada, posicionObtenida);
    }

    @Test
    public void testLaFiguraAvanzaUnaVezAlEsteYSuPosicionYSeIncrementa(){
        Contenedor contenedor = new Contenedor(500, 500);
        Sensor sensor = new Sensor(contenedor);
        PosicionFigura posicion = new PosicionFigura(0, 0);
        Figura figura = new Figura(sensor, posicion);
        figura.setDireccion(Direccion.east());
        figura.move();
        PosicionFigura posicionEsperada = new PosicionFigura(120, 0);
        PosicionFigura posicionObtenida = figura.getPosicionFigura();
        Assert.assertEquals(posicionEsperada, posicionObtenida);
    }

    @Test
    public void testLaFiguraAvanzaUnaVezAlNorteColisionaConElBordeSuperiorDelContenedorYSuDireccionAhoraEsEste(){
        Contenedor contenedor = new Contenedor(500, 100);
        Sensor sensor = new Sensor(contenedor);
        PosicionFigura posicion = new PosicionFigura(0, 0);
        Figura figura = new Figura(sensor, posicion);
        figura.setDireccion(Direccion.north());
        figura.move();
        Assert.assertEquals(figura.getDireccion(), Direccion.east());
    }

    @Test
    public void testLaFiguraAvanzaUnaVezAlEsteColisionaConElBordeDerechoDelContenedorYSuDireccionAhoraEsSur(){
        Contenedor contenedor = new Contenedor(100, 500);
        Sensor sensor = new Sensor(contenedor);
        PosicionFigura posicion = new PosicionFigura(0, 0);
        Figura figura = new Figura(sensor, posicion);
        figura.setDireccion(Direccion.east());
        figura.move();
        Assert.assertEquals(figura.getDireccion(), Direccion.south());
    }

    @Test
    public void testLaFiguraAvanzaUnaAlNorteAlColisionarSuDireccionSeIncrementaEnX(){
        Contenedor contenedor = new Contenedor(500, 100);
        Sensor sensor = new Sensor(contenedor);
        PosicionFigura posicion = new PosicionFigura(0, 0);
        Figura figura = new Figura(sensor, posicion);
        figura.setDireccion(Direccion.north());
        figura.move();
        PosicionFigura posicionEsperada = new PosicionFigura(120, 0);
        PosicionFigura posicionObtenida = figura.getPosicionFigura();
        Assert.assertEquals(posicionEsperada, posicionObtenida);
    }

    @Test
    public void testLaFiguraAvanzaUnaAlEsteAlColisionarSuDireccionSeDecrementaEnY(){
        Contenedor contenedor = new Contenedor(100, 500);
        Sensor sensor = new Sensor(contenedor);
        PosicionFigura posicion = new PosicionFigura(0, 100);
        Figura figura = new Figura(sensor, posicion);
        figura.setDireccion(Direccion.east());
        figura.move();
        PosicionFigura posicionEsperada = new PosicionFigura(0, 30);
        PosicionFigura posicionObtenida = figura.getPosicionFigura();
        Assert.assertEquals(posicionEsperada, posicionObtenida);
    }
}
