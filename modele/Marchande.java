package modele;

public class Marchande extends Personnage {

	  public Marchande() {
	        super("Marchande", 6, Caracteristiques.MARCHANDE);
	    }

	    @Override
	    public void utiliserPouvoir() {
			System.out.println("\nMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM nombre de pieces avant "+this.getJoueur().nbPieces());
			if(this.isValid()) {
				this.getJoueur().ajouterPieces(1);
			}
			System.out.println("\nMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM nombre de pieces aprs "+this.getJoueur().nbPieces());
		}
	// Utilisation du pouvoir par un avatar
	public void utiliserPouvoirAvatar() {
		if(this.isValid()) {
			this.getJoueur().ajouterPieces(1);
		}
	}
	    @Override
	    public void percevoirRessourcesSpecifiques() {
			int nbQuartierCommercant=0;

			
			if(this.getJoueur()!=null) {
				for(Quartier qs: this.getJoueur().getCite()) {
				     if(qs!=null&&qs.getType().equals("COMMERCANT")) {
	 					  nbQuartierCommercant++;
	 	                     }
				}
				this.getJoueur().ajouterPieces(nbQuartierCommercant);
				System.out.println("vous avez "+nbQuartierCommercant+" "+"pieces en plus");
			}
		}
}
