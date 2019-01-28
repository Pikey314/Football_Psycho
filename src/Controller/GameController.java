package Controller;

import View.Labels.GameLabel;
import View.MainFrame;
import View.Panels.GamePanel;
import View.Panels.WelcomePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class GameController implements KeyListener {
    private MainFrame properMainFrame;
    private GameLabel leftLabel;
    private GameLabel rightLabel;
    public static boolean hasBallBeenMoved;
    public static long ballAppearTime;
    public static long arrowPressTime;
    public static boolean didUserPressedTheButton;
    public static boolean didWhistlePlayed;
    public static int attemptNumber;

    public static int totalGoodRight;
    public static int totalGoodLeft;
    public static int totalGoodWhistle;
    public static int totalBadRight;
    public static int totalBadLeft;
    public static int totalBadWhistle;
    public static int totalBadTooLate;
    public static int totalBadNoButtonPressed;
    public static int totalBAD;
    public static int totalGOOD;


    private long goodHitTime;
    private float goodHitTimeInSec;


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
                    didUserPressedTheButton = true;
                    System.out.println("left");
                    if (leftLabel.isBallThere() && !didWhistlePlayed) {
                        arrowPressTime = System.currentTimeMillis();
                        this.goodHitTime = arrowPressTime-ballAppearTime;
                        this.goodHitTimeInSec = this.goodHitTime/1000F;

                        if (this.goodHitTimeInSec <= 3) {
                            System.out.println(attemptNumber + " GOOD - Reaction time: " + this.goodHitTimeInSec + " (ball on the left side)");
                            this.leftLabel.setGoodHitIcon();
                            totalGoodLeft++;
                            totalGOOD++;
                            try {
                                WelcomePanel.resultsWriter.newLine();
                                WelcomePanel.resultsWriter.write(attemptNumber + " GOOD - Reaction time: " + this.goodHitTimeInSec + " (ball on the left side)");
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }

                        }
                        else {
                            System.out.println(attemptNumber + " BAD - Too slow, Reaction time: " + this.goodHitTimeInSec + " (ball on the left side)");
                            totalBadTooLate++;
                            totalBAD++;
                            try {
                                WelcomePanel.resultsWriter.newLine();
                                WelcomePanel.resultsWriter.write(attemptNumber + " BAD - Too slow, Reaction time: " + this.goodHitTimeInSec + " (ball on the left side)");
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                    else if (leftLabel.isBallThere() && didWhistlePlayed) {
                        System.out.println(attemptNumber + " BAD - Button pressed while whistle played (ball on the left side)");
                        this.leftLabel.setBadHitLabel();
                        totalBadWhistle++;
                        totalBAD++;
                        try {
                            WelcomePanel.resultsWriter.newLine();
                            WelcomePanel.resultsWriter.write(attemptNumber + " BAD - Button pressed while whistle played (ball on the left side)");
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if (!leftLabel.isBallThere() && didWhistlePlayed) {
                        System.out.println(attemptNumber + " BAD - Button pressed while whistle played AND Wrong button pressed (ball on the right side)");
                        this.rightLabel.setBadHitLabel();
                        totalBadWhistle++;
                        totalBAD++;
                        try {
                            WelcomePanel.resultsWriter.newLine();
                            WelcomePanel.resultsWriter.write(attemptNumber + " BAD - Button pressed while whistle played AND Wrong button pressed (ball on the right side)");
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                    }
                    else {
                        System.out.println(attemptNumber + " BAD - Wrong button pressed (ball on the right side)");
                        this.rightLabel.setBadHitLabel();
                        totalBadLeft++;
                        totalBAD++;
                        try {
                            WelcomePanel.resultsWriter.newLine();
                            WelcomePanel.resultsWriter.write(attemptNumber + " BAD - Wrong button pressed (ball on the right side)");
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    leftArrowPressed = true;
                    hasBallBeenMoved = false;
                }
                break;


            case KeyEvent.VK_RIGHT:
                if(!rightArrowPressed && hasBallBeenMoved) {
                    didUserPressedTheButton = true;
                    System.out.println("right");
                    if (rightLabel.isBallThere() && !didWhistlePlayed) {
                        arrowPressTime = System.currentTimeMillis();
                        this.goodHitTime = arrowPressTime-ballAppearTime;
                        this.goodHitTimeInSec = this.goodHitTime/1000F;

                        if (this.goodHitTimeInSec <= 3) {
                            System.out.println(attemptNumber + " GOOD - Reaction time: " + this.goodHitTimeInSec + " (ball on the right side)");
                            this.rightLabel.setGoodHitIcon();
                            totalGoodRight++;
                            totalGOOD++;
                            try {
                                WelcomePanel.resultsWriter.newLine();
                                WelcomePanel.resultsWriter.write(attemptNumber + " GOOD - Reaction time: " + this.goodHitTimeInSec + " (ball on the right side)");
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }

                        }
                        else {
                            System.out.println(attemptNumber + " BAD - Too slow, Reaction time: " + this.goodHitTimeInSec + " (ball on the right side)");
                            totalBadTooLate++;
                            totalBAD++;
                            try {
                                WelcomePanel.resultsWriter.newLine();
                                WelcomePanel.resultsWriter.write(attemptNumber + " BAD - Too slow, Reaction time: " + this.goodHitTimeInSec + " (ball on the right side)");
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                    else if (rightLabel.isBallThere() && didWhistlePlayed) {
                        System.out.println(attemptNumber + " BAD - Button pressed while whistle played (ball on the right side)");
                        this.rightLabel.setBadHitLabel();
                        totalBadWhistle++;
                        totalBAD++;
                        try {
                            WelcomePanel.resultsWriter.newLine();
                            WelcomePanel.resultsWriter.write(attemptNumber + " BAD - Button pressed while whistle played (ball on the right side)");
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if (!rightLabel.isBallThere() && didWhistlePlayed) {
                        System.out.println(attemptNumber + " BAD - Button pressed while whistle played AND Wrong button pressed (ball on the left side)");
                        this.leftLabel.setBadHitLabel();
                        totalBadWhistle++;
                        totalBAD++;
                        try {
                            WelcomePanel.resultsWriter.newLine();
                            WelcomePanel.resultsWriter.write(attemptNumber + " BAD - Button pressed while whistle played AND Wrong button pressed (ball on the left side)");
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else {
                        System.out.println(attemptNumber + " BAD - Wrong button pressed (ball on the left side)");
                        this.leftLabel.setBadHitLabel();
                        totalBadRight++;
                        totalBAD++;
                        try {
                            WelcomePanel.resultsWriter.newLine();
                            WelcomePanel.resultsWriter.write(attemptNumber + " BAD - Wrong button pressed (ball on the left side)");
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
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