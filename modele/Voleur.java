package modele;

import controleur.Interaction;

import java.util.Random;

public class Voleur extends Personnage{
    public Voleur() { super("Voleur", 2, Caracteristiques.VOLEUR); }

    @Override
    public void utiliserPouvoir() {
        if(this.isValid()){
            int choix;
            // afficher les cibles
            System.out.println("Quel personnage voulez-vous voler ?");
            for (int i = 0; i < this.getPlateau().getNombrePersonnages(); i++) {
                if(this.getPlateau().getPersonnage(i)!= null) {
                    System.out.println((i + 1) + " " + this.getPlateau().getPersonnage(i).getNom());
                }
            }
            //choix de la cible
            do {
                System.out.print("Votre vhoix : ");
                choix = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages()+1);
                if(this.getPlateau().getPersonnage(choix -1).getNom().equals("Voleur"))
                    System.out.println("Vous ne pouvez pas vous voler !!");
                if(this.getPlateau().getPersonnage(choix -1).getRang()==1)
                    System.out.println("Vous ne pouvez pas voler un personnage de rang 1 !!");
            } while (this.getPlateau().getPersonnage(choix -1).getNom().equals("Voleur") ||
                    this.getPlateau().getPersonnage(choix -1).getRang()==1);
            // vol de la cible
            this.getPlateau().getPersonnage(choix - 1).setVole();

            // récupérer les pièces
            /* if(this.getPlateau().getPersonnage(choix -1).getJoueur()!=null) {
                int piece = this.getPlateau().getPersonnage(choix - 1).getJoueur().nbPieces();
                this.getPlateau().getPersonnage(choix - 1).getJoueur().retirerPieces(piece);
                this.getJoueur().ajouterPieces(piece);
            } */

            System.out.println("Le personnage " + this.getPlateau().getPersonnage(choix - 1).getNom() + "a été volé.");
        }
    }
    public void utiliserPouvoirAvatar() {
        if(this.isValid()){
            int choix;
            Random r = new Random();
            do {
                choix = r.nextInt(this.getPlateau().getNombrePersonnages());
            } while (this.getPlateau().getPersonnage(choix -1).getNom().equals("Voleur") ||
                    this.getPlateau().getPersonnage(choix -1).getRang()==1);
            this.getPlateau().getPersonnage(choix).setAssassine();
            System.out.println("Le personnage " + this.getPlateau().getPersonnage(choix).getNom() + "a été volé.");
        }
    }
}
