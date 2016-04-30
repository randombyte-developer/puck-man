import greenfoot.*;
import java.awt.Color;

/**
 * Der Start-Bildschirm des Spiels.
 */
public class Start extends World {
    
    public Start() {
        super(5, 3, 130);
        Spielfeld.setHintergrundFarbe(this, Color.LIGHT_GRAY);
        
        addObject(new Text("PuckMan", 90, Color.GREEN, Color.LIGHT_GRAY), 2, 0);
        
        addObject(new TextButton("Start", 70, Color.LIGHT_GRAY, Color.YELLOW, new TextButton.KlickCallback() {
            public void klick() {
                Greenfoot.setWorld(new LevelAuswahl());
            }
        }), 2, 1);
        
        addObject(new Text("von Sven Rahn und Kasper Jarocki", 18, Color.BLACK, Color.LIGHT_GRAY), 2, 2);
    }
}
