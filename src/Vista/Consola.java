package Vista;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Consola {
    static VBox vbox = null;

    public Consola() {
        Text text = new Text(">>> Consola");
        text.setFont(Font.font("Verdana", 12));
        text.setFill(Color.GREEN);
        VBox contenedorConsola = new VBox();
        contenedorConsola.getChildren().add(text);
        contenedorConsola.setPadding(new Insets(0, 0, 100, 0));
        contenedorConsola.setStyle("-fx-background-color: black;");
        vbox = contenedorConsola;
    }

    public VBox contenedorConsola() {
        return vbox;
    }


    public static void println(String cadena) {
        if ( vbox== null){
            System.out.println(cadena);
            return;
        };
        Text text = new Text(cadena);
        text.setFont(Font.font("Verdana", 12));
        text.setFill(Color.GREEN);
        vbox.getChildren().add(text);
    }
}
