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
        Position zufaelligesLeeresFeld = Zufall.getZufallsElement(welt.leereFelderSuchen());
        Position ohneOffset = welt.ohneOffset(zufaelligesLeeresFeld);
        getSpieler().setLocation(ohneOffset.getX(), ohneOffset.getY());
    }
}
