import greenfoot.*;

public class Spieler extends Figur {
    
    public Spieler() {
        super("spieler.png", 10); //Bild und Geschwindigkeit
    }
    
    public void act() {
        super.act();
        drehen(); //Drehen hier, damit sofortige Reaktion auf Nutzereingaben und nicht erst jede 10. act-Methode
        gegnerFressen();
        powerUpAufnehmen();
    }
    
    public void actBewegen() {
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
    
    /**
     * Entfernt alle Gegener auf dem Feld des Spielers.
     */
    private void gegnerFressen() {
        removeTouching(Gegner.class);
    }
    
    /**
     * Nimmt alle PowerUps auf dem Feld des Spielers auf.
     */
    private void powerUpAufnehmen() {
        removeTouching(PowerUp.class);
    }
}
