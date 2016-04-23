import greenfoot.*;
import java.lang.Math;

/**
 * Ein bewegliches Objekt mit Bild auf dem Spielfeld. Es hat eine actBewegen() Methode, welche passend zur Geschwingkeit dieses Objekts aufgerufen wird.
 */
public class Figur extends Actor {
    
    private double prozentZellenGroesse = -1; //-1, wenn Bild nicht skaliert werden soll
    private int geschwindigkeit; //Anzahl act Methoden auf einem Feld, dann erst bewegen; je höher der Wert, desto langsamer die Figur; nur jede n-te act-Methode bewegen; Wert kleiner als 0 -> unbewegliche Figur
    private int actAnzahl = 0; //Anzahl act Methoden schon auf einem Feld verbracht
    private int richtung = 0; //0 -> rechts, 1 -> unten, 2 -> links, 3 -> oben
    
    /**
     * @bildPfad Der Pfad zu dem Bild, das dieses Objekt anzeigen soll
     * @geschwindigkeit Siehe oben
     */
    public Figur(String bildPfad, int geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
        setRichtung(3); //Nach oben gucken
        
        GreenfootImage bild = new GreenfootImage(bildPfad);
        bild.rotate(90);
        setImage(bild);
    }
    
    /**
     * Konstruktor für unbewegliche Objekte.
     * @bildPfad Siehe oben
     */
    public Figur(String bildPfad) {
        this(bildPfad, -1);
    }
    
    /**
     * Konstruktor für unbewegliche Objekte.
     * @bildPfad Siehe oben
     * @prozentZellenGroesse 
     */
    public Figur(String bildPfad, double prozentZellenGroesse) {
        this(bildPfad, -1);
        this.prozentZellenGroesse = prozentZellenGroesse;
    }
    
    /**
     * Skaliert das Bild der Figur automatisch, wenn sie zu einer Welt hinzugefügt wird.
     */
    public void addedToWorld(World welt) {
        if (prozentZellenGroesse  < 0) return;
        bildSkalieren((int) (welt.getCellSize() * prozentZellenGroesse));
    }
    
    /**
     * Zählt die 'actAnzahl' hoch. Ruft 'actBewegen()' der Geschwindigkeit entsprechend auf.
     */
    public void act() {
        if (geschwindigkeit < 0) return;
        if (++actAnzahl >= geschwindigkeit) {
            actBewegen(); //Genug act-Methoden gewartet -> einmal bewegen
            actAnzahl = 0;
        }
    }
    
    /**
     * Wird nur einmal in 'geschwindigkeit'-act-Methoden aufgerufen. Die anderen acts dazwischen werden übersprungen.
     */
    public void actBewegen() {}
    
    /**
     * Skaliert das Bild dieses SpielfeldObjekts auf die angegebene Größe.
     */
    public void bildSkalieren(int groesse) {
        GreenfootImage bild = getImage();
        bild.scale(groesse, groesse);
        setImage(bild);
    }
    
    /**
     * Um Methoden des Spielfeldes einfach benutzen zu können.
     */
    public Spielfeld getWorld() {
        return getWorldOfType(Spielfeld.class);
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
     * @return Die aktuelle Geschwindigkeit
     */
    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }
    
    /**
     * @geschwindigkeit Geschwindigkeit, die die Figur haben soll
     *  Anzahl der act-Methoden, die gewartet wird, bis sich die Figur bewegt, kleiner als 0, wenn sich die Figur nicht bewegt
     */
    public void setGeschwindigkeit(int geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }
    
    /**
     * Bewegt die Figur ein Feld nach vorne, wenn keine Wand im Weg ist und das nächste Feld innerhalb des Spielfeldes ist.
     */
    protected void bewegen() {
        if (isRichtungMoeglich(richtung)) {
            int[] pos = getNaechstePosition(richtung);
            setLocation(pos[0], pos[1]);
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
