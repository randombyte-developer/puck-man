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
        List<Spielfeld> maps = new ArrayList<Spielfeld>();
        maps.add(new Map1());
        maps.add(new Map2());

        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
            
            }
        }

        addObject(new TextButton("1", 70, Color.WHITE, Color.YELLOW, new TextButton.KlickCallback() {
                    public void klick() {
                        Greenfoot.setWorld(new Map1());
                    }
                }), 0, 0);
    }
}

