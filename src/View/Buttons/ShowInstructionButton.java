package View.Buttons;

import Controller.ShowInstructionButtonController;
import Controller.StartButtonController;
import View.MainFrame;

import javax.swing.*;
import java.awt.*;

import static View.Panels.WelcomePanel.WELCOME_PANEL_HEIGHT;
import static View.Panels.WelcomePanel.WELCOME_PANEL_WIDTH;

public class ShowInstructionButton extends JButton {
    private MainFrame properMainFrame;


    public ShowInstructionButton(MainFrame properMainFrame, JTextField personalNumber, JTextField date){
        super();
        this.properMainFrame = properMainFrame;
        setText("Continue");
        setBackground(Color.green);
        setFont(new Font("Arial", Font.BOLD, 40));
        setPreferredSize(new Dimension(WELCOME_PANEL_WIDTH,WELCOME_PANEL_HEIGHT/8));
        ShowInstructionButtonController sbc = new ShowInstructionButtonController(this.properMainFrame,personalNumber,date);
        addActionListener(sbc);


    }


}