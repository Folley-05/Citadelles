package modele;

public class Architecte extends Personnage {
	
	public Architecte() {
		super("Architecte", 7, Caracteristiques.ARCHITECTE);
	}

	@Override
	public void utiliserPouvoir() {
		// TODO Auto-generated method stub
		if(this.getJoueur()!=null) {
			for(int i=1; i < 3 ; i++) {
				if(this.getPlateau().getPioche().nombreElements() != 0) {
					this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
				}
			}
		}
		
	}
	public void utiliserPouvoirAvatar() {
		if(this.getJoueur()!=null) {
			for(int i=1; i < 3 ; i++) {
				if(this.getPlateau().getPioche().nombreElements() != 0) {
					this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
				}
			}
		}
	}



}
