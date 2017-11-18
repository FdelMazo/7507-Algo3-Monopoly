package Vista;

import Modelo.Jugador;
import Vista.eventos.BotonComprar;
import Vista.eventos.BotonTirarDados;
import Vista.eventos.BotonVender;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import Modelo.Dados;

import java.awt.*;
import java.util.ArrayList;

public class ContenedorPrincipal extends BorderPane{

    public ContenedorPrincipal(ArrayList<Jugador> jugadores){
        this.setBotonera(jugadores.get(0)); //esto sería para probar, ver como maneja que spon varios jug
    }

    private void setBotonera(Jugador jugador){

        Button botonTirarDados = new Button();
        botonTirarDados.setText("Tirar Dados");
        BotonTirarDados tirarDadosBotonHanler = new BotonTirarDados(new Dados());
        botonTirarDados.setOnAction(tirarDadosBotonHanler);

        Button botonComprar = new Button();
        botonComprar.setText("Comprar");
        BotonComprar comprarHandler = new BotonComprar(jugador);
        botonComprar.setOnAction(comprarHandler);

        Button botonVender = new Button();
        botonVender.setText("Vender");
        BotonVender venderHandler = new BotonVender(jugador);
        botonVender.setOnAction(venderHandler);

        VBox contenedorVertical = new VBox(botonComprar,botonVender,botonTirarDados);
        contenedorVertical.setSpacing(15);
        contenedorVertical.setPadding(new Insets(20));

    }





}
