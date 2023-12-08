package modele;

public class Quartier {
    public static final String TYPE_QUARTIERS[]={"RELIGIEUX", "MILITAIRE", "NOBLE", "COMMERCANT", "MERVEILLE"};

    private String nom, type, caracteristiques;
    private int coutConstruction;

    public Quartier(String nom, String type, int cout, String caracteristiques) {
        setNom(nom);
        setType(type);
        setCaracteristiques(caracteristiques);
        setCout(cout);
    }
    public Quartier(String nom, String type, int cout){
        this(nom, type, cout, "");    
    }
    public Quartier(){
        this("", "", 0, "");    
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setType(String type) {
        boolean witness=false;
        for (String item : TYPE_QUARTIERS) {
            if(item==type) witness=true;
        }
        if(witness)this.type = type;
        else this.type="";
        
    }
    public void setCout(int cout) {
        if(cout >=1 && cout <=6) this.coutConstruction = cout;
        else this.coutConstruction=0;
    }
    public void setCaracteristiques(String caracteristiques) {
        this.caracteristiques = caracteristiques;
    }
    public String getNom() {
        return nom;
    }
    public String getType() {
        return type;
    }
    public int getCout() {
        return coutConstruction;
    }
    public String getCaracteristiques() {
        return caracteristiques;
    }
}
