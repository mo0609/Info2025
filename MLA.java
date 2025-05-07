public class MLA extends SPIEL
{
    FIGUR MD;
    FIGUR[] getreide;
    FIGUR[] mast;
    FIGUR[] vogel;
    int gesammelt;
    RECHTECK[] rahmen;


    MLA(){
        super(900,600);
        setzeRasterSichtbar(true);
        
        rahmen = new RECHTECK[4];
        macheRahmen();
        
        
        MD = new FIGUR("rechts", "pacman.gif");
        MD.fuegeZustandVonGifHinzu("links", "pacmanLinks.gif");
        MD.fuegeZustandVonGifHinzu("oben", "pacmanOben.gif");
        MD.fuegeZustandVonGifHinzu("unten", "pacmanUnten.gif");
        MD.skaliere(0.14);
        MD.macheAktiv();
        
        setzeSchwerkraft(0);

        restart();
        
        tickerNeuStarten(0.05);
        
    }

    public void restart(){
    }

    public void tick(){
        
    }
    

    public void tasteReagieren(int taste){
        if(taste == TASTE.RECHTS){
            MD.setzeGeschwindigkeit(3, 0);
            MD.setzeZustand("rechts");
            korrigierenY();
        }
        if(taste == TASTE.LINKS){
            MD.setzeGeschwindigkeit(-3, 0);
            MD.setzeZustand("links");
            korrigierenY();
        }
        if(taste == TASTE.RAUF){
            MD.setzeGeschwindigkeit(0, 3);
            MD.setzeZustand("oben");
            korrigierenX();
        }
        if(taste == TASTE.RUNTER){
            MD.setzeGeschwindigkeit(0, -3);
            MD.setzeZustand("unten");
            korrigierenX();
        }
     }
    

    
    public void macheRahmen(){
        rahmen[0] = new RECHTECK(30,2,-15,10);
        rahmen[1] = new RECHTECK(30,2,-15,-8);
        rahmen[2] = new RECHTECK(2,20,-15,10);
        rahmen[3] = new RECHTECK(2,20,13,10);
        
        for(int i = 0; i < rahmen.length; i++){
            rahmen[i].machePassiv();
        }
    }

    public void korrigierenX()
    {
        double neuX = Math.round(MD.nenneMittelpunktX()-0.5)+0.5;
        MD.setzeMittelpunkt(neuX, MD.nenneMittelpunktY());
        
    }

    public void korrigierenY()
    {
        double neuY = Math.round(MD.nenneMittelpunktY()-0.5)+0.5;
        MD.setzeMittelpunkt(MD.nenneMittelpunktX(), neuY);
    }
}
