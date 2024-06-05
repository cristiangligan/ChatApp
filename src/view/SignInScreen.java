package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.net.URL;
import java.util.Map;

public class SignInScreen extends JFrame {
    private static final int FRAME_WIDTH = 460;
    private static final int FRAME_HEIGHT = 220;
    private static final int PROFILE_IMG_SIZE = 100;
    private static final int DEFAULT_SPACING = 20;
    private static final int SIGN_UP_BTN_SPACE = 5;


    private final JPanel pnlMain = new JPanel();
    private final JLabel lblProfilePic = new JLabel();
    private final JTextField txtUsername = new JTextField();
    private final JTextField txtPassword = new JTextField();
    private final JButton btnSignIn = new JButton();
    private final JButton btnGoToSignUp = new JButton();
    private final JLabel lblAlreadyHaveAcc = new JLabel();
    private final Controller controller;

    public SignInScreen(Controller controller) {
        this.controller = controller;
        setTitle("ChatApp");
        SpringLayout springLayout = new SpringLayout();
        setContentPane(pnlMain);
        pnlMain.setLayout(springLayout);

        URL blankProfileImgUrl = ClassLoader.getSystemResource("images/blank-profile-picture.png");
        Image image = new ImageIcon(blankProfileImgUrl).getImage();
        Image newImage = image.getScaledInstance(PROFILE_IMG_SIZE, PROFILE_IMG_SIZE, Image.SCALE_SMOOTH);
        Icon icon = new ImageIcon(newImage);
        lblProfilePic.setIcon(icon);
        lblProfilePic.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        pnlMain.add(lblProfilePic);
        springLayout.putConstraint(SpringLayout.NORTH, lblProfilePic, DEFAULT_SPACING, SpringLayout.NORTH, pnlMain);
        springLayout.putConstraint(SpringLayout.WEST, lblProfilePic, DEFAULT_SPACING, SpringLayout.WEST, pnlMain);

        txtUsername.setBorder(BorderFactory.createTitledBorder("Username"));
        pnlMain.add(txtUsername);
        springLayout.putConstraint(SpringLayout.NORTH, txtUsername, 0, SpringLayout.NORTH, lblProfilePic);
        springLayout.putConstraint(SpringLayout.WEST, txtUsername, DEFAULT_SPACING, SpringLayout.EAST, lblProfilePic);
        springLayout.putConstraint(SpringLayout.EAST, txtUsername, -DEFAULT_SPACING, SpringLayout.EAST, pnlMain);

        txtPassword.setBorder(BorderFactory.createTitledBorder("Password"));
        pnlMain.add(txtPassword);
        springLayout.putConstraint(SpringLayout.SOUTH, txtPassword, 0, SpringLayout.SOUTH, lblProfilePic);
        springLayout.putConstraint(SpringLayout.WEST, txtPassword, 0, SpringLayout.WEST, txtUsername);
        springLayout.putConstraint(SpringLayout.EAST, txtPassword, 0, SpringLayout.EAST, txtUsername);

        btnSignIn.setText("Sign in");
        pnlMain.add(btnSignIn);
        springLayout.putConstraint(SpringLayout.NORTH, btnSignIn, DEFAULT_SPACING, SpringLayout.SOUTH, txtPassword);
        springLayout.putConstraint(SpringLayout.EAST, btnSignIn, 0, SpringLayout.EAST, txtPassword);

        lblAlreadyHaveAcc.setText("Already have an account?");
        pnlMain.add(lblAlreadyHaveAcc);
        springLayout.putConstraint(SpringLayout.NORTH, lblAlreadyHaveAcc, 0, SpringLayout.NORTH, btnSignIn);
        springLayout.putConstraint(SpringLayout.WEST, lblAlreadyHaveAcc, 0, SpringLayout.WEST, lblProfilePic);
        springLayout.putConstraint(SpringLayout.SOUTH, lblAlreadyHaveAcc, 0, SpringLayout.SOUTH, btnSignIn);

        btnGoToSignUp.setText("Sign up");
        pnlMain.add(btnGoToSignUp);
        btnGoToSignUp.setBorder(BorderFactory.createEmptyBorder());
        btnGoToSignUp.setRolloverEnabled(true);
        btnGoToSignUp.getModel().addChangeListener(e -> onHoverSignUp());
        springLayout.putConstraint(SpringLayout.NORTH, btnGoToSignUp, 0, SpringLayout.NORTH, lblAlreadyHaveAcc);
        springLayout.putConstraint(SpringLayout.WEST, btnGoToSignUp, SIGN_UP_BTN_SPACE, SpringLayout.EAST, lblAlreadyHaveAcc);
        springLayout.putConstraint(SpringLayout.SOUTH, btnGoToSignUp, 0, SpringLayout.SOUTH, lblAlreadyHaveAcc);

        this.pack();
        this.setVisible(true);
        this.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void onHoverSignUp() {
        Font btnFont = btnGoToSignUp.getFont();
        Map attributes = btnFont.getAttributes();
        if (btnGoToSignUp.getModel().isRollover()) {

            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            btnGoToSignUp.setForeground(Color.BLUE);
        } else {
            attributes.put(TextAttribute.UNDERLINE, null);
            btnGoToSignUp.setForeground(Color.BLACK);
        }
        btnFont = btnFont.deriveFont(attributes);
        btnGoToSignUp.setFont(btnFont);
    }
}
