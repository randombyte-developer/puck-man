import greenfoot.*;

public class PowerUpEffekt {
    
    private final int dauer;
    private int vergangeneDauer = 0;
    private Spieler spieler;
    private boolean aktiv = true;
    
    /**
     * Gibt einen neuen Effekt für den PowerUpTyp zurück.
     */
    public static PowerUpEffekt vonTypErstellen(PowerUpTyp typ, Spieler spieler) {
        switch (typ) {
            case SPEED:
                return new SpeedEffekt(spieler);
            default:
                System.out.println("PowerUp hat keinen Effekt: " + typ);
                return null;
        }
    }
    
    /**
     * @dauer Die Dauer des Effekts als Anzahl von act-Methoden
     * @spieler Spieler, als Zugriff auf Eigenschaften und Methoden des Spielers und der World
     */
    protected PowerUpEffekt(int dauer, Spieler spieler) {
        this.dauer = dauer;
        this.spieler = spieler;
    }
    
    /**
     * Deaktiviert den Effekt manuell vorzeitig.
     */
    public void deaktivieren() {
        aktiv = false;
        deaktiviert();
    }
    
    /**
     * @return Der gespeicherte Spieler von der Erstellung des Effektes
     */
    public Spieler getSpieler() {
        return spieler;
    }
    
    /**
     * Muss bei jedem act aufgerufen werden.
     */
    public void act() {
        if (aktiv && vergangeneDauer == 0) {
            aktiviert();
        }
        if (aktiv && ++vergangeneDauer >= dauer) {
            aktiv = false;
            deaktiviert();
        }
    }
    
    /**
     * Wird einmal aufgerufen, wenn das PowerUp aktiviert wird.
     */
    public void aktiviert() {}
    
    
    /**
     * Wird einmal aufgerufen, wenn das PowerUp deaktiviert wird.
     */
    public void deaktiviert() {}
    
    public boolean isAktiv() {
        return aktiv;
    }
}
