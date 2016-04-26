import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

public class LevelAuswahl extends World {

    public LevelAuswahl() {
        super(10, 5, 110);

        GreenfootImage hintergrund = new GreenfootImage(1, 1); //Nur ein Pixel groß, weil Greenfoot den gegebenen Hintergrund so oft wiederholt, bis alles ausgefüllt ist
        hintergrund.setColor(Color.LIGHT_GRAY);
        hintergrund.fill();
        setBackground(hintergrund);
        
        levelAuflisten();
    }

    private void levelAuflisten() {
        List<Spielfeld> spielfelder = new ArrayList<Spielfeld>();
        spielfelder.add(new Map1());
        spielfelder.add(new Map2());
        spielfelder.add(new Map3());
        spielfelder.add(new Map4());
        spielfelder.add(new Map5());

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                int nummer = x + y;
                if (spielfelder.size() - 1 < nummer) { //Keine weiteren Spielfelder mehr zum auflisten da
                    return;
                }
                addObject(new TextButton(String.valueOf(nummer + 1), 70, Color.LIGHT_GRAY, Color.YELLOW, new TextButton.KlickCallback() {
                    public void klick() {
                        Greenfoot.setWorld(spielfelder.get(nummer));
                    }
                }), x, y);
            }
        }
    }
}

