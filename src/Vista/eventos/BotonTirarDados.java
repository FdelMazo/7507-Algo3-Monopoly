package Vista.eventos;

import Modelo.Dados;
import Modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonTirarDados implements EventHandler<ActionEvent> {

    Dados dados;

    public BotonTirarDados(Dados dados){
        this.dados = dados;
    }

    @Override
    public void handle(ActionEvent event) {
        this.dados.suma();
    }
}