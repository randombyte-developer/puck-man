import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

public class Spielfeld extends World {

    private boolean gestoppt = false;
    
    public Spielfeld(int breite, int hoehe, int feldgroesse) {
        super(breite, hoehe, feldgroesse, false); //false -> nicht 'bounded'

        setPaintOrder(Spieler.class, Gegner.class, Punkt.class);
        Greenfoot.setSpeed(50);
    }

    /**
     * Liest den mapString ein und "baut" das Spielfeld auf. Löscht alles auf dem Spielfeld!
     * O -> Punkt, X -> Wand, S -> Spieler, G -> Gegner
     * Beispiel:
     * XXXXX
     * XOOGX
     * XOXXX
     * XOSOX
     * XXXXX
     */
    protected void einlesen(String mapString) {
        spielfeldLeeren();

        String[] mapReihen = mapString.split(";", getHeight());
        if (mapReihen.length != getHeight()) {
            System.out.println("Die Anzahl der Reihen von " + mapReihen.length + " Reihen entspricht nicht der Spielfeldhöhe von " + getHeight() + " Reihen!");
        }
        
        for (int y = 0; y < getHeight(); y++) {
            String[] reihe = mapReihen[y].split("", getWidth());
            if (reihe.length != getWidth()) {
                System.out.println("Die " + y + ". Reihe hat nicht so viele Zeichen wie die Spielfeldbreite von " + getWidth() + " Feldern!");
            }
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

    /**
     * Verhindert die Ausführung der act Methode.
     */
    public void setGestoppt(boolean gestoppt) {
        this.gestoppt = gestoppt;
    }
    
    /**
     * @return Ob das Spiel zur Zeit gestoppt ist
     */
    public boolean isGestoppt() {
        return gestoppt;
    }
    
    /**
     * Entfernt alle Objekte auf dem Spielfeld.
     */
    public void spielfeldLeeren() {
        removeObjects(getObjects(null));
    }
        
    /**
     * @return Die Anzahl der noch auf dem Spielfeld vorhandenen Punkte
     */
    public int getPunkteAufSpielfeld() {
        return getObjects(Punkt.class).size();
    }

    /**
     * Prüft, ob die gegebene Position auf dem Spielfeld ist.
     */
    public boolean isPositionInSpielfeld(int x, int y) {
        return 0 <= x && x < getWidth() && 0 <= y && y < getHeight();
    }
}
