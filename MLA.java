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
        
        getreide = new FIGUR[30];
        for(int i = 0; i < getreide.length; i++){
            getreide[i] = new FIGUR("normal", "heu-ballen-test-bg-2.png", 1, 1);
            getreide[i].machePassiv();
            getreide[i].skaliere(0.25);
            getreide[i].setzeMittelpunkt(zufallszahlVonBis(-13, 13), zufallszahlVonBis(-8, 8));
            
        }
        
        tickerNeuStarten(0.05);
        
    }

    public void restart(){
    }

    public void tick(){
                for(int i = 0; i < getreide.length; i++){
            if(MD.beruehrt(getreide[i])){
                gesammelt = gesammelt + 1;
                getreide[i].entfernen();
            
            }
            
            for(int j = 0; j < getreide.length; j++){
                if(getreide[i].beruehrt(getreide[j])){
                    getreide[i].setzeMittelpunkt(zufallszahlVonBis(-13, 13), zufallszahlVonBis(-8, 8));
                }
            }
        }
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
        rahmen[0] = new RECHTECK(30,1,-15,10);
        rahmen[1] = new RECHTECK(30,1,-15,-9);
        rahmen[2] = new RECHTECK(1,20,-15,10);
        rahmen[3] = new RECHTECK(1,20,14,10);
        
        rahmen[0].setzeFarbe("dunkelgrün");
        rahmen[1].setzeFarbe("dunkelgrün");
        rahmen[2].setzeFarbe("dunkelgrün");
        rahmen[3].setzeFarbe("dunkelgrün");
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
