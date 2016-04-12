import greenfoot.*;

public class Figur extends Actor {
    
    private int richtung = 0; //0 -> rechts, 1 -> unten, 2 -> links, 3 -> oben
    
    public void act() {
        
    }
    
    /**
     * Dreht die Figur.
     * @richtung 0 -> rechts, 1 -> unten, 2 -> links, 3 -> oben
     */
    public void setRichtung(int richtung) {
        this.richtung = richtung;
        setRotation(richtung * 90);
    }
    
    /**
     * Bewegt die Figur ein Feld nach vorne, wenn keine Wand im Weg ist.
     */
    protected void bewegen() {
        if (!isWandVorne()) {
            move(1);
        }
    }
    
    /**
     * Prüft, ob Wand in Bewegungs-Richtung der Figur ist.
     */
    private boolean isWandVorne() {
        int x = getX();
        int y = getY();
        
        if (richtung == 0) {
            x++;
        } else if (richtung == 1) {
            y++;
        } else if (richtung == 2) {
            x--;
        } else if (richtung == 3) {
            y--;
        }
        
        boolean wandInRichtung = getWorld().getObjectsAt(x, y, Wand.class).size() > 0;
        return wandInRichtung;
    }
}
