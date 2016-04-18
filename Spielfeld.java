import greenfoot.*;

public class Spielfeld extends World {

    public Spielfeld(int breite, int hoehe, int feldgroesse) {
        super(breite, hoehe, feldgroesse);
        
        Greenfoot.setSpeed(50);
        mauernBauen();
        setPaintOrder(Spieler.class, Gegner.class, Punkt.class);
    }
    
    public Spielfeld(int breite, int hoehe, int feldgroesse, String mapString) {
        super(breite, hoehe, feldgroesse);
        einlesen(mapString);
        punkteVerteilen();
    }
    
    /**
     * Liest den mapString ein und "baut" das Spielfeld auf.
     */
    private void einlesen(String mapString) {
        spielfeldLeeren();
        
        String[] mapReihen = mapString.split(";", getHeight());
        
        for (int y = 0; y < getHeight(); y++) {
            String[] reihe = mapReihen[y].split("", getWidth());
            for (int x = 0; x < getWidth(); x++) {
                SpielfeldObjekt objekt = null;
                if (reihe[x].equals("X")) {
                    objekt = new Wand();
                } else if (reihe[x].equals("S")) {
                    objekt = new Gegner();
                } else if (reihe[x].equals("G")) {
                    objekt = new Spieler();
                }
                
                if (objekt != null) {
                    addObject(objekt, x, y); //Zur Welt hinzufügen
                }
            }
        }
    }
    
    /**
     * Entfernt alle Objekte auf dem Spielfeld.
     */
    private void spielfeldLeeren() {
        removeObjects(getObjects(null));
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
