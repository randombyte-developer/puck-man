import greenfoot.*;
import java.util.List;

public class Gegner extends Figur {
    
    public Gegner() {
        setImage("bluej-icon.png");
        GreenfootImage image = getImage();
        image.scale(30, 30);
        setImage(image);
    }
    
    public void act() {
        punktEinsammeln();
    }
    
    private void punktEinsammeln() {
        List<Punkt> punkte = getWorld().getObjectsAt(getX(), getY(), Punkt.class);
        getWorld().removeObjects(punkte);
    }
}
