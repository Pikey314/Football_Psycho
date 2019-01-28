package View.Buttons;

import Controller.PlayGameButtonController;
import Controller.ShowInstructionButtonController;
import Controller.StartButtonController;
import View.MainFrame;

import javax.swing.*;
import java.awt.*;

import static View.Panels.WelcomePanel.WELCOME_PANEL_HEIGHT;
import static View.Panels.WelcomePanel.WELCOME_PANEL_WIDTH;

public class PlayGameButton extends JButton {
    private MainFrame properMainFrame;


    public PlayGameButton(MainFrame properMainFrame){
        super();
        this.properMainFrame = properMainFrame;
        setText("Start the game");

        setForeground(Color.darkGray);
        setFont(new Font("Arial", Font.BOLD, 40));
        setPreferredSize(new Dimension(WELCOME_PANEL_WIDTH,WELCOME_PANEL_HEIGHT/8));
        PlayGameButtonController sbc = new PlayGameButtonController(this.properMainFrame);
        addActionListener(sbc);


    }


}
