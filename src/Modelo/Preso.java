package Modelo;

public class Preso implements Estado{

    private int diasPreso;
    private int fianza;
    private boolean fianzaPagada;
    private Jugador jugador;

    public Preso(Jugador jugador){

        diasPreso = 1;
        fianza = 45000;
        fianzaPagada = false;
        this.jugador = jugador;
    }

    public boolean mover() {
        diasPreso += 1;
        return diasPreso>3 || fianzaPagada ;
    }

    public boolean pagarFianza (){

        if(diasPreso>1) {
            fianzaPagada = jugador.solicitarDinero(fianza);
        }
        return fianzaPagada;
    }

    public boolean movimienoHabilitado(){
        return fianzaPagada;
    }
}
