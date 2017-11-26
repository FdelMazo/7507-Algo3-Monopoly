package Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import Controladores.Botones.BotonEntrarEventHandler;

public class ContenedorEntrada extends VBox {

    Stage stage;

    public ContenedorEntrada(Stage stage, Scene proximaEscena) {

        super();

        this.stage = stage;
        stage.getIcons().add(new Image("Recursos\\Imagenes\\monopoly_icon.png"));

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
//        Image imagen = new Image("Recursos/Imagenes/mrmonopoly.jpg");
//        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
//        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();
        botonEntrar.setText("JUGAR");

        Label jugador1 = new Label("Primer Jugador:");
        Label jugador2 = new Label("Segundo Jugador:");
        Label jugador3 = new Label("Tercer Jugador:");
        TextField textField1 = new TextField ();
        TextField textField2 = new TextField ();
        TextField textField3 = new TextField ();
        VBox hb = new VBox();
        hb.getChildren().addAll(jugador1, textField1);
        hb.getChildren().addAll(jugador2, textField2);
        hb.getChildren().addAll(jugador3, textField3);
        hb.setSpacing(10);

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

        etiqueta.setText("ALGOPOLY");
        etiqueta.setTextFill(Color.web("000000"));

        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena);
        botonEntrar.setOnAction(botonEntrarHandler);

        this.getChildren().addAll(etiqueta, botonEntrar,hb );
    }

}