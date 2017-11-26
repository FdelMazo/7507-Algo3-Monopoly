package Vista;

import Controladores.Botones.*;
import Controladores.Sistema;
import Modelo.Figura.Contenedor;
import Modelo.Figura.Figura;
import Modelo.Figura.PosicionFigura;
import Modelo.Figura.Sensor;
import Modelo.Jugador;
import Modelo.Tablero;
import Vista.Figura.FiguraVista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
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

        Boton botonTirarDados = new Boton("Tirar Dados", new ControladorTirarDados());
        Boton botonComprar = new Boton("Comprar", new ControladorComprar(jugador));
        Boton botonVender = new Boton("Vender", new ControladorVender(jugador));
        Presionador botonMudo = new Presionador("Mudo", new ControladorMudo());
        botonMudo.textoAlPasarMouse("Africa by Toto \nCover by 8 Bit Universe");

        VBox contenedorVertical = new VBox(botonComprar,botonVender,botonTirarDados, botonMudo);
        contenedorVertical.setSpacing(15);
        contenedorVertical.setPadding(new Insets(20));

        this.setLeft(contenedorVertical);

    }

    private void setCentro(Tablero tablero) {

        Group tableroConFiguras = new Group();

        // TABLERO

        canvasCentral = new Canvas(800,500);
        tableroCentral = new Pane();
        vistaTablero = new VistaTablero(Tablero.getInstancia() , canvasCentral, tableroCentral);
        vistaTablero.dibujar();

        contenedorCentral = new VBox(tableroCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));

        // FIGURAS

        VBox contenedorFiguras = new VBox();
        contenedorFiguras.setAlignment(Pos.CENTER);
        contenedorFiguras.setSpacing(20);
        contenedorFiguras.setPadding(new Insets(25));

        Contenedor contenedor = new Contenedor(720, 420);
        Sensor sensor = new Sensor(contenedor);
        Figura figura = new Figura(sensor, new PosicionFigura(0, 0));

        Canvas canvasFigura = new Canvas();
        contenedorFiguras.getChildren().add(canvasFigura);
        FiguraVista figuraVista = new FiguraVista(figura, canvasFigura.getGraphicsContext2D());
        figuraVista.draw();

        tableroConFiguras.getChildren().addAll(contenedorCentral, contenedorFiguras);

        this.setCenter(tableroConFiguras);
    }

    private void setConsola() {
        Sistema consolaLocal = new Sistema();
        this.setRight(consolaLocal.contenedorConsola());
    }
}
