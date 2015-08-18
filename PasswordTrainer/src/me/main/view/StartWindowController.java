package me.main.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class StartWindowController {

    @FXML
    private PasswordField passField;

    @FXML
    private void CancelButtonClick(ActionEvent event)
    {
          System.exit(0);
    }

    @FXML
    private void okButtonClick(ActionEvent event)
    {
        passPassword();
    }

    @FXML
    private void passField_onKeyReleased(KeyEvent event)
    {
        if(event.getCode() == KeyCode.ENTER)
            passPassword();
    }

    private void passPassword()
    {
        MainWindowController.getMainController().passwordTyped(passField.getText());
    }

}
