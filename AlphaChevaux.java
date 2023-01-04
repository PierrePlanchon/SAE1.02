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
        String basic_case = CASE;
        String case_mid = CASE_MID;
        init(plateau);

        Cheval bleu1 = creerCheval(6,0,J1_COLOR," 1 ");
        Cheval jaune1 = creerCheval(0,8,J2_COLOR," 1 ");
        Cheval rouge1 = creerCheval(8,14,J3_COLOR," 1 ");
        Cheval vert1 = creerCheval(14,6,J4_COLOR," 1 ");

        plateau[bleu1.ligne][bleu1.colonne] = bleu1.couleur + bleu1.pion;
        plateau[jaune1.ligne][jaune1.colonne] = jaune1.couleur + jaune1.pion;
        plateau[rouge1.ligne][rouge1.colonne] = rouge1.couleur + rouge1.pion;
        plateau[vert1.ligne][vert1.colonne] = vert1.couleur + vert1.pion;

        int[][] cheminBleu = new int[][]{{6,0},{6,1},{6,2},{6,3},{6,4},{6,5},{6,6},{5,6},{4,6},{3,6},{2,6},{1,6},{0,6},
                                        {0,7},{0,8},{1,8},{2,8},{3,8},{4,8},{5,8},{6,8},{6,9},{6,10},{6,11},{6,12},{6,13},{6,14},
                                        {7,14},{8,14},{8,13},{8,12},{8,11},{8,10},{8,9},{8,8},{9,8},{10,8},{11,8},{12,8},{13,8},{14,8},
                                        {14,7},{14,6},{13,6},{12,6},{11,6},{10,6},{9,6},{8,6},{8,5},{8,4},{8,3},{8,2},{8,1},{8,0},{7,0}};
        int[][] interieurBleu = new int[][]{{7,0},{7,1},{7,2},{7,3},{7,4},{7,5},{7,6}};

        int[][] cheminJaune = new int[][]{{0,8},{1,8},{2,8},{3,8},{4,8},{5,8},{6,8},{6,9},{6,10},{6,11},{6,12},{6,13},{6,14},
                                        {7,14},{8,14},{8,13},{8,12},{8,11},{8,10},{8,9},{8,8},{9,8},{10,8},{11,8},{12,8},{13,8},{14,8},
                                        {14,7},{14,6},{13,6},{12,6},{11,6},{10,6},{9,6},{8,6},{8,5},{8,4},{8,3},{8,2},{8,1},{8,0},{7,0},
                                        {6,0},{6,1},{6,2},{6,3},{6,4},{6,5},{6,6},{5,6},{4,6},{3,6},{2,6},{1,6},{0,6},{0,7}};
        int[][] interieurJaune = new int[][]{{0,7},{1,7},{2,7},{3,7},{4,7},{5,7},{6,7}};

        int[][] cheminRouge = new int[][]{{8,14},{8,13},{8,12},{8,11},{8,10},{8,9},{8,8},{9,8},{10,8},{11,8},{12,8},{13,8},{14,8},
                                        {14,7},{14,6},{13,6},{12,6},{11,6},{10,6},{9,6},{8,6},{8,5},{8,4},{8,3},{8,2},{8,1},{8,0},{7,0},
                                        {6,0},{6,1},{6,2},{6,3},{6,4},{6,5},{6,6},{5,6},{4,6},{3,6},{2,6},{1,6},{0,6},{0,7},{0,8},{1,8},{2,8},
                                        {3,8},{4,8},{5,8},{6,8},{6,9},{6,10},{6,11},{6,12},{6,13},{6,14},{7,14}};
        int[][] interieurRouge = new int[][]{{7,14},{7,13},{7,12},{7,11},{7,10},{7,9},{7,8}};

        int[][] cheminVert = new int[][]{{14,6},{13,6},{12,6},{11,6},{10,6},{9,6},{8,6},{8,5},{8,4},{8,3},{8,2},{8,1},{8,0},{7,0},
                                        {6,0},{6,1},{6,2},{6,3},{6,4},{6,5},{6,6},{5,6},{4,6},{3,6},{2,6},{1,6},{0,6},{0,7},{0,8},{1,8},{2,8},
                                        {3,8},{4,8},{5,8},{6,8},{6,9},{6,10},{6,11},{6,12},{6,13},{6,14},{7,14},{8,14},{8,13},{8,12},{8,11},{8,10},
                                        {8,9},{8,8},{9,8},{10,8},{11,8},{12,8},{13,8},{14,8},{14,7}};
        int[][] interieurVert = new int[][]{{14,7},{13,7},{12,7},{11,7},{10,7},{9,7},{8,7}};

        int idxBleu = 0;
        int idxJaune = 0;
        int idxRouge = 0;
        int idxVert = 0;
        boolean tour = false;
        String couleur;
        int joueur = 1;
        while (!tour){
            println();
            println(ANSI_RED+ANSI_BLINK_SLOW+"JOUEUR "+joueur); //JOUEUR X
            println(ANSI_RESET);
            afficherPlateau(plateau); //plateau
            println(ANSI_RESET);
            int cases = lancé1();  //dé1
            int table = lancé2();  //dé2
            int multi = lancé2();  //dé3
            println("Vous jouez pour avancer de "+cases+" cases !");
            println("table de : "+table);
            

            String saisie;
            do {
                print(table+" x "+multi+" = ");
                saisie = readString();
            }while(!estNombre(saisie));

            int reponse = stringToInt(saisie);
            
            boolean rep = (table*multi == reponse);
            if (joueur==1){
                couleur = J1_COLOR;
                idxBleu = deplacer(plateau,  cheminBleu, idxBleu, cases, rep, bleu1, CASE);
            }else if (joueur==2){
                couleur = J2_COLOR;
                idxJaune = deplacer(plateau,  cheminJaune, idxJaune, cases, rep, jaune1, CASE);
            }else if (joueur==3){
                couleur = J3_COLOR;
                idxRouge = deplacer(plateau,  cheminRouge, idxRouge, cases, rep, rouge1, CASE);
            }else{
                couleur = J4_COLOR;
                idxVert = deplacer(plateau,  cheminVert, idxVert, cases, rep, vert1, CASE);
            }
            
            ////////////////////// ---> creer fonction deplacements_interieurs 
            int[][] tempBleu = cheminBleu;
            if (idxBleu == length(tempBleu)-1){
                cheminBleu = interieurBleu;
                idxBleu = 0;
                basic_case = case_mid;
                //tour=true;
            }
            int[][] tempJaune = cheminJaune;
            if (idxJaune == length(tempJaune)-1){
                cheminJaune = interieurJaune;
                idxJaune = 0;
                basic_case = case_mid;
                //tour=true;
            }
            int[][] tempRouge = cheminRouge;
            if (idxRouge == length(tempRouge)-1){
                cheminRouge = interieurRouge;
                idxRouge = 0;
                basic_case = case_mid;
                //tour=true;
            }
            int[][] tempVert = cheminVert;
            if (idxVert == length(tempVert)-1){
                cheminVert = interieurVert;
                idxVert = 0;
                basic_case = case_mid;
                //tour=true;
            }
            //////////////////////

            ///////////////////////
            if (joueur<4){
                joueur++;
            }else {
                joueur = 1;
            }
        }
        afficherPlateau(plateau);
        
    }

    ////////// deplacements intérieurs /////////

    int[][] deplacements_interieurs(int[][] chemin, int[][] interieur, int position){
        int[][] temp = chemin;
        if (position == length(temp)-1){
            chemin = interieur;
            position = 0;
        }
        return chemin;
    }

    ////////// gestion saisie /////////

    boolean estNombre(String reponse){
        char chiffre;
        for (int idx=0; idx<length(reponse); idx++){
            chiffre = charAt(reponse, idx);
            if (chiffre<'0' || chiffre>'9'){
                return false;
            }
        }
        return true;
    }

    void testEstNombre(){
        assertEquals(true, estNombre("90"));
        assertEquals(false, estNombre("."));
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

    ////////// deplacements //////////

    int deplacer(String[][] plateau, int[][] chemin, int position, int cases, boolean reponse, Cheval horse, String old_case){
        if (reponse){
            println("Bonne réponse ! Vous avancez de "+cases+" cases !");
            plateau[chemin[position][0]][chemin[position][1]] = ANSI_RESET+old_case;
            position = position + cases;
            if (position>=length(chemin)){
                position = length(chemin)-1;
            }
            plateau[chemin[position][0]][chemin[position][1]] = horse.couleur+horse.pion+ANSI_RESET;
        }else {
            println("Mauvaise réponse... Vous n'avancez que de "+cases/2+" cases...");
            plateau[chemin[position][0]][chemin[position][1]] = ANSI_RESET+old_case;
            position = position + cases/2;
            if (position>=length(chemin)){
                position = length(chemin)-1;
            }
            plateau[chemin[position][0]][chemin[position][1]] = horse.couleur+horse.pion+ANSI_RESET;
        }
        return position;
    }

    ////////// creer un cheval //////////

    Cheval creerCheval(int ligne, int colonne, String couleur, String pion){
        Cheval horse = new Cheval();
        horse.ligne = ligne;
        horse.colonne = colonne;
        horse.couleur = couleur;
        horse.pion = pion;
        return horse;
    }

    
}

/*
règles : 
lancé du 1er dé : [1,6] --> on joue pour combien de cases ?
lancé du 2e dé : [1,10] --> la question concernera quelle table ?
Si bonne réponse : on avance du nombre du 1er dé, sinon ce nombre/2


creer un type Chemins ?
gerer la fin d'un tour (ne depasse pas les limites du chemins) ---> en cours
dans deplacer() ajouter le type Cheval, tout gerer avec le type cheval !! ---> OK
chevaux "1" et "2" ---> en cours
clignotant de la bonne couleur ---> à faire
gerer les pions mangés !! --- à faire
creer foncton deplacements_interieurs ---> en cours /!\
gérer la sauvegarde d'une partie ---> à faire
gérer la saisie (que des nombres) ---> OK
*/