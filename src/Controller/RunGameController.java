package Controller;

import View.Labels.GameLabel;
import View.MainFrame;
import View.Panels.GamePanel;
import View.Panels.InstructionPanel;
import View.Panels.LoginPanel;
import View.Panels.WelcomePanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class RunGameController implements ActionListener {
    private MainFrame properMainFrame;
    private boolean gameStartedFlag = true;
    private GameLabel leftLabel;
    private GameLabel rightLabel;
    private int timerSpeed;
    private Random randomGenerator;
    public static final float gameDuration = 120;
    public static long gameStartTime = 0;
    private boolean firstPress;
    private URL whistleSound;
    private Clip clip;
    private int soundNumber;

    public RunGameController(MainFrame properMainFrame, JLabel rightLabel, JLabel leftLabel) {
        super();
        this.properMainFrame = properMainFrame;
        this.rightLabel = (GameLabel) rightLabel;
        this.leftLabel = (GameLabel) leftLabel;
        randomGenerator = new Random();
        firstPress = true;
        whistleSound = getClass().getClassLoader().getResource("whistle.wav");
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(whistleSound));
            //clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
        GameController.attemptNumber = 0;
        try {
            WelcomePanel.resultsWriter.write("Date: " + LoginPanel.date);
            WelcomePanel.resultsWriter.newLine();
            WelcomePanel.resultsWriter.write("Personal Number: " + LoginPanel.personalNumber);
            WelcomePanel.resultsWriter.newLine();
            WelcomePanel.resultsWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GameController.totalGoodRight = 0;
        GameController.totalGoodLeft = 0;
        GameController.totalGoodWhistle = 0;
        GameController.totalBadRight = 0;
        GameController.totalBadLeft = 0;
        GameController.totalBadWhistle = 0;
        GameController.totalBadTooLate = 0;
        GameController.totalBadNoButtonPressed = 0;
        GameController.totalBAD = 0;
        GameController.totalGOOD = 0;

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (firstPress) {
            gameStartTime = System.currentTimeMillis();
            firstPress = false;
            clip.start();
        }
        if (gameStartedFlag) {
            Timer timer = new Timer(2000, null);
            timer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((System.currentTimeMillis() - gameStartTime) / 1000F < gameDuration) {
                        if (!GameController.didUserPressedTheButton) {
                            if (!GameController.didWhistlePlayed) {
                                System.out.println("No button pressed");
                                GameController.totalBadNoButtonPressed++;
                                GameController.totalBAD++;
                                try {
                                    WelcomePanel.resultsWriter.newLine();
                                    WelcomePanel.resultsWriter.write(GameController.attemptNumber + " BAD - Too Late - No Button Pressed");
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                            } else {
                                System.out.println("Whistle good");
                                GameController.totalGoodWhistle++;
                                GameController.totalGOOD++;
                                try {
                                    WelcomePanel.resultsWriter.newLine();
                                    WelcomePanel.resultsWriter.write(GameController.attemptNumber + " GOOD - Whistle - No Button Pressed");
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                            }

                        }

                        GameController.attemptNumber++;
                        GameController.didUserPressedTheButton = false;
                        GameController.didWhistlePlayed = false;

                        soundNumber = randomGenerator.nextInt(6);

                        leftLabel.moveBall();
                        rightLabel.moveBall();
                        if (soundNumber == 1) {
                            clip.stop();
                            clip.setMicrosecondPosition(0);
                            clip.start();
                            GameController.didWhistlePlayed = true;
                        }


                        GameController.hasBallBeenMoved = true;
                        GameController.ballAppearTime = System.currentTimeMillis();
                        timerSpeed = randomGenerator.nextInt(4501) + 500;
                        timer.setDelay(timerSpeed);


                    } else {
                        System.out.println("KONIEC GRY");
                        timer.stop();
                        clip.stop();
                        clip.setMicrosecondPosition(0);
                        clip.start();
                        printStats();
                        try {
                            WelcomePanel.resultsWriter.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();

                        }

                    System.exit(1);
                    }

                }
            });

            timer.start();
            this.gameStartedFlag = false;
        }


    }

    public void printStats(){
        try {
            WelcomePanel.resultsWriter.newLine();
            WelcomePanel.resultsWriter.newLine();
            WelcomePanel.resultsWriter.newLine();
            WelcomePanel.resultsWriter.write("*****  STATS  *****");
            WelcomePanel.resultsWriter.write("Total attempts: " + GameController.attemptNumber);
            WelcomePanel.resultsWriter.newLine();
            WelcomePanel.resultsWriter.newLine();

            WelcomePanel.resultsWriter.write("Total good attempts: " + GameController.totalGOOD);
            WelcomePanel.resultsWriter.newLine();
            WelcomePanel.resultsWriter.write("Total good left side attempts: " + GameController.totalGoodLeft);
            WelcomePanel.resultsWriter.newLine();
            WelcomePanel.resultsWriter.write("Total good right side attempts: " + GameController.totalGoodRight);
            WelcomePanel.resultsWriter.newLine();
            WelcomePanel.resultsWriter.write("Total good whistle attempts: " + GameController.totalGoodWhistle);
            WelcomePanel.resultsWriter.newLine();
            WelcomePanel.resultsWriter.newLine();
            WelcomePanel.resultsWriter.write("Total bad attempts: " + GameController.totalBAD);
            WelcomePanel.resultsWriter.newLine();
            WelcomePanel.resultsWriter.write("Total bad right side attempts: " + GameController.totalBadRight);
            WelcomePanel.resultsWriter.newLine();
            WelcomePanel.resultsWriter.write("Total bad left side attempts: " + GameController.totalBadLeft);
            WelcomePanel.resultsWriter.newLine();
            WelcomePanel.resultsWriter.write("Total bad whistle attempts: " + GameController.totalBadWhistle);
            WelcomePanel.resultsWriter.newLine();
            WelcomePanel.resultsWriter.write("Total bad too-late-button-pressed attempts: " + GameController.totalBadTooLate);
            WelcomePanel.resultsWriter.newLine();
            WelcomePanel.resultsWriter.write("Total bad no-button-pressed attempts: " + GameController.totalBadNoButtonPressed);
            WelcomePanel.resultsWriter.newLine();






            WelcomePanel.resultsWriter.write("Total attempts: " + GameController.attemptNumber);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}



