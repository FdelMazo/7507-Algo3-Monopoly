package Controladores;

import Controladores.Botones.ControladorEntrar;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import static javafx.scene.input.KeyCode.R;

public class Sistema {

    static VBox consola = null;
    static boolean mudo = false;
    static ArrayList<MediaPlayer> sonidos = new ArrayList<MediaPlayer>();
    static MediaPlayer musicaFondo;
    static ScrollPane sp;
    public static HashMap<String,Color> dicColores = new HashMap<>();

    public Sistema() {
        Text text = new Text(">>> Consola");
        text.setFont(Font.font("Verdana", 12));
        text.setFill(Color.GREEN);
        VBox contenedorConsola = new VBox(text);
        contenedorConsola.setStyle("-fx-background-color: black;");
        contenedorConsola.setPrefWidth(280);
        consola = contenedorConsola;
        sp = new ScrollPane(contenedorConsola);
        sp.setStyle("-fx-background: black;");
        sp.vvalueProperty().bind(consola.heightProperty());
    }

    public static ScrollPane contenedorConsola() {
        return sp;
    }

    public static void mutear(){
        if (mudo == true) mudo=false;
        else if (mudo == false) mudo=true;
    }


    public static void imprimir(String cadena) {
        if (consola == null) {
            System.out.println(cadena);
            return;
        }
        Text text = new Text(cadena);
        text.setFont(Font.font("Verdana", 12));
        text.setFill(Color.GREEN);
        consola.getChildren().add(text);
    }

    public static void reproducir(Class c, String archivo) {
        if (mudo==true) return;
        Media media = new Media(c.getResource("/Recursos/Sonidos/"+archivo).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        sonidos.add(mediaPlayer);
    }

    public static void frenarSonidos() {
        for (MediaPlayer mp : sonidos) {
            mp.stop();
        }
        sonidos.clear();
        if(musicaFondo.getStatus().equals(MediaPlayer.Status.PLAYING)) musicaFondo.pause();
        else musicaFondo.play();
    }

    public static void musicaFondo(Class c) {
        Media media = new Media(c.getResource("/Recursos/Sonidos/background.mp3").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        musicaFondo = mediaPlayer;
    }

    public static void error() {
        imprimir("\tNo se puede realizar esa accion");
    }
}
