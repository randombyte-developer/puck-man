import greenfoot.*;
import java.awt.Color;

public class LevelAuswahl extends World {
    
    public LevelAuswahl() {
        super(10, 5, 110);
        
        levelAuflisten();
    }
    
    private void levelAuflisten() {
        addObject(new TextButton("1", 70, Color.WHITE, Color.YELLOW, new KlickCallback() {
            public void klick() {
                Greenfoot.setWorld(new Map1());
            }
        }), 0, 0);
    }
}

