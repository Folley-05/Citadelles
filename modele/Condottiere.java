package modele;

import java.util.ArrayList;

import controleur.Interaction;

public class Condottiere extends Personnage {

    public Condottiere() {
        super("Condotierre", 8, Caracteristiques.CONDOTTIERE);
    }

    // Utilisation du pouvoir par un joueur humain
    public void utiliserPouvoir() {
        int choixPersonnage;
        int	choixQuartier=0;
        String nomQuartier =null;
        boolean choix;
        ArrayList<Personnage> listePersonnage = new ArrayList<>(this.getPlateau().getNombreJoueurs());
        for(int i=0; i<this.getPlateau().getNombrePersonnages(); i++) {
            if(this.getPlateau().getPersonnage(i).getJoueur()!= null && this.getPlateau().getPersonnage(i) != null && this.getPlateau().getPersonnage(i).getJoueur().nbQuartiersDansCite()<7) {
                listePersonnage.add(this.getPlateau().getPersonnage(i));
            }
        }
        System.out.println("Voulez-vous utiliser votre pouvoir de destruction ?");
        choix=Interaction.lireOuiOuNon();
        if (choix) {
            do {
                System.out.println("Voici la liste des joueurs et le contenu de leur cit� :");
                for(int i=0; i<listePersonnage.size(); i++) {
                    System.out.print("\n"+ (i+1) + " " + listePersonnage.get(i).getNom() + ": ");
                    for (int j = 0; j < listePersonnage.get(i).getJoueur().nbQuartiersDansCite(); j++) {
                        System.out.print(j + 1 + " " + listePersonnage.get(i).getJoueur().getCite()[j].getNom() + "(co�t "+ listePersonnage.get(i).getJoueur().getCite()[j].getCout() + "), ");
                    }
                }
                System.out.println("\n\nPour Information, vous avez "+getJoueur().nbPieces()+" pi�ces d'or dans votre tr�sor");
                System.out.println("\nQuel joueur choississez-vous ?( 0 pour annuler )");
                choixPersonnage = Interaction.lireUnEntier(0, listePersonnage.size()+1);
                if(choixPersonnage==0) {
                    System.out.println("Vous n'utilisez pas votre pouvoir de destruction");
                    break;
                }else if(listePersonnage.get(choixPersonnage-1).getNom().equals("Eveque") && !listePersonnage.get(choixPersonnage-1).getAssassine()){
                    System.out.println("L'�v�que est vivant vous ne pouvez pas le selectionner");
                }else {
                    do {
                        System.out.println("Quel quartier choisissez-vous ? (0 pour annuler)");
                        choixQuartier = Interaction.lireUnEntier(0,listePersonnage.get(choixPersonnage-1).getJoueur().nbQuartiersDansCite()+1);
                        if(choixQuartier==0) { // L'index 0 correspond � la libert� de ne pas continuer
                            System.out.println("Vous annulez le choix du quartier");
                            break;
                        }else if((listePersonnage.get(choixPersonnage-1).getJoueur().getCite()[choixQuartier-1].getCout() - 1) > this.getJoueur().nbPieces()) {
                            System.out.println("Pas assez d'argent pour d�truire ce quartier");
                        }else if(listePersonnage.get(choixPersonnage-1).getJoueur().getCite()[choixQuartier-1].getNom().equals("Donjon")) {
                            System.out.println("Le Donjon n'est pas destructible");
                        }
                    }while(listePersonnage.get(choixPersonnage-1).getJoueur().getCite()[choixQuartier-1].getCout() - 1 > this.getJoueur().nbPieces()|| listePersonnage.get(choixPersonnage-1).getJoueur().getCite()[choixQuartier-1].getNom().equals("Donjon")); //tourne tant que le quartier n'est pas achetable
                    if(choixQuartier!=0) {
                        for(int i=0; i<this.getPlateau().getNombrePersonnages(); i++) {
                            if(this.getPlateau().getPersonnage(i).getNom().equals(listePersonnage.get(choixPersonnage-1).getNom())) {
                                nomQuartier = this.getPlateau().getPersonnage(i).getJoueur().getCite()[choixQuartier-1].getNom();
                                this.getJoueur().retirerPieces(this.getPlateau().getPersonnage(i).getJoueur().getCite()[choixQuartier-1].getCout() - 1);
                                this.getPlateau().getPersonnage(i).getJoueur().retirerQuartierDansCite(nomQuartier);
                                System.out.println(this.getPlateau().getPersonnage(i).getJoueur().getNom()+" votre quartier : " + nomQuartier + " �  �t� d�truit par le Condottiere");
                            }
                        }
                    }
                }
            }while(listePersonnage.get(choixPersonnage-1).getNom().equals("Eveque") && !listePersonnage.get(choixPersonnage-1).getAssassine() || choixQuartier==0);
        }else {
            System.out.println("Vous n'utilisez pas votre pouvoir de destruction");
        }
    }



    // Perception des ressources sp�cifiques
    public void percevoirRessourcesSpecifiques() {
        int nbQuartierMilitaire = 0;
        super.percevoirRessourcesSpecifiques();
        if (this.getJoueur().getNom() != null) {

            Quartier[] Cite = new Quartier[this.getJoueur().nbQuartiersDansCite()];

            for (int i = 0; i < Cite.length; i++) {
                for (int j = 0; j < this.getJoueur().getCite().length; j++) {
                    Cite[i] = this.getJoueur().getCite()[i];
                }
            }
            for (Quartier quartier : Cite) {
                if ("MILITAIRE".equals(quartier.getType())) {
                    nbQuartierMilitaire++;
                }
            }

            this.getJoueur().ajouterPieces(nbQuartierMilitaire);
            System.out.println("[" + nbQuartierMilitaire + "]" + "pieces en plus dans votre tr�sor");
        }
    }

}
