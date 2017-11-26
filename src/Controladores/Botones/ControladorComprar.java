package Controladores.Botones;

import Modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorComprar implements EventHandler<ActionEvent>{

    Jugador jugador;

    public ControladorComprar(Jugador jugador){
        this.jugador = jugador;
    }

    @Override
    public void handle(ActionEvent event) {
        //this.jugador.comprar();
    }



}