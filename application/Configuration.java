package application;

import controleur.Interaction;
import modele.Architecte;
import modele.Assassin;
import modele.Condottiere;
import modele.Eveque;
import modele.Joueur;
import modele.Magicienne;
import modele.Marchande;
import modele.Pioche;
import modele.PlateauDeJeu;
import modele.Quartier;
import modele.Roi;
import modele.Voleur;

public class Configuration {

  public static void main(String[] args) {
      nouvellePioche();
      System.out.println("Hello configuration \n" + (int) (Math.random() * 4));
  }

  public static Pioche nouvellePioche() {
    Pioche pioche = new Pioche();
    // create a loop with 54 rounds
    for (int i = 0; i < 54; i++) {
      // create a code to generate a random int include between 0 and 4
      int random = (int) (Math.random() * 5);
      pioche.ajouter(
        new Quartier(
          "Quartier " + (i + 1),
          Quartier.TYPE_QUARTIERS[random],
          random * 5
        )
      );
    }

    // pioche.ajouter();
    return pioche;
  }

  public static PlateauDeJeu configurationDeBase(Pioche pioche) {
    PlateauDeJeu plateau = new PlateauDeJeu();
    plateau.ajouterPersonnage(new Architecte());
    plateau.ajouterPersonnage(new Assassin());
    plateau.ajouterPersonnage(new Condottiere());
    plateau.ajouterPersonnage(new Eveque());
    plateau.ajouterPersonnage(new Magicienne());
    plateau.ajouterPersonnage(new Marchande());
    plateau.ajouterPersonnage(new Roi());
    plateau.ajouterPersonnage(new Voleur());
    for (int i = 0; i < 4; i++) {
        // System.out.println("Entrez le nom du joueur "+(i+1)+" ");
        // String name=Interaction.lireUneChaine();
        Joueur j=new Joueur("player "+i);
        plateau.ajouterJoueur(j);
    }
    return plateau;
  }
}
