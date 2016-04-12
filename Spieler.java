import greenfoot.*;

public class Spieler extends Figur {
    
    private int geschwindigkeit = 0; //Anzahl act Methoden auf einem Feld
    
    public Spieler() {
        setImage("ppl2.png");
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("right")) {
            setRichtung(0);
        } else if (Greenfoot.isKeyDown("down")) {
            setRichtung(1);
        }  else if (Greenfoot.isKeyDown("left")) {
            setRichtung(2);
        } else if (Greenfoot.isKeyDown("up")) {
            setRichtung(3);
        }
        
        bewegen();
    }
}
