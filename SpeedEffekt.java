import greenfoot.*;

/**
 * Beschleunigt den Spieler für eine kurze Zeit um den Faktor BOOST_FAKTOR.
 */
public class SpeedEffekt extends PowerUpEffekt {
    
    private static final double BOOST_FAKTOR = 0.6;
    
    private int alteGeschwindigkeit = -1;
    
    public SpeedEffekt(Spieler spieler) {
        super(220, spieler);
    }
    
    public void aktiviert() {
        alteGeschwindigkeit = getSpieler().getGeschwindigkeit();
        getSpieler().setGeschwindigkeit((int) (alteGeschwindigkeit * BOOST_FAKTOR));
    }
    
    public void deaktiviert() {
        getSpieler().setGeschwindigkeit(alteGeschwindigkeit);
    }
}
