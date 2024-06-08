package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.net.URL;
import java.util.Map;

public class SignInScreen extends JFrame {
    private static final int FRAME_WIDTH = 280;
    private static final int FRAME_HEIGHT = 320;
    public static final int PROFILE_IMG_SIZE = 100;
    private static final int DEFAULT_SPACING_PROFILE = 82;
    private static final int DEFAULT_SPACING = 20;



    private final JPanel pnlMain = new JPanel();
    private final JButton btnChooseProfilePic = new JButton();
    private final JTextField txtUsername = new JTextField();
    private final JButton btnSignIn = new JButton();
    private final JButton btnGoToSignIn = new JButton();
    private Icon profilePic;
    private final Controller controller;

    public SignInScreen(Controller controller) {
        this.controller = controller;
        setTitle("ChatApp");
        SpringLayout springLayout = new SpringLayout();
        setContentPane(pnlMain);
        pnlMain.setLayout(springLayout);

        URL blankProfileImgUrl = ClassLoader.getSystemResource("images/add-profile-picture.png");
        Image image = new ImageIcon(blankProfileImgUrl).getImage();
        Image newImage = image.getScaledInstance(PROFILE_IMG_SIZE, PROFILE_IMG_SIZE, Image.SCALE_SMOOTH);
        profilePic = new ImageIcon(newImage);
        btnChooseProfilePic.setIcon(profilePic);
        btnChooseProfilePic.setBorder(BorderFactory.createTitledBorder("Click to set"));
        btnChooseProfilePic.addActionListener(e -> onChooseProfileBtnClick());
        pnlMain.add(btnChooseProfilePic);
        springLayout.putConstraint(SpringLayout.NORTH, btnChooseProfilePic, DEFAULT_SPACING, SpringLayout.NORTH, pnlMain);
        springLayout.putConstraint(SpringLayout.WEST, btnChooseProfilePic, DEFAULT_SPACING_PROFILE, SpringLayout.WEST, pnlMain);
        springLayout.putConstraint(SpringLayout.EAST, btnChooseProfilePic, -DEFAULT_SPACING_PROFILE, SpringLayout.EAST, pnlMain);


        txtUsername.setBorder(BorderFactory.createTitledBorder("Username"));
        pnlMain.add(txtUsername);
        springLayout.putConstraint(SpringLayout.NORTH, txtUsername, DEFAULT_SPACING, SpringLayout.SOUTH, btnChooseProfilePic);
        springLayout.putConstraint(SpringLayout.WEST, txtUsername, DEFAULT_SPACING, SpringLayout.WEST, pnlMain);
        springLayout.putConstraint(SpringLayout.EAST, txtUsername, -DEFAULT_SPACING, SpringLayout.EAST, pnlMain);

        btnSignIn.setText("Sign in");
        pnlMain.add(btnSignIn);
        springLayout.putConstraint(SpringLayout.NORTH, btnSignIn, DEFAULT_SPACING, SpringLayout.SOUTH, txtUsername);
        springLayout.putConstraint(SpringLayout.WEST, btnSignIn, DEFAULT_SPACING, SpringLayout.WEST, txtUsername);
        springLayout.putConstraint(SpringLayout.EAST, btnSignIn, -DEFAULT_SPACING, SpringLayout.EAST, txtUsername);
        springLayout.putConstraint(SpringLayout.SOUTH, btnSignIn, -DEFAULT_SPACING, SpringLayout.SOUTH, pnlMain);

        this.pack();
        this.setVisible(true);
        this.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void onChooseProfileBtnClick() {
        controller.handleChooseProfilePic();
    }

    private void onHoverSignUp() {
        Font btnFont = btnGoToSignIn.getFont();
        Map attributes = btnFont.getAttributes();
        if (btnGoToSignIn.getModel().isRollover()) {

            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            btnGoToSignIn.setForeground(Color.BLUE);
        } else {
            attributes.put(TextAttribute.UNDERLINE, null);
            btnGoToSignIn.setForeground(Color.BLACK);
        }
        btnFont = btnFont.deriveFont(attributes);
        btnGoToSignIn.setFont(btnFont);
    }

    public void updateProfilePic(Icon profilePic) {
        this.profilePic = profilePic;
        btnChooseProfilePic.setIcon(profilePic);
    }
}
