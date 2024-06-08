package controller;

import view.SignInScreen;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class Controller {
    private SignInScreen signInScreen;
    public Controller() {
        signInScreen = new SignInScreen(this);
    }

    //****** SIGN IN - START ******
    public void handleSignIn() {

    }

    public void handleChooseProfilePic() {
        SwingUtilities.invokeLater(() -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "jpeg"));
            fileChooser.setAcceptAllFileFilterUsed(false);
            int option = fileChooser.showOpenDialog(null);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String filePath = file.getAbsolutePath();
                Image image = new ImageIcon(filePath).getImage();
                Image newImage = image.getScaledInstance(SignInScreen.PROFILE_IMG_SIZE, SignInScreen.PROFILE_IMG_SIZE, Image.SCALE_SMOOTH);
                Icon icon = new ImageIcon(newImage);
                signInScreen.updateProfilePic(icon);
            }
        });
    }
    //****** SIGN IN - END ******
    public static void main(String[] args) {
        Controller controller = new Controller();
    }
}