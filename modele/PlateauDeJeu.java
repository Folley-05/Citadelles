package modele;

public class PlateauDeJeu {
    private Personnage[] listePersonnages; 
    private Joueur[] listeJoueurs;
    private Pioche pioche;
    private int nombrePersonnages, nombreJoueurs;

    public PlateauDeJeu(){
        this.listeJoueurs=new Joueur[9];
        this.listePersonnages=new Personnage[9];
        this.nombreJoueurs=0;
        this.nombrePersonnages=0;
        this.pioche=new Pioche();
    }

    public Joueur getJoueur(int i) {
        if(i>=0 && i<=listeJoueurs.length) return listeJoueurs[i];
        else return null;
    }
    public Personnage getPersonnage(int i) {
        if(i>=0 && i<=listePersonnages.length) return listePersonnages[i];
        else return null;
    }
    public int getNombreJoueurs() {
        return nombreJoueurs;
    }
    public int getNombrePersonnages() {
        return nombrePersonnages;
    }
    public Pioche getPioche() {
        return pioche;
    }
    public void setPioche(Pioche p) {
        pioche=p;
    }

    public void ajouterPersonnage(Personnage p){
        if(nombrePersonnages < listePersonnages.length && p!=null) {
            p.setPlateau(this);
            this.listePersonnages[nombrePersonnages]=p;
            this.nombrePersonnages++;
        }
    }
    public void ajouterJoueur(Joueur j){
        if(nombreJoueurs < listeJoueurs.length && j!=null) {
            this.listeJoueurs[nombreJoueurs]=j;
            this.nombreJoueurs++;
        }
    }
}
