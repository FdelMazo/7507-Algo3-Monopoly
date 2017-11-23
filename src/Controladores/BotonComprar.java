package Controladores;

import Modelo.Jugador;
import Vista.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class BotonComprar implements EventHandler<ActionEvent>{

    Jugador jugador;

    public BotonComprar(Jugador jugador){
        this.jugador = jugador;
    }

    @Override
    public void handle(ActionEvent event) {
        Sistema.reproducir(getClass(), "background.mp3");
        Sistema.imprimir("Compro Compro");
        //this.jugador.comprar();
    }

}