import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

public class Spielfeld extends World {
    
    private long acts = 0;
    
    public Spielfeld(int breite, int hoehe, int feldgroesse, String mapString) {
        super(breite, hoehe, feldgroesse);
        
        setPaintOrder(Spieler.class, Gegner.class, Punkt.class);
        Greenfoot.setSpeed(50);

        einlesen(mapString);
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
        
        String[] mapReihen = mapString.split(";", getHeight());
        
        for (int y = 0; y < getHeight(); y++) {
            String[] reihe = mapReihen[y].split("", getWidth());
            for (int x = 0; x < getWidth(); x++) {
                String feldBuchstabe = reihe[x];
                Figur objekt = null;
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
                    addObject(objekt, x, y); //Zur Welt hinzufügen
                }
            }
        }
    }
    
    public void act() {
        if (Greenfoot.getRandomNumber(100) == 42) {
            spawnPowerUp();
        }
    }
    
    private void spawnPowerUp() {
        
    }
    
    /**
     * Sucht nach dem gegebenen Objekttyp auf dem Spielfeld.
     * @clazz Objekttyp, nach dem gesucht werden soll; null, wenn kein Objekt auf dem Feld sein darf
     * @return Positionen, auf denen der gegebene Objekttyp vorhanden ist
     */
    // private <T> List<Position> getObjekte(Class<T> clazz) {
        // List<Position> positionen = new ArrayList<Position>();
        // for
            // y ->
            // clazz == obj(x, y)
            // list.add
            
        // return list
    // }
    
    /**
     * Entfernt alle Objekte auf dem Spielfeld.
     */
    private void spielfeldLeeren() {
        removeObjects(getObjects(null));
    }
    
    /**
     * Prüft, ob die gegebene Position auf dem Spielfeld ist.
     */
    public boolean isPositionInSpielfeld(int x, int y) {
        return 0 <= x && x < getWidth() && 0 <= y && y < getHeight();
    }
}
