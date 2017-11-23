package Vista;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Sistema {
    static VBox consola = null;
    static boolean mudo = false;

    public Sistema() {
        Text text = new Text(">>> Consola");
        text.setFont(Font.font("Verdana", 12));
        text.setFill(Color.GREEN);
        VBox contenedorConsola = new VBox();
        contenedorConsola.getChildren().add(text);
        contenedorConsola.setPadding(new Insets(0, 200, 0, 0));
        contenedorConsola.setStyle("-fx-background-color: black;");
        contenedorConsola.setMaxHeight(800);
        contenedorConsola.setMaxWidth(300);
        contenedorConsola.setMinHeight(contenedorConsola.getMaxHeight());
        contenedorConsola.setMinWidth(contenedorConsola.getMaxWidth());
        consola = contenedorConsola;
    }

    public VBox contenedorConsola() {
        return consola;
    }

    public static void mutear(){
        if (mudo == true) mudo=false;
        else if (mudo == false) mudo=true;
    }


    public static void imprimir(String cadena) {
        if (consola == null) {
//            System.out.println(cadena);
            return;
        }
        ;
        Text text = new Text(cadena);
        text.setFont(Font.font("Verdana", 12));
        text.setFill(Color.GREEN);
        consola.getChildren().add(0, text);
    }

    public static void reproducir(Class c, String archivo) {
        if (mudo==true) return;
        Media musicaInicio = new Media(c.getResource(archivo).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(musicaInicio);
        mediaPlayer.play();
    }
}
