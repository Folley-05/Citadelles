package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controleur.Interaction;
import modele.Joueur;
import modele.Personnage;
import modele.PlateauDeJeu;
import modele.Quartier;

public class Jeu {

    private PlateauDeJeu plateauDeJeu;
    private int numeroConfiguration, nbTours;
    private Random generator;
    private Joueur JoueurPerso[];
    private String firstPlayer;
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
        System.out.println("\nCONTINUEZ DE PATIENTER LES RÈGLES ARRIVENT BIENTÔT");
    }

    private void afficherDetailsPartie() {
        for(int i=0; i<this.plateauDeJeu.getNombreJoueurs(); i++){
            System.out.println("JOUEUR "+ i+1 +" : "+ this.plateauDeJeu.getJoueur(i).getNom());
            System.out.println("Nombre de pieces : "+ this.plateauDeJeu.getJoueur(i).nbPieces());
            // TODO Implemente affichage du score final
            this.plateauDeJeu.getJoueur(i).afficherQuartierDansCite();
        }
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
        System.out.println("nombre de cartes dans la pioche "+ plateauDeJeu.getPioche().nombreElements());
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
            crown=(crown+1)%nbJoueurs;
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
            JoueurPerso=new Joueur[8];
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
            System.out.println(textToPrint);
        
            for (int j = 0; j < selectable.size(); j++) {
                System.out.println((j+1)+"  "+ selectable.get(j).getNom());
            }
            System.out.println(plateauDeJeu.getJoueur(correctIndice).getNom()+" choisissez votre personnage ");
            // choixPerso=Interaction.lireUnEntier(0, 5); @audit active this to allow player to select his character
            // choixPerso=Interaction.randomInt(selectable.size());
            choixPerso=Interaction.automatedChoice(selectable.size(), true);
            plateauDeJeu.getJoueur(correctIndice).setMonPersonnage(selectable.remove(choixPerso));
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

    private void appelerPersonnage() {
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
                Thread.sleep(500);
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

                // construire
                construireQuartier(j);
                
            break;
            case "Voleur":
                System.out.println("Le personnage a le joueur : VOLEUR");
                percevoirRessource(j);


                construireQuartier(j);
                
            break;
            case "Magicienne":
                System.out.println("Le personnage a le joueur : MAGICIENNE");
                percevoirRessource(j);
                
                construireQuartier(j);
                
            break;
            case "Roi":
                System.out.println("Le personnage a le joueur : ROI");
                percevoirRessource(j);
                
                construireQuartier(j);
                
            break;
            case "Eveque":
                System.out.println("Le personnage a le joueur : EVEQUE");
                percevoirRessource(j);
                
                construireQuartier(j);
                
            break;
            case "Marchande":
                System.out.println("Le personnage a le joueur : MARCHANDE");
                percevoirRessource(j);
                
                construireQuartier(j);
                
            break;
            case "Architecte":
                System.out.println("Le personnage a le joueur : ACHITECTE");
                percevoirRessource(j);
                
                construireQuartier(j);
                
            break;
            case "Condotierre":
                System.out.println("Le personnage a le joueur : CONDOTIERE");
                percevoirRessource(j);
                
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
        int choix=Interaction.automatedChoice(2, true);
        if(choix<1) { // @audit do not forget do manage that part
            System.out.println("\nVOUS AVEZ CHOISI DE RECEVOIR DEUX PIECES D'OR");
            j.ajouterPieces(5); // @audit set 2 here
            System.out.println("votre tresor est maintenant de "+j.nbPieces()+" pieces d'or");
        }
        else {
            System.out.println("\nVOUS AVEZ CHOISI DE PIOCHER DEUX CARTES");
            Quartier q1=plateauDeJeu.getPioche().piocher(), q2=plateauDeJeu.getPioche().piocher();
            System.out.println("voici les cartes que vous avez piocher");
            System.out.println("1. "+q1.getNom()+ " de type "+q1.getType()+" coutant "+q1.getCout()+" pieces d'or");
            System.out.println("1. "+q2.getNom()+ " de type "+q2.getType()+" coutant "+q2.getCout()+" pieces d'or");
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
        int choix=Interaction.automatedChoice(2, true);
            if(choix<1) {
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
                    afficherQuartierDansLaCite(j);
                    witness=false;
                }
            } while (witness);
            }
    }

    private void reinitialisationPersonnages() {
        
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

    }

    
// @audit found an infinite loop in the program try to check what causes it
}
