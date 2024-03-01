package org.UserRegistration.controller;

import org.UserRegistration.model.Contact;
import org.UserRegistration.view.InputView;

public class Controller {
    public void start() {
        new Contact(
                InputView.UserInput());
    }
}
