package controleur;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interaction {
    private static Scanner sc = new Scanner(System.in);

    public static int lireUnEntier() {
        int i = 0;
        boolean continu = true;
        do {
            try {
                i = sc.nextInt();
                continu = false;
            } catch (InputMismatchException e) {
                System.out.print("Veuillez rentrer un chiffre : ");
                sc.next(); // passe l'entier pour éviter de boucler
            }
        } while(continu);
        return i;
    }

    // renvoie un entier lu au clavier compris dans l'intervalle
    //     [borneMin, borneMax[
    public static int lireUnEntier(int borneMin, int borneMax) {
        int i = 0;
        boolean continu = true;
        do {
            try {
                i = sc.nextInt();
                if(i>=borneMin && i<borneMax)
                    continu = false;
                else
                    System.out.print("Veuillez rentrer un chiffre compris entre [ " + borneMin + " et " + borneMax + " [ :");
            } catch (InputMismatchException e) {
                System.out.print("Veuillez rentrer un chiffre compris entre [ " + borneMin + " et " + borneMax + " [ :");
                sc.next(); // passe l'entier pour éviter de boucler
            }
        } while(continu);
        return i;
    }

    // lit les réponses "oui", "non", "o" ou "n" et renvoie un bool�en
    public static boolean lireOuiOuNon() {
        boolean retour = true;
        boolean continu = true;
        do {
            String i = sc.nextLine();
            // retourne true si l'utilisateur entre oui ou o
            if (i.compareTo("oui")==0 || i.compareTo("o")==0){
                continu = false;
            }
            // retourne false si l'utilisateur entre non ou n
            else if (i.compareTo("non")==0 || i.compareTo("n")==0){
                retour = false;
                continu = false;
            }
            else
                System.out.print("Veuillez rentrer oui (o) ou non (n)  : ");
        }while(continu);
        return retour;
    }

    // renvoie une cha�ne de caractère lue au clavier:
    public static String lireUneChaine() {
        String retour = null;
        do {
            retour = sc.next();
        } while(retour==null);
        return retour;
    }

}