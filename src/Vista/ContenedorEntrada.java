package Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import Controladores.Botones.ControladorEntrar;

public class ContenedorEntrada extends VBox {

    Stage stage;

    public ContenedorEntrada(Stage stage, Scene proximaEscena) {

        super();

        this.stage = stage;
        stage.getIcons().add(new Image("Recursos/Imagenes/monopoly_icon.png"));

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
//        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
//        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();
        botonEntrar.setText("JUGAR");

        TextField texto1 = new TextField ();
        TextField texto2 = new TextField ();
        TextField texto3 = new TextField ();
        texto1.setPromptText("Primer Jugador (Superman)");
        texto2.setPromptText("Segundo Jugador (Batman)");
        texto3.setPromptText("Tercer Jugador (Wonder Woman)");
        texto1.setPrefColumnCount(30);
        texto2.setPrefColumnCount(30);
        texto3.setPrefColumnCount(30);

        ColorPicker color1 = new ColorPicker(Color.PALEGREEN);
        ColorPicker color2 = new ColorPicker(Color.PALEVIOLETRED);
        ColorPicker color3 = new ColorPicker(Color.AQUA);
        color1.setStyle("-fx-color-label-visible: false;");
        color2.setStyle("-fx-color-label-visible: false;");
        color3.setStyle("-fx-color-label-visible: false;");

        HBox hb1 = new HBox(texto1,color1);
        HBox hb2 = new HBox(texto2,color2);
        HBox hb3 = new HBox(texto3,color3);
        hb1.setSpacing(10);
        hb2.setSpacing(10);
        hb3.setSpacing(10);

        Image imagen = new Image("Recursos/Imagenes/Monopoly_pack_logo.png");
        final ImageView selectedImage = new ImageView(imagen);
        VBox vb = new VBox(hb1,hb2,hb3, selectedImage);
        vb.setSpacing(30);

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

        etiqueta.setText("ALGOPOLY");
        etiqueta.setTextFill(Color.web("000000"));

        ControladorEntrar botonEntrarHandler = new ControladorEntrar(stage, proximaEscena);
        botonEntrar.setOnAction(botonEntrarHandler);

        this.getChildren().addAll(etiqueta, botonEntrar, vb);
    }

}