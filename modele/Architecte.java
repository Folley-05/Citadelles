package modele;

import controleur.Interaction;

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
			System.out.println("Combien de quartiers voulez vous construire ? minimun 0 - maximum 3");
			int nb = Interaction.lireUnEntier(0,4);
			for(int i=0; i<nb; i++){
				if(this.getJoueur().peutConstruire().equals("")){
					int choix = 0;
					// afficher le tresor du joueur
					System.out.println("Trésor actuel : "+this.getJoueur().nbPieces());
					// afficher les quartiers contenues dans la main
					for (int j = 0; j < this.getJoueur().nbQuartiersDansMain(); j++) {
						System.out.println((j + 1) +" "+ this.getJoueur().getMain().get(j).getNom() +" (coût "+ this.getJoueur().getMain().get(j).getCout() +")");
					}
					// choisir le quartier si le coût est gérable
					do{
						choix = Interaction.lireUnEntier(1, this.getJoueur().nbQuartiersDansMain()+1);
						if(this.getJoueur().getMain().get(choix).getCout()>this.getJoueur().nbPieces()){
							System.out.println("Vous n'avez pas suffisement de pièces pour construire ce quartier");
						}
					}while(this.getJoueur().getMain().get(choix-1).getCout()>this.getJoueur().nbPieces());
					//construire le quartier
					this.getJoueur().ConstruireQuartier(choix-1);
				} else{
					System.out.println(this.getJoueur().peutConstruire());
					break;
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
			int nb = r.nextInt(4);
			for(int i=0; i<nb; i++){
				if(this.getJoueur().peutConstruire().equals("")){
					int choix = 0;
					do{
						choix = r.nextInt( this.getJoueur().nbQuartiersDansMain());
					}while(this.getJoueur().getMain().get(choix).getCout()>this.getJoueur().nbPieces());
					//construire le quartier
					this.getJoueur().ConstruireQuartier(choix);
				} else{
					break;
				}
			}
		}
	}



}
