package View.Panels;

import View.Buttons.StartButton;
import View.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static View.MainFrame.APPLICATION_HEIGHT;
import static View.MainFrame.APPLICATION_WIDTH;

public class WelcomePanel extends JPanel {
    public final static int WELCOME_PANEL_WIDTH = APPLICATION_WIDTH;
    public final static int WELCOME_PANEL_HEIGHT = APPLICATION_HEIGHT;
    public static BufferedWriter resultsWriter;

    private MainFrame properMainFrame;


    public WelcomePanel(MainFrame properMainFrame){
        this.properMainFrame = properMainFrame;
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("FootBallTestStart.jpg"));
        JLabel picLabel = new JLabel(imageIcon);
        picLabel.setIcon(imageIcon);
        picLabel.setPreferredSize(new Dimension(WELCOME_PANEL_WIDTH,WELCOME_PANEL_HEIGHT));
        setLayout(new BorderLayout());
        JButton welcomeButton = new StartButton(this.properMainFrame);

        add(picLabel, BorderLayout.CENTER);
        add(welcomeButton, BorderLayout.SOUTH);
        setBackground(Color.white);


    }
}
