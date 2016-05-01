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
    
    /**
     * @return Pfad zu dem Bild, welches zu dem gegebenem Typ gehört
     */
    private static String getBildPfadFuerTyp(PowerUpTyp typ) {
        switch (typ) {
            case SPEED: return "speed.png";
            case RANDOM_TELEPORT: return "randomTeleport.png";
            case POINTS_BACK: return "pointsBack.png";
            default: return "gold-ball.png";
        }
    }
}
