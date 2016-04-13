import greenfoot.*;

public class Spieler extends Figur {
    
    public Spieler() {
        super(10);
        
        setImage("ppl2.png");
        GreenfootImage image = getImage();
        image.scale(30, 30);
        setImage(image);
    }
    
    public void actBewegen() {
        drehen();
        bewegen();
    }
    
    /**
     * Fragt Tastatur ab und ändert dementsprechend die Richtung des Spielers.
     */
    private void drehen() {
        if (Greenfoot.isKeyDown("right")) {
            setRichtung(0);
        } else if (Greenfoot.isKeyDown("down")) {
            setRichtung(1);
        }  else if (Greenfoot.isKeyDown("left")) {
            setRichtung(2);
        } else if (Greenfoot.isKeyDown("up")) {
            setRichtung(3);
        }
    }
    

}
