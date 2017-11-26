package Controladores.Botones;

import Controladores.ControladorDeTurno;
import Modelo.Dados;
import Controladores.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorTirarDados implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        Sistema.reproducir(getClass(), "dados_sonido.mp3");

        ControladorDeTurno controlador = ControladorDeTurno.getInstance();
        controlador.jugar();

        Dados dados = new Dados();
        int resultado = dados.suma();
        Sistema.imprimir("Sacas : " + resultado);
    }
}