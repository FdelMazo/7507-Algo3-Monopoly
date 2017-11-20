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
        int costo = propiedad.resetear();
        this.cobrar(costo);
    }

    public Propiedades propiedadParaIntercambiar() {
        return propiedades.remove(0);
    }

    public void intercambiarPropiedades(Jugador jugador) {
        Propiedades propiedad1 = this.propiedadParaIntercambiar();
        Propiedades propiedad2 = jugador.propiedadParaIntercambiar();
        jugador.agregar_propiedad(propiedad1);
        this.agregar_propiedad(propiedad2);
        propiedad1.cambiarPropietario(jugador);
        propiedad2.cambiarPropietario(this);
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

    public void agregar_propiedad(Propiedades propiedad) {
        propiedades.add(propiedad);
    }

    public String nombre() {
        return nombre;
    }

    public boolean posee(String propiedad) {
        for (Propiedades propiedadesDeJugador : propiedades) {
            if (propiedad == propiedadesDeJugador.nombre()) return true;
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
}
