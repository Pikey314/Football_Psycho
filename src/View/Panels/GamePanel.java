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
        /*JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.green);
        infoPanel.setPreferredSize(new Dimension(APPLICATION_WIDTH,APPLICATION_HEIGHT/8));*/

        JLabel rightLabel = new GameLabel(false);
        JLabel leftLabel = new GameLabel(true);
        JLabel middleLabel = new JLabel();
        middleLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("middle.jpg")));

        JButton arrowsButton = new JButton("Game will start after clicking here");
        arrowsButton.setFont(new Font("Arial", Font.BOLD, 20));
        arrowsButton.setPreferredSize(new Dimension(APPLICATION_WIDTH, APPLICATION_HEIGHT/8));
        //arrowsButton.setBackground(Color.yellow);

        add(rightLabel,BorderLayout.EAST);
        add(leftLabel,BorderLayout.WEST);
        add(middleLabel,BorderLayout.CENTER);
        //add(infoPanel,BorderLayout.NORTH);
        add(arrowsButton,BorderLayout.SOUTH);


        GameController gk = new GameController(this.properMainFrame,rightLabel,leftLabel);
        RunGameController rgc = new RunGameController(this.properMainFrame, rightLabel, leftLabel);
        arrowsButton.addKeyListener(gk);
        arrowsButton.addActionListener(rgc);


    }

}