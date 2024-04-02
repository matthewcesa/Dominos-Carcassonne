package Domino;
import java.util.*;
public class Plateau {
    private LinkedList<LinkedList<Dominos>> tab; 
    Sac sac;
    public Plateau(){
        sac = new Sac();
        Dominos d = sac.pioche();
        gererPlateau(d, 1, 1);
    }

    public void gererPlateau(Dominos d, int x, int y){
        if(tab == null){
            tab = new LinkedList<LinkedList<Dominos>>();
            for(int i=0; i < 3; i++){
                tab.add(new LinkedList<Dominos>());
                for(int j = 0; j < 3; j ++){
                    if(i == x && j == y)
                        tab.getLast().add(d);
                    else
                        tab.getLast().add(new DominoNull());
                }
            }
        }else{
            tab.get(x).remove(y); //eleve le dominoNull
            tab.get(x).add(y, d); // ajoute ne nouveau domino
            if(x == 0){
                tab.add(0, new LinkedList<Dominos>());
                for(int i=0; i< tab.size(); i++){
                    tab.getFirst().add(new DominoNull());
                }
            }else if(x == tab.size()){
                tab.add(x, new LinkedList<Dominos>());
                for(int i=0; i< tab.size(); i++){
                    tab.getLast().add(new DominoNull());
                }
            }
            if (y == 0) {
                for(int i=0; i< tab.get(x).size(); i++){
                    tab.get(i).addFirst(new DominoNull());
                }
            } else if(y == tab.get(x).size()){
                for(int i=0; i< tab.get(x).size(); i++){
                    tab.get(i).addLast( new DominoNull());
                }
            }

        }
    }

    public void afficheTabHorizontal(int [] tab){
        System.out.print("    ");
        for(int i = 0 ; i < 3 ; i++){
            System.out.print(tab[i]+ " ");
        }
        System.out.print("   ");
    }
    public void afficheTab0Vertical(int [] tabNord,int [] tabSud){
        System.out.print("   "+tabNord[0]+"     "+tabSud[0]+"   ");
    }

    public void afficheTab1Vertical(int [] tabNord,int [] tabSud){
        System.out.print("   "+tabNord[1]+"     "+tabSud[1]+"   ");
    }

    public void afficheTab2Vertical(int [] tabNord,int [] tabSud){
        System.out.print("   "+tabNord[2]+"     "+tabSud[2]+"   ");
    }

    public void affichePlateau(){
        System.out.print("      ");
        for(int i  = 0 ; i < tab.size() ; i++){
            System.out.print((char)(i+65)+")           ");
        }
        System.out.println();
        for(int i = 0 ; i  < tab.size() ; i++){
            System.out.println(i+1 + ")");
            for(int j = 0 ; j < tab.get(i).size() ; j++){
                this.afficheTabHorizontal(tab.get(i).get(j).getNord());
            }
            System.out.println();
            for(int j = 0 ; j < tab.get(i).size() ; j++){
                this.afficheTab0Vertical(tab.get(i).get(j).getOuest(), tab.get(i).get(j).getEst());
            }
            System.out.println();
            for(int j = 0 ; j < tab.get(i).size() ; j++){
                this.afficheTab1Vertical(tab.get(i).get(j).getOuest(), tab.get(i).get(j).getEst());
            }
            System.out.println();
            for(int j = 0 ; j < tab.get(i).size() ; j++){
                this.afficheTab2Vertical(tab.get(i).get(j).getOuest(), tab.get(i).get(j).getEst());
            }
            System.out.println();
            for(int j = 0 ; j < tab.get(i).size() ; j++){
                this.afficheTabHorizontal(tab.get(i).get(j).getSud());
            }
            System.out.println();
            System.out.println();
        }
    }

    public Object getTab() {
        return this.tab;
    }

    public boolean verifieCoteNord(Dominos d, int x, int y) {
        if (x > 0) {
            if(!(tab.get(x-1).get(y) instanceof DominoNull))
                return dominoEstCompatible(d.getNord(), tab.get(x-1).get(y).getSud());
        }
        return false;
    }
    public boolean verifieCoteSud(Dominos d, int x, int y) {
        if (x < tab.size()-1) {
            if(!(tab.get(x+1).get(y) instanceof DominoNull))
                return dominoEstCompatible(d.getSud(), tab.get(x+1).get(y).getNord());
        }
        return false;
    }
    public boolean verifieCoteEst(Dominos d, int x, int y) {
        if (y > 0) {
            if(!(tab.get(x).get(y-1) instanceof DominoNull)) {
                return dominoEstCompatible(d.getOuest(), tab.get(x).get(y-1).getEst());
            }
        }
        return false;
    }
    public boolean verifieCoteOuest(Dominos d, int x, int y) {
        if (y < tab.getLast().size()-1) {
            if(!(tab.get(x).get(y+1) instanceof DominoNull)) {
               return dominoEstCompatible(d.getEst(), tab.get(x).get(y+1).getOuest());
            }
        }
        return false;
    }


    public boolean dominoEstCompatible(int [] t, int [] t1){
        for(int i = 0 ; i < 3 ; i++){
            if(t[i] != t1[i]){
                return false;
            }
        }
        return true;
    }

    public boolean posValide(int x, int y) {
        return (x >= 0 && x <= tab.size()) && (y >= 0 && y <= tab.getFirst().size());
    }

    public Dominos pioche(){
        return sac.pioche();
    }

    public Sac getSac() {
        return sac;
    }
    // ligne numero, colonne lettres
}

