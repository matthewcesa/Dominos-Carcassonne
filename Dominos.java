package Domino;
public class Dominos{
    private int [] nord, sud, ouest,est = new int [3];
    
    public Dominos(int[]nord,int [] sud, int [] ouest, int []est){
        this.nord = nord;
        this.ouest = ouest;
        this.est = est;
        this.sud = sud;
    }
    public int[] getNord() {
        return nord;
    }

    public int[] getSud() {
        return sud;
    }

    public int[] getOuest() {
        return ouest;
    }

    public int[] getEst() {
        return est;
    }   

    public void tourne(String reponse){
        int [] n = this.nord;
        int [] s = this.sud;
        int [] o = this.ouest;
        int [] e = this.est;
        if(reponse.equals("d")){
            this.nord = o;
            this.est = n;
            this.sud = e;
            this.ouest = s;
        }else {
            this.nord = e;
            this.est = s;
            this.sud = o;
            this.ouest = n;}
    }

    public void afficheDomino(){
        for(int i = 0 ;i < 3 ; i++){
            System.out.print(" "+nord[i]);
        }
        System.out.println();
        for(int i = 0 ; i < 3 ; i++){
            System.out.println(ouest[i] + "     " + est[i]);                                 
        }
        for(int i = 0 ; i < 3 ; i++){
            System.out.print(" "+sud[i]);
        }
        System.out.println();
    }
    public int sum(int[] side) {
        int s=0;
        for(int i=0; i<3; i++)
        {
            s += side[i];
        }
        return s;
    }

    public void setNord(int[] nord) {
        this.nord = nord;
    }
    public void setSud(int[] sud) {
        this.sud = sud;
    }
    public void setOuest(int[] ouest) {
        this.ouest = ouest;
    }
    public void setEst(int[] est) {
        this.est = est;
    }
}
