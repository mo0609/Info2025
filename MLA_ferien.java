public class MLA extends SPIEL
{
    FIGUR MD;
    FIGUR back;
    FIGUR over;
    FIGUR[] getreide;
    double[] zeitget;
    FIGUR[] getreide2;
    FIGUR[] mast;
    FIGUR[] mast2;
    FIGUR[] vogel;
    TEXT anzeige;
    TEXT manzeige;
    FIGUR aicon;
    FIGUR micon;
    int gesammelt;
    int mastkollanz = 3;
    double zeit;
    RECHTECK[] rahmen;
    int xyz;
    int anzahl;

    MLA(){
        super(900,600);
        setzeRasterSichtbar(true);
        

        //back = new FIGUR("a", "back-min.png", 1, 1);
        //back.skaliere(0.1);
        //back.setzeMittelpunkt(0, 0);

        over = new FIGUR("a", "over-3.png", 1, 1);
        over.skaliere(0.25);
        over.setzeMittelpunkt(0, 0);
        over.setzeSichtbar(false);
        over.setzeEbene(20);

        rahmen = new RECHTECK[4];
        macheRahmen();

        MD = new FIGUR("rechts", "M_R.gif");
        MD.fuegeZustandVonGifHinzu("links", "M_L.gif");
        MD.fuegeZustandVonGifHinzu("oben", "M_O.gif");
        MD.fuegeZustandVonGifHinzu("unten", "M_U.gif");
        MD.skaliere(0.10);
        MD.setzeMittelpunkt(-13.5, -8.5);

        MD.setzeAnimationsGeschwindigkeitVon("rechts", 0.25);
        MD.setzeAnimationsGeschwindigkeitVon("links", 0.25);
        MD.setzeAnimationsGeschwindigkeitVon("oben", 0.25);
        MD.setzeAnimationsGeschwindigkeitVon("unten", 0.25);
        MD.macheAktiv();
        MD.setzeEbene(10);

        setzeSchwerkraft(0);
        restart();
        /*
        getreide = new FIGUR[30];
        for(int i = 0; i < getreide.length; i++){
        getreide[i] = new FIGUR("normal", "heu-ballen-test-bg-2.png", 1, 1);
        //getreide[i].macheAktiv();
        getreide[i].skaliere(0.25);
        getreide[i].setzeMittelpunkt(zufallszahlVonBis(-13, 13), zufallszahlVonBis(-8, 8));

        }
         */
        getreide = new FIGUR[40];
        for(int i = 0; i < getreide.length; i++){
            getreide[i] = new FIGUR("eins", "heu-ballen-test-bg-2.png", 1, 1);
            // gif keine richtige Animation
            //getreide[i].fuegeZustandVonEinzelbildernHinzu("zwei", "heu-ballen-test-bg-2-z2.png", "heu-ballen-test-bg-2-z3.png");
            // Option 1: Geschwindigkeit direkt beim Hinzufügen des Zustands angeben
            //getreide[i].fuegeZustandVonEinzelbildernHinzu("zwei", "heu-ballen-test-bg-2-z2.png", "heu-ballen-test-bg-2-z3.png");
            // Dann direkt danach die Geschwindigkeit setzen
            //getreide[i].setzeAnimationsGeschwindigkeitVon("zwei", 0.1); // Oder einen anderen passenden Wert
            //getreide[i].fuegeZustandVonEinzelbildernHinzu("drei", "heu-ballen-test-bg-2-z3.png");
            //getreide[i].fuegeZustandVonEinzelbildernHinzu("vier", "heu-ballen-test-bg-2-z4.png");
            //Fehler(ober): Programm will mehrere Bilder; Lösung: png in Gif umwandeln         
            //getreide[i].macheAktiv();
            getreide[i].skaliere(0.25);
            getreide[i].setzeMittelpunkt(zufallszahlVonBis(-13, 13), zufallszahlVonBis(-8, 8));
            /*
            if(i > 30){
            getreide[i].setzeSichtbar(false);
            }*/

        }
            
        zeitget = new double[40];
        
        


        mast = new FIGUR[15];
        double zufally = zufallszahlVonBis(-2, 2);
        for(int i = 0; i < mast.length; i++){
            mast[i] = new FIGUR("normal", "mast.gif");;
            //getreide[i].macheAktiv();
            mast[i].skaliere(0.07);
            mast[i].setzeMittelpunkt(3.2*i-15, zufally*(3.2*i-15));
            if(zufally > 1.5){
                mast[i].drehen(90);
            }else if(zufally < -1.5){
                mast[i].drehen(90);
            }
            //mast[i].machePassiv();
            mast[i].drehen(90);
            mast[i].setzeEbene(15);
        }
        
        mast2 = new FIGUR[15];
        double zufally2 = zufallszahlVonBis(-2, 2);
        for(int i = 0; i < mast.length; i++){
            mast2[i] = new FIGUR("normal", "mast.gif");;
            //getreide[i].macheAktiv();
            mast2[i].skaliere(0.07);
            mast2[i].setzeMittelpunkt(3.2*i-15, zufally2*(3.2*i-15));
            //mast2[i].machePassiv();
            mast2[i].drehen(90);
            mast2[i].setzeEbene(15);
        }

        aicon = new FIGUR("normal", "getreide-icon.gif");
        aicon.skaliere(0.1);
        aicon.setzeMittelpunkt(9, 9.5);

        micon = new FIGUR("normal", "Mähwerk.gif");
        micon.skaliere(0.25);
        micon.setzeMittelpunkt(5, 9.5);

        anzeige = new TEXT(10, 9.5, 1, "0");
        anzeige.setzeSichtbar(true);

        manzeige = new TEXT(6, 9.5, 1, "0");
        manzeige.setzeSichtbar(true);
        manzeige.setzeInhalt(mastkollanz);
        anfang();
        tickerNeuStarten(0.05);
    }

    public void anfang()
    {
        boolean fertig = false;
        while(!fertig)
        {

            fertig = true;
            for(int i = 0; i < getreide.length; i++){
                for(int j = 0; j < getreide.length; j++){
                    if(getreide[i] != getreide[j] ){
                        //if(MD.beruehrt(getreide[i])){
                        if(getreide[i].beruehrt(MD)){
                            gesammelt = 0;
                            anzeige.setzeInhalt(gesammelt);

                        }
                        if(getreide[i].beruehrt(getreide[j])){
                            ZufallGetreide(i);
                            fertig = false;
                            //getreide[i].setzeMittelpunkt(zufallszahlVonBis(-13, 13), zufallszahlVonBis(-8, 8));
                        }
                    }
                }
            }
        }
    }

    public void restart(){
        //System.in.reset();
        
    }

    public void tick(){
        zeit = zeit + 0.05;
        for(int i = 0; i < getreide.length; i++){
            if(MD.beruehrt(getreide[i])){
                gesammelt = gesammelt + 1;
                anzeige.setzeInhalt(gesammelt);
                //getreide[i].entfernen();

                for(int j = 0; j < getreide.length; j++){
                    if(getreide[i] != getreide[j] ){
                        //if(MD.beruehrt(getreide[i])){

                        if(getreide[i].beruehrt(getreide[j])){
                            getreide[i].setzeMittelpunkt(zufallszahlVonBis(-13, 13), zufallszahlVonBis(-8, 8));
                        }
                    }
                    if(getreide[i].beruehrt(MD)){
                        getreide[i].setzeMittelpunkt(zufallszahlVonBis(-13, 13), zufallszahlVonBis(-8, 8));

                    }

                }

                ZufallGetreide(i);
            }

        }
        /*if(gesammelt == 50){
        over.setzeSichtbar(true);
        MD.setzeSichtbar(false);
        }*/

        for(int i = 0; i < mast.length; i++){
            if(MD.beruehrt(mast[i])){
                MD.setzeMittelpunkt(-13.5, -8.5);
                mastkollanz = mastkollanz - 1;
                
                
                if(mastkollanz <= 0){
                    manzeige.setzeInhalt(0);
                }else{
                    manzeige.setzeInhalt(mastkollanz);
                }
                
                if(mastkollanz == 0){
                    over.setzeSichtbar(true);
                    MD.setzeSichtbar(false);
                    for(int j = 0; j < mast.length; j++){
                        mast[j].setzeSichtbar(false);
                    }

                    for(int j = 0; j < getreide.length; j++){
                        getreide[j].setzeSichtbar(false);
                    }
                    
                }
                //xyz = 1;
            }
            //if(xyz == 1){MD.setzeSichtbar(false);}
        }
        
        for(int i = 0; i < mast2.length; i++){
            if(MD.beruehrt(mast2[i])){
                MD.setzeMittelpunkt(-13.5, -8.5);
                mastkollanz = mastkollanz - 1;
                if(mastkollanz <= 0){
                    manzeige.setzeInhalt(0);
                }else{
                    manzeige.setzeInhalt(mastkollanz);
                }
                
                
                if(mastkollanz == 0){
                    over.setzeSichtbar(true);
                    MD.setzeSichtbar(false);
                    for(int j = 0; j < mast2.length; j++){
                        mast[j].setzeSichtbar(false);
                    }

                    for(int j = 0; j < getreide.length; j++){
                        getreide[j].setzeSichtbar(false);
                    }
                }
                //xyz = 1;
            }
            //if(xyz == 1){MD.setzeSichtbar(false);}
        }
        
        
        
        /*
        if(getreide[31].nenneSichtbar() == false && zeit == 10){
        for(int i = 0;i < (getreide.length - 30); i++){
        //getreide

        }

        }*/
        /*
        for(int i = 0; i < 10; i++){
            zeitget[i] = zeitget[i] + 0.05;
            if(zeitget[i] >= 1){
                getreide[i].setzeZustand("z2");
            }
        
        }*/
    }

    public void neuesGetreideOhneKollision(int index) {
        boolean positionGefunden = false;

        for (int versuch = 0; versuch < 20; versuch++) {
            double x = zufallszahlVonBis(-13, 13);
            double y = zufallszahlVonBis(-8, 8);
            getreide[index].setzeMittelpunkt(x, y);

            boolean kollision = false;

            // Prüfe Kollision mit anderen Getreiden
            for (int i = 0; i < getreide.length; i++) {
                if (i != index && getreide[index].beruehrt(getreide[i])) {
                    kollision = true;
                    break;
                }
            }

            // Prüfe Kollision mit dem Mähdrescher (MD)
            if (getreide[index].beruehrt(MD)) {
                kollision = true;
            }

            if (!kollision) {
                positionGefunden = true;
                break; // Position gefunden, Schleife verlassen
            }
        }

        if (!positionGefunden) {
            //System.out.println("Getreide " + index + " konnte keine freie Position finden und wird entfernt.");
            getreide[index].setzeSichtbar(false);
            getreide[index].entfernen();
        }
    }

    public void ZufallGetreide(int num){
        for(int i = 0; i < getreide.length; i++){
            if(getreide[num].beruehrt(getreide[i])){

                getreide[num].setzeMittelpunkt(zufallszahlVonBis(-13, 13), zufallszahlVonBis(-8, 8));
                //System.out.println(num + "getreide zufallgespawn");
            }

        }
    }

    public void tasteReagieren(int taste){
        if(taste == TASTE.ENTER){
            restart();
        }
        if(MD.nenneSichtbar() == true)
        {
            double x = MD.nenneMittelpunktX();
            double y = MD.nenneMittelpunktY();
            if(taste == TASTE.RECHTS){
                MD.setzeGeschwindigkeit(3, 0);
                //MD.drehen(0);
                MD.setzeDrehwinkel(0);
                //MD.setzeZustand("rechts");
                //korrigierenY();
            }
            if(taste == TASTE.LINKS){
                MD.setzeGeschwindigkeit(-3, 0);
                MD.setzeDrehwinkel(180);
                //MD.drehen(90);
                //MD.setzeZustand("links");
                //korrigierenY();
            }
            if(taste == TASTE.RAUF){
                MD.setzeGeschwindigkeit(0, 3);
                MD.setzeDrehwinkel(90);
                //MD.drehen(-90);
                //MD.setzeZustand("oben");
                //korrigierenX();
            }
            if(taste == TASTE.RUNTER){
                MD.setzeGeschwindigkeit(0, -3);
                MD.setzeDrehwinkel(-90);
                //MD.drehen(180);
                //MD.setzeZustand("unten");
                //korrigierenX();
            }

            MD.setzeMittelpunkt(x, y);
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
