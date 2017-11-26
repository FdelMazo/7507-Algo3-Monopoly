package Modelo;

import Modelo.Casilleros.Propiedades;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class Municipio {

    private static Municipio primeraInstancia = null;
    private Hashtable<String, Jugador> propietarios = new Hashtable<>();
    private Hashtable<String, String> hermano = new Hashtable<>();
    private Hashtable<String, Pair> alquiler_servicio = new Hashtable<>();
    private Hashtable<String, ArrayList<Propiedades>> jugadorPropiedades = new Hashtable<>();
    private Hashtable<String,Integer> cant_edificaciones = new Hashtable<>();

    private Municipio() {
    }

    public static Municipio getInstance() {
        if (primeraInstancia == null) {
            primeraInstancia = new Municipio();
            primeraInstancia.cargarDatos();
        }
        return primeraInstancia;
    }

    public void cargarDatos() {

        ArrayList<String> nombres_propiedades = new ArrayList<>();
        File file = new File("src\\Modelo\\nombres_propiedades.txt");
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                nombres_propiedades.add(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (String propiedad :nombres_propiedades){
            cant_edificaciones.put(propiedad,0);
        }

        hermano.put("Buenos Aires Sur", "Buenos Aires Norte");
        hermano.put("Buenos Aires Norte", "Buenos Aires Sur");
        hermano.put("Salta Norte", "Salta Sur");
        hermano.put("Salta Sur", "Salta Norte");
        hermano.put("Cordoba Norte", "Cordoba Sur");
        hermano.put("Cordoba Sur", "Cordoba Norte");
        hermano.put("Tren", "Subte");
        hermano.put("Subte", "Tren");
        hermano.put("Aysa", "Edesur");
        hermano.put("Edesur", "Aysa");

        alquiler_servicio.put("Tren", new Pair(450, 800));
        alquiler_servicio.put("Subte", new Pair(600, 1100));
        alquiler_servicio.put("Aysa", new Pair(300, 500));
        alquiler_servicio.put("Edesur", new Pair(500, 1000));

    }

    public void cambiar_propietario(Jugador jugador, Propiedades propiedad) {

        cant_edificaciones.put(propiedad.nombre(), 0);

        //Si ya tenía propietario se la saca al propietario viejo
        if (propietarios.get(propiedad.nombre()) != null) {

            Jugador exDuenio = propietarios.get(propiedad.nombre());
            jugadorPropiedades.get(exDuenio.getNombre()).remove(propiedad);

        }
        propietarios.put(propiedad.nombre(), jugador);
        //Agrego la propiedad al nuevo dueño
        if (jugadorPropiedades.containsKey(jugador.getNombre())) {
            jugadorPropiedades.get(jugador.getNombre()).add(propiedad);
        } else {
            ArrayList<Propiedades> propiedades = new ArrayList<>();
            propiedades.add(propiedad);
            jugadorPropiedades.put(jugador.getNombre(), propiedades);
        }
    }

    public int devolverAlquilerServicio(Propiedades propiedad) {
        if (propietarios.get(propiedad.nombre()) == propietarios.get(hermano.get(propiedad.nombre()))) {
            return (int) (alquiler_servicio.get(propiedad.nombre()).getValue());
        }
        return (int) (alquiler_servicio.get(propiedad.nombre()).getKey());
    }

    public void devolverAlquilerBarrio(Propiedades propiedad) {
        if (hermano.containsKey(propiedad.nombre())) {
            if (propietarios.get(propiedad.nombre()) == propietarios.get(hermano.get(propiedad.nombre()))) {
                return;
            }
        } else {
            return;
        }
    }

    public void resetear() {
        primeraInstancia = null;
    }

    public boolean tienePropietario(Propiedades propiedad) {
        if (this.propietarios.containsKey(propiedad.nombre()) && this.propietarios.get(propiedad.nombre()) != null) {
            return true;
        }
        return false;
    }

    public Jugador devolverPropietario(Propiedades propiedad) {
        if (this.tienePropietario(propiedad)) {
            return propietarios.get(propiedad.nombre());
        }
        return null;
    }

    public ArrayList<Propiedades> devolverPropiedades(Jugador jugador) {
        if (jugadorPropiedades.containsKey(jugador.getNombre())) {
            return jugadorPropiedades.get(jugador.getNombre());
        }
        return null;
    }

    public void cederPropiedadAlBanco(Jugador duenio, Propiedades propiedad) {

        propiedad.cederAlBanco(duenio);
        propietarios.remove(propiedad.nombre());
        jugadorPropiedades.get(duenio.getNombre()).remove(propiedad);
        cant_edificaciones.put(propiedad.nombre(), 0);
    }

    public void agregarEdificacion(Propiedades propiedad){
        int valor = cant_edificaciones.get(propiedad.nombre());
        cant_edificaciones.put(propiedad.nombre(),valor + 1);
    }

    public int edificacionesExistentes(Propiedades propiedad){
        return cant_edificaciones.get(propiedad.nombre());
    }

    public boolean poseeLosDosHermanos( Propiedades propiedad){

        if (propietarios.containsKey(propiedad.nombre()) && propietarios.containsKey(hermano.get(propiedad.nombre()))){
            return propietarios.get(propiedad.nombre()) == propietarios.get(hermano.get(propiedad.nombre()));
        }
        return false;
    }

    public boolean puedeEdificarHotel(Propiedades propiedad){

        if(hermano.containsKey(propiedad.nombre())){
            if(poseeLosDosHermanos(propiedad)){
                if(propietarios.get(propiedad.nombre()) == propietarios.get(hermano.get(propiedad.nombre()))) {
                    return cant_edificaciones.get(propiedad.nombre()) == 2 && cant_edificaciones.get(hermano.get(propiedad.nombre())) >= 2;
                }
            }
        }
        return false;
    }
}







