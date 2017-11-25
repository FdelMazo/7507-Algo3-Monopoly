package Modelo.Figura;

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
        PosicionFigura act = this.posicionFigura;
        PosicionFigura next = this.posicionFigura.next(this.direccion);
        if (this.sensor.estaEnContacto(next)){
            this.direccion = this.direccion.inverse();
            this.posicionFigura = this.posicionFigura.next(this.direccion);
        }
        else{
            this.posicionFigura = this.posicionFigura.next(this.direccion);
        }
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    public PosicionFigura getPosicionFigura() {
        return this.posicionFigura;
    }
}
