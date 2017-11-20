package Vista.eventos;

import Modelo.Dados;
import Vista.Consola;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonTirarDados implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Dados dados = new Dados();
        int resultado = dados.suma();
        Consola.println("Sacas : " + resultado);
    }
}