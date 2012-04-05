package imageeditor;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.Map;

/**
 *
 * @author Leonardo Cabral (<a href="mailto:leomcabral@gmail.com"></a>)
 */
public interface Drawable {
    
    void paint(Graphics2D g);
    
    Shape getShape();
    
    void receiveParameters(Map parameters);
}
