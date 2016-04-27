import greenfoot.*;

public class Spieler extends Figur {
    
    private PowerUpTyp gespeicherterPowerUpTyp = null; //Wenn gespeichert, kann mit Leertaste freigegeben werden
    private PowerUpEffekt aktuellerEffekt = null; //Der mit Leertaste freigegebene Effekt
    
    public Spieler() {
        super("spieler.png", 12); //Bild und Geschwindigkeit
    }
    
    public void act() {
        if (!getWorld().isSpielGestartet()) {
            if (getGedrueckteRichtung() != -1) {
                getWorld().spielStarten();
            }
        }
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
     * Fragt Tastatur ab.
     * @return Gedrückte Richtung oder -1, wenn keine Richtung gedrückt ist
     */
    private int getGedrueckteRichtung() {
        int richtung = -1;
        if (Greenfoot.isKeyDown("right")) {
            richtung = 0;
        } else if (Greenfoot.isKeyDown("down")) {
            richtung = 1;
        }  else if (Greenfoot.isKeyDown("left")) {
            richtung = 2;
        } else if (Greenfoot.isKeyDown("up")) {
            richtung = 3;
        }
        
        return richtung;
    }
    
    /**
     *  Ändert die Richtung des Spielers, falls eine Taste gedrückt ist.
     */
    private void drehen() {
        int neueRichtung = getGedrueckteRichtung();
        
        if (neueRichtung == -1) return; //Keine Richtungsänderung
        
        if (!getWorld().isSpielGestartet()) {
            getWorld().spielStarten();
        }
        
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
