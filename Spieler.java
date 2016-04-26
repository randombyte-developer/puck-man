import greenfoot.*;

public class Spieler extends Figur {
    
    private PowerUpTyp gespeicherterPowerUpTyp = null; //Wenn gespeichert, kann mit Leertaste freigegeben werden
    private PowerUpEffekt aktuellerEffekt = null; //Der mit Leertaste freigegebene Effekt
    
    public Spieler() {
        super("spieler.png", 12); //Bild und Geschwindigkeit
    }
    
    public void act() {
        if (getWorld().isGestoppt()) return;
        super.act();
        drehen(); //Drehen hier, damit sofortige Reaktion auf Nutzereingaben und nicht erst jede 10. act-Methode
        gegnerFressen();
        powerUpAufnehmen();
        if (aktuellerEffekt != null) {
            aktuellerEffekt.act();
            if (!aktuellerEffekt.isAktiv()) { //Ausgelaufenen Effekt entfernen
                aktuellerEffekt = null;
            }
        }
        powerUpFreigeben();
    }
    
    public void actBewegen() {
        bewegen();
    }
    
    /**
     * Fragt Tastatur ab und ändert dementsprechend die Richtung des Spielers.
     */
    private void drehen() {
        int neueRichtung = -1;
        if (Greenfoot.isKeyDown("right")) {
            neueRichtung = 0;
        } else if (Greenfoot.isKeyDown("down")) {
            neueRichtung = 1;
        }  else if (Greenfoot.isKeyDown("left")) {
            neueRichtung = 2;
        } else if (Greenfoot.isKeyDown("up")) {
            neueRichtung = 3;
        }
        
        if (neueRichtung == -1) return; //Keine Richtungsänderung
        
        if (isRichtungMoeglich(neueRichtung)) { //Wenn neue Richtung nicht sinnvoll ist und somit der Spieler stehen bleiben würde, nicht drehen
            setRichtung(neueRichtung);
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
        Actor actor = getOneIntersectingObject(PowerUp.class);
        if (actor == null) return; //Kein PowerUp am Platz
        PowerUp powerUp = (PowerUp) actor; //Casten ist sicher, da nur Actor vom Typ PowerUp zurückgegeben werden
        gespeicherterPowerUpTyp = powerUp.getTyp();
        getWorld().setPowerUpDisplay(gespeicherterPowerUpTyp);
        removeTouching(PowerUp.class);
    }
    
    /**
     * Gibt, wenn die Leertase gedrückt wird, das gespeicherte PowerUp frei und führt den Effekt aus.
     */
    private void powerUpFreigeben() {
        if (Greenfoot.isKeyDown("space") && gespeicherterPowerUpTyp != null) {
            if (aktuellerEffekt != null) { //Ein Effekt ist noch aktiv
                aktuellerEffekt.deaktivieren();
            }
            aktuellerEffekt= PowerUpEffekt.vonTypErstellen(gespeicherterPowerUpTyp, this); //Neuer Effekt, der beim nächsten act() aktiviert wird
            gespeicherterPowerUpTyp = null;
            getWorld().setPowerUpDisplay(null);
        }
    }
}
