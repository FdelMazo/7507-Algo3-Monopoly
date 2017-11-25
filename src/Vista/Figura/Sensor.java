package Vista.Figura;

public class Sensor {

    private final Contenedor contenedor;

    public Sensor(Contenedor contenedor){
        this.contenedor = contenedor;
    }

    public boolean estaEnContacto(PosicionFigura posicion){
        boolean contactoX = Math.abs(posicion.getX()) >= contenedor.getWidth()/2;
        boolean contactoY = Math.abs(posicion.getY()) >= contenedor.getHeight()/2;
        return contactoX || contactoY;
    }

}
