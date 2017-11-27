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
import java.util.Map;


public class ContenedorPrincipal extends BorderPane {

    static Visor visorActual;
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

    public void setFondo() {
        fondo = new Canvas(800, 500);
        fondo.getGraphicsContext2D().setFill(Color.LIGHTGOLDENRODYELLOW);
        fondo.getGraphicsContext2D().fillRect(0, 0, 720, 420);
        centro = new Pane(fondo);
    }

    private void setBotonera() {
        Boton botonTirarDados = new Boton("Tirar Dados", new ControladorTirarDados());
        botonTirarDados.textoAlPasarMouse("Truquito: Doble click termina el turno");
        Boton botonComprar = new Boton("Comprar", new ControladorComprar());
        Boton botonVender = new Boton("Vender", new ControladorVender());
        Boton botonFinalizarTurno = new Boton("Finalizar turno", new ControladorFinalizarTurno());
        Boton botonPagarFianza = new Boton("Pagar Fianza", new ControladorPagarFianza());
        Boton botonEdificarCasa = new Boton("Edificar Casa", new ControladorEdificar());
        Boton botonEdificarHotel = new Boton("Edificar Hotel", new ControladorEdificarHotel());
        Presionador botonMudo = new Presionador("Mudo", new ControladorMudo());
        botonMudo.textoAlPasarMouse("Africa by Toto \nCover by 8 Bit Universe");
        Pane espacioVacio = new Pane();
        espacioVacio.setPrefHeight(280);
        VBox contenedorVertical = new VBox(botonTirarDados, botonComprar, botonVender, botonEdificarCasa,botonEdificarHotel,botonPagarFianza,botonFinalizarTurno, espacioVacio, botonMudo);
        contenedorVertical.setSpacing(15);
        contenedorVertical.setPadding(new Insets(20));
        this.setLeft(contenedorVertical);
    }

    private void setCentro(Tablero tablero) {
        vistaTablero = new VistaTablero(Tablero.getInstancia(), centro, fondo);
        vistaTablero.dibujar();
        contenedorCentral = new VBox(centro);
        contenedorCentral.setPadding(new Insets(25));
        this.setCenter(contenedorCentral);
    }


    private void setConsola() {
        this.setRight(Sistema.contenedorConsola());
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
        VistaJugador vjActual = VistaJugador.getPorNombre(ControladorDeTurno.getInstance().getJugadorActual().getNombre());
        visorActual = new Visor(vjActual, centro);

    }

    public static void actualizar() {
        visorActual.reset();
        VistaJugador vjActual = VistaJugador.getPorNombre(ControladorDeTurno.getInstance().getJugadorActual().getNombre());
        visorActual = new Visor(vjActual, centro);
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
