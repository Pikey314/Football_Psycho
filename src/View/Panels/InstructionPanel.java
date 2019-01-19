package View.Panels;

import View.Buttons.PlayGameButton;
import View.Buttons.ShowInstructionButton;
import View.MainFrame;

import javax.swing.*;
import java.awt.*;

import static View.MainFrame.APPLICATION_HEIGHT;
import static View.MainFrame.APPLICATION_WIDTH;

public class InstructionPanel extends JPanel {


    private MainFrame properMainFrame;


    public InstructionPanel(MainFrame properMainFrame) {
        this.properMainFrame = properMainFrame;
        setPreferredSize(new Dimension(APPLICATION_WIDTH, APPLICATION_HEIGHT));

        JButton playGameButton = new PlayGameButton(this.properMainFrame);

        setLayout(new GridLayout(7,1));

        add(playGameButton);


    }

}
