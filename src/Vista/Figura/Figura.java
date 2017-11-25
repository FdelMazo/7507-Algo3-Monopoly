package Vista.Figura;

public class Figura {
    private Direccion direccion;
    private PosicionFigura posicionFigura;
    private Sensor sensor;

    public Figura(Sensor sensor, PosicionFigura posicion){
        this.sensor = sensor;
        this.posicionFigura = posicion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void move(){

    }

}
