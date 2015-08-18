import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import me.main.view.MainWindowController;

import java.io.IOException;

public class Main extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainWindowController.class.getResource("MainWindow.fxml"));
        AnchorPane pane = loader.load();
        Scene mainScene = new Scene(pane);
        primaryStage.setTitle("Password Trainer");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
