package application;

import controleur.Interaction;
import modele.*;

import java.util.Random;

public class Configuration {

    static String typeReligieux = Quartier.TYPE_QUARTIERS[0];
    static String typeMilitaire = Quartier.TYPE_QUARTIERS[1];
    static String typeNoble = Quartier.TYPE_QUARTIERS[2];
    static String typeCommercant = Quartier.TYPE_QUARTIERS[3];
    static String typeMerveille = Quartier.TYPE_QUARTIERS[4];

    public static Pioche nouvellePioche(){
        Pioche pioche = null;
/*
        Random random = new Random();
        int index = random.nextInt(Quartier.TYPE_QUARTIERS.length);
        String type = Quartier.TYPE_QUARTIERS[index];
        int cout = random.nextInt(9) + 2;
        cout*=5;*/




        for(int rang=2; rang<=5; rang++){

            if(rang==2){
                //We create district of rank 2
                for(int i=0; i<rang; i++){
                    Quartier cathedrale = new Quartier("cathédrale", typeReligieux, 5);
                    pioche.ajouter(cathedrale);
                    Quartier forteresse = new Quartier("forteresse", typeMilitaire, 5);
                    pioche.ajouter(forteresse);
                    Quartier hotel  = new Quartier("hotel de ville", typeCommercant, 5);
                    pioche.ajouter(hotel);
                }

            }

            else if(rang==3){
                //We create district of rank 3
                for(int i=0; i<rang; i++){
                    Quartier temple = new Quartier("temple", typeReligieux, 1);
                    pioche.ajouter(temple);
                    Quartier eglise = new Quartier("eglise", typeReligieux, 2);
                    pioche.ajouter(eglise);
                    Quartier monastere = new Quartier("monastère", typeReligieux, 3);
                    pioche.ajouter(monastere);
                    Quartier tour = new Quartier("tour de guet", typeMilitaire, 1);
                    pioche.ajouter(tour);
                    Quartier prison = new Quartier("prison", typeMilitaire, 2);
                    pioche.ajouter(prison);
                    Quartier caserne = new Quartier("caserne", typeMilitaire, 3);
                    pioche.ajouter(caserne);
                    Quartier palais = new Quartier("palais", typeNoble, 5);
                    pioche.ajouter(palais);
                    Quartier echoppe = new Quartier("echoppe", typeCommercant, 2);
                    pioche.ajouter(echoppe);
                    Quartier comptoir  = new Quartier("comptoir", typeCommercant, 3);
                    pioche.ajouter(comptoir);
                    Quartier port  = new Quartier("port", typeCommercant, 4);
                    pioche.ajouter(port);
                }

            }
            else if(rang==4){
                //We create district of rank 4
                for(int i=0; i<rang; i++){
                    Quartier marche  = new Quartier("marché", typeCommercant, 2);
                    pioche.ajouter(marche);
                    Quartier chateau = new Quartier("chateau", typeNoble, 4);
                    pioche.ajouter(chateau);
                }
            }
            if(rang==5){
                //We create district of rank 5
                for(int i=0; i<5; i++){
                    Quartier manoir  = new Quartier("manoir", typeNoble, 3);
                    pioche.ajouter(manoir);
                    Quartier taverne = new Quartier("taverne", typeCommercant , 1);
                    pioche.ajouter(taverne);
                }
            }
        }

        return pioche;

    }

    public static PlateauDeJeu configurationDeBase(Pioche pioche){

        PlateauDeJeu plateau = new PlateauDeJeu();

        //We create the 08 characters
        plateau.ajouterPersonnage(new Architecte());
        plateau.ajouterPersonnage(new Assassin());
        plateau.ajouterPersonnage(new Condottiere());
        plateau.ajouterPersonnage(new Eveque());
        plateau.ajouterPersonnage(new Magicienne());
        plateau.ajouterPersonnage(new Marchande());
        plateau.ajouterPersonnage(new Roi());
        plateau.ajouterPersonnage(new Voleur());

        //We add players
        for (int i = 0; i < 4; i++) {
            System.out.println("Entrez le nom du joueur "+(i+1)+" ");
            String name= Interaction.lireUneChaine();
            Joueur j=new Joueur(name);
            plateau.ajouterJoueur(j);
        }

        //We add the 14 Marvels
        Quartier Bibliotheque = new Quartier("Bibliotheque", typeMerveille, 6);
        pioche.ajouter(Bibliotheque);
        Quartier Carriere = new Quartier("Carriere", typeMerveille, 5);
        pioche.ajouter(Carriere);
        Quartier Cour = new Quartier("Cours des Miracles", typeMerveille, 2);
        pioche.ajouter(Cour);
        Quartier Donjon = new Quartier("Donjon", typeMerveille, 3);
        pioche.ajouter(Donjon );
        Quartier Dracoport = new Quartier("Dracoport", typeMerveille, 6);
        pioche.ajouter(Dracoport);
        Quartier Ecole = new Quartier("Ecole de Magie", typeMerveille, 6);
        pioche.ajouter(Ecole);
        Quartier Fontaine= new Quartier("Fontaine", typeMerveille, 5);
        pioche.ajouter(Fontaine);
        Quartier Forge = new Quartier("Forge", typeMerveille, 5);
        pioche.ajouter(Forge);
        Quartier Laboratoire = new Quartier("Laboratoire", typeMerveille, 5);
        pioche.ajouter(Laboratoire);
        Quartier Manufacture = new Quartier("Manufacture", typeMerveille, 5);
        pioche.ajouter(Manufacture);
        Quartier Salle = new Quartier("Salle des Cartes", typeMerveille, 5);
        pioche.ajouter(Salle);
        Quartier Statue = new Quartier("Statue Equestre", typeMerveille, 3);
        pioche.ajouter(Statue);
        Quartier Tresor = new Quartier("Trésor Impérial", typeMerveille, 5);
        pioche.ajouter(Tresor);
        Quartier Tripot = new Quartier("Tripot", typeMerveille, 6);
        pioche.ajouter(Tripot);

        return plateau;

    }
}
