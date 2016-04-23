import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

public class Spielfeld extends World {

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
     * Entfernt alle Objekte auf dem Spielfeld.
     */
    public void spielfeldLeeren() {
        removeObjects(getObjects(null));
    }
    
    
    /**
     * @return Liste mit Positionen, wo leere Felder sind
     */
    public List<Position> leereFelderSuchen() {
        return felderSuchen(null);
    }

    /**
     * Sucht nach Positionen, die dem gebenenem Typ entsprechen.
     * @clazz Typ des Actors, nach dem gesucht werden soll oder null, wenn nach leeren Felder gesucht werden soll
     * @return Liste mit Positionen, die dem Kriterium entsprechen
     */
    public List<Position> felderSuchen(Class clazz) {
        boolean nachFreienFeldernSuchen = clazz == null;
        List<Position> felder = new ArrayList<Position>();
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                List<Actor> actors = getObjectsAt(x, y, clazz);
                boolean keinActorAufFeld = actors.size() == 0;
                if ((nachFreienFeldernSuchen && keinActorAufFeld) || (!nachFreienFeldernSuchen && !keinActorAufFeld)) { 
                    felder.add(new Position(x, y));
                }
            }
        }

        return felder;
    }

    /**
     * Prüft, ob die gegebene Position auf dem Spielfeld ist.
     */
    public boolean isPositionInSpielfeld(int x, int y) {
        return 0 <= x && x < getWidth() && 0 <= y && y < getHeight();
    }
}
