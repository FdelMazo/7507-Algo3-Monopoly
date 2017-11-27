package Controladores;

public class MovimientoJugador {

    int desplazamientoX; int desplazamientoY;
    int x_rel = 0; int y_rel = 0;
    int x; int y;

    public MovimientoJugador(int cantX,int cantY,int mov, int posInicialX, int posInicalY){

        desplazamientoX = cantX;
        desplazamientoY = cantY;
        x = posInicialX;
        y = posInicalY;

    }

    public int getNextX(){
        return x;

    }

    public int getNextY(){
        return y;
    }

    public void actualizar(){

    }


}
