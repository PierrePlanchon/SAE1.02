class AlphaChevaux extends Program{
    
    final String BASE = " @ ";
    final String CASE = "( )";
    final String CASE_MID = "[ ]";

    final String J1_COLOR = ANSI_BLUE;
    final String J2_COLOR = ANSI_YELLOW;
    final String J3_COLOR = ANSI_RED;
    final String J4_COLOR = ANSI_GREEN;

    void algorithm(){
        String[][] plateau = new String[15][15];
        init(plateau);
        println(ANSI_RED+ANSI_BLINK_SLOW+"rouge"); //faire clignoter joueur
        println(ANSI_RESET);
        plateau[6][0] = J1_COLOR + " 0 ";
        //afficherPlateau(plateau);
        //println(ANSI_RESET);

        int[][] cheminBleu = new int[][]{{6,0},{6,1},{6,2},{6,3},{6,4},{6,5},{6,6},{5,6},{4,6},{3,6},{2,6},{1,6},{0,6},
                                        {0,7},{0,8},{1,8},{2,8},{3,8},{4,8},{5,8},{6,8},{6,9},{6,10},{6,11},{6,12},{6,13},{6,14},
                                        {7,14},{8,14},{8,13},{8,12},{8,11},{8,10},{8,9},{8,8},{9,8},{10,8},{11,8},{12,8},{13,8},{14,8},
                                        {14,7},{14,6},{13,6},{12,6},{11,6},{10,6},{9,6},{8,6},{8,5},{8,4},{8,3},{8,2},{8,1},{8,0},{7,0}};
        int idxBleu = 0;
        //int posBleu = cheminBleu[idxBleu];
        //type cheval : couleur et position
        //savoir ligne ou colonne
        boolean tour = false;
        while (!tour){
            afficherPlateau(plateau);
            println(ANSI_RESET);
            int cases = lancé1();
            int table = lancé2();
            int multi = lancé2();
            println("Vous jouez pour avancer de "+cases+" cases !");
            println("table de : "+table);
            print(table+" x "+multi+" = ");
            int reponse = readInt();
            if (table*multi == reponse){
                println("Bonne réponse ! Vous avancez de "+"2"+" cases !");
                plateau[cheminBleu[idxBleu][0]][cheminBleu[idxBleu][1]] = ANSI_RESET+CASE;
                idxBleu = idxBleu + cases;
                //posBleu = cheminBleu[idxBleu];
                plateau[cheminBleu[idxBleu][0]][cheminBleu[idxBleu][1]] = J1_COLOR+" 0 "+ANSI_RESET;
                if (idxBleu == length(cheminBleu)-1){
                    tour=true;
                }
            }else {
                println("Mauvaise réponse... Vous n'avancez que de "+cases/2+" cases...");
            }
        }
        afficherPlateau(plateau);
        
    }


    ////////// initialisation du plateau //////////

    void init(String[][] plateau){
        for (int ligne=0; ligne<length(plateau); ligne++){
            for (int colonne=0; colonne<length(plateau[ligne]); colonne++){
                if ((colonne<6 || colonne>8) && (ligne<6 || ligne>8)){
                    if (ligne<6 && colonne<6){
                        plateau[ligne][colonne] = J1_COLOR+BASE;
                    }else if (ligne<6 && colonne>8){
                        plateau[ligne][colonne] = J2_COLOR+BASE;
                    }else if (ligne>8 && colonne<6){
                        plateau[ligne][colonne] = J4_COLOR+BASE;
                    }else if (ligne>8 && colonne>8){
                        plateau[ligne][colonne] = J3_COLOR+BASE;
                    }
                }else{
                    if (ligne==7 && colonne!=0 && colonne!=14 || colonne==7 && ligne!=0 && ligne!=14){
                        if (ligne==7 && colonne<7){
                            plateau[ligne][colonne] = J1_COLOR+CASE_MID;
                        }else if (ligne<7 && colonne==7){
                            plateau[ligne][colonne] = J2_COLOR+CASE_MID;
                        }else if (ligne>7 && colonne==7){
                            plateau[ligne][colonne] = J4_COLOR+CASE_MID;
                        }else if (ligne==7 && colonne>7){
                            plateau[ligne][colonne] = J3_COLOR+CASE_MID;
                        }
                    }else{
                        plateau[ligne][colonne] = ANSI_RESET+CASE;
                    }
                }
            }
        }
        plateau[7][7] = ANSI_RESET+" X ";
    }


    ////////// affichage du plateau //////////

    void afficherPlateau(String[][] plateau){
        String tab="";
        for (int i=0; i<length(plateau); i++){
            for (int c=0; c<length(plateau[i]); c++){
                tab=tab+plateau[i][c];
            }
            tab=tab+"\n";
        }
        print(tab);
    }


    ////////// lancer des dés //////////

    int lancé1(){
        return (int)(random()*6) + 1;
    }

    int lancé2(){
        return (int)(random()*10) + 1;
    }

    ////////// 
}


/*
règles : 
lancé du 1er dé : [1,6] --> on joue pour combien de cases ?
lancé du 2e dé : [1,10] --> la question concernera quelle table ?
Si bonne réponse : on avance du nombre du 1er dé, sinon ce nombre/2

tour à tour : fonctions J1, J2, J3, J4
while (J1){
    ligne 10
}
*/