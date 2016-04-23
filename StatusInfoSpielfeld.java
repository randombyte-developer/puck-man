import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Spielfeld mit einer Reihe oben am Spielfeldrand für Statusinformationen(z.B. aktuelles PowerUp). Spawnt PowerUps.
 */
public class StatusInfoSpielfeld extends OffsetSpielfeld {
    
    private double powerUpVorkommen;
    
    private Text punkteText = new Text("", 30, Color.BLACK, Color.WHITE);
    private PowerUp powerUpDisplay = null;
    
    /**
     * @powerUpVorkommen Zwischen 0 und 1, wie wahrscheinlich es ist, dass in einer act-Methode ein PowerUp gespawnt wird
     */
    public StatusInfoSpielfeld(int breite, int hoehe, int feldgroesse, String mapString, double powerUpVorkommen) {
        super(breite, hoehe, feldgroesse, 0, 1); //Eine Reihe oben hinzugefügt
        this.powerUpVorkommen = powerUpVorkommen;
        einlesen(mapString);
        addObjectOhneOffset(punkteText, 2, 0);
    }
    
    /**
     * Zeigt ein PowerUp vom gegebenen Typ oben an.
     * @typ Der neue PowerUpTyp, der angezeigt werden soll oder null, wenn kein PowerUp angezeigt werden soll
     */
    public void setPowerUpDisplay(PowerUpTyp typ) {
        if (powerUpDisplay != null) { //Altes entfernen
            removeObject(powerUpDisplay);
        }
        if (typ == null) return;
        powerUpDisplay = new PowerUp(typ);
        addObjectOhneOffset(powerUpDisplay, 4, 0);
    }
    
    public void act() {
        if (isGestoppt()) return;
        super.act();
        
        punkteText.setText(getPunkteAufSpielfeld() + " Punkte");
        if (Zufall.getZufallsBoolean(powerUpVorkommen)) { //Zufälliger Zeitpunkt
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
