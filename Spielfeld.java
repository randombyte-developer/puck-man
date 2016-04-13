import greenfoot.*;

public class Spielfeld extends World {

    public Spielfeld(int breite, int hoehe, int feldgroesse) {
        super(breite, hoehe, feldgroesse);
        
        Greenfoot.setSpeed(50);
        mauernBauen();
        setPaintOrder(Spieler.class, Gegner.class, Punkt.class);
    }
    
    /**
     * Setzt Wände außen am Spielfeld.
     */
    private void mauernBauen() {
        for (int x = 0; x < getWidth(); x++) {
            addObject(new Wand(), x, 0);
            addObject(new Wand(), x, getHeight());
        }
        for (int y = 0; y < getHeight(); y++) {
            addObject(new Wand(), 0, y);
            addObject(new Wand(), getWidth(), y);
        }
    }
    
    /**
     * Setzt Punkte auf freie Spielfelder.
     */
    protected void punkteVerteilen() {
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                boolean keinObjektAufFeld = getObjectsAt(x, y, null).size() == 0;
                if (keinObjektAufFeld) {
                    addObject(new Punkt(), x, y);
                }
            }
        }
    }
    
    /**
     * Prüft, ob die gegebene Position auf dem Spielfeld ist.
     */
    public boolean isPositionInSpielfeld(int x, int y) {
        return 0 <= x && x < getWidth() && 0 <= y && y < getHeight();
    }
}
