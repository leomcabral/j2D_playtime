package imageeditor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Cabral (<a href="mailto:leomcabral@gmail.com"></a>)
 */
public class BasicLayer implements Layer {

    private List<Drawable> drawables = new ArrayList<Drawable>();
    
    @Override
    public List<Drawable> getDrawables() {
        return drawables;
    }

    @Override
    public boolean isVisible() {
        return true;
    }
    
    @Override
    public void addDrawable(Drawable drawable) {
        if (drawable == null) {
            throw new NullPointerException();
        }
        
        this.drawables.add(drawable);
    }
    
}
