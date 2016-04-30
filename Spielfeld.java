import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

public class Spielfeld extends World {

    private boolean spielGestartet = false; //Wird ein einziges mal auf true gesetzt, wenn der Spieler sich das erste mal bewegt
    private boolean gestoppt = true;
    
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

    public void act() {
        if (isGestoppt()) return;
        gewonnenVerlorenPruefen();
        if (Greenfoot.isKeyDown("escape")) { //Level abbrechen
            Greenfoot.setWorld(new LevelAuswahl());
        }
    }
    
    /**
     * Ändert die Hintergrundfarbe auf die gegebene Farbe.
     */
    public static void setHintergrundFarbe(World world, Color color) {
        GreenfootImage hintergrund = new GreenfootImage(1, 1); //Nur ein Pixel groß, weil Greenfoot den gegebenen Hintergrund so oft wiederholt, bis alles ausgefüllt ist
        hintergrund.setColor(color);
        hintergrund.fill();
        world.setBackground(hintergrund);
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
     * Startet das Spiel.
     */
    public void spielStarten() {
        if (!spielGestartet) {
            this.spielGestartet = true;
            setGestoppt(false);
        }
    }
    
    /**
     * @return Ob das Spiel gestartet ist
     */
    public boolean isSpielGestartet() {
        return spielGestartet;
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
     * @return Die Anzahl der noch auf dem Spielfeld vorhandenen Gegner
     */
    public int getGegnerAufSpielfeld() {
        return getObjects(Gegner.class).size();
    }
    
    /**
     * Prüft, ob der Spieler gewonnen oder verloren hat und führt dementsprechend weitere Aktionen aus.
     */
    private void gewonnenVerlorenPruefen() {
        int punkteAufFeld = getPunkteAufSpielfeld();
        if (punkteAufFeld == 0) { //Gegner haben alle Punkte
            endNachrichtZeigen("Game over! Score: " + punkteAufFeld);
        }
        
        if (getGegnerAufSpielfeld() == 0) { //Alle Gegner tot
            endNachrichtZeigen("Gewonnen! Score: " + punkteAufFeld);
        }
    }
    
    /**
     * Zeigt die gegebene Nachricht, wartet, löscht alle Objekte, wartet nochmal und kehrt dann zur LevelAuswahl zurück.
     */
    private void endNachrichtZeigen(String nachricht) {
        setGestoppt(true);
        showText(nachricht, getWidth() / 2, getHeight() / 2);
        Greenfoot.delay(50);
        spielfeldLeeren();
        Greenfoot.delay(120);
        Greenfoot.setWorld(new LevelAuswahl());
    }
    
    /**
     * Prüft, ob die gegebene Position auf dem Spielfeld ist.
     */
    public boolean isPositionInSpielfeld(int x, int y) {
        return 0 <= x && x < getWidth() && 0 <= y && y < getHeight();
    }
}
