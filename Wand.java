import greenfoot.*;

public class Wand extends Figur {
    
    public Wand() {
        super("brick.jpg", -1);
    }
    
    public void addedToWorld(World welt) {
        bildSkalieren(getWorld().getCellSize());
    }  
}
