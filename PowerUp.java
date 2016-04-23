import greenfoot.*;

public class PowerUp extends Figur {
    
    private PowerUpTyp typ;
    
    public PowerUp(PowerUpTyp typ) {
        super(getBildPfadFuerTyp(typ), 1.0);
        this.typ = typ;
    }
    
    /**
     * @return Der PowerUpTyp des PowerUps
     */
    public PowerUpTyp getTyp() {
        return typ;
    }
    
    private static String getBildPfadFuerTyp(PowerUpTyp typ) {
        switch (typ) {
            case SPEED: return "bluej-icon.png";
            case RANDOM_TELEPORT: return "gold-ball.png";
            case POINTS_BACK: return "ppl2.png";
            default: return "gold-ball.png";
        }
    }
}
