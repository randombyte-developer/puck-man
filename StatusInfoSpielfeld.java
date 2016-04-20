import greenfoot.*;

/**
 * Zeigt am oberen Spielfeldrand eine Reihe für Statusinformationen(z.B. aktuelles PowerUp) an.
 */
public class StatusInfoSpielfeld extends OffsetSpielfeld {
    
    public StatusInfoSpielfeld(int breite, int hoehe, int feldgroesse, String mapString) {
        super(breite, hoehe, feldgroesse, mapString, 1, 0); //Eine Reihe oben hinzugefügt
    }
}
