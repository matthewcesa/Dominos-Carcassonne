package Carcassonne;

import javax.swing.JFrame;

public class Carcassonne {
    private JFrame startMenu, gameFrame;
    private Plateau board;

    public Carcassonne(){
        initGameFrame();
    }

    public void initGameFrame(){
        gameFrame = new JFrame();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(500, 500);
        
        board = new Plateau();
        gameFrame.add(board);
        
        gameFrame.setVisible(true);
    }
}
