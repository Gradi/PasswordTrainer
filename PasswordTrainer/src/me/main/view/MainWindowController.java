package me.main.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;

public class MainWindowController
{
    @FXML
    private BorderPane mainPane;

    private static MainWindowController mainController;
    private static String goodPassword;

    public static MainWindowController getMainController()
    {
        return  mainController;
    }

    public static String getGoodPassword()
    {
        return goodPassword;
    }

    public void passwordTyped(String password)
    {
        goodPassword = password;
        showScene(MainWindowController.class.getResource("TrainingWindow.fxml"));
    }

    @FXML
    public void initialize()
    {
        mainController = this;
        showScene(MainWindowController.class.getResource("StartWindow.fxml"));
    }

    private void showScene(URL resource)
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(resource);
        try
        {
            AnchorPane pane = loader.load();
            mainPane.setCenter(pane);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
