package imageeditor;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Map;

/**
 *
 * @author Leonardo Cabral (<a href="mailto:leomcabral@gmail.com"></a>)
 */
public class Line implements Drawable {

    private Point pontoInicial = new Point(10,20);
    private Point pontoFinal = new Point(15, 250);
    private Line2D shape = new Line2D.Double(pontoInicial, pontoFinal); 
    
    @Override
    public void paint(Graphics2D g) {
        Color oldColor = g.getColor();
        g.setColor(Color.RED);
        
        g.setStroke(new BasicStroke(10));
        
        g.draw(shape);//drawLine(pontoInicial.x, pontoInicial.y, pontoFinal.x, pontoFinal.y);
        
        g.setColor(oldColor);
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }

    @Override
    public void receiveParameters(Map parameters) {
        if (parameters != null) {
            pontoFinal = (Point) parameters.get("mousePoint");
            shape.setLine(pontoInicial, pontoFinal);
        }
    }
    
}
