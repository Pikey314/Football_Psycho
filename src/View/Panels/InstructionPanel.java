package View.Panels;

import View.Buttons.PlayGameButton;
import View.Buttons.ShowInstructionButton;
import View.MainFrame;

import javax.swing.*;
import java.awt.*;

import static View.MainFrame.APPLICATION_HEIGHT;
import static View.MainFrame.APPLICATION_WIDTH;
import static View.Panels.WelcomePanel.WELCOME_PANEL_HEIGHT;
import static View.Panels.WelcomePanel.WELCOME_PANEL_WIDTH;

public class InstructionPanel extends JPanel {


    private MainFrame properMainFrame;


    public InstructionPanel(MainFrame properMainFrame) {
        this.properMainFrame = properMainFrame;
        setPreferredSize(new Dimension(APPLICATION_WIDTH, APPLICATION_HEIGHT));
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Instruction.jpg"));
        JLabel picLabel = new JLabel(imageIcon);
        picLabel.setIcon(imageIcon);
        picLabel.setPreferredSize(new Dimension(WELCOME_PANEL_WIDTH,WELCOME_PANEL_HEIGHT));
        setLayout(new BorderLayout());

        JButton playGameButton = new PlayGameButton(this.properMainFrame);

        setLayout(new BorderLayout());
        add(picLabel, BorderLayout.CENTER);
        add(playGameButton, BorderLayout.SOUTH);


    }

}
