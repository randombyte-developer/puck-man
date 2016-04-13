import greenfoot.*;

public abstract class Figur extends Actor {
    
    private int geschwindigkeit; //Anzahl act Methoden auf einem Feld, dann erst bewegen; je höher der Wert, desto langsamer die Figur
    private int actAnzahl = 0; //Anzahl act Methoden schon auf einem Feld verbracht
    private int richtung = 0; //0 -> rechts, 1 -> unten, 2 -> links, 3 -> oben
    
    public Figur(int geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }
    
    /**
     * Zählt die 'actAnzahl' hoch. Ruft 'actBewegen()' der Geschwindigkeit entsprechend auf.
     */
    public void act() {
        if (++actAnzahl >= geschwindigkeit) {
            actBewegen();
            actAnzahl = 0;
        }
    }
    
    public abstract void actBewegen();
    
    /**
     * Dreht die Figur.
     * @richtung 0 -> rechts, 1 -> unten, 2 -> links, 3 -> oben
     */
    public void setRichtung(int richtung) {
        this.richtung = richtung;
        setRotation(richtung * 90);
    }
    
    /**
     * Gibt die aktuelle Richtung zurück.
     * @return Die aktuelle Richtung: 0 -> rechts, 1 -> unten, 2 -> links, 3 -> oben
     */
    public int getRichtung() {
        return richtung;
    }
    
    /**
     * Gibt die gegenüberliegende Richtung zurück. Z.B. Aktuelle Richtung ist rechts, Gegenrichtung ist links.
     * @return Die Gegenrichtung: 0 -> rechts, 1 -> unten, 2 -> links, 3 -> oben
     */
    public int getGegenRichtung() {
        int gegenRichtung = richtung + 2;
        switch (gegenRichtung) {
            case 4:
                gegenRichtung = 0;
                break;
            case 5:
                gegenRichtung = 1;
                break;    
        }
        
        return gegenRichtung;
    }
    
    public Spielfeld getWorld() {
        return (Spielfeld) super.getWorld();
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
     * Gibt die Koordinaten zurück, wenn die Figur in die gegebene Richtung von der aktuellen Position aus ein Feld weitergeht. Ob die Position möglich ist,
     * wird nicht beachtet(z.B. außerhalb der Welt oder Wand im Weg).
     * @richtung 0 -> rechts, 1 -> unten, 2 -> links, 3 -> oben
     */
    public int[] getNaechstePosition(int richtung) {
        int x = getX();
        int y = getY();
        switch (richtung) {
            case 0:
                x++;
                break;
            case 1:
                y++;
                break;
            case 2:
                x--;
                break;
            case 3:
                y--;
                break;
        }
        
        return new int[] {x, y};
    }
    
    /**
     * Prüft, ob Wand in Bewegungs-Richtung der Figur ist.
     */
    private boolean isWandVorne() {
        int[] naechstePosition = getNaechstePosition(richtung);
        int x = naechstePosition[0];
        int y = naechstePosition[1]; 
        
        boolean wandInRichtung = getWorld().getObjectsAt(x, y, Wand.class).size() > 0;
        return wandInRichtung;
    }
}
