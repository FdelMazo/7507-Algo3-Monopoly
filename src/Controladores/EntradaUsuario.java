package Controladores;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class EntradaUsuario {
    HBox hb;
    TextField tx;
    ColorPicker cp;


    public EntradaUsuario(String textoHover, Color colorDefault) {
        TextField texto = new TextField(textoHover);
        texto.setPrefColumnCount(30);
        tx = texto;
        ColorPicker color = new ColorPicker(colorDefault);
        color.setStyle("-fx-color-label-visible: false;");
        cp = color;
        HBox hbox = new HBox(texto, color);
        hbox.setSpacing(10);
        hb = hbox;
    }

    public HBox getHb() {
        return hb;
    }

    public String getNombre() {
        return tx.getText();
    }

    public Color getColor() {return cp.getValue();}
}
