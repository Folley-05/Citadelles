package modele;

import controleur.Interaction;

public class Assassin extends Personnage{
    public Assassin() { super("Assassin", 1, Caracteristiques.ASSASSIN); }

    public void utiliserPouvoir(){
        if(this.isValid()){
            int choix;
            // afficher les cibles
            System.out.println("Quel personnage voulez-vous assassiner ?");
            for (int i = 0; i < this.getPlateau().getNombrePersonnages(); i++) {
                if(this.getPlateau().getPersonnage(i)!= null) {
                    System.out.println((i + 1) + " " + this.getPlateau().getPersonnage(i).getNom());
                }
            }
            //choix de la cible
            do {
                System.out.print("Votre vhoix : ");
                choix = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages()+1);
                if(this.getPlateau().getPersonnage(choix -1).getNom().equals("Assassin"))
                    System.out.println("Vous ne pouvez pas vous assassiner !!");
            } while (this.getPlateau().getPersonnage(choix -1).getNom().equals("Assassin"));
            // assassinat de la cible
            this.getPlateau().getPersonnage(choix - 1).setAssassine();
        }
    }
}