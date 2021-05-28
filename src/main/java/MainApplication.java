import Model.ApplicationFacade;
import Model.InputAPI.InputFetcherImpl;

import java.io.IOException;

import View.ApplicationWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        ApplicationWindow appWindow = new ApplicationWindow(window);
        appWindow.initialize();

        window.setTitle("My Application");
        window.show();
    }



    public static void main(String[] args) throws IOException {
        launch(args);
    }
}
