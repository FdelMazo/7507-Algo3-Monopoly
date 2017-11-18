package Vista;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PiezaJugador {

    public int posX;
    public int posY;
    public int largox;
    public int largoy;

    public PiezaJugador(int x, int y, int largoX, int largoY){
        posX = x;
        posY = y;
        largox = largoX;
        largoy = largoY;
    }

    public void show(GraphicsContext gc){

        gc.setFill(Color.BLUE);
        gc.fillOval(posX,posY,largox,largoy);
    }

    public void move (int anchoPantalla, int largoPantalla, int anchoCasilla, int largoCasilla ,int n){

        for( int i =0 ; i < n ; i++) {
            posX += largoCasilla / 2;
            posY += anchoCasilla /2 ;
        }
    }
}
