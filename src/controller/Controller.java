package controller;

import view.SignInScreen;

public class Controller {
    public static void main(String[] args) {
        Controller controller = new Controller();
        SignInScreen signInScreen = new SignInScreen(controller);
    }
}