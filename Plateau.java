package Carcassonne;

import java.awt.image.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Plateau extends JPanel{
    private BufferedImage backgroundImage;

    public Plateau() {
        this.setBounds(0, 0, 260, 180);

        try {
            this.backgroundImage = ImageIO.read(new File("Carcassonne/Images/Board.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }
    
}
