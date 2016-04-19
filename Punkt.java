import greenfoot.*;

public class Punkt extends Figur {
    
    public Punkt() {
        super("punkt.png");
    }
    
    public void addedToWorld(World welt) {
        bildSkalieren((int) (getWorld().getFeldgroesse() * 0.7)); //70% der Feldgröße
    }
}
