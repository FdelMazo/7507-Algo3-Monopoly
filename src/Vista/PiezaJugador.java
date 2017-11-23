package Vista;

import javafx.animation.TranslateTransition;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class PiezaJugador {

    public int posX;
    public int posY;
    public int radio = 10;
    GraphicsContext gc;
    Circle pieza;

    public PiezaJugador(int x, int y,GraphicsContext gc){
        this.gc = gc;
        posX = x;
        posY = y;
        pieza = new Circle(radio,Color.BLUE);
        Circle pieza = new Circle(radio,Color.BLUE);
    }

    public void show(){
        this.drawShapes();
    }

    public void drawShapes(){

        pieza.setCenterX(posX);
        pieza.setCenterY(posY);

    }

    public void move (){

        posX -= 10;
        pieza.setCenterX(posX);
        TranslateTransition tt = new TranslateTransition(Duration.millis(2000), this.pieza);
        tt.setByX(posX);
        tt.play();

    }
}
