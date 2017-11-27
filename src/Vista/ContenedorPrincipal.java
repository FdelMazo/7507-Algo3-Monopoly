package Vista;

import Controladores.Botones.*;
import Controladores.ControladorDeTurno;
import Controladores.Sistema;
import Modelo.Jugador;
import Modelo.Tablero;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;


public class ContenedorPrincipal extends BorderPane{

    Tablero tablero;
    VBox contenedorCentral;
    Sistema sistema;
    Pane centro;
    Canvas fondo;
    VistaJugador vistaJugador1;
    VistaJugador vistaJugador2;
    VistaJugador vistaJugador3;
    VistaTablero vistaTablero;
    VistaTotal vistaTotal;

    public ContenedorPrincipal(Stage stage){
        sistema = new Sistema();
        this.setCentro(tablero);
        this.setConsola();
        this.setBotonera();
    }

    private void setBotonera(){
        Boton botonTirarDados = new Boton("Tirar Dados", new ControladorTirarDados(vistaTotal));
        Boton botonComprar = new Boton("Comprar", new ControladorComprar());
        Boton botonEdificar = new Boton("Edificar", new ControladorEdificar());
        Boton botonVender = new Boton("Vender", new ControladorVender());
        Boton botonFinalizarTurno = new Boton("Finalizar turno", new ControladorFinalizarTurno());
        Presionador botonMudo = new Presionador("Mudo", new ControladorMudo());
        botonMudo.textoAlPasarMouse("Africa by Toto \nCover by 8 Bit Universe");
        Pane espacioVacio = new Pane();
        espacioVacio.setPrefHeight(280);
        VBox contenedorVertical = new VBox(botonTirarDados, botonComprar,botonVender, botonFinalizarTurno, espacioVacio, botonMudo);
        contenedorVertical.setSpacing(15);
        contenedorVertical.setPadding(new Insets(20));
        this.setLeft(contenedorVertical);
    }

    private void setCentro(Tablero tablero) {

        Canvas fondo = new Canvas(800,500);
        fondo.getGraphicsContext2D().setFill(Color.LIGHTGOLDENRODYELLOW);
        fondo.getGraphicsContext2D().fillRect(0, 0, 720, 420);
        centro = new Pane(fondo);
        vistaTablero = new VistaTablero(Tablero.getInstancia(), centro,fondo);
        vistaTablero.dibujar();
        this.setJugadores(fondo);
        ArrayList<VistaJugador> vistaJugadores = new ArrayList<>();
        vistaJugadores.add(vistaJugador1);
        vistaJugadores.add(vistaJugador2);
        vistaJugadores.add(vistaJugador3);
        vistaTotal = new VistaTotal(vistaJugadores,vistaTablero);
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

    public void setJugadores(Canvas canvas) {

        ControladorDeTurno controlador = ControladorDeTurno.getInstance();
        ArrayList<Jugador> jugadores = controlador.getJugadores();
        int y = 0;
        vistaJugador1 = new VistaJugador(jugadores.get(0), Color.BLUE, canvas,680,355+y);
        vistaJugador1.dibujar();
        y+=20;
        vistaJugador2 = new VistaJugador(jugadores.get(1), Color.BLUE, canvas,680,355+y);
        vistaJugador2.dibujar();
        y+=20;
        vistaJugador3 = new VistaJugador(jugadores.get(2), Color.BLUE, canvas,680,355+y);
        vistaJugador3.dibujar();
    }
}
