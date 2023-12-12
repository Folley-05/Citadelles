package modele;

public abstract class Personnage {
    private String nom, caracteristiques;
    private int rang;
    private Joueur joueur;
    private boolean assassine, vole;
    private PlateauDeJeu plateau;
    public static final String TYPE_PERSONNAGE[]={"Assassin", "Voleur", "Magicienne", "Roi", "Eveque", "Marchande", "Architecte", "Condotierre"};

    public Personnage(String nom,int rang,String caracteristiques) {
        this.nom=nom;
        this.rang=rang;
        this.caracteristiques=caracteristiques;
        this.joueur=null;
        this.vole=false;
        this.assassine=false;
    }

    public Joueur getJoueur() {
        return joueur;
    }
    public String getNom() {
        return nom;
    }
    public String getCaracteristiques() {
        return caracteristiques;
    }
    public int getRang() {
        return rang;
    }
    public boolean getAssassine() {
        return this.assassine;
    }
    public boolean getVole() {
        return this.vole;
    }
    public PlateauDeJeu getPlateau() {
        return plateau;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur= joueur;
    }
    public void setAssassine() {
        this.assassine = true;
    }
    public void setVole() {
        this.vole = true;
    }
    public void setPlateau(PlateauDeJeu plateau) {
        this.plateau = plateau;
    }

    public void ajouterPieces() {
        if(this.isValid()) joueur.ajouterPieces(2);
        // if(!(this.joueur==null || this.assassine)) {
        //     joueur.ajouterPieces(2);
        // }
    }


    public void ajouterQuartier(Quartier q){
        if(this.isValid()) this.joueur.ajouterQuartierDansMain(q);
    }

    public void construire(Quartier q) {
        if(this.isValid()) this.joueur.ajouterQuartierDansCite(q);
    }

    public void percevoirRessourcesSpecifiques(){
        if(this.isValid()) System.out.println("Aucune ressource specifique");
    }

    public abstract void utiliserPouvoir();

    public abstract void utiliserPouvoirAvatar();

    public void reinitialiser() {
        this.joueur=null;
        this.vole=false;
        this.assassine=false;
    }

    public boolean isValid() {
        if(!(this.joueur==null || this.assassine)) {
            return true;
        } else return false;
    }
    
}
