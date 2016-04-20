import greenfoot.*;

public class PowerUp extends Figur {
    
    private PowerUpTyp typ;
    
    public PowerUp(PowerUpTyp typ) {
        super(getBildPfadFuerTyp(typ), 1.0);
        this.typ = typ;
    }
    
    private static String getBildPfadFuerTyp(PowerUpTyp typ) {
        switch (typ) {
            case SPEED: return "bluej-icon.png";
            default: return "gold-ball.png";
        }
    }
}
