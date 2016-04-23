import greenfoot.*;

public class Zufall {
    /**
     * @wahrscheinlichkeit Zwischen 0 und 1, umso größer, desto wahrscheinlicher wird true zurückgegeben
     */
    public static boolean getZufallsBoolean(double wahrscheinlichkeit) {
        return Greenfoot.getRandomNumber(1000) <= wahrscheinlichkeit * 1000;
    }
}
