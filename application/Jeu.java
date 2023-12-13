package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controleur.Interaction;
import modele.*;

public class Jeu {

    private PlateauDeJeu plateauDeJeu;
    private int numeroConfiguration, nbTours;
    private Random generator;
    private Joueur JoueurPerso[];
    private String firstPlayer, nextKing;
    private boolean lastTurn;
    private int crown;
    
    public Jeu(PlateauDeJeu p, int config, Random gen) {
        plateauDeJeu = p;
        numeroConfiguration = config;
        generator = gen;
        JoueurPerso = new Joueur[8]; // @audit create the table according to the number of player
    }
    public static void main(String[] args) {
        
        Jeu test=new Jeu(null, 0, new Random());
        test.jouer();
    }

    public void jouer() {
        int choix=-1;
        System.out.println("BIENVENUE SUR CITADELLES \n\n");
        do {
            choix=afficherMenu();
            switch (choix) {
                case 0:
                    afficherLesRegles();
                    break;
                case 1:
                    jouerPartie();
                    break;
                case 2:
                    System.out.println("\nFERMETURE DU PROGRAMME\n\nREVENEZ QUAND VOUS VOUDREZ :)");
                    break;
            
                default:
                    break;
            }
        } while (choix!=2);
    }

    private void afficherLesRegles() {
        int choixregle=-1;
        do {
            System.out.println("REGLES\n");
            System.out.println("\n1. Objectif du jeu\n2.Personnages \n3.Tour des Joueurs \n4.Fin du jeu \n5.Retour au menu ");
            choixregle=Interaction.lireUnEntier(1,6);
            switch (choixregle) {
                case 1:
                    System.out.println("\nObjectif du jeu\n");
                    System.out.println(Caracteristiques.OBJECTIF);
                    break;
                case 2:
                    System.out.println("\nPersonnage\n");
                    System.out.println(Caracteristiques.PERSONNAGE);
                    break;
                case 3:
                    System.out.println("\nTour des joueurs\n");
                    System.out.println(Caracteristiques.TOUR);
                    break;
                case 4:
                    System.out.println("\nFin de la partie\n");
                    System.out.println(Caracteristiques.FIN);
                    break;
                case 5:
                    System.out.println("\nFERMETURE \n\n");
                    afficherMenu();
                    break;
                default:
                    break;
            }
        }while (choixregle!=5);
    }

    private void jouerPartie() {
        System.out.println("\nLANCEMENT DE LA PARTIE \n");

        initialisation();

        tourDeJeu();
        
        afficherScores(calculDesPoints());


        System.out.println("\nFIN DE PARTIE \n");
    }

    private void initialisation() {
        System.out.println("\nINITIALISATION DU JEU");
        lastTurn=false;
        firstPlayer=null;
        nbTours=0;
        crown=-1;
        nextKing="";
        plateauDeJeu=Configuration.configurationDeBase(Configuration.nouvellePioche());
        for (int i = 0; i < plateauDeJeu.getNombreJoueurs(); i++) {
            // add two pieces of gold
            Joueur j=plateauDeJeu.getJoueur(i);
            j.ajouterPieces(2);
            // add four quarter to the hand
            for (int j2 = 0; j2 < 4; j2++) {
                j.ajouterQuartierDansMain(plateauDeJeu.getPioche().piocher());
            }

        }
        plateauDeJeu.getJoueur(0).setPossedeCouronne(true);

    }

