import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

public class Gegner extends Figur {
    
    public Gegner() {
        super("gegner.png", 20); //Bild und Geschwindigkeit
    }
    
    public void actBewegen() {
        drehenFallsKreuzung();
        bewegen();
        punktEinsammeln();
    }
    
    private void drehenFallsKreuzung() {
        Integer[] moeglicheRichtungen = getMoeglicheRichtungen();
        int zufallszahl = Greenfoot.getRandomNumber(moeglicheRichtungen.length);
        int zufallsrichtung = moeglicheRichtungen[zufallszahl];
        setRichtung(zufallsrichtung);
    }
    
    private Integer[] getMoeglicheRichtungen() {
        List<Integer> moeglicheRichtungen = new ArrayList(3); //Höchstens 3 mögliche Richtungen
        int gegenrichtung = getGegenRichtung();
        for (int richtung = 0; richtung < 4; richtung++) {
            if (richtung == gegenrichtung) {
                continue; //Nicht rückwärts gegen
            }
            int[] naechstePosition = getNaechstePosition(richtung);
            int x = naechstePosition[0];
            int y = naechstePosition[1];
            
            boolean keineWand = getWorld().getObjectsAt(x, y, Wand.class).size() == 0;
            boolean imSpielfeld = getWorld().isPositionInSpielfeld(x, y);
            if (keineWand && imSpielfeld) { //Richtung möglich
                moeglicheRichtungen.add(richtung);
            }
        }
        
        return moeglicheRichtungen.toArray(new Integer[moeglicheRichtungen.size()]);
    }
    
    /**
     * Sammelt alle Punkte am Platz ein.
     */
    private void punktEinsammeln() {
        List<Punkt> punkte = getWorld().getObjectsAt(getX(), getY(), Punkt.class);
        getWorld().removeObjects(punkte);
    }
}
