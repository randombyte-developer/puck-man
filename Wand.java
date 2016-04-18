import greenfoot.*;

public class Wand extends SpielfeldObjekt {
    
    public Wand() {
        super("brick.jpg");
    }
    
    public void addedToWorld(World welt) {
        bildSkalieren(welt.getCellSize());
    }  
}
