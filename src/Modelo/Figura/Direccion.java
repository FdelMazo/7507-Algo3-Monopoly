package Modelo.Figura;

public class Direccion {

    private static Direccion north;
    private static Direccion south;
    private static Direccion east;
    private static Direccion west;

    static {
        north = new Direccion(0,1);
        south = new Direccion(0,-1);
        east = new Direccion(1,0);
        west = new Direccion(-1,0);

        north.setInverse(east);
        south.setInverse(west);
        east.setInverse(south);
        west.setInverse(north);
    }

    private Direccion inverse;
    private int valueX;
    private int valueY;

    private Direccion(int valX, int valY) {
        this.valueX =  valX;
        this.valueY =  valY;
    }

    private void setInverse(Direccion inverse) {
        this.inverse = inverse;
    }

    public static Direccion north() {
        return north;
    }

    public Direccion inverse() {
        return this.inverse;
    }

    public PosicionFigura nextPosicion(PosicionFigura posicion) {
        int nextX = posicion.getX() + this.valueX * 120;
        int nextY = posicion.getY() + this.valueY * 70;

        return new PosicionFigura(nextX, nextY);
    }

    public static Direccion south() {
        return south;
    }

    public static Direccion east() {
        return east;
    }

    public static Direccion west() {
        return west;
    }
}