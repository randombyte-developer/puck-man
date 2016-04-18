import greenfoot.*;

/**
 * Ein unbewegliches Objekt mit Bild auf einem Spielfeld.
 */
public class SpielfeldObjekt extends Actor {
    
    private int x = 0;
    private int y = 0;
    
    /**
     * @bildPfad Der Pfad zu dem Bild, das dieses Objekt anzeigen soll
     * @kopfInRichtung True, wenn das Bild dieses Objekts in Bewegungsrichtung zeigen soll
     */
    public SpielfeldObjekt(String bildPfad, boolean kopfInRichtung) {
        setImage(bildPfad);
        if (kopfInRichtung) {
            GreenfootImage bild = getImage();
            bild.rotate(90);
            setImage(bild);
        }
    }
    
    public int getX() {
        return x;
    }
    
    public int getRealX() {
        return super.getX();
    }
    
    public void setX(int x) {
        this.x = x;
        int realX = x * getWorld().getFeldgroesse() + getWorld().getFeldgroesse() / 2;
        setLocation(realX, getRealY());
    }
    
    public int getY() {
        return y;
    }
    
    public int getRealY() {
        return super.getY();
    }
    
    public void setY(int y) {
        this.y = y;
        int realY = y * getWorld().getFeldgroesse() + getWorld().getFeldgroesse() / 2;
        setLocation(getRealX(), realY);
    }
    
    public void setPos(int x, int y) {
        setX(x);
        setY(y);
    }
    
    /**
     * Skaliert das Bild dieses SpielfeldObjekts auf die angegebene Größe.
     */
    public void bildSkalieren(int groesse) {
        GreenfootImage bild = getImage();
        bild.scale(groesse, groesse);
        setImage(bild);
    }
    
    /**
     * Um Methoden des Spielfeldes einfach benutzen zu können.
     */
    public Spielfeld getWorld() {
        return getWorldOfType(Spielfeld.class);
    }
}
