package modele;

public class Eveque extends Personnage{
    public Eveque() { super("Eveque", 5, Caracteristiques.EVEQUE); }

    @Override
    public void utiliserPouvoir() {

    }
    public void percevoirRessourcesSpecifiques() {
        int nbQuartierReligieux=0;
        if (this.getJoueur() != null) {
            Quartier[] cite = new Quartier[this.getJoueur().nbQuartiersDansCite()];
            for (int i = 0; i < cite.length; i++) {
                for (int j = 0; j < this.getJoueur().getCite().length; j++) {
                    cite[i] = this.getJoueur().getCite()[i];
                }
            }
            //compter le nombre de quartiers
            for (int k = 0; k < cite.length; k++) {
                if (cite[k].getType().equals("RELIGIEUX")) {
                    nbQuartierReligieux++;
                }
            }
            this.getJoueur().ajouterPieces(nbQuartierReligieux);
        }
    }
}
