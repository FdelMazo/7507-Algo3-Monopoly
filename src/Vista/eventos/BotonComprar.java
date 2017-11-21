package Vista.eventos;

import Modelo.Jugador;
import Vista.Consola;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonComprar implements EventHandler<ActionEvent>{

    Jugador jugador;

    public BotonComprar(Jugador jugador){
        this.jugador = jugador;
    }

    @Override
    public void handle(ActionEvent event) {
        Media musicaInicio = new Media(getClass().getResource("background.mp3").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(musicaInicio);
        mediaPlayer.play();
        Consola.println("Compro Compro");
        //this.jugador.comprar();
    }

}