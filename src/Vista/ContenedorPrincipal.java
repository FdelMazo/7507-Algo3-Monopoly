package Vista;

import Controladores.Botones.*;
import Controladores.EntradaUsuario;
import Controladores.Sistema;
import Modelo.Jugador;
import Modelo.Tablero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ContenedorPrincipal extends BorderPane{

    Tablero tablero;
    VBox contenedorCentral;
    Sistema sistema;
    Pane centro;

    public ContenedorPrincipal(Stage stage){
        sistema = new Sistema();
        this.setBotonera();
        this.setCentro(tablero);
        this.setConsola();
    }

    private void setBotonera(){
        Boton botonTirarDados = new Boton("Tirar Dados", new ControladorTirarDados());
        Boton botonComprar = new Boton("Comprar", new ControladorComprar());
        Boton botonEdificar = new Boton("Edificar", new ControladorEdificar());
        Boton botonVender = new Boton("Vender", new ControladorVender());
        Presionador botonMudo = new Presionador("Mudo", new ControladorMudo());
        botonMudo.textoAlPasarMouse("Africa by Toto \nCover by 8 Bit Universe");
        Pane espacioVacio = new Pane();
        espacioVacio.setPrefHeight(280);
        VBox contenedorVertical = new VBox(botonTirarDados, botonComprar,botonVender,espacioVacio, botonMudo);
        contenedorVertical.setSpacing(15);
        contenedorVertical.setPadding(new Insets(20));
        this.setLeft(contenedorVertical);
    }

    private void setCentro(Tablero tablero) {
        Canvas fondo = new Canvas(800,500);
        fondo.getGraphicsContext2D().setFill(Color.LIGHTGOLDENRODYELLOW);
        fondo.getGraphicsContext2D().fillRect(0, 0, 720, 420);
        centro = new Pane(fondo);
        VistaTablero vistaTablero = new VistaTablero(Tablero.getInstancia(), centro);
        vistaTablero.dibujar();
        VisorCasillero visorNulo = new VisorCasillero(Tablero.getInstancia().salida(), centro);
        contenedorCentral = new VBox(centro);
        contenedorCentral.setPadding(new Insets(25));
        this.setCenter(contenedorCentral);
    }


    private void setConsola() {
        Sistema consolaLocal = new Sistema();
        this.setRight(consolaLocal.contenedorConsola());
    }

    private void setVisoresJugador(VisorJugador visor) {
        this.setRight(visor);
    }

    public void setJugadores(ArrayList<EntradaUsuario> entradas) {
        int y = 0;
        for (EntradaUsuario entrada: entradas){
            Jugador jugador = new Jugador(entrada.getNombre());
            VistaJugador vistaJugador = new VistaJugador(jugador, entrada.getColor());
            Circle circulo = vistaJugador.getPieza();
            circulo.relocate(680,355+y);
            y+=20;
            centro.getChildren().add(circulo);
        }

    }
}
