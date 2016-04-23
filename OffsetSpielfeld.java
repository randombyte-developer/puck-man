import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
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
        Position pos = mitOffset(new Position(x, y));
        super.addObject(actor, pos.getX(), pos.getY());
    }
    
    /**
     * Fügt einen Actor wie super.addObject(...) hinzu, ohne den Offset zu beachten.
     */
    public void addObjectOhneOffset(Actor actor, int x, int y) {
        super.addObject(actor, x, y);
    }
    
    /**
     * Wie super.getObjectsAt(...) unter Beachtung des Offsets.
     */
    public <T> List<T> getObjectsAtMitOffset(int x, int y, Class<T> clazz) {
        Position pos = mitOffset(new Position(x, y));
        return super.getObjectsAt(pos.getX(), pos.getY(), clazz);
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
    
    /**
     * Wandelt eine Position um, damit der Offset beachtet wird. Die Position kann danach direkt mit allen Greenfoot-Methoden benutzt werden.
     */
    public Position mitOffset(Position pos) {
        return new Position(pos.getX() + (xOffset > 0 ? xOffset : 0), pos.getY() + (yOffset > 0 ? yOffset : 0));
    }
    
    /**
     * Wandelt eine Position um, damit der Offset nicht beachtet wird.
     */
    public Position ohneOffset(Position pos) {
        return new Position(pos.getX() - Math.max(0, xOffset), pos.getY() + Math.max(0, yOffset));
    }
    
    /**
     * @return Liste mit Positionen, wo leere Felder sind
     */
    public List<Position> leereFelderSuchen() {
        return felderSuchen(null, false);
    }

    /**
     * Sucht nach Positionen, die dem gebenenem Typ entsprechen innerhalb des Spielfelds und lässt den Offset außen vor.
     * @clazz Typ des Actors, nach dem gesucht werden soll oder null, wenn nach leeren Felder gesucht werden soll
     * @umgekehrt true, wenn das Gegenteil des Kriteriums gefunden werden soll
     * @return Liste mit Positionen, die dem Kriterium entsprechen
     */
    public List<Position> felderSuchen(Class clazz, boolean umgekehrt) {
        boolean nachFreienFeldernSuchen = clazz == null;
        List<Position> felder = new ArrayList<Position>();
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                List<Actor> actors = getObjectsAtMitOffset(x, y, clazz);
                boolean keinActorAufFeld = actors.size() == 0;
                if ((nachFreienFeldernSuchen && keinActorAufFeld) || (!nachFreienFeldernSuchen && !keinActorAufFeld)) {
                    if (!umgekehrt) {
                        felder.add(new Position(x, y));
                    }
                } else if (umgekehrt) {
                    felder.add(new Position(x, y));
                }
            }
        }

        return felder;
    }
}
