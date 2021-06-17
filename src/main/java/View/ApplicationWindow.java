package View;

import Controller.ApplicationController;
import View.ApplicationPages.*;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;

public class ApplicationWindow {

    private Stage window;
    private ApplicationController controller;
    private HashMap<String, Scene> allScenes = new HashMap<>();
    private HashMap<String, Text> allTextBoxes = new HashMap<>();

    /**
     * Constructs new ApplicationWindow object.
     *
     * @param window The primary stage used by the application.
     * @param controller ApplicationController object used to retrieve data from Model.
     */
    public ApplicationWindow(Stage window, ApplicationController controller) {
        this.window = window;
        this.controller = controller;
    }

    /**
     * Initializes all Scene objects used by the main application.
     * Creates all buttons/inputFields/text objects, assigns them to the appropriate Scene.
     */
    public void initialize() throws IOException {
        this.allTextBoxes.put("league", new Text());
        this.allTextBoxes.put("series", new Text());
        this.allTextBoxes.put("sent", new Text());


        HomePage newHomePage = new HomePage(window, allScenes, allTextBoxes,controller);

        InputModePage newInputModePage = new InputModePage(window, allScenes, allTextBoxes,controller);

        LeaguesPage newLeaguesPage = new LeaguesPage(window, allScenes, allTextBoxes,controller);

        SeriesPage newSeriesPage = new SeriesPage(window, allScenes, allTextBoxes,controller);

        SendPage newSendPage = new SendPage(window, allScenes, allTextBoxes, controller);

        StartPage startPage = new StartPage(window, allScenes, allTextBoxes, controller);

        window.setScene(allScenes.get("start"));
        window.setTitle("My Application");
        window.show();
    }


}