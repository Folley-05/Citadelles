package modele;

import controleur.Interaction;

import java.util.ArrayList;

public class Magicienne extends Personnage {
    public Magicienne() {
        super("Magicienne", 3, Caracteristiques.MAGICIENNE);
    }
    @Override
    public void utiliserPouvoir() {
        if(this.isValid() && this.getJoueur().nbQuartiersDansMain()!=0) {
            System.out.println("Voulez-vous échanger vos cartes avec celles d'un autre joueur? (o/n)");
            boolean echangeAvecJoueur = Interaction.lireOuiOuNon();
            if (echangeAvecJoueur) {
                // affichage de tous les joueurs sur le plateau
                System.out.println("Choisissez un joueur avec qui echanger : ");
                for (int i = 0; i < this.getPlateau().getNombreJoueurs(); i++) {
                    if (this.getPlateau().getJoueur(i) != null) {
                        System.out.println((i + 1) + " " + this.getPlateau().getJoueur(i).getNom() + " : " + this.getPlateau().getJoueur(i).nbQuartiersDansMain() + " cartes");
                    }
                }
                // choix du joueur
                int choix = Interaction.lireUnEntier(1, this.getPlateau().getNombreJoueurs()+1);
                // copies des mains des deux joueurs
                ArrayList<Quartier> copieMainMagicienne = new ArrayList<>(this.getJoueur().getMain());
                ArrayList<Quartier> copieMainCible = new ArrayList<>(this.getPlateau().getJoueur(choix - 1).getMain());
                // vider les mains des personnages
                this.getJoueur().viderMain();
                this.getPlateau().getJoueur(choix - 1).viderMain();
                // Permuter le contenu des mains
                // ajouter la main de la magicienne dans celle du joueur choisi
                for (int i = 0; i < copieMainMagicienne.size(); i++) { this.getPlateau().getJoueur(choix - 1).ajouterQuartierDansMain(copieMainMagicienne.get(i)); }
                // ajouter la main du joueur choisi dans celle de la magicienne
                for (int i = 0; i < copieMainCible.size(); i++) { this.getJoueur().ajouterQuartierDansMain(copieMainCible.get(i)); }

                System.out.println("Echange éffectué avec " + this.getPlateau().getJoueur(choix - 1).getNom());
            }
            else{
                System.out.println("Combien de cartes voulez-vous prendre dans la pioche : ");
                int nb = Interaction.lireUnEntier(0, this.getJoueur().nbQuartiersDansMain()+1);
                if(nb==0){
                    System.out.println("Aucun changement n'a été éffectué");
                }
                else if (nb==this.getJoueur().nbQuartiersDansMain()){
                    // copie de la main
                    ArrayList<Quartier> copieMainMagicienne = new ArrayList<>(this.getJoueur().getMain());
                    // vider la main
                    this.getJoueur().viderMain();
                    // rajouter les cartes à la pioche
                    for (int i = 0; i < copieMainMagicienne.size(); i++){
                        this.getPlateau().getPioche().ajouter(copieMainMagicienne.get(i));
                    }
                    // piocher des cartes
                    for (int i = 0; i < copieMainMagicienne.size(); i++) {
                        this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
                    }
                }
                else {
                    // copie de la main
                    ArrayList<Quartier> copieMainMagicienne = new ArrayList<>(this.getJoueur().getMain());
                    System.out.println("Liste des quartiers :");
                    for (int j = 0; j<nb; j++) {
                        // afficher toutes le cartes de la main à chaque iteration
                        for (int i = 0; i < copieMainMagicienne.size(); i++) {
                            System.out.println((i + 1) + " " + copieMainMagicienne.get(i).getNom());
                        }
                        System.out.println("Quel carte voulez-vous changer : ");
                        int choix = Interaction.lireUnEntier(0, copieMainMagicienne.size()+1);
                        this.getPlateau().getPioche().ajouter(copieMainMagicienne.get(choix-1));
                        copieMainMagicienne.remove(choix-1);
                    }
                    //vider la main originale
                    this.getJoueur().viderMain();
                    // piocher des cartes
                    for (int i = 0; i < nb; i++) {
                        this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
                    }
                    //ajouter les cartes de la copie dans la main originale
                    for (int i = 0; i < copieMainMagicienne.size(); i++) {
                        this.getJoueur().ajouterQuartierDansMain(copieMainMagicienne.get(i));
                    }
                }
            }
        }
        else if(this.getJoueur().nbQuartiersDansMain()==0){
            System.out.println("Vous ne pouvez pas utiliser votre pouvoir car votre main est vide");
        }
    }
}