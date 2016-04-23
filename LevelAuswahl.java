import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

public class LevelAuswahl extends World {

    public LevelAuswahl() {
        super(10, 5, 110);

        levelAuflisten();
    }

    private void levelAuflisten() {
        List<Spielfeld> spielfelder = new ArrayList<Spielfeld>();
        spielfelder.add(new Map1());
        spielfelder.add(new Map2());

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                int nummer = x + y;
                if (spielfelder.size() - 1 < nummer) { //Keine weiteren Spielfelder mehr zum auflisten da
                    return;
                }
                addObject(new TextButton(String.valueOf(nummer + 1), 70, Color.WHITE, Color.YELLOW, new TextButton.KlickCallback() {
                    public void klick() {
                        Greenfoot.setWorld(spielfelder.get(nummer));
                    }
                }), x, y);
            }
        }
    }
}