    private void gestionCouronne() {
        System.out.println("\nGESTION DE LA COURONNE\n");
        int nbJoueurs=plateauDeJeu.getNombreJoueurs();
        if(crown==-1) {
            System.out.println("Quel joueur aura la couronne pour le premier tour ?");
            for (int i = 0; i < nbJoueurs; i++) {
                System.out.println((i+1)+". "+ plateauDeJeu.getJoueur(i).getNom());
            }
            System.out.println("choisissez une option ");
            int choix=Interaction.automatedChoice(nbJoueurs, false);
            crown=choix;
            plateauDeJeu.getJoueur(crown).setPossedeCouronne(true);
        } else {
            if(!nextKing.equals("")) {
                for (int i = 0; i < plateauDeJeu.getNombreJoueurs(); i++) {
                    if(plateauDeJeu.getJoueur(i).getNom()==nextKing) crown=i;
                }
                nextKing="";
            } else {
                crown=(crown+1)%nbJoueurs;
            }
            for (int i = 0; i < nbJoueurs; i++) {
                plateauDeJeu.getJoueur(i).setPossedeCouronne(false);
            }
            plateauDeJeu.getJoueur(crown).setPossedeCouronne(true);
        }
        System.out.println("\nPOUR CE TOUR LE JOUEUR "+plateauDeJeu.getJoueur(crown).getNom()+" AURA LA COURONNE");
    }

