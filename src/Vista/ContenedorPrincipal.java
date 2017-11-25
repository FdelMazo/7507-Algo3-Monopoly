package Vista;

import Controladores.Botones.*;
import Controladores.Sistema;
import Modelo.Jugador;
import Modelo.Tablero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorPrincipal extends BorderPane{

    Tablero tablero;
    VBox contenedorCentral;
    Canvas canvasCentral;
    VistaTablero vistaTablero;
    Pane tableroCentral;

    public ContenedorPrincipal(ArrayList<Jugador> jugadores, Stage stage){
        this.setConsola();
        this.setBotonera(jugadores.get(0)); //esto sería para probar, ver como maneja que spon varios jug
        this.setCentro(tablero);
    }

    private void setBotonera(Jugador jugador){

        Button botonTirarDados = new Button();
        botonTirarDados.setText("Tirar Dados");
        BotonTirarDados tirarDadosBotonHanler = new BotonTirarDados();
        botonTirarDados.setOnAction(tirarDadosBotonHanler);

        Button botonComprar = new Button();
        botonComprar.setText("Comprar");
        BotonComprar comprarHandler = new BotonComprar(jugador);
        botonComprar.setOnAction(comprarHandler);

        Button botonVender = new Button();
        botonVender.setText("Vender");
        BotonVender venderHandler = new BotonVender(jugador);
        botonVender.setOnAction(venderHandler);


        Button botonMute = new Button();
        botonMute.setText("Frenar musica");
        BotonMudo muteHandler = new BotonMudo();
        botonMute.setOnAction(muteHandler);


        VBox contenedorVertical = new VBox(botonComprar,botonVender,botonTirarDados, botonMute);
        contenedorVertical.setSpacing(15);
        contenedorVertical.setPadding(new Insets(20));

        this.setLeft(contenedorVertical);

    }

    private void setCentro(Tablero tablero) {

        canvasCentral = new Canvas(800,500);
        tableroCentral = new Pane();
        vistaTablero = new VistaTablero(Tablero.getInstancia() , canvasCentral, tableroCentral);
        vistaTablero.dibujar();

        contenedorCentral = new VBox(tableroCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));

        this.setCenter(contenedorCentral);
    }

    private void setConsola() {
        Sistema consolaLocal = new Sistema();
        this.setRight(consolaLocal.contenedorConsola());
    }
}
