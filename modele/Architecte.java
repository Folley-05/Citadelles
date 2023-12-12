package modele;

import java.util.Random;

public class Architecte extends Personnage {
	
	public Architecte() {
		super("Architecte", 7, Caracteristiques.ARCHITECTE);
	}

	@Override
	public void utiliserPouvoir() {
		// TODO Auto-generated method stub
		if(this.isValid()) {
			for(int i=1; i < 3 ; i++) {
				if(this.getPlateau().getPioche().nombreElements() != 0) {
					this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
				}
			}
		}
	}

	public void utiliserPouvoirAvatar() {
		// TODO Auto-generated method stub
		if(this.isValid()) {
			Random r = new Random();
			for(int i=1; i < 3 ; i++) {
				if(this.getPlateau().getPioche().nombreElements() != 0) {
					this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
				}
			}
		}
	}



}
