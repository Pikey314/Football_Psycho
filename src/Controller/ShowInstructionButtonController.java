package Controller;

import View.MainFrame;
import View.Panels.InstructionPanel;
import View.Panels.LoginPanel;
import View.Panels.WelcomePanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ShowInstructionButtonController implements ActionListener {
    private MainFrame properMainFrame;
    private JTextField personalNumber;
    private JTextField date;

    public ShowInstructionButtonController(MainFrame properMainFrame, JTextField personalNumber, JTextField date){
        super();
        this.properMainFrame = properMainFrame;
        this.personalNumber = personalNumber;
        this.date = date;

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                ".TXT files only", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            String filenname = chooser.getSelectedFile().getAbsolutePath();
            System.out.println("You chose to open this file: " + filenname);
            try {
                WelcomePanel.resultsWriter = new BufferedWriter(new FileWriter(filenname));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        JPanel instructionPanel = new InstructionPanel(this.properMainFrame);
        properMainFrame.setNewPanel(instructionPanel);
        LoginPanel.date = this.date.getText();
        LoginPanel.personalNumber = this.personalNumber.getText();




    }


}

