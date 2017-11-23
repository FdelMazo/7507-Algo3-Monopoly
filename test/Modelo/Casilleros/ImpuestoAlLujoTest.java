package Modelo.Casilleros;
import Modelo.Jugador;
import Modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class ImpuestoAlLujoTest {

    @Test
    public void cobrarImpuesto(){

        Jugador jugador = new Jugador("nick");
        ImpuestoAlLujo impuestoAlLujo = new ImpuestoAlLujo();
        int capital_anterior = jugador.capital();
        jugador.caeEn(impuestoAlLujo,null);
        Assert.assertEquals(capital_anterior - capital_anterior*0.1,jugador.capital(),1);


    }

}
