import greenfoot.*;

public abstract class Figur extends Actor {
    
    private int geschwindigkeit; //Anzahl act Methoden auf einem Feld, dann erst bewegen; je höher der Wert, desto langsamer die Figur
    private int actAnzahl = 0; //Anzahl act Methoden schon auf einem Feld verbracht
    private int richtung = 0; //0 -> rechts, 1 -> unten, 2 -> links, 3 -> oben
    
    public Figur(String bild, int geschwindigkeit) {
        setBild(bild);
        this.geschwindigkeit = geschwindigkeit;
    }
    
    /**
     * Zählt die 'actAnzahl' hoch. Ruft 'actBewegen()' der Geschwindigkeit entsprechend auf.
     */
    public void act() {
        if (++actAnzahl >= geschwindigkeit) {
            actBewegen(); //Genug act-Methoden gewartet -> einmal bewegen
            actAnzahl = 0;
        }
    }
    
    public abstract void actBewegen();
    
    /**
     * Lädt das Bild vom angegebenen Pfad, skaliert es auf Feldgröße und setzt es für diese Figur.
     */
    public void setBild(String bildPfad) {
        GreenfootImage bild = new GreenfootImage(bildPfad);
        bild.scale(30, 30);
        setImage(bild);
    }
    
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
        return (richtung + 2) % 4; //Addiert 2 für gegenüberliegende Richtung; modulo 4, um Richtung 4 und 5 zu 0 und 1 zu machen
    }
    
    /**
     * Um Methoden des Spielfeldes einfach benutzen zu können.
     */
    public Spielfeld getWorld() {
        return getWorldOfType(Spielfeld.class);
    }
    
    /**
     * Bewegt die Figur ein Feld nach vorne, wenn keine Wand im Weg ist und das nächste Feld innerhalb des Spielfeldes ist.
     */
    protected void bewegen() {
        if (isRichtungMoeglich(richtung)) {
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
     * Prüft, ob die Figur das Feld in Richtung richtung betreten kann(keine Wand und im Spielfeld).
     */
    public boolean isRichtungMoeglich(int richtung) {
        int[] naechstePosition = getNaechstePosition(richtung);
        int x = naechstePosition[0];
        int y = naechstePosition[1];
        
        boolean keineWand = getWorld().getObjectsAt(x, y, Wand.class).size() == 0;
        boolean imSpielfeld = getWorld().isPositionInSpielfeld(x, y);
        return keineWand && imSpielfeld;
    }
}
