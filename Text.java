import greenfoot.*;
import java.awt.Color;

public class Text extends Actor {
    
    private final int schriftgroesse;
    private final Color schriftfarbe;
    private final Color hintergrundfarbe;
    
    /**
     * @text Text, der angezeigt werden soll
     * @schriftgroesse Schriftgröße des Texts
     * @schriftfarbe Schriftfarbe des Texts
     * @hintergrundfarbe Hintergrundfarbe des Textfelds
     */
    public Text(String text, int schriftgroesse, Color schriftfarbe, Color hintergrundfarbe) {
        this.schriftgroesse = schriftgroesse;
        this.schriftfarbe = schriftfarbe;
        this.hintergrundfarbe = hintergrundfarbe;
        setText(text);
    }
    
    /**
     * Ändert den Text des Textfelds.
     * @text Text, der angezeigt werden soll
     */
    public void setText(String text) {
        setImage(new GreenfootImage(text, schriftgroesse, schriftfarbe, hintergrundfarbe));
    }
}
