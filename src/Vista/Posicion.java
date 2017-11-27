package Vista;

public class Posicion {

    int desplazamientoX; int desplazamientoY;
    int x_rel = 0; int y_rel = 0;
    int x; int y;

    public Posicion(int cantX,int cantY){
        desplazamientoX = cantX;
        desplazamientoY = cantY;

    }

    public int getNextX(){return x;}
    public int getNextY(){return y;}

    public void actualizar(){
        if (x_rel==0 & y_rel>0){y_rel-=1; y+=desplazamientoY;}
        if (y_rel==5){x_rel-=1; x+=desplazamientoX;}
        if (x_rel==5){y_rel+=1; y-=desplazamientoY;}
        if (y_rel==0){x_rel+=1; x-=desplazamientoX;}
    }

    public void setInicial(int unX, int unY) {
        x = unX;
        y = unY;
    }
}
