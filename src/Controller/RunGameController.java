package Controller;

import View.Labels.GameLabel;
import View.MainFrame;
import View.Panels.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RunGameController implements ActionListener {
    private MainFrame properMainFrame;
    private boolean gameStartedFlag = true;
    private GameLabel leftLabel;
    private GameLabel rightLabel;
    private int timerSpeed;
    private Random randomGenerator;
    public RunGameController(MainFrame properMainFrame, JLabel rightLabel, JLabel leftLabel) {
        super();
        this.properMainFrame = properMainFrame;
        this.rightLabel = (GameLabel) rightLabel;
        this.leftLabel = (GameLabel) leftLabel;
        randomGenerator = new Random();

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (gameStartedFlag) {
            Timer timer = new Timer(200, null);
            timer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    leftLabel.moveBall();
                    rightLabel.moveBall();
                    GameController.hasBallBeenMoved = true;
                    timerSpeed = randomGenerator.nextInt(4501)+500;
                    timer.setDelay(timerSpeed);

                }
            });

            timer.start();
            this.gameStartedFlag = false;
        }


    }
}