package imageeditor;

import java.util.List;

/**
 *
 * @author Leonardo Cabral (<a href="mailto:leomcabral@gmail.com"></a>)
 */
public interface Layer {
    List<Drawable> getDrawables();
    boolean isVisible();
    void addDrawable(Drawable drawable);
}
