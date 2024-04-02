package Domino;
import java.util.Random;
public class Sac {
    private Random random = new Random();
    private int nbDominoPioche;
    private int[][] sac = new int[10][3];

    public int getNbDominoPioche(){
        return this.nbDominoPioche;
    }

    public Sac(){
        this.nbDominoPioche = 100;
        for(int i = 0; i<sac.length; i++){
            for(int j = 0; j<3; j++){
                sac[i][j] = random.nextInt(4) + 1;
            }
        }
    }

    public Dominos pioche(){
         int[] n = sac[random.nextInt(11)];
         int[] s = sac[random.nextInt(11)];
         int[] o = sac[random.nextInt(11)];
         int[] e = sac[random.nextInt(11)];
        nbDominoPioche--;
        return new Dominos(n, s, o, e);
     }

    public boolean estVide(){
        return this.nbDominoPioche == 0;
    }
}
