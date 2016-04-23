import greenfoot.*;
import java.awt.Color;

/**
 * Der Start-Bildschirm des Spiels.
 */
public class Start extends World {
    
    public Start() {
        super(5, 3, 130);
        
        GreenfootImage hintergrund = new GreenfootImage(1, 1); //Nur ein Pixel groß, weil Greenfoot den gegebenen Hintergrund so oft wiederholt, bis alles ausgefüllt ist
        hintergrund.setColor(Color.LIGHT_GRAY);
        hintergrund.fill();
        setBackground(hintergrund);
        
        addObject(new Text("PuckMan", 90, Color.GREEN, Color.LIGHT_GRAY), 2, 0);
        
        addObject(new TextButton("Start", 70, Color.LIGHT_GRAY, Color.YELLOW, new TextButton.KlickCallback() {
            public void klick() {
                Greenfoot.setWorld(new LevelAuswahl());
            }
        }), 2, 1);
        
        addObject(new Text("von Sven Rahn und Kasper Jarocki", 18, Color.BLACK, Color.LIGHT_GRAY), 2, 2);
    }
}
