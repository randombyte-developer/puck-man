import greenfoot.*;
import java.util.List;

/**
 * Spawnt auf zufälligen freien Feldern Münzen.
 */
public class PointsBack extends PowerUpEffekt {
    
    private static final int MAX_POINTS_BACK = 20;
    
    public PointsBack(Spieler spieler) {
        super(1, spieler);
    }
    
    public void aktiviert() {
        OffsetSpielfeld welt = getSpieler().getWorld();
        List<Position> leereFelder = welt.leereFelderSuchen();
        for (int i = 0; i < MAX_POINTS_BACK; i++) {
            if (leereFelder.size() == 0) return; //Keine freien Felder (mehr)
            Position zufaelligesLeeresFeld = Zufall.getZufallsElement(leereFelder);
            welt.addObject(new Punkt(), zufaelligesLeeresFeld.getX(), zufaelligesLeeresFeld.getY());
            leereFelder.remove(zufaelligesLeeresFeld);
        }
    }
}
