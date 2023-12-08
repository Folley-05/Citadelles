
package modele;

public class Magicienne extends Personnage {
    public Magicienne() {
        super("Magicienne", 3, Caracteristiques.MAGICIENNE);
    }
    @Override
    public void utiliserPouvoir() {
        System.out.println("Voulez-vous échanger vos cartes avec celles d'un autre joueur? (o/n)");
    }
}