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
        
        addObject(new TextButton("Start", 70, Color.WHITE, Color.YELLOW, new TextButton.KlickCallback() {
            public void klick() {
                Greenfoot.setWorld(new LevelAuswahl());
            }
        }), 2, 1);
    }
}
