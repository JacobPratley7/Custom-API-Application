import Controller.ApplicationController;
import java.io.IOException;
import View.ApplicationWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application {

    private static ApplicationController controller;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.controller.setAppWindow(primaryStage);


        ApplicationWindow appWindow = controller.getAppWindow();
        appWindow.initialize();
    }

    private static void initializeController(String inputMode, String outputMode) {
        controller = new ApplicationController(inputMode, outputMode);
    }


    /**
     * The main method of the application.
     *
     * @param args indicates whether the dummy or live version will be used for the input
     *             and output api.
     */
    public static void main(String[] args) {
        initializeController(args[0], args[1]);
        launch(args);
    }
}
