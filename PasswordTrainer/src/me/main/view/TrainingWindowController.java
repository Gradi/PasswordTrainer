package me.main.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;


public class TrainingWindowController
{

    @FXML
    private Label scoreLabel;
    @FXML
    private Label correctLabel;
    @FXML
    private Label failsLabel;
    @FXML
    private Label goodPasswordLabel;
    @FXML
    private PasswordField passField;
    @FXML
    private Button showPasswordButton;

    private String goodPassword;
    private int total;
    private int correct;
    private int fails;

    @FXML
    private void initialize()
    {
        this.goodPassword = MainWindowController.getGoodPassword();
        goodPasswordLabel.setText(this.goodPassword);
    }

    @FXML
    private void passField_OnKeyReleased(KeyEvent event)
    {
        if(event.getCode() == KeyCode.ENTER)
            checkPass();
    }

    @FXML
    private void cancelButtonPressed(ActionEvent event)
    {
        System.exit(0);
    }

    @FXML
    private void checkButtonPressed(ActionEvent event)
    {
        checkPass();
    }

    @FXML
    private void showPassButtonPressed(ActionEvent event)
    {
        if(goodPasswordLabel.isVisible())
        {
            showPasswordButton.setText("Show Original Password");
            goodPasswordLabel.setVisible(false);
        }
        else
        {
            showPasswordButton.setText("Hide Original Password");
            goodPasswordLabel.setVisible(true);
        }
    }

    private void checkPass()
    {
        total++;
        String userPassword = passField.getText();
        passField.setText("");
        if(goodPassword.equals(userPassword))
        {
            correct++;
            failsLabel.setTextFill(Color.BLACK);
            correctLabel.setTextFill(Color.DARKGREEN);
        }
        else
        {
            fails++;
            correctLabel.setTextFill(Color.BLACK);
            failsLabel.setTextFill(Color.DARKRED);
        }
        String label = String.format("%d/%d/%d", total, correct, fails);
        scoreLabel.setText(label);
    }
}
