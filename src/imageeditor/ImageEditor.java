package imageeditor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Leonardo Cabral (<a href="mailto:leomcabral@gmail.com"></a>)
 */
public class ImageEditor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("Desenhador");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                final Container c = frame.getContentPane();
                
                DrawablePanel drawablePanel = new DrawablePanel();
                drawablePanel.addLayer(criarLayers());
                
                c.setLayout(new BorderLayout());
                c.add(drawablePanel);
                
                frame.setPreferredSize(new Dimension(800, 600));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    
    private static Layer criarLayers() {
        Layer layer = new BasicLayer();
        layer.addDrawable(new Line());
        return layer;
    }
}
