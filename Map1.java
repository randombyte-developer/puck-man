import greenfoot.*;

public class Map1 extends Spielfeld {

    public Map1() {
        super(30, 20, 30);

        prepare();
        punkteVerteilen();
    }

    /**
     * Bereite die Welt für den Programmstart vor.
     * Das heißt: Erzeuge die Anfangs-Objekte und füge sie der Welt hinzu.
     */
    private void prepare()
    {
        Wand wand = new Wand();
        addObject(wand,5,1);
        Wand wand2 = new Wand();
        addObject(wand2,5,2);
        Wand wand3 = new Wand();
        addObject(wand3,5,2);
        Wand wand4 = new Wand();
        addObject(wand4,5,3);
        Wand wand5 = new Wand();
        addObject(wand5,5,5);
        Wand wand6 = new Wand();
        addObject(wand6,5,6);
        Wand wand7 = new Wand();
        addObject(wand7,5,7);
        Wand wand8 = new Wand();
        addObject(wand8,5,9);
        Wand wand9 = new Wand();
        addObject(wand9,5,10);
        Wand wand10 = new Wand();
        addObject(wand10,4,11);
        Wand wand11 = new Wand();
        addObject(wand11,5,13);
        Wand wand12 = new Wand();
        addObject(wand12,5,14);
        Wand wand13 = new Wand();
        addObject(wand13,5,16);
        Wand wand14 = new Wand();
        addObject(wand14,5,17);
        Wand wand15 = new Wand();
        addObject(wand15,5,18);
        Wand wand16 = new Wand();
        addObject(wand16,5,15);
        Wand wand17 = new Wand();
        addObject(wand17,5,15);
        Wand wand18 = new Wand();
        addObject(wand18,5,11);
        Wand wand19 = new Wand();
        addObject(wand19,5,11);
        Wand wand20 = new Wand();
        addObject(wand20,5,10);
        Wand wand21 = new Wand();
        addObject(wand21,5,11);
        Wand wand22 = new Wand();
        addObject(wand22,5,8);
        Wand wand23 = new Wand();
        addObject(wand23,5,12);
        Wand wand24 = new Wand();
        addObject(wand24,5,4);
        Wand wand25 = new Wand();
        addObject(wand25,4,7);
        Wand wand26 = new Wand();
        addObject(wand26,4,7);
        Wand wand27 = new Wand();
        addObject(wand27,3,7);
        Wand wand28 = new Wand();
        addObject(wand28,3,3);
        Wand wand29 = new Wand();
        addObject(wand29,3,4);
        Wand wand30 = new Wand();
        addObject(wand30,3,4);
        Wand wand31 = new Wand();
        addObject(wand31,3,13);
        Wand wand32 = new Wand();
        addObject(wand32,2,14);
        Wand wand33 = new Wand();
        addObject(wand33,3,15);
        Wand wand34 = new Wand();
        addObject(wand34,3,15);
        Wand wand35 = new Wand();
        addObject(wand35,3,16);
        Wand wand36 = new Wand();
        addObject(wand36,2,16);
        Wand wand37 = new Wand();
        addObject(wand37,3,9);
        Wand wand38 = new Wand();
        addObject(wand38,2,9);
        Wand wand39 = new Wand();
        addObject(wand39,1,9);
        Wand wand40 = new Wand();
        addObject(wand40,2,3);
        Wand wand41 = new Wand();
        addObject(wand41,2,3);
        Wand wand42 = new Wand();
        addObject(wand42,2,1);
        addObject(new Spieler(),1,1);
    }
}
