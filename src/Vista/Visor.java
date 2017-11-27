package Vista;

import Controladores.ControladorDeTurno;
import Modelo.Casilleros.*;
import Modelo.Jugador;
import Modelo.Municipio;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.lang.invoke.SerializedLambda;

public class Visor {
    VBox vb;

    public Visor(VistaJugador vistaJugador, Pane pane) {
        int x = 150;
        int y = 100;
        Casillero actual = vistaJugador.getJugador().actual();
        Jugador jugadorActual = vistaJugador.getJugador();
        VBox flow = new VBox(2);
        Font fontTitulo = new Font("Tahoma Bold", 18);
        Font fontSubTitulo = new Font("Tahoma Bold", 16);
        Label jugador = new Label(jugadorActual.getNombre() + " en "+ actual.nombre());
        if (Municipio.getInstance().esUnaPropiedad(actual.nombre())){
            Propiedades actualB = (Propiedades) actual;
            jugador.setText(jugador.getText()+ " ($"+ Integer.toString(actualB.getCosto()) +")");
            Label propiedades = new Label(Municipio.getInstance().devolverPropiedades(jugadorActual).toString());
            flow.getChildren().add(propiedades);
        }
        Label capital = new Label("$"+jugadorActual.capital());
//        Municipio.getInstance().esUnaPropiedad(casillero.get)
        Label preso = null;
        jugador.setFont(fontTitulo);
        capital.setFont(fontTitulo);
        flow.getChildren().addAll(jugador,capital);
        if (!jugadorActual.estaPreso()){
            preso = new Label("Preso :(");
            preso.setFont(fontSubTitulo);
            flow.getChildren().add(preso);
        }
        flow.relocate(x, y);
        pane.getChildren().add(flow);
        vb = flow;
    }


    public void reset(){
        vb.getChildren().clear();
    }


}
