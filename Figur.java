import greenfoot.*;

public class Figur extends Actor {
    
    private int richtung = 0; //0 -> rechts, 1 -> unten, 2 -> links, 3 -> oben
    
    public void act() {
        
    }
    
    public void setRichtung(int richtung) {
        this.richtung = richtung;
        setRotation(richtung * 90);
    }
    
    public void bewegen() {
        move(1);
        //todo: nicht gegen Wand laufen
    }
    
}
