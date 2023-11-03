package modele;

public class Marchande extends Personnage {

	  public Marchande() {
	        super("Marchande", 6, Caracteristiques.MARCHANDE);
	    }

	    @Override
	    public void utiliserPouvoir() {
			if(this.getJoueur()!=null) {
				this.getJoueur().ajouterPieces(1);
			}
		}
	    @Override
	    public void percevoirRessourcesSpecifiques() {
			int nbQuartierCommercant=0;

			
			if(this.getJoueur()!=null) {
				for(Quartier qs: this.getJoueur().getCite()) {
				     if(qs!=null&&qs.getType()=="COMMERCANT") {
	 					  nbQuartierCommercant++;
	 	                     }
				}
				this.getJoueur().ajouterPieces(nbQuartierCommercant);
				System.out.println("vous avez "+nbQuartierCommercant+" "+"pieces en plus");
			}
		}
}
