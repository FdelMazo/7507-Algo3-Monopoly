package Vista;

import Controladores.EntradaUsuario;
import Controladores.Sistema;
import Modelo.Jugador;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class VistaJugador {
    Circle circulo;
    public VistaJugador(Jugador jugador, Color color) {
       PiezaJugador pieza = new PiezaJugador(color);
       circulo = pieza.getForma();

    }

    public Circle getPieza() {
        return circulo;
    }

}
