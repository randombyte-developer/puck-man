import greenfoot.*;

public class Punkt extends SpielfeldObjekt {
    
    public Punkt() {
        super("punkt.png", false);
    }
    
    public void addedToWorld(World welt) {
        bildSkalieren((int) (getWorld().getFeldgroesse() * 0.7)); //70% der Feldgröße
    }
}
