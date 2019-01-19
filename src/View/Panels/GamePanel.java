package View.Panels;

import Controller.GameController;
import Controller.RunGameController;
import View.Buttons.PlayGameButton;
import View.Buttons.StartButton;
import View.Labels.GameLabel;
import View.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static View.MainFrame.APPLICATION_HEIGHT;
import static View.MainFrame.APPLICATION_WIDTH;

public class GamePanel extends JPanel {


    private MainFrame properMainFrame;


    public GamePanel(MainFrame properMainFrame) {
        this.properMainFrame = properMainFrame;
        setPreferredSize(new Dimension(APPLICATION_WIDTH, APPLICATION_HEIGHT));
        setLayout(new BorderLayout());

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.green);
        infoPanel.setPreferredSize(new Dimension(APPLICATION_WIDTH,APPLICATION_HEIGHT/8));

        JLabel rightLabel = new GameLabel(false);
        JLabel leftLabel = new GameLabel(true);

        JButton arrowsButton = new JButton("");
        arrowsButton.setBackground(Color.blue);

        add(rightLabel,BorderLayout.EAST);
        add(leftLabel,BorderLayout.WEST);
        add(infoPanel,BorderLayout.NORTH);
        add(arrowsButton,BorderLayout.SOUTH);


        GameController gk = new GameController(this.properMainFrame,rightLabel,leftLabel);
        RunGameController rgc = new RunGameController(this.properMainFrame, rightLabel, leftLabel);
        arrowsButton.addKeyListener(gk);
        arrowsButton.addActionListener(rgc);


    }

}