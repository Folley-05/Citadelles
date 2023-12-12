package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controleur.Interaction;
import modele.Joueur;
import modele.Personnage;
import modele.PlateauDeJeu;
import modele.Quartier;
import modele.Voleur;

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
        System.out.println("\n1. Objectif du jeu\n2.Personnages \n3.Tour des Joueurs \n4.Fin du jeu \n5.Retour au menu ");
        choixregle=Interaction.lireUnEntier();
        do{switch(choixregle){
            case 1:
                System.out.println("\nObjectif du jeu\n");
                System.out.println("Deux \u0012a huit joueurs s'a\u000Brontent pour construire le plus rapidement possible la plus prestigieuse\n" +
                        "cit\u0013e. Pour cela, chaque joueur devra construire des quartiers, ayant chacun des co^uts di\u000B\u0013erents.\n" +
                        "Comme dans un jeu de r^ole, chaque joueur doit se mettre dans la peau d'un personnage, \u0012a ceci\n" +
                        "pr\u0012es que les joueurs changent de personnage \u0012a chaque tour de jeu. Ces personnages ont chacun des\n" +
                        "pouvoirs particuliers : la meilleure stat\u0013egie est de choisir un personnage au bon moment du jeu.");
                break;
            case 2:
                System.out.println("\nPersonnage\n" +
                        "\n" +
                        "Assassin : Annoncez le personnage que vous assassinez. Si un joueur a ce personnage, il ne doit\n" +
                        "pas r\u0013eagir tout de suite, mais lorsque le personnage assassin\u0013e sera appel\u0013e. Le personnage\n" +
                        "assassin\u0013e passe son tour.\n"+
                        "\n"+
                        "Voleur : Annoncez le personnage que vous volez. Si un joueur a ce personnage, il ne doit pas\n" +
                        "r\u0013eagir. Lorsque le personnage vol\u0013e sera appel\u0013e et r\u0013ev\u0013el\u0013e, vous lui prendrez toutes ces pi\u0012eces\n" +
                        "d'or. Vous ne pouvez voler ni le personnage de rang 1 (Assassin, Sorci\u0012ere ou \u0013Echevin), ni le\n" +
                        "personnage assassin\u0013e ou ensorcel\u0013e.\n"+
                        "\n"+
                        "Magicienne: Vous pouvez au choix :\n" +
                        "  soit echanger toutes les cartes de votre main avec celles d'un autre joueur ; si vous n'avez\n" +
                        "aucune carte en main, vous prenez simplement les cartes de l'autre joueur,\n" +
                        "  soit defausser un certain nombre de cartes de votre main, les placer sous la pioche et\n" +
                        "piocher le meme nombre de cartes du dessus de la pioche.\n"+
                        "\n"+
                        "Roi: Recevez une pi\u0012ece d'or pour chaque quartier Noble dans votre cit\u0013e.\n" +
                        "Vous devez prendre la Couronne. C'est d\u0013esormais vous qui appelerez les personnages. En\n" +
                        "outre, au prochain tour, et aux tours suivants jusqu'\u0012a ce qu'un autre joueur r\u0013ev\u0012ele le Roi,\n" +
                        "vous choisirez votre personnage en premier.\n" +
                        "Si vous ^etes assassin\u0013e, vous passez votre tour comme n'importe quel personnage. N\u0013eanmoins,\n" +
                        "apr\u0012es que tous les autres joueurs ont jou\u0013e, vous r\u0013ev\u0013elez que vous aviez choisi le Roi et, en\n" +
                        "tant qu'h\u0013eritier du Roi assassin\u0013e, prenez la Couronne.\n" +
                        "Si vous ^etes ensorcel\u0013e, vous prenez quand m^eme la Couronne.\n" +
                        "Si le Roi est \u0013ecart\u0013e face visible en d\u0013ebut de tour, remplacez-le par le personnage suivant et\n" +
                        "m\u0013elangez-le avec les personnages restants.\n"+
                        "\u0013Ev^eque: Recevez 1 pi\u0012ece d'or pour chaque quartier religieux dans votre cit\u0013e.\n" +
                        "Vos quartiers ne peuvent pas ^etre a\u000Bect\u0013es par les pouvoirs des personnages de rang 8 (Condot-\n" +
                        "tiere, Diplomate, Capitaine).\n" +
                        "Si vous ^etes assassin\u0013e, vous n'^etes plus \u0013Ev^eque ; vous ^etes mort, et vos Quartiers peuvent\n" +
                        "donc ^etre la cible des personnages de rang 8. De m^eme, si vous ^etes ensorcel\u0013e, les quartiers\n" +
                        "de la Sorci\u0012ere sont prot\u0013eg\u0013es contre les personnages de rang 8, mais pas les v^otres.\n"+
                        "\n"+
                        "Ev^eque : Recevez 1 pi\u0012ece d'or pour chaque quartier religieux dans votre cit\u0013e.\n" +
                        "Vos quartiers ne peuvent pas ^etre a\u000Bect\u0013es par les pouvoirs des personnages de rang 8 (Condot-\n" +
                        "tiere, Diplomate, Capitaine).\n" +
                        "Si vous ^etes assassin\u0013e, vous n'^etes plus \u0013Ev^eque ; vous ^etes mort, et vos Quartiers peuvent\n" +
                        "donc ^etre la cible des personnages de rang 8. De m^eme, si vous ^etes ensorcel\u0013e, les quartiers\n"+
                        "\n"+
                        "Marchande :Recevez 1 pi\u0012ece d'or pour chaque quartier Commer\u0018cant dans votre cit\u0013e.\n" +
                        "Recevez 1 pi\u0012ece d'or suppl\u0013ementaire quel que soit le type de ressources (pi\u0012ece d'or ou carte)\n" +
                        "que vous avez prises au d\u0013ebut de votre tour.\n "+
                        "\n"+
                        "Architecte: Piochez 2 cartes Quartier et ajoutez-les \u0012a votre main.\n" +
                        "Vous pouvez b^atir jusqu'\u0012a 3 quartiers durant votre tour.\n"+
                        "\n"+
                        "Condottiere :Recevez 1 pi\u0012ece d'or pour chaque quartier Militaire dans votre cit\u0013e.\n" +
                        "Vous pouvez d\u0013etruire un quartier de votre choix dans une cit\u0013e en payant son co^ut de construc-\n" +
                        "tion moins 1. Vous pouvez donc d\u0013etruire gratuitement un quartier de co^ut 1, ou payer 1 pi\u0012ece\n" +
                        "d'or pour d\u0013etruire un quartier de co^ut 2, etc.\n" +
                        "Vous ne pouvez d\u0013etruire un quartier d'une cit\u0013e d\u0013ej\u0012a compl\u0012ete. Vous pouvez d\u0013etruire l'un de\n" +
                        "vos propres quartiers. Les quartiers d\u0013etruits sont d\u0013efauss\u0013es, face cach\u0013ee, en dessous de la\n" +
                        "pioche.\n"+
                        "\n");
                break;
            case 3:
                System.out.println("\nTour des joueurs\n" +
                        "Les tours des joueurs ne se succ\u0012edent pas dans le sens habituel des aiguilles d'une montre, mais\n" +
                        "dans l'ordre croissant des rangs des Personnages. Dans le jeu de plateau, le joueur qui d\u0013etient\n" +
                        "la Couronne appelle les Personnages les uns apr\u0012es les autres en commen\u0018cant donc par le rang 1\n" +
                        "(Assassin, Sorci\u0012ere ou \u0013Echevin), et ainsi de suite. Dans cette version \u0013electronique, c'est l'application\n" +
                        "qui appelera les Personnages.\n" +
                        "Lorsqu'un Personnage est appel\u0013e, le joueur qui l'a choisi r\u0013ev\u0012ele la carte Personnage et commence\n" +
                        "\u0012a jouer. Chaque joueur :\n" +
                        "1. re\u0018coit des ressources en choisissant :\n" +
                        "| soit de recevoir 2 pi\u0012eces d'or de la banque, ou\n" +
                        "| soit de piocher 2 cartes Quartier, en conserver une et remettre l'autre sous la pioche.\n" +
                        "2. puis (de mani\u0012ere indi\u000B\u0013erente si aucune pr\u0013ecision n'est indiqu\u0013ee) :\n" +
                        "| re\u0018coit les ressources sp\u0013eci\fques \u0012a son Personnage, ainsi que les ressources que lui procure\n" +
                        "les Merveilles de sa cit\u0013e,\n" +
                        "| utilise le pouvoir de son Personnage,\n" +
                        "| et peut b^atir ou non un quartier dans sa cit\u0013e en payant son co^ut de construction.\n" +
                        "Le joueur ne peut utiliser son pouvoir qu'une seule fois par tour. De la m^eme mani\u0012ere, le joueur\n" +
                        "ne peut b^atir qu'un seul quartier par tour (sauf indication contraire) et ne peut pas b^atir deux fois\n" +
                        "le m^eme quartier de m^eme nom (sauf indication contraire).");
                break;
            case 4:
                System.out.println("\nFin de la partie\n" +
                        "Les tours se succ\u0012edent jusqu'\u0012a ce qu'un des joueurs poss\u0012ede une cit\u0013e compl\u0012ete : c'est \u0012a dire une\n" +
                        "cit\u0013e de 7 quartiers ou plus pour les parties de 4 \u0012a 7 joueurs, ou une cit\u0013e de 8 quartiers pour les\n" +
                        "parties a 2, 3 ou 8 joueurs. On ach\u0012eve alors le tour et la partie est termin\u0013ee.\n" +
                        "6 Le calcul des points\n" +
                        "A\n" +
                        "l'issue de la partie, chaque joueur calcule ses points en additionnant :\n" +
                        "la somme totale des co^uts de contruction des quartiers de sa cit\u0013e,\n" +
                        "3 points suppl\u0013ementaires si la cit\u0013e comprend au moins un quartier de cinq types differents\n" +
                        "(Noble, Commer\u0018cant, Religieux, Militaire et Merveille),\n" +
                        "4 points supplementaires s'il est le premier joueur ayant compl\u0013et\u0013e sa cite,\n" +
                        "2 points suppl\u0013ementaires si sa cite est complete mais qu'il n'a pas \u0013et\u0013e le premier \u0012a la completer,\n" +
                        "et enfin la somme des differents bonus eventuels des Merveilles de sa cite.\n" +
                        "Le joueur qui a le score le plus eleve est vainqueur. En cas d'egalite, la victoire revient a celui\n" +
                        "qui a revele le personnage de rang le plus eleve au dernier tour.");
                break;
            case 5:
                System.out.println("\nFERMETURE \n\n");
                afficherMenu();

                break;

            default:
                break;


        }
        }while(choixregle!=5);


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
            int choix=Interaction.automatedChoice(nbJoueurs, true);
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
            System.out.println(plateauDeJeu.getJoueur(correctIndice).getNom()+" choisissez votre personnage ");
            // choixPerso=Interaction.lireUnEntier(0, 5); @audit active this to allow player to select his character
            choixPerso=Interaction.automatedChoice(selectable.size(), true);
            Personnage perso=selectable.remove(choixPerso);
            perso.setJoueur(plateauDeJeu.getJoueur(correctIndice));
            plateauDeJeu.getJoueur(correctIndice).setMonPersonnage(perso);
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
                System.out.println("PPPPPPPPPPPPPPPPPPPPPPPP  utilisation de pouvoir PPPPPPPPPPPPPPPPPPPPPPPP+");
                j.getPersonnage().utiliserPouvoirAvatar();
                // construire
                construireQuartier(j);
                
            break;
            case "Voleur":
                System.out.println("Le personnage a le joueur : VOLEUR");
                percevoirRessource(j);
                if(!j.getPersonnage().isValid()) {
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX  personnage mort");
                    break;
                }
                System.out.println("PPPPPPPPPPPPPPPPPPPPPPPP  utilisation de pouvoir PPPPPPPPPPPPPPPPPPPPPPPP");
                j.getPersonnage().utiliserPouvoirAvatar();
                construireQuartier(j);
                
            break;
            case "Magicienne":
                System.out.println("Le personnage a le joueur : MAGICIENNE");
                percevoirRessource(j);
                if(!j.getPersonnage().isValid()) {
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX  personnage mort");
                    break;
                }
                if(j.getPersonnage().getVole()) recupererPiece(j);
                j.getPersonnage().utiliserPouvoirAvatar();
                construireQuartier(j);
                
            break;
            case "Roi":
                System.out.println("Le personnage a le joueur : ROI");
                percevoirRessource(j);
                if(!j.getPersonnage().isValid()) {
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX  personnage mort");
                    break;
                }
                if(j.getPersonnage().getVole()) recupererPiece(j);
                j.getPersonnage().utiliserPouvoirAvatar();
                if(j.getPossedeCouronne()) {
                    nextKing=j.getNom();
                    System.out.println("LE PROCHAIN ROI SERA "+j.getNom());
                }
                construireQuartier(j);
                
            break;
            case "Eveque":
                System.out.println("Le personnage a le joueur : EVEQUE");
                percevoirRessource(j);
                if(!j.getPersonnage().isValid()) {
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX  personnage mort");
                    break;
                }
                if(j.getPersonnage().getVole()) recupererPiece(j);
                j.getPersonnage().utiliserPouvoirAvatar();
                construireQuartier(j);
                
            break;
            case "Marchande":
                System.out.println("Le personnage a le joueur : MARCHANDE");
                percevoirRessource(j);
                if(!j.getPersonnage().isValid()) {
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX  personnage mort");
                    break;
                }
                if(j.getPersonnage().getVole()) recupererPiece(j);
                System.out.println("PPPPPPPPPPPPPPPPPPPPPPPP  utilisation de pouvoir PPPPPPPPPPPPPPPPPPPPPPPP");
                j.getPersonnage().utiliserPouvoirAvatar();
                construireQuartier(j);
                
            break;
            case "Architecte":
                System.out.println("Le personnage a le joueur : ACHITECTE");
                percevoirRessource(j);
                if(!j.getPersonnage().isValid()) {
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX  personnage mort");
                    break;
                }
                if(j.getPersonnage().getVole()) recupererPiece(j);
                // j.getPersonnage().utiliserPouvoir(); @audit
                construireQuartier(j);
                
            break;
            case "Condotierre":
                System.out.println("Le personnage a le joueur : CONDOTIERRE");
                percevoirRessource(j);
                if(!j.getPersonnage().isValid()) {
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX  personnage mort");
                    break;
                }
                if(j.getPersonnage().getVole()) recupererPiece(j);
                System.out.println("PPPPPPPPPPPPPPPPPPPPPPPP  utilisation de pouvoir PPPPPPPPPPPPPPPPPPPPPPPP");
                j.getPersonnage().utiliserPouvoirAvatar();
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
        // System.out.println(optionsText);
        int choix=Interaction.automatedChoice(2, true);
        if(choix<1) { // @audit do not forget do manage that part
            System.out.println("\nVOUS AVEZ CHOISI DE RECEVOIR DEUX PIECES D'OR");
            j.ajouterPieces(2); // @audit set 2 here
            System.out.println("votre tresor est maintenant de "+j.nbPieces()+" pieces d'or");
        }
        else {
            System.out.println("\nVOUS AVEZ CHOISI DE PIOCHER DEUX CARTES");
            Quartier q1=plateauDeJeu.getPioche().piocher(), q2=plateauDeJeu.getPioche().piocher();
            // System.out.println("voici les cartes que vous avez piocher");
            // System.out.println("1. "+q1.getNom()+ " de type "+q1.getType()+" coutant "+q1.getCout()+" pieces d'or");
            // System.out.println("1. "+q2.getNom()+ " de type "+q2.getType()+" coutant "+q2.getCout()+" pieces d'or");
            System.out.println("choisissez celle que vous souhaitez conserver ");
            choix=Interaction.automatedChoice(2, true);
            if(choix<1) {
                plateauDeJeu.getPioche().ajouter(q2);
                j.ajouterQuartierDansMain(q1);
            }
            else {
                plateauDeJeu.getPioche().ajouter(q1);
                j.ajouterQuartierDansMain(q2);
            }
            // afficherQuartierDansLaMain(j);
            
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
        int choix=Interaction.automatedChoice(2, true);
            if(choix<1) {
            // if(false) { // @audit remove this
                
            }
            else {
                System.out.println("--------    Arrete toi ici      -----------");
                boolean witness=true;
                do {
                System.out.println("vous avez "+j.nbPieces()+" pieces d'or");
                // afficherQuartierDansLaMain(j);
                String reason=j.peutConstruire();
                if(!reason.equals("")) {
                    System.out.println(reason+" \n Votre tour se termine");
                    return;
                }
                System.out.println("quel est le quartier que vous voulez construire ? ");
                choix=Interaction.automatedChoice(j.getMain().size(), true);
                Quartier aConstruire=j.getMain().get(choix);
                if(aConstruire.getCout()>j.nbPieces()) System.out.println("vous n'avez pas assez de pièces pour construire ce quartier choississez en un autre");
                else {
                    j.ajouterQuartierDansCite(aConstruire);
                    j.retirerLeQuartierDansMain(choix);
                    j.retirerPieces(aConstruire.getCout());
                    // afficherQuartierDansLaCite(j);
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
    
// @audit found an infinite loop in the program try to check what causes it

// @audit handle the case where there is no more quartier in the pioche

// @audit do not forget to implement the fact that we can't steal a player murderd
}
