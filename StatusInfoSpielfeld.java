import greenfoot.*;
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
     * Punkte aktualisieren.
     */
    public void act() {
        super.act();
        punkteText.setText(getPunkteAufSpielfeld() + " Punkte");
    }
    
    /**
     * @return Die Anzahl der noch auf dem Spielfeld vorhandenen Punkte
     */
    private int getPunkteAufSpielfeld() {
        return getObjects(Punkt.class).size();
    }
}
