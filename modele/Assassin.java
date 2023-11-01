package modele;

import java.util.Scanner;

public class Assassin extends Personnage{
    public Assassin() { super("Assassin", 1, Caracteristiques.ASSASSIN); }

    public void utiliserPouvoir(){
        Scanner sc = new Scanner(System.in);
        if(this.isValid()){
            // si jamais il y'a plus de 2 personnages
            System.out.println("Quel personnage voulez-vous assassiner ?");
            for (int i = 0; i < this.getPlateau().getNombrePersonnages(); i++) {
                System.out.println((i + 1) + " " + this.getPlateau().getPersonnage(i).getNom());
            }
            int choix;
            do {
                System.out.print("Votre vhoix : ");
                choix = sc.nextInt();
            } while (choix > 0 && choix <= this.getPlateau().getNombrePersonnages()
                    && this.getPlateau().getPersonnage(choix -1).getNom().compareTo("Assassin")==0);
            this.getPlateau().getPersonnage(choix - 1).setAssassine();
        }
    }
}
