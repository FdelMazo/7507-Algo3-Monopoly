package Modelo.Figura;

public class Contenedor {
    private final int width;
    private final int height;

    public Contenedor(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}
