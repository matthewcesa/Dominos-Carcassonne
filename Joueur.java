package Domino;

import java.util.LinkedList;

public class Joueur {

    private final int id;
    private int score;
    private Dominos domino;
    private final String pseudo;

    private AIController controller = null;

    public Joueur(String p, int id){
        this.id = id;
        this.domino = null;
        this.score = 0;
        this.pseudo = p;

        if(id == 2)
            this.controller = new AIController(this);
    }
    public void setDomino(Dominos domino){
        this.domino = domino;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Dominos getDomino() {
        return domino;
    }
    public String getPseudo() {
        return pseudo;
    }
    public int getId() {
        return id;
    }

    public int nbPoints(){
        return this.score;
    }

    public boolean poser(Plateau plateau, int[] coo){
        boolean safe = false;
        boolean valN = false, valS = false, valE = false, valO = false;
        if (plateau.posValide(coo[0]-1, coo[1]-1)) {
            if(plateau.verifieCoteNord(domino, coo[0]-1, coo[1]-1)){
                valN = true;
                score += domino.sum(domino.getNord());
            }
            if(plateau.verifieCoteSud(domino, coo[0]-1, coo[1]-1)){
                valS = true;
                score += domino.sum(domino.getSud());
            }
            if(plateau.verifieCoteEst(domino, coo[0]-1, coo[1]-1)){
                valE = true;
                score += domino.sum(domino.getEst());
            }
            if(plateau.verifieCoteOuest(domino, coo[0]-1, coo[1]-1)){
                valO = true;
                score += domino.sum(domino.getOuest());
            }
            if(valN || valS || valE || valO){
                plateau.gererPlateau(domino, coo[0]-1, coo[1]-1);           
                safe = true;
            }
        }
        return safe;
    }

    void choise(Plateau p){
        if(this.id == 1) return;
        controller.choise(p);
    }

    public void tourne(String s){
        domino.tourne(s);
        domino.afficheDomino();
    }

    public void passer() {
        setDomino(null);
    }

    public void afficher() {
        System.out.println(pseudo + "\nPoints: " + score + "\n");
        domino.afficheDomino();
    }

    static class AIController {
        public Joueur ai;

        public AIController(Joueur j){
            this.ai = j;
        }

        @SuppressWarnings("unchecked")
        void choise(Plateau plateau){
            LinkedList<LinkedList<Dominos>> tab = ((LinkedList<LinkedList<Dominos>>) plateau.getTab()); // creer une copie du plateau original
            int sizeV = tab.size();
            int sizeH = tab.getLast().size();
            for(int i = 0; i< sizeV; i++){
                for(int j =0; j < sizeH; j++){
                    if(!(tab.get(i).get(j) instanceof DominoNull)){
                        int[] coo = {i+1, j+1};
                        int[] stop = ai.getDomino().getNord();
                        do{
                            if(ai.poser(plateau, coo)) return;
                            ai.tourne("d");
                        }while(stop != ai.getDomino().getNord());
                    }
                }
            }

        }
        
    }
}
