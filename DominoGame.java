package Domino;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import java.awt.GridBagLayout;
import javax.swing.event.ChangeListener;


public class DominoGame extends JFrame{
    private JPanel fenetrePrecedente; // garde en memoire le panel de la page precedente
    private JPanel fenetreDominoPrincipal; //garde en memoire la panel du menu domino
    private String TitreTempo; // garde en memoire le titre de la page precedente
    private String TitreMenuDomino = "Bienvenue dans le Domino!";

    private JPanel fenetre;
    private JButton settings, valider, ok;
    private JLabel nombreDeJoueurs;
    private JSpinner nbJoueurs;
    private int nbMinimumJoueur;

    
    private JPanel DominoDemarrage,plateauPrincipal, espaceJoueur;
    private JButton abandon,tournerDomino, skipAndNew;
    //skipAndNew c'est pour abandonner le domino actuel pour en avoir un nouveau

    public DominoGame(){
        initDominoGame();
    }

    public void initDominoGame(){   
        this.setTitle(TitreMenuDomino);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setResizable(true);
        this.setVisible(true);
        
        fenetre = new JPanel();
        fenetre.setLayout(null);
        
        settings = new JButton("Paramètres");
        settings.setBounds(0, 0, 100, 50);
        valider = new JButton("Valider");
        valider.setBounds((this.getWidth()/2)-50,(this.getHeight()-200),100,100);


        // final JLabel label = new JLabel();          
        // label.setHorizontalAlignment(JLabel.CENTER);  
        // label.setSize(250,100);

        ok = new JButton("OK");
        ok.setBounds(this.getWidth()-140,(this.getHeight()-450),30,30);
        fenetre.add(ok);
        nbMinimumJoueur = 2;
        SpinnerModel model = new SpinnerNumberModel(
                nbMinimumJoueur, //valeur initiale
                1, //valeur minimum
                4, //valeur maximum
                1 //pas
        );
        nbJoueurs = new JSpinner(model);
        nbJoueurs.setBounds((this.getWidth()/2)-100,(this.getHeight()-450),200,30);
        nbJoueurs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                nbMinimumJoueur = (int) nbJoueurs.getValue();
                // label.setText("Valeur : " + nbMinimumJoueur);
                ok.addActionListener(a -> {
                    creerText(nbMinimumJoueur);
                });
            }
          });
        
          fenetreDominoPrincipal = fenetre;
        settings.addActionListener(e->{
            this.paramètres(fenetreDominoPrincipal,TitreTempo);
        });
        valider.addActionListener(e -> {
            this.DémarrageDuJeu();
        });

        fenetre.add(settings);
        fenetre.add(valider);
        fenetre.add(nbJoueurs);
        // fenetre.add(label);
        this.add(fenetre);
        fenetrePrecedente = fenetre;
        TitreTempo = this.getTitle();

    }

    public void creerText(int nb){
        int x = (this.getWidth()/2)-100;
        int y = (this.getHeight()-400);
        int width = 200;
        int height = 30;
        for(int i = 1 ; i <= nb ; i++){
            JLabel lab = new JLabel("nom du Joueur " + i);
            lab.setBounds(x-110,y,width,height);
            JTextField j = new JTextField();
            j.setBounds(x,y,width,height);
            y += 60;
            fenetre.add(lab);
            fenetre.add(j);
        }
    }
    public void retourAuMenuDomino(){
        this.setContentPane(fenetre);
        this.setTitle(TitreMenuDomino);
    }
    public void close(){
        this.dispose();
        new Game();
    }
    public void pagePrecedente(String titretmp){
        this.setContentPane(fenetrePrecedente);
        this.setTitle(titretmp);
    }
    public void paramètres(JPanel fenetretmp,String titre){
        this.setTitle("Paramètres");
        JPanel param = new JPanel();
        // param.setBackground(Color.GREEN);
        this.add(param);
        JButton precedent = new JButton("Précédent");
        precedent.setBounds((this.getWidth()/3)-50,(this.getHeight()/3) , 50, 30);
        param.add(precedent);
        JButton retour = new JButton("Retour au menu Domino"); // retour sur la page précédente
        retour.setBounds((this.getWidth()/3)-50,(this.getHeight()/3)+30, 50, 30);
        param.add(retour);
        JButton close = new JButton("Quitter le jeu"); //quitte la page pr retourner au menu principam
        close.setBounds((this.getWidth()/3)-50,(this.getHeight()/3)+60 , 50, 30);
        param.add(close);

        precedent.addActionListener(e->{
            pagePrecedente(titre);
        });

        retour.addActionListener(e->{
            retourAuMenuDomino();
        });

        close.addActionListener(e->{
            close();
        });

        fenetrePrecedente = fenetretmp;
        this.setContentPane(param);
        this.revalidate();
    }
    
    public void DémarrageDuJeu(){
        this.setTitle("Bonne chance!");
        //panel qui regroupe tout
        DominoDemarrage = new JPanel();

        // là où on peut voir le jeu
        plateauPrincipal = new JPanel();
        plateauPrincipal.setBounds(0, 0, this.getWidth(), this.getHeight()-200);

        // la ou seulement nous, pouvons voir ou intéragir avec le jeu
        espaceJoueur = new JPanel();
        espaceJoueur.setBounds(0,this.getHeight()-200,this.getWidth(), this.getHeight()-plateauPrincipal.getHeight());
        // espaceJoueur.setBackground(Color.GREEN);
        DominoDemarrage.setLayout(null);
        DominoDemarrage.add(plateauPrincipal);
        DominoDemarrage.add(espaceJoueur);

        settings = new JButton("Paramètres");
        settings.setBounds(0, 0, 100, 50); 
        plateauPrincipal.add(settings);
        
        TitreTempo = "Bonne chance!";

        fenetrePrecedente = DominoDemarrage;
        settings.addActionListener(e->{
            this.paramètres(DominoDemarrage,TitreTempo);
        });

        // this.setContentPane(DominoDemarrage);
        // this.revalidate();
    

    // public void espaceJoueur(JPanel j){
        abandon = new JButton("Abandon");
        tournerDomino = new JButton("Tourner le domino");
        skipAndNew = new JButton("Passer son tour");
        espaceJoueur.add(abandon);
        espaceJoueur.add(tournerDomino);
        espaceJoueur.add(skipAndNew);
        abandon.addActionListener(e->{
            this.setTitle("Abandon");
            JPanel giveUp = new JPanel();
            JLabel text = new JLabel("Êtes-vous sûr de vouloir abandonner?");
            JButton previous = new JButton("Non");
            JButton sure = new JButton("Oui");
            text.setBounds(this.getWidth()/2-50, this.getWidth()/3 , 30, 30);
            giveUp.add(text);
            sure.setBounds(this.getWidth()/2, this.getWidth()/3,80,30);
            giveUp.add(sure);
            previous.setBounds(this.getWidth()/2, this.getWidth()/3 + 50,80,30);
            giveUp.add(previous);

            previous.addActionListener(a->{
                this.setContentPane(DominoDemarrage);
                this.setTitle(TitreTempo);
            });
            sure.addActionListener(a->{
                this.setContentPane(fenetreDominoPrincipal);
                this.setTitle(TitreMenuDomino);
            });

            this.setContentPane(giveUp);
            this.revalidate();
        });
        this.setContentPane(DominoDemarrage);
        this.revalidate();

    }

    
}
