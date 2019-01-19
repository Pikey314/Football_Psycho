package Controller;

import View.MainFrame;
import View.Panels.InstructionPanel;
import View.Panels.LoginPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowInstructionButtonController implements ActionListener {
    private MainFrame properMainFrame;

    public ShowInstructionButtonController(MainFrame properMainFrame){
        super();
        this.properMainFrame = properMainFrame;

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JPanel instructionPanel = new InstructionPanel(this.properMainFrame);
        properMainFrame.setNewPanel(instructionPanel);



    }


}

