import greenfoot.*;
import java.util.List;

public class Zufall {
    /**
     * @wahrscheinlichkeit Zwischen 0 und 1, umso größer, desto wahrscheinlicher wird true zurückgegeben
     */
    public static boolean getZufallsBoolean(double wahrscheinlichkeit) {
        return Greenfoot.getRandomNumber(1000) <= wahrscheinlichkeit * 1000;
    }
    
    /**
     * @return Ein zufälliges Element der gegebenen Liste
     */
    public static <T> T getZufallsElement(List<T> liste) {
        if (liste.size() == 0) {
            System.out.println("Liste hat keine Elemente!");
        }
        return liste.get(Greenfoot.getRandomNumber(liste.size()));
    }
}
