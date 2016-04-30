import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Spielfeld mit einer Reihe oben am Spielfeldrand für Statusinformationen(z.B. aktuelles PowerUp). Spawnt PowerUps.
 */
public class StatusInfoSpielfeld extends OffsetSpielfeld {
    
    private static final int POWER_UP_DISPLAY_X = 5;
    private static final int PUNKTE_DISPLAY_X = 2;
    
    private double powerUpVorkommen;
    
    private Text punkteText = new Text("", 30, Color.BLACK, Color.LIGHT_GRAY);
    private PowerUp powerUpDisplay = null;
    
    /**
     * @powerUpVorkommen Zwischen 0 und 1, wie wahrscheinlich es ist, dass in einer act-Methode ein PowerUp gespawnt wird
     */
    public StatusInfoSpielfeld(int breite, int hoehe, int feldgroesse, String mapString, double powerUpVorkommen) {
        super(breite, hoehe, feldgroesse, 0, 1); //Eine Reihe oben hinzugefügt
        this.powerUpVorkommen = powerUpVorkommen;
        Spielfeld.setHintergrundFarbe(this, Color.LIGHT_GRAY);
        einlesen(mapString);
        addObjectOhneOffset(punkteText, PUNKTE_DISPLAY_X, 0);
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
        addObjectOhneOffset(powerUpDisplay, POWER_UP_DISPLAY_X, 0);
    }
    
    public void act() {
        if (isGestoppt()) return;
        super.act();
        
        punkteText.setText(getPunkteAufSpielfeld() + " Punkte");
        if (Zufall.getZufallsBoolean(powerUpVorkommen)) { //Zufälliger Zeitpunkt
            List<Position> leereFelder = leereFelderSuchen();
            if (leereFelder.size() > 0) {
                Position leeresFeld = Zufall.getZufallsElement(leereFelder);
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
}
