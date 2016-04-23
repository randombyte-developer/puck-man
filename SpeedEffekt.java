import greenfoot.*;

public class SpeedEffekt extends PowerUpEffekt {
    
    private static final double BOOST_FAKTOR = 0.6;
    
    private int alteGeschwindigkeit = -1;
    
    public SpeedEffekt(Spieler spieler) {
        super(180, spieler);
    }
    
    public void aktiviert() {
        alteGeschwindigkeit = getSpieler().getGeschwindigkeit();
        getSpieler().setGeschwindigkeit((int) (alteGeschwindigkeit * BOOST_FAKTOR));
    }
    
    public void deaktiviert() {
        getSpieler().setGeschwindigkeit(alteGeschwindigkeit);
    }
}
