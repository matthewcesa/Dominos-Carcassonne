package Domino;
import java.util.ArrayList;
import java.util.Scanner;

public class Jeu {
    private static ArrayList<Joueur> joueurs;
    private static Plateau plateau;
    private static ControllerTerm con;
    
    public static void main(String[] args) {
        con = new ControllerTerm();
        while (con.init()) {
            int turn = 0;
            plateau = new Plateau();
            nbJoueurs();
            while (plateau.getSac().getNbDominoPioche() > 0) {
                System.out.println("tourne " + turn);
                for(Joueur j : joueurs)
                {
                    plateau.affichePlateau();
                    j.setDomino(plateau.pioche());
                    if(j.getId() == 1)
                        choix(j);
                    else
                        j.choise(plateau);
                }
                turn++;
            }
        }
    }

    public static void nbJoueurs(){
            joueurs = new ArrayList<Joueur>();
            int r = con.nbJoueur();
            for(int i=0; i<r; i++){
                String pseudo = con.pesudo();
                if (pseudo.length() < 1) pseudo = "Player " + (i+1);
                joueurs.add(new Joueur(pseudo, 1));
            }
            int r2 = con.nbAI();
            for(int i=0; i<r2; i++){
                joueurs.add(new Joueur("Player " + (r+i+1), 2));
            }
    }

    public static void choix(Joueur j) {
        int choix;
        boolean bonne;
        do {
            j.afficher();
            choix = con.choix();
            switch (choix) {
                case 1:
                    con.tourne(j);
                    bonne = true;
                    break;
                case 2:
                    bonne = !(j.poser(plateau, con.getcoordone()));
                    break;
                case 3:
                    j.passer();
                    bonne = false;
                    break;
                default:
                    System.out.println("svp, choisir une option valide");
                    bonne = true;
            }
        } while (bonne);
    }

    static class ControllerTerm {
        private Scanner sc = new Scanner(System.in);

        public ControllerTerm(){}

        public boolean init(){
            System.out.print("Vous voulez jouer?(yes/no): ");
            String reponse = sc.nextLine();
            boolean run = reponse.equals("yes");
            while (!reponse.equals("yes") && !reponse.equals("no")) {
                System.out.println("desole, try again");
                System.out.print("Vous voulez jouer?(yes/no): ");
                reponse = sc.nextLine();
                run = reponse.equals("yes");
            }
            return run;
        }

        public int nbJoueur(){
            int r = 0;
            boolean is_number = true;
            do{
                System.out.println("Donner la quantité de joueur (entre 1 à 4): ");
                String input = sc.nextLine();
                is_number = true;
                try {
                    r = Integer.parseInt(input);
                } catch (Exception e) {
                    System.out.println("si vous plait, inserer un nombre valide!");
                    is_number = false;
                }
            }while(!is_number && r<1 && r>4);
            return r;
        }

        public int nbAI(){
            int r = 0;
            boolean is_number = true;
            do{
                System.out.println("Donner la quantité de IA (entre 0 à 4): ");
                String input = sc.nextLine();
                is_number = true;
                try {
                    r = Integer.parseInt(input);
                } catch (Exception e) {
                    System.out.println("si vous plait, inserer un nombre valide!");
                    is_number = false;
                }
            }while(!is_number && r<0 && r>4);
            return r;
        }

        public String pesudo() {
            System.out.println("Pseudo: ");
            return sc.nextLine();
        }

        public int choix(){
            boolean optionValide;
            int input = 0;
            do {
                optionValide = true;
                System.out.println("1.tourner\n2.poser\n3.passer tourne\nton action: ");
                try {
                    input = sc.nextInt();
                } catch (Exception e) {
                    optionValide = false;
                    System.out.println("svp, donnez un nombre");
                } 
            } while (!optionValide);

            return input;
        }

        public int[] getcoordone(){
            System.out.print("Votre coordonne est: ");
            String entree = sc.next();
            int c1 = (int) entree.toLowerCase().charAt(0) %96;
            int c2 = Integer.valueOf(entree.substring(1));
            int[] c = {c1, c2};
            return c;
        }

        public void tourne(Joueur j) {
            System.out.println("voulez-vous tourner la tuile vers la gauche ou vers la droite (choisissez " + "'d' pour la droite / 'g' pour la gauche) .");
            String input = sc.next();
            if(input.equals("r")) return;
            if (input.equals("d") || input.equals("g"))
                j.tourne(input);
        }
    }
}
