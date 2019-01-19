package View.Labels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static View.MainFrame.APPLICATION_HEIGHT;
import static View.MainFrame.APPLICATION_WIDTH;

public class GameLabel extends JLabel {

    ImageIcon grassIcon;
    ImageIcon ballIcon;
    private boolean ball;

    public GameLabel (boolean ball) {
        this.ball = ball;
        BufferedImage grassPicture = null;
        BufferedImage ballPicture = null;
        try {
            grassPicture = ImageIO.read(this.getClass().getResource("grass.jpg"));
            ballPicture = ImageIO.read(this.getClass().getResource("ball.jpg"));
        } catch (IOException e) {
            System.out.println("Error");
        }
        this.grassIcon = new ImageIcon(grassPicture);
        this.ballIcon = new ImageIcon(ballPicture);

        if (ball)
            setIcon(ballIcon);
        else
            setIcon(grassIcon);
        setPreferredSize(new Dimension(APPLICATION_WIDTH/2,APPLICATION_HEIGHT));

    }

    public void moveBall(){
        if (this.ball){
            setIcon(grassIcon);
            this.ball = false;
        }
        else {
            setIcon(ballIcon);
            this.ball = true;
        }

    }

    public boolean isBallThere(){
        return this.ball;
    }
}
