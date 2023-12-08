package modele;

import controleur.Interaction;

public class Magicienne extends Personnage {
    public Magicienne() {
        super("Magicienne", 3, Caracteristiques.MAGICIENNE);
    }
    @Override
    public void utiliserPouvoir() {
        System.out.println("Voulez-vous échanger vos cartes avec celles d'un autre joueur? (o/n)");
        boolean echangeAvecJoueur = Interaction.lireOuiOuNon();
        if(echangeAvecJoueur){
            // affichage de tous les joueurs

        }

    }
}