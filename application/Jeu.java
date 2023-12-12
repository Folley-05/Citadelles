package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import controleur.Interaction;
import modele.Joueur;
import modele.Personnage;
import modele.PlateauDeJeu;
import modele.Quartier;

public class Jeu {

    private PlateauDeJeu plateauDeJeu;
    private int numeroConfiguration;
    private Random generator;
    
    public Jeu(PlateauDeJeu p, int config, Random gen) {
        plateauDeJeu = p;
        numeroConfiguration = config;
        generator = gen;
    }
    public static void main(String[] args) {
        
        Jeu test=new Jeu(null, 0, new Random());
        test.jouer();
    }

    public void jouer() {
        int choix=-1;
        System.out.println("BIENVENUE SUR CITADELLES \n\n");
        System.out.println("vous avez choisi l'option "+choix);
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
                    
                    break;
            
                default:
                    break;
            }
        } while (choix!=2);
    }

    private void afficherLesRegles() {
        System.out.println("CONTINUEZ DE PATIENTER LES RÈGLES ARRIVENT BIENTÔT");
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
        System.out.println("LANCEMENT DE LA PARTIE \n");

        initialisation();

        tourDeJeu();

        gestionCouronne();

        System.out.println("FIN DE PARTIE \n");
    }

    private void initialisation() {
        System.out.println("INITIALISATION DU JEU");
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
        
    }

    private void reinitialisationPersonnages() {
        
    }

    private Boolean partieFinie() {
        
        return true;
    }

    private void tourDeJeu() {
        choixPersonnages();

        for (int i = 0; i < plateauDeJeu.getNombreJoueurs(); i++) {
            Joueur player=plateauDeJeu.getJoueur(i);
            System.out.println(player.getNom()+" --> "+player.getPersonnage().getNom());
        }
    }

    private void choixPersonnages() {
        System.out.println("CHOIX DE PERSONNAGE");
        int nPerso=plateauDeJeu.getNombrePersonnages();
        int c1=Interaction.randomInt(nPerso), c2=(c1+1)%nPerso, c3=(c2+1)%nPerso;
        // declare an empty int table of 5 elements
        List<Personnage> selectable = new ArrayList<Personnage>();
        int choixPerso=-1;
        // Quartier[] selectable=new Quartier[5];
        for (int i = 0; i < plateauDeJeu.getNombrePersonnages(); i++) {
            if(i!=c1&&i!=c2&&i!=c3) {
                Personnage p=plateauDeJeu.getPersonnage(i);
                selectable.add(p);
                // System.out.println(i+"  "+ p.getNom());
            }
        }
        for (int i = 0; i < plateauDeJeu.getNombreJoueurs(); i++) {
        System.out.println("Le personnage  "+ plateauDeJeu.getPersonnage(c1).getNom()+" est posé face visible");
        System.out.println("Le personnage  "+ plateauDeJeu.getPersonnage(c2).getNom()+" est posé face visible");
        System.out.println("Un personnage  est posé face cachée \n");
        
            for (int j = 0; j < selectable.size(); j++) {
                System.out.println(j+"  "+ selectable.get(j).getNom());
            }
            System.out.println("choisissez votre personnage ");
            choixPerso=Interaction.lireUnEntier(0, 5);
            // selectable.remove(choixPerso);
            plateauDeJeu.getJoueur(i).setMonPersonnage(selectable.remove(choixPerso));
            System.out.println("\n");
        }


        
    }

    private void percevoirRessource() {
        
    }

    private void calculDesPoints() {
        
    }

    private int afficherMenu() {
        String menu="\n\t MENU \n\n"+
            "0. AFFICHER LES RÈGLES \n"+
            "1. JOUER UNE PARTIE \n"+
            "2. QUITTER LE JEU \n" +
            "\n\n"+
            "Veuillez choisir une option ";
        System.out.println(menu);

        return Interaction.lireUnEntier(0, 4);
    }


}
