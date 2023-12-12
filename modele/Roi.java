package modele;

public class Roi extends Personnage {
    
    public Roi() {
        super("Roi", 4, Caracteristiques.ROI);
    }

    @Override
    public void utiliserPouvoir() {
        if(this.isValid()) {
            System.out.println("Je prends la couronne");
            this.getJoueur().setPossedeCouronne(true);
        }
    }
    @Override
    public void percevoirRessourcesSpecifiques(){
        if(this.isValid()) {
            if(this.getJoueur().nbQuartiersDansCite()>0) {
                Quartier qs[]=this.getJoueur().getCite();
                // System.out.println("les quartier "+qs[0]);
                int nb=0;
                for (int i = 0; i < this.getJoueur().nbQuartiersDansCite(); i++) {
                    if(qs[i].getType()==Quartier.TYPE_QUARTIERS[2]) nb++;
                    // System.out.println("iteration "+i);
                }
                this.getJoueur().ajouterPieces(nb);
                System.out.println("le nombre de pieces ajoutées est "+nb);
            } else System.out.println("le nombre de pieces ajoutées est 0");
        }
    }
    public void utiliserPouvoirAvatar() {
        if(this.isValid()) {
            System.out.println("Je prends la couronne");
            this.getJoueur().setPossedeCouronne(true);
        }
    }
}
