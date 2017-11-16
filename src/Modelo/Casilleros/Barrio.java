package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;

import java.util.ArrayList;

public class Barrio implements Casillero, Propiedades {

    public Jugador propietario;
    public String nombre;
    public int costo;
    public ArrayList<Integer> alquiler;
    public int alquilerActual;
    public int edificacionCasa;
    public int edificacionHotel;
    public int casasTotales;
    public int casasMaximas;
    public int valor_mercado;



    public Barrio(String unNombre, int valor_propiedad, ArrayList listaalquileres, int edificacionDeCasa, int edificacionDeHotel){
        nombre = unNombre;
        propietario  = null;
        costo = valor_propiedad;
        alquiler = listaalquileres;
        alquilerActual = 0;
        edificacionCasa = edificacionDeCasa;
        edificacionHotel = edificacionDeHotel;
        casasTotales = 0;
        casasMaximas = 1;
        valor_mercado = costo;
    }

    public boolean permiteSalida(Jugador jugador){
        return true;
    }

    public boolean vender(Jugador jugador){
        if(!jugador.solicitar_dinero(valor_mercado)) return false;
        jugador.agregar_propiedad(this);
        cambiarPropietario(jugador);
        valor_mercado = costo * 85 /100;
        return true;
        }

    public void cambiarPropietario(Jugador jugador){
        propietario = jugador;
        casasTotales = 0;
        alquilerActual = 0;
    }


    public void accionAlPartir(Jugador jugador) {  }

    public void accionAlCaer(Jugador jugador, int numDado, Tablero tablero) {
        if (propietario == null){
            this.vender(jugador);
        }
        else if (propietario != jugador){
            jugador.solicitar_dinero(alquiler.get(alquilerActual));
            propietario.cobrar_ingreso(alquiler.get(alquilerActual));
        }
    }

    public Jugador duenio (){
        return propietario;
    }

    public int valorMercado(){return valor_mercado;}

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

    public String nombre() {
        return nombre;
    }

}
