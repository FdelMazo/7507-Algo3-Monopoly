package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;

public class Barrio implements Casillero {

    private Jugador propietario;
    private String nombre;
    private int costo;
    private int alquiler;


    public Barrio(String unNombre, int valor_propiedad, int costo_alquiler){
        nombre = unNombre;
        propietario  = null;
        costo = valor_propiedad;
        alquiler = costo_alquiler;
    }
    public boolean permiteSalida(Jugador jugador){
        return true;
    }

    public void vender(Jugador jugador){
        if(!jugador.solicitar_dinero(costo)) return;
        jugador.agregar_propiedad(this);
        propietario = jugador;
        }


    public void accionAlPartir(Jugador jugador) {  }

    public void accionAlCaer(Jugador jugador, int numDado, Tablero tablero) {

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
