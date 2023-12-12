package modele;

import java.util.ArrayList;
import java.util.Random;

public class Joueur {
    private String nom;
    private int tresor, nbQuartier;
    private Quartier cite[];
    private ArrayList<Quartier> main;
    private boolean possedeCouronne;
    protected Personnage monPersonnage;
    

    public Joueur(String nom) {
        this.nom=nom;
        this.tresor=0;
        this.nbQuartier=0;
        this.possedeCouronne=false;
        this.cite=new Quartier[8];
        this.main =new ArrayList<Quartier>();
        this.monPersonnage=null;
    }

    public Personnage getPersonnage() {
		return monPersonnage;
	}

    public void setMonPersonnage(Personnage p) {
        this.monPersonnage=p;
    }
    
	public String getNom() {
        return nom;
    }
    public int nbPieces() {
        return tresor;
    }
    public Quartier[] getCite() {
        return cite;
    }
    public ArrayList<Quartier> getMain() {
        return main;
    }
    public int nbQuartiersDansMain() {
        return main.size();
    }
    public boolean getPossedeCouronne(){
        return possedeCouronne;
    }

    public void setPossedeCouronne(boolean possedeCouronne) {
        this.possedeCouronne = possedeCouronne;
    }
    public int nbQuartiersDansCite() {
        return nbQuartier;
    }
    public void ajouterPieces(int nb){
        if(nb>0) this.tresor+=nb;

    }
    public void retirerPieces(int nb){
        if(nb>0) {
            if (nb<=this.tresor) {
                this.tresor-=nb;
            }
        }
    }
    public void ajouterQuartierDansCite(Quartier q) {
        if(nbQuartier<cite.length) {
            this.cite[nbQuartier]=q;
            this.nbQuartier++;
        }
        
    }
    public boolean quartierPresentDansCite(String nom){
        boolean witness=false;
        for (int i = 0; i < cite.length; i++) {
            if(cite[i]!=null && cite[i].getNom().equals(nom)) witness=true;
        }
        return witness;
    }
    public Quartier retirerQuartierDansCite(String nom) {
        Quartier q=null;
        int index=-1;
        for (int i = 0; i < cite.length; i++) {
            if(this.cite[i]!=null && cite[i].getNom().equals(nom)) {
                q=this.cite[i];
                this.cite[i]=null;
                index=i;
                this.nbQuartier--;
            }
        }
        if(index!=-1) {
            for (int i = index; i < cite.length-1; i++) {
                this.cite[i]=this.cite[i+1];
            }
        }
        return q;
    }
    public void ajouterQuartierDansMain(Quartier q) {
        main.add(q);
    }
    public Quartier retirerLeQuartierDansMain(int i){
        return main.remove(i);
    }
    public Quartier retirerQuartierDansMain(){
        Random generateur = new Random();
        int numeroHasard = generateur.nextInt(this.nbQuartiersDansMain());
        return main.remove(numeroHasard);
    }
    public void viderMain(){
        this.main.clear();
    }
    public void reinitialiser(){
        this.tresor=0;
        this.main.clear();
        this.cite=new Quartier[8];
        this.nbQuartier=0;
    }

    public ArrayList<Quartier> retournerMain(){
        return main;
    }

    public Quartier[] retounerCite(){
        return cite;
    }

    public String peutConstruire(){
        if (tresor==0) return "Vous n'avez pas assez de piece pour construire";
        else if (main.size()==0) return "Votre main est vide vous ne pouvez pas construire";
        else {
            boolean witness=false;
            for (int i = 0; i < main.size(); i++) {
                if(tresor>=main.get(i).getCout()) witness=true;
            }
            if (witness) return "";
            else return "Votre trésor ne peut construire aucun quartier de votre main";
        }
    }
}
