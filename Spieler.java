import greenfoot.*;

public class Spieler extends Figur {
    
    private int geschwindigkeit = 10; //Anzahl act Methoden auf einem Feld, dann erst bewegen
    private int actAnzahl = 0; //Anzahl schon vergangener act Methoden auf einem Feld
    
    public Spieler() {
        setImage("ppl2.png");
        GreenfootImage image = getImage();
        image.scale(30, 30);
        setImage(image);
    }
    
    public void act() {
        richtungAendern();
        actBewegen();
    }
    
    /**
     * Fragt Tastatur ab und ändert dementsprechend die Richtung des Spielers.
     */
    private void richtungAendern() {
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
    
    /**
     * Wird jedes mal in der act()-Methode aufgerufen. Zählt die 'actAnzahl' hoch. Bewegt den Spieler einstprechend der Geschwindigkeit.
     */
    private void actBewegen() {
        if (++actAnzahl >= geschwindigkeit) {
            bewegen();
            actAnzahl = 0;
        }
    }
}
