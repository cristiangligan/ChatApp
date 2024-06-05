package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

public class SignInScreen extends JFrame {
    private JPanel pnlMain = new JPanel();
    private JLabel lblProfilePic = new JLabel();
    private JTextField txtUsername = new JTextField();
    private JTextField txtPassword = new JTextField();
    private JButton btnSignIn = new JButton();
    private JButton btnSignUp = new JButton();
    private JLabel lblAlreadyHaveAcc = new JLabel();
    private Controller controller;

    public SignInScreen(Controller controller) {
        this.controller = controller;
        setTitle("ChatApp");
        SpringLayout springLayout = new SpringLayout();
        setContentPane(pnlMain);
        pnlMain.setLayout(springLayout);

        Image image = new ImageIcon("src/images/blank-profile-picture.png").getImage();
        Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Icon icon = new ImageIcon(newImage);
        lblProfilePic.setIcon(icon);
        lblProfilePic.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        pnlMain.add(lblProfilePic);
        springLayout.putConstraint(SpringLayout.NORTH, lblProfilePic, 20, SpringLayout.NORTH, pnlMain);
        springLayout.putConstraint(SpringLayout.WEST, lblProfilePic, 20, SpringLayout.WEST, pnlMain);

        txtUsername.setBorder(BorderFactory.createTitledBorder("Username"));
        pnlMain.add(txtUsername);
        springLayout.putConstraint(SpringLayout.NORTH, txtUsername, 0, SpringLayout.NORTH, lblProfilePic);
        springLayout.putConstraint(SpringLayout.WEST, txtUsername, 20, SpringLayout.EAST, lblProfilePic);
        springLayout.putConstraint(SpringLayout.EAST, txtUsername, -20, SpringLayout.EAST, pnlMain);

        txtPassword.setBorder(BorderFactory.createTitledBorder("Password"));
        pnlMain.add(txtPassword);
        springLayout.putConstraint(SpringLayout.SOUTH, txtPassword, 0, SpringLayout.SOUTH, lblProfilePic);
        springLayout.putConstraint(SpringLayout.WEST, txtPassword, 0, SpringLayout.WEST, txtUsername);
        springLayout.putConstraint(SpringLayout.EAST, txtPassword, 0, SpringLayout.EAST, txtUsername);

        btnSignIn.setText("Sign in");
        pnlMain.add(btnSignIn);
        springLayout.putConstraint(SpringLayout.NORTH, btnSignIn, 20, SpringLayout.SOUTH, txtPassword);
        springLayout.putConstraint(SpringLayout.EAST, btnSignIn, 0, SpringLayout.EAST, txtPassword);

        lblAlreadyHaveAcc.setText("Already have an account?");
        pnlMain.add(lblAlreadyHaveAcc);
        springLayout.putConstraint(SpringLayout.NORTH, lblAlreadyHaveAcc, 0, SpringLayout.NORTH, btnSignIn);
        springLayout.putConstraint(SpringLayout.WEST, lblAlreadyHaveAcc, 0, SpringLayout.WEST, lblProfilePic);
        springLayout.putConstraint(SpringLayout.SOUTH, lblAlreadyHaveAcc, 0, SpringLayout.SOUTH, btnSignIn);

        btnSignUp.setText("Sign up");
        pnlMain.add(btnSignUp);
        btnSignUp.setBorder(BorderFactory.createEmptyBorder());
        btnSignUp.setRolloverEnabled(true);
        btnSignUp.getModel().addChangeListener(e -> onHoverSignUp());
        springLayout.putConstraint(SpringLayout.NORTH, btnSignUp, 0, SpringLayout.NORTH, lblAlreadyHaveAcc);
        springLayout.putConstraint(SpringLayout.WEST, btnSignUp, 5, SpringLayout.EAST, lblAlreadyHaveAcc);
        springLayout.putConstraint(SpringLayout.SOUTH, btnSignUp, 0, SpringLayout.SOUTH, lblAlreadyHaveAcc);

        this.pack();
        this.setVisible(true);
        this.setSize(new Dimension(460, 220));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void onHoverSignUp() {
        Font btnFont = btnSignUp.getFont();
        Map attributes = btnFont.getAttributes();
        if (btnSignUp.getModel().isRollover()) {

            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            btnSignUp.setForeground(Color.BLUE);
        } else {
            attributes.put(TextAttribute.UNDERLINE, null);
            btnSignUp.setForeground(Color.BLACK);
        }
        btnFont = btnFont.deriveFont(attributes);
        btnSignUp.setFont(btnFont);
    }
}
