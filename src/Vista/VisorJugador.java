package Vista;

import Modelo.Jugador;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextFlow;

public class VisorJugador extends VBox{

    public VisorJugador (Jugador jugador){

        TextFlow flow = new TextFlow();
        Label titulo = new Label(jugador.getNombre());
        Label plata = new Label(Integer.toString(jugador.capital()));
        titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        flow.getChildren().addAll(titulo);
        this.getChildren().add(flow);

    }
}
