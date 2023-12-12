package modele;

import controleur.Interaction;

import java.util.Random;

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
            boolean goon=true;
            do {
                System.out.print("Votre vhoix : ");
                // choix = Interaction.lireUnEntier(1, plateau.getNombrePersonnages()+1);
                choix=Interaction.automatedChoice(plateau.getNombreJoueurs(), true);
                if(plateau.getPersonnage(choix).getNom().equals("Assassin"))
                    System.out.println("Vous ne pouvez pas vous assassiner !!");
                else goon=false;
            } while (goon);
            // assassinat de la cible
            this.getPlateau().getPersonnage(choix).setAssassine();
            System.out.println("Le personnage " + this.getPlateau().getPersonnage(choix).getNom() + " a �t� assassin�.");
        }
    }

    @Override
    public void utiliserPouvoirAvatar() {
        if(this.isValid()) {
            int choix;
            Random r = new Random();
            do {
                choix = r.nextInt(this.getPlateau().getNombrePersonnages());
            } while (this.getPlateau().getPersonnage(choix).getNom().equals("Assassin"));
            this.getPlateau().getPersonnage(choix).setAssassine();
            System.out.println("Le personnage " + this.getPlateau().getPersonnage(choix).getNom() + "a �t� assassin�.");
        }
    }
}