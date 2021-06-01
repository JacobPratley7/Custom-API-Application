import Model.ApplicationFacade;
import Model.InputAPI.InputFetcherDummy;
import Model.InputAPI.InputFetcherImpl;

import java.io.IOException;
import View.ApplicationWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application {

    private static ApplicationManager manager;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Stage window = primaryStage;

        ApplicationWindow appWindow = new ApplicationWindow(window, manager.getAppFacade());
        appWindow.initialize();

        window.setTitle("My Application");
        window.show();


    }

    private static void initializeManager(String inputMode, String outputMode) {
        manager = new ApplicationManager(inputMode, outputMode);
    }


    public static void main(String[] args) throws IOException {
        initializeManager(args[0], args[1]);

        launch(args);
    }
}
