package modele;

import controleur.Interaction;

public class Assassin extends Personnage{
    public Assassin() { super("Assassin", 1, Caracteristiques.ASSASSIN); }

    public void utiliserPouvoir(){
        if(this.isValid()){
            int choix;
            PlateauDeJeu plateau=this.getPlateau();
            // afficher les cibles
            System.out.println("Quel personnage voulez-vous assassiner ?");
            for (int i = 0; i < plateau.getNombrePersonnages(); i++) {
                if(plateau.getPersonnage(i)!= null) {
                    System.out.println((i + 1) + " " + plateau.getPersonnage(i).getNom());
                }
            }
            //choix de la cible
            do {
                System.out.print("Votre vhoix : ");
                // choix = Interaction.lireUnEntier(1, plateau.getNombrePersonnages()+1);
                choix=Interaction.automatedChoice(plateau.getNombreJoueurs(), true);
                if(plateau.getPersonnage(choix -1).getNom().equals("Assassin"))
                    System.out.println("Vous ne pouvez pas vous assassiner !!");
            } while (plateau.getPersonnage(choix -1).getNom().equals("Assassin"));
            // assassinat de la cible
            plateau.getPersonnage(choix - 1).setAssassine();
        }
    }
}