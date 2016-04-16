import greenfoot.*;

public class Punkt extends SpielfeldObjekt {
    
    public Punkt() {
        super("punkt.png");
    }
    
    public void addedToWorld(World welt) {
        bildSkalieren((int) (welt.getCellSize() * 0.7)); //70% der Feldgröße
    }
}
