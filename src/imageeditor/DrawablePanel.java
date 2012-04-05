package imageeditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

/**
 *
 * @author Leonardo Cabral (<a href="mailto:leomcabral@gmail.com"></a>)
 */
public class DrawablePanel extends JPanel implements MouseListener, MouseMotionListener {

    private List<Layer> layers = new ArrayList<Layer>();

    public DrawablePanel() {
        setOpaque(true);
        setBackground(Color.BLUE);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Layer layer : layers) {
            if (layer.isVisible()) {
                for (Drawable drawable : layer.getDrawables()) {
                    drawable.paint(g2);
                }
            }
        }
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public void addLayer(Layer layer) {
        if (layer == null) {
            throw new NullPointerException();
        }
        
        layers.add(layer);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Map params = new HashMap();
        params.put("mousePoint", e.getPoint());
        
        for (Layer layer : layers) {
            for (Drawable drawable : layer.getDrawables()) {
                drawable.receiveParameters(params);
            }
        }
        repaint();
    }
}
