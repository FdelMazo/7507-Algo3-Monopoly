package Modelo;
import Modelo.Casilleros.Propiedades;
import Modelo.Casilleros.Casillero;
import Vista.Consola;

import java.util.ArrayList;


public class Jugador {

    private int capital;
    private ArrayList<Propiedades> propiedades;
    private Casillero casilleroActual;
    private String nombre;
    private Estado estado;
    Municipio municipio = Municipio.getInstance();

    public Jugador(String nombreJugador) {
        this.capital = 100000;
        propiedades = new ArrayList<>();
        casilleroActual = null;
        nombre = nombreJugador;
        estado = new Libre();
        Consola.println("El jugador "+nombreJugador+"ha ingresado a la partida");
    }

    public void asignarCasillero(Casillero casillero) {
        casilleroActual = casillero;
    }

    public int cantPropiedades() {
        return propiedades.size();
    }

    public void caeEn(Casillero casillero, int numDado, Tablero tablero) {
        asignarCasillero(casillero);
        casilleroActual.accionAlCaer(this, numDado, tablero);
    }

    public Casillero actual() {
        return casilleroActual;
    }

    public void cobrar(int monto) {
        capital += monto;
    }

    public int capital() {
        return capital;
    }
    
    public void venderAlBanco(Propiedades propiedad) {

        propiedades.remove(propiedad);
        propiedad.cederAlBanco(this);
    }

    public void intercambiarPropiedades(Jugador otroJugador, Propiedades propiedad) {

        Propiedades propiedad1 = propiedades.remove(0);
        Propiedades propiedad2 = otroJugador.propiedades.remove(0);
        this.agregarPropiedad(propiedad2);
        otroJugador.agregarPropiedad(propiedad1);
        municipio.cambiar_propietario(this,propiedad2);
        municipio.cambiar_propietario(otroJugador,propiedad1);

    }

    public boolean solicitarDinero(double dineroSolicitado) {
        if (capital > dineroSolicitado) {
            capital -= dineroSolicitado;
            return true;
        }
        for (Propiedades propiedad : propiedades) {
            this.venderAlBanco(propiedad);
            if (this.solicitarDinero(dineroSolicitado)) return true;
        }
        return false;
    }

    public void agregarPropiedad(Propiedades propiedad) {
        propiedades.add(propiedad);
    }

    public boolean posee(String nombrePropiedad) {
        for (Propiedades propiedadesDeJugador : propiedades) {
            if (nombrePropiedad == propiedadesDeJugador.nombre()) return true;
        }
        return false;
    }

    public boolean mover() {
        return estado.mover(this);
    }

    public void actualizarEstado(Estado nuevo_estado) {
        estado = nuevo_estado;
    }

    public boolean perdio() {
        return capital == 0;
    }

    public String getNombre(){ return nombre; }
}
