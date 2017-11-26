package Controladores.Botones;

import Modelo.Jugador;
import Controladores.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorVender implements EventHandler<ActionEvent>{
    private int contador;

    Jugador jugador;

    public ControladorVender(Jugador jugador){
        contador = 0;
        this.jugador = jugador;

    }

    @Override
    public void handle(ActionEvent event) {
        String woah = null ;
        if (contador == 0)woah = "woah0.mp3";
        else if (contador == 1)woah = "woah1.mp3";
        else if (contador == 2)woah = "woah2.mp3";
        else if (contador == 3)woah = "woah3.mp3";
        else if (contador == 4){
            contador = 0;
            woah = "woah4.mp3";
        };

        Sistema.reproducir(getClass(), woah);
        Sistema.imprimir("Vendo vendo");
        contador +=1;
    }
}


