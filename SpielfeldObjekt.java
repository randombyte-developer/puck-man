import greenfoot.*;

/**
 * Ein unbewegliches Objekt mit Bild auf einem Spielfeld
 */
public class SpielfeldObjekt extends Actor {
    
    /**
     * @bildPfad Der Pfad zu dem Bild, das dieses Objekt anzeigen soll
     */
    public SpielfeldObjekt(String bildPfad) {
        setImage(bildPfad);
    }
    
    /**
     * Skaliert das Bild dieses SpielfeldObjekts auf die angegebene Größe.
     */
    public void bildSkalieren(int groesse) {
        GreenfootImage bild = getImage();
        bild.scale(groesse, groesse);
        setImage(bild);
    }
}
