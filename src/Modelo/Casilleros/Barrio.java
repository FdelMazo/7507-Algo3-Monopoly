package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;

import java.util.ArrayList;

public class Barrio implements Casillero {

    public Jugador propietario;
    public String nombre;
    public int costo;
    public ArrayList<Integer> alquiler;
    public int alquilerActual;
    public int edificacionCasa;
    public int edificacionHotel;
    public int casasTotales;
    public int casasMaximas;



    public Barrio(String unNombre, int valor_propiedad, ArrayList listaalquileres, int edificacionDeCasa, int edificacionDeHotel){
        nombre = unNombre;
        propietario  = null;
        costo = valor_propiedad;
        alquiler = listaalquileres;
        alquilerActual = 0;
        edificacionCasa = edificacionDeCasa;
        edificacionHotel = edificacionDeHotel;
        casasTotales = 0;
        casasMaximas = 2;
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
        else if (propietario == jugador){
            jugador.cobrar_ingreso(alquiler.get(alquilerActual));
        }
        else{
            jugador.solicitar_dinero(alquiler.get(alquilerActual));
        }
    }

    public Jugador duenio (){
        return propietario;
    }

    public boolean hayCapacidadMaximaDeCasas(){
        return casasTotales == casasMaximas;
    }

    public boolean puedeEdificarCasa(Jugador jugador){
        return (jugador.capital() >= edificacionCasa || casasTotales < casasMaximas);
    }

    public boolean edificarCasa(Jugador jugador) {
        if (puedeEdificarCasa(jugador)){
            alquilerActual += 1;
            casasTotales += 1;
            jugador.solicitar_dinero(edificacionCasa);
            return true;
        }
        return false;
    }

    public boolean puedeEdificarHotel(Jugador jugador){
        return (jugador.capital() >= edificacionHotel && this.hayCapacidadMaximaDeCasas());
    }

    public boolean edificarHotel(Jugador jugador){
        if (puedeEdificarHotel(jugador)){
            alquilerActual += 1;
            jugador.solicitar_dinero(edificacionHotel);
            return true;
        }
        return false;
    }

    public int resetear(){
        propietario = null;
        return costo*(85/100);
    }
}
