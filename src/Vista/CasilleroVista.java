package Vista;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CasilleroVista{

    private int posX;
    private int posY;
    private int largo;
    private int ancho;
    private String nombre;
    private Color color;

    public CasilleroVista(int x, int y, int l, int w,String nombre_propiedad, Color fondo){
        posX = x;
        posY = y;
        largo = l;
        ancho = w;
        nombre = nombre_propiedad.toUpperCase();
        color = fondo;
    }

    public void show(GraphicsContext gc){

        gc.setFill(color);
        gc.fillRect(posX,posY,largo,ancho);
        gc.strokeText(nombre,posX + (largo)/3,posY+ (ancho)/3,100);

    }
}