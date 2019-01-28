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
    ImageIcon badHitIcon;
    ImageIcon goodHitIcon;

    private boolean ball;

    public GameLabel (boolean ball) {
        this.ball = ball;
        this.grassIcon = new ImageIcon(getClass().getClassLoader().getResource("grass.jpg"));
        this.ballIcon = new ImageIcon(getClass().getClassLoader().getResource("ball.jpg"));
        this.badHitIcon = new ImageIcon(getClass().getClassLoader().getResource("badHit.jpg"));
        this.goodHitIcon = new ImageIcon(getClass().getClassLoader().getResource("goodHit.jpg"));


        if (ball)
            setIcon(ballIcon);
        else
            setIcon(grassIcon);
        setPreferredSize(new Dimension(APPLICATION_WIDTH/2-50,APPLICATION_HEIGHT));

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

    public void setBadHitLabel(){
        setIcon(badHitIcon);
    }
    public void setGoodHitIcon(){
        setIcon(goodHitIcon);
    }

    public boolean isBallThere(){
        return this.ball;
    }
}
