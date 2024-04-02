package Carcassonne;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Tuille extends JLabel{
    private CardContent nord, sud, est, ouest, center;
    private boolean symbol;

    public Tuille(CardContent nord, CardContent sud, CardContent est, CardContent ouest, CardContent center, int id, boolean s){
        this.nord = nord;
        this.sud = sud;
        this.est = est;
        this.ouest = ouest;
        this.center = center;
        this.symbol = s;
        defineIm(id);
    }

    public void tourne(char direction){
        CardContent n = this.nord;
        CardContent s = this.sud;
        CardContent o = this.ouest;
        CardContent e = this.est;

        // si on veut tourner a gauche
        if (direction == 'r') {
            this.nord = o;
            this.ouest = s;            
            this.sud = e;
            this.est = n;
        } else { // si on veut tourner a la droite
            this.nord = e;
            this.est = s;
            this.sud = o;
            this.ouest = n;
        }

    }

    private void defineIm(int id){
        String chemin = "Carcassonne/Images/CardIcon" + id + ".png";
        this.setIcon(new ImageIcon(chemin));
    }

    public CardContent getNord() {
        return nord;
    }

    public CardContent getSud() {
        return sud;
    }

    public CardContent getEst() {
        return est;
    }

    public CardContent getOuest() {
        return ouest;
    }

    public CardContent getCenter() {
        return center;
    }

    public boolean isSymbol() {
        return symbol;
    }    
}
