package Vista;

import Modelo.Figura.Direccion;
import Modelo.Figura.PosicionFigura;
import org.junit.Assert;
import org.junit.Test;

public class DireccionTest {

    @Test
    public void testElInversoDeNorteDeberiaSerEste(){
        Direccion norte = Direccion.north();
        Direccion este = Direccion.east();
        Assert.assertEquals(norte.inverse(), este);
    }

    @Test
    public void testNextPositionEnNorthDebeIncrementarY(){
        Direccion norte = Direccion.north();
        PosicionFigura posicionActual = new PosicionFigura(1,1);
        PosicionFigura posicionEsperada = new PosicionFigura(1, 121);
        PosicionFigura posicionSiguiente = norte.nextPosicion(posicionActual);
        Assert.assertEquals(posicionEsperada, posicionEsperada);
    }

    @Test
    public void testNextPosicionEnWestDebeIncrementarX(){
        Direccion oeste = Direccion.west();
        PosicionFigura posicionActual = new PosicionFigura(1,1);
        PosicionFigura posicionEsperada = new PosicionFigura(71, 1);
        PosicionFigura posicionSiguiente = oeste.nextPosicion(posicionActual);
        Assert.assertEquals(posicionEsperada, posicionEsperada);
    }

    @Test
    public void testNextPositionEnSouthDebeDisminuirY(){
        Direccion sur = Direccion.south();
        PosicionFigura posicionActual = new PosicionFigura(1,1);
        PosicionFigura posicionEsperada = new PosicionFigura(1, -199);
        PosicionFigura posicionSiguiente = sur.nextPosicion(posicionActual);
        Assert.assertEquals(posicionEsperada, posicionEsperada);
    }

    @Test
    public void testNextPositionEnEastDebeDisminuirY(){
        Direccion este = Direccion.east();
        PosicionFigura posicionActual = new PosicionFigura(1,1);
        PosicionFigura posicionEsperada = new PosicionFigura(-69, 1);
        PosicionFigura posicionSiguiente = este.nextPosicion(posicionActual);
        Assert.assertEquals(posicionEsperada, posicionEsperada);
    }

}
