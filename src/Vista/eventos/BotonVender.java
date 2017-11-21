package Vista.eventos;

import Modelo.Jugador;
import Vista.Consola;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonVender implements EventHandler<ActionEvent>{
    private int contador;

    Jugador jugador;

    public BotonVender(Jugador jugador){
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

        Media musicaInicio = new Media(getClass().getResource(woah).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(musicaInicio);
        mediaPlayer.play();
        Consola.println("Vendo vendo");
        contador +=1;
    }
}


