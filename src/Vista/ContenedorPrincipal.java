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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ContenedorPrincipal extends BorderPane {

    Tablero tablero;
    VBox contenedorCentral;
    static Pane centro;
    static ArrayList<VistaJugador> vistaJugadores = new ArrayList<>();
    static ArrayList<Jugador> jugadores = new ArrayList<>();
    static VistaTablero vistaTablero;
    static Canvas fondo;

    public ContenedorPrincipal() {
        this.setFondo();
        this.setCentro(tablero);
        this.setConsola();
        this.setBotonera();
    }

    public static ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    private void setFondo() {
        fondo = new Canvas(800, 500);
        fondo.getGraphicsContext2D().setFill(Color.LIGHTGOLDENRODYELLOW);
        fondo.getGraphicsContext2D().fillRect(0, 0, 720, 420);
        centro = new Pane(fondo);
    }

    private void setBotonera() {
        Boton botonTirarDados = new Boton("Tirar Dados", new ControladorTirarDados());
        Boton botonComprar = new Boton("Comprar", new ControladorComprar());
        Boton botonVender = new Boton("Vender", new ControladorVender());
        Boton botonEdificarCasa = new Boton("Edificar casa", new ControladorEdificar());
        Presionador botonMudo = new Presionador("Mudo", new ControladorMudo());
        botonMudo.textoAlPasarMouse("Africa by Toto \nCover by 8 Bit Universe");
        Pane espacioVacio = new Pane();
        espacioVacio.setPrefHeight(280);
        VBox contenedorVertical = new VBox(botonTirarDados, botonComprar, botonVender, botonEdificarCasa, espacioVacio, botonMudo);
        contenedorVertical.setSpacing(15);
        contenedorVertical.setPadding(new Insets(20));
        this.setLeft(contenedorVertical);
    }

    private void setCentro(Tablero tablero) {
        vistaTablero = new VistaTablero(Tablero.getInstancia(), centro, fondo);
        vistaTablero.dibujar();
//        VisorCasillero visorNulo = new VisorCasillero(Tablero.getInstancia().salida(), centro);
        contenedorCentral = new VBox(centro);
        contenedorCentral.setPadding(new Insets(25));
        this.setCenter(contenedorCentral);
    }


    private void setConsola() {
        this.setRight(Sistema.contenedorConsola());
    }

    private void setVisoresJugador(VisorJugador visor) {
        this.setRight(visor);
    }

    public static void setJugadores() {
        int y = 0;
        int x = 680;
        for (Map.Entry<String, Color> entrada : Sistema.dicColores.entrySet()) {
            Jugador jugador = new Jugador(entrada.getKey());
            jugador.asignarCasillero(Tablero.getInstancia().salida());
            jugadores.add(jugador);
            vistaJugadores.add(new VistaJugador(jugador, entrada.getValue(), centro, x, 355 + y));
            y += 20;
        }
        for (VistaJugador vj : vistaJugadores) {
            vj.dibujar();
        }
        ControladorDeTurno.getInstance();
    }

    public static void actualizar() {
//        vistaTablero.dibujar();
//        for (VistaJugador vj : vistaJugadores) {
//            vj.dibujar();
//        }
//        int jugadoresEnJuego = vistaJugadores.size();
//        for (int i = 0; i < jugadoresEnJuego; i++) {
//            if (vistaJugadores.get(i).esElJugador(nombreJugador)) {
//                for (int x = 0; x < pasos; x++) {
//                    vistaJugadores.get(i).mover();
//                }
//            } else {
//                vistaJugadores.get(i).dibujar();
//            }
//        }
    }
}
