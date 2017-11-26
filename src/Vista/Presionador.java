package Vista;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;

public class Presionador extends ToggleButton {

    public Presionador(String texto, javafx.event.EventHandler< ActionEvent > controlador){
        setText(texto);
        setOnAction(controlador);
    }

    public void textoAlPasarMouse(String texto){
        setTooltip(new Tooltip(texto));
    }

}
