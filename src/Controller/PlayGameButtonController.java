package Controller;

import View.MainFrame;
import View.Panels.GamePanel;
import View.Panels.InstructionPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayGameButtonController implements ActionListener {
    private MainFrame properMainFrame;

    public PlayGameButtonController(MainFrame properMainFrame){
        super();
        this.properMainFrame = properMainFrame;

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JPanel gamePanel = new GamePanel(this.properMainFrame);
        properMainFrame.setNewPanel(gamePanel);



    }


}
