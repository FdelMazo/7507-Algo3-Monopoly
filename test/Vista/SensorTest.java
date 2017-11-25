package Vista;

import Modelo.Figura.Contenedor;
import Modelo.Figura.PosicionFigura;
import Modelo.Figura.Sensor;
import org.junit.Assert;
import org.junit.Test;

public class SensorTest {

    @Test
    public void testEstaEnContactoDebeSerFalseSiXYSonMenoresAlTamanioDelContenedorPeroMayoresOIgualesQueCero(){
        Contenedor contenedor = new Contenedor(5, 5);
        Sensor sensor = new Sensor(contenedor);
        PosicionFigura posicion = new PosicionFigura(1, 1);
        Assert.assertFalse(sensor.estaEnContacto(posicion));
    }

    @Test
    public void testEstaEnContactoDebeSerTrueSiXYSonDelTamanioDelContenedor(){
        Contenedor contenedor = new Contenedor(5, 5);
        Sensor sensor = new Sensor(contenedor);
        PosicionFigura posicion = new PosicionFigura(5, 5);
        Assert.assertTrue(sensor.estaEnContacto(posicion));
    }

    @Test
    public void testEstaEnContactoDebeSerTrueSiXEsIgualAlXDelContenedor(){
        Contenedor contenedor = new Contenedor(5, 5);
        Sensor sensor = new Sensor(contenedor);
        PosicionFigura posicion = new PosicionFigura(5, 2);
        Assert.assertTrue(sensor.estaEnContacto(posicion));
    }

    @Test
    public void testEstaEnContactoDebeSerTrueSiYEsIgualAlYDelContenedor(){
        Contenedor contenedor = new Contenedor(5, 5);
        Sensor sensor = new Sensor(contenedor);
        PosicionFigura posicion = new PosicionFigura(2, 5);
        Assert.assertTrue(sensor.estaEnContacto(posicion));
    }

    @Test
    public void testEstaEnContactoDebeSerTrueSiXEsMayorlXDelContenedor(){
        Contenedor contenedor = new Contenedor(5, 5);
        Sensor sensor = new Sensor(contenedor);
        PosicionFigura posicion = new PosicionFigura(10, 4);
        Assert.assertTrue(sensor.estaEnContacto(posicion));
    }

    @Test
    public void testEstaEnContactoDebeSerTrueSiYEsMayorlYDelContenedor(){
        Contenedor contenedor = new Contenedor(5, 5);
        Sensor sensor = new Sensor(contenedor);
        PosicionFigura posicion = new PosicionFigura(4, 10);
        Assert.assertTrue(sensor.estaEnContacto(posicion));
    }

    @Test
    public void testEstaEnContactoDebeSerTrueSiXEsMenorAlXDelContenedor(){
        Contenedor contenedor = new Contenedor(5, 5);
        Sensor sensor = new Sensor(contenedor);
        PosicionFigura posicion = new PosicionFigura(-10, 4);
        Assert.assertTrue(sensor.estaEnContacto(posicion));
    }

    @Test
    public void testEstaEnContactoDebeSerTrueSiYEsMenorAlYDelContenedor(){
        Contenedor contenedor = new Contenedor(5, 5);
        Sensor sensor = new Sensor(contenedor);
        PosicionFigura posicion = new PosicionFigura(4, -10);
        Assert.assertTrue(sensor.estaEnContacto(posicion));
    }

    @Test
    public void testEstaEnContactoDebeSerTrueSiXYSonMenoresAlXYDelContenedor() {
        Contenedor contenedor = new Contenedor(5, 5);
        Sensor sensor = new Sensor(contenedor);
        PosicionFigura posicion = new PosicionFigura(-4, -10);
        Assert.assertTrue(sensor.estaEnContacto(posicion));
    }
}
