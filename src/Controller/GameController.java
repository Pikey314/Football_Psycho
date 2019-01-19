package Controller;

import View.Labels.GameLabel;
import View.MainFrame;
import View.Panels.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener {
    private MainFrame properMainFrame;
    private GameLabel leftLabel;
    private GameLabel rightLabel;
    public static boolean hasBallBeenMoved;
    

    public GameController(MainFrame properMainFrame, JLabel rightLabel, JLabel leftLabel){
        super();
        this.properMainFrame = properMainFrame;
        this.leftLabel = (GameLabel) leftLabel;
        this.rightLabel = (GameLabel) rightLabel;
        this.hasBallBeenMoved = true;

    }

    private boolean leftArrowPressed = false;
    private boolean rightArrowPressed = false;


    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                if(!leftArrowPressed && hasBallBeenMoved) {
                    System.out.println("left");
                    if (leftLabel.isBallThere())
                        System.out.println("GOOD LEFT");
                    else
                        System.out.println("BAD LEFT");
                    leftArrowPressed = true;
                    hasBallBeenMoved = false;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(!rightArrowPressed && hasBallBeenMoved) {
                    System.out.println("right");
                    if (rightLabel.isBallThere())
                        System.out.println("GOOD RIGHT");
                    else
                        System.out.println("BAD RIGHT");
                    rightArrowPressed = true;
                    hasBallBeenMoved = false;
                }
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                leftArrowPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
                rightArrowPressed = false;
                break;
        }

    }
}