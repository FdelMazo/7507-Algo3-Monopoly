package Vista;

import Controladores.ControladorDeTurno;
import Modelo.Casilleros.*;
import Modelo.Edificacion;
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
        int x = 140;
        int y = 100;
        Casillero actual = vistaJugador.getJugador().actual();
        Jugador jugadorActual = vistaJugador.getJugador();
        VBox flow = new VBox(2);
        Font fontTitulo = new Font("Tahoma Bold", 18);
        Font fontSubTitulo = new Font("Tahoma Bold", 16);
        Label jugador = new Label(jugadorActual.getNombre() + " ($" +jugadorActual.capital() + ")" +" en "+ actual.nombre());
        jugador.setTextFill(vistaJugador.color);
        Pane espacioVacio = new Pane();
        espacioVacio.setPrefHeight(10);
        flow.getChildren().addAll(jugador, espacioVacio);
        if (Municipio.getInstance().esUnaPropiedad(actual.nombre())){
            Propiedades actualB = (Propiedades) actual;
            Jugador propietario = Municipio.getInstance().devolverPropietario(actualB);
            String nombrePropietario;
            if (propietario==null) nombrePropietario =" Nadie lo sabe";
            else nombrePropietario = propietario.getNombre();
            jugador.setText(jugador.getText()+
                    "\n\t$"+ Integer.toString(actualB.getCosto()) +"\n\t"
                    +  Municipio.getInstance().edificacionesExistentes(actualB)+ " Edificaciones"
                    + "\n\tDueño: " +  nombrePropietario
            );

        }
        Label preso = null;
        jugador.setFont(fontTitulo);
        if (!jugadorActual.mover()){
            preso = new Label("Preso :(");
            preso.setFont(fontSubTitulo);
            preso.setTextFill(vistaJugador.color);
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
