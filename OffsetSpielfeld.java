import greenfoot.*;
import java.lang.Math;

public class OffsetSpielfeld extends Spielfeld {
    
    private final int xOffset; //Positiv, wenn eine Spalte links hinzugefügt, negativ, wenn rechts
    private final int yOffset; //Positiv, wenn eine Reihe oben hinzugefügt, negativ, wenn unten
    
    public OffsetSpielfeld(int breite, int hoehe, int feldgroesse, int xOffset, int yOffset) {
        super(breite + Math.abs(xOffset), hoehe + Math.abs(yOffset), feldgroesse);
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    
    /**
     * @return Den Offset in x-Richtung
     */
    public int getXOffset() {
        return xOffset;
    }
    
    /**
     * @return Den Offset in y-Richtung
     */
    public int getYOffset() {
        return yOffset;
    }
    
    /**
     * Methode überschreiben, damit Offset beachtet wird.
     */
    public void addObject(Actor actor, int x, int y) {
        super.addObject(actor, x + (xOffset > 0 ? xOffset : 0), y + (yOffset > 0 ? yOffset : 0));
    }
    
    /**
     * Fügt einen Actor wie super.addObject(...) hinzu, ohne den Offset zu beachten.
     */
    public void addObjectOhneOffset(Actor actor, int x, int y) {
        super.addObject(actor, x, y);
    }
    
    /**
     * Methode überschreiben, damit Offset beachtet wird.
     */
    public int getWidth() {
        return super.getWidth() - Math.abs(xOffset);
    }
    
    /**
     * Methode überschreiben, damit Offset beachtet wird.
     */
    public int getHeight() {
        return super.getHeight() - Math.abs(yOffset);
    }
}
