import greenfoot.*;
import java.util.List;

public class Spielfeld extends World {
    
    private int feldgroesse;
    private int breite;
    private int hoehe;
    
    public Spielfeld(int breite, int hoehe, int feldgroesse, String mapString) {
        super(breite * feldgroesse, hoehe * feldgroesse, 1);
        
        this.feldgroesse = feldgroesse;
        this.breite = breite;
        this.hoehe = hoehe;
        
        setPaintOrder(Spieler.class, Gegner.class, Punkt.class);
        Greenfoot.setSpeed(50);

        einlesen(mapString);
    }
    
    public int getFeldgroesse() {
        return feldgroesse;
    }
    
    /**
     * Fügt das gegebene SpielfeldObjekt an der gegebenen Position ein.
     */
    public void objektHinzufuegen(SpielfeldObjekt objekt, int x, int y) {
        addObject(objekt, 0, 0);
        objekt.setPos(x, y); //Position korrigieren
    }
    
    /**
     * Liest den mapString ein und "baut" das Spielfeld auf.
     * O -> Punkt, X -> Wand, S -> Spieler, G -> Gegner
     * Beispiel:
     * XXXXX
     * XOOGX
     * XOXXX
     * XOSOX
     * XXXXX
     */
    private void einlesen(String mapString) {
        spielfeldLeeren();
        
        String[] mapReihen = mapString.split(";", hoehe);
        
        for (int y = 0; y < hoehe; y++) {
            String[] reihe = mapReihen[y].split("", breite);
            for (int x = 0; x < breite; x++) {
                String feldBuchstabe = reihe[x];
                SpielfeldObjekt objekt = null;
                if (feldBuchstabe.equals("O")) {
                    objekt = new Punkt();
                } else if (feldBuchstabe.equals("X")) {
                    objekt = new Wand();
                } else if (feldBuchstabe.equals("S")) {
                    objekt = new Spieler();
                } else if (feldBuchstabe.equals("G")) {
                    objekt = new Gegner();
                }
                
                if (objekt != null) {
                    objektHinzufuegen(objekt, x, y); //Zur Welt hinzufügen
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
     * Siehe World#getObjectsAt(int, int, Class).
     */
    public <T> List<T> getObjekteAuf(int x, int y, Class<T> clazz) {
        return getObjectsAt(x * feldgroesse, y * feldgroesse, clazz);
    }
    
    /**
     * Prüft, ob die gegebene Position auf dem Spielfeld ist.
     */
    public boolean isPositionInSpielfeld(int x, int y) {
        return 0 <= x && x < breite && 0 <= y && y < hoehe;
    }
}
