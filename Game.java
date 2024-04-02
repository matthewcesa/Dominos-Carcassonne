package Domino;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import Carcassonne.Carcassonne;


public class Game extends JFrame{
    private JButton dom, ca;
    Game(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        
        JPanel panneau = new JPanel();
        panneau.setLayout(null);

        JLabel option = new JLabel("Choose your game");
        option.setBounds((this.getWidth()/2) - 80, (this.getHeight()/2) - 110, 200, 100);
        
        this.add(panneau);

        dom = new JButton("Dominos");
        dom.setBounds( (this.getWidth()/2) - 120, this.getHeight()/2, 100, 50);
        ca = new JButton("Carcassonne");
        ca.setBounds( (this.getWidth()/2), this.getHeight()/2, 100, 50);
        
        panneau.add(option);
        panneau.add(dom); 
        panneau.add(ca, BorderLayout.SOUTH);

        dom.addActionListener(e -> {
            this.dispose();
            new DominoGame();
        });

        ca.addActionListener(e -> {
            this.dispose();
            new Carcassonne();
        });

        this.setVisible(true);
    }

    public static void main(String[] args) {
        Game g = new Game();
    }
}
