package Vista.eventos;

import Modelo.Dados;
import Vista.Consola;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonTirarDados implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        Media musicaInicio = new Media(getClass().getResource("dados_sonido.mp3").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(musicaInicio);
        mediaPlayer.play();

        Dados dados = new Dados();
        int resultado = dados.suma();
        Consola.println("Sacas : " + resultado);
    }
}