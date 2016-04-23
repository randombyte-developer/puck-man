import greenfoot.*;

public enum PowerUpTyp   {
    SPEED, RANDOM_TELEPORT;
    
    /**
     * @return Ein zufällig ausgewählter PowerUpTyp
     */
    public static PowerUpTyp getRandomTyp() {
        return values()[Greenfoot.getRandomNumber(values().length)];
    }
}
