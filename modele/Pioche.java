package modele;

import java.util.ArrayList;
import java.util.Random;

public class Pioche {
    ArrayList <Quartier> liste;

    public Pioche(){
        this.liste=new ArrayList<Quartier>();
    }

    public Quartier piocher() {
        if(this.nombreElements()>0) return liste.remove(0);
        else return null;
    }
    public void ajouter(Quartier q) {
        liste.add(q);
    }
    public int nombreElements() {
        return liste.size();
    }
    public void melanger() {
        final int size=this.nombreElements();
        Random generateur=new Random();
        for (int i = 0; i < size-1; i++) {
            int p1=generateur.nextInt(size-1), p2=generateur.nextInt(size-1);
            Quartier q1=liste.get(p1), q2=liste.get(p2);
            liste.set(p1, q2);
            liste.set(p2, q1);
        }
    }
}
