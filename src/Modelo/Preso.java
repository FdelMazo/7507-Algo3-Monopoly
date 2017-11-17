package Modelo;

public class Preso implements Estado{

    int dias_preso;
    int fianza;

    public Preso(){
        dias_preso = 0; //?
        fianza = 45000;
    }

    @Override
    public boolean mover(Jugador jugador) {
        dias_preso += 1;
        if (dias_preso > 3){
            return true;
        }
        else if (dias_preso > 1){
            return jugador.salir(fianza);
        }
        return false;
    }
}
