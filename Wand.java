import greenfoot.*;

public class Wand extends SpielfeldObjekt {
    
    public Wand() {
        super("brick.jpg", false);
    }
    
    public void addedToWorld(World welt) {
        bildSkalieren(getWorld().getFeldgroesse());
    }  
}
