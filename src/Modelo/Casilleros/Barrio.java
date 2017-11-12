package Modelo.Casilleros;

import Modelo.Jugador;

public class Barrio implements Casillero {

    private Jugador propietario;
    private int costo;
    private int alquiler;


    public Barrio(int valor_propiedad, int costo_alquiler){
        propietario  = null;
        costo = valor_propiedad;
        alquiler = costo_alquiler;
    }
    public boolean permiteSalida(Jugador jugador){
        return true;
    }
    public void vender(Jugador jugador){
        int capital_jugador = jugador.capital();
        if (capital_jugador >= costo) {
            jugador.pedir_dinero(costo);
            jugador.agregar_propiedad(this);
            propietario = jugador;
        }
    }

    public void accionAlPartir(Jugador jugador) {
    }

    public void accionAlCaer(Jugador jugador, int numDado) {

        if (propietario == null){
            this.vender(jugador);
        }
        else{
            jugador.cobrar_ingreso(alquiler);
        }
    }

    public Jugador duenio (){
        return propietario;
    }
}
