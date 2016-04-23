import greenfoot.*;

/**
 * Teleportiert den Spieler auf ein zufälliges freies Feld.
 */
public class ZufallsTeleport extends PowerUpEffekt {
    
    public ZufallsTeleport(Spieler spieler) {
        super(1, spieler);
    }
    
    public void aktiviert() {
        OffsetSpielfeld welt = getSpieler().getWorld();
        Position zufaelligesNichtWandFeld = Zufall.getZufallsElement(welt.felderSuchen(Wand.class, true));
        Position ohneOffset = welt.ohneOffset(zufaelligesNichtWandFeld);
        getSpieler().setLocation(ohneOffset.getX(), ohneOffset.getY());
    }
}
