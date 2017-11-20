package Modelo;

import org.junit.Assert;
import org.junit.Test;

public class DadosTest {

    @Test
    public void testSumaEntre0y12(){
        Dados dados = new Dados();
        Assert.assertTrue( 0 < dados.suma() && dados.suma() < 13 );
    }

}
