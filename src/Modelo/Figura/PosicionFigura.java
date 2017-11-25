package Modelo.Figura;

public class PosicionFigura {

    private int x;
    private int y;

    public PosicionFigura(int posX, int posY) {
        this.x = posX;
        this.y = posY;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public PosicionFigura next(Direccion direccion) {
        return direccion.nextPosicion(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PosicionFigura)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PosicionFigura other = (PosicionFigura) obj;
        return (this.getX() == other.getX() && this.getY() == other.getY());
    }

}
