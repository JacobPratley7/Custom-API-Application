import Controller.ApplicationController;
import Model.ApplicationFacade;
import Model.Database.DataBaseManager;
import Model.InputAPI.InputFetcherDummy;
import Model.InputAPI.InputFetcherImpl;

import java.io.IOException;
import View.ApplicationWindow;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.xml.crypto.Data;

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


    public static void main(String[] args) throws IOException {
        initializeController(args[0], args[1]);



        launch(args);
    }
}
