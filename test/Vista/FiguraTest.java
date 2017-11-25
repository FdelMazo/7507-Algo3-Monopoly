package Vista;

import Vista.Figura.Contenedor;
import Vista.Figura.Figura;
import Vista.Figura.Sensor;
import org.junit.Test;

public class FiguraTest {

    @Test
    public void test(){
        Contenedor contenedor = new Contenedor(50, 50);
        Sensor sensor = new Sensor(contenedor);
        Posicion posicion = new Posicion(10, 10);
    }


}
