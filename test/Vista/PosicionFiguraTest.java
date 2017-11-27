package Vista;

import Modelo.Figura.Direccion;
import Modelo.Figura.PosicionFigura;
import org.junit.Assert;
import org.junit.Test;

public class PosicionFiguraTest {

    @Test
    public void testNextIncrementaYAlTenerComoDireccionNorte(){
        PosicionFigura posicion = new PosicionFigura(0, 0);
        Direccion norte = Direccion.north();
        PosicionFigura posicionEsperada = new PosicionFigura(0, 70);
        PosicionFigura posicionObtenida = posicion.next(norte);
        Assert.assertEquals(posicionEsperada, posicionObtenida);
        Assert.assertEquals(posicionEsperada, posicionObtenida);
    }

    @Test
    public void testNextIncrementaYAlTenerComoDireccionEeste(){
        PosicionFigura posicion = new PosicionFigura(0, 0);
        Direccion este = Direccion.east();
        PosicionFigura posicionEsperada = new PosicionFigura(120, 0);
        PosicionFigura posicionObtenida = posicion.next(este);
        Assert.assertEquals(posicionEsperada, posicionObtenida);
        Assert.assertEquals(posicionEsperada, posicionObtenida);
    }

}
