package View.Panels;

import View.Buttons.ShowInstructionButton;
import View.MainFrame;

import javax.swing.*;
import java.awt.*;

import static View.MainFrame.APPLICATION_HEIGHT;
import static View.MainFrame.APPLICATION_WIDTH;

public class LoginPanel extends JPanel {



    public final static int LOGIN_PANEL_WIDTH = APPLICATION_WIDTH;
    public final static int LOGIN_PANEL_HEIGHT = APPLICATION_HEIGHT;
    public static String date;
    public static String personalNumber;
    private MainFrame properMainFrame;


    public LoginPanel(MainFrame properMainFrame) {
        this.properMainFrame = properMainFrame;
        setPreferredSize(new Dimension(LOGIN_PANEL_WIDTH, LOGIN_PANEL_HEIGHT));
        JTextField personalNumber = new JTextField("input personal number here");
        JTextField date = new JTextField("input date here");
        //sprawdź czy string zawiera /// i same cyfry i czy miesiące się zgadzaja
        JLabel textLabel = new JLabel("Please provide personal data below",SwingConstants.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 30));
        personalNumber.setPreferredSize(new Dimension(LOGIN_PANEL_WIDTH/2, LOGIN_PANEL_HEIGHT/20));
        date.setPreferredSize(new Dimension(LOGIN_PANEL_WIDTH/2, LOGIN_PANEL_HEIGHT/20));
        personalNumber.setHorizontalAlignment(JTextField.CENTER);
        date.setHorizontalAlignment(JTextField.CENTER);
        personalNumber.setFont(new Font("Arial", Font.ITALIC, 20));
        date.setFont(new Font("Arial", Font.ITALIC, 20));
        JButton showInstructionButton = new ShowInstructionButton(this.properMainFrame, personalNumber, date);
        //JButton register = new RegisterUserButton(this.properMainFrame, "Sign up",false);
        setLayout(new GridLayout(7,1));
        add(textLabel);
        add(personalNumber);
        add(date);
        add(showInstructionButton);
        //add(register);*/


    }

}