    private void tourDeJeu() {
        do {
            nbTours++;
            if(nbTours>1)reinitialisationPersonnages();
            System.out.println("\n-------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("\n ------------------------   TOUR DE JEU : "+nbTours);
            choixPersonnages();
            for (int i = 0; i < plateauDeJeu.getNombreJoueurs(); i++) {
                Joueur player=plateauDeJeu.getJoueur(i);
                // associer les personnages aux joueurs
                JoueurPerso[player.getPersonnage().getRang()-1]=player;
                System.out.println(player.getNom()+" --> "+player.getPersonnage().getNom());
            }

            System.out.println("\nAPPEL DES PERSONNAGES");
            // call character and play their turn
            this.appelerPersonnage();
            partieFinie();
        } while (!lastTurn);
        // } while (nbTours<2); 

    }

    private void choixPersonnages() {
        System.out.println("\nMELANGE CARTES PERSONNAGE");
        int nPerso=plateauDeJeu.getNombrePersonnages();
        
        int c1=Interaction.randomInt(nPerso), c2=(c1+1)%nPerso, c3=(c2+1)%nPerso;
        // declare an empty int table of 5 elements
        List<Personnage> selectable = new ArrayList<Personnage>();
        int choixPerso=-1;
        for (int i = 0; i < nPerso; i++) {
            if(i!=c1&&i!=c2&&i!=c3) {
                Personnage p=plateauDeJeu.getPersonnage(i);
                selectable.add(p);
            }
        }
        gestionCouronne();
        System.out.println("\nCHOIX DE PERSONNAGE "+crown);
        // for (int i = 0; i < plateauDeJeu.getNombreJoueurs(); i++) {
        for (int i = crown; i < (crown+plateauDeJeu.getNombreJoueurs()); i++) {
            int correctIndice=(i%plateauDeJeu.getNombreJoueurs());
            String textToPrint="Le personnage  "+ plateauDeJeu.getPersonnage(c1).getNom()+" est posé face visible\n"+
                "Le personnage  "+ plateauDeJeu.getPersonnage(c2).getNom()+" est posé face visible\n"+
                "Un personnage  est posé face cachée \n"+
                "Liste des personnages disponibles";
            // System.out.println(textToPrint);
        
            for (int j = 0; j < selectable.size(); j++) {
                System.out.println((j+1)+"  "+ selectable.get(j).getNom());
            }
            Joueur j=plateauDeJeu.getJoueur(correctIndice);
            System.out.println(j.getNom()+" choisissez votre personnage ");
            // choixPerso=Interaction.lireUnEntier(0, 5); @audit active this to allow player to select his character
            choixPerso=Interaction.automatedChoice(selectable.size(), j.getAutomated());
            Personnage perso=selectable.remove(choixPerso);
            perso.setJoueur(j);
            j.setMonPersonnage(perso);
            // plateauDeJeu.getJoueur(correctIndice).getPersonnage().setJoueur(null);
            System.out.println("\n");
        }
        
    }

    private int afficherMenu() {
        String menu="\n\tMENU \n\n"+
            "0. AFFICHER LES RÈGLES \n"+
            "1. JOUER UNE PARTIE \n"+
            "2. QUITTER LE JEU \n" +
            "\n\n"+
            "Veuillez choisir une option ";
        System.out.println(menu);

        return Interaction.lireUnEntier(0, 4);
    }

    private void afficherDetailsPartie(int [] scores) {
        for(int i=0; i<this.plateauDeJeu.getNombreJoueurs(); i++){
            System.out.println("JOUEUR "+ (i+1) +" : "+ this.plateauDeJeu.getJoueur(i).getNom());
            System.out.println("Nombre de pieces : "+ this.plateauDeJeu.getJoueur(i).nbPieces());
            System.out.println("Score : "+ scores[i]);
            this.plateauDeJeu.getJoueur(i).afficherQuartierDansCite();
            System.out.println("\n");
        }
    }

    protected Boolean bibliotheque(Joueur joueur) {
        if (joueur.quartierPresentDansCite("Bibliotheque")) {
            for (int i = 0; i < 2; i++) {
                Quartier quartier = this.plateauDeJeu.getPioche().piocher();
                if (quartier != null) {
                    System.out.println(i+1 + "- " + quartier.getNom() + " (coût " + quartier.getCout() + ")");
                    joueur.getPersonnage().ajouterQuartier(quartier);
                }
            }
            return true;
        }else {
            return false;
        }
    }
    protected Boolean carriere(Joueur joueur, Quartier quartier) {
        if(joueur.quartierPresentDansCite(quartier.getNom()) && joueur.quartierPresentDansCite("Carriere")) {
            return true;
        }else if(!joueur.quartierPresentDansCite(quartier.getNom())) {
            return true;
        }else {
            System.out.println("Impossible de construire ce quartier");
            return false;
        }
    }

    private void appelerPersonnage() {
        for (int i = 0; i < plateauDeJeu.getNombreJoueurs(); i++) {
            if(!plateauDeJeu.getJoueur(i).getPersonnage().isValid()) {
                System.out.println("MORT AVANT LE DEBUT DU TOUR "+nbTours);
                System.out.println("PERSONNAGE JOUEUR "+plateauDeJeu.getJoueur(i).getPersonnage().getJoueur());
                System.out.println("PERSONNAGE ASSASSINE "+plateauDeJeu.getJoueur(i).getPersonnage().getAssassine());
                System.out.println(plateauDeJeu.getJoueur(i).getNom()+"  "+plateauDeJeu.getJoueur(i).getPersonnage().getNom());
                System.exit(0);
            }
        }
        for (int i = 0; i < 8; i++) {
            System.out.println("\nPERSONNAGE AVEC LE RANG "+(i+1));
            Joueur joueurActif=JoueurPerso[i];
            if(joueurActif!=null) {
                // System.out.println("Joueur Actif : "+joueurActif.getNom());
                tourJoueur(joueurActif);
            }
            else // System.out.println("IL N'Y A PAS DE PERSONNAGE AVEC LE RANG "+(i+1));
                System.out.printf(". . . . . . . . . . . . . . . . . ");
            // code that pause the program 5 seconds
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }

    }

    private void tourJoueur(Joueur j) {
        switch (j.getPersonnage().getNom()) {
            case "Assassin":
                System.out.println("Le personnage a le joueur : ASSASSIN");
                // reçoit les ressources
                percevoirRessource(j);
                // reçoit les ressources specifiques liées à son pouvoir et à ses merveilles

                // utilise son pouvoir
                System.out.println("PPPPPPPPPPPPPPPPPPPPPPPP  utilisation de pouvoir PPPPPPPPPPPPPPPPPPPPPPPP");
                if(!j.getAutomated()) j.getPersonnage().utiliserPouvoir();
                else j.getPersonnage().utiliserPouvoirAvatar();
                
                // construire
                construireQuartier(j);
                
            break;
            case "Voleur":
                if(!j.getPersonnage().isValid()) {
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX  personnage mort");
                    if(!j.getAutomated()) {
                        System.out.println("\n VOTRE PERSONNAGE A ÉTÉ TUÉ \n Entrez o pour continuer");
                        Interaction.lireOuiOuNon();
                    }
                    break;
                }
                System.out.println("Le personnage a le joueur : VOLEUR");
                percevoirRessource(j);
                System.out.println("PPPPPPPPPPPPPPPPPPPPPPPP  utilisation de pouvoir PPPPPPPPPPPPPPPPPPPPPPPP");
                if(!j.getAutomated()) j.getPersonnage().utiliserPouvoir();
                else j.getPersonnage().utiliserPouvoirAvatar();
                construireQuartier(j);
                
            break;
            case "Magicienne":
                if(!j.getPersonnage().isValid()) {
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX  personnage mort");
                    if(!j.getAutomated()) {
                        System.out.println("\n VOTRE PERSONNAGE A ÉTÉ TUÉ \n Entrez o pour continuer");
                        Interaction.lireOuiOuNon();
                    }
                    break;
                }
                System.out.println("Le personnage a le joueur : MAGICIENNE");
                if(j.getPersonnage().getVole()) {
                    recupererPiece(j);
                    if(!j.getAutomated()) {
                        System.out.println("\n VOTRE PERSONNAGE A ÉTÉ VOLE \n Entrez o pour continuer");
                        Interaction.lireOuiOuNon();
                    }
                }
                percevoirRessource(j);
                if(!j.getAutomated()) j.getPersonnage().utiliserPouvoir();
                else j.getPersonnage().utiliserPouvoirAvatar();
                construireQuartier(j);
                
            break;
            case "Roi":
                if(!j.getPersonnage().isValid()) {
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX  personnage mort");
                    if(!j.getAutomated()) {
                        System.out.println("\n VOTRE PERSONNAGE A ÉTÉ TUÉ \n Entrez o pour continuer");
                        Interaction.lireOuiOuNon();
                    }
                    break;
                }
                System.out.println("Le personnage a le joueur : ROI");
                if(j.getPersonnage().getVole()) {
                    recupererPiece(j);
                    if(!j.getAutomated()) {
                        System.out.println("\n VOTRE PERSONNAGE A ÉTÉ VOLE \n Entrez o pour continuer");
                        Interaction.lireOuiOuNon();
                    }
                }
                percevoirRessource(j);
                
                if(!j.getAutomated()) j.getPersonnage().utiliserPouvoir();
                else j.getPersonnage().utiliserPouvoirAvatar();

                if(j.getPossedeCouronne()) {
                    nextKing=j.getNom();
                    System.out.println("LE PROCHAIN ROI SERA "+j.getNom());
                }
                construireQuartier(j);
                
            break;
            case "Eveque":
                if(!j.getPersonnage().isValid()) {
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX  personnage mort");
                    if(!j.getAutomated()) {
                        System.out.println("\n VOTRE PERSONNAGE A ÉTÉ TUÉ \n Entrez o pour continuer");
                        Interaction.lireOuiOuNon();
                    }
                    break;
                }
                System.out.println("Le personnage a le joueur : EVEQUE");
                if(j.getPersonnage().getVole()) {
                    recupererPiece(j);
                    if(!j.getAutomated()) {
                        System.out.println("\n VOTRE PERSONNAGE A ÉTÉ VOLE \n Entrez o pour continuer");
                        Interaction.lireOuiOuNon();
                    }
                }
                percevoirRessource(j);
                
                if(!j.getAutomated()) j.getPersonnage().utiliserPouvoir();
                else j.getPersonnage().utiliserPouvoirAvatar();
                
                construireQuartier(j);
                
            break;
            case "Marchande":
                if(!j.getPersonnage().isValid()) {
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX  personnage mort");
                    if(!j.getAutomated()) {
                        System.out.println("\n VOTRE PERSONNAGE A ÉTÉ TUÉ \n Entrez o pour continuer");
                        Interaction.lireOuiOuNon();
                    }
                    break;
                }
                percevoirRessource(j);
                System.out.println("Le personnage a le joueur : MARCHANDE");
                if(j.getPersonnage().getVole()) {
                    recupererPiece(j);
                    if(!j.getAutomated()) {
                        System.out.println("\n VOTRE PERSONNAGE A ÉTÉ VOLE \n Entrez o pour continuer");
                        Interaction.lireOuiOuNon();
                    }
                }
                System.out.println("PPPPPPPPPPPPPPPPPPPPPPPP  utilisation de pouvoir PPPPPPPPPPPPPPPPPPPPPPPP");
                
                if(!j.getAutomated()) j.getPersonnage().utiliserPouvoir();
                else j.getPersonnage().utiliserPouvoirAvatar();

                construireQuartier(j);
                
            break;
            case "Architecte":
                if(!j.getPersonnage().isValid()) {
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX  personnage mort");
                    if(!j.getAutomated()) {
                        System.out.println("\n VOTRE PERSONNAGE A ÉTÉ TUÉ \n Entrez o pour continuer");
                        Interaction.lireOuiOuNon();
                    }
                    break;
                }
                System.out.println("Le personnage a le joueur : ACHITECTE");
                if(j.getPersonnage().getVole()) {
                    recupererPiece(j);
                    if(!j.getAutomated()) {
                        System.out.println("\n VOTRE PERSONNAGE A ÉTÉ VOLE \n Entrez o pour continuer");
                        Interaction.lireOuiOuNon();
                    }
                }

                percevoirRessource(j);
                System.out.println("\n Vous pouvez construire jusqu'a 3 quatiers combient voulez vous en construire ?");
                int choix;
                if(j.getAutomated()) choix=Interaction.randomInt(3);
                else choix=Interaction.lireUnEntier(0, 4);
                System.out.println("&&&&&&&&&&&& vous avez choisi "+choix);
                for (int i = 0; i < choix; i++) {
                    construireQuartier(j);
                }
                
            break;
            case "Condotierre":
                if(!j.getPersonnage().isValid()) {
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX  personnage mort");
                    if(!j.getAutomated()) {
                        System.out.println("\n VOTRE PERSONNAGE A ÉTÉ TUÉ \n Entrez o pour continuer");
                        Interaction.lireOuiOuNon();
                    }
                    break;
                }
                System.out.println("Le personnage a le joueur : CONDOTIERRE");
                if(j.getPersonnage().getVole()) {
                    recupererPiece(j);
                    if(!j.getAutomated()) {
                        System.out.println("\n VOTRE PERSONNAGE A ÉTÉ VOLE \n Entrez o pour continuer");
                        Interaction.lireOuiOuNon();
                    }
                }
                
                percevoirRessource(j);
                System.out.println("PPPPPPPPPPPPPPPPPPPPPPPP  utilisation de pouvoir PPPPPPPPPPPPPPPPPPPPPPPP");
                
                if(!j.getAutomated()) j.getPersonnage().utiliserPouvoir();
                else j.getPersonnage().utiliserPouvoirAvatar();

                construireQuartier(j);
                
            break;
        
            default:
                break;
        }
    }


    private void percevoirRessource(Joueur j) {
        System.out.println("\nPHASE 1 DU TOUR \n");
        System.out.println("vous pouvez choisir l'une des option suivantes");
        String optionsText="1. Recevoir deux pieces d'or \n"+
            "2. Piocher deux cartes \n"+
            "choisissez une option ";
        System.out.println(optionsText);
        int choix=Interaction.automatedChoice(2, j.getAutomated());
        if(choix<1) { // @audit do not forget do manage that part
            System.out.println("\nVOUS AVEZ CHOISI DE RECEVOIR DEUX PIECES D'OR");
            j.ajouterPieces(10); // @audit set 2 here
            System.out.println("votre tresor est maintenant de "+j.nbPieces()+" pieces d'or");
        }
        else {
            System.out.println("\nVOUS AVEZ CHOISI DE PIOCHER DEUX CARTES");
            Quartier q1=plateauDeJeu.getPioche().piocher(), q2=plateauDeJeu.getPioche().piocher();
            System.out.println("voici les cartes que vous avez piocher");
            System.out.println("1. "+q1.getNom()+ " de type "+q1.getType()+" coutant "+q1.getCout()+" pieces d'or");
            System.out.println("2. "+q2.getNom()+ " de type "+q2.getType()+" coutant "+q2.getCout()+" pieces d'or");
            System.out.println("choisissez celle que vous souhaitez conserver ");
            choix=Interaction.automatedChoice(2, j.getAutomated());
            if(choix<1) {
                plateauDeJeu.getPioche().ajouter(q2);
                j.ajouterQuartierDansMain(q1);
            }
            else {
                plateauDeJeu.getPioche().ajouter(q1);
                j.ajouterQuartierDansMain(q2);
            }
            afficherQuartierDansLaMain(j);
            
        }
    }

    private void afficherQuartierDansLaMain(Joueur j) {
            System.out.println("voici les quartiers de votre main");
            ArrayList<Quartier> main=j.retournerMain();
            for (int i = 0; i < main.size(); i++) {
                System.out.println((i+1)+". "+main.get(i).getNom()+" de type "+main.get(i).getType()+" : "+main.get(i).getCout()+" pieces d'or");
            }
    }
    private void afficherQuartierDansLaCite(Joueur j) {
            System.out.println("voici les quartiers de votre cite");
            Quartier[] cite=j.retounerCite();
            System.out.println("nombre de quartiers dans la cite : "+j.nbQuartiersDansCite());
            for (int i = 0; i < j.nbQuartiersDansCite(); i++) {
                System.out.println((i+1)+". "+cite[i].getNom()+" de type "+cite[i].getType()+" : "+cite[i].getCout()+" pieces d'or");
            }
    }

    private void construireQuartier(Joueur j){
        System.out.println("\nPHASE 4 DU TOUR \n");
        System.out.println("souhaitez vous construire un quartier dans votre cite ?");
        String optionText="1. OUI je souhaite construire un quartier \n"+
            "2. NON je ne le souhaite pas \n"+
            "choisissez une option ";
        System.out.println(optionText);
        int choix=Interaction.automatedChoice(2, j.getAutomated());
            if(choix==1) {
            // if(false) { // @audit remove this
                
            }
            else {
                System.out.println("--------    Arrete toi ici      -----------");
                boolean witness=true;
                do {
                System.out.println("vous avez "+j.nbPieces()+" pieces d'or");
                afficherQuartierDansLaMain(j);
                String reason=j.peutConstruire();
                if(!reason.equals("")) {
                    System.out.println(reason+" \n Votre tour va se terminer entrez o pour continuer");
                    Interaction.lireOuiOuNon();
                    return;
                }
                System.out.println("quel est le quartier que vous voulez construire ? ");
                choix=Interaction.automatedChoice(j.getMain().size(), j.getAutomated());
                Quartier aConstruire=j.getMain().get(choix);
                if(aConstruire.getCout()>j.nbPieces()) System.out.println("vous n'avez pas assez de pièces pour construire ce quartier choississez en un autre");
                else {
                    j.ajouterQuartierDansCite(aConstruire);
                    j.retirerLeQuartierDansMain(choix);
                    j.retirerPieces(aConstruire.getCout());
                    afficherQuartierDansLaCite(j);
                    witness=false;
                }
            } while (witness);
            }
    }

    private void reinitialisationPersonnages() {
        System.out.println("reinitialiation des personnages ");
        JoueurPerso=new Joueur[8];
        for (int i = 0; i < plateauDeJeu.getNombrePersonnages(); i++) {
            plateauDeJeu.getPersonnage(i).reinitialiser();
        }
    }

    private void partieFinie() {
        /**
         * @audit variantes de fin 
         * Les tours se succèdent jusqu’à ce qu’un des joueurs possède une cité complète : c’est à dire une
            cité de 7 quartiers ou plus pour les parties de 4 à 7 joueurs, ou une cité de 8 quartiers pour les
            parties à 2, 3 ou 8 joueurs. On achève alors le tour et la partie est terminée.
         */

        //  @audit use plateauDeJeu.getNombreJoueurs() to get the number of player commited

        for (int i = 0; i <plateauDeJeu.getNombreJoueurs() ; i++) {
            if(!lastTurn && plateauDeJeu.getJoueur(i).nbQuartiersDansCite()>=7) {
                firstPlayer=plateauDeJeu.getJoueur(i).getNom();
                lastTurn=true;
            }
        }
    }
    private int[] calculDesPoints() {
        /**
         * À l’issue de la partie, chaque joueur calcule ses points en additionnant :
            • la somme totale des coûts de contruction des quartiers de sa cité,
            • 3 points supplémentaires si la cité comprend au moins un quartier de cinq types différents
            (Noble, Commerçant, Religieux, Militaire et Merveille),
            • 4 points supplémentaires s’il est le premier joueur ayant complété sa cité, @audit implement this
            • 2 points supplémentaires si sa cité est complète mais qu’il n’a pas été le premier à la compléter, @audit implement this
            • et enfin la somme des différents bonus éventuels des Merveilles de sa cité.
            Le joueur qui a le score le plus élevé est vainqueur. En cas d’égalité, la victoire revient à celui
            qui a révélé le personnage de rang le plus élevé au dernier tour.
         */

        //  first phase of calcul
        System.out.println("\nCALCUL DES POINTS\n");
        int[] scores=new int[plateauDeJeu.getNombreJoueurs()];
        for (int i = 0; i <plateauDeJeu.getNombreJoueurs() ; i++) {
            ArrayList<String> typesQuartier = new ArrayList<>();
            int s=0;
            Joueur j=plateauDeJeu.getJoueur(i);
            Quartier[] cite=j.getCite();
            for (int c = 0; c < j.nbQuartiersDansCite(); c++) {
                s+=cite[c].getCout();
                if(!typesQuartier.contains(cite[c].getType())) typesQuartier.add(cite[c].getType());
                
            }
            if(typesQuartier.size()==5) s+=3;
            if(j.nbQuartiersDansCite()>=7) {
                if(firstPlayer==j.getNom()) s+=4;
                else s+=2;
            }
            scores[i]=s;
        }
        return scores;
    }

    private void afficherScores(int[] scores) {
        int max=0;
        String winner=null;
        System.out.println("\nTABLEAU DE SCORES \n");
        for (int i = 0; i <plateauDeJeu.getNombreJoueurs() ; i++) {
            System.out.println(plateauDeJeu.getJoueur(i).getNom()+"\t --------------- \t : "+scores[i]);
            if(scores[i]>max) { // @audit do not forget to manage this
                max=scores[i];
                winner=plateauDeJeu.getJoueur(i).getNom();
            }
        }
        System.out.println("\nLE VAINQUEUR DE LA PARTIE EST "+winner);
        System.out.println("\nLA PARTIE A DUREE "+nbTours+" tours de jeu");
        System.out.print("\nVOULEZ VOUS PLUS DE DETAILS ?");
        Boolean details = Interaction.lireOuiOuNon();
        if(details){
            afficherDetailsPartie(scores);
        }
    }

    public void recupererPiece(Joueur d){
        Joueur v=null;  // @audit this can cause error when executing vol function
        for (int i = 0; i < plateauDeJeu.getNombreJoueurs(); i++) {
            if(plateauDeJeu.getJoueur(i).getPersonnage().getNom().equals("Voleur")) v=plateauDeJeu.getJoueur(i);
        }
        Voleur.vol(v, d);
        System.out.println("*******************     VOUS AVEZ ETE VOLE");
    }
    

}
