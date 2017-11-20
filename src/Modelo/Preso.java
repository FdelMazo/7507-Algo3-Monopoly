package Modelo;

public class Preso implements Estado{

    int diasPreso;
    int fianza;

    public Preso(){
        diasPreso = 0;
        fianza = 45000;
    }

    @Override
    public boolean mover(Jugador jugador) {
        diasPreso += 1;
        if (diasPreso > 3){
            return true;
        }
        else if (diasPreso > 1){
            return jugador.solicitarDinero(fianza);
        }
        return false;
    }
}
