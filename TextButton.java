import greenfoot.*;
import java.awt.Color;

/**
 * Ein anklickbarer Button mit Text.
 */
public class TextButton extends Actor {
    
    private final GreenfootImage normal;
    private final GreenfootImage selektiert;
    private final KlickCallback callback;
    
    /**
     * @text Text, der auf dem Button angezeigt werden soll
     * @schriftgroesse Schriftgroesse, die die Beschriftung des Buttons haben soll
     * @farbeNormal Die Farbe, die angezeigt werden soll, wenn die Maus nicht über dem Button ist
     * @farbeSelektiert Die Farbe, die angezeigt werden soll, wenn die Maus über dem Button ist
     * @callback Ein Callback, das ausgeführt werden soll, wenn auf den Button geklickt wird
     */
    public TextButton(String text, int schriftgroesse, Color farbeNormal, Color farbeSelektiert, KlickCallback callback) {
        this.normal = new GreenfootImage(text, schriftgroesse, Color.BLACK, farbeNormal);
        this.selektiert = new GreenfootImage(text, schriftgroesse, Color.BLACK, farbeSelektiert);
        this.callback = callback;
    }
    
    /**
     * Auf Klick reagieren und Bild ändern, falls Maus über Button.
     */
    public void act() {
        MouseInfo info = Greenfoot.getMouseInfo();
        
        if (info != null && info.getX() == getX() && info.getY() == getY()) { //Maus über Button
            setImage(selektiert);
            if (info.getButton() == 1) { //Linksklick
                callback.klick();
            }
        } else {
            setImage(normal);
        }
    }
}
