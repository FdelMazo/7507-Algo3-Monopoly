package Modelo;
import Modelo.Casilleros.Propiedades;
import Modelo.Casilleros.Casillero;

import java.util.ArrayList;


public class Jugador {

    private int capital;
    private Casillero casilleroActual;
    private String nombre;
    private Estado estado;
    private Dados dados;
    Municipio municipio = Municipio.getInstance();

    public Jugador(String nombreJugador) {
        this.capital = 100000;
        casilleroActual = null;
        nombre = nombreJugador;
        estado = new Libre();
    }

    public void asignarCasillero(Casillero casillero) {
        casilleroActual = casillero;
    }

    public int cantPropiedades() {
        ArrayList<Propiedades> propiedades = municipio.devolverPropiedades(this);
        if (propiedades == null){return 0;}
        return propiedades.size();
    }

    public void caeEn(Casillero casillero) {
        if (dados == null) lanzarDados();
        asignarCasillero(casillero);
        casilleroActual.accionAlCaer(this);
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

    public boolean comprar(int monto,Propiedades propiedad){
        if (this.capital < monto) return false;
        this.agregarPropiedad(propiedad);
        this.solicitarDinero(monto);
        return true;
    }

    public void venderAlBanco(Propiedades propiedad) {

        municipio.cederPropiedadAlBanco(this,propiedad);

    }

    public void intercambiarPropiedades(Propiedades miPropiedad,Jugador otroJugador, Propiedades propiedad) {

        miPropiedad.cambiarPropietario(otroJugador);
        propiedad.cambiarPropietario(this);


    }

    public boolean solicitarDinero(double dineroSolicitado) {

        if (capital >= dineroSolicitado) {
            capital -= dineroSolicitado;
            return true;
        }
        ArrayList<Propiedades> propiedades = municipio.devolverPropiedades(this);
        if(propiedades==null) return false;
        for (Propiedades propiedad : propiedades) {

            this.venderAlBanco(propiedad);
            if (this.solicitarDinero(dineroSolicitado)) return true;
        }
        return false;
    }

    public void agregarPropiedad(Propiedades propiedad) {

        municipio.cambiar_propietario(this,propiedad);
    }

    public boolean posee(String nombrePropiedad) {

        ArrayList<Propiedades> propiedades = municipio.devolverPropiedades(this);
        if(propiedades==null){return false;}
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
        return capital <= 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int lanzarDados(){
        dados = new Dados();
        return sumaDados();
    }

    public int lanzarDadosdobles(){
        dados = new Dados();
        dados.dadosDobles();
        return sumaDados();
    }
    public boolean doble(){
        return dados.doble();
    }

    public int sumaDados() {
        return dados.suma();
    }
}
