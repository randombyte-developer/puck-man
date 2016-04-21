import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Zeigt am oberen Spielfeldrand eine Reihe für Statusinformationen(z.B. aktuelles PowerUp) an.
 */
public class StatusInfoSpielfeld extends OffsetSpielfeld {
    
    private Text punkteText = new Text("", 30, Color.BLACK, Color.WHITE);
    
    public StatusInfoSpielfeld(int breite, int hoehe, int feldgroesse, String mapString) {
        super(breite, hoehe, feldgroesse, 0, 1); //Eine Reihe oben hinzugefügt
        einlesen(mapString);
        addObjectOhneOffset(punkteText, 3, 0);
    }
    
    /**
     * @return Die Anzahl der noch auf dem Spielfeld vorhandenen Punkte
     */
    private int getPunkteAufSpielfeld() {
        return getObjects(Punkt.class).size();
    }
    
    
    public void act() {
        super.act();
        punkteText.setText(getPunkteAufSpielfeld() + " Punkte");
        if (Greenfoot.getRandomNumber(100) == 42) { //Zufälliger Zeitpunkt
            List<Position> leereFelder = leereFelderSuchen();
            if (leereFelder.size() > 0) {
                Position leeresFeld = leereFelder.get(Greenfoot.getRandomNumber(leereFelder.size()));
                spawnPowerUp(PowerUpTyp.getRandomTyp(), leeresFeld.getX(), leeresFeld.getY());
            }
        }
    }

    /**
     * Spawnt ein PowerUp an der gegebenen Position.
     * @typ Typ des PowerUps, das gespawnt wird
     * @x Die X-Koordinate
     * @y Die Y-Koordinate
     */
    private void spawnPowerUp(PowerUpTyp typ, int x, int y) {
        addObject(new PowerUp(typ), x, y);
    }

    /**
     * @return Liste mit Positionen, wo leere Felder sind
     */
    private List<Position> leereFelderSuchen() {
        return felderSuchen(null);
    }

    /**
     * Sucht nach Positionen, die dem gebenenem Typ entsprechen.
     * @clazz Typ des Actors, nach dem gesucht werden soll oder null, wenn nach leeren Felder gesucht werden soll
     * @return Liste mit Positionen, die dem Kriterium entsprechen
     */
    private List<Position> felderSuchen(Class clazz) {
        boolean nachFreienFeldernSuchen = clazz == null;
        List<Position> felder = new ArrayList<Position>();
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                List<Actor> actors = getObjectsAtMitOffset(x, y, clazz);
                boolean keinActorAufFeld = actors.size() == 0;
                if ((nachFreienFeldernSuchen && keinActorAufFeld) || (!nachFreienFeldernSuchen && !keinActorAufFeld)) { 
                    felder.add(new Position(x, y));
                }
            }
        }

        return felder;
    }
}
